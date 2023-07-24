package org.im97mori.ble.profile.esp.central;

import static org.im97mori.ble.constants.ServiceUUID.BATTERY_SERVICE;
import static org.im97mori.ble.constants.ServiceUUID.DEVICE_INFORMATION_SERVICE;

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
import org.im97mori.ble.descriptor.u2901.CharacteristicUserDescription;
import org.im97mori.ble.descriptor.u290b.EnvironmentalSensingConfiguration;
import org.im97mori.ble.descriptor.u290d.EnvironmentalSensingTriggerSetting;
import org.im97mori.ble.profile.central.AbstractCentralProfile;
import org.im97mori.ble.profile.central.db.BondedDeviceDatabaseHelper;
import org.im97mori.ble.profile.esp.central.db.EnvironmentalSensingProfileBondedDatabaseHelper;
import org.im97mori.ble.service.bas.central.BatteryService;
import org.im97mori.ble.service.dis.central.DeviceInformationService;
import org.im97mori.ble.service.ess.central.EnvironmentalSensingService;
import org.im97mori.ble.task.DiscoverServiceTask;

import java.util.List;

/**
 * Environmental Sensing Profile for Central
 */
public class EnvironmentalSensingProfile extends AbstractCentralProfile {

    /**
     * {@link EnvironmentalSensingProfileCallback} instance
     */
    protected final EnvironmentalSensingProfileCallback mEnvironmentalSensingProfileCallback;

    /**
     * {@link EnvironmentalSensingService} instance
     */
    protected EnvironmentalSensingService mEnvironmentalSensingService;

    /**
     * {@link DeviceInformationService} instance
     */
    protected DeviceInformationService mDeviceInformationService;

    /**
     * {@link BatteryService} instance
     */
    protected BatteryService mBatteryService;

    /**
     * {@code true}:Device has Device Information Service, {@code false}:no Device information Service
     */
    private boolean mHasDeviceInformationService;

    /**
     * {@code true}:Device has Battery Service, {@code false}:no Battery Service
     */
    private boolean mHasBatteryService;

    /**
     * @param context                             {@link Context} instance
     * @param environmentalSensingProfileCallback {@link EnvironmentalSensingProfileCallback} instance
     */
    public EnvironmentalSensingProfile(@NonNull Context context, @NonNull EnvironmentalSensingProfileCallback environmentalSensingProfileCallback) {
        super(context, environmentalSensingProfileCallback);
        mEnvironmentalSensingProfileCallback = environmentalSensingProfileCallback;
    }

    /**
     * @return {@code true}:Device has Device Information Service, {@code false}:no Device information Service. if {@code null} returned, profile is not ready
     */
    @Nullable
    public synchronized Boolean hasDeviceInformationService() {
        Boolean result = null;
        if (mDeviceInformationService != null) {
            result = mHasDeviceInformationService;
        }
        return result;
    }

    /**
     * @return {@code true}:Device has Battery Service, {@code false}:no Battery Service. if {@code null} returned, profile is not ready
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
     * @see EnvironmentalSensingService#isDescriptorValueChangedCharacteristicSupported()
     */
    public synchronized Boolean isDescriptorValueChangedCharacteristicSupported() {
        Boolean result = null;
        if (mEnvironmentalSensingService != null) {
            result = mEnvironmentalSensingService.isDescriptorValueChangedCharacteristicSupported();
        }
        return result;
    }


    /**
     * @see EnvironmentalSensingService#startDescriptorValueChangedIndication()
     */
    @Nullable
    public synchronized Integer startDescriptorValueChangedIndication() {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.startDescriptorValueChangedIndication();
        }
        return taskId;
    }

    /**
     * @see EnvironmentalSensingService#stopDescriptorValueChangedIndication()
     */
    @Nullable
    public synchronized Integer stopDescriptorValueChangedIndication() {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.stopDescriptorValueChangedIndication();
        }
        return taskId;
    }

    /**
     * @see EnvironmentalSensingService#getAmmoniaConcentrationCount()
     */
    @Nullable
    public synchronized Integer getAmmoniaConcentrationCount() {
        Integer count = null;
        if (mEnvironmentalSensingService != null) {
            count = mEnvironmentalSensingService.getAmmoniaConcentrationCount();
        }
        return count;
    }

    /**
     * @see #canAmmoniaConcentrationNotify(int)
     */
    public synchronized Boolean canAmmoniaConcentrationNotify() {
        return canAmmoniaConcentrationNotify(0);
    }

    /**
     * @see EnvironmentalSensingService#canAmmoniaConcentrationNotify(int)
     */
    public synchronized Boolean canAmmoniaConcentrationNotify(int index) {
        Boolean result = null;
        if (mEnvironmentalSensingService != null) {
            result = mEnvironmentalSensingService.canAmmoniaConcentrationNotify(index);
        }
        return result;
    }

    /**
     * @see #hasAmmoniaConcentrationCharacteristicEnvironmentalSensingMeasurement(int)
     */
    public synchronized Boolean hasAmmoniaConcentrationCharacteristicEnvironmentalSensingMeasurement() {
        return hasAmmoniaConcentrationCharacteristicEnvironmentalSensingMeasurement(0);
    }

    /**
     * @see EnvironmentalSensingService#hasAmmoniaConcentrationCharacteristicEnvironmentalSensingMeasurement(int)
     */
    public synchronized Boolean hasAmmoniaConcentrationCharacteristicEnvironmentalSensingMeasurement(int index) {
        Boolean result = null;
        if (mEnvironmentalSensingService != null) {
            result = mEnvironmentalSensingService.hasAmmoniaConcentrationCharacteristicEnvironmentalSensingMeasurement(index);
        }
        return result;
    }

    /**
     * @see #getAmmoniaConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount(int)
     */
    public synchronized Integer getAmmoniaConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount() {
        return getAmmoniaConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount(0);
    }

    /**
     * @see EnvironmentalSensingService#getAmmoniaConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount(int)
     */
    @Nullable
    public synchronized Integer getAmmoniaConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount(int index) {
        Integer count = null;
        if (mEnvironmentalSensingService != null) {
            count = mEnvironmentalSensingService.getAmmoniaConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount(index);
        }
        return count;
    }

    /**
     * @see #hasAmmoniaConcentrationCharacteristicEnvironmentalSensingConfiguration(int)
     */
    public synchronized Boolean hasAmmoniaConcentrationCharacteristicEnvironmentalSensingConfiguration() {
        return hasAmmoniaConcentrationCharacteristicEnvironmentalSensingConfiguration(0);
    }

    /**
     * @see EnvironmentalSensingService#hasAmmoniaConcentrationCharacteristicEnvironmentalSensingConfiguration(int)
     */
    public synchronized Boolean hasAmmoniaConcentrationCharacteristicEnvironmentalSensingConfiguration(int index) {
        Boolean result = null;
        if (mEnvironmentalSensingService != null) {
            result = mEnvironmentalSensingService.hasAmmoniaConcentrationCharacteristicEnvironmentalSensingConfiguration(index);
        }
        return result;
    }

    /**
     * @see #hasAmmoniaConcentrationCharacteristicCharacteristicUserDescription(int)
     */
    public synchronized Boolean hasAmmoniaConcentrationCharacteristicCharacteristicUserDescription() {
        return hasAmmoniaConcentrationCharacteristicCharacteristicUserDescription(0);
    }

    /**
     * @see EnvironmentalSensingService#hasAmmoniaConcentrationCharacteristicCharacteristicUserDescription(int)
     */
    public synchronized Boolean hasAmmoniaConcentrationCharacteristicCharacteristicUserDescription(int index) {
        Boolean result = null;
        if (mEnvironmentalSensingService != null) {
            result = mEnvironmentalSensingService.hasAmmoniaConcentrationCharacteristicCharacteristicUserDescription(index);
        }
        return result;
    }

    /**
     * @see #hasAmmoniaConcentrationCharacteristicValidRange(int)
     */
    public synchronized Boolean hasAmmoniaConcentrationCharacteristicValidRange() {
        return hasAmmoniaConcentrationCharacteristicValidRange(0);
    }

    /**
     * @see EnvironmentalSensingService#hasAmmoniaConcentrationCharacteristicValidRange(int)
     */
    public synchronized Boolean hasAmmoniaConcentrationCharacteristicValidRange(int index) {
        Boolean result = null;
        if (mEnvironmentalSensingService != null) {
            result = mEnvironmentalSensingService.hasAmmoniaConcentrationCharacteristicValidRange(index);
        }
        return result;
    }

    /**
     * @see #getAmmoniaConcentration(int)
     */
    @Nullable
    public synchronized Integer getAmmoniaConcentration() {
        return getAmmoniaConcentration(0);
    }

    /**
     * @see EnvironmentalSensingService#getAmmoniaConcentration(int)
     */
    @Nullable
    public synchronized Integer getAmmoniaConcentration(int index) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.getAmmoniaConcentration(index);
        }
        return taskId;
    }

    /**
     * @see #startAmmoniaConcentrationNotification(int)
     */
    @Nullable
    public synchronized Integer startAmmoniaConcentrationNotification() {
        return startAmmoniaConcentrationNotification(0);
    }

    /**
     * @see EnvironmentalSensingService#startAmmoniaConcentrationNotification(int)
     */
    @Nullable
    public synchronized Integer startAmmoniaConcentrationNotification(int index) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.startAmmoniaConcentrationNotification(index);
        }
        return taskId;
    }

    /**
     * @see #startAmmoniaConcentrationNotification(int)
     */
    @Nullable
    public synchronized Integer stopAmmoniaConcentrationNotification() {
        return stopAmmoniaConcentrationNotification(0);
    }

    /**
     * @see EnvironmentalSensingService#stopAmmoniaConcentrationNotification(int)
     */
    @Nullable
    public synchronized Integer stopAmmoniaConcentrationNotification(int index) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.stopAmmoniaConcentrationNotification(index);
        }
        return taskId;
    }

    /**
     * @see #getAmmoniaConcentrationEnvironmentalSensingMeasurement(int)
     */
    @Nullable
    public synchronized Integer getAmmoniaConcentrationEnvironmentalSensingMeasurement() {
        return getAmmoniaConcentrationEnvironmentalSensingMeasurement(0);
    }

    /**
     * @see EnvironmentalSensingService#getAmmoniaConcentrationEnvironmentalSensingMeasurement(int)
     */
    @Nullable
    public synchronized Integer getAmmoniaConcentrationEnvironmentalSensingMeasurement(int index) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.getAmmoniaConcentrationEnvironmentalSensingMeasurement(index);
        }
        return taskId;
    }

    /**
     * @see #getAmmoniaConcentrationEnvironmentalSensingTriggerSetting(int, int)
     */
    @Nullable
    public synchronized Integer getAmmoniaConcentrationEnvironmentalSensingTriggerSetting() {
        return getAmmoniaConcentrationEnvironmentalSensingTriggerSetting(0, 0);
    }

    /**
     * @see EnvironmentalSensingService#getAmmoniaConcentrationEnvironmentalSensingTriggerSetting(int, int)
     */
    @Nullable
    public synchronized Integer getAmmoniaConcentrationEnvironmentalSensingTriggerSetting(int characteristicIndex, int descriptorIndex) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.getAmmoniaConcentrationEnvironmentalSensingTriggerSetting(characteristicIndex, descriptorIndex);
        }
        return taskId;
    }

    /**
     * @see #setAmmoniaConcentrationEnvironmentalSensingTriggerSetting(int, int, EnvironmentalSensingTriggerSetting)
     */
    @Nullable
    public synchronized Integer setAmmoniaConcentrationEnvironmentalSensingTriggerSetting(@NonNull EnvironmentalSensingTriggerSetting environmentalSensingTriggerSetting) {
        return setAmmoniaConcentrationEnvironmentalSensingTriggerSetting(0, 0, environmentalSensingTriggerSetting);
    }

    /**
     * @see EnvironmentalSensingService#setAmmoniaConcentrationEnvironmentalSensingTriggerSetting(int, int, EnvironmentalSensingTriggerSetting)
     */
    @Nullable
    public synchronized Integer setAmmoniaConcentrationEnvironmentalSensingTriggerSetting(int characteristicIndex, int descriptorIndex, @NonNull EnvironmentalSensingTriggerSetting environmentalSensingTriggerSetting) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.setAmmoniaConcentrationEnvironmentalSensingTriggerSetting(characteristicIndex, descriptorIndex, environmentalSensingTriggerSetting);
        }
        return taskId;
    }

    /**
     * @see #getAmmoniaConcentrationEnvironmentalSensingConfiguration(int)
     */
    @Nullable
    public synchronized Integer getAmmoniaConcentrationEnvironmentalSensingConfiguration() {
        return getAmmoniaConcentrationEnvironmentalSensingConfiguration(0);
    }

    /**
     * @see EnvironmentalSensingService#getAmmoniaConcentrationEnvironmentalSensingConfiguration(int)
     */
    @Nullable
    public synchronized Integer getAmmoniaConcentrationEnvironmentalSensingConfiguration(int index) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.getAmmoniaConcentrationEnvironmentalSensingConfiguration(index);
        }
        return taskId;
    }

    /**
     * @see #setAmmoniaConcentrationEnvironmentalSensingConfiguration(int, EnvironmentalSensingConfiguration)
     */
    @Nullable
    public synchronized Integer setAmmoniaConcentrationEnvironmentalSensingConfiguration(@NonNull EnvironmentalSensingConfiguration environmentalSensingConfiguration) {
        return setAmmoniaConcentrationEnvironmentalSensingConfiguration(0, environmentalSensingConfiguration);
    }

    /**
     * @see EnvironmentalSensingService#setAmmoniaConcentrationEnvironmentalSensingConfiguration(int, EnvironmentalSensingConfiguration)
     */
    @Nullable
    public synchronized Integer setAmmoniaConcentrationEnvironmentalSensingConfiguration(int index, @NonNull EnvironmentalSensingConfiguration environmentalSensingConfiguration) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.setAmmoniaConcentrationEnvironmentalSensingConfiguration(index, environmentalSensingConfiguration);
        }
        return taskId;
    }

    /**
     * @see #getAmmoniaConcentrationCharacteristicUserDescription(int)
     */
    @Nullable
    public synchronized Integer getAmmoniaConcentrationCharacteristicUserDescription() {
        return getAmmoniaConcentrationCharacteristicUserDescription(0);
    }

    /**
     * @see EnvironmentalSensingService#getAmmoniaConcentrationCharacteristicUserDescription(int)
     */
    @Nullable
    public synchronized Integer getAmmoniaConcentrationCharacteristicUserDescription(int index) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.getAmmoniaConcentrationCharacteristicUserDescription(index);
        }
        return taskId;
    }

    /**
     * @see #setAmmoniaConcentrationCharacteristicUserDescription(int, CharacteristicUserDescription)
     */
    @Nullable
    public synchronized Integer setAmmoniaConcentrationCharacteristicUserDescription(@NonNull CharacteristicUserDescription characteristicUserDescription) {
        return setAmmoniaConcentrationCharacteristicUserDescription(0, characteristicUserDescription);
    }

    /**
     * @see EnvironmentalSensingService#setAmmoniaConcentrationCharacteristicUserDescription(int, CharacteristicUserDescription)
     */
    @Nullable
    public synchronized Integer setAmmoniaConcentrationCharacteristicUserDescription(int index, @NonNull CharacteristicUserDescription characteristicUserDescription) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.setAmmoniaConcentrationCharacteristicUserDescription(index, characteristicUserDescription);
        }
        return taskId;
    }

    /**
     * @see #getAmmoniaConcentrationValidRange(int)
     */
    @Nullable
    public synchronized Integer getAmmoniaConcentrationValidRange() {
        return getAmmoniaConcentrationValidRange(0);
    }

    /**
     * @see EnvironmentalSensingService#getAmmoniaConcentrationValidRange(int)
     */
    @Nullable
    public synchronized Integer getAmmoniaConcentrationValidRange(int index) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.getAmmoniaConcentrationValidRange(index);
        }
        return taskId;
    }

    /**
     * @see EnvironmentalSensingService#getApparentWindDirectionCount()
     */
    @Nullable
    public synchronized Integer getApparentWindDirectionCount() {
        Integer count = null;
        if (mEnvironmentalSensingService != null) {
            count = mEnvironmentalSensingService.getApparentWindDirectionCount();
        }
        return count;
    }

    /**
     * @see #canApparentWindDirectionNotify(int)
     */
    public synchronized Boolean canApparentWindDirectionNotify() {
        return canApparentWindDirectionNotify(0);
    }

    /**
     * @see EnvironmentalSensingService#canApparentWindDirectionNotify(int)
     */
    public synchronized Boolean canApparentWindDirectionNotify(int index) {
        Boolean result = null;
        if (mEnvironmentalSensingService != null) {
            result = mEnvironmentalSensingService.canApparentWindDirectionNotify(index);
        }
        return result;
    }

    /**
     * @see #hasApparentWindDirectionCharacteristicEnvironmentalSensingMeasurement(int)
     */
    public synchronized Boolean hasApparentWindDirectionCharacteristicEnvironmentalSensingMeasurement() {
        return hasApparentWindDirectionCharacteristicEnvironmentalSensingMeasurement(0);
    }

    /**
     * @see EnvironmentalSensingService#hasApparentWindDirectionCharacteristicEnvironmentalSensingMeasurement(int)
     */
    public synchronized Boolean hasApparentWindDirectionCharacteristicEnvironmentalSensingMeasurement(int index) {
        Boolean result = null;
        if (mEnvironmentalSensingService != null) {
            result = mEnvironmentalSensingService.hasApparentWindDirectionCharacteristicEnvironmentalSensingMeasurement(index);
        }
        return result;
    }

    /**
     * @see #getApparentWindDirectionCharacteristicEnvironmentalSensingTriggerSettingCount(int)
     */
    public synchronized Integer getApparentWindDirectionCharacteristicEnvironmentalSensingTriggerSettingCount() {
        return getApparentWindDirectionCharacteristicEnvironmentalSensingTriggerSettingCount(0);
    }

    /**
     * @see EnvironmentalSensingService#getApparentWindDirectionCharacteristicEnvironmentalSensingTriggerSettingCount(int)
     */
    @Nullable
    public synchronized Integer getApparentWindDirectionCharacteristicEnvironmentalSensingTriggerSettingCount(int index) {
        Integer count = null;
        if (mEnvironmentalSensingService != null) {
            count = mEnvironmentalSensingService.getApparentWindDirectionCharacteristicEnvironmentalSensingTriggerSettingCount(index);
        }
        return count;
    }

    /**
     * @see #hasApparentWindDirectionCharacteristicEnvironmentalSensingConfiguration(int)
     */
    public synchronized Boolean hasApparentWindDirectionCharacteristicEnvironmentalSensingConfiguration() {
        return hasApparentWindDirectionCharacteristicEnvironmentalSensingConfiguration(0);
    }

    /**
     * @see EnvironmentalSensingService#hasApparentWindDirectionCharacteristicEnvironmentalSensingConfiguration(int)
     */
    public synchronized Boolean hasApparentWindDirectionCharacteristicEnvironmentalSensingConfiguration(int index) {
        Boolean result = null;
        if (mEnvironmentalSensingService != null) {
            result = mEnvironmentalSensingService.hasApparentWindDirectionCharacteristicEnvironmentalSensingConfiguration(index);
        }
        return result;
    }

    /**
     * @see #hasApparentWindDirectionCharacteristicCharacteristicUserDescription(int)
     */
    public synchronized Boolean hasApparentWindDirectionCharacteristicCharacteristicUserDescription() {
        return hasApparentWindDirectionCharacteristicCharacteristicUserDescription(0);
    }

    /**
     * @see EnvironmentalSensingService#hasApparentWindDirectionCharacteristicCharacteristicUserDescription(int)
     */
    public synchronized Boolean hasApparentWindDirectionCharacteristicCharacteristicUserDescription(int index) {
        Boolean result = null;
        if (mEnvironmentalSensingService != null) {
            result = mEnvironmentalSensingService.hasApparentWindDirectionCharacteristicCharacteristicUserDescription(index);
        }
        return result;
    }

    /**
     * @see #hasApparentWindDirectionCharacteristicValidRange(int)
     */
    public synchronized Boolean hasApparentWindDirectionCharacteristicValidRange() {
        return hasApparentWindDirectionCharacteristicValidRange(0);
    }

    /**
     * @see EnvironmentalSensingService#hasApparentWindDirectionCharacteristicValidRange(int)
     */
    public synchronized Boolean hasApparentWindDirectionCharacteristicValidRange(int index) {
        Boolean result = null;
        if (mEnvironmentalSensingService != null) {
            result = mEnvironmentalSensingService.hasApparentWindDirectionCharacteristicValidRange(index);
        }
        return result;
    }

    /**
     * @see #getApparentWindDirection(int)
     */
    @Nullable
    public synchronized Integer getApparentWindDirection() {
        return getApparentWindDirection(0);
    }

    /**
     * @see EnvironmentalSensingService#getApparentWindDirection(int)
     */
    @Nullable
    public synchronized Integer getApparentWindDirection(int index) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.getApparentWindDirection(index);
        }
        return taskId;
    }

    /**
     * @see #startApparentWindDirectionNotification(int)
     */
    @Nullable
    public synchronized Integer startApparentWindDirectionNotification() {
        return startApparentWindDirectionNotification(0);
    }

    /**
     * @see EnvironmentalSensingService#startApparentWindDirectionNotification(int)
     */
    @Nullable
    public synchronized Integer startApparentWindDirectionNotification(int index) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.startApparentWindDirectionNotification(index);
        }
        return taskId;
    }

    /**
     * @see #startApparentWindDirectionNotification(int)
     */
    @Nullable
    public synchronized Integer stopApparentWindDirectionNotification() {
        return stopApparentWindDirectionNotification(0);
    }

    /**
     * @see EnvironmentalSensingService#stopApparentWindDirectionNotification(int)
     */
    @Nullable
    public synchronized Integer stopApparentWindDirectionNotification(int index) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.stopApparentWindDirectionNotification(index);
        }
        return taskId;
    }

    /**
     * @see #getApparentWindDirectionEnvironmentalSensingMeasurement(int)
     */
    @Nullable
    public synchronized Integer getApparentWindDirectionEnvironmentalSensingMeasurement() {
        return getApparentWindDirectionEnvironmentalSensingMeasurement(0);
    }

    /**
     * @see EnvironmentalSensingService#getApparentWindDirectionEnvironmentalSensingMeasurement(int)
     */
    @Nullable
    public synchronized Integer getApparentWindDirectionEnvironmentalSensingMeasurement(int index) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.getApparentWindDirectionEnvironmentalSensingMeasurement(index);
        }
        return taskId;
    }

    /**
     * @see #getApparentWindDirectionEnvironmentalSensingTriggerSetting(int, int)
     */
    @Nullable
    public synchronized Integer getApparentWindDirectionEnvironmentalSensingTriggerSetting() {
        return getApparentWindDirectionEnvironmentalSensingTriggerSetting(0, 0);
    }

    /**
     * @see EnvironmentalSensingService#getApparentWindDirectionEnvironmentalSensingTriggerSetting(int, int)
     */
    @Nullable
    public synchronized Integer getApparentWindDirectionEnvironmentalSensingTriggerSetting(int characteristicIndex, int descriptorIndex) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.getApparentWindDirectionEnvironmentalSensingTriggerSetting(characteristicIndex, descriptorIndex);
        }
        return taskId;
    }

    /**
     * @see #setApparentWindDirectionEnvironmentalSensingTriggerSetting(int, int, EnvironmentalSensingTriggerSetting)
     */
    @Nullable
    public synchronized Integer setApparentWindDirectionEnvironmentalSensingTriggerSetting(@NonNull EnvironmentalSensingTriggerSetting environmentalSensingTriggerSetting) {
        return setApparentWindDirectionEnvironmentalSensingTriggerSetting(0, 0, environmentalSensingTriggerSetting);
    }

    /**
     * @see EnvironmentalSensingService#setApparentWindDirectionEnvironmentalSensingTriggerSetting(int, int, EnvironmentalSensingTriggerSetting)
     */
    @Nullable
    public synchronized Integer setApparentWindDirectionEnvironmentalSensingTriggerSetting(int characteristicIndex, int descriptorIndex, @NonNull EnvironmentalSensingTriggerSetting environmentalSensingTriggerSetting) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.setApparentWindDirectionEnvironmentalSensingTriggerSetting(characteristicIndex, descriptorIndex, environmentalSensingTriggerSetting);
        }
        return taskId;
    }

    /**
     * @see #getApparentWindDirectionEnvironmentalSensingConfiguration(int)
     */
    @Nullable
    public synchronized Integer getApparentWindDirectionEnvironmentalSensingConfiguration() {
        return getApparentWindDirectionEnvironmentalSensingConfiguration(0);
    }

    /**
     * @see EnvironmentalSensingService#getApparentWindDirectionEnvironmentalSensingConfiguration(int)
     */
    @Nullable
    public synchronized Integer getApparentWindDirectionEnvironmentalSensingConfiguration(int index) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.getApparentWindDirectionEnvironmentalSensingConfiguration(index);
        }
        return taskId;
    }

    /**
     * @see #setApparentWindDirectionEnvironmentalSensingConfiguration(int, EnvironmentalSensingConfiguration)
     */
    @Nullable
    public synchronized Integer setApparentWindDirectionEnvironmentalSensingConfiguration(@NonNull EnvironmentalSensingConfiguration environmentalSensingConfiguration) {
        return setApparentWindDirectionEnvironmentalSensingConfiguration(0, environmentalSensingConfiguration);
    }

    /**
     * @see EnvironmentalSensingService#setApparentWindDirectionEnvironmentalSensingConfiguration(int, EnvironmentalSensingConfiguration)
     */
    @Nullable
    public synchronized Integer setApparentWindDirectionEnvironmentalSensingConfiguration(int index, @NonNull EnvironmentalSensingConfiguration environmentalSensingConfiguration) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.setApparentWindDirectionEnvironmentalSensingConfiguration(index, environmentalSensingConfiguration);
        }
        return taskId;
    }

    /**
     * @see #getApparentWindDirectionCharacteristicUserDescription(int)
     */
    @Nullable
    public synchronized Integer getApparentWindDirectionCharacteristicUserDescription() {
        return getApparentWindDirectionCharacteristicUserDescription(0);
    }

    /**
     * @see EnvironmentalSensingService#getApparentWindDirectionCharacteristicUserDescription(int)
     */
    @Nullable
    public synchronized Integer getApparentWindDirectionCharacteristicUserDescription(int index) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.getApparentWindDirectionCharacteristicUserDescription(index);
        }
        return taskId;
    }

    /**
     * @see #setApparentWindDirectionCharacteristicUserDescription(int, CharacteristicUserDescription)
     */
    @Nullable
    public synchronized Integer setApparentWindDirectionCharacteristicUserDescription(@NonNull CharacteristicUserDescription characteristicUserDescription) {
        return setApparentWindDirectionCharacteristicUserDescription(0, characteristicUserDescription);
    }

    /**
     * @see EnvironmentalSensingService#setApparentWindDirectionCharacteristicUserDescription(int, CharacteristicUserDescription)
     */
    @Nullable
    public synchronized Integer setApparentWindDirectionCharacteristicUserDescription(int index, @NonNull CharacteristicUserDescription characteristicUserDescription) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.setApparentWindDirectionCharacteristicUserDescription(index, characteristicUserDescription);
        }
        return taskId;
    }

    /**
     * @see #getApparentWindDirectionValidRange(int)
     */
    @Nullable
    public synchronized Integer getApparentWindDirectionValidRange() {
        return getApparentWindDirectionValidRange(0);
    }

    /**
     * @see EnvironmentalSensingService#getApparentWindDirectionValidRange(int)
     */
    @Nullable
    public synchronized Integer getApparentWindDirectionValidRange(int index) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.getApparentWindDirectionValidRange(index);
        }
        return taskId;
    }

    /**
     * @see EnvironmentalSensingService#getApparentWindSpeedCount()
     */
    @Nullable
    public synchronized Integer getApparentWindSpeedCount() {
        Integer count = null;
        if (mEnvironmentalSensingService != null) {
            count = mEnvironmentalSensingService.getApparentWindSpeedCount();
        }
        return count;
    }

    /**
     * @see #canApparentWindSpeedNotify(int)
     */
    public synchronized Boolean canApparentWindSpeedNotify() {
        return canApparentWindSpeedNotify(0);
    }

    /**
     * @see EnvironmentalSensingService#canApparentWindSpeedNotify(int)
     */
    public synchronized Boolean canApparentWindSpeedNotify(int index) {
        Boolean result = null;
        if (mEnvironmentalSensingService != null) {
            result = mEnvironmentalSensingService.canApparentWindSpeedNotify(index);
        }
        return result;
    }

    /**
     * @see #hasApparentWindSpeedCharacteristicEnvironmentalSensingMeasurement(int)
     */
    public synchronized Boolean hasApparentWindSpeedCharacteristicEnvironmentalSensingMeasurement() {
        return hasApparentWindSpeedCharacteristicEnvironmentalSensingMeasurement(0);
    }

    /**
     * @see EnvironmentalSensingService#hasApparentWindSpeedCharacteristicEnvironmentalSensingMeasurement(int)
     */
    public synchronized Boolean hasApparentWindSpeedCharacteristicEnvironmentalSensingMeasurement(int index) {
        Boolean result = null;
        if (mEnvironmentalSensingService != null) {
            result = mEnvironmentalSensingService.hasApparentWindSpeedCharacteristicEnvironmentalSensingMeasurement(index);
        }
        return result;
    }

    /**
     * @see #getApparentWindSpeedCharacteristicEnvironmentalSensingTriggerSettingCount(int)
     */
    public synchronized Integer getApparentWindSpeedCharacteristicEnvironmentalSensingTriggerSettingCount() {
        return getApparentWindSpeedCharacteristicEnvironmentalSensingTriggerSettingCount(0);
    }

    /**
     * @see EnvironmentalSensingService#getApparentWindSpeedCharacteristicEnvironmentalSensingTriggerSettingCount(int)
     */
    @Nullable
    public synchronized Integer getApparentWindSpeedCharacteristicEnvironmentalSensingTriggerSettingCount(int index) {
        Integer count = null;
        if (mEnvironmentalSensingService != null) {
            count = mEnvironmentalSensingService.getApparentWindSpeedCharacteristicEnvironmentalSensingTriggerSettingCount(index);
        }
        return count;
    }

    /**
     * @see #hasApparentWindSpeedCharacteristicEnvironmentalSensingConfiguration(int)
     */
    public synchronized Boolean hasApparentWindSpeedCharacteristicEnvironmentalSensingConfiguration() {
        return hasApparentWindSpeedCharacteristicEnvironmentalSensingConfiguration(0);
    }

    /**
     * @see EnvironmentalSensingService#hasApparentWindSpeedCharacteristicEnvironmentalSensingConfiguration(int)
     */
    public synchronized Boolean hasApparentWindSpeedCharacteristicEnvironmentalSensingConfiguration(int index) {
        Boolean result = null;
        if (mEnvironmentalSensingService != null) {
            result = mEnvironmentalSensingService.hasApparentWindSpeedCharacteristicEnvironmentalSensingConfiguration(index);
        }
        return result;
    }

    /**
     * @see #hasApparentWindSpeedCharacteristicCharacteristicUserDescription(int)
     */
    public synchronized Boolean hasApparentWindSpeedCharacteristicCharacteristicUserDescription() {
        return hasApparentWindSpeedCharacteristicCharacteristicUserDescription(0);
    }

    /**
     * @see EnvironmentalSensingService#hasApparentWindSpeedCharacteristicCharacteristicUserDescription(int)
     */
    public synchronized Boolean hasApparentWindSpeedCharacteristicCharacteristicUserDescription(int index) {
        Boolean result = null;
        if (mEnvironmentalSensingService != null) {
            result = mEnvironmentalSensingService.hasApparentWindSpeedCharacteristicCharacteristicUserDescription(index);
        }
        return result;
    }

    /**
     * @see #hasApparentWindSpeedCharacteristicValidRange(int)
     */
    public synchronized Boolean hasApparentWindSpeedCharacteristicValidRange() {
        return hasApparentWindSpeedCharacteristicValidRange(0);
    }

    /**
     * @see EnvironmentalSensingService#hasApparentWindSpeedCharacteristicValidRange(int)
     */
    public synchronized Boolean hasApparentWindSpeedCharacteristicValidRange(int index) {
        Boolean result = null;
        if (mEnvironmentalSensingService != null) {
            result = mEnvironmentalSensingService.hasApparentWindSpeedCharacteristicValidRange(index);
        }
        return result;
    }

    /**
     * @see #getApparentWindSpeed(int)
     */
    @Nullable
    public synchronized Integer getApparentWindSpeed() {
        return getApparentWindSpeed(0);
    }

    /**
     * @see EnvironmentalSensingService#getApparentWindSpeed(int)
     */
    @Nullable
    public synchronized Integer getApparentWindSpeed(int index) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.getApparentWindSpeed(index);
        }
        return taskId;
    }

    /**
     * @see #startApparentWindSpeedNotification(int)
     */
    @Nullable
    public synchronized Integer startApparentWindSpeedNotification() {
        return startApparentWindSpeedNotification(0);
    }

    /**
     * @see EnvironmentalSensingService#startApparentWindSpeedNotification(int)
     */
    @Nullable
    public synchronized Integer startApparentWindSpeedNotification(int index) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.startApparentWindSpeedNotification(index);
        }
        return taskId;
    }

    /**
     * @see #startApparentWindSpeedNotification(int)
     */
    @Nullable
    public synchronized Integer stopApparentWindSpeedNotification() {
        return stopApparentWindSpeedNotification(0);
    }

    /**
     * @see EnvironmentalSensingService#stopApparentWindSpeedNotification(int)
     */
    @Nullable
    public synchronized Integer stopApparentWindSpeedNotification(int index) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.stopApparentWindSpeedNotification(index);
        }
        return taskId;
    }

    /**
     * @see #getApparentWindSpeedEnvironmentalSensingMeasurement(int)
     */
    @Nullable
    public synchronized Integer getApparentWindSpeedEnvironmentalSensingMeasurement() {
        return getApparentWindSpeedEnvironmentalSensingMeasurement(0);
    }

    /**
     * @see EnvironmentalSensingService#getApparentWindSpeedEnvironmentalSensingMeasurement(int)
     */
    @Nullable
    public synchronized Integer getApparentWindSpeedEnvironmentalSensingMeasurement(int index) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.getApparentWindSpeedEnvironmentalSensingMeasurement(index);
        }
        return taskId;
    }

    /**
     * @see #getApparentWindSpeedEnvironmentalSensingTriggerSetting(int, int)
     */
    @Nullable
    public synchronized Integer getApparentWindSpeedEnvironmentalSensingTriggerSetting() {
        return getApparentWindSpeedEnvironmentalSensingTriggerSetting(0, 0);
    }

    /**
     * @see EnvironmentalSensingService#getApparentWindSpeedEnvironmentalSensingTriggerSetting(int, int)
     */
    @Nullable
    public synchronized Integer getApparentWindSpeedEnvironmentalSensingTriggerSetting(int characteristicIndex, int descriptorIndex) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.getApparentWindSpeedEnvironmentalSensingTriggerSetting(characteristicIndex, descriptorIndex);
        }
        return taskId;
    }

    /**
     * @see #setApparentWindSpeedEnvironmentalSensingTriggerSetting(int, int, EnvironmentalSensingTriggerSetting)
     */
    @Nullable
    public synchronized Integer setApparentWindSpeedEnvironmentalSensingTriggerSetting(@NonNull EnvironmentalSensingTriggerSetting environmentalSensingTriggerSetting) {
        return setApparentWindSpeedEnvironmentalSensingTriggerSetting(0, 0, environmentalSensingTriggerSetting);
    }

    /**
     * @see EnvironmentalSensingService#setApparentWindSpeedEnvironmentalSensingTriggerSetting(int, int, EnvironmentalSensingTriggerSetting)
     */
    @Nullable
    public synchronized Integer setApparentWindSpeedEnvironmentalSensingTriggerSetting(int characteristicIndex, int descriptorIndex, @NonNull EnvironmentalSensingTriggerSetting environmentalSensingTriggerSetting) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.setApparentWindSpeedEnvironmentalSensingTriggerSetting(characteristicIndex, descriptorIndex, environmentalSensingTriggerSetting);
        }
        return taskId;
    }

    /**
     * @see #getApparentWindSpeedEnvironmentalSensingConfiguration(int)
     */
    @Nullable
    public synchronized Integer getApparentWindSpeedEnvironmentalSensingConfiguration() {
        return getApparentWindSpeedEnvironmentalSensingConfiguration(0);
    }

    /**
     * @see EnvironmentalSensingService#getApparentWindSpeedEnvironmentalSensingConfiguration(int)
     */
    @Nullable
    public synchronized Integer getApparentWindSpeedEnvironmentalSensingConfiguration(int index) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.getApparentWindSpeedEnvironmentalSensingConfiguration(index);
        }
        return taskId;
    }

    /**
     * @see #setApparentWindSpeedEnvironmentalSensingConfiguration(int, EnvironmentalSensingConfiguration)
     */
    @Nullable
    public synchronized Integer setApparentWindSpeedEnvironmentalSensingConfiguration(@NonNull EnvironmentalSensingConfiguration environmentalSensingConfiguration) {
        return setApparentWindSpeedEnvironmentalSensingConfiguration(0, environmentalSensingConfiguration);
    }

    /**
     * @see EnvironmentalSensingService#setApparentWindSpeedEnvironmentalSensingConfiguration(int, EnvironmentalSensingConfiguration)
     */
    @Nullable
    public synchronized Integer setApparentWindSpeedEnvironmentalSensingConfiguration(int index, @NonNull EnvironmentalSensingConfiguration environmentalSensingConfiguration) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.setApparentWindSpeedEnvironmentalSensingConfiguration(index, environmentalSensingConfiguration);
        }
        return taskId;
    }

    /**
     * @see #getApparentWindSpeedCharacteristicUserDescription(int)
     */
    @Nullable
    public synchronized Integer getApparentWindSpeedCharacteristicUserDescription() {
        return getApparentWindSpeedCharacteristicUserDescription(0);
    }

    /**
     * @see EnvironmentalSensingService#getApparentWindSpeedCharacteristicUserDescription(int)
     */
    @Nullable
    public synchronized Integer getApparentWindSpeedCharacteristicUserDescription(int index) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.getApparentWindSpeedCharacteristicUserDescription(index);
        }
        return taskId;
    }

    /**
     * @see #setApparentWindSpeedCharacteristicUserDescription(int, CharacteristicUserDescription)
     */
    @Nullable
    public synchronized Integer setApparentWindSpeedCharacteristicUserDescription(@NonNull CharacteristicUserDescription characteristicUserDescription) {
        return setApparentWindSpeedCharacteristicUserDescription(0, characteristicUserDescription);
    }

    /**
     * @see EnvironmentalSensingService#setApparentWindSpeedCharacteristicUserDescription(int, CharacteristicUserDescription)
     */
    @Nullable
    public synchronized Integer setApparentWindSpeedCharacteristicUserDescription(int index, @NonNull CharacteristicUserDescription characteristicUserDescription) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.setApparentWindSpeedCharacteristicUserDescription(index, characteristicUserDescription);
        }
        return taskId;
    }

    /**
     * @see #getApparentWindSpeedValidRange(int)
     */
    @Nullable
    public synchronized Integer getApparentWindSpeedValidRange() {
        return getApparentWindSpeedValidRange(0);
    }

    /**
     * @see EnvironmentalSensingService#getApparentWindSpeedValidRange(int)
     */
    @Nullable
    public synchronized Integer getApparentWindSpeedValidRange(int index) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.getApparentWindSpeedValidRange(index);
        }
        return taskId;
    }

    /**
     * @see EnvironmentalSensingService#getBarometricPressureTrendCount()
     */
    @Nullable
    public synchronized Integer getBarometricPressureTrendCount() {
        Integer count = null;
        if (mEnvironmentalSensingService != null) {
            count = mEnvironmentalSensingService.getBarometricPressureTrendCount();
        }
        return count;
    }

    /**
     * @see #canBarometricPressureTrendNotify(int)
     */
    public synchronized Boolean canBarometricPressureTrendNotify() {
        return canBarometricPressureTrendNotify(0);
    }

    /**
     * @see EnvironmentalSensingService#canBarometricPressureTrendNotify(int)
     */
    public synchronized Boolean canBarometricPressureTrendNotify(int index) {
        Boolean result = null;
        if (mEnvironmentalSensingService != null) {
            result = mEnvironmentalSensingService.canBarometricPressureTrendNotify(index);
        }
        return result;
    }

    /**
     * @see #hasBarometricPressureTrendCharacteristicEnvironmentalSensingMeasurement(int)
     */
    public synchronized Boolean hasBarometricPressureTrendCharacteristicEnvironmentalSensingMeasurement() {
        return hasBarometricPressureTrendCharacteristicEnvironmentalSensingMeasurement(0);
    }

    /**
     * @see EnvironmentalSensingService#hasBarometricPressureTrendCharacteristicEnvironmentalSensingMeasurement(int)
     */
    public synchronized Boolean hasBarometricPressureTrendCharacteristicEnvironmentalSensingMeasurement(int index) {
        Boolean result = null;
        if (mEnvironmentalSensingService != null) {
            result = mEnvironmentalSensingService.hasBarometricPressureTrendCharacteristicEnvironmentalSensingMeasurement(index);
        }
        return result;
    }

    /**
     * @see #getBarometricPressureTrendCharacteristicEnvironmentalSensingTriggerSettingCount(int)
     */
    public synchronized Integer getBarometricPressureTrendCharacteristicEnvironmentalSensingTriggerSettingCount() {
        return getBarometricPressureTrendCharacteristicEnvironmentalSensingTriggerSettingCount(0);
    }

    /**
     * @see EnvironmentalSensingService#getBarometricPressureTrendCharacteristicEnvironmentalSensingTriggerSettingCount(int)
     */
    @Nullable
    public synchronized Integer getBarometricPressureTrendCharacteristicEnvironmentalSensingTriggerSettingCount(int index) {
        Integer count = null;
        if (mEnvironmentalSensingService != null) {
            count = mEnvironmentalSensingService.getBarometricPressureTrendCharacteristicEnvironmentalSensingTriggerSettingCount(index);
        }
        return count;
    }

    /**
     * @see #hasBarometricPressureTrendCharacteristicEnvironmentalSensingConfiguration(int)
     */
    public synchronized Boolean hasBarometricPressureTrendCharacteristicEnvironmentalSensingConfiguration() {
        return hasBarometricPressureTrendCharacteristicEnvironmentalSensingConfiguration(0);
    }

    /**
     * @see EnvironmentalSensingService#hasBarometricPressureTrendCharacteristicEnvironmentalSensingConfiguration(int)
     */
    public synchronized Boolean hasBarometricPressureTrendCharacteristicEnvironmentalSensingConfiguration(int index) {
        Boolean result = null;
        if (mEnvironmentalSensingService != null) {
            result = mEnvironmentalSensingService.hasBarometricPressureTrendCharacteristicEnvironmentalSensingConfiguration(index);
        }
        return result;
    }

    /**
     * @see #hasBarometricPressureTrendCharacteristicCharacteristicUserDescription(int)
     */
    public synchronized Boolean hasBarometricPressureTrendCharacteristicCharacteristicUserDescription() {
        return hasBarometricPressureTrendCharacteristicCharacteristicUserDescription(0);
    }

    /**
     * @see EnvironmentalSensingService#hasBarometricPressureTrendCharacteristicCharacteristicUserDescription(int)
     */
    public synchronized Boolean hasBarometricPressureTrendCharacteristicCharacteristicUserDescription(int index) {
        Boolean result = null;
        if (mEnvironmentalSensingService != null) {
            result = mEnvironmentalSensingService.hasBarometricPressureTrendCharacteristicCharacteristicUserDescription(index);
        }
        return result;
    }

    /**
     * @see #hasBarometricPressureTrendCharacteristicValidRange(int)
     */
    public synchronized Boolean hasBarometricPressureTrendCharacteristicValidRange() {
        return hasBarometricPressureTrendCharacteristicValidRange(0);
    }

    /**
     * @see EnvironmentalSensingService#hasBarometricPressureTrendCharacteristicValidRange(int)
     */
    public synchronized Boolean hasBarometricPressureTrendCharacteristicValidRange(int index) {
        Boolean result = null;
        if (mEnvironmentalSensingService != null) {
            result = mEnvironmentalSensingService.hasBarometricPressureTrendCharacteristicValidRange(index);
        }
        return result;
    }

    /**
     * @see #getBarometricPressureTrend(int)
     */
    @Nullable
    public synchronized Integer getBarometricPressureTrend() {
        return getBarometricPressureTrend(0);
    }

    /**
     * @see EnvironmentalSensingService#getBarometricPressureTrend(int)
     */
    @Nullable
    public synchronized Integer getBarometricPressureTrend(int index) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.getBarometricPressureTrend(index);
        }
        return taskId;
    }

    /**
     * @see #startBarometricPressureTrendNotification(int)
     */
    @Nullable
    public synchronized Integer startBarometricPressureTrendNotification() {
        return startBarometricPressureTrendNotification(0);
    }

    /**
     * @see EnvironmentalSensingService#startBarometricPressureTrendNotification(int)
     */
    @Nullable
    public synchronized Integer startBarometricPressureTrendNotification(int index) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.startBarometricPressureTrendNotification(index);
        }
        return taskId;
    }

    /**
     * @see #startBarometricPressureTrendNotification(int)
     */
    @Nullable
    public synchronized Integer stopBarometricPressureTrendNotification() {
        return stopBarometricPressureTrendNotification(0);
    }

    /**
     * @see EnvironmentalSensingService#stopBarometricPressureTrendNotification(int)
     */
    @Nullable
    public synchronized Integer stopBarometricPressureTrendNotification(int index) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.stopBarometricPressureTrendNotification(index);
        }
        return taskId;
    }

    /**
     * @see #getBarometricPressureTrendEnvironmentalSensingMeasurement(int)
     */
    @Nullable
    public synchronized Integer getBarometricPressureTrendEnvironmentalSensingMeasurement() {
        return getBarometricPressureTrendEnvironmentalSensingMeasurement(0);
    }

    /**
     * @see EnvironmentalSensingService#getBarometricPressureTrendEnvironmentalSensingMeasurement(int)
     */
    @Nullable
    public synchronized Integer getBarometricPressureTrendEnvironmentalSensingMeasurement(int index) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.getBarometricPressureTrendEnvironmentalSensingMeasurement(index);
        }
        return taskId;
    }

    /**
     * @see #getBarometricPressureTrendEnvironmentalSensingTriggerSetting(int, int)
     */
    @Nullable
    public synchronized Integer getBarometricPressureTrendEnvironmentalSensingTriggerSetting() {
        return getBarometricPressureTrendEnvironmentalSensingTriggerSetting(0, 0);
    }

    /**
     * @see EnvironmentalSensingService#getBarometricPressureTrendEnvironmentalSensingTriggerSetting(int, int)
     */
    @Nullable
    public synchronized Integer getBarometricPressureTrendEnvironmentalSensingTriggerSetting(int characteristicIndex, int descriptorIndex) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.getBarometricPressureTrendEnvironmentalSensingTriggerSetting(characteristicIndex, descriptorIndex);
        }
        return taskId;
    }

    /**
     * @see #setBarometricPressureTrendEnvironmentalSensingTriggerSetting(int, int, EnvironmentalSensingTriggerSetting)
     */
    @Nullable
    public synchronized Integer setBarometricPressureTrendEnvironmentalSensingTriggerSetting(@NonNull EnvironmentalSensingTriggerSetting environmentalSensingTriggerSetting) {
        return setBarometricPressureTrendEnvironmentalSensingTriggerSetting(0, 0, environmentalSensingTriggerSetting);
    }

    /**
     * @see EnvironmentalSensingService#setBarometricPressureTrendEnvironmentalSensingTriggerSetting(int, int, EnvironmentalSensingTriggerSetting)
     */
    @Nullable
    public synchronized Integer setBarometricPressureTrendEnvironmentalSensingTriggerSetting(int characteristicIndex, int descriptorIndex, @NonNull EnvironmentalSensingTriggerSetting environmentalSensingTriggerSetting) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.setBarometricPressureTrendEnvironmentalSensingTriggerSetting(characteristicIndex, descriptorIndex, environmentalSensingTriggerSetting);
        }
        return taskId;
    }

    /**
     * @see #getBarometricPressureTrendEnvironmentalSensingConfiguration(int)
     */
    @Nullable
    public synchronized Integer getBarometricPressureTrendEnvironmentalSensingConfiguration() {
        return getBarometricPressureTrendEnvironmentalSensingConfiguration(0);
    }

    /**
     * @see EnvironmentalSensingService#getBarometricPressureTrendEnvironmentalSensingConfiguration(int)
     */
    @Nullable
    public synchronized Integer getBarometricPressureTrendEnvironmentalSensingConfiguration(int index) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.getBarometricPressureTrendEnvironmentalSensingConfiguration(index);
        }
        return taskId;
    }

    /**
     * @see #setBarometricPressureTrendEnvironmentalSensingConfiguration(int, EnvironmentalSensingConfiguration)
     */
    @Nullable
    public synchronized Integer setBarometricPressureTrendEnvironmentalSensingConfiguration(@NonNull EnvironmentalSensingConfiguration environmentalSensingConfiguration) {
        return setBarometricPressureTrendEnvironmentalSensingConfiguration(0, environmentalSensingConfiguration);
    }

    /**
     * @see EnvironmentalSensingService#setBarometricPressureTrendEnvironmentalSensingConfiguration(int, EnvironmentalSensingConfiguration)
     */
    @Nullable
    public synchronized Integer setBarometricPressureTrendEnvironmentalSensingConfiguration(int index, @NonNull EnvironmentalSensingConfiguration environmentalSensingConfiguration) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.setBarometricPressureTrendEnvironmentalSensingConfiguration(index, environmentalSensingConfiguration);
        }
        return taskId;
    }

    /**
     * @see #getBarometricPressureTrendCharacteristicUserDescription(int)
     */
    @Nullable
    public synchronized Integer getBarometricPressureTrendCharacteristicUserDescription() {
        return getBarometricPressureTrendCharacteristicUserDescription(0);
    }

    /**
     * @see EnvironmentalSensingService#getBarometricPressureTrendCharacteristicUserDescription(int)
     */
    @Nullable
    public synchronized Integer getBarometricPressureTrendCharacteristicUserDescription(int index) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.getBarometricPressureTrendCharacteristicUserDescription(index);
        }
        return taskId;
    }

    /**
     * @see #setBarometricPressureTrendCharacteristicUserDescription(int, CharacteristicUserDescription)
     */
    @Nullable
    public synchronized Integer setBarometricPressureTrendCharacteristicUserDescription(@NonNull CharacteristicUserDescription characteristicUserDescription) {
        return setBarometricPressureTrendCharacteristicUserDescription(0, characteristicUserDescription);
    }

    /**
     * @see EnvironmentalSensingService#setBarometricPressureTrendCharacteristicUserDescription(int, CharacteristicUserDescription)
     */
    @Nullable
    public synchronized Integer setBarometricPressureTrendCharacteristicUserDescription(int index, @NonNull CharacteristicUserDescription characteristicUserDescription) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.setBarometricPressureTrendCharacteristicUserDescription(index, characteristicUserDescription);
        }
        return taskId;
    }

    /**
     * @see #getBarometricPressureTrendValidRange(int)
     */
    @Nullable
    public synchronized Integer getBarometricPressureTrendValidRange() {
        return getBarometricPressureTrendValidRange(0);
    }

    /**
     * @see EnvironmentalSensingService#getBarometricPressureTrendValidRange(int)
     */
    @Nullable
    public synchronized Integer getBarometricPressureTrendValidRange(int index) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.getBarometricPressureTrendValidRange(index);
        }
        return taskId;
    }

    /**
     * @see EnvironmentalSensingService#getCarbonMonoxideConcentrationCount()
     */
    @Nullable
    public synchronized Integer getCarbonMonoxideConcentrationCount() {
        Integer count = null;
        if (mEnvironmentalSensingService != null) {
            count = mEnvironmentalSensingService.getCarbonMonoxideConcentrationCount();
        }
        return count;
    }

    /**
     * @see #canCarbonMonoxideConcentrationNotify(int)
     */
    public synchronized Boolean canCarbonMonoxideConcentrationNotify() {
        return canCarbonMonoxideConcentrationNotify(0);
    }

    /**
     * @see EnvironmentalSensingService#canCarbonMonoxideConcentrationNotify(int)
     */
    public synchronized Boolean canCarbonMonoxideConcentrationNotify(int index) {
        Boolean result = null;
        if (mEnvironmentalSensingService != null) {
            result = mEnvironmentalSensingService.canCarbonMonoxideConcentrationNotify(index);
        }
        return result;
    }

    /**
     * @see #hasCarbonMonoxideConcentrationCharacteristicEnvironmentalSensingMeasurement(int)
     */
    public synchronized Boolean hasCarbonMonoxideConcentrationCharacteristicEnvironmentalSensingMeasurement() {
        return hasCarbonMonoxideConcentrationCharacteristicEnvironmentalSensingMeasurement(0);
    }

    /**
     * @see EnvironmentalSensingService#hasCarbonMonoxideConcentrationCharacteristicEnvironmentalSensingMeasurement(int)
     */
    public synchronized Boolean hasCarbonMonoxideConcentrationCharacteristicEnvironmentalSensingMeasurement(int index) {
        Boolean result = null;
        if (mEnvironmentalSensingService != null) {
            result = mEnvironmentalSensingService.hasCarbonMonoxideConcentrationCharacteristicEnvironmentalSensingMeasurement(index);
        }
        return result;
    }

    /**
     * @see #getCarbonMonoxideConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount(int)
     */
    public synchronized Integer getCarbonMonoxideConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount() {
        return getCarbonMonoxideConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount(0);
    }

    /**
     * @see EnvironmentalSensingService#getCarbonMonoxideConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount(int)
     */
    @Nullable
    public synchronized Integer getCarbonMonoxideConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount(int index) {
        Integer count = null;
        if (mEnvironmentalSensingService != null) {
            count = mEnvironmentalSensingService.getCarbonMonoxideConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount(index);
        }
        return count;
    }

    /**
     * @see #hasCarbonMonoxideConcentrationCharacteristicEnvironmentalSensingConfiguration(int)
     */
    public synchronized Boolean hasCarbonMonoxideConcentrationCharacteristicEnvironmentalSensingConfiguration() {
        return hasCarbonMonoxideConcentrationCharacteristicEnvironmentalSensingConfiguration(0);
    }

    /**
     * @see EnvironmentalSensingService#hasCarbonMonoxideConcentrationCharacteristicEnvironmentalSensingConfiguration(int)
     */
    public synchronized Boolean hasCarbonMonoxideConcentrationCharacteristicEnvironmentalSensingConfiguration(int index) {
        Boolean result = null;
        if (mEnvironmentalSensingService != null) {
            result = mEnvironmentalSensingService.hasCarbonMonoxideConcentrationCharacteristicEnvironmentalSensingConfiguration(index);
        }
        return result;
    }

    /**
     * @see #hasCarbonMonoxideConcentrationCharacteristicCharacteristicUserDescription(int)
     */
    public synchronized Boolean hasCarbonMonoxideConcentrationCharacteristicCharacteristicUserDescription() {
        return hasCarbonMonoxideConcentrationCharacteristicCharacteristicUserDescription(0);
    }

    /**
     * @see EnvironmentalSensingService#hasCarbonMonoxideConcentrationCharacteristicCharacteristicUserDescription(int)
     */
    public synchronized Boolean hasCarbonMonoxideConcentrationCharacteristicCharacteristicUserDescription(int index) {
        Boolean result = null;
        if (mEnvironmentalSensingService != null) {
            result = mEnvironmentalSensingService.hasCarbonMonoxideConcentrationCharacteristicCharacteristicUserDescription(index);
        }
        return result;
    }

    /**
     * @see #hasCarbonMonoxideConcentrationCharacteristicValidRange(int)
     */
    public synchronized Boolean hasCarbonMonoxideConcentrationCharacteristicValidRange() {
        return hasCarbonMonoxideConcentrationCharacteristicValidRange(0);
    }

    /**
     * @see EnvironmentalSensingService#hasCarbonMonoxideConcentrationCharacteristicValidRange(int)
     */
    public synchronized Boolean hasCarbonMonoxideConcentrationCharacteristicValidRange(int index) {
        Boolean result = null;
        if (mEnvironmentalSensingService != null) {
            result = mEnvironmentalSensingService.hasCarbonMonoxideConcentrationCharacteristicValidRange(index);
        }
        return result;
    }

    /**
     * @see #getCarbonMonoxideConcentration(int)
     */
    @Nullable
    public synchronized Integer getCarbonMonoxideConcentration() {
        return getCarbonMonoxideConcentration(0);
    }

    /**
     * @see EnvironmentalSensingService#getCarbonMonoxideConcentration(int)
     */
    @Nullable
    public synchronized Integer getCarbonMonoxideConcentration(int index) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.getCarbonMonoxideConcentration(index);
        }
        return taskId;
    }

    /**
     * @see #startCarbonMonoxideConcentrationNotification(int)
     */
    @Nullable
    public synchronized Integer startCarbonMonoxideConcentrationNotification() {
        return startCarbonMonoxideConcentrationNotification(0);
    }

    /**
     * @see EnvironmentalSensingService#startCarbonMonoxideConcentrationNotification(int)
     */
    @Nullable
    public synchronized Integer startCarbonMonoxideConcentrationNotification(int index) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.startCarbonMonoxideConcentrationNotification(index);
        }
        return taskId;
    }

    /**
     * @see #startCarbonMonoxideConcentrationNotification(int)
     */
    @Nullable
    public synchronized Integer stopCarbonMonoxideConcentrationNotification() {
        return stopCarbonMonoxideConcentrationNotification(0);
    }

    /**
     * @see EnvironmentalSensingService#stopCarbonMonoxideConcentrationNotification(int)
     */
    @Nullable
    public synchronized Integer stopCarbonMonoxideConcentrationNotification(int index) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.stopCarbonMonoxideConcentrationNotification(index);
        }
        return taskId;
    }

    /**
     * @see #getCarbonMonoxideConcentrationEnvironmentalSensingMeasurement(int)
     */
    @Nullable
    public synchronized Integer getCarbonMonoxideConcentrationEnvironmentalSensingMeasurement() {
        return getCarbonMonoxideConcentrationEnvironmentalSensingMeasurement(0);
    }

    /**
     * @see EnvironmentalSensingService#getCarbonMonoxideConcentrationEnvironmentalSensingMeasurement(int)
     */
    @Nullable
    public synchronized Integer getCarbonMonoxideConcentrationEnvironmentalSensingMeasurement(int index) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.getCarbonMonoxideConcentrationEnvironmentalSensingMeasurement(index);
        }
        return taskId;
    }

    /**
     * @see #getCarbonMonoxideConcentrationEnvironmentalSensingTriggerSetting(int, int)
     */
    @Nullable
    public synchronized Integer getCarbonMonoxideConcentrationEnvironmentalSensingTriggerSetting() {
        return getCarbonMonoxideConcentrationEnvironmentalSensingTriggerSetting(0, 0);
    }

    /**
     * @see EnvironmentalSensingService#getCarbonMonoxideConcentrationEnvironmentalSensingTriggerSetting(int, int)
     */
    @Nullable
    public synchronized Integer getCarbonMonoxideConcentrationEnvironmentalSensingTriggerSetting(int characteristicIndex, int descriptorIndex) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.getCarbonMonoxideConcentrationEnvironmentalSensingTriggerSetting(characteristicIndex, descriptorIndex);
        }
        return taskId;
    }

    /**
     * @see #setCarbonMonoxideConcentrationEnvironmentalSensingTriggerSetting(int, int, EnvironmentalSensingTriggerSetting)
     */
    @Nullable
    public synchronized Integer setCarbonMonoxideConcentrationEnvironmentalSensingTriggerSetting(@NonNull EnvironmentalSensingTriggerSetting environmentalSensingTriggerSetting) {
        return setCarbonMonoxideConcentrationEnvironmentalSensingTriggerSetting(0, 0, environmentalSensingTriggerSetting);
    }

    /**
     * @see EnvironmentalSensingService#setCarbonMonoxideConcentrationEnvironmentalSensingTriggerSetting(int, int, EnvironmentalSensingTriggerSetting)
     */
    @Nullable
    public synchronized Integer setCarbonMonoxideConcentrationEnvironmentalSensingTriggerSetting(int characteristicIndex, int descriptorIndex, @NonNull EnvironmentalSensingTriggerSetting environmentalSensingTriggerSetting) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.setCarbonMonoxideConcentrationEnvironmentalSensingTriggerSetting(characteristicIndex, descriptorIndex, environmentalSensingTriggerSetting);
        }
        return taskId;
    }

    /**
     * @see #getCarbonMonoxideConcentrationEnvironmentalSensingConfiguration(int)
     */
    @Nullable
    public synchronized Integer getCarbonMonoxideConcentrationEnvironmentalSensingConfiguration() {
        return getCarbonMonoxideConcentrationEnvironmentalSensingConfiguration(0);
    }

    /**
     * @see EnvironmentalSensingService#getCarbonMonoxideConcentrationEnvironmentalSensingConfiguration(int)
     */
    @Nullable
    public synchronized Integer getCarbonMonoxideConcentrationEnvironmentalSensingConfiguration(int index) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.getCarbonMonoxideConcentrationEnvironmentalSensingConfiguration(index);
        }
        return taskId;
    }

    /**
     * @see #setCarbonMonoxideConcentrationEnvironmentalSensingConfiguration(int, EnvironmentalSensingConfiguration)
     */
    @Nullable
    public synchronized Integer setCarbonMonoxideConcentrationEnvironmentalSensingConfiguration(@NonNull EnvironmentalSensingConfiguration environmentalSensingConfiguration) {
        return setCarbonMonoxideConcentrationEnvironmentalSensingConfiguration(0, environmentalSensingConfiguration);
    }

    /**
     * @see EnvironmentalSensingService#setCarbonMonoxideConcentrationEnvironmentalSensingConfiguration(int, EnvironmentalSensingConfiguration)
     */
    @Nullable
    public synchronized Integer setCarbonMonoxideConcentrationEnvironmentalSensingConfiguration(int index, @NonNull EnvironmentalSensingConfiguration environmentalSensingConfiguration) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.setCarbonMonoxideConcentrationEnvironmentalSensingConfiguration(index, environmentalSensingConfiguration);
        }
        return taskId;
    }

    /**
     * @see #getCarbonMonoxideConcentrationCharacteristicUserDescription(int)
     */
    @Nullable
    public synchronized Integer getCarbonMonoxideConcentrationCharacteristicUserDescription() {
        return getCarbonMonoxideConcentrationCharacteristicUserDescription(0);
    }

    /**
     * @see EnvironmentalSensingService#getCarbonMonoxideConcentrationCharacteristicUserDescription(int)
     */
    @Nullable
    public synchronized Integer getCarbonMonoxideConcentrationCharacteristicUserDescription(int index) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.getCarbonMonoxideConcentrationCharacteristicUserDescription(index);
        }
        return taskId;
    }

    /**
     * @see #setCarbonMonoxideConcentrationCharacteristicUserDescription(int, CharacteristicUserDescription)
     */
    @Nullable
    public synchronized Integer setCarbonMonoxideConcentrationCharacteristicUserDescription(@NonNull CharacteristicUserDescription characteristicUserDescription) {
        return setCarbonMonoxideConcentrationCharacteristicUserDescription(0, characteristicUserDescription);
    }

    /**
     * @see EnvironmentalSensingService#setCarbonMonoxideConcentrationCharacteristicUserDescription(int, CharacteristicUserDescription)
     */
    @Nullable
    public synchronized Integer setCarbonMonoxideConcentrationCharacteristicUserDescription(int index, @NonNull CharacteristicUserDescription characteristicUserDescription) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.setCarbonMonoxideConcentrationCharacteristicUserDescription(index, characteristicUserDescription);
        }
        return taskId;
    }

    /**
     * @see #getCarbonMonoxideConcentrationValidRange(int)
     */
    @Nullable
    public synchronized Integer getCarbonMonoxideConcentrationValidRange() {
        return getCarbonMonoxideConcentrationValidRange(0);
    }

    /**
     * @see EnvironmentalSensingService#getCarbonMonoxideConcentrationValidRange(int)
     */
    @Nullable
    public synchronized Integer getCarbonMonoxideConcentrationValidRange(int index) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.getCarbonMonoxideConcentrationValidRange(index);
        }
        return taskId;
    }

    /**
     * @see EnvironmentalSensingService#getDewPointCount()
     */
    @Nullable
    public synchronized Integer getDewPointCount() {
        Integer count = null;
        if (mEnvironmentalSensingService != null) {
            count = mEnvironmentalSensingService.getDewPointCount();
        }
        return count;
    }

    /**
     * @see #canDewPointNotify(int)
     */
    public synchronized Boolean canDewPointNotify() {
        return canDewPointNotify(0);
    }

    /**
     * @see EnvironmentalSensingService#canDewPointNotify(int)
     */
    public synchronized Boolean canDewPointNotify(int index) {
        Boolean result = null;
        if (mEnvironmentalSensingService != null) {
            result = mEnvironmentalSensingService.canDewPointNotify(index);
        }
        return result;
    }

    /**
     * @see #hasDewPointCharacteristicEnvironmentalSensingMeasurement(int)
     */
    public synchronized Boolean hasDewPointCharacteristicEnvironmentalSensingMeasurement() {
        return hasDewPointCharacteristicEnvironmentalSensingMeasurement(0);
    }

    /**
     * @see EnvironmentalSensingService#hasDewPointCharacteristicEnvironmentalSensingMeasurement(int)
     */
    public synchronized Boolean hasDewPointCharacteristicEnvironmentalSensingMeasurement(int index) {
        Boolean result = null;
        if (mEnvironmentalSensingService != null) {
            result = mEnvironmentalSensingService.hasDewPointCharacteristicEnvironmentalSensingMeasurement(index);
        }
        return result;
    }

    /**
     * @see #getDewPointCharacteristicEnvironmentalSensingTriggerSettingCount(int)
     */
    public synchronized Integer getDewPointCharacteristicEnvironmentalSensingTriggerSettingCount() {
        return getDewPointCharacteristicEnvironmentalSensingTriggerSettingCount(0);
    }

    /**
     * @see EnvironmentalSensingService#getDewPointCharacteristicEnvironmentalSensingTriggerSettingCount(int)
     */
    @Nullable
    public synchronized Integer getDewPointCharacteristicEnvironmentalSensingTriggerSettingCount(int index) {
        Integer count = null;
        if (mEnvironmentalSensingService != null) {
            count = mEnvironmentalSensingService.getDewPointCharacteristicEnvironmentalSensingTriggerSettingCount(index);
        }
        return count;
    }

    /**
     * @see #hasDewPointCharacteristicEnvironmentalSensingConfiguration(int)
     */
    public synchronized Boolean hasDewPointCharacteristicEnvironmentalSensingConfiguration() {
        return hasDewPointCharacteristicEnvironmentalSensingConfiguration(0);
    }

    /**
     * @see EnvironmentalSensingService#hasDewPointCharacteristicEnvironmentalSensingConfiguration(int)
     */
    public synchronized Boolean hasDewPointCharacteristicEnvironmentalSensingConfiguration(int index) {
        Boolean result = null;
        if (mEnvironmentalSensingService != null) {
            result = mEnvironmentalSensingService.hasDewPointCharacteristicEnvironmentalSensingConfiguration(index);
        }
        return result;
    }

    /**
     * @see #hasDewPointCharacteristicCharacteristicUserDescription(int)
     */
    public synchronized Boolean hasDewPointCharacteristicCharacteristicUserDescription() {
        return hasDewPointCharacteristicCharacteristicUserDescription(0);
    }

    /**
     * @see EnvironmentalSensingService#hasDewPointCharacteristicCharacteristicUserDescription(int)
     */
    public synchronized Boolean hasDewPointCharacteristicCharacteristicUserDescription(int index) {
        Boolean result = null;
        if (mEnvironmentalSensingService != null) {
            result = mEnvironmentalSensingService.hasDewPointCharacteristicCharacteristicUserDescription(index);
        }
        return result;
    }

    /**
     * @see #hasDewPointCharacteristicValidRange(int)
     */
    public synchronized Boolean hasDewPointCharacteristicValidRange() {
        return hasDewPointCharacteristicValidRange(0);
    }

    /**
     * @see EnvironmentalSensingService#hasDewPointCharacteristicValidRange(int)
     */
    public synchronized Boolean hasDewPointCharacteristicValidRange(int index) {
        Boolean result = null;
        if (mEnvironmentalSensingService != null) {
            result = mEnvironmentalSensingService.hasDewPointCharacteristicValidRange(index);
        }
        return result;
    }

    /**
     * @see #getDewPoint(int)
     */
    @Nullable
    public synchronized Integer getDewPoint() {
        return getDewPoint(0);
    }

    /**
     * @see EnvironmentalSensingService#getDewPoint(int)
     */
    @Nullable
    public synchronized Integer getDewPoint(int index) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.getDewPoint(index);
        }
        return taskId;
    }

    /**
     * @see #startDewPointNotification(int)
     */
    @Nullable
    public synchronized Integer startDewPointNotification() {
        return startDewPointNotification(0);
    }

    /**
     * @see EnvironmentalSensingService#startDewPointNotification(int)
     */
    @Nullable
    public synchronized Integer startDewPointNotification(int index) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.startDewPointNotification(index);
        }
        return taskId;
    }

    /**
     * @see #startDewPointNotification(int)
     */
    @Nullable
    public synchronized Integer stopDewPointNotification() {
        return stopDewPointNotification(0);
    }

    /**
     * @see EnvironmentalSensingService#stopDewPointNotification(int)
     */
    @Nullable
    public synchronized Integer stopDewPointNotification(int index) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.stopDewPointNotification(index);
        }
        return taskId;
    }

    /**
     * @see #getDewPointEnvironmentalSensingMeasurement(int)
     */
    @Nullable
    public synchronized Integer getDewPointEnvironmentalSensingMeasurement() {
        return getDewPointEnvironmentalSensingMeasurement(0);
    }

    /**
     * @see EnvironmentalSensingService#getDewPointEnvironmentalSensingMeasurement(int)
     */
    @Nullable
    public synchronized Integer getDewPointEnvironmentalSensingMeasurement(int index) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.getDewPointEnvironmentalSensingMeasurement(index);
        }
        return taskId;
    }

    /**
     * @see #getDewPointEnvironmentalSensingTriggerSetting(int, int)
     */
    @Nullable
    public synchronized Integer getDewPointEnvironmentalSensingTriggerSetting() {
        return getDewPointEnvironmentalSensingTriggerSetting(0, 0);
    }

    /**
     * @see EnvironmentalSensingService#getDewPointEnvironmentalSensingTriggerSetting(int, int)
     */
    @Nullable
    public synchronized Integer getDewPointEnvironmentalSensingTriggerSetting(int characteristicIndex, int descriptorIndex) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.getDewPointEnvironmentalSensingTriggerSetting(characteristicIndex, descriptorIndex);
        }
        return taskId;
    }

    /**
     * @see #setDewPointEnvironmentalSensingTriggerSetting(int, int, EnvironmentalSensingTriggerSetting)
     */
    @Nullable
    public synchronized Integer setDewPointEnvironmentalSensingTriggerSetting(@NonNull EnvironmentalSensingTriggerSetting environmentalSensingTriggerSetting) {
        return setDewPointEnvironmentalSensingTriggerSetting(0, 0, environmentalSensingTriggerSetting);
    }

    /**
     * @see EnvironmentalSensingService#setDewPointEnvironmentalSensingTriggerSetting(int, int, EnvironmentalSensingTriggerSetting)
     */
    @Nullable
    public synchronized Integer setDewPointEnvironmentalSensingTriggerSetting(int characteristicIndex, int descriptorIndex, @NonNull EnvironmentalSensingTriggerSetting environmentalSensingTriggerSetting) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.setDewPointEnvironmentalSensingTriggerSetting(characteristicIndex, descriptorIndex, environmentalSensingTriggerSetting);
        }
        return taskId;
    }

    /**
     * @see #getDewPointEnvironmentalSensingConfiguration(int)
     */
    @Nullable
    public synchronized Integer getDewPointEnvironmentalSensingConfiguration() {
        return getDewPointEnvironmentalSensingConfiguration(0);
    }

    /**
     * @see EnvironmentalSensingService#getDewPointEnvironmentalSensingConfiguration(int)
     */
    @Nullable
    public synchronized Integer getDewPointEnvironmentalSensingConfiguration(int index) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.getDewPointEnvironmentalSensingConfiguration(index);
        }
        return taskId;
    }

    /**
     * @see #setDewPointEnvironmentalSensingConfiguration(int, EnvironmentalSensingConfiguration)
     */
    @Nullable
    public synchronized Integer setDewPointEnvironmentalSensingConfiguration(@NonNull EnvironmentalSensingConfiguration environmentalSensingConfiguration) {
        return setDewPointEnvironmentalSensingConfiguration(0, environmentalSensingConfiguration);
    }

    /**
     * @see EnvironmentalSensingService#setDewPointEnvironmentalSensingConfiguration(int, EnvironmentalSensingConfiguration)
     */
    @Nullable
    public synchronized Integer setDewPointEnvironmentalSensingConfiguration(int index, @NonNull EnvironmentalSensingConfiguration environmentalSensingConfiguration) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.setDewPointEnvironmentalSensingConfiguration(index, environmentalSensingConfiguration);
        }
        return taskId;
    }

    /**
     * @see #getDewPointCharacteristicUserDescription(int)
     */
    @Nullable
    public synchronized Integer getDewPointCharacteristicUserDescription() {
        return getDewPointCharacteristicUserDescription(0);
    }

    /**
     * @see EnvironmentalSensingService#getDewPointCharacteristicUserDescription(int)
     */
    @Nullable
    public synchronized Integer getDewPointCharacteristicUserDescription(int index) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.getDewPointCharacteristicUserDescription(index);
        }
        return taskId;
    }

    /**
     * @see #setDewPointCharacteristicUserDescription(int, CharacteristicUserDescription)
     */
    @Nullable
    public synchronized Integer setDewPointCharacteristicUserDescription(@NonNull CharacteristicUserDescription characteristicUserDescription) {
        return setDewPointCharacteristicUserDescription(0, characteristicUserDescription);
    }

    /**
     * @see EnvironmentalSensingService#setDewPointCharacteristicUserDescription(int, CharacteristicUserDescription)
     */
    @Nullable
    public synchronized Integer setDewPointCharacteristicUserDescription(int index, @NonNull CharacteristicUserDescription characteristicUserDescription) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.setDewPointCharacteristicUserDescription(index, characteristicUserDescription);
        }
        return taskId;
    }

    /**
     * @see #getDewPointValidRange(int)
     */
    @Nullable
    public synchronized Integer getDewPointValidRange() {
        return getDewPointValidRange(0);
    }

    /**
     * @see EnvironmentalSensingService#getDewPointValidRange(int)
     */
    @Nullable
    public synchronized Integer getDewPointValidRange(int index) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.getDewPointValidRange(index);
        }
        return taskId;
    }

    /**
     * @see EnvironmentalSensingService#getElevationCount()
     */
    @Nullable
    public synchronized Integer getElevationCount() {
        Integer count = null;
        if (mEnvironmentalSensingService != null) {
            count = mEnvironmentalSensingService.getElevationCount();
        }
        return count;
    }

    /**
     * @see #canElevationNotify(int)
     */
    public synchronized Boolean canElevationNotify() {
        return canElevationNotify(0);
    }

    /**
     * @see EnvironmentalSensingService#canElevationNotify(int)
     */
    public synchronized Boolean canElevationNotify(int index) {
        Boolean result = null;
        if (mEnvironmentalSensingService != null) {
            result = mEnvironmentalSensingService.canElevationNotify(index);
        }
        return result;
    }

    /**
     * @see #hasElevationCharacteristicEnvironmentalSensingMeasurement(int)
     */
    public synchronized Boolean hasElevationCharacteristicEnvironmentalSensingMeasurement() {
        return hasElevationCharacteristicEnvironmentalSensingMeasurement(0);
    }

    /**
     * @see EnvironmentalSensingService#hasElevationCharacteristicEnvironmentalSensingMeasurement(int)
     */
    public synchronized Boolean hasElevationCharacteristicEnvironmentalSensingMeasurement(int index) {
        Boolean result = null;
        if (mEnvironmentalSensingService != null) {
            result = mEnvironmentalSensingService.hasElevationCharacteristicEnvironmentalSensingMeasurement(index);
        }
        return result;
    }

    /**
     * @see #getElevationCharacteristicEnvironmentalSensingTriggerSettingCount(int)
     */
    public synchronized Integer getElevationCharacteristicEnvironmentalSensingTriggerSettingCount() {
        return getElevationCharacteristicEnvironmentalSensingTriggerSettingCount(0);
    }

    /**
     * @see EnvironmentalSensingService#getElevationCharacteristicEnvironmentalSensingTriggerSettingCount(int)
     */
    @Nullable
    public synchronized Integer getElevationCharacteristicEnvironmentalSensingTriggerSettingCount(int index) {
        Integer count = null;
        if (mEnvironmentalSensingService != null) {
            count = mEnvironmentalSensingService.getElevationCharacteristicEnvironmentalSensingTriggerSettingCount(index);
        }
        return count;
    }

    /**
     * @see #hasElevationCharacteristicEnvironmentalSensingConfiguration(int)
     */
    public synchronized Boolean hasElevationCharacteristicEnvironmentalSensingConfiguration() {
        return hasElevationCharacteristicEnvironmentalSensingConfiguration(0);
    }

    /**
     * @see EnvironmentalSensingService#hasElevationCharacteristicEnvironmentalSensingConfiguration(int)
     */
    public synchronized Boolean hasElevationCharacteristicEnvironmentalSensingConfiguration(int index) {
        Boolean result = null;
        if (mEnvironmentalSensingService != null) {
            result = mEnvironmentalSensingService.hasElevationCharacteristicEnvironmentalSensingConfiguration(index);
        }
        return result;
    }

    /**
     * @see #hasElevationCharacteristicCharacteristicUserDescription(int)
     */
    public synchronized Boolean hasElevationCharacteristicCharacteristicUserDescription() {
        return hasElevationCharacteristicCharacteristicUserDescription(0);
    }

    /**
     * @see EnvironmentalSensingService#hasElevationCharacteristicCharacteristicUserDescription(int)
     */
    public synchronized Boolean hasElevationCharacteristicCharacteristicUserDescription(int index) {
        Boolean result = null;
        if (mEnvironmentalSensingService != null) {
            result = mEnvironmentalSensingService.hasElevationCharacteristicCharacteristicUserDescription(index);
        }
        return result;
    }

    /**
     * @see #hasElevationCharacteristicValidRange(int)
     */
    public synchronized Boolean hasElevationCharacteristicValidRange() {
        return hasElevationCharacteristicValidRange(0);
    }

    /**
     * @see EnvironmentalSensingService#hasElevationCharacteristicValidRange(int)
     */
    public synchronized Boolean hasElevationCharacteristicValidRange(int index) {
        Boolean result = null;
        if (mEnvironmentalSensingService != null) {
            result = mEnvironmentalSensingService.hasElevationCharacteristicValidRange(index);
        }
        return result;
    }

    /**
     * @see #getElevation(int)
     */
    @Nullable
    public synchronized Integer getElevation() {
        return getElevation(0);
    }

    /**
     * @see EnvironmentalSensingService#getElevation(int)
     */
    @Nullable
    public synchronized Integer getElevation(int index) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.getElevation(index);
        }
        return taskId;
    }

    /**
     * @see #startElevationNotification(int)
     */
    @Nullable
    public synchronized Integer startElevationNotification() {
        return startElevationNotification(0);
    }

    /**
     * @see EnvironmentalSensingService#startElevationNotification(int)
     */
    @Nullable
    public synchronized Integer startElevationNotification(int index) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.startElevationNotification(index);
        }
        return taskId;
    }

    /**
     * @see #startElevationNotification(int)
     */
    @Nullable
    public synchronized Integer stopElevationNotification() {
        return stopElevationNotification(0);
    }

    /**
     * @see EnvironmentalSensingService#stopElevationNotification(int)
     */
    @Nullable
    public synchronized Integer stopElevationNotification(int index) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.stopElevationNotification(index);
        }
        return taskId;
    }

    /**
     * @see #getElevationEnvironmentalSensingMeasurement(int)
     */
    @Nullable
    public synchronized Integer getElevationEnvironmentalSensingMeasurement() {
        return getElevationEnvironmentalSensingMeasurement(0);
    }

    /**
     * @see EnvironmentalSensingService#getElevationEnvironmentalSensingMeasurement(int)
     */
    @Nullable
    public synchronized Integer getElevationEnvironmentalSensingMeasurement(int index) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.getElevationEnvironmentalSensingMeasurement(index);
        }
        return taskId;
    }

    /**
     * @see #getElevationEnvironmentalSensingTriggerSetting(int, int)
     */
    @Nullable
    public synchronized Integer getElevationEnvironmentalSensingTriggerSetting() {
        return getElevationEnvironmentalSensingTriggerSetting(0, 0);
    }

    /**
     * @see EnvironmentalSensingService#getElevationEnvironmentalSensingTriggerSetting(int, int)
     */
    @Nullable
    public synchronized Integer getElevationEnvironmentalSensingTriggerSetting(int characteristicIndex, int descriptorIndex) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.getElevationEnvironmentalSensingTriggerSetting(characteristicIndex, descriptorIndex);
        }
        return taskId;
    }

    /**
     * @see #setElevationEnvironmentalSensingTriggerSetting(int, int, EnvironmentalSensingTriggerSetting)
     */
    @Nullable
    public synchronized Integer setElevationEnvironmentalSensingTriggerSetting(@NonNull EnvironmentalSensingTriggerSetting environmentalSensingTriggerSetting) {
        return setElevationEnvironmentalSensingTriggerSetting(0, 0, environmentalSensingTriggerSetting);
    }

    /**
     * @see EnvironmentalSensingService#setElevationEnvironmentalSensingTriggerSetting(int, int, EnvironmentalSensingTriggerSetting)
     */
    @Nullable
    public synchronized Integer setElevationEnvironmentalSensingTriggerSetting(int characteristicIndex, int descriptorIndex, @NonNull EnvironmentalSensingTriggerSetting environmentalSensingTriggerSetting) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.setElevationEnvironmentalSensingTriggerSetting(characteristicIndex, descriptorIndex, environmentalSensingTriggerSetting);
        }
        return taskId;
    }

    /**
     * @see #getElevationEnvironmentalSensingConfiguration(int)
     */
    @Nullable
    public synchronized Integer getElevationEnvironmentalSensingConfiguration() {
        return getElevationEnvironmentalSensingConfiguration(0);
    }

    /**
     * @see EnvironmentalSensingService#getElevationEnvironmentalSensingConfiguration(int)
     */
    @Nullable
    public synchronized Integer getElevationEnvironmentalSensingConfiguration(int index) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.getElevationEnvironmentalSensingConfiguration(index);
        }
        return taskId;
    }

    /**
     * @see #setElevationEnvironmentalSensingConfiguration(int, EnvironmentalSensingConfiguration)
     */
    @Nullable
    public synchronized Integer setElevationEnvironmentalSensingConfiguration(@NonNull EnvironmentalSensingConfiguration environmentalSensingConfiguration) {
        return setElevationEnvironmentalSensingConfiguration(0, environmentalSensingConfiguration);
    }

    /**
     * @see EnvironmentalSensingService#setElevationEnvironmentalSensingConfiguration(int, EnvironmentalSensingConfiguration)
     */
    @Nullable
    public synchronized Integer setElevationEnvironmentalSensingConfiguration(int index, @NonNull EnvironmentalSensingConfiguration environmentalSensingConfiguration) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.setElevationEnvironmentalSensingConfiguration(index, environmentalSensingConfiguration);
        }
        return taskId;
    }

    /**
     * @see #getElevationCharacteristicUserDescription(int)
     */
    @Nullable
    public synchronized Integer getElevationCharacteristicUserDescription() {
        return getElevationCharacteristicUserDescription(0);
    }

    /**
     * @see EnvironmentalSensingService#getElevationCharacteristicUserDescription(int)
     */
    @Nullable
    public synchronized Integer getElevationCharacteristicUserDescription(int index) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.getElevationCharacteristicUserDescription(index);
        }
        return taskId;
    }

    /**
     * @see #setElevationCharacteristicUserDescription(int, CharacteristicUserDescription)
     */
    @Nullable
    public synchronized Integer setElevationCharacteristicUserDescription(@NonNull CharacteristicUserDescription characteristicUserDescription) {
        return setElevationCharacteristicUserDescription(0, characteristicUserDescription);
    }

    /**
     * @see EnvironmentalSensingService#setElevationCharacteristicUserDescription(int, CharacteristicUserDescription)
     */
    @Nullable
    public synchronized Integer setElevationCharacteristicUserDescription(int index, @NonNull CharacteristicUserDescription characteristicUserDescription) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.setElevationCharacteristicUserDescription(index, characteristicUserDescription);
        }
        return taskId;
    }

    /**
     * @see #getElevationValidRange(int)
     */
    @Nullable
    public synchronized Integer getElevationValidRange() {
        return getElevationValidRange(0);
    }

    /**
     * @see EnvironmentalSensingService#getElevationValidRange(int)
     */
    @Nullable
    public synchronized Integer getElevationValidRange(int index) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.getElevationValidRange(index);
        }
        return taskId;
    }

    /**
     * @see EnvironmentalSensingService#getGustFactorCount()
     */
    @Nullable
    public synchronized Integer getGustFactorCount() {
        Integer count = null;
        if (mEnvironmentalSensingService != null) {
            count = mEnvironmentalSensingService.getGustFactorCount();
        }
        return count;
    }

    /**
     * @see #canGustFactorNotify(int)
     */
    public synchronized Boolean canGustFactorNotify() {
        return canGustFactorNotify(0);
    }

    /**
     * @see EnvironmentalSensingService#canGustFactorNotify(int)
     */
    public synchronized Boolean canGustFactorNotify(int index) {
        Boolean result = null;
        if (mEnvironmentalSensingService != null) {
            result = mEnvironmentalSensingService.canGustFactorNotify(index);
        }
        return result;
    }

    /**
     * @see #hasGustFactorCharacteristicEnvironmentalSensingMeasurement(int)
     */
    public synchronized Boolean hasGustFactorCharacteristicEnvironmentalSensingMeasurement() {
        return hasGustFactorCharacteristicEnvironmentalSensingMeasurement(0);
    }

    /**
     * @see EnvironmentalSensingService#hasGustFactorCharacteristicEnvironmentalSensingMeasurement(int)
     */
    public synchronized Boolean hasGustFactorCharacteristicEnvironmentalSensingMeasurement(int index) {
        Boolean result = null;
        if (mEnvironmentalSensingService != null) {
            result = mEnvironmentalSensingService.hasGustFactorCharacteristicEnvironmentalSensingMeasurement(index);
        }
        return result;
    }

    /**
     * @see #getGustFactorCharacteristicEnvironmentalSensingTriggerSettingCount(int)
     */
    public synchronized Integer getGustFactorCharacteristicEnvironmentalSensingTriggerSettingCount() {
        return getGustFactorCharacteristicEnvironmentalSensingTriggerSettingCount(0);
    }

    /**
     * @see EnvironmentalSensingService#getGustFactorCharacteristicEnvironmentalSensingTriggerSettingCount(int)
     */
    @Nullable
    public synchronized Integer getGustFactorCharacteristicEnvironmentalSensingTriggerSettingCount(int index) {
        Integer count = null;
        if (mEnvironmentalSensingService != null) {
            count = mEnvironmentalSensingService.getGustFactorCharacteristicEnvironmentalSensingTriggerSettingCount(index);
        }
        return count;
    }

    /**
     * @see #hasGustFactorCharacteristicEnvironmentalSensingConfiguration(int)
     */
    public synchronized Boolean hasGustFactorCharacteristicEnvironmentalSensingConfiguration() {
        return hasGustFactorCharacteristicEnvironmentalSensingConfiguration(0);
    }

    /**
     * @see EnvironmentalSensingService#hasGustFactorCharacteristicEnvironmentalSensingConfiguration(int)
     */
    public synchronized Boolean hasGustFactorCharacteristicEnvironmentalSensingConfiguration(int index) {
        Boolean result = null;
        if (mEnvironmentalSensingService != null) {
            result = mEnvironmentalSensingService.hasGustFactorCharacteristicEnvironmentalSensingConfiguration(index);
        }
        return result;
    }

    /**
     * @see #hasGustFactorCharacteristicCharacteristicUserDescription(int)
     */
    public synchronized Boolean hasGustFactorCharacteristicCharacteristicUserDescription() {
        return hasGustFactorCharacteristicCharacteristicUserDescription(0);
    }

    /**
     * @see EnvironmentalSensingService#hasGustFactorCharacteristicCharacteristicUserDescription(int)
     */
    public synchronized Boolean hasGustFactorCharacteristicCharacteristicUserDescription(int index) {
        Boolean result = null;
        if (mEnvironmentalSensingService != null) {
            result = mEnvironmentalSensingService.hasGustFactorCharacteristicCharacteristicUserDescription(index);
        }
        return result;
    }

    /**
     * @see #hasGustFactorCharacteristicValidRange(int)
     */
    public synchronized Boolean hasGustFactorCharacteristicValidRange() {
        return hasGustFactorCharacteristicValidRange(0);
    }

    /**
     * @see EnvironmentalSensingService#hasGustFactorCharacteristicValidRange(int)
     */
    public synchronized Boolean hasGustFactorCharacteristicValidRange(int index) {
        Boolean result = null;
        if (mEnvironmentalSensingService != null) {
            result = mEnvironmentalSensingService.hasGustFactorCharacteristicValidRange(index);
        }
        return result;
    }

    /**
     * @see #getGustFactor(int)
     */
    @Nullable
    public synchronized Integer getGustFactor() {
        return getGustFactor(0);
    }

    /**
     * @see EnvironmentalSensingService#getGustFactor(int)
     */
    @Nullable
    public synchronized Integer getGustFactor(int index) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.getGustFactor(index);
        }
        return taskId;
    }

    /**
     * @see #startGustFactorNotification(int)
     */
    @Nullable
    public synchronized Integer startGustFactorNotification() {
        return startGustFactorNotification(0);
    }

    /**
     * @see EnvironmentalSensingService#startGustFactorNotification(int)
     */
    @Nullable
    public synchronized Integer startGustFactorNotification(int index) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.startGustFactorNotification(index);
        }
        return taskId;
    }

    /**
     * @see #startGustFactorNotification(int)
     */
    @Nullable
    public synchronized Integer stopGustFactorNotification() {
        return stopGustFactorNotification(0);
    }

    /**
     * @see EnvironmentalSensingService#stopGustFactorNotification(int)
     */
    @Nullable
    public synchronized Integer stopGustFactorNotification(int index) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.stopGustFactorNotification(index);
        }
        return taskId;
    }

    /**
     * @see #getGustFactorEnvironmentalSensingMeasurement(int)
     */
    @Nullable
    public synchronized Integer getGustFactorEnvironmentalSensingMeasurement() {
        return getGustFactorEnvironmentalSensingMeasurement(0);
    }

    /**
     * @see EnvironmentalSensingService#getGustFactorEnvironmentalSensingMeasurement(int)
     */
    @Nullable
    public synchronized Integer getGustFactorEnvironmentalSensingMeasurement(int index) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.getGustFactorEnvironmentalSensingMeasurement(index);
        }
        return taskId;
    }

    /**
     * @see #getGustFactorEnvironmentalSensingTriggerSetting(int, int)
     */
    @Nullable
    public synchronized Integer getGustFactorEnvironmentalSensingTriggerSetting() {
        return getGustFactorEnvironmentalSensingTriggerSetting(0, 0);
    }

    /**
     * @see EnvironmentalSensingService#getGustFactorEnvironmentalSensingTriggerSetting(int, int)
     */
    @Nullable
    public synchronized Integer getGustFactorEnvironmentalSensingTriggerSetting(int characteristicIndex, int descriptorIndex) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.getGustFactorEnvironmentalSensingTriggerSetting(characteristicIndex, descriptorIndex);
        }
        return taskId;
    }

    /**
     * @see #setGustFactorEnvironmentalSensingTriggerSetting(int, int, EnvironmentalSensingTriggerSetting)
     */
    @Nullable
    public synchronized Integer setGustFactorEnvironmentalSensingTriggerSetting(@NonNull EnvironmentalSensingTriggerSetting environmentalSensingTriggerSetting) {
        return setGustFactorEnvironmentalSensingTriggerSetting(0, 0, environmentalSensingTriggerSetting);
    }

    /**
     * @see EnvironmentalSensingService#setGustFactorEnvironmentalSensingTriggerSetting(int, int, EnvironmentalSensingTriggerSetting)
     */
    @Nullable
    public synchronized Integer setGustFactorEnvironmentalSensingTriggerSetting(int characteristicIndex, int descriptorIndex, @NonNull EnvironmentalSensingTriggerSetting environmentalSensingTriggerSetting) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.setGustFactorEnvironmentalSensingTriggerSetting(characteristicIndex, descriptorIndex, environmentalSensingTriggerSetting);
        }
        return taskId;
    }

    /**
     * @see #getGustFactorEnvironmentalSensingConfiguration(int)
     */
    @Nullable
    public synchronized Integer getGustFactorEnvironmentalSensingConfiguration() {
        return getGustFactorEnvironmentalSensingConfiguration(0);
    }

    /**
     * @see EnvironmentalSensingService#getGustFactorEnvironmentalSensingConfiguration(int)
     */
    @Nullable
    public synchronized Integer getGustFactorEnvironmentalSensingConfiguration(int index) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.getGustFactorEnvironmentalSensingConfiguration(index);
        }
        return taskId;
    }

    /**
     * @see #setGustFactorEnvironmentalSensingConfiguration(int, EnvironmentalSensingConfiguration)
     */
    @Nullable
    public synchronized Integer setGustFactorEnvironmentalSensingConfiguration(@NonNull EnvironmentalSensingConfiguration environmentalSensingConfiguration) {
        return setGustFactorEnvironmentalSensingConfiguration(0, environmentalSensingConfiguration);
    }

    /**
     * @see EnvironmentalSensingService#setGustFactorEnvironmentalSensingConfiguration(int, EnvironmentalSensingConfiguration)
     */
    @Nullable
    public synchronized Integer setGustFactorEnvironmentalSensingConfiguration(int index, @NonNull EnvironmentalSensingConfiguration environmentalSensingConfiguration) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.setGustFactorEnvironmentalSensingConfiguration(index, environmentalSensingConfiguration);
        }
        return taskId;
    }

    /**
     * @see #getGustFactorCharacteristicUserDescription(int)
     */
    @Nullable
    public synchronized Integer getGustFactorCharacteristicUserDescription() {
        return getGustFactorCharacteristicUserDescription(0);
    }

    /**
     * @see EnvironmentalSensingService#getGustFactorCharacteristicUserDescription(int)
     */
    @Nullable
    public synchronized Integer getGustFactorCharacteristicUserDescription(int index) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.getGustFactorCharacteristicUserDescription(index);
        }
        return taskId;
    }

    /**
     * @see #setGustFactorCharacteristicUserDescription(int, CharacteristicUserDescription)
     */
    @Nullable
    public synchronized Integer setGustFactorCharacteristicUserDescription(@NonNull CharacteristicUserDescription characteristicUserDescription) {
        return setGustFactorCharacteristicUserDescription(0, characteristicUserDescription);
    }

    /**
     * @see EnvironmentalSensingService#setGustFactorCharacteristicUserDescription(int, CharacteristicUserDescription)
     */
    @Nullable
    public synchronized Integer setGustFactorCharacteristicUserDescription(int index, @NonNull CharacteristicUserDescription characteristicUserDescription) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.setGustFactorCharacteristicUserDescription(index, characteristicUserDescription);
        }
        return taskId;
    }

    /**
     * @see #getGustFactorValidRange(int)
     */
    @Nullable
    public synchronized Integer getGustFactorValidRange() {
        return getGustFactorValidRange(0);
    }

    /**
     * @see EnvironmentalSensingService#getGustFactorValidRange(int)
     */
    @Nullable
    public synchronized Integer getGustFactorValidRange(int index) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.getGustFactorValidRange(index);
        }
        return taskId;
    }

    /**
     * @see EnvironmentalSensingService#getHeatIndexCount()
     */
    @Nullable
    public synchronized Integer getHeatIndexCount() {
        Integer count = null;
        if (mEnvironmentalSensingService != null) {
            count = mEnvironmentalSensingService.getHeatIndexCount();
        }
        return count;
    }

    /**
     * @see #canHeatIndexNotify(int)
     */
    public synchronized Boolean canHeatIndexNotify() {
        return canHeatIndexNotify(0);
    }

    /**
     * @see EnvironmentalSensingService#canHeatIndexNotify(int)
     */
    public synchronized Boolean canHeatIndexNotify(int index) {
        Boolean result = null;
        if (mEnvironmentalSensingService != null) {
            result = mEnvironmentalSensingService.canHeatIndexNotify(index);
        }
        return result;
    }

    /**
     * @see #hasHeatIndexCharacteristicEnvironmentalSensingMeasurement(int)
     */
    public synchronized Boolean hasHeatIndexCharacteristicEnvironmentalSensingMeasurement() {
        return hasHeatIndexCharacteristicEnvironmentalSensingMeasurement(0);
    }

    /**
     * @see EnvironmentalSensingService#hasHeatIndexCharacteristicEnvironmentalSensingMeasurement(int)
     */
    public synchronized Boolean hasHeatIndexCharacteristicEnvironmentalSensingMeasurement(int index) {
        Boolean result = null;
        if (mEnvironmentalSensingService != null) {
            result = mEnvironmentalSensingService.hasHeatIndexCharacteristicEnvironmentalSensingMeasurement(index);
        }
        return result;
    }

    /**
     * @see #getHeatIndexCharacteristicEnvironmentalSensingTriggerSettingCount(int)
     */
    public synchronized Integer getHeatIndexCharacteristicEnvironmentalSensingTriggerSettingCount() {
        return getHeatIndexCharacteristicEnvironmentalSensingTriggerSettingCount(0);
    }

    /**
     * @see EnvironmentalSensingService#getHeatIndexCharacteristicEnvironmentalSensingTriggerSettingCount(int)
     */
    @Nullable
    public synchronized Integer getHeatIndexCharacteristicEnvironmentalSensingTriggerSettingCount(int index) {
        Integer count = null;
        if (mEnvironmentalSensingService != null) {
            count = mEnvironmentalSensingService.getHeatIndexCharacteristicEnvironmentalSensingTriggerSettingCount(index);
        }
        return count;
    }

    /**
     * @see #hasHeatIndexCharacteristicEnvironmentalSensingConfiguration(int)
     */
    public synchronized Boolean hasHeatIndexCharacteristicEnvironmentalSensingConfiguration() {
        return hasHeatIndexCharacteristicEnvironmentalSensingConfiguration(0);
    }

    /**
     * @see EnvironmentalSensingService#hasHeatIndexCharacteristicEnvironmentalSensingConfiguration(int)
     */
    public synchronized Boolean hasHeatIndexCharacteristicEnvironmentalSensingConfiguration(int index) {
        Boolean result = null;
        if (mEnvironmentalSensingService != null) {
            result = mEnvironmentalSensingService.hasHeatIndexCharacteristicEnvironmentalSensingConfiguration(index);
        }
        return result;
    }

    /**
     * @see #hasHeatIndexCharacteristicCharacteristicUserDescription(int)
     */
    public synchronized Boolean hasHeatIndexCharacteristicCharacteristicUserDescription() {
        return hasHeatIndexCharacteristicCharacteristicUserDescription(0);
    }

    /**
     * @see EnvironmentalSensingService#hasHeatIndexCharacteristicCharacteristicUserDescription(int)
     */
    public synchronized Boolean hasHeatIndexCharacteristicCharacteristicUserDescription(int index) {
        Boolean result = null;
        if (mEnvironmentalSensingService != null) {
            result = mEnvironmentalSensingService.hasHeatIndexCharacteristicCharacteristicUserDescription(index);
        }
        return result;
    }

    /**
     * @see #hasHeatIndexCharacteristicValidRange(int)
     */
    public synchronized Boolean hasHeatIndexCharacteristicValidRange() {
        return hasHeatIndexCharacteristicValidRange(0);
    }

    /**
     * @see EnvironmentalSensingService#hasHeatIndexCharacteristicValidRange(int)
     */
    public synchronized Boolean hasHeatIndexCharacteristicValidRange(int index) {
        Boolean result = null;
        if (mEnvironmentalSensingService != null) {
            result = mEnvironmentalSensingService.hasHeatIndexCharacteristicValidRange(index);
        }
        return result;
    }

    /**
     * @see #getHeatIndex(int)
     */
    @Nullable
    public synchronized Integer getHeatIndex() {
        return getHeatIndex(0);
    }

    /**
     * @see EnvironmentalSensingService#getHeatIndex(int)
     */
    @Nullable
    public synchronized Integer getHeatIndex(int index) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.getHeatIndex(index);
        }
        return taskId;
    }

    /**
     * @see #startHeatIndexNotification(int)
     */
    @Nullable
    public synchronized Integer startHeatIndexNotification() {
        return startHeatIndexNotification(0);
    }

    /**
     * @see EnvironmentalSensingService#startHeatIndexNotification(int)
     */
    @Nullable
    public synchronized Integer startHeatIndexNotification(int index) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.startHeatIndexNotification(index);
        }
        return taskId;
    }

    /**
     * @see #startHeatIndexNotification(int)
     */
    @Nullable
    public synchronized Integer stopHeatIndexNotification() {
        return stopHeatIndexNotification(0);
    }

    /**
     * @see EnvironmentalSensingService#stopHeatIndexNotification(int)
     */
    @Nullable
    public synchronized Integer stopHeatIndexNotification(int index) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.stopHeatIndexNotification(index);
        }
        return taskId;
    }

    /**
     * @see #getHeatIndexEnvironmentalSensingMeasurement(int)
     */
    @Nullable
    public synchronized Integer getHeatIndexEnvironmentalSensingMeasurement() {
        return getHeatIndexEnvironmentalSensingMeasurement(0);
    }

    /**
     * @see EnvironmentalSensingService#getHeatIndexEnvironmentalSensingMeasurement(int)
     */
    @Nullable
    public synchronized Integer getHeatIndexEnvironmentalSensingMeasurement(int index) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.getHeatIndexEnvironmentalSensingMeasurement(index);
        }
        return taskId;
    }

    /**
     * @see #getHeatIndexEnvironmentalSensingTriggerSetting(int, int)
     */
    @Nullable
    public synchronized Integer getHeatIndexEnvironmentalSensingTriggerSetting() {
        return getHeatIndexEnvironmentalSensingTriggerSetting(0, 0);
    }

    /**
     * @see EnvironmentalSensingService#getHeatIndexEnvironmentalSensingTriggerSetting(int, int)
     */
    @Nullable
    public synchronized Integer getHeatIndexEnvironmentalSensingTriggerSetting(int characteristicIndex, int descriptorIndex) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.getHeatIndexEnvironmentalSensingTriggerSetting(characteristicIndex, descriptorIndex);
        }
        return taskId;
    }

    /**
     * @see #setHeatIndexEnvironmentalSensingTriggerSetting(int, int, EnvironmentalSensingTriggerSetting)
     */
    @Nullable
    public synchronized Integer setHeatIndexEnvironmentalSensingTriggerSetting(@NonNull EnvironmentalSensingTriggerSetting environmentalSensingTriggerSetting) {
        return setHeatIndexEnvironmentalSensingTriggerSetting(0, 0, environmentalSensingTriggerSetting);
    }

    /**
     * @see EnvironmentalSensingService#setHeatIndexEnvironmentalSensingTriggerSetting(int, int, EnvironmentalSensingTriggerSetting)
     */
    @Nullable
    public synchronized Integer setHeatIndexEnvironmentalSensingTriggerSetting(int characteristicIndex, int descriptorIndex, @NonNull EnvironmentalSensingTriggerSetting environmentalSensingTriggerSetting) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.setHeatIndexEnvironmentalSensingTriggerSetting(characteristicIndex, descriptorIndex, environmentalSensingTriggerSetting);
        }
        return taskId;
    }

    /**
     * @see #getHeatIndexEnvironmentalSensingConfiguration(int)
     */
    @Nullable
    public synchronized Integer getHeatIndexEnvironmentalSensingConfiguration() {
        return getHeatIndexEnvironmentalSensingConfiguration(0);
    }

    /**
     * @see EnvironmentalSensingService#getHeatIndexEnvironmentalSensingConfiguration(int)
     */
    @Nullable
    public synchronized Integer getHeatIndexEnvironmentalSensingConfiguration(int index) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.getHeatIndexEnvironmentalSensingConfiguration(index);
        }
        return taskId;
    }

    /**
     * @see #setHeatIndexEnvironmentalSensingConfiguration(int, EnvironmentalSensingConfiguration)
     */
    @Nullable
    public synchronized Integer setHeatIndexEnvironmentalSensingConfiguration(@NonNull EnvironmentalSensingConfiguration environmentalSensingConfiguration) {
        return setHeatIndexEnvironmentalSensingConfiguration(0, environmentalSensingConfiguration);
    }

    /**
     * @see EnvironmentalSensingService#setHeatIndexEnvironmentalSensingConfiguration(int, EnvironmentalSensingConfiguration)
     */
    @Nullable
    public synchronized Integer setHeatIndexEnvironmentalSensingConfiguration(int index, @NonNull EnvironmentalSensingConfiguration environmentalSensingConfiguration) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.setHeatIndexEnvironmentalSensingConfiguration(index, environmentalSensingConfiguration);
        }
        return taskId;
    }

    /**
     * @see #getHeatIndexCharacteristicUserDescription(int)
     */
    @Nullable
    public synchronized Integer getHeatIndexCharacteristicUserDescription() {
        return getHeatIndexCharacteristicUserDescription(0);
    }

    /**
     * @see EnvironmentalSensingService#getHeatIndexCharacteristicUserDescription(int)
     */
    @Nullable
    public synchronized Integer getHeatIndexCharacteristicUserDescription(int index) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.getHeatIndexCharacteristicUserDescription(index);
        }
        return taskId;
    }

    /**
     * @see #setHeatIndexCharacteristicUserDescription(int, CharacteristicUserDescription)
     */
    @Nullable
    public synchronized Integer setHeatIndexCharacteristicUserDescription(@NonNull CharacteristicUserDescription characteristicUserDescription) {
        return setHeatIndexCharacteristicUserDescription(0, characteristicUserDescription);
    }

    /**
     * @see EnvironmentalSensingService#setHeatIndexCharacteristicUserDescription(int, CharacteristicUserDescription)
     */
    @Nullable
    public synchronized Integer setHeatIndexCharacteristicUserDescription(int index, @NonNull CharacteristicUserDescription characteristicUserDescription) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.setHeatIndexCharacteristicUserDescription(index, characteristicUserDescription);
        }
        return taskId;
    }

    /**
     * @see #getHeatIndexValidRange(int)
     */
    @Nullable
    public synchronized Integer getHeatIndexValidRange() {
        return getHeatIndexValidRange(0);
    }

    /**
     * @see EnvironmentalSensingService#getHeatIndexValidRange(int)
     */
    @Nullable
    public synchronized Integer getHeatIndexValidRange(int index) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.getHeatIndexValidRange(index);
        }
        return taskId;
    }

    /**
     * @see EnvironmentalSensingService#getHumidityCount()
     */
    @Nullable
    public synchronized Integer getHumidityCount() {
        Integer count = null;
        if (mEnvironmentalSensingService != null) {
            count = mEnvironmentalSensingService.getHumidityCount();
        }
        return count;
    }

    /**
     * @see #canHumidityNotify(int)
     */
    public synchronized Boolean canHumidityNotify() {
        return canHumidityNotify(0);
    }

    /**
     * @see EnvironmentalSensingService#canHumidityNotify(int)
     */
    public synchronized Boolean canHumidityNotify(int index) {
        Boolean result = null;
        if (mEnvironmentalSensingService != null) {
            result = mEnvironmentalSensingService.canHumidityNotify(index);
        }
        return result;
    }

    /**
     * @see #hasHumidityCharacteristicEnvironmentalSensingMeasurement(int)
     */
    public synchronized Boolean hasHumidityCharacteristicEnvironmentalSensingMeasurement() {
        return hasHumidityCharacteristicEnvironmentalSensingMeasurement(0);
    }

    /**
     * @see EnvironmentalSensingService#hasHumidityCharacteristicEnvironmentalSensingMeasurement(int)
     */
    public synchronized Boolean hasHumidityCharacteristicEnvironmentalSensingMeasurement(int index) {
        Boolean result = null;
        if (mEnvironmentalSensingService != null) {
            result = mEnvironmentalSensingService.hasHumidityCharacteristicEnvironmentalSensingMeasurement(index);
        }
        return result;
    }

    /**
     * @see #getHumidityCharacteristicEnvironmentalSensingTriggerSettingCount(int)
     */
    public synchronized Integer getHumidityCharacteristicEnvironmentalSensingTriggerSettingCount() {
        return getHumidityCharacteristicEnvironmentalSensingTriggerSettingCount(0);
    }

    /**
     * @see EnvironmentalSensingService#getHumidityCharacteristicEnvironmentalSensingTriggerSettingCount(int)
     */
    @Nullable
    public synchronized Integer getHumidityCharacteristicEnvironmentalSensingTriggerSettingCount(int index) {
        Integer count = null;
        if (mEnvironmentalSensingService != null) {
            count = mEnvironmentalSensingService.getHumidityCharacteristicEnvironmentalSensingTriggerSettingCount(index);
        }
        return count;
    }

    /**
     * @see #hasHumidityCharacteristicEnvironmentalSensingConfiguration(int)
     */
    public synchronized Boolean hasHumidityCharacteristicEnvironmentalSensingConfiguration() {
        return hasHumidityCharacteristicEnvironmentalSensingConfiguration(0);
    }

    /**
     * @see EnvironmentalSensingService#hasHumidityCharacteristicEnvironmentalSensingConfiguration(int)
     */
    public synchronized Boolean hasHumidityCharacteristicEnvironmentalSensingConfiguration(int index) {
        Boolean result = null;
        if (mEnvironmentalSensingService != null) {
            result = mEnvironmentalSensingService.hasHumidityCharacteristicEnvironmentalSensingConfiguration(index);
        }
        return result;
    }

    /**
     * @see #hasHumidityCharacteristicCharacteristicUserDescription(int)
     */
    public synchronized Boolean hasHumidityCharacteristicCharacteristicUserDescription() {
        return hasHumidityCharacteristicCharacteristicUserDescription(0);
    }

    /**
     * @see EnvironmentalSensingService#hasHumidityCharacteristicCharacteristicUserDescription(int)
     */
    public synchronized Boolean hasHumidityCharacteristicCharacteristicUserDescription(int index) {
        Boolean result = null;
        if (mEnvironmentalSensingService != null) {
            result = mEnvironmentalSensingService.hasHumidityCharacteristicCharacteristicUserDescription(index);
        }
        return result;
    }

    /**
     * @see #hasHumidityCharacteristicValidRange(int)
     */
    public synchronized Boolean hasHumidityCharacteristicValidRange() {
        return hasHumidityCharacteristicValidRange(0);
    }

    /**
     * @see EnvironmentalSensingService#hasHumidityCharacteristicValidRange(int)
     */
    public synchronized Boolean hasHumidityCharacteristicValidRange(int index) {
        Boolean result = null;
        if (mEnvironmentalSensingService != null) {
            result = mEnvironmentalSensingService.hasHumidityCharacteristicValidRange(index);
        }
        return result;
    }

    /**
     * @see #getHumidity(int)
     */
    @Nullable
    public synchronized Integer getHumidity() {
        return getHumidity(0);
    }

    /**
     * @see EnvironmentalSensingService#getHumidity(int)
     */
    @Nullable
    public synchronized Integer getHumidity(int index) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.getHumidity(index);
        }
        return taskId;
    }

    /**
     * @see #startHumidityNotification(int)
     */
    @Nullable
    public synchronized Integer startHumidityNotification() {
        return startHumidityNotification(0);
    }

    /**
     * @see EnvironmentalSensingService#startHumidityNotification(int)
     */
    @Nullable
    public synchronized Integer startHumidityNotification(int index) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.startHumidityNotification(index);
        }
        return taskId;
    }

    /**
     * @see #startHumidityNotification(int)
     */
    @Nullable
    public synchronized Integer stopHumidityNotification() {
        return stopHumidityNotification(0);
    }

    /**
     * @see EnvironmentalSensingService#stopHumidityNotification(int)
     */
    @Nullable
    public synchronized Integer stopHumidityNotification(int index) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.stopHumidityNotification(index);
        }
        return taskId;
    }

    /**
     * @see #getHumidityEnvironmentalSensingMeasurement(int)
     */
    @Nullable
    public synchronized Integer getHumidityEnvironmentalSensingMeasurement() {
        return getHumidityEnvironmentalSensingMeasurement(0);
    }

    /**
     * @see EnvironmentalSensingService#getHumidityEnvironmentalSensingMeasurement(int)
     */
    @Nullable
    public synchronized Integer getHumidityEnvironmentalSensingMeasurement(int index) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.getHumidityEnvironmentalSensingMeasurement(index);
        }
        return taskId;
    }

    /**
     * @see #getHumidityEnvironmentalSensingTriggerSetting(int, int)
     */
    @Nullable
    public synchronized Integer getHumidityEnvironmentalSensingTriggerSetting() {
        return getHumidityEnvironmentalSensingTriggerSetting(0, 0);
    }

    /**
     * @see EnvironmentalSensingService#getHumidityEnvironmentalSensingTriggerSetting(int, int)
     */
    @Nullable
    public synchronized Integer getHumidityEnvironmentalSensingTriggerSetting(int characteristicIndex, int descriptorIndex) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.getHumidityEnvironmentalSensingTriggerSetting(characteristicIndex, descriptorIndex);
        }
        return taskId;
    }

    /**
     * @see #setHumidityEnvironmentalSensingTriggerSetting(int, int, EnvironmentalSensingTriggerSetting)
     */
    @Nullable
    public synchronized Integer setHumidityEnvironmentalSensingTriggerSetting(@NonNull EnvironmentalSensingTriggerSetting environmentalSensingTriggerSetting) {
        return setHumidityEnvironmentalSensingTriggerSetting(0, 0, environmentalSensingTriggerSetting);
    }

    /**
     * @see EnvironmentalSensingService#setHumidityEnvironmentalSensingTriggerSetting(int, int, EnvironmentalSensingTriggerSetting)
     */
    @Nullable
    public synchronized Integer setHumidityEnvironmentalSensingTriggerSetting(int characteristicIndex, int descriptorIndex, @NonNull EnvironmentalSensingTriggerSetting environmentalSensingTriggerSetting) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.setHumidityEnvironmentalSensingTriggerSetting(characteristicIndex, descriptorIndex, environmentalSensingTriggerSetting);
        }
        return taskId;
    }

    /**
     * @see #getHumidityEnvironmentalSensingConfiguration(int)
     */
    @Nullable
    public synchronized Integer getHumidityEnvironmentalSensingConfiguration() {
        return getHumidityEnvironmentalSensingConfiguration(0);
    }

    /**
     * @see EnvironmentalSensingService#getHumidityEnvironmentalSensingConfiguration(int)
     */
    @Nullable
    public synchronized Integer getHumidityEnvironmentalSensingConfiguration(int index) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.getHumidityEnvironmentalSensingConfiguration(index);
        }
        return taskId;
    }

    /**
     * @see #setHumidityEnvironmentalSensingConfiguration(int, EnvironmentalSensingConfiguration)
     */
    @Nullable
    public synchronized Integer setHumidityEnvironmentalSensingConfiguration(@NonNull EnvironmentalSensingConfiguration environmentalSensingConfiguration) {
        return setHumidityEnvironmentalSensingConfiguration(0, environmentalSensingConfiguration);
    }

    /**
     * @see EnvironmentalSensingService#setHumidityEnvironmentalSensingConfiguration(int, EnvironmentalSensingConfiguration)
     */
    @Nullable
    public synchronized Integer setHumidityEnvironmentalSensingConfiguration(int index, @NonNull EnvironmentalSensingConfiguration environmentalSensingConfiguration) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.setHumidityEnvironmentalSensingConfiguration(index, environmentalSensingConfiguration);
        }
        return taskId;
    }

    /**
     * @see #getHumidityCharacteristicUserDescription(int)
     */
    @Nullable
    public synchronized Integer getHumidityCharacteristicUserDescription() {
        return getHumidityCharacteristicUserDescription(0);
    }

    /**
     * @see EnvironmentalSensingService#getHumidityCharacteristicUserDescription(int)
     */
    @Nullable
    public synchronized Integer getHumidityCharacteristicUserDescription(int index) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.getHumidityCharacteristicUserDescription(index);
        }
        return taskId;
    }

    /**
     * @see #setHumidityCharacteristicUserDescription(int, CharacteristicUserDescription)
     */
    @Nullable
    public synchronized Integer setHumidityCharacteristicUserDescription(@NonNull CharacteristicUserDescription characteristicUserDescription) {
        return setHumidityCharacteristicUserDescription(0, characteristicUserDescription);
    }

    /**
     * @see EnvironmentalSensingService#setHumidityCharacteristicUserDescription(int, CharacteristicUserDescription)
     */
    @Nullable
    public synchronized Integer setHumidityCharacteristicUserDescription(int index, @NonNull CharacteristicUserDescription characteristicUserDescription) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.setHumidityCharacteristicUserDescription(index, characteristicUserDescription);
        }
        return taskId;
    }

    /**
     * @see #getHumidityValidRange(int)
     */
    @Nullable
    public synchronized Integer getHumidityValidRange() {
        return getHumidityValidRange(0);
    }

    /**
     * @see EnvironmentalSensingService#getHumidityValidRange(int)
     */
    @Nullable
    public synchronized Integer getHumidityValidRange(int index) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.getHumidityValidRange(index);
        }
        return taskId;
    }

    /**
     * @see EnvironmentalSensingService#getIrradianceCount()
     */
    @Nullable
    public synchronized Integer getIrradianceCount() {
        Integer count = null;
        if (mEnvironmentalSensingService != null) {
            count = mEnvironmentalSensingService.getIrradianceCount();
        }
        return count;
    }

    /**
     * @see #canIrradianceNotify(int)
     */
    public synchronized Boolean canIrradianceNotify() {
        return canIrradianceNotify(0);
    }

    /**
     * @see EnvironmentalSensingService#canIrradianceNotify(int)
     */
    public synchronized Boolean canIrradianceNotify(int index) {
        Boolean result = null;
        if (mEnvironmentalSensingService != null) {
            result = mEnvironmentalSensingService.canIrradianceNotify(index);
        }
        return result;
    }

    /**
     * @see #hasIrradianceCharacteristicEnvironmentalSensingMeasurement(int)
     */
    public synchronized Boolean hasIrradianceCharacteristicEnvironmentalSensingMeasurement() {
        return hasIrradianceCharacteristicEnvironmentalSensingMeasurement(0);
    }

    /**
     * @see EnvironmentalSensingService#hasIrradianceCharacteristicEnvironmentalSensingMeasurement(int)
     */
    public synchronized Boolean hasIrradianceCharacteristicEnvironmentalSensingMeasurement(int index) {
        Boolean result = null;
        if (mEnvironmentalSensingService != null) {
            result = mEnvironmentalSensingService.hasIrradianceCharacteristicEnvironmentalSensingMeasurement(index);
        }
        return result;
    }

    /**
     * @see #getIrradianceCharacteristicEnvironmentalSensingTriggerSettingCount(int)
     */
    public synchronized Integer getIrradianceCharacteristicEnvironmentalSensingTriggerSettingCount() {
        return getIrradianceCharacteristicEnvironmentalSensingTriggerSettingCount(0);
    }

    /**
     * @see EnvironmentalSensingService#getIrradianceCharacteristicEnvironmentalSensingTriggerSettingCount(int)
     */
    @Nullable
    public synchronized Integer getIrradianceCharacteristicEnvironmentalSensingTriggerSettingCount(int index) {
        Integer count = null;
        if (mEnvironmentalSensingService != null) {
            count = mEnvironmentalSensingService.getIrradianceCharacteristicEnvironmentalSensingTriggerSettingCount(index);
        }
        return count;
    }

    /**
     * @see #hasIrradianceCharacteristicEnvironmentalSensingConfiguration(int)
     */
    public synchronized Boolean hasIrradianceCharacteristicEnvironmentalSensingConfiguration() {
        return hasIrradianceCharacteristicEnvironmentalSensingConfiguration(0);
    }

    /**
     * @see EnvironmentalSensingService#hasIrradianceCharacteristicEnvironmentalSensingConfiguration(int)
     */
    public synchronized Boolean hasIrradianceCharacteristicEnvironmentalSensingConfiguration(int index) {
        Boolean result = null;
        if (mEnvironmentalSensingService != null) {
            result = mEnvironmentalSensingService.hasIrradianceCharacteristicEnvironmentalSensingConfiguration(index);
        }
        return result;
    }

    /**
     * @see #hasIrradianceCharacteristicCharacteristicUserDescription(int)
     */
    public synchronized Boolean hasIrradianceCharacteristicCharacteristicUserDescription() {
        return hasIrradianceCharacteristicCharacteristicUserDescription(0);
    }

    /**
     * @see EnvironmentalSensingService#hasIrradianceCharacteristicCharacteristicUserDescription(int)
     */
    public synchronized Boolean hasIrradianceCharacteristicCharacteristicUserDescription(int index) {
        Boolean result = null;
        if (mEnvironmentalSensingService != null) {
            result = mEnvironmentalSensingService.hasIrradianceCharacteristicCharacteristicUserDescription(index);
        }
        return result;
    }

    /**
     * @see #hasIrradianceCharacteristicValidRange(int)
     */
    public synchronized Boolean hasIrradianceCharacteristicValidRange() {
        return hasIrradianceCharacteristicValidRange(0);
    }

    /**
     * @see EnvironmentalSensingService#hasIrradianceCharacteristicValidRange(int)
     */
    public synchronized Boolean hasIrradianceCharacteristicValidRange(int index) {
        Boolean result = null;
        if (mEnvironmentalSensingService != null) {
            result = mEnvironmentalSensingService.hasIrradianceCharacteristicValidRange(index);
        }
        return result;
    }

    /**
     * @see #getIrradiance(int)
     */
    @Nullable
    public synchronized Integer getIrradiance() {
        return getIrradiance(0);
    }

    /**
     * @see EnvironmentalSensingService#getIrradiance(int)
     */
    @Nullable
    public synchronized Integer getIrradiance(int index) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.getIrradiance(index);
        }
        return taskId;
    }

    /**
     * @see #startIrradianceNotification(int)
     */
    @Nullable
    public synchronized Integer startIrradianceNotification() {
        return startIrradianceNotification(0);
    }

    /**
     * @see EnvironmentalSensingService#startIrradianceNotification(int)
     */
    @Nullable
    public synchronized Integer startIrradianceNotification(int index) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.startIrradianceNotification(index);
        }
        return taskId;
    }

    /**
     * @see #startIrradianceNotification(int)
     */
    @Nullable
    public synchronized Integer stopIrradianceNotification() {
        return stopIrradianceNotification(0);
    }

    /**
     * @see EnvironmentalSensingService#stopIrradianceNotification(int)
     */
    @Nullable
    public synchronized Integer stopIrradianceNotification(int index) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.stopIrradianceNotification(index);
        }
        return taskId;
    }

    /**
     * @see #getIrradianceEnvironmentalSensingMeasurement(int)
     */
    @Nullable
    public synchronized Integer getIrradianceEnvironmentalSensingMeasurement() {
        return getIrradianceEnvironmentalSensingMeasurement(0);
    }

    /**
     * @see EnvironmentalSensingService#getIrradianceEnvironmentalSensingMeasurement(int)
     */
    @Nullable
    public synchronized Integer getIrradianceEnvironmentalSensingMeasurement(int index) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.getIrradianceEnvironmentalSensingMeasurement(index);
        }
        return taskId;
    }

    /**
     * @see #getIrradianceEnvironmentalSensingTriggerSetting(int, int)
     */
    @Nullable
    public synchronized Integer getIrradianceEnvironmentalSensingTriggerSetting() {
        return getIrradianceEnvironmentalSensingTriggerSetting(0, 0);
    }

    /**
     * @see EnvironmentalSensingService#getIrradianceEnvironmentalSensingTriggerSetting(int, int)
     */
    @Nullable
    public synchronized Integer getIrradianceEnvironmentalSensingTriggerSetting(int characteristicIndex, int descriptorIndex) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.getIrradianceEnvironmentalSensingTriggerSetting(characteristicIndex, descriptorIndex);
        }
        return taskId;
    }

    /**
     * @see #setIrradianceEnvironmentalSensingTriggerSetting(int, int, EnvironmentalSensingTriggerSetting)
     */
    @Nullable
    public synchronized Integer setIrradianceEnvironmentalSensingTriggerSetting(@NonNull EnvironmentalSensingTriggerSetting environmentalSensingTriggerSetting) {
        return setIrradianceEnvironmentalSensingTriggerSetting(0, 0, environmentalSensingTriggerSetting);
    }

    /**
     * @see EnvironmentalSensingService#setIrradianceEnvironmentalSensingTriggerSetting(int, int, EnvironmentalSensingTriggerSetting)
     */
    @Nullable
    public synchronized Integer setIrradianceEnvironmentalSensingTriggerSetting(int characteristicIndex, int descriptorIndex, @NonNull EnvironmentalSensingTriggerSetting environmentalSensingTriggerSetting) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.setIrradianceEnvironmentalSensingTriggerSetting(characteristicIndex, descriptorIndex, environmentalSensingTriggerSetting);
        }
        return taskId;
    }

    /**
     * @see #getIrradianceEnvironmentalSensingConfiguration(int)
     */
    @Nullable
    public synchronized Integer getIrradianceEnvironmentalSensingConfiguration() {
        return getIrradianceEnvironmentalSensingConfiguration(0);
    }

    /**
     * @see EnvironmentalSensingService#getIrradianceEnvironmentalSensingConfiguration(int)
     */
    @Nullable
    public synchronized Integer getIrradianceEnvironmentalSensingConfiguration(int index) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.getIrradianceEnvironmentalSensingConfiguration(index);
        }
        return taskId;
    }

    /**
     * @see #setIrradianceEnvironmentalSensingConfiguration(int, EnvironmentalSensingConfiguration)
     */
    @Nullable
    public synchronized Integer setIrradianceEnvironmentalSensingConfiguration(@NonNull EnvironmentalSensingConfiguration environmentalSensingConfiguration) {
        return setIrradianceEnvironmentalSensingConfiguration(0, environmentalSensingConfiguration);
    }

    /**
     * @see EnvironmentalSensingService#setIrradianceEnvironmentalSensingConfiguration(int, EnvironmentalSensingConfiguration)
     */
    @Nullable
    public synchronized Integer setIrradianceEnvironmentalSensingConfiguration(int index, @NonNull EnvironmentalSensingConfiguration environmentalSensingConfiguration) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.setIrradianceEnvironmentalSensingConfiguration(index, environmentalSensingConfiguration);
        }
        return taskId;
    }

    /**
     * @see #getIrradianceCharacteristicUserDescription(int)
     */
    @Nullable
    public synchronized Integer getIrradianceCharacteristicUserDescription() {
        return getIrradianceCharacteristicUserDescription(0);
    }

    /**
     * @see EnvironmentalSensingService#getIrradianceCharacteristicUserDescription(int)
     */
    @Nullable
    public synchronized Integer getIrradianceCharacteristicUserDescription(int index) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.getIrradianceCharacteristicUserDescription(index);
        }
        return taskId;
    }

    /**
     * @see #setIrradianceCharacteristicUserDescription(int, CharacteristicUserDescription)
     */
    @Nullable
    public synchronized Integer setIrradianceCharacteristicUserDescription(@NonNull CharacteristicUserDescription characteristicUserDescription) {
        return setIrradianceCharacteristicUserDescription(0, characteristicUserDescription);
    }

    /**
     * @see EnvironmentalSensingService#setIrradianceCharacteristicUserDescription(int, CharacteristicUserDescription)
     */
    @Nullable
    public synchronized Integer setIrradianceCharacteristicUserDescription(int index, @NonNull CharacteristicUserDescription characteristicUserDescription) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.setIrradianceCharacteristicUserDescription(index, characteristicUserDescription);
        }
        return taskId;
    }

    /**
     * @see #getIrradianceValidRange(int)
     */
    @Nullable
    public synchronized Integer getIrradianceValidRange() {
        return getIrradianceValidRange(0);
    }

    /**
     * @see EnvironmentalSensingService#getIrradianceValidRange(int)
     */
    @Nullable
    public synchronized Integer getIrradianceValidRange(int index) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.getIrradianceValidRange(index);
        }
        return taskId;
    }

    /**
     * @see EnvironmentalSensingService#getMagneticDeclinationCount()
     */
    @Nullable
    public synchronized Integer getMagneticDeclinationCount() {
        Integer count = null;
        if (mEnvironmentalSensingService != null) {
            count = mEnvironmentalSensingService.getMagneticDeclinationCount();
        }
        return count;
    }

    /**
     * @see #canMagneticDeclinationNotify(int)
     */
    public synchronized Boolean canMagneticDeclinationNotify() {
        return canMagneticDeclinationNotify(0);
    }

    /**
     * @see EnvironmentalSensingService#canMagneticDeclinationNotify(int)
     */
    public synchronized Boolean canMagneticDeclinationNotify(int index) {
        Boolean result = null;
        if (mEnvironmentalSensingService != null) {
            result = mEnvironmentalSensingService.canMagneticDeclinationNotify(index);
        }
        return result;
    }

    /**
     * @see #hasMagneticDeclinationCharacteristicEnvironmentalSensingMeasurement(int)
     */
    public synchronized Boolean hasMagneticDeclinationCharacteristicEnvironmentalSensingMeasurement() {
        return hasMagneticDeclinationCharacteristicEnvironmentalSensingMeasurement(0);
    }

    /**
     * @see EnvironmentalSensingService#hasMagneticDeclinationCharacteristicEnvironmentalSensingMeasurement(int)
     */
    public synchronized Boolean hasMagneticDeclinationCharacteristicEnvironmentalSensingMeasurement(int index) {
        Boolean result = null;
        if (mEnvironmentalSensingService != null) {
            result = mEnvironmentalSensingService.hasMagneticDeclinationCharacteristicEnvironmentalSensingMeasurement(index);
        }
        return result;
    }

    /**
     * @see #getMagneticDeclinationCharacteristicEnvironmentalSensingTriggerSettingCount(int)
     */
    public synchronized Integer getMagneticDeclinationCharacteristicEnvironmentalSensingTriggerSettingCount() {
        return getMagneticDeclinationCharacteristicEnvironmentalSensingTriggerSettingCount(0);
    }

    /**
     * @see EnvironmentalSensingService#getMagneticDeclinationCharacteristicEnvironmentalSensingTriggerSettingCount(int)
     */
    @Nullable
    public synchronized Integer getMagneticDeclinationCharacteristicEnvironmentalSensingTriggerSettingCount(int index) {
        Integer count = null;
        if (mEnvironmentalSensingService != null) {
            count = mEnvironmentalSensingService.getMagneticDeclinationCharacteristicEnvironmentalSensingTriggerSettingCount(index);
        }
        return count;
    }

    /**
     * @see #hasMagneticDeclinationCharacteristicEnvironmentalSensingConfiguration(int)
     */
    public synchronized Boolean hasMagneticDeclinationCharacteristicEnvironmentalSensingConfiguration() {
        return hasMagneticDeclinationCharacteristicEnvironmentalSensingConfiguration(0);
    }

    /**
     * @see EnvironmentalSensingService#hasMagneticDeclinationCharacteristicEnvironmentalSensingConfiguration(int)
     */
    public synchronized Boolean hasMagneticDeclinationCharacteristicEnvironmentalSensingConfiguration(int index) {
        Boolean result = null;
        if (mEnvironmentalSensingService != null) {
            result = mEnvironmentalSensingService.hasMagneticDeclinationCharacteristicEnvironmentalSensingConfiguration(index);
        }
        return result;
    }

    /**
     * @see #hasMagneticDeclinationCharacteristicCharacteristicUserDescription(int)
     */
    public synchronized Boolean hasMagneticDeclinationCharacteristicCharacteristicUserDescription() {
        return hasMagneticDeclinationCharacteristicCharacteristicUserDescription(0);
    }

    /**
     * @see EnvironmentalSensingService#hasMagneticDeclinationCharacteristicCharacteristicUserDescription(int)
     */
    public synchronized Boolean hasMagneticDeclinationCharacteristicCharacteristicUserDescription(int index) {
        Boolean result = null;
        if (mEnvironmentalSensingService != null) {
            result = mEnvironmentalSensingService.hasMagneticDeclinationCharacteristicCharacteristicUserDescription(index);
        }
        return result;
    }

    /**
     * @see #hasMagneticDeclinationCharacteristicValidRange(int)
     */
    public synchronized Boolean hasMagneticDeclinationCharacteristicValidRange() {
        return hasMagneticDeclinationCharacteristicValidRange(0);
    }

    /**
     * @see EnvironmentalSensingService#hasMagneticDeclinationCharacteristicValidRange(int)
     */
    public synchronized Boolean hasMagneticDeclinationCharacteristicValidRange(int index) {
        Boolean result = null;
        if (mEnvironmentalSensingService != null) {
            result = mEnvironmentalSensingService.hasMagneticDeclinationCharacteristicValidRange(index);
        }
        return result;
    }

    /**
     * @see #getMagneticDeclination(int)
     */
    @Nullable
    public synchronized Integer getMagneticDeclination() {
        return getMagneticDeclination(0);
    }

    /**
     * @see EnvironmentalSensingService#getMagneticDeclination(int)
     */
    @Nullable
    public synchronized Integer getMagneticDeclination(int index) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.getMagneticDeclination(index);
        }
        return taskId;
    }

    /**
     * @see #startMagneticDeclinationNotification(int)
     */
    @Nullable
    public synchronized Integer startMagneticDeclinationNotification() {
        return startMagneticDeclinationNotification(0);
    }

    /**
     * @see EnvironmentalSensingService#startMagneticDeclinationNotification(int)
     */
    @Nullable
    public synchronized Integer startMagneticDeclinationNotification(int index) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.startMagneticDeclinationNotification(index);
        }
        return taskId;
    }

    /**
     * @see #startMagneticDeclinationNotification(int)
     */
    @Nullable
    public synchronized Integer stopMagneticDeclinationNotification() {
        return stopMagneticDeclinationNotification(0);
    }

    /**
     * @see EnvironmentalSensingService#stopMagneticDeclinationNotification(int)
     */
    @Nullable
    public synchronized Integer stopMagneticDeclinationNotification(int index) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.stopMagneticDeclinationNotification(index);
        }
        return taskId;
    }

    /**
     * @see #getMagneticDeclinationEnvironmentalSensingMeasurement(int)
     */
    @Nullable
    public synchronized Integer getMagneticDeclinationEnvironmentalSensingMeasurement() {
        return getMagneticDeclinationEnvironmentalSensingMeasurement(0);
    }

    /**
     * @see EnvironmentalSensingService#getMagneticDeclinationEnvironmentalSensingMeasurement(int)
     */
    @Nullable
    public synchronized Integer getMagneticDeclinationEnvironmentalSensingMeasurement(int index) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.getMagneticDeclinationEnvironmentalSensingMeasurement(index);
        }
        return taskId;
    }

    /**
     * @see #getMagneticDeclinationEnvironmentalSensingTriggerSetting(int, int)
     */
    @Nullable
    public synchronized Integer getMagneticDeclinationEnvironmentalSensingTriggerSetting() {
        return getMagneticDeclinationEnvironmentalSensingTriggerSetting(0, 0);
    }

    /**
     * @see EnvironmentalSensingService#getMagneticDeclinationEnvironmentalSensingTriggerSetting(int, int)
     */
    @Nullable
    public synchronized Integer getMagneticDeclinationEnvironmentalSensingTriggerSetting(int characteristicIndex, int descriptorIndex) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.getMagneticDeclinationEnvironmentalSensingTriggerSetting(characteristicIndex, descriptorIndex);
        }
        return taskId;
    }

    /**
     * @see #setMagneticDeclinationEnvironmentalSensingTriggerSetting(int, int, EnvironmentalSensingTriggerSetting)
     */
    @Nullable
    public synchronized Integer setMagneticDeclinationEnvironmentalSensingTriggerSetting(@NonNull EnvironmentalSensingTriggerSetting environmentalSensingTriggerSetting) {
        return setMagneticDeclinationEnvironmentalSensingTriggerSetting(0, 0, environmentalSensingTriggerSetting);
    }

    /**
     * @see EnvironmentalSensingService#setMagneticDeclinationEnvironmentalSensingTriggerSetting(int, int, EnvironmentalSensingTriggerSetting)
     */
    @Nullable
    public synchronized Integer setMagneticDeclinationEnvironmentalSensingTriggerSetting(int characteristicIndex, int descriptorIndex, @NonNull EnvironmentalSensingTriggerSetting environmentalSensingTriggerSetting) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.setMagneticDeclinationEnvironmentalSensingTriggerSetting(characteristicIndex, descriptorIndex, environmentalSensingTriggerSetting);
        }
        return taskId;
    }

    /**
     * @see #getMagneticDeclinationEnvironmentalSensingConfiguration(int)
     */
    @Nullable
    public synchronized Integer getMagneticDeclinationEnvironmentalSensingConfiguration() {
        return getMagneticDeclinationEnvironmentalSensingConfiguration(0);
    }

    /**
     * @see EnvironmentalSensingService#getMagneticDeclinationEnvironmentalSensingConfiguration(int)
     */
    @Nullable
    public synchronized Integer getMagneticDeclinationEnvironmentalSensingConfiguration(int index) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.getMagneticDeclinationEnvironmentalSensingConfiguration(index);
        }
        return taskId;
    }

    /**
     * @see #setMagneticDeclinationEnvironmentalSensingConfiguration(int, EnvironmentalSensingConfiguration)
     */
    @Nullable
    public synchronized Integer setMagneticDeclinationEnvironmentalSensingConfiguration(@NonNull EnvironmentalSensingConfiguration environmentalSensingConfiguration) {
        return setMagneticDeclinationEnvironmentalSensingConfiguration(0, environmentalSensingConfiguration);
    }

    /**
     * @see EnvironmentalSensingService#setMagneticDeclinationEnvironmentalSensingConfiguration(int, EnvironmentalSensingConfiguration)
     */
    @Nullable
    public synchronized Integer setMagneticDeclinationEnvironmentalSensingConfiguration(int index, @NonNull EnvironmentalSensingConfiguration environmentalSensingConfiguration) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.setMagneticDeclinationEnvironmentalSensingConfiguration(index, environmentalSensingConfiguration);
        }
        return taskId;
    }

    /**
     * @see #getMagneticDeclinationCharacteristicUserDescription(int)
     */
    @Nullable
    public synchronized Integer getMagneticDeclinationCharacteristicUserDescription() {
        return getMagneticDeclinationCharacteristicUserDescription(0);
    }

    /**
     * @see EnvironmentalSensingService#getMagneticDeclinationCharacteristicUserDescription(int)
     */
    @Nullable
    public synchronized Integer getMagneticDeclinationCharacteristicUserDescription(int index) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.getMagneticDeclinationCharacteristicUserDescription(index);
        }
        return taskId;
    }

    /**
     * @see #setMagneticDeclinationCharacteristicUserDescription(int, CharacteristicUserDescription)
     */
    @Nullable
    public synchronized Integer setMagneticDeclinationCharacteristicUserDescription(@NonNull CharacteristicUserDescription characteristicUserDescription) {
        return setMagneticDeclinationCharacteristicUserDescription(0, characteristicUserDescription);
    }

    /**
     * @see EnvironmentalSensingService#setMagneticDeclinationCharacteristicUserDescription(int, CharacteristicUserDescription)
     */
    @Nullable
    public synchronized Integer setMagneticDeclinationCharacteristicUserDescription(int index, @NonNull CharacteristicUserDescription characteristicUserDescription) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.setMagneticDeclinationCharacteristicUserDescription(index, characteristicUserDescription);
        }
        return taskId;
    }

    /**
     * @see #getMagneticDeclinationValidRange(int)
     */
    @Nullable
    public synchronized Integer getMagneticDeclinationValidRange() {
        return getMagneticDeclinationValidRange(0);
    }

    /**
     * @see EnvironmentalSensingService#getMagneticDeclinationValidRange(int)
     */
    @Nullable
    public synchronized Integer getMagneticDeclinationValidRange(int index) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.getMagneticDeclinationValidRange(index);
        }
        return taskId;
    }

    /**
     * @see EnvironmentalSensingService#getMagneticFluxDensity2DCount()
     */
    @Nullable
    public synchronized Integer getMagneticFluxDensity2DCount() {
        Integer count = null;
        if (mEnvironmentalSensingService != null) {
            count = mEnvironmentalSensingService.getMagneticFluxDensity2DCount();
        }
        return count;
    }

    /**
     * @see #canMagneticFluxDensity2DNotify(int)
     */
    public synchronized Boolean canMagneticFluxDensity2DNotify() {
        return canMagneticFluxDensity2DNotify(0);
    }

    /**
     * @see EnvironmentalSensingService#canMagneticFluxDensity2DNotify(int)
     */
    public synchronized Boolean canMagneticFluxDensity2DNotify(int index) {
        Boolean result = null;
        if (mEnvironmentalSensingService != null) {
            result = mEnvironmentalSensingService.canMagneticFluxDensity2DNotify(index);
        }
        return result;
    }

    /**
     * @see #hasMagneticFluxDensity2DCharacteristicEnvironmentalSensingMeasurement(int)
     */
    public synchronized Boolean hasMagneticFluxDensity2DCharacteristicEnvironmentalSensingMeasurement() {
        return hasMagneticFluxDensity2DCharacteristicEnvironmentalSensingMeasurement(0);
    }

    /**
     * @see EnvironmentalSensingService#hasMagneticFluxDensity2DCharacteristicEnvironmentalSensingMeasurement(int)
     */
    public synchronized Boolean hasMagneticFluxDensity2DCharacteristicEnvironmentalSensingMeasurement(int index) {
        Boolean result = null;
        if (mEnvironmentalSensingService != null) {
            result = mEnvironmentalSensingService.hasMagneticFluxDensity2DCharacteristicEnvironmentalSensingMeasurement(index);
        }
        return result;
    }

    /**
     * @see #getMagneticFluxDensity2DCharacteristicEnvironmentalSensingTriggerSettingCount(int)
     */
    public synchronized Integer getMagneticFluxDensity2DCharacteristicEnvironmentalSensingTriggerSettingCount() {
        return getMagneticFluxDensity2DCharacteristicEnvironmentalSensingTriggerSettingCount(0);
    }

    /**
     * @see EnvironmentalSensingService#getMagneticFluxDensity2DCharacteristicEnvironmentalSensingTriggerSettingCount(int)
     */
    @Nullable
    public synchronized Integer getMagneticFluxDensity2DCharacteristicEnvironmentalSensingTriggerSettingCount(int index) {
        Integer count = null;
        if (mEnvironmentalSensingService != null) {
            count = mEnvironmentalSensingService.getMagneticFluxDensity2DCharacteristicEnvironmentalSensingTriggerSettingCount(index);
        }
        return count;
    }

    /**
     * @see #hasMagneticFluxDensity2DCharacteristicEnvironmentalSensingConfiguration(int)
     */
    public synchronized Boolean hasMagneticFluxDensity2DCharacteristicEnvironmentalSensingConfiguration() {
        return hasMagneticFluxDensity2DCharacteristicEnvironmentalSensingConfiguration(0);
    }

    /**
     * @see EnvironmentalSensingService#hasMagneticFluxDensity2DCharacteristicEnvironmentalSensingConfiguration(int)
     */
    public synchronized Boolean hasMagneticFluxDensity2DCharacteristicEnvironmentalSensingConfiguration(int index) {
        Boolean result = null;
        if (mEnvironmentalSensingService != null) {
            result = mEnvironmentalSensingService.hasMagneticFluxDensity2DCharacteristicEnvironmentalSensingConfiguration(index);
        }
        return result;
    }

    /**
     * @see #hasMagneticFluxDensity2DCharacteristicCharacteristicUserDescription(int)
     */
    public synchronized Boolean hasMagneticFluxDensity2DCharacteristicCharacteristicUserDescription() {
        return hasMagneticFluxDensity2DCharacteristicCharacteristicUserDescription(0);
    }

    /**
     * @see EnvironmentalSensingService#hasMagneticFluxDensity2DCharacteristicCharacteristicUserDescription(int)
     */
    public synchronized Boolean hasMagneticFluxDensity2DCharacteristicCharacteristicUserDescription(int index) {
        Boolean result = null;
        if (mEnvironmentalSensingService != null) {
            result = mEnvironmentalSensingService.hasMagneticFluxDensity2DCharacteristicCharacteristicUserDescription(index);
        }
        return result;
    }

    /**
     * @see #hasMagneticFluxDensity2DCharacteristicValidRange(int)
     */
    public synchronized Boolean hasMagneticFluxDensity2DCharacteristicValidRange() {
        return hasMagneticFluxDensity2DCharacteristicValidRange(0);
    }

    /**
     * @see EnvironmentalSensingService#hasMagneticFluxDensity2DCharacteristicValidRange(int)
     */
    public synchronized Boolean hasMagneticFluxDensity2DCharacteristicValidRange(int index) {
        Boolean result = null;
        if (mEnvironmentalSensingService != null) {
            result = mEnvironmentalSensingService.hasMagneticFluxDensity2DCharacteristicValidRange(index);
        }
        return result;
    }

    /**
     * @see #getMagneticFluxDensity2D(int)
     */
    @Nullable
    public synchronized Integer getMagneticFluxDensity2D() {
        return getMagneticFluxDensity2D(0);
    }

    /**
     * @see EnvironmentalSensingService#getMagneticFluxDensity2D(int)
     */
    @Nullable
    public synchronized Integer getMagneticFluxDensity2D(int index) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.getMagneticFluxDensity2D(index);
        }
        return taskId;
    }

    /**
     * @see #startMagneticFluxDensity2DNotification(int)
     */
    @Nullable
    public synchronized Integer startMagneticFluxDensity2DNotification() {
        return startMagneticFluxDensity2DNotification(0);
    }

    /**
     * @see EnvironmentalSensingService#startMagneticFluxDensity2DNotification(int)
     */
    @Nullable
    public synchronized Integer startMagneticFluxDensity2DNotification(int index) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.startMagneticFluxDensity2DNotification(index);
        }
        return taskId;
    }

    /**
     * @see #startMagneticFluxDensity2DNotification(int)
     */
    @Nullable
    public synchronized Integer stopMagneticFluxDensity2DNotification() {
        return stopMagneticFluxDensity2DNotification(0);
    }

    /**
     * @see EnvironmentalSensingService#stopMagneticFluxDensity2DNotification(int)
     */
    @Nullable
    public synchronized Integer stopMagneticFluxDensity2DNotification(int index) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.stopMagneticFluxDensity2DNotification(index);
        }
        return taskId;
    }

    /**
     * @see #getMagneticFluxDensity2DEnvironmentalSensingMeasurement(int)
     */
    @Nullable
    public synchronized Integer getMagneticFluxDensity2DEnvironmentalSensingMeasurement() {
        return getMagneticFluxDensity2DEnvironmentalSensingMeasurement(0);
    }

    /**
     * @see EnvironmentalSensingService#getMagneticFluxDensity2DEnvironmentalSensingMeasurement(int)
     */
    @Nullable
    public synchronized Integer getMagneticFluxDensity2DEnvironmentalSensingMeasurement(int index) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.getMagneticFluxDensity2DEnvironmentalSensingMeasurement(index);
        }
        return taskId;
    }

    /**
     * @see #getMagneticFluxDensity2DEnvironmentalSensingTriggerSetting(int, int)
     */
    @Nullable
    public synchronized Integer getMagneticFluxDensity2DEnvironmentalSensingTriggerSetting() {
        return getMagneticFluxDensity2DEnvironmentalSensingTriggerSetting(0, 0);
    }

    /**
     * @see EnvironmentalSensingService#getMagneticFluxDensity2DEnvironmentalSensingTriggerSetting(int, int)
     */
    @Nullable
    public synchronized Integer getMagneticFluxDensity2DEnvironmentalSensingTriggerSetting(int characteristicIndex, int descriptorIndex) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.getMagneticFluxDensity2DEnvironmentalSensingTriggerSetting(characteristicIndex, descriptorIndex);
        }
        return taskId;
    }

    /**
     * @see #setMagneticFluxDensity2DEnvironmentalSensingTriggerSetting(int, int, EnvironmentalSensingTriggerSetting)
     */
    @Nullable
    public synchronized Integer setMagneticFluxDensity2DEnvironmentalSensingTriggerSetting(@NonNull EnvironmentalSensingTriggerSetting environmentalSensingTriggerSetting) {
        return setMagneticFluxDensity2DEnvironmentalSensingTriggerSetting(0, 0, environmentalSensingTriggerSetting);
    }

    /**
     * @see EnvironmentalSensingService#setMagneticFluxDensity2DEnvironmentalSensingTriggerSetting(int, int, EnvironmentalSensingTriggerSetting)
     */
    @Nullable
    public synchronized Integer setMagneticFluxDensity2DEnvironmentalSensingTriggerSetting(int characteristicIndex, int descriptorIndex, @NonNull EnvironmentalSensingTriggerSetting environmentalSensingTriggerSetting) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.setMagneticFluxDensity2DEnvironmentalSensingTriggerSetting(characteristicIndex, descriptorIndex, environmentalSensingTriggerSetting);
        }
        return taskId;
    }

    /**
     * @see #getMagneticFluxDensity2DEnvironmentalSensingConfiguration(int)
     */
    @Nullable
    public synchronized Integer getMagneticFluxDensity2DEnvironmentalSensingConfiguration() {
        return getMagneticFluxDensity2DEnvironmentalSensingConfiguration(0);
    }

    /**
     * @see EnvironmentalSensingService#getMagneticFluxDensity2DEnvironmentalSensingConfiguration(int)
     */
    @Nullable
    public synchronized Integer getMagneticFluxDensity2DEnvironmentalSensingConfiguration(int index) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.getMagneticFluxDensity2DEnvironmentalSensingConfiguration(index);
        }
        return taskId;
    }

    /**
     * @see #setMagneticFluxDensity2DEnvironmentalSensingConfiguration(int, EnvironmentalSensingConfiguration)
     */
    @Nullable
    public synchronized Integer setMagneticFluxDensity2DEnvironmentalSensingConfiguration(@NonNull EnvironmentalSensingConfiguration environmentalSensingConfiguration) {
        return setMagneticFluxDensity2DEnvironmentalSensingConfiguration(0, environmentalSensingConfiguration);
    }

    /**
     * @see EnvironmentalSensingService#setMagneticFluxDensity2DEnvironmentalSensingConfiguration(int, EnvironmentalSensingConfiguration)
     */
    @Nullable
    public synchronized Integer setMagneticFluxDensity2DEnvironmentalSensingConfiguration(int index, @NonNull EnvironmentalSensingConfiguration environmentalSensingConfiguration) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.setMagneticFluxDensity2DEnvironmentalSensingConfiguration(index, environmentalSensingConfiguration);
        }
        return taskId;
    }

    /**
     * @see #getMagneticFluxDensity2DCharacteristicUserDescription(int)
     */
    @Nullable
    public synchronized Integer getMagneticFluxDensity2DCharacteristicUserDescription() {
        return getMagneticFluxDensity2DCharacteristicUserDescription(0);
    }

    /**
     * @see EnvironmentalSensingService#getMagneticFluxDensity2DCharacteristicUserDescription(int)
     */
    @Nullable
    public synchronized Integer getMagneticFluxDensity2DCharacteristicUserDescription(int index) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.getMagneticFluxDensity2DCharacteristicUserDescription(index);
        }
        return taskId;
    }

    /**
     * @see #setMagneticFluxDensity2DCharacteristicUserDescription(int, CharacteristicUserDescription)
     */
    @Nullable
    public synchronized Integer setMagneticFluxDensity2DCharacteristicUserDescription(@NonNull CharacteristicUserDescription characteristicUserDescription) {
        return setMagneticFluxDensity2DCharacteristicUserDescription(0, characteristicUserDescription);
    }

    /**
     * @see EnvironmentalSensingService#setMagneticFluxDensity2DCharacteristicUserDescription(int, CharacteristicUserDescription)
     */
    @Nullable
    public synchronized Integer setMagneticFluxDensity2DCharacteristicUserDescription(int index, @NonNull CharacteristicUserDescription characteristicUserDescription) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.setMagneticFluxDensity2DCharacteristicUserDescription(index, characteristicUserDescription);
        }
        return taskId;
    }

    /**
     * @see #getMagneticFluxDensity2DValidRange(int)
     */
    @Nullable
    public synchronized Integer getMagneticFluxDensity2DValidRange() {
        return getMagneticFluxDensity2DValidRange(0);
    }

    /**
     * @see EnvironmentalSensingService#getMagneticFluxDensity2DValidRange(int)
     */
    @Nullable
    public synchronized Integer getMagneticFluxDensity2DValidRange(int index) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.getMagneticFluxDensity2DValidRange(index);
        }
        return taskId;
    }

    /**
     * @see EnvironmentalSensingService#getMagneticFluxDensity3DCount()
     */
    @Nullable
    public synchronized Integer getMagneticFluxDensity3DCount() {
        Integer count = null;
        if (mEnvironmentalSensingService != null) {
            count = mEnvironmentalSensingService.getMagneticFluxDensity3DCount();
        }
        return count;
    }

    /**
     * @see #canMagneticFluxDensity3DNotify(int)
     */
    public synchronized Boolean canMagneticFluxDensity3DNotify() {
        return canMagneticFluxDensity3DNotify(0);
    }

    /**
     * @see EnvironmentalSensingService#canMagneticFluxDensity3DNotify(int)
     */
    public synchronized Boolean canMagneticFluxDensity3DNotify(int index) {
        Boolean result = null;
        if (mEnvironmentalSensingService != null) {
            result = mEnvironmentalSensingService.canMagneticFluxDensity3DNotify(index);
        }
        return result;
    }

    /**
     * @see #hasMagneticFluxDensity3DCharacteristicEnvironmentalSensingMeasurement(int)
     */
    public synchronized Boolean hasMagneticFluxDensity3DCharacteristicEnvironmentalSensingMeasurement() {
        return hasMagneticFluxDensity3DCharacteristicEnvironmentalSensingMeasurement(0);
    }

    /**
     * @see EnvironmentalSensingService#hasMagneticFluxDensity3DCharacteristicEnvironmentalSensingMeasurement(int)
     */
    public synchronized Boolean hasMagneticFluxDensity3DCharacteristicEnvironmentalSensingMeasurement(int index) {
        Boolean result = null;
        if (mEnvironmentalSensingService != null) {
            result = mEnvironmentalSensingService.hasMagneticFluxDensity3DCharacteristicEnvironmentalSensingMeasurement(index);
        }
        return result;
    }

    /**
     * @see #getMagneticFluxDensity3DCharacteristicEnvironmentalSensingTriggerSettingCount(int)
     */
    public synchronized Integer getMagneticFluxDensity3DCharacteristicEnvironmentalSensingTriggerSettingCount() {
        return getMagneticFluxDensity3DCharacteristicEnvironmentalSensingTriggerSettingCount(0);
    }

    /**
     * @see EnvironmentalSensingService#getMagneticFluxDensity3DCharacteristicEnvironmentalSensingTriggerSettingCount(int)
     */
    @Nullable
    public synchronized Integer getMagneticFluxDensity3DCharacteristicEnvironmentalSensingTriggerSettingCount(int index) {
        Integer count = null;
        if (mEnvironmentalSensingService != null) {
            count = mEnvironmentalSensingService.getMagneticFluxDensity3DCharacteristicEnvironmentalSensingTriggerSettingCount(index);
        }
        return count;
    }

    /**
     * @see #hasMagneticFluxDensity3DCharacteristicEnvironmentalSensingConfiguration(int)
     */
    public synchronized Boolean hasMagneticFluxDensity3DCharacteristicEnvironmentalSensingConfiguration() {
        return hasMagneticFluxDensity3DCharacteristicEnvironmentalSensingConfiguration(0);
    }

    /**
     * @see EnvironmentalSensingService#hasMagneticFluxDensity3DCharacteristicEnvironmentalSensingConfiguration(int)
     */
    public synchronized Boolean hasMagneticFluxDensity3DCharacteristicEnvironmentalSensingConfiguration(int index) {
        Boolean result = null;
        if (mEnvironmentalSensingService != null) {
            result = mEnvironmentalSensingService.hasMagneticFluxDensity3DCharacteristicEnvironmentalSensingConfiguration(index);
        }
        return result;
    }

    /**
     * @see #hasMagneticFluxDensity3DCharacteristicCharacteristicUserDescription(int)
     */
    public synchronized Boolean hasMagneticFluxDensity3DCharacteristicCharacteristicUserDescription() {
        return hasMagneticFluxDensity3DCharacteristicCharacteristicUserDescription(0);
    }

    /**
     * @see EnvironmentalSensingService#hasMagneticFluxDensity3DCharacteristicCharacteristicUserDescription(int)
     */
    public synchronized Boolean hasMagneticFluxDensity3DCharacteristicCharacteristicUserDescription(int index) {
        Boolean result = null;
        if (mEnvironmentalSensingService != null) {
            result = mEnvironmentalSensingService.hasMagneticFluxDensity3DCharacteristicCharacteristicUserDescription(index);
        }
        return result;
    }

    /**
     * @see #hasMagneticFluxDensity3DCharacteristicValidRange(int)
     */
    public synchronized Boolean hasMagneticFluxDensity3DCharacteristicValidRange() {
        return hasMagneticFluxDensity3DCharacteristicValidRange(0);
    }

    /**
     * @see EnvironmentalSensingService#hasMagneticFluxDensity3DCharacteristicValidRange(int)
     */
    public synchronized Boolean hasMagneticFluxDensity3DCharacteristicValidRange(int index) {
        Boolean result = null;
        if (mEnvironmentalSensingService != null) {
            result = mEnvironmentalSensingService.hasMagneticFluxDensity3DCharacteristicValidRange(index);
        }
        return result;
    }

    /**
     * @see #getMagneticFluxDensity3D(int)
     */
    @Nullable
    public synchronized Integer getMagneticFluxDensity3D() {
        return getMagneticFluxDensity3D(0);
    }

    /**
     * @see EnvironmentalSensingService#getMagneticFluxDensity3D(int)
     */
    @Nullable
    public synchronized Integer getMagneticFluxDensity3D(int index) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.getMagneticFluxDensity3D(index);
        }
        return taskId;
    }

    /**
     * @see #startMagneticFluxDensity3DNotification(int)
     */
    @Nullable
    public synchronized Integer startMagneticFluxDensity3DNotification() {
        return startMagneticFluxDensity3DNotification(0);
    }

    /**
     * @see EnvironmentalSensingService#startMagneticFluxDensity3DNotification(int)
     */
    @Nullable
    public synchronized Integer startMagneticFluxDensity3DNotification(int index) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.startMagneticFluxDensity3DNotification(index);
        }
        return taskId;
    }

    /**
     * @see #startMagneticFluxDensity3DNotification(int)
     */
    @Nullable
    public synchronized Integer stopMagneticFluxDensity3DNotification() {
        return stopMagneticFluxDensity3DNotification(0);
    }

    /**
     * @see EnvironmentalSensingService#stopMagneticFluxDensity3DNotification(int)
     */
    @Nullable
    public synchronized Integer stopMagneticFluxDensity3DNotification(int index) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.stopMagneticFluxDensity3DNotification(index);
        }
        return taskId;
    }

    /**
     * @see #getMagneticFluxDensity3DEnvironmentalSensingMeasurement(int)
     */
    @Nullable
    public synchronized Integer getMagneticFluxDensity3DEnvironmentalSensingMeasurement() {
        return getMagneticFluxDensity3DEnvironmentalSensingMeasurement(0);
    }

    /**
     * @see EnvironmentalSensingService#getMagneticFluxDensity3DEnvironmentalSensingMeasurement(int)
     */
    @Nullable
    public synchronized Integer getMagneticFluxDensity3DEnvironmentalSensingMeasurement(int index) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.getMagneticFluxDensity3DEnvironmentalSensingMeasurement(index);
        }
        return taskId;
    }

    /**
     * @see #getMagneticFluxDensity3DEnvironmentalSensingTriggerSetting(int, int)
     */
    @Nullable
    public synchronized Integer getMagneticFluxDensity3DEnvironmentalSensingTriggerSetting() {
        return getMagneticFluxDensity3DEnvironmentalSensingTriggerSetting(0, 0);
    }

    /**
     * @see EnvironmentalSensingService#getMagneticFluxDensity3DEnvironmentalSensingTriggerSetting(int, int)
     */
    @Nullable
    public synchronized Integer getMagneticFluxDensity3DEnvironmentalSensingTriggerSetting(int characteristicIndex, int descriptorIndex) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.getMagneticFluxDensity3DEnvironmentalSensingTriggerSetting(characteristicIndex, descriptorIndex);
        }
        return taskId;
    }

    /**
     * @see #setMagneticFluxDensity3DEnvironmentalSensingTriggerSetting(int, int, EnvironmentalSensingTriggerSetting)
     */
    @Nullable
    public synchronized Integer setMagneticFluxDensity3DEnvironmentalSensingTriggerSetting(@NonNull EnvironmentalSensingTriggerSetting environmentalSensingTriggerSetting) {
        return setMagneticFluxDensity3DEnvironmentalSensingTriggerSetting(0, 0, environmentalSensingTriggerSetting);
    }

    /**
     * @see EnvironmentalSensingService#setMagneticFluxDensity3DEnvironmentalSensingTriggerSetting(int, int, EnvironmentalSensingTriggerSetting)
     */
    @Nullable
    public synchronized Integer setMagneticFluxDensity3DEnvironmentalSensingTriggerSetting(int characteristicIndex, int descriptorIndex, @NonNull EnvironmentalSensingTriggerSetting environmentalSensingTriggerSetting) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.setMagneticFluxDensity3DEnvironmentalSensingTriggerSetting(characteristicIndex, descriptorIndex, environmentalSensingTriggerSetting);
        }
        return taskId;
    }

    /**
     * @see #getMagneticFluxDensity3DEnvironmentalSensingConfiguration(int)
     */
    @Nullable
    public synchronized Integer getMagneticFluxDensity3DEnvironmentalSensingConfiguration() {
        return getMagneticFluxDensity3DEnvironmentalSensingConfiguration(0);
    }

    /**
     * @see EnvironmentalSensingService#getMagneticFluxDensity3DEnvironmentalSensingConfiguration(int)
     */
    @Nullable
    public synchronized Integer getMagneticFluxDensity3DEnvironmentalSensingConfiguration(int index) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.getMagneticFluxDensity3DEnvironmentalSensingConfiguration(index);
        }
        return taskId;
    }

    /**
     * @see #setMagneticFluxDensity3DEnvironmentalSensingConfiguration(int, EnvironmentalSensingConfiguration)
     */
    @Nullable
    public synchronized Integer setMagneticFluxDensity3DEnvironmentalSensingConfiguration(@NonNull EnvironmentalSensingConfiguration environmentalSensingConfiguration) {
        return setMagneticFluxDensity3DEnvironmentalSensingConfiguration(0, environmentalSensingConfiguration);
    }

    /**
     * @see EnvironmentalSensingService#setMagneticFluxDensity3DEnvironmentalSensingConfiguration(int, EnvironmentalSensingConfiguration)
     */
    @Nullable
    public synchronized Integer setMagneticFluxDensity3DEnvironmentalSensingConfiguration(int index, @NonNull EnvironmentalSensingConfiguration environmentalSensingConfiguration) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.setMagneticFluxDensity3DEnvironmentalSensingConfiguration(index, environmentalSensingConfiguration);
        }
        return taskId;
    }

    /**
     * @see #getMagneticFluxDensity3DCharacteristicUserDescription(int)
     */
    @Nullable
    public synchronized Integer getMagneticFluxDensity3DCharacteristicUserDescription() {
        return getMagneticFluxDensity3DCharacteristicUserDescription(0);
    }

    /**
     * @see EnvironmentalSensingService#getMagneticFluxDensity3DCharacteristicUserDescription(int)
     */
    @Nullable
    public synchronized Integer getMagneticFluxDensity3DCharacteristicUserDescription(int index) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.getMagneticFluxDensity3DCharacteristicUserDescription(index);
        }
        return taskId;
    }

    /**
     * @see #setMagneticFluxDensity3DCharacteristicUserDescription(int, CharacteristicUserDescription)
     */
    @Nullable
    public synchronized Integer setMagneticFluxDensity3DCharacteristicUserDescription(@NonNull CharacteristicUserDescription characteristicUserDescription) {
        return setMagneticFluxDensity3DCharacteristicUserDescription(0, characteristicUserDescription);
    }

    /**
     * @see EnvironmentalSensingService#setMagneticFluxDensity3DCharacteristicUserDescription(int, CharacteristicUserDescription)
     */
    @Nullable
    public synchronized Integer setMagneticFluxDensity3DCharacteristicUserDescription(int index, @NonNull CharacteristicUserDescription characteristicUserDescription) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.setMagneticFluxDensity3DCharacteristicUserDescription(index, characteristicUserDescription);
        }
        return taskId;
    }

    /**
     * @see #getMagneticFluxDensity3DValidRange(int)
     */
    @Nullable
    public synchronized Integer getMagneticFluxDensity3DValidRange() {
        return getMagneticFluxDensity3DValidRange(0);
    }

    /**
     * @see EnvironmentalSensingService#getMagneticFluxDensity3DValidRange(int)
     */
    @Nullable
    public synchronized Integer getMagneticFluxDensity3DValidRange(int index) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.getMagneticFluxDensity3DValidRange(index);
        }
        return taskId;
    }

    /**
     * @see EnvironmentalSensingService#getMethaneConcentrationCount()
     */
    @Nullable
    public synchronized Integer getMethaneConcentrationCount() {
        Integer count = null;
        if (mEnvironmentalSensingService != null) {
            count = mEnvironmentalSensingService.getMethaneConcentrationCount();
        }
        return count;
    }

    /**
     * @see #canMethaneConcentrationNotify(int)
     */
    public synchronized Boolean canMethaneConcentrationNotify() {
        return canMethaneConcentrationNotify(0);
    }

    /**
     * @see EnvironmentalSensingService#canMethaneConcentrationNotify(int)
     */
    public synchronized Boolean canMethaneConcentrationNotify(int index) {
        Boolean result = null;
        if (mEnvironmentalSensingService != null) {
            result = mEnvironmentalSensingService.canMethaneConcentrationNotify(index);
        }
        return result;
    }

    /**
     * @see #hasMethaneConcentrationCharacteristicEnvironmentalSensingMeasurement(int)
     */
    public synchronized Boolean hasMethaneConcentrationCharacteristicEnvironmentalSensingMeasurement() {
        return hasMethaneConcentrationCharacteristicEnvironmentalSensingMeasurement(0);
    }

    /**
     * @see EnvironmentalSensingService#hasMethaneConcentrationCharacteristicEnvironmentalSensingMeasurement(int)
     */
    public synchronized Boolean hasMethaneConcentrationCharacteristicEnvironmentalSensingMeasurement(int index) {
        Boolean result = null;
        if (mEnvironmentalSensingService != null) {
            result = mEnvironmentalSensingService.hasMethaneConcentrationCharacteristicEnvironmentalSensingMeasurement(index);
        }
        return result;
    }

    /**
     * @see #getMethaneConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount(int)
     */
    public synchronized Integer getMethaneConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount() {
        return getMethaneConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount(0);
    }

    /**
     * @see EnvironmentalSensingService#getMethaneConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount(int)
     */
    @Nullable
    public synchronized Integer getMethaneConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount(int index) {
        Integer count = null;
        if (mEnvironmentalSensingService != null) {
            count = mEnvironmentalSensingService.getMethaneConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount(index);
        }
        return count;
    }

    /**
     * @see #hasMethaneConcentrationCharacteristicEnvironmentalSensingConfiguration(int)
     */
    public synchronized Boolean hasMethaneConcentrationCharacteristicEnvironmentalSensingConfiguration() {
        return hasMethaneConcentrationCharacteristicEnvironmentalSensingConfiguration(0);
    }

    /**
     * @see EnvironmentalSensingService#hasMethaneConcentrationCharacteristicEnvironmentalSensingConfiguration(int)
     */
    public synchronized Boolean hasMethaneConcentrationCharacteristicEnvironmentalSensingConfiguration(int index) {
        Boolean result = null;
        if (mEnvironmentalSensingService != null) {
            result = mEnvironmentalSensingService.hasMethaneConcentrationCharacteristicEnvironmentalSensingConfiguration(index);
        }
        return result;
    }

    /**
     * @see #hasMethaneConcentrationCharacteristicCharacteristicUserDescription(int)
     */
    public synchronized Boolean hasMethaneConcentrationCharacteristicCharacteristicUserDescription() {
        return hasMethaneConcentrationCharacteristicCharacteristicUserDescription(0);
    }

    /**
     * @see EnvironmentalSensingService#hasMethaneConcentrationCharacteristicCharacteristicUserDescription(int)
     */
    public synchronized Boolean hasMethaneConcentrationCharacteristicCharacteristicUserDescription(int index) {
        Boolean result = null;
        if (mEnvironmentalSensingService != null) {
            result = mEnvironmentalSensingService.hasMethaneConcentrationCharacteristicCharacteristicUserDescription(index);
        }
        return result;
    }

    /**
     * @see #hasMethaneConcentrationCharacteristicValidRange(int)
     */
    public synchronized Boolean hasMethaneConcentrationCharacteristicValidRange() {
        return hasMethaneConcentrationCharacteristicValidRange(0);
    }

    /**
     * @see EnvironmentalSensingService#hasMethaneConcentrationCharacteristicValidRange(int)
     */
    public synchronized Boolean hasMethaneConcentrationCharacteristicValidRange(int index) {
        Boolean result = null;
        if (mEnvironmentalSensingService != null) {
            result = mEnvironmentalSensingService.hasMethaneConcentrationCharacteristicValidRange(index);
        }
        return result;
    }

    /**
     * @see #getMethaneConcentration(int)
     */
    @Nullable
    public synchronized Integer getMethaneConcentration() {
        return getMethaneConcentration(0);
    }

    /**
     * @see EnvironmentalSensingService#getMethaneConcentration(int)
     */
    @Nullable
    public synchronized Integer getMethaneConcentration(int index) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.getMethaneConcentration(index);
        }
        return taskId;
    }

    /**
     * @see #startMethaneConcentrationNotification(int)
     */
    @Nullable
    public synchronized Integer startMethaneConcentrationNotification() {
        return startMethaneConcentrationNotification(0);
    }

    /**
     * @see EnvironmentalSensingService#startMethaneConcentrationNotification(int)
     */
    @Nullable
    public synchronized Integer startMethaneConcentrationNotification(int index) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.startMethaneConcentrationNotification(index);
        }
        return taskId;
    }

    /**
     * @see #startMethaneConcentrationNotification(int)
     */
    @Nullable
    public synchronized Integer stopMethaneConcentrationNotification() {
        return stopMethaneConcentrationNotification(0);
    }

    /**
     * @see EnvironmentalSensingService#stopMethaneConcentrationNotification(int)
     */
    @Nullable
    public synchronized Integer stopMethaneConcentrationNotification(int index) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.stopMethaneConcentrationNotification(index);
        }
        return taskId;
    }

    /**
     * @see #getMethaneConcentrationEnvironmentalSensingMeasurement(int)
     */
    @Nullable
    public synchronized Integer getMethaneConcentrationEnvironmentalSensingMeasurement() {
        return getMethaneConcentrationEnvironmentalSensingMeasurement(0);
    }

    /**
     * @see EnvironmentalSensingService#getMethaneConcentrationEnvironmentalSensingMeasurement(int)
     */
    @Nullable
    public synchronized Integer getMethaneConcentrationEnvironmentalSensingMeasurement(int index) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.getMethaneConcentrationEnvironmentalSensingMeasurement(index);
        }
        return taskId;
    }

    /**
     * @see #getMethaneConcentrationEnvironmentalSensingTriggerSetting(int, int)
     */
    @Nullable
    public synchronized Integer getMethaneConcentrationEnvironmentalSensingTriggerSetting() {
        return getMethaneConcentrationEnvironmentalSensingTriggerSetting(0, 0);
    }

    /**
     * @see EnvironmentalSensingService#getMethaneConcentrationEnvironmentalSensingTriggerSetting(int, int)
     */
    @Nullable
    public synchronized Integer getMethaneConcentrationEnvironmentalSensingTriggerSetting(int characteristicIndex, int descriptorIndex) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.getMethaneConcentrationEnvironmentalSensingTriggerSetting(characteristicIndex, descriptorIndex);
        }
        return taskId;
    }

    /**
     * @see #setMethaneConcentrationEnvironmentalSensingTriggerSetting(int, int, EnvironmentalSensingTriggerSetting)
     */
    @Nullable
    public synchronized Integer setMethaneConcentrationEnvironmentalSensingTriggerSetting(@NonNull EnvironmentalSensingTriggerSetting environmentalSensingTriggerSetting) {
        return setMethaneConcentrationEnvironmentalSensingTriggerSetting(0, 0, environmentalSensingTriggerSetting);
    }

    /**
     * @see EnvironmentalSensingService#setMethaneConcentrationEnvironmentalSensingTriggerSetting(int, int, EnvironmentalSensingTriggerSetting)
     */
    @Nullable
    public synchronized Integer setMethaneConcentrationEnvironmentalSensingTriggerSetting(int characteristicIndex, int descriptorIndex, @NonNull EnvironmentalSensingTriggerSetting environmentalSensingTriggerSetting) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.setMethaneConcentrationEnvironmentalSensingTriggerSetting(characteristicIndex, descriptorIndex, environmentalSensingTriggerSetting);
        }
        return taskId;
    }

    /**
     * @see #getMethaneConcentrationEnvironmentalSensingConfiguration(int)
     */
    @Nullable
    public synchronized Integer getMethaneConcentrationEnvironmentalSensingConfiguration() {
        return getMethaneConcentrationEnvironmentalSensingConfiguration(0);
    }

    /**
     * @see EnvironmentalSensingService#getMethaneConcentrationEnvironmentalSensingConfiguration(int)
     */
    @Nullable
    public synchronized Integer getMethaneConcentrationEnvironmentalSensingConfiguration(int index) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.getMethaneConcentrationEnvironmentalSensingConfiguration(index);
        }
        return taskId;
    }

    /**
     * @see #setMethaneConcentrationEnvironmentalSensingConfiguration(int, EnvironmentalSensingConfiguration)
     */
    @Nullable
    public synchronized Integer setMethaneConcentrationEnvironmentalSensingConfiguration(@NonNull EnvironmentalSensingConfiguration environmentalSensingConfiguration) {
        return setMethaneConcentrationEnvironmentalSensingConfiguration(0, environmentalSensingConfiguration);
    }

    /**
     * @see EnvironmentalSensingService#setMethaneConcentrationEnvironmentalSensingConfiguration(int, EnvironmentalSensingConfiguration)
     */
    @Nullable
    public synchronized Integer setMethaneConcentrationEnvironmentalSensingConfiguration(int index, @NonNull EnvironmentalSensingConfiguration environmentalSensingConfiguration) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.setMethaneConcentrationEnvironmentalSensingConfiguration(index, environmentalSensingConfiguration);
        }
        return taskId;
    }

    /**
     * @see #getMethaneConcentrationCharacteristicUserDescription(int)
     */
    @Nullable
    public synchronized Integer getMethaneConcentrationCharacteristicUserDescription() {
        return getMethaneConcentrationCharacteristicUserDescription(0);
    }

    /**
     * @see EnvironmentalSensingService#getMethaneConcentrationCharacteristicUserDescription(int)
     */
    @Nullable
    public synchronized Integer getMethaneConcentrationCharacteristicUserDescription(int index) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.getMethaneConcentrationCharacteristicUserDescription(index);
        }
        return taskId;
    }

    /**
     * @see #setMethaneConcentrationCharacteristicUserDescription(int, CharacteristicUserDescription)
     */
    @Nullable
    public synchronized Integer setMethaneConcentrationCharacteristicUserDescription(@NonNull CharacteristicUserDescription characteristicUserDescription) {
        return setMethaneConcentrationCharacteristicUserDescription(0, characteristicUserDescription);
    }

    /**
     * @see EnvironmentalSensingService#setMethaneConcentrationCharacteristicUserDescription(int, CharacteristicUserDescription)
     */
    @Nullable
    public synchronized Integer setMethaneConcentrationCharacteristicUserDescription(int index, @NonNull CharacteristicUserDescription characteristicUserDescription) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.setMethaneConcentrationCharacteristicUserDescription(index, characteristicUserDescription);
        }
        return taskId;
    }

    /**
     * @see #getMethaneConcentrationValidRange(int)
     */
    @Nullable
    public synchronized Integer getMethaneConcentrationValidRange() {
        return getMethaneConcentrationValidRange(0);
    }

    /**
     * @see EnvironmentalSensingService#getMethaneConcentrationValidRange(int)
     */
    @Nullable
    public synchronized Integer getMethaneConcentrationValidRange(int index) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.getMethaneConcentrationValidRange(index);
        }
        return taskId;
    }

    /**
     * @see EnvironmentalSensingService#getNitrogenDioxideConcentrationCount()
     */
    @Nullable
    public synchronized Integer getNitrogenDioxideConcentrationCount() {
        Integer count = null;
        if (mEnvironmentalSensingService != null) {
            count = mEnvironmentalSensingService.getNitrogenDioxideConcentrationCount();
        }
        return count;
    }

    /**
     * @see #canNitrogenDioxideConcentrationNotify(int)
     */
    public synchronized Boolean canNitrogenDioxideConcentrationNotify() {
        return canNitrogenDioxideConcentrationNotify(0);
    }

    /**
     * @see EnvironmentalSensingService#canNitrogenDioxideConcentrationNotify(int)
     */
    public synchronized Boolean canNitrogenDioxideConcentrationNotify(int index) {
        Boolean result = null;
        if (mEnvironmentalSensingService != null) {
            result = mEnvironmentalSensingService.canNitrogenDioxideConcentrationNotify(index);
        }
        return result;
    }

    /**
     * @see #hasNitrogenDioxideConcentrationCharacteristicEnvironmentalSensingMeasurement(int)
     */
    public synchronized Boolean hasNitrogenDioxideConcentrationCharacteristicEnvironmentalSensingMeasurement() {
        return hasNitrogenDioxideConcentrationCharacteristicEnvironmentalSensingMeasurement(0);
    }

    /**
     * @see EnvironmentalSensingService#hasNitrogenDioxideConcentrationCharacteristicEnvironmentalSensingMeasurement(int)
     */
    public synchronized Boolean hasNitrogenDioxideConcentrationCharacteristicEnvironmentalSensingMeasurement(int index) {
        Boolean result = null;
        if (mEnvironmentalSensingService != null) {
            result = mEnvironmentalSensingService.hasNitrogenDioxideConcentrationCharacteristicEnvironmentalSensingMeasurement(index);
        }
        return result;
    }

    /**
     * @see #getNitrogenDioxideConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount(int)
     */
    public synchronized Integer getNitrogenDioxideConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount() {
        return getNitrogenDioxideConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount(0);
    }

    /**
     * @see EnvironmentalSensingService#getNitrogenDioxideConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount(int)
     */
    @Nullable
    public synchronized Integer getNitrogenDioxideConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount(int index) {
        Integer count = null;
        if (mEnvironmentalSensingService != null) {
            count = mEnvironmentalSensingService.getNitrogenDioxideConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount(index);
        }
        return count;
    }

    /**
     * @see #hasNitrogenDioxideConcentrationCharacteristicEnvironmentalSensingConfiguration(int)
     */
    public synchronized Boolean hasNitrogenDioxideConcentrationCharacteristicEnvironmentalSensingConfiguration() {
        return hasNitrogenDioxideConcentrationCharacteristicEnvironmentalSensingConfiguration(0);
    }

    /**
     * @see EnvironmentalSensingService#hasNitrogenDioxideConcentrationCharacteristicEnvironmentalSensingConfiguration(int)
     */
    public synchronized Boolean hasNitrogenDioxideConcentrationCharacteristicEnvironmentalSensingConfiguration(int index) {
        Boolean result = null;
        if (mEnvironmentalSensingService != null) {
            result = mEnvironmentalSensingService.hasNitrogenDioxideConcentrationCharacteristicEnvironmentalSensingConfiguration(index);
        }
        return result;
    }

    /**
     * @see #hasNitrogenDioxideConcentrationCharacteristicCharacteristicUserDescription(int)
     */
    public synchronized Boolean hasNitrogenDioxideConcentrationCharacteristicCharacteristicUserDescription() {
        return hasNitrogenDioxideConcentrationCharacteristicCharacteristicUserDescription(0);
    }

    /**
     * @see EnvironmentalSensingService#hasNitrogenDioxideConcentrationCharacteristicCharacteristicUserDescription(int)
     */
    public synchronized Boolean hasNitrogenDioxideConcentrationCharacteristicCharacteristicUserDescription(int index) {
        Boolean result = null;
        if (mEnvironmentalSensingService != null) {
            result = mEnvironmentalSensingService.hasNitrogenDioxideConcentrationCharacteristicCharacteristicUserDescription(index);
        }
        return result;
    }

    /**
     * @see #hasNitrogenDioxideConcentrationCharacteristicValidRange(int)
     */
    public synchronized Boolean hasNitrogenDioxideConcentrationCharacteristicValidRange() {
        return hasNitrogenDioxideConcentrationCharacteristicValidRange(0);
    }

    /**
     * @see EnvironmentalSensingService#hasNitrogenDioxideConcentrationCharacteristicValidRange(int)
     */
    public synchronized Boolean hasNitrogenDioxideConcentrationCharacteristicValidRange(int index) {
        Boolean result = null;
        if (mEnvironmentalSensingService != null) {
            result = mEnvironmentalSensingService.hasNitrogenDioxideConcentrationCharacteristicValidRange(index);
        }
        return result;
    }

    /**
     * @see #getNitrogenDioxideConcentration(int)
     */
    @Nullable
    public synchronized Integer getNitrogenDioxideConcentration() {
        return getNitrogenDioxideConcentration(0);
    }

    /**
     * @see EnvironmentalSensingService#getNitrogenDioxideConcentration(int)
     */
    @Nullable
    public synchronized Integer getNitrogenDioxideConcentration(int index) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.getNitrogenDioxideConcentration(index);
        }
        return taskId;
    }

    /**
     * @see #startNitrogenDioxideConcentrationNotification(int)
     */
    @Nullable
    public synchronized Integer startNitrogenDioxideConcentrationNotification() {
        return startNitrogenDioxideConcentrationNotification(0);
    }

    /**
     * @see EnvironmentalSensingService#startNitrogenDioxideConcentrationNotification(int)
     */
    @Nullable
    public synchronized Integer startNitrogenDioxideConcentrationNotification(int index) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.startNitrogenDioxideConcentrationNotification(index);
        }
        return taskId;
    }

    /**
     * @see #startNitrogenDioxideConcentrationNotification(int)
     */
    @Nullable
    public synchronized Integer stopNitrogenDioxideConcentrationNotification() {
        return stopNitrogenDioxideConcentrationNotification(0);
    }

    /**
     * @see EnvironmentalSensingService#stopNitrogenDioxideConcentrationNotification(int)
     */
    @Nullable
    public synchronized Integer stopNitrogenDioxideConcentrationNotification(int index) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.stopNitrogenDioxideConcentrationNotification(index);
        }
        return taskId;
    }

    /**
     * @see #getNitrogenDioxideConcentrationEnvironmentalSensingMeasurement(int)
     */
    @Nullable
    public synchronized Integer getNitrogenDioxideConcentrationEnvironmentalSensingMeasurement() {
        return getNitrogenDioxideConcentrationEnvironmentalSensingMeasurement(0);
    }

    /**
     * @see EnvironmentalSensingService#getNitrogenDioxideConcentrationEnvironmentalSensingMeasurement(int)
     */
    @Nullable
    public synchronized Integer getNitrogenDioxideConcentrationEnvironmentalSensingMeasurement(int index) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.getNitrogenDioxideConcentrationEnvironmentalSensingMeasurement(index);
        }
        return taskId;
    }

    /**
     * @see #getNitrogenDioxideConcentrationEnvironmentalSensingTriggerSetting(int, int)
     */
    @Nullable
    public synchronized Integer getNitrogenDioxideConcentrationEnvironmentalSensingTriggerSetting() {
        return getNitrogenDioxideConcentrationEnvironmentalSensingTriggerSetting(0, 0);
    }

    /**
     * @see EnvironmentalSensingService#getNitrogenDioxideConcentrationEnvironmentalSensingTriggerSetting(int, int)
     */
    @Nullable
    public synchronized Integer getNitrogenDioxideConcentrationEnvironmentalSensingTriggerSetting(int characteristicIndex, int descriptorIndex) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.getNitrogenDioxideConcentrationEnvironmentalSensingTriggerSetting(characteristicIndex, descriptorIndex);
        }
        return taskId;
    }

    /**
     * @see #setNitrogenDioxideConcentrationEnvironmentalSensingTriggerSetting(int, int, EnvironmentalSensingTriggerSetting)
     */
    @Nullable
    public synchronized Integer setNitrogenDioxideConcentrationEnvironmentalSensingTriggerSetting(@NonNull EnvironmentalSensingTriggerSetting environmentalSensingTriggerSetting) {
        return setNitrogenDioxideConcentrationEnvironmentalSensingTriggerSetting(0, 0, environmentalSensingTriggerSetting);
    }

    /**
     * @see EnvironmentalSensingService#setNitrogenDioxideConcentrationEnvironmentalSensingTriggerSetting(int, int, EnvironmentalSensingTriggerSetting)
     */
    @Nullable
    public synchronized Integer setNitrogenDioxideConcentrationEnvironmentalSensingTriggerSetting(int characteristicIndex, int descriptorIndex, @NonNull EnvironmentalSensingTriggerSetting environmentalSensingTriggerSetting) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.setNitrogenDioxideConcentrationEnvironmentalSensingTriggerSetting(characteristicIndex, descriptorIndex, environmentalSensingTriggerSetting);
        }
        return taskId;
    }

    /**
     * @see #getNitrogenDioxideConcentrationEnvironmentalSensingConfiguration(int)
     */
    @Nullable
    public synchronized Integer getNitrogenDioxideConcentrationEnvironmentalSensingConfiguration() {
        return getNitrogenDioxideConcentrationEnvironmentalSensingConfiguration(0);
    }

    /**
     * @see EnvironmentalSensingService#getNitrogenDioxideConcentrationEnvironmentalSensingConfiguration(int)
     */
    @Nullable
    public synchronized Integer getNitrogenDioxideConcentrationEnvironmentalSensingConfiguration(int index) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.getNitrogenDioxideConcentrationEnvironmentalSensingConfiguration(index);
        }
        return taskId;
    }

    /**
     * @see #setNitrogenDioxideConcentrationEnvironmentalSensingConfiguration(int, EnvironmentalSensingConfiguration)
     */
    @Nullable
    public synchronized Integer setNitrogenDioxideConcentrationEnvironmentalSensingConfiguration(@NonNull EnvironmentalSensingConfiguration environmentalSensingConfiguration) {
        return setNitrogenDioxideConcentrationEnvironmentalSensingConfiguration(0, environmentalSensingConfiguration);
    }

    /**
     * @see EnvironmentalSensingService#setNitrogenDioxideConcentrationEnvironmentalSensingConfiguration(int, EnvironmentalSensingConfiguration)
     */
    @Nullable
    public synchronized Integer setNitrogenDioxideConcentrationEnvironmentalSensingConfiguration(int index, @NonNull EnvironmentalSensingConfiguration environmentalSensingConfiguration) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.setNitrogenDioxideConcentrationEnvironmentalSensingConfiguration(index, environmentalSensingConfiguration);
        }
        return taskId;
    }

    /**
     * @see #getNitrogenDioxideConcentrationCharacteristicUserDescription(int)
     */
    @Nullable
    public synchronized Integer getNitrogenDioxideConcentrationCharacteristicUserDescription() {
        return getNitrogenDioxideConcentrationCharacteristicUserDescription(0);
    }

    /**
     * @see EnvironmentalSensingService#getNitrogenDioxideConcentrationCharacteristicUserDescription(int)
     */
    @Nullable
    public synchronized Integer getNitrogenDioxideConcentrationCharacteristicUserDescription(int index) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.getNitrogenDioxideConcentrationCharacteristicUserDescription(index);
        }
        return taskId;
    }

    /**
     * @see #setNitrogenDioxideConcentrationCharacteristicUserDescription(int, CharacteristicUserDescription)
     */
    @Nullable
    public synchronized Integer setNitrogenDioxideConcentrationCharacteristicUserDescription(@NonNull CharacteristicUserDescription characteristicUserDescription) {
        return setNitrogenDioxideConcentrationCharacteristicUserDescription(0, characteristicUserDescription);
    }

    /**
     * @see EnvironmentalSensingService#setNitrogenDioxideConcentrationCharacteristicUserDescription(int, CharacteristicUserDescription)
     */
    @Nullable
    public synchronized Integer setNitrogenDioxideConcentrationCharacteristicUserDescription(int index, @NonNull CharacteristicUserDescription characteristicUserDescription) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.setNitrogenDioxideConcentrationCharacteristicUserDescription(index, characteristicUserDescription);
        }
        return taskId;
    }

    /**
     * @see #getNitrogenDioxideConcentrationValidRange(int)
     */
    @Nullable
    public synchronized Integer getNitrogenDioxideConcentrationValidRange() {
        return getNitrogenDioxideConcentrationValidRange(0);
    }

    /**
     * @see EnvironmentalSensingService#getNitrogenDioxideConcentrationValidRange(int)
     */
    @Nullable
    public synchronized Integer getNitrogenDioxideConcentrationValidRange(int index) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.getNitrogenDioxideConcentrationValidRange(index);
        }
        return taskId;
    }

    /**
     * @see EnvironmentalSensingService#getNonMethaneVolatileOrganicCompoundsConcentrationCount()
     */
    @Nullable
    public synchronized Integer getNonMethaneVolatileOrganicCompoundsConcentrationCount() {
        Integer count = null;
        if (mEnvironmentalSensingService != null) {
            count = mEnvironmentalSensingService.getNonMethaneVolatileOrganicCompoundsConcentrationCount();
        }
        return count;
    }

    /**
     * @see #canNonMethaneVolatileOrganicCompoundsConcentrationNotify(int)
     */
    public synchronized Boolean canNonMethaneVolatileOrganicCompoundsConcentrationNotify() {
        return canNonMethaneVolatileOrganicCompoundsConcentrationNotify(0);
    }

    /**
     * @see EnvironmentalSensingService#canNonMethaneVolatileOrganicCompoundsConcentrationNotify(int)
     */
    public synchronized Boolean canNonMethaneVolatileOrganicCompoundsConcentrationNotify(int index) {
        Boolean result = null;
        if (mEnvironmentalSensingService != null) {
            result = mEnvironmentalSensingService.canNonMethaneVolatileOrganicCompoundsConcentrationNotify(index);
        }
        return result;
    }

    /**
     * @see #hasNonMethaneVolatileOrganicCompoundsConcentrationCharacteristicEnvironmentalSensingMeasurement(int)
     */
    public synchronized Boolean hasNonMethaneVolatileOrganicCompoundsConcentrationCharacteristicEnvironmentalSensingMeasurement() {
        return hasNonMethaneVolatileOrganicCompoundsConcentrationCharacteristicEnvironmentalSensingMeasurement(0);
    }

    /**
     * @see EnvironmentalSensingService#hasNonMethaneVolatileOrganicCompoundsConcentrationCharacteristicEnvironmentalSensingMeasurement(int)
     */
    public synchronized Boolean hasNonMethaneVolatileOrganicCompoundsConcentrationCharacteristicEnvironmentalSensingMeasurement(int index) {
        Boolean result = null;
        if (mEnvironmentalSensingService != null) {
            result = mEnvironmentalSensingService.hasNonMethaneVolatileOrganicCompoundsConcentrationCharacteristicEnvironmentalSensingMeasurement(index);
        }
        return result;
    }

    /**
     * @see #getNonMethaneVolatileOrganicCompoundsConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount(int)
     */
    public synchronized Integer getNonMethaneVolatileOrganicCompoundsConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount() {
        return getNonMethaneVolatileOrganicCompoundsConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount(0);
    }

    /**
     * @see EnvironmentalSensingService#getNonMethaneVolatileOrganicCompoundsConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount(int)
     */
    @Nullable
    public synchronized Integer getNonMethaneVolatileOrganicCompoundsConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount(int index) {
        Integer count = null;
        if (mEnvironmentalSensingService != null) {
            count = mEnvironmentalSensingService.getNonMethaneVolatileOrganicCompoundsConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount(index);
        }
        return count;
    }

    /**
     * @see #hasNonMethaneVolatileOrganicCompoundsConcentrationCharacteristicEnvironmentalSensingConfiguration(int)
     */
    public synchronized Boolean hasNonMethaneVolatileOrganicCompoundsConcentrationCharacteristicEnvironmentalSensingConfiguration() {
        return hasNonMethaneVolatileOrganicCompoundsConcentrationCharacteristicEnvironmentalSensingConfiguration(0);
    }

    /**
     * @see EnvironmentalSensingService#hasNonMethaneVolatileOrganicCompoundsConcentrationCharacteristicEnvironmentalSensingConfiguration(int)
     */
    public synchronized Boolean hasNonMethaneVolatileOrganicCompoundsConcentrationCharacteristicEnvironmentalSensingConfiguration(int index) {
        Boolean result = null;
        if (mEnvironmentalSensingService != null) {
            result = mEnvironmentalSensingService.hasNonMethaneVolatileOrganicCompoundsConcentrationCharacteristicEnvironmentalSensingConfiguration(index);
        }
        return result;
    }

    /**
     * @see #hasNonMethaneVolatileOrganicCompoundsConcentrationCharacteristicCharacteristicUserDescription(int)
     */
    public synchronized Boolean hasNonMethaneVolatileOrganicCompoundsConcentrationCharacteristicCharacteristicUserDescription() {
        return hasNonMethaneVolatileOrganicCompoundsConcentrationCharacteristicCharacteristicUserDescription(0);
    }

    /**
     * @see EnvironmentalSensingService#hasNonMethaneVolatileOrganicCompoundsConcentrationCharacteristicCharacteristicUserDescription(int)
     */
    public synchronized Boolean hasNonMethaneVolatileOrganicCompoundsConcentrationCharacteristicCharacteristicUserDescription(int index) {
        Boolean result = null;
        if (mEnvironmentalSensingService != null) {
            result = mEnvironmentalSensingService.hasNonMethaneVolatileOrganicCompoundsConcentrationCharacteristicCharacteristicUserDescription(index);
        }
        return result;
    }

    /**
     * @see #hasNonMethaneVolatileOrganicCompoundsConcentrationCharacteristicValidRange(int)
     */
    public synchronized Boolean hasNonMethaneVolatileOrganicCompoundsConcentrationCharacteristicValidRange() {
        return hasNonMethaneVolatileOrganicCompoundsConcentrationCharacteristicValidRange(0);
    }

    /**
     * @see EnvironmentalSensingService#hasNonMethaneVolatileOrganicCompoundsConcentrationCharacteristicValidRange(int)
     */
    public synchronized Boolean hasNonMethaneVolatileOrganicCompoundsConcentrationCharacteristicValidRange(int index) {
        Boolean result = null;
        if (mEnvironmentalSensingService != null) {
            result = mEnvironmentalSensingService.hasNonMethaneVolatileOrganicCompoundsConcentrationCharacteristicValidRange(index);
        }
        return result;
    }

    /**
     * @see #getNonMethaneVolatileOrganicCompoundsConcentration(int)
     */
    @Nullable
    public synchronized Integer getNonMethaneVolatileOrganicCompoundsConcentration() {
        return getNonMethaneVolatileOrganicCompoundsConcentration(0);
    }

    /**
     * @see EnvironmentalSensingService#getNonMethaneVolatileOrganicCompoundsConcentration(int)
     */
    @Nullable
    public synchronized Integer getNonMethaneVolatileOrganicCompoundsConcentration(int index) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.getNonMethaneVolatileOrganicCompoundsConcentration(index);
        }
        return taskId;
    }

    /**
     * @see #startNonMethaneVolatileOrganicCompoundsConcentrationNotification(int)
     */
    @Nullable
    public synchronized Integer startNonMethaneVolatileOrganicCompoundsConcentrationNotification() {
        return startNonMethaneVolatileOrganicCompoundsConcentrationNotification(0);
    }

    /**
     * @see EnvironmentalSensingService#startNonMethaneVolatileOrganicCompoundsConcentrationNotification(int)
     */
    @Nullable
    public synchronized Integer startNonMethaneVolatileOrganicCompoundsConcentrationNotification(int index) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.startNonMethaneVolatileOrganicCompoundsConcentrationNotification(index);
        }
        return taskId;
    }

    /**
     * @see #startNonMethaneVolatileOrganicCompoundsConcentrationNotification(int)
     */
    @Nullable
    public synchronized Integer stopNonMethaneVolatileOrganicCompoundsConcentrationNotification() {
        return stopNonMethaneVolatileOrganicCompoundsConcentrationNotification(0);
    }

    /**
     * @see EnvironmentalSensingService#stopNonMethaneVolatileOrganicCompoundsConcentrationNotification(int)
     */
    @Nullable
    public synchronized Integer stopNonMethaneVolatileOrganicCompoundsConcentrationNotification(int index) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.stopNonMethaneVolatileOrganicCompoundsConcentrationNotification(index);
        }
        return taskId;
    }

    /**
     * @see #getNonMethaneVolatileOrganicCompoundsConcentrationEnvironmentalSensingMeasurement(int)
     */
    @Nullable
    public synchronized Integer getNonMethaneVolatileOrganicCompoundsConcentrationEnvironmentalSensingMeasurement() {
        return getNonMethaneVolatileOrganicCompoundsConcentrationEnvironmentalSensingMeasurement(0);
    }

    /**
     * @see EnvironmentalSensingService#getNonMethaneVolatileOrganicCompoundsConcentrationEnvironmentalSensingMeasurement(int)
     */
    @Nullable
    public synchronized Integer getNonMethaneVolatileOrganicCompoundsConcentrationEnvironmentalSensingMeasurement(int index) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.getNonMethaneVolatileOrganicCompoundsConcentrationEnvironmentalSensingMeasurement(index);
        }
        return taskId;
    }

    /**
     * @see #getNonMethaneVolatileOrganicCompoundsConcentrationEnvironmentalSensingTriggerSetting(int, int)
     */
    @Nullable
    public synchronized Integer getNonMethaneVolatileOrganicCompoundsConcentrationEnvironmentalSensingTriggerSetting() {
        return getNonMethaneVolatileOrganicCompoundsConcentrationEnvironmentalSensingTriggerSetting(0, 0);
    }

    /**
     * @see EnvironmentalSensingService#getNonMethaneVolatileOrganicCompoundsConcentrationEnvironmentalSensingTriggerSetting(int, int)
     */
    @Nullable
    public synchronized Integer getNonMethaneVolatileOrganicCompoundsConcentrationEnvironmentalSensingTriggerSetting(int characteristicIndex, int descriptorIndex) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.getNonMethaneVolatileOrganicCompoundsConcentrationEnvironmentalSensingTriggerSetting(characteristicIndex, descriptorIndex);
        }
        return taskId;
    }

    /**
     * @see #setNonMethaneVolatileOrganicCompoundsConcentrationEnvironmentalSensingTriggerSetting(int, int, EnvironmentalSensingTriggerSetting)
     */
    @Nullable
    public synchronized Integer setNonMethaneVolatileOrganicCompoundsConcentrationEnvironmentalSensingTriggerSetting(@NonNull EnvironmentalSensingTriggerSetting environmentalSensingTriggerSetting) {
        return setNonMethaneVolatileOrganicCompoundsConcentrationEnvironmentalSensingTriggerSetting(0, 0, environmentalSensingTriggerSetting);
    }

    /**
     * @see EnvironmentalSensingService#setNonMethaneVolatileOrganicCompoundsConcentrationEnvironmentalSensingTriggerSetting(int, int, EnvironmentalSensingTriggerSetting)
     */
    @Nullable
    public synchronized Integer setNonMethaneVolatileOrganicCompoundsConcentrationEnvironmentalSensingTriggerSetting(int characteristicIndex, int descriptorIndex, @NonNull EnvironmentalSensingTriggerSetting environmentalSensingTriggerSetting) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.setNonMethaneVolatileOrganicCompoundsConcentrationEnvironmentalSensingTriggerSetting(characteristicIndex, descriptorIndex, environmentalSensingTriggerSetting);
        }
        return taskId;
    }

    /**
     * @see #getNonMethaneVolatileOrganicCompoundsConcentrationEnvironmentalSensingConfiguration(int)
     */
    @Nullable
    public synchronized Integer getNonMethaneVolatileOrganicCompoundsConcentrationEnvironmentalSensingConfiguration() {
        return getNonMethaneVolatileOrganicCompoundsConcentrationEnvironmentalSensingConfiguration(0);
    }

    /**
     * @see EnvironmentalSensingService#getNonMethaneVolatileOrganicCompoundsConcentrationEnvironmentalSensingConfiguration(int)
     */
    @Nullable
    public synchronized Integer getNonMethaneVolatileOrganicCompoundsConcentrationEnvironmentalSensingConfiguration(int index) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.getNonMethaneVolatileOrganicCompoundsConcentrationEnvironmentalSensingConfiguration(index);
        }
        return taskId;
    }

    /**
     * @see #setNonMethaneVolatileOrganicCompoundsConcentrationEnvironmentalSensingConfiguration(int, EnvironmentalSensingConfiguration)
     */
    @Nullable
    public synchronized Integer setNonMethaneVolatileOrganicCompoundsConcentrationEnvironmentalSensingConfiguration(@NonNull EnvironmentalSensingConfiguration environmentalSensingConfiguration) {
        return setNonMethaneVolatileOrganicCompoundsConcentrationEnvironmentalSensingConfiguration(0, environmentalSensingConfiguration);
    }

    /**
     * @see EnvironmentalSensingService#setNonMethaneVolatileOrganicCompoundsConcentrationEnvironmentalSensingConfiguration(int, EnvironmentalSensingConfiguration)
     */
    @Nullable
    public synchronized Integer setNonMethaneVolatileOrganicCompoundsConcentrationEnvironmentalSensingConfiguration(int index, @NonNull EnvironmentalSensingConfiguration environmentalSensingConfiguration) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.setNonMethaneVolatileOrganicCompoundsConcentrationEnvironmentalSensingConfiguration(index, environmentalSensingConfiguration);
        }
        return taskId;
    }

    /**
     * @see #getNonMethaneVolatileOrganicCompoundsConcentrationCharacteristicUserDescription(int)
     */
    @Nullable
    public synchronized Integer getNonMethaneVolatileOrganicCompoundsConcentrationCharacteristicUserDescription() {
        return getNonMethaneVolatileOrganicCompoundsConcentrationCharacteristicUserDescription(0);
    }

    /**
     * @see EnvironmentalSensingService#getNonMethaneVolatileOrganicCompoundsConcentrationCharacteristicUserDescription(int)
     */
    @Nullable
    public synchronized Integer getNonMethaneVolatileOrganicCompoundsConcentrationCharacteristicUserDescription(int index) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.getNonMethaneVolatileOrganicCompoundsConcentrationCharacteristicUserDescription(index);
        }
        return taskId;
    }

    /**
     * @see #setNonMethaneVolatileOrganicCompoundsConcentrationCharacteristicUserDescription(int, CharacteristicUserDescription)
     */
    @Nullable
    public synchronized Integer setNonMethaneVolatileOrganicCompoundsConcentrationCharacteristicUserDescription(@NonNull CharacteristicUserDescription characteristicUserDescription) {
        return setNonMethaneVolatileOrganicCompoundsConcentrationCharacteristicUserDescription(0, characteristicUserDescription);
    }

    /**
     * @see EnvironmentalSensingService#setNonMethaneVolatileOrganicCompoundsConcentrationCharacteristicUserDescription(int, CharacteristicUserDescription)
     */
    @Nullable
    public synchronized Integer setNonMethaneVolatileOrganicCompoundsConcentrationCharacteristicUserDescription(int index, @NonNull CharacteristicUserDescription characteristicUserDescription) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.setNonMethaneVolatileOrganicCompoundsConcentrationCharacteristicUserDescription(index, characteristicUserDescription);
        }
        return taskId;
    }

    /**
     * @see #getNonMethaneVolatileOrganicCompoundsConcentrationValidRange(int)
     */
    @Nullable
    public synchronized Integer getNonMethaneVolatileOrganicCompoundsConcentrationValidRange() {
        return getNonMethaneVolatileOrganicCompoundsConcentrationValidRange(0);
    }

    /**
     * @see EnvironmentalSensingService#getNonMethaneVolatileOrganicCompoundsConcentrationValidRange(int)
     */
    @Nullable
    public synchronized Integer getNonMethaneVolatileOrganicCompoundsConcentrationValidRange(int index) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.getNonMethaneVolatileOrganicCompoundsConcentrationValidRange(index);
        }
        return taskId;
    }

    /**
     * @see EnvironmentalSensingService#getOzoneConcentrationCount()
     */
    @Nullable
    public synchronized Integer getOzoneConcentrationCount() {
        Integer count = null;
        if (mEnvironmentalSensingService != null) {
            count = mEnvironmentalSensingService.getOzoneConcentrationCount();
        }
        return count;
    }

    /**
     * @see #canOzoneConcentrationNotify(int)
     */
    public synchronized Boolean canOzoneConcentrationNotify() {
        return canOzoneConcentrationNotify(0);
    }

    /**
     * @see EnvironmentalSensingService#canOzoneConcentrationNotify(int)
     */
    public synchronized Boolean canOzoneConcentrationNotify(int index) {
        Boolean result = null;
        if (mEnvironmentalSensingService != null) {
            result = mEnvironmentalSensingService.canOzoneConcentrationNotify(index);
        }
        return result;
    }

    /**
     * @see #hasOzoneConcentrationCharacteristicEnvironmentalSensingMeasurement(int)
     */
    public synchronized Boolean hasOzoneConcentrationCharacteristicEnvironmentalSensingMeasurement() {
        return hasOzoneConcentrationCharacteristicEnvironmentalSensingMeasurement(0);
    }

    /**
     * @see EnvironmentalSensingService#hasOzoneConcentrationCharacteristicEnvironmentalSensingMeasurement(int)
     */
    public synchronized Boolean hasOzoneConcentrationCharacteristicEnvironmentalSensingMeasurement(int index) {
        Boolean result = null;
        if (mEnvironmentalSensingService != null) {
            result = mEnvironmentalSensingService.hasOzoneConcentrationCharacteristicEnvironmentalSensingMeasurement(index);
        }
        return result;
    }

    /**
     * @see #getOzoneConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount(int)
     */
    public synchronized Integer getOzoneConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount() {
        return getOzoneConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount(0);
    }

    /**
     * @see EnvironmentalSensingService#getOzoneConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount(int)
     */
    @Nullable
    public synchronized Integer getOzoneConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount(int index) {
        Integer count = null;
        if (mEnvironmentalSensingService != null) {
            count = mEnvironmentalSensingService.getOzoneConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount(index);
        }
        return count;
    }

    /**
     * @see #hasOzoneConcentrationCharacteristicEnvironmentalSensingConfiguration(int)
     */
    public synchronized Boolean hasOzoneConcentrationCharacteristicEnvironmentalSensingConfiguration() {
        return hasOzoneConcentrationCharacteristicEnvironmentalSensingConfiguration(0);
    }

    /**
     * @see EnvironmentalSensingService#hasOzoneConcentrationCharacteristicEnvironmentalSensingConfiguration(int)
     */
    public synchronized Boolean hasOzoneConcentrationCharacteristicEnvironmentalSensingConfiguration(int index) {
        Boolean result = null;
        if (mEnvironmentalSensingService != null) {
            result = mEnvironmentalSensingService.hasOzoneConcentrationCharacteristicEnvironmentalSensingConfiguration(index);
        }
        return result;
    }

    /**
     * @see #hasOzoneConcentrationCharacteristicCharacteristicUserDescription(int)
     */
    public synchronized Boolean hasOzoneConcentrationCharacteristicCharacteristicUserDescription() {
        return hasOzoneConcentrationCharacteristicCharacteristicUserDescription(0);
    }

    /**
     * @see EnvironmentalSensingService#hasOzoneConcentrationCharacteristicCharacteristicUserDescription(int)
     */
    public synchronized Boolean hasOzoneConcentrationCharacteristicCharacteristicUserDescription(int index) {
        Boolean result = null;
        if (mEnvironmentalSensingService != null) {
            result = mEnvironmentalSensingService.hasOzoneConcentrationCharacteristicCharacteristicUserDescription(index);
        }
        return result;
    }

    /**
     * @see #hasOzoneConcentrationCharacteristicValidRange(int)
     */
    public synchronized Boolean hasOzoneConcentrationCharacteristicValidRange() {
        return hasOzoneConcentrationCharacteristicValidRange(0);
    }

    /**
     * @see EnvironmentalSensingService#hasOzoneConcentrationCharacteristicValidRange(int)
     */
    public synchronized Boolean hasOzoneConcentrationCharacteristicValidRange(int index) {
        Boolean result = null;
        if (mEnvironmentalSensingService != null) {
            result = mEnvironmentalSensingService.hasOzoneConcentrationCharacteristicValidRange(index);
        }
        return result;
    }

    /**
     * @see #getOzoneConcentration(int)
     */
    @Nullable
    public synchronized Integer getOzoneConcentration() {
        return getOzoneConcentration(0);
    }

    /**
     * @see EnvironmentalSensingService#getOzoneConcentration(int)
     */
    @Nullable
    public synchronized Integer getOzoneConcentration(int index) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.getOzoneConcentration(index);
        }
        return taskId;
    }

    /**
     * @see #startOzoneConcentrationNotification(int)
     */
    @Nullable
    public synchronized Integer startOzoneConcentrationNotification() {
        return startOzoneConcentrationNotification(0);
    }

    /**
     * @see EnvironmentalSensingService#startOzoneConcentrationNotification(int)
     */
    @Nullable
    public synchronized Integer startOzoneConcentrationNotification(int index) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.startOzoneConcentrationNotification(index);
        }
        return taskId;
    }

    /**
     * @see #startOzoneConcentrationNotification(int)
     */
    @Nullable
    public synchronized Integer stopOzoneConcentrationNotification() {
        return stopOzoneConcentrationNotification(0);
    }

    /**
     * @see EnvironmentalSensingService#stopOzoneConcentrationNotification(int)
     */
    @Nullable
    public synchronized Integer stopOzoneConcentrationNotification(int index) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.stopOzoneConcentrationNotification(index);
        }
        return taskId;
    }

    /**
     * @see #getOzoneConcentrationEnvironmentalSensingMeasurement(int)
     */
    @Nullable
    public synchronized Integer getOzoneConcentrationEnvironmentalSensingMeasurement() {
        return getOzoneConcentrationEnvironmentalSensingMeasurement(0);
    }

    /**
     * @see EnvironmentalSensingService#getOzoneConcentrationEnvironmentalSensingMeasurement(int)
     */
    @Nullable
    public synchronized Integer getOzoneConcentrationEnvironmentalSensingMeasurement(int index) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.getOzoneConcentrationEnvironmentalSensingMeasurement(index);
        }
        return taskId;
    }

    /**
     * @see #getOzoneConcentrationEnvironmentalSensingTriggerSetting(int, int)
     */
    @Nullable
    public synchronized Integer getOzoneConcentrationEnvironmentalSensingTriggerSetting() {
        return getOzoneConcentrationEnvironmentalSensingTriggerSetting(0, 0);
    }

    /**
     * @see EnvironmentalSensingService#getOzoneConcentrationEnvironmentalSensingTriggerSetting(int, int)
     */
    @Nullable
    public synchronized Integer getOzoneConcentrationEnvironmentalSensingTriggerSetting(int characteristicIndex, int descriptorIndex) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.getOzoneConcentrationEnvironmentalSensingTriggerSetting(characteristicIndex, descriptorIndex);
        }
        return taskId;
    }

    /**
     * @see #setOzoneConcentrationEnvironmentalSensingTriggerSetting(int, int, EnvironmentalSensingTriggerSetting)
     */
    @Nullable
    public synchronized Integer setOzoneConcentrationEnvironmentalSensingTriggerSetting(@NonNull EnvironmentalSensingTriggerSetting environmentalSensingTriggerSetting) {
        return setOzoneConcentrationEnvironmentalSensingTriggerSetting(0, 0, environmentalSensingTriggerSetting);
    }

    /**
     * @see EnvironmentalSensingService#setOzoneConcentrationEnvironmentalSensingTriggerSetting(int, int, EnvironmentalSensingTriggerSetting)
     */
    @Nullable
    public synchronized Integer setOzoneConcentrationEnvironmentalSensingTriggerSetting(int characteristicIndex, int descriptorIndex, @NonNull EnvironmentalSensingTriggerSetting environmentalSensingTriggerSetting) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.setOzoneConcentrationEnvironmentalSensingTriggerSetting(characteristicIndex, descriptorIndex, environmentalSensingTriggerSetting);
        }
        return taskId;
    }

    /**
     * @see #getOzoneConcentrationEnvironmentalSensingConfiguration(int)
     */
    @Nullable
    public synchronized Integer getOzoneConcentrationEnvironmentalSensingConfiguration() {
        return getOzoneConcentrationEnvironmentalSensingConfiguration(0);
    }

    /**
     * @see EnvironmentalSensingService#getOzoneConcentrationEnvironmentalSensingConfiguration(int)
     */
    @Nullable
    public synchronized Integer getOzoneConcentrationEnvironmentalSensingConfiguration(int index) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.getOzoneConcentrationEnvironmentalSensingConfiguration(index);
        }
        return taskId;
    }

    /**
     * @see #setOzoneConcentrationEnvironmentalSensingConfiguration(int, EnvironmentalSensingConfiguration)
     */
    @Nullable
    public synchronized Integer setOzoneConcentrationEnvironmentalSensingConfiguration(@NonNull EnvironmentalSensingConfiguration environmentalSensingConfiguration) {
        return setOzoneConcentrationEnvironmentalSensingConfiguration(0, environmentalSensingConfiguration);
    }

    /**
     * @see EnvironmentalSensingService#setOzoneConcentrationEnvironmentalSensingConfiguration(int, EnvironmentalSensingConfiguration)
     */
    @Nullable
    public synchronized Integer setOzoneConcentrationEnvironmentalSensingConfiguration(int index, @NonNull EnvironmentalSensingConfiguration environmentalSensingConfiguration) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.setOzoneConcentrationEnvironmentalSensingConfiguration(index, environmentalSensingConfiguration);
        }
        return taskId;
    }

    /**
     * @see #getOzoneConcentrationCharacteristicUserDescription(int)
     */
    @Nullable
    public synchronized Integer getOzoneConcentrationCharacteristicUserDescription() {
        return getOzoneConcentrationCharacteristicUserDescription(0);
    }

    /**
     * @see EnvironmentalSensingService#getOzoneConcentrationCharacteristicUserDescription(int)
     */
    @Nullable
    public synchronized Integer getOzoneConcentrationCharacteristicUserDescription(int index) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.getOzoneConcentrationCharacteristicUserDescription(index);
        }
        return taskId;
    }

    /**
     * @see #setOzoneConcentrationCharacteristicUserDescription(int, CharacteristicUserDescription)
     */
    @Nullable
    public synchronized Integer setOzoneConcentrationCharacteristicUserDescription(@NonNull CharacteristicUserDescription characteristicUserDescription) {
        return setOzoneConcentrationCharacteristicUserDescription(0, characteristicUserDescription);
    }

    /**
     * @see EnvironmentalSensingService#setOzoneConcentrationCharacteristicUserDescription(int, CharacteristicUserDescription)
     */
    @Nullable
    public synchronized Integer setOzoneConcentrationCharacteristicUserDescription(int index, @NonNull CharacteristicUserDescription characteristicUserDescription) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.setOzoneConcentrationCharacteristicUserDescription(index, characteristicUserDescription);
        }
        return taskId;
    }

    /**
     * @see #getOzoneConcentrationValidRange(int)
     */
    @Nullable
    public synchronized Integer getOzoneConcentrationValidRange() {
        return getOzoneConcentrationValidRange(0);
    }

    /**
     * @see EnvironmentalSensingService#getOzoneConcentrationValidRange(int)
     */
    @Nullable
    public synchronized Integer getOzoneConcentrationValidRange(int index) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.getOzoneConcentrationValidRange(index);
        }
        return taskId;
    }

    /**
     * @see EnvironmentalSensingService#getParticulateMatterPm10ConcentrationCount()
     */
    @Nullable
    public synchronized Integer getParticulateMatterPm10ConcentrationCount() {
        Integer count = null;
        if (mEnvironmentalSensingService != null) {
            count = mEnvironmentalSensingService.getParticulateMatterPm10ConcentrationCount();
        }
        return count;
    }

    /**
     * @see #canParticulateMatterPm10ConcentrationNotify(int)
     */
    public synchronized Boolean canParticulateMatterPm10ConcentrationNotify() {
        return canParticulateMatterPm10ConcentrationNotify(0);
    }

    /**
     * @see EnvironmentalSensingService#canParticulateMatterPm10ConcentrationNotify(int)
     */
    public synchronized Boolean canParticulateMatterPm10ConcentrationNotify(int index) {
        Boolean result = null;
        if (mEnvironmentalSensingService != null) {
            result = mEnvironmentalSensingService.canParticulateMatterPm10ConcentrationNotify(index);
        }
        return result;
    }

    /**
     * @see #hasParticulateMatterPm10ConcentrationCharacteristicEnvironmentalSensingMeasurement(int)
     */
    public synchronized Boolean hasParticulateMatterPm10ConcentrationCharacteristicEnvironmentalSensingMeasurement() {
        return hasParticulateMatterPm10ConcentrationCharacteristicEnvironmentalSensingMeasurement(0);
    }

    /**
     * @see EnvironmentalSensingService#hasParticulateMatterPm10ConcentrationCharacteristicEnvironmentalSensingMeasurement(int)
     */
    public synchronized Boolean hasParticulateMatterPm10ConcentrationCharacteristicEnvironmentalSensingMeasurement(int index) {
        Boolean result = null;
        if (mEnvironmentalSensingService != null) {
            result = mEnvironmentalSensingService.hasParticulateMatterPm10ConcentrationCharacteristicEnvironmentalSensingMeasurement(index);
        }
        return result;
    }

    /**
     * @see #getParticulateMatterPm10ConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount(int)
     */
    public synchronized Integer getParticulateMatterPm10ConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount() {
        return getParticulateMatterPm10ConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount(0);
    }

    /**
     * @see EnvironmentalSensingService#getParticulateMatterPm10ConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount(int)
     */
    @Nullable
    public synchronized Integer getParticulateMatterPm10ConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount(int index) {
        Integer count = null;
        if (mEnvironmentalSensingService != null) {
            count = mEnvironmentalSensingService.getParticulateMatterPm10ConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount(index);
        }
        return count;
    }

    /**
     * @see #hasParticulateMatterPm10ConcentrationCharacteristicEnvironmentalSensingConfiguration(int)
     */
    public synchronized Boolean hasParticulateMatterPm10ConcentrationCharacteristicEnvironmentalSensingConfiguration() {
        return hasParticulateMatterPm10ConcentrationCharacteristicEnvironmentalSensingConfiguration(0);
    }

    /**
     * @see EnvironmentalSensingService#hasParticulateMatterPm10ConcentrationCharacteristicEnvironmentalSensingConfiguration(int)
     */
    public synchronized Boolean hasParticulateMatterPm10ConcentrationCharacteristicEnvironmentalSensingConfiguration(int index) {
        Boolean result = null;
        if (mEnvironmentalSensingService != null) {
            result = mEnvironmentalSensingService.hasParticulateMatterPm10ConcentrationCharacteristicEnvironmentalSensingConfiguration(index);
        }
        return result;
    }

    /**
     * @see #hasParticulateMatterPm10ConcentrationCharacteristicCharacteristicUserDescription(int)
     */
    public synchronized Boolean hasParticulateMatterPm10ConcentrationCharacteristicCharacteristicUserDescription() {
        return hasParticulateMatterPm10ConcentrationCharacteristicCharacteristicUserDescription(0);
    }

    /**
     * @see EnvironmentalSensingService#hasParticulateMatterPm10ConcentrationCharacteristicCharacteristicUserDescription(int)
     */
    public synchronized Boolean hasParticulateMatterPm10ConcentrationCharacteristicCharacteristicUserDescription(int index) {
        Boolean result = null;
        if (mEnvironmentalSensingService != null) {
            result = mEnvironmentalSensingService.hasParticulateMatterPm10ConcentrationCharacteristicCharacteristicUserDescription(index);
        }
        return result;
    }

    /**
     * @see #hasParticulateMatterPm10ConcentrationCharacteristicValidRange(int)
     */
    public synchronized Boolean hasParticulateMatterPm10ConcentrationCharacteristicValidRange() {
        return hasParticulateMatterPm10ConcentrationCharacteristicValidRange(0);
    }

    /**
     * @see EnvironmentalSensingService#hasParticulateMatterPm10ConcentrationCharacteristicValidRange(int)
     */
    public synchronized Boolean hasParticulateMatterPm10ConcentrationCharacteristicValidRange(int index) {
        Boolean result = null;
        if (mEnvironmentalSensingService != null) {
            result = mEnvironmentalSensingService.hasParticulateMatterPm10ConcentrationCharacteristicValidRange(index);
        }
        return result;
    }

    /**
     * @see #getParticulateMatterPm10Concentration(int)
     */
    @Nullable
    public synchronized Integer getParticulateMatterPm10Concentration() {
        return getParticulateMatterPm10Concentration(0);
    }

    /**
     * @see EnvironmentalSensingService#getParticulateMatterPm10Concentration(int)
     */
    @Nullable
    public synchronized Integer getParticulateMatterPm10Concentration(int index) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.getParticulateMatterPm10Concentration(index);
        }
        return taskId;
    }

    /**
     * @see #startParticulateMatterPm10ConcentrationNotification(int)
     */
    @Nullable
    public synchronized Integer startParticulateMatterPm10ConcentrationNotification() {
        return startParticulateMatterPm10ConcentrationNotification(0);
    }

    /**
     * @see EnvironmentalSensingService#startParticulateMatterPm10ConcentrationNotification(int)
     */
    @Nullable
    public synchronized Integer startParticulateMatterPm10ConcentrationNotification(int index) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.startParticulateMatterPm10ConcentrationNotification(index);
        }
        return taskId;
    }

    /**
     * @see #startParticulateMatterPm10ConcentrationNotification(int)
     */
    @Nullable
    public synchronized Integer stopParticulateMatterPm10ConcentrationNotification() {
        return stopParticulateMatterPm10ConcentrationNotification(0);
    }

    /**
     * @see EnvironmentalSensingService#stopParticulateMatterPm10ConcentrationNotification(int)
     */
    @Nullable
    public synchronized Integer stopParticulateMatterPm10ConcentrationNotification(int index) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.stopParticulateMatterPm10ConcentrationNotification(index);
        }
        return taskId;
    }

    /**
     * @see #getParticulateMatterPm10ConcentrationEnvironmentalSensingMeasurement(int)
     */
    @Nullable
    public synchronized Integer getParticulateMatterPm10ConcentrationEnvironmentalSensingMeasurement() {
        return getParticulateMatterPm10ConcentrationEnvironmentalSensingMeasurement(0);
    }

    /**
     * @see EnvironmentalSensingService#getParticulateMatterPm10ConcentrationEnvironmentalSensingMeasurement(int)
     */
    @Nullable
    public synchronized Integer getParticulateMatterPm10ConcentrationEnvironmentalSensingMeasurement(int index) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.getParticulateMatterPm10ConcentrationEnvironmentalSensingMeasurement(index);
        }
        return taskId;
    }

    /**
     * @see #getParticulateMatterPm10ConcentrationEnvironmentalSensingTriggerSetting(int, int)
     */
    @Nullable
    public synchronized Integer getParticulateMatterPm10ConcentrationEnvironmentalSensingTriggerSetting() {
        return getParticulateMatterPm10ConcentrationEnvironmentalSensingTriggerSetting(0, 0);
    }

    /**
     * @see EnvironmentalSensingService#getParticulateMatterPm10ConcentrationEnvironmentalSensingTriggerSetting(int, int)
     */
    @Nullable
    public synchronized Integer getParticulateMatterPm10ConcentrationEnvironmentalSensingTriggerSetting(int characteristicIndex, int descriptorIndex) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.getParticulateMatterPm10ConcentrationEnvironmentalSensingTriggerSetting(characteristicIndex, descriptorIndex);
        }
        return taskId;
    }

    /**
     * @see #setParticulateMatterPm10ConcentrationEnvironmentalSensingTriggerSetting(int, int, EnvironmentalSensingTriggerSetting)
     */
    @Nullable
    public synchronized Integer setParticulateMatterPm10ConcentrationEnvironmentalSensingTriggerSetting(@NonNull EnvironmentalSensingTriggerSetting environmentalSensingTriggerSetting) {
        return setParticulateMatterPm10ConcentrationEnvironmentalSensingTriggerSetting(0, 0, environmentalSensingTriggerSetting);
    }

    /**
     * @see EnvironmentalSensingService#setParticulateMatterPm10ConcentrationEnvironmentalSensingTriggerSetting(int, int, EnvironmentalSensingTriggerSetting)
     */
    @Nullable
    public synchronized Integer setParticulateMatterPm10ConcentrationEnvironmentalSensingTriggerSetting(int characteristicIndex, int descriptorIndex, @NonNull EnvironmentalSensingTriggerSetting environmentalSensingTriggerSetting) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.setParticulateMatterPm10ConcentrationEnvironmentalSensingTriggerSetting(characteristicIndex, descriptorIndex, environmentalSensingTriggerSetting);
        }
        return taskId;
    }

    /**
     * @see #getParticulateMatterPm10ConcentrationEnvironmentalSensingConfiguration(int)
     */
    @Nullable
    public synchronized Integer getParticulateMatterPm10ConcentrationEnvironmentalSensingConfiguration() {
        return getParticulateMatterPm10ConcentrationEnvironmentalSensingConfiguration(0);
    }

    /**
     * @see EnvironmentalSensingService#getParticulateMatterPm10ConcentrationEnvironmentalSensingConfiguration(int)
     */
    @Nullable
    public synchronized Integer getParticulateMatterPm10ConcentrationEnvironmentalSensingConfiguration(int index) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.getParticulateMatterPm10ConcentrationEnvironmentalSensingConfiguration(index);
        }
        return taskId;
    }

    /**
     * @see #setParticulateMatterPm10ConcentrationEnvironmentalSensingConfiguration(int, EnvironmentalSensingConfiguration)
     */
    @Nullable
    public synchronized Integer setParticulateMatterPm10ConcentrationEnvironmentalSensingConfiguration(@NonNull EnvironmentalSensingConfiguration environmentalSensingConfiguration) {
        return setParticulateMatterPm10ConcentrationEnvironmentalSensingConfiguration(0, environmentalSensingConfiguration);
    }

    /**
     * @see EnvironmentalSensingService#setParticulateMatterPm10ConcentrationEnvironmentalSensingConfiguration(int, EnvironmentalSensingConfiguration)
     */
    @Nullable
    public synchronized Integer setParticulateMatterPm10ConcentrationEnvironmentalSensingConfiguration(int index, @NonNull EnvironmentalSensingConfiguration environmentalSensingConfiguration) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.setParticulateMatterPm10ConcentrationEnvironmentalSensingConfiguration(index, environmentalSensingConfiguration);
        }
        return taskId;
    }

    /**
     * @see #getParticulateMatterPm10ConcentrationCharacteristicUserDescription(int)
     */
    @Nullable
    public synchronized Integer getParticulateMatterPm10ConcentrationCharacteristicUserDescription() {
        return getParticulateMatterPm10ConcentrationCharacteristicUserDescription(0);
    }

    /**
     * @see EnvironmentalSensingService#getParticulateMatterPm10ConcentrationCharacteristicUserDescription(int)
     */
    @Nullable
    public synchronized Integer getParticulateMatterPm10ConcentrationCharacteristicUserDescription(int index) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.getParticulateMatterPm10ConcentrationCharacteristicUserDescription(index);
        }
        return taskId;
    }

    /**
     * @see #setParticulateMatterPm10ConcentrationCharacteristicUserDescription(int, CharacteristicUserDescription)
     */
    @Nullable
    public synchronized Integer setParticulateMatterPm10ConcentrationCharacteristicUserDescription(@NonNull CharacteristicUserDescription characteristicUserDescription) {
        return setParticulateMatterPm10ConcentrationCharacteristicUserDescription(0, characteristicUserDescription);
    }

    /**
     * @see EnvironmentalSensingService#setParticulateMatterPm10ConcentrationCharacteristicUserDescription(int, CharacteristicUserDescription)
     */
    @Nullable
    public synchronized Integer setParticulateMatterPm10ConcentrationCharacteristicUserDescription(int index, @NonNull CharacteristicUserDescription characteristicUserDescription) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.setParticulateMatterPm10ConcentrationCharacteristicUserDescription(index, characteristicUserDescription);
        }
        return taskId;
    }

    /**
     * @see #getParticulateMatterPm10ConcentrationValidRange(int)
     */
    @Nullable
    public synchronized Integer getParticulateMatterPm10ConcentrationValidRange() {
        return getParticulateMatterPm10ConcentrationValidRange(0);
    }

    /**
     * @see EnvironmentalSensingService#getParticulateMatterPm10ConcentrationValidRange(int)
     */
    @Nullable
    public synchronized Integer getParticulateMatterPm10ConcentrationValidRange(int index) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.getParticulateMatterPm10ConcentrationValidRange(index);
        }
        return taskId;
    }

    /**
     * @see EnvironmentalSensingService#getParticulateMatterPm1ConcentrationCount()
     */
    @Nullable
    public synchronized Integer getParticulateMatterPm1ConcentrationCount() {
        Integer count = null;
        if (mEnvironmentalSensingService != null) {
            count = mEnvironmentalSensingService.getParticulateMatterPm1ConcentrationCount();
        }
        return count;
    }

    /**
     * @see #canParticulateMatterPm1ConcentrationNotify(int)
     */
    public synchronized Boolean canParticulateMatterPm1ConcentrationNotify() {
        return canParticulateMatterPm1ConcentrationNotify(0);
    }

    /**
     * @see EnvironmentalSensingService#canParticulateMatterPm1ConcentrationNotify(int)
     */
    public synchronized Boolean canParticulateMatterPm1ConcentrationNotify(int index) {
        Boolean result = null;
        if (mEnvironmentalSensingService != null) {
            result = mEnvironmentalSensingService.canParticulateMatterPm1ConcentrationNotify(index);
        }
        return result;
    }

    /**
     * @see #hasParticulateMatterPm1ConcentrationCharacteristicEnvironmentalSensingMeasurement(int)
     */
    public synchronized Boolean hasParticulateMatterPm1ConcentrationCharacteristicEnvironmentalSensingMeasurement() {
        return hasParticulateMatterPm1ConcentrationCharacteristicEnvironmentalSensingMeasurement(0);
    }

    /**
     * @see EnvironmentalSensingService#hasParticulateMatterPm1ConcentrationCharacteristicEnvironmentalSensingMeasurement(int)
     */
    public synchronized Boolean hasParticulateMatterPm1ConcentrationCharacteristicEnvironmentalSensingMeasurement(int index) {
        Boolean result = null;
        if (mEnvironmentalSensingService != null) {
            result = mEnvironmentalSensingService.hasParticulateMatterPm1ConcentrationCharacteristicEnvironmentalSensingMeasurement(index);
        }
        return result;
    }

    /**
     * @see #getParticulateMatterPm1ConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount(int)
     */
    public synchronized Integer getParticulateMatterPm1ConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount() {
        return getParticulateMatterPm1ConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount(0);
    }

    /**
     * @see EnvironmentalSensingService#getParticulateMatterPm1ConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount(int)
     */
    @Nullable
    public synchronized Integer getParticulateMatterPm1ConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount(int index) {
        Integer count = null;
        if (mEnvironmentalSensingService != null) {
            count = mEnvironmentalSensingService.getParticulateMatterPm1ConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount(index);
        }
        return count;
    }

    /**
     * @see #hasParticulateMatterPm1ConcentrationCharacteristicEnvironmentalSensingConfiguration(int)
     */
    public synchronized Boolean hasParticulateMatterPm1ConcentrationCharacteristicEnvironmentalSensingConfiguration() {
        return hasParticulateMatterPm1ConcentrationCharacteristicEnvironmentalSensingConfiguration(0);
    }

    /**
     * @see EnvironmentalSensingService#hasParticulateMatterPm1ConcentrationCharacteristicEnvironmentalSensingConfiguration(int)
     */
    public synchronized Boolean hasParticulateMatterPm1ConcentrationCharacteristicEnvironmentalSensingConfiguration(int index) {
        Boolean result = null;
        if (mEnvironmentalSensingService != null) {
            result = mEnvironmentalSensingService.hasParticulateMatterPm1ConcentrationCharacteristicEnvironmentalSensingConfiguration(index);
        }
        return result;
    }

    /**
     * @see #hasParticulateMatterPm1ConcentrationCharacteristicCharacteristicUserDescription(int)
     */
    public synchronized Boolean hasParticulateMatterPm1ConcentrationCharacteristicCharacteristicUserDescription() {
        return hasParticulateMatterPm1ConcentrationCharacteristicCharacteristicUserDescription(0);
    }

    /**
     * @see EnvironmentalSensingService#hasParticulateMatterPm1ConcentrationCharacteristicCharacteristicUserDescription(int)
     */
    public synchronized Boolean hasParticulateMatterPm1ConcentrationCharacteristicCharacteristicUserDescription(int index) {
        Boolean result = null;
        if (mEnvironmentalSensingService != null) {
            result = mEnvironmentalSensingService.hasParticulateMatterPm1ConcentrationCharacteristicCharacteristicUserDescription(index);
        }
        return result;
    }

    /**
     * @see #hasParticulateMatterPm1ConcentrationCharacteristicValidRange(int)
     */
    public synchronized Boolean hasParticulateMatterPm1ConcentrationCharacteristicValidRange() {
        return hasParticulateMatterPm1ConcentrationCharacteristicValidRange(0);
    }

    /**
     * @see EnvironmentalSensingService#hasParticulateMatterPm1ConcentrationCharacteristicValidRange(int)
     */
    public synchronized Boolean hasParticulateMatterPm1ConcentrationCharacteristicValidRange(int index) {
        Boolean result = null;
        if (mEnvironmentalSensingService != null) {
            result = mEnvironmentalSensingService.hasParticulateMatterPm1ConcentrationCharacteristicValidRange(index);
        }
        return result;
    }

    /**
     * @see #getParticulateMatterPm1Concentration(int)
     */
    @Nullable
    public synchronized Integer getParticulateMatterPm1Concentration() {
        return getParticulateMatterPm1Concentration(0);
    }

    /**
     * @see EnvironmentalSensingService#getParticulateMatterPm1Concentration(int)
     */
    @Nullable
    public synchronized Integer getParticulateMatterPm1Concentration(int index) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.getParticulateMatterPm1Concentration(index);
        }
        return taskId;
    }

    /**
     * @see #startParticulateMatterPm1ConcentrationNotification(int)
     */
    @Nullable
    public synchronized Integer startParticulateMatterPm1ConcentrationNotification() {
        return startParticulateMatterPm1ConcentrationNotification(0);
    }

    /**
     * @see EnvironmentalSensingService#startParticulateMatterPm1ConcentrationNotification(int)
     */
    @Nullable
    public synchronized Integer startParticulateMatterPm1ConcentrationNotification(int index) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.startParticulateMatterPm1ConcentrationNotification(index);
        }
        return taskId;
    }

    /**
     * @see #startParticulateMatterPm1ConcentrationNotification(int)
     */
    @Nullable
    public synchronized Integer stopParticulateMatterPm1ConcentrationNotification() {
        return stopParticulateMatterPm1ConcentrationNotification(0);
    }

    /**
     * @see EnvironmentalSensingService#stopParticulateMatterPm1ConcentrationNotification(int)
     */
    @Nullable
    public synchronized Integer stopParticulateMatterPm1ConcentrationNotification(int index) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.stopParticulateMatterPm1ConcentrationNotification(index);
        }
        return taskId;
    }

    /**
     * @see #getParticulateMatterPm1ConcentrationEnvironmentalSensingMeasurement(int)
     */
    @Nullable
    public synchronized Integer getParticulateMatterPm1ConcentrationEnvironmentalSensingMeasurement() {
        return getParticulateMatterPm1ConcentrationEnvironmentalSensingMeasurement(0);
    }

    /**
     * @see EnvironmentalSensingService#getParticulateMatterPm1ConcentrationEnvironmentalSensingMeasurement(int)
     */
    @Nullable
    public synchronized Integer getParticulateMatterPm1ConcentrationEnvironmentalSensingMeasurement(int index) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.getParticulateMatterPm1ConcentrationEnvironmentalSensingMeasurement(index);
        }
        return taskId;
    }

    /**
     * @see #getParticulateMatterPm1ConcentrationEnvironmentalSensingTriggerSetting(int, int)
     */
    @Nullable
    public synchronized Integer getParticulateMatterPm1ConcentrationEnvironmentalSensingTriggerSetting() {
        return getParticulateMatterPm1ConcentrationEnvironmentalSensingTriggerSetting(0, 0);
    }

    /**
     * @see EnvironmentalSensingService#getParticulateMatterPm1ConcentrationEnvironmentalSensingTriggerSetting(int, int)
     */
    @Nullable
    public synchronized Integer getParticulateMatterPm1ConcentrationEnvironmentalSensingTriggerSetting(int characteristicIndex, int descriptorIndex) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.getParticulateMatterPm1ConcentrationEnvironmentalSensingTriggerSetting(characteristicIndex, descriptorIndex);
        }
        return taskId;
    }

    /**
     * @see #setParticulateMatterPm1ConcentrationEnvironmentalSensingTriggerSetting(int, int, EnvironmentalSensingTriggerSetting)
     */
    @Nullable
    public synchronized Integer setParticulateMatterPm1ConcentrationEnvironmentalSensingTriggerSetting(@NonNull EnvironmentalSensingTriggerSetting environmentalSensingTriggerSetting) {
        return setParticulateMatterPm1ConcentrationEnvironmentalSensingTriggerSetting(0, 0, environmentalSensingTriggerSetting);
    }

    /**
     * @see EnvironmentalSensingService#setParticulateMatterPm1ConcentrationEnvironmentalSensingTriggerSetting(int, int, EnvironmentalSensingTriggerSetting)
     */
    @Nullable
    public synchronized Integer setParticulateMatterPm1ConcentrationEnvironmentalSensingTriggerSetting(int characteristicIndex, int descriptorIndex, @NonNull EnvironmentalSensingTriggerSetting environmentalSensingTriggerSetting) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.setParticulateMatterPm1ConcentrationEnvironmentalSensingTriggerSetting(characteristicIndex, descriptorIndex, environmentalSensingTriggerSetting);
        }
        return taskId;
    }

    /**
     * @see #getParticulateMatterPm1ConcentrationEnvironmentalSensingConfiguration(int)
     */
    @Nullable
    public synchronized Integer getParticulateMatterPm1ConcentrationEnvironmentalSensingConfiguration() {
        return getParticulateMatterPm1ConcentrationEnvironmentalSensingConfiguration(0);
    }

    /**
     * @see EnvironmentalSensingService#getParticulateMatterPm1ConcentrationEnvironmentalSensingConfiguration(int)
     */
    @Nullable
    public synchronized Integer getParticulateMatterPm1ConcentrationEnvironmentalSensingConfiguration(int index) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.getParticulateMatterPm1ConcentrationEnvironmentalSensingConfiguration(index);
        }
        return taskId;
    }

    /**
     * @see #setParticulateMatterPm1ConcentrationEnvironmentalSensingConfiguration(int, EnvironmentalSensingConfiguration)
     */
    @Nullable
    public synchronized Integer setParticulateMatterPm1ConcentrationEnvironmentalSensingConfiguration(@NonNull EnvironmentalSensingConfiguration environmentalSensingConfiguration) {
        return setParticulateMatterPm1ConcentrationEnvironmentalSensingConfiguration(0, environmentalSensingConfiguration);
    }

    /**
     * @see EnvironmentalSensingService#setParticulateMatterPm1ConcentrationEnvironmentalSensingConfiguration(int, EnvironmentalSensingConfiguration)
     */
    @Nullable
    public synchronized Integer setParticulateMatterPm1ConcentrationEnvironmentalSensingConfiguration(int index, @NonNull EnvironmentalSensingConfiguration environmentalSensingConfiguration) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.setParticulateMatterPm1ConcentrationEnvironmentalSensingConfiguration(index, environmentalSensingConfiguration);
        }
        return taskId;
    }

    /**
     * @see #getParticulateMatterPm1ConcentrationCharacteristicUserDescription(int)
     */
    @Nullable
    public synchronized Integer getParticulateMatterPm1ConcentrationCharacteristicUserDescription() {
        return getParticulateMatterPm1ConcentrationCharacteristicUserDescription(0);
    }

    /**
     * @see EnvironmentalSensingService#getParticulateMatterPm1ConcentrationCharacteristicUserDescription(int)
     */
    @Nullable
    public synchronized Integer getParticulateMatterPm1ConcentrationCharacteristicUserDescription(int index) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.getParticulateMatterPm1ConcentrationCharacteristicUserDescription(index);
        }
        return taskId;
    }

    /**
     * @see #setParticulateMatterPm1ConcentrationCharacteristicUserDescription(int, CharacteristicUserDescription)
     */
    @Nullable
    public synchronized Integer setParticulateMatterPm1ConcentrationCharacteristicUserDescription(@NonNull CharacteristicUserDescription characteristicUserDescription) {
        return setParticulateMatterPm1ConcentrationCharacteristicUserDescription(0, characteristicUserDescription);
    }

    /**
     * @see EnvironmentalSensingService#setParticulateMatterPm1ConcentrationCharacteristicUserDescription(int, CharacteristicUserDescription)
     */
    @Nullable
    public synchronized Integer setParticulateMatterPm1ConcentrationCharacteristicUserDescription(int index, @NonNull CharacteristicUserDescription characteristicUserDescription) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.setParticulateMatterPm1ConcentrationCharacteristicUserDescription(index, characteristicUserDescription);
        }
        return taskId;
    }

    /**
     * @see #getParticulateMatterPm1ConcentrationValidRange(int)
     */
    @Nullable
    public synchronized Integer getParticulateMatterPm1ConcentrationValidRange() {
        return getParticulateMatterPm1ConcentrationValidRange(0);
    }

    /**
     * @see EnvironmentalSensingService#getParticulateMatterPm1ConcentrationValidRange(int)
     */
    @Nullable
    public synchronized Integer getParticulateMatterPm1ConcentrationValidRange(int index) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.getParticulateMatterPm1ConcentrationValidRange(index);
        }
        return taskId;
    }

    /**
     * @see EnvironmentalSensingService#getParticulateMatterPm25ConcentrationCount()
     */
    @Nullable
    public synchronized Integer getParticulateMatterPm25ConcentrationCount() {
        Integer count = null;
        if (mEnvironmentalSensingService != null) {
            count = mEnvironmentalSensingService.getParticulateMatterPm25ConcentrationCount();
        }
        return count;
    }

    /**
     * @see #canParticulateMatterPm25ConcentrationNotify(int)
     */
    public synchronized Boolean canParticulateMatterPm25ConcentrationNotify() {
        return canParticulateMatterPm25ConcentrationNotify(0);
    }

    /**
     * @see EnvironmentalSensingService#canParticulateMatterPm25ConcentrationNotify(int)
     */
    public synchronized Boolean canParticulateMatterPm25ConcentrationNotify(int index) {
        Boolean result = null;
        if (mEnvironmentalSensingService != null) {
            result = mEnvironmentalSensingService.canParticulateMatterPm25ConcentrationNotify(index);
        }
        return result;
    }

    /**
     * @see #hasParticulateMatterPm25ConcentrationCharacteristicEnvironmentalSensingMeasurement(int)
     */
    public synchronized Boolean hasParticulateMatterPm25ConcentrationCharacteristicEnvironmentalSensingMeasurement() {
        return hasParticulateMatterPm25ConcentrationCharacteristicEnvironmentalSensingMeasurement(0);
    }

    /**
     * @see EnvironmentalSensingService#hasParticulateMatterPm25ConcentrationCharacteristicEnvironmentalSensingMeasurement(int)
     */
    public synchronized Boolean hasParticulateMatterPm25ConcentrationCharacteristicEnvironmentalSensingMeasurement(int index) {
        Boolean result = null;
        if (mEnvironmentalSensingService != null) {
            result = mEnvironmentalSensingService.hasParticulateMatterPm25ConcentrationCharacteristicEnvironmentalSensingMeasurement(index);
        }
        return result;
    }

    /**
     * @see #getParticulateMatterPm25ConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount(int)
     */
    public synchronized Integer getParticulateMatterPm25ConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount() {
        return getParticulateMatterPm25ConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount(0);
    }

    /**
     * @see EnvironmentalSensingService#getParticulateMatterPm25ConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount(int)
     */
    @Nullable
    public synchronized Integer getParticulateMatterPm25ConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount(int index) {
        Integer count = null;
        if (mEnvironmentalSensingService != null) {
            count = mEnvironmentalSensingService.getParticulateMatterPm25ConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount(index);
        }
        return count;
    }

    /**
     * @see #hasParticulateMatterPm25ConcentrationCharacteristicEnvironmentalSensingConfiguration(int)
     */
    public synchronized Boolean hasParticulateMatterPm25ConcentrationCharacteristicEnvironmentalSensingConfiguration() {
        return hasParticulateMatterPm25ConcentrationCharacteristicEnvironmentalSensingConfiguration(0);
    }

    /**
     * @see EnvironmentalSensingService#hasParticulateMatterPm25ConcentrationCharacteristicEnvironmentalSensingConfiguration(int)
     */
    public synchronized Boolean hasParticulateMatterPm25ConcentrationCharacteristicEnvironmentalSensingConfiguration(int index) {
        Boolean result = null;
        if (mEnvironmentalSensingService != null) {
            result = mEnvironmentalSensingService.hasParticulateMatterPm25ConcentrationCharacteristicEnvironmentalSensingConfiguration(index);
        }
        return result;
    }

    /**
     * @see #hasParticulateMatterPm25ConcentrationCharacteristicCharacteristicUserDescription(int)
     */
    public synchronized Boolean hasParticulateMatterPm25ConcentrationCharacteristicCharacteristicUserDescription() {
        return hasParticulateMatterPm25ConcentrationCharacteristicCharacteristicUserDescription(0);
    }

    /**
     * @see EnvironmentalSensingService#hasParticulateMatterPm25ConcentrationCharacteristicCharacteristicUserDescription(int)
     */
    public synchronized Boolean hasParticulateMatterPm25ConcentrationCharacteristicCharacteristicUserDescription(int index) {
        Boolean result = null;
        if (mEnvironmentalSensingService != null) {
            result = mEnvironmentalSensingService.hasParticulateMatterPm25ConcentrationCharacteristicCharacteristicUserDescription(index);
        }
        return result;
    }

    /**
     * @see #hasParticulateMatterPm25ConcentrationCharacteristicValidRange(int)
     */
    public synchronized Boolean hasParticulateMatterPm25ConcentrationCharacteristicValidRange() {
        return hasParticulateMatterPm25ConcentrationCharacteristicValidRange(0);
    }

    /**
     * @see EnvironmentalSensingService#hasParticulateMatterPm25ConcentrationCharacteristicValidRange(int)
     */
    public synchronized Boolean hasParticulateMatterPm25ConcentrationCharacteristicValidRange(int index) {
        Boolean result = null;
        if (mEnvironmentalSensingService != null) {
            result = mEnvironmentalSensingService.hasParticulateMatterPm25ConcentrationCharacteristicValidRange(index);
        }
        return result;
    }

    /**
     * @see #getParticulateMatterPm25Concentration(int)
     */
    @Nullable
    public synchronized Integer getParticulateMatterPm25Concentration() {
        return getParticulateMatterPm25Concentration(0);
    }

    /**
     * @see EnvironmentalSensingService#getParticulateMatterPm25Concentration(int)
     */
    @Nullable
    public synchronized Integer getParticulateMatterPm25Concentration(int index) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.getParticulateMatterPm25Concentration(index);
        }
        return taskId;
    }

    /**
     * @see #startParticulateMatterPm25ConcentrationNotification(int)
     */
    @Nullable
    public synchronized Integer startParticulateMatterPm25ConcentrationNotification() {
        return startParticulateMatterPm25ConcentrationNotification(0);
    }

    /**
     * @see EnvironmentalSensingService#startParticulateMatterPm25ConcentrationNotification(int)
     */
    @Nullable
    public synchronized Integer startParticulateMatterPm25ConcentrationNotification(int index) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.startParticulateMatterPm25ConcentrationNotification(index);
        }
        return taskId;
    }

    /**
     * @see #startParticulateMatterPm25ConcentrationNotification(int)
     */
    @Nullable
    public synchronized Integer stopParticulateMatterPm25ConcentrationNotification() {
        return stopParticulateMatterPm25ConcentrationNotification(0);
    }

    /**
     * @see EnvironmentalSensingService#stopParticulateMatterPm25ConcentrationNotification(int)
     */
    @Nullable
    public synchronized Integer stopParticulateMatterPm25ConcentrationNotification(int index) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.stopParticulateMatterPm25ConcentrationNotification(index);
        }
        return taskId;
    }

    /**
     * @see #getParticulateMatterPm25ConcentrationEnvironmentalSensingMeasurement(int)
     */
    @Nullable
    public synchronized Integer getParticulateMatterPm25ConcentrationEnvironmentalSensingMeasurement() {
        return getParticulateMatterPm25ConcentrationEnvironmentalSensingMeasurement(0);
    }

    /**
     * @see EnvironmentalSensingService#getParticulateMatterPm25ConcentrationEnvironmentalSensingMeasurement(int)
     */
    @Nullable
    public synchronized Integer getParticulateMatterPm25ConcentrationEnvironmentalSensingMeasurement(int index) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.getParticulateMatterPm25ConcentrationEnvironmentalSensingMeasurement(index);
        }
        return taskId;
    }

    /**
     * @see #getParticulateMatterPm25ConcentrationEnvironmentalSensingTriggerSetting(int, int)
     */
    @Nullable
    public synchronized Integer getParticulateMatterPm25ConcentrationEnvironmentalSensingTriggerSetting() {
        return getParticulateMatterPm25ConcentrationEnvironmentalSensingTriggerSetting(0, 0);
    }

    /**
     * @see EnvironmentalSensingService#getParticulateMatterPm25ConcentrationEnvironmentalSensingTriggerSetting(int, int)
     */
    @Nullable
    public synchronized Integer getParticulateMatterPm25ConcentrationEnvironmentalSensingTriggerSetting(int characteristicIndex, int descriptorIndex) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.getParticulateMatterPm25ConcentrationEnvironmentalSensingTriggerSetting(characteristicIndex, descriptorIndex);
        }
        return taskId;
    }

    /**
     * @see #setParticulateMatterPm25ConcentrationEnvironmentalSensingTriggerSetting(int, int, EnvironmentalSensingTriggerSetting)
     */
    @Nullable
    public synchronized Integer setParticulateMatterPm25ConcentrationEnvironmentalSensingTriggerSetting(@NonNull EnvironmentalSensingTriggerSetting environmentalSensingTriggerSetting) {
        return setParticulateMatterPm25ConcentrationEnvironmentalSensingTriggerSetting(0, 0, environmentalSensingTriggerSetting);
    }

    /**
     * @see EnvironmentalSensingService#setParticulateMatterPm25ConcentrationEnvironmentalSensingTriggerSetting(int, int, EnvironmentalSensingTriggerSetting)
     */
    @Nullable
    public synchronized Integer setParticulateMatterPm25ConcentrationEnvironmentalSensingTriggerSetting(int characteristicIndex, int descriptorIndex, @NonNull EnvironmentalSensingTriggerSetting environmentalSensingTriggerSetting) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.setParticulateMatterPm25ConcentrationEnvironmentalSensingTriggerSetting(characteristicIndex, descriptorIndex, environmentalSensingTriggerSetting);
        }
        return taskId;
    }

    /**
     * @see #getParticulateMatterPm25ConcentrationEnvironmentalSensingConfiguration(int)
     */
    @Nullable
    public synchronized Integer getParticulateMatterPm25ConcentrationEnvironmentalSensingConfiguration() {
        return getParticulateMatterPm25ConcentrationEnvironmentalSensingConfiguration(0);
    }

    /**
     * @see EnvironmentalSensingService#getParticulateMatterPm25ConcentrationEnvironmentalSensingConfiguration(int)
     */
    @Nullable
    public synchronized Integer getParticulateMatterPm25ConcentrationEnvironmentalSensingConfiguration(int index) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.getParticulateMatterPm25ConcentrationEnvironmentalSensingConfiguration(index);
        }
        return taskId;
    }

    /**
     * @see #setParticulateMatterPm25ConcentrationEnvironmentalSensingConfiguration(int, EnvironmentalSensingConfiguration)
     */
    @Nullable
    public synchronized Integer setParticulateMatterPm25ConcentrationEnvironmentalSensingConfiguration(@NonNull EnvironmentalSensingConfiguration environmentalSensingConfiguration) {
        return setParticulateMatterPm25ConcentrationEnvironmentalSensingConfiguration(0, environmentalSensingConfiguration);
    }

    /**
     * @see EnvironmentalSensingService#setParticulateMatterPm25ConcentrationEnvironmentalSensingConfiguration(int, EnvironmentalSensingConfiguration)
     */
    @Nullable
    public synchronized Integer setParticulateMatterPm25ConcentrationEnvironmentalSensingConfiguration(int index, @NonNull EnvironmentalSensingConfiguration environmentalSensingConfiguration) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.setParticulateMatterPm25ConcentrationEnvironmentalSensingConfiguration(index, environmentalSensingConfiguration);
        }
        return taskId;
    }

    /**
     * @see #getParticulateMatterPm25ConcentrationCharacteristicUserDescription(int)
     */
    @Nullable
    public synchronized Integer getParticulateMatterPm25ConcentrationCharacteristicUserDescription() {
        return getParticulateMatterPm25ConcentrationCharacteristicUserDescription(0);
    }

    /**
     * @see EnvironmentalSensingService#getParticulateMatterPm25ConcentrationCharacteristicUserDescription(int)
     */
    @Nullable
    public synchronized Integer getParticulateMatterPm25ConcentrationCharacteristicUserDescription(int index) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.getParticulateMatterPm25ConcentrationCharacteristicUserDescription(index);
        }
        return taskId;
    }

    /**
     * @see #setParticulateMatterPm25ConcentrationCharacteristicUserDescription(int, CharacteristicUserDescription)
     */
    @Nullable
    public synchronized Integer setParticulateMatterPm25ConcentrationCharacteristicUserDescription(@NonNull CharacteristicUserDescription characteristicUserDescription) {
        return setParticulateMatterPm25ConcentrationCharacteristicUserDescription(0, characteristicUserDescription);
    }

    /**
     * @see EnvironmentalSensingService#setParticulateMatterPm25ConcentrationCharacteristicUserDescription(int, CharacteristicUserDescription)
     */
    @Nullable
    public synchronized Integer setParticulateMatterPm25ConcentrationCharacteristicUserDescription(int index, @NonNull CharacteristicUserDescription characteristicUserDescription) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.setParticulateMatterPm25ConcentrationCharacteristicUserDescription(index, characteristicUserDescription);
        }
        return taskId;
    }

    /**
     * @see #getParticulateMatterPm25ConcentrationValidRange(int)
     */
    @Nullable
    public synchronized Integer getParticulateMatterPm25ConcentrationValidRange() {
        return getParticulateMatterPm25ConcentrationValidRange(0);
    }

    /**
     * @see EnvironmentalSensingService#getParticulateMatterPm25ConcentrationValidRange(int)
     */
    @Nullable
    public synchronized Integer getParticulateMatterPm25ConcentrationValidRange(int index) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.getParticulateMatterPm25ConcentrationValidRange(index);
        }
        return taskId;
    }

    /**
     * @see EnvironmentalSensingService#getPollenConcentrationCount()
     */
    @Nullable
    public synchronized Integer getPollenConcentrationCount() {
        Integer count = null;
        if (mEnvironmentalSensingService != null) {
            count = mEnvironmentalSensingService.getPollenConcentrationCount();
        }
        return count;
    }

    /**
     * @see #canPollenConcentrationNotify(int)
     */
    public synchronized Boolean canPollenConcentrationNotify() {
        return canPollenConcentrationNotify(0);
    }

    /**
     * @see EnvironmentalSensingService#canPollenConcentrationNotify(int)
     */
    public synchronized Boolean canPollenConcentrationNotify(int index) {
        Boolean result = null;
        if (mEnvironmentalSensingService != null) {
            result = mEnvironmentalSensingService.canPollenConcentrationNotify(index);
        }
        return result;
    }

    /**
     * @see #hasPollenConcentrationCharacteristicEnvironmentalSensingMeasurement(int)
     */
    public synchronized Boolean hasPollenConcentrationCharacteristicEnvironmentalSensingMeasurement() {
        return hasPollenConcentrationCharacteristicEnvironmentalSensingMeasurement(0);
    }

    /**
     * @see EnvironmentalSensingService#hasPollenConcentrationCharacteristicEnvironmentalSensingMeasurement(int)
     */
    public synchronized Boolean hasPollenConcentrationCharacteristicEnvironmentalSensingMeasurement(int index) {
        Boolean result = null;
        if (mEnvironmentalSensingService != null) {
            result = mEnvironmentalSensingService.hasPollenConcentrationCharacteristicEnvironmentalSensingMeasurement(index);
        }
        return result;
    }

    /**
     * @see #getPollenConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount(int)
     */
    public synchronized Integer getPollenConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount() {
        return getPollenConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount(0);
    }

    /**
     * @see EnvironmentalSensingService#getPollenConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount(int)
     */
    @Nullable
    public synchronized Integer getPollenConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount(int index) {
        Integer count = null;
        if (mEnvironmentalSensingService != null) {
            count = mEnvironmentalSensingService.getPollenConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount(index);
        }
        return count;
    }

    /**
     * @see #hasPollenConcentrationCharacteristicEnvironmentalSensingConfiguration(int)
     */
    public synchronized Boolean hasPollenConcentrationCharacteristicEnvironmentalSensingConfiguration() {
        return hasPollenConcentrationCharacteristicEnvironmentalSensingConfiguration(0);
    }

    /**
     * @see EnvironmentalSensingService#hasPollenConcentrationCharacteristicEnvironmentalSensingConfiguration(int)
     */
    public synchronized Boolean hasPollenConcentrationCharacteristicEnvironmentalSensingConfiguration(int index) {
        Boolean result = null;
        if (mEnvironmentalSensingService != null) {
            result = mEnvironmentalSensingService.hasPollenConcentrationCharacteristicEnvironmentalSensingConfiguration(index);
        }
        return result;
    }

    /**
     * @see #hasPollenConcentrationCharacteristicCharacteristicUserDescription(int)
     */
    public synchronized Boolean hasPollenConcentrationCharacteristicCharacteristicUserDescription() {
        return hasPollenConcentrationCharacteristicCharacteristicUserDescription(0);
    }

    /**
     * @see EnvironmentalSensingService#hasPollenConcentrationCharacteristicCharacteristicUserDescription(int)
     */
    public synchronized Boolean hasPollenConcentrationCharacteristicCharacteristicUserDescription(int index) {
        Boolean result = null;
        if (mEnvironmentalSensingService != null) {
            result = mEnvironmentalSensingService.hasPollenConcentrationCharacteristicCharacteristicUserDescription(index);
        }
        return result;
    }

    /**
     * @see #hasPollenConcentrationCharacteristicValidRange(int)
     */
    public synchronized Boolean hasPollenConcentrationCharacteristicValidRange() {
        return hasPollenConcentrationCharacteristicValidRange(0);
    }

    /**
     * @see EnvironmentalSensingService#hasPollenConcentrationCharacteristicValidRange(int)
     */
    public synchronized Boolean hasPollenConcentrationCharacteristicValidRange(int index) {
        Boolean result = null;
        if (mEnvironmentalSensingService != null) {
            result = mEnvironmentalSensingService.hasPollenConcentrationCharacteristicValidRange(index);
        }
        return result;
    }

    /**
     * @see #getPollenConcentration(int)
     */
    @Nullable
    public synchronized Integer getPollenConcentration() {
        return getPollenConcentration(0);
    }

    /**
     * @see EnvironmentalSensingService#getPollenConcentration(int)
     */
    @Nullable
    public synchronized Integer getPollenConcentration(int index) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.getPollenConcentration(index);
        }
        return taskId;
    }

    /**
     * @see #startPollenConcentrationNotification(int)
     */
    @Nullable
    public synchronized Integer startPollenConcentrationNotification() {
        return startPollenConcentrationNotification(0);
    }

    /**
     * @see EnvironmentalSensingService#startPollenConcentrationNotification(int)
     */
    @Nullable
    public synchronized Integer startPollenConcentrationNotification(int index) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.startPollenConcentrationNotification(index);
        }
        return taskId;
    }

    /**
     * @see #startPollenConcentrationNotification(int)
     */
    @Nullable
    public synchronized Integer stopPollenConcentrationNotification() {
        return stopPollenConcentrationNotification(0);
    }

    /**
     * @see EnvironmentalSensingService#stopPollenConcentrationNotification(int)
     */
    @Nullable
    public synchronized Integer stopPollenConcentrationNotification(int index) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.stopPollenConcentrationNotification(index);
        }
        return taskId;
    }

    /**
     * @see #getPollenConcentrationEnvironmentalSensingMeasurement(int)
     */
    @Nullable
    public synchronized Integer getPollenConcentrationEnvironmentalSensingMeasurement() {
        return getPollenConcentrationEnvironmentalSensingMeasurement(0);
    }

    /**
     * @see EnvironmentalSensingService#getPollenConcentrationEnvironmentalSensingMeasurement(int)
     */
    @Nullable
    public synchronized Integer getPollenConcentrationEnvironmentalSensingMeasurement(int index) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.getPollenConcentrationEnvironmentalSensingMeasurement(index);
        }
        return taskId;
    }

    /**
     * @see #getPollenConcentrationEnvironmentalSensingTriggerSetting(int, int)
     */
    @Nullable
    public synchronized Integer getPollenConcentrationEnvironmentalSensingTriggerSetting() {
        return getPollenConcentrationEnvironmentalSensingTriggerSetting(0, 0);
    }

    /**
     * @see EnvironmentalSensingService#getPollenConcentrationEnvironmentalSensingTriggerSetting(int, int)
     */
    @Nullable
    public synchronized Integer getPollenConcentrationEnvironmentalSensingTriggerSetting(int characteristicIndex, int descriptorIndex) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.getPollenConcentrationEnvironmentalSensingTriggerSetting(characteristicIndex, descriptorIndex);
        }
        return taskId;
    }

    /**
     * @see #setPollenConcentrationEnvironmentalSensingTriggerSetting(int, int, EnvironmentalSensingTriggerSetting)
     */
    @Nullable
    public synchronized Integer setPollenConcentrationEnvironmentalSensingTriggerSetting(@NonNull EnvironmentalSensingTriggerSetting environmentalSensingTriggerSetting) {
        return setPollenConcentrationEnvironmentalSensingTriggerSetting(0, 0, environmentalSensingTriggerSetting);
    }

    /**
     * @see EnvironmentalSensingService#setPollenConcentrationEnvironmentalSensingTriggerSetting(int, int, EnvironmentalSensingTriggerSetting)
     */
    @Nullable
    public synchronized Integer setPollenConcentrationEnvironmentalSensingTriggerSetting(int characteristicIndex, int descriptorIndex, @NonNull EnvironmentalSensingTriggerSetting environmentalSensingTriggerSetting) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.setPollenConcentrationEnvironmentalSensingTriggerSetting(characteristicIndex, descriptorIndex, environmentalSensingTriggerSetting);
        }
        return taskId;
    }

    /**
     * @see #getPollenConcentrationEnvironmentalSensingConfiguration(int)
     */
    @Nullable
    public synchronized Integer getPollenConcentrationEnvironmentalSensingConfiguration() {
        return getPollenConcentrationEnvironmentalSensingConfiguration(0);
    }

    /**
     * @see EnvironmentalSensingService#getPollenConcentrationEnvironmentalSensingConfiguration(int)
     */
    @Nullable
    public synchronized Integer getPollenConcentrationEnvironmentalSensingConfiguration(int index) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.getPollenConcentrationEnvironmentalSensingConfiguration(index);
        }
        return taskId;
    }

    /**
     * @see #setPollenConcentrationEnvironmentalSensingConfiguration(int, EnvironmentalSensingConfiguration)
     */
    @Nullable
    public synchronized Integer setPollenConcentrationEnvironmentalSensingConfiguration(@NonNull EnvironmentalSensingConfiguration environmentalSensingConfiguration) {
        return setPollenConcentrationEnvironmentalSensingConfiguration(0, environmentalSensingConfiguration);
    }

    /**
     * @see EnvironmentalSensingService#setPollenConcentrationEnvironmentalSensingConfiguration(int, EnvironmentalSensingConfiguration)
     */
    @Nullable
    public synchronized Integer setPollenConcentrationEnvironmentalSensingConfiguration(int index, @NonNull EnvironmentalSensingConfiguration environmentalSensingConfiguration) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.setPollenConcentrationEnvironmentalSensingConfiguration(index, environmentalSensingConfiguration);
        }
        return taskId;
    }

    /**
     * @see #getPollenConcentrationCharacteristicUserDescription(int)
     */
    @Nullable
    public synchronized Integer getPollenConcentrationCharacteristicUserDescription() {
        return getPollenConcentrationCharacteristicUserDescription(0);
    }

    /**
     * @see EnvironmentalSensingService#getPollenConcentrationCharacteristicUserDescription(int)
     */
    @Nullable
    public synchronized Integer getPollenConcentrationCharacteristicUserDescription(int index) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.getPollenConcentrationCharacteristicUserDescription(index);
        }
        return taskId;
    }

    /**
     * @see #setPollenConcentrationCharacteristicUserDescription(int, CharacteristicUserDescription)
     */
    @Nullable
    public synchronized Integer setPollenConcentrationCharacteristicUserDescription(@NonNull CharacteristicUserDescription characteristicUserDescription) {
        return setPollenConcentrationCharacteristicUserDescription(0, characteristicUserDescription);
    }

    /**
     * @see EnvironmentalSensingService#setPollenConcentrationCharacteristicUserDescription(int, CharacteristicUserDescription)
     */
    @Nullable
    public synchronized Integer setPollenConcentrationCharacteristicUserDescription(int index, @NonNull CharacteristicUserDescription characteristicUserDescription) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.setPollenConcentrationCharacteristicUserDescription(index, characteristicUserDescription);
        }
        return taskId;
    }

    /**
     * @see #getPollenConcentrationValidRange(int)
     */
    @Nullable
    public synchronized Integer getPollenConcentrationValidRange() {
        return getPollenConcentrationValidRange(0);
    }

    /**
     * @see EnvironmentalSensingService#getPollenConcentrationValidRange(int)
     */
    @Nullable
    public synchronized Integer getPollenConcentrationValidRange(int index) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.getPollenConcentrationValidRange(index);
        }
        return taskId;
    }

    /**
     * @see EnvironmentalSensingService#getPressureCount()
     */
    @Nullable
    public synchronized Integer getPressureCount() {
        Integer count = null;
        if (mEnvironmentalSensingService != null) {
            count = mEnvironmentalSensingService.getPressureCount();
        }
        return count;
    }

    /**
     * @see #canPressureNotify(int)
     */
    public synchronized Boolean canPressureNotify() {
        return canPressureNotify(0);
    }

    /**
     * @see EnvironmentalSensingService#canPressureNotify(int)
     */
    public synchronized Boolean canPressureNotify(int index) {
        Boolean result = null;
        if (mEnvironmentalSensingService != null) {
            result = mEnvironmentalSensingService.canPressureNotify(index);
        }
        return result;
    }

    /**
     * @see #hasPressureCharacteristicEnvironmentalSensingMeasurement(int)
     */
    public synchronized Boolean hasPressureCharacteristicEnvironmentalSensingMeasurement() {
        return hasPressureCharacteristicEnvironmentalSensingMeasurement(0);
    }

    /**
     * @see EnvironmentalSensingService#hasPressureCharacteristicEnvironmentalSensingMeasurement(int)
     */
    public synchronized Boolean hasPressureCharacteristicEnvironmentalSensingMeasurement(int index) {
        Boolean result = null;
        if (mEnvironmentalSensingService != null) {
            result = mEnvironmentalSensingService.hasPressureCharacteristicEnvironmentalSensingMeasurement(index);
        }
        return result;
    }

    /**
     * @see #getPressureCharacteristicEnvironmentalSensingTriggerSettingCount(int)
     */
    public synchronized Integer getPressureCharacteristicEnvironmentalSensingTriggerSettingCount() {
        return getPressureCharacteristicEnvironmentalSensingTriggerSettingCount(0);
    }

    /**
     * @see EnvironmentalSensingService#getPressureCharacteristicEnvironmentalSensingTriggerSettingCount(int)
     */
    @Nullable
    public synchronized Integer getPressureCharacteristicEnvironmentalSensingTriggerSettingCount(int index) {
        Integer count = null;
        if (mEnvironmentalSensingService != null) {
            count = mEnvironmentalSensingService.getPressureCharacteristicEnvironmentalSensingTriggerSettingCount(index);
        }
        return count;
    }

    /**
     * @see #hasPressureCharacteristicEnvironmentalSensingConfiguration(int)
     */
    public synchronized Boolean hasPressureCharacteristicEnvironmentalSensingConfiguration() {
        return hasPressureCharacteristicEnvironmentalSensingConfiguration(0);
    }

    /**
     * @see EnvironmentalSensingService#hasPressureCharacteristicEnvironmentalSensingConfiguration(int)
     */
    public synchronized Boolean hasPressureCharacteristicEnvironmentalSensingConfiguration(int index) {
        Boolean result = null;
        if (mEnvironmentalSensingService != null) {
            result = mEnvironmentalSensingService.hasPressureCharacteristicEnvironmentalSensingConfiguration(index);
        }
        return result;
    }

    /**
     * @see #hasPressureCharacteristicCharacteristicUserDescription(int)
     */
    public synchronized Boolean hasPressureCharacteristicCharacteristicUserDescription() {
        return hasPressureCharacteristicCharacteristicUserDescription(0);
    }

    /**
     * @see EnvironmentalSensingService#hasPressureCharacteristicCharacteristicUserDescription(int)
     */
    public synchronized Boolean hasPressureCharacteristicCharacteristicUserDescription(int index) {
        Boolean result = null;
        if (mEnvironmentalSensingService != null) {
            result = mEnvironmentalSensingService.hasPressureCharacteristicCharacteristicUserDescription(index);
        }
        return result;
    }

    /**
     * @see #hasPressureCharacteristicValidRange(int)
     */
    public synchronized Boolean hasPressureCharacteristicValidRange() {
        return hasPressureCharacteristicValidRange(0);
    }

    /**
     * @see EnvironmentalSensingService#hasPressureCharacteristicValidRange(int)
     */
    public synchronized Boolean hasPressureCharacteristicValidRange(int index) {
        Boolean result = null;
        if (mEnvironmentalSensingService != null) {
            result = mEnvironmentalSensingService.hasPressureCharacteristicValidRange(index);
        }
        return result;
    }

    /**
     * @see #getPressure(int)
     */
    @Nullable
    public synchronized Integer getPressure() {
        return getPressure(0);
    }

    /**
     * @see EnvironmentalSensingService#getPressure(int)
     */
    @Nullable
    public synchronized Integer getPressure(int index) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.getPressure(index);
        }
        return taskId;
    }

    /**
     * @see #startPressureNotification(int)
     */
    @Nullable
    public synchronized Integer startPressureNotification() {
        return startPressureNotification(0);
    }

    /**
     * @see EnvironmentalSensingService#startPressureNotification(int)
     */
    @Nullable
    public synchronized Integer startPressureNotification(int index) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.startPressureNotification(index);
        }
        return taskId;
    }

    /**
     * @see #startPressureNotification(int)
     */
    @Nullable
    public synchronized Integer stopPressureNotification() {
        return stopPressureNotification(0);
    }

    /**
     * @see EnvironmentalSensingService#stopPressureNotification(int)
     */
    @Nullable
    public synchronized Integer stopPressureNotification(int index) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.stopPressureNotification(index);
        }
        return taskId;
    }

    /**
     * @see #getPressureEnvironmentalSensingMeasurement(int)
     */
    @Nullable
    public synchronized Integer getPressureEnvironmentalSensingMeasurement() {
        return getPressureEnvironmentalSensingMeasurement(0);
    }

    /**
     * @see EnvironmentalSensingService#getPressureEnvironmentalSensingMeasurement(int)
     */
    @Nullable
    public synchronized Integer getPressureEnvironmentalSensingMeasurement(int index) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.getPressureEnvironmentalSensingMeasurement(index);
        }
        return taskId;
    }

    /**
     * @see #getPressureEnvironmentalSensingTriggerSetting(int, int)
     */
    @Nullable
    public synchronized Integer getPressureEnvironmentalSensingTriggerSetting() {
        return getPressureEnvironmentalSensingTriggerSetting(0, 0);
    }

    /**
     * @see EnvironmentalSensingService#getPressureEnvironmentalSensingTriggerSetting(int, int)
     */
    @Nullable
    public synchronized Integer getPressureEnvironmentalSensingTriggerSetting(int characteristicIndex, int descriptorIndex) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.getPressureEnvironmentalSensingTriggerSetting(characteristicIndex, descriptorIndex);
        }
        return taskId;
    }

    /**
     * @see #setPressureEnvironmentalSensingTriggerSetting(int, int, EnvironmentalSensingTriggerSetting)
     */
    @Nullable
    public synchronized Integer setPressureEnvironmentalSensingTriggerSetting(@NonNull EnvironmentalSensingTriggerSetting environmentalSensingTriggerSetting) {
        return setPressureEnvironmentalSensingTriggerSetting(0, 0, environmentalSensingTriggerSetting);
    }

    /**
     * @see EnvironmentalSensingService#setPressureEnvironmentalSensingTriggerSetting(int, int, EnvironmentalSensingTriggerSetting)
     */
    @Nullable
    public synchronized Integer setPressureEnvironmentalSensingTriggerSetting(int characteristicIndex, int descriptorIndex, @NonNull EnvironmentalSensingTriggerSetting environmentalSensingTriggerSetting) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.setPressureEnvironmentalSensingTriggerSetting(characteristicIndex, descriptorIndex, environmentalSensingTriggerSetting);
        }
        return taskId;
    }

    /**
     * @see #getPressureEnvironmentalSensingConfiguration(int)
     */
    @Nullable
    public synchronized Integer getPressureEnvironmentalSensingConfiguration() {
        return getPressureEnvironmentalSensingConfiguration(0);
    }

    /**
     * @see EnvironmentalSensingService#getPressureEnvironmentalSensingConfiguration(int)
     */
    @Nullable
    public synchronized Integer getPressureEnvironmentalSensingConfiguration(int index) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.getPressureEnvironmentalSensingConfiguration(index);
        }
        return taskId;
    }

    /**
     * @see #setPressureEnvironmentalSensingConfiguration(int, EnvironmentalSensingConfiguration)
     */
    @Nullable
    public synchronized Integer setPressureEnvironmentalSensingConfiguration(@NonNull EnvironmentalSensingConfiguration environmentalSensingConfiguration) {
        return setPressureEnvironmentalSensingConfiguration(0, environmentalSensingConfiguration);
    }

    /**
     * @see EnvironmentalSensingService#setPressureEnvironmentalSensingConfiguration(int, EnvironmentalSensingConfiguration)
     */
    @Nullable
    public synchronized Integer setPressureEnvironmentalSensingConfiguration(int index, @NonNull EnvironmentalSensingConfiguration environmentalSensingConfiguration) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.setPressureEnvironmentalSensingConfiguration(index, environmentalSensingConfiguration);
        }
        return taskId;
    }

    /**
     * @see #getPressureCharacteristicUserDescription(int)
     */
    @Nullable
    public synchronized Integer getPressureCharacteristicUserDescription() {
        return getPressureCharacteristicUserDescription(0);
    }

    /**
     * @see EnvironmentalSensingService#getPressureCharacteristicUserDescription(int)
     */
    @Nullable
    public synchronized Integer getPressureCharacteristicUserDescription(int index) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.getPressureCharacteristicUserDescription(index);
        }
        return taskId;
    }

    /**
     * @see #setPressureCharacteristicUserDescription(int, CharacteristicUserDescription)
     */
    @Nullable
    public synchronized Integer setPressureCharacteristicUserDescription(@NonNull CharacteristicUserDescription characteristicUserDescription) {
        return setPressureCharacteristicUserDescription(0, characteristicUserDescription);
    }

    /**
     * @see EnvironmentalSensingService#setPressureCharacteristicUserDescription(int, CharacteristicUserDescription)
     */
    @Nullable
    public synchronized Integer setPressureCharacteristicUserDescription(int index, @NonNull CharacteristicUserDescription characteristicUserDescription) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.setPressureCharacteristicUserDescription(index, characteristicUserDescription);
        }
        return taskId;
    }

    /**
     * @see #getPressureValidRange(int)
     */
    @Nullable
    public synchronized Integer getPressureValidRange() {
        return getPressureValidRange(0);
    }

    /**
     * @see EnvironmentalSensingService#getPressureValidRange(int)
     */
    @Nullable
    public synchronized Integer getPressureValidRange(int index) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.getPressureValidRange(index);
        }
        return taskId;
    }

    /**
     * @see EnvironmentalSensingService#getRainfallCount()
     */
    @Nullable
    public synchronized Integer getRainfallCount() {
        Integer count = null;
        if (mEnvironmentalSensingService != null) {
            count = mEnvironmentalSensingService.getRainfallCount();
        }
        return count;
    }

    /**
     * @see #canRainfallNotify(int)
     */
    public synchronized Boolean canRainfallNotify() {
        return canRainfallNotify(0);
    }

    /**
     * @see EnvironmentalSensingService#canRainfallNotify(int)
     */
    public synchronized Boolean canRainfallNotify(int index) {
        Boolean result = null;
        if (mEnvironmentalSensingService != null) {
            result = mEnvironmentalSensingService.canRainfallNotify(index);
        }
        return result;
    }

    /**
     * @see #hasRainfallCharacteristicEnvironmentalSensingMeasurement(int)
     */
    public synchronized Boolean hasRainfallCharacteristicEnvironmentalSensingMeasurement() {
        return hasRainfallCharacteristicEnvironmentalSensingMeasurement(0);
    }

    /**
     * @see EnvironmentalSensingService#hasRainfallCharacteristicEnvironmentalSensingMeasurement(int)
     */
    public synchronized Boolean hasRainfallCharacteristicEnvironmentalSensingMeasurement(int index) {
        Boolean result = null;
        if (mEnvironmentalSensingService != null) {
            result = mEnvironmentalSensingService.hasRainfallCharacteristicEnvironmentalSensingMeasurement(index);
        }
        return result;
    }

    /**
     * @see #getRainfallCharacteristicEnvironmentalSensingTriggerSettingCount(int)
     */
    public synchronized Integer getRainfallCharacteristicEnvironmentalSensingTriggerSettingCount() {
        return getRainfallCharacteristicEnvironmentalSensingTriggerSettingCount(0);
    }

    /**
     * @see EnvironmentalSensingService#getRainfallCharacteristicEnvironmentalSensingTriggerSettingCount(int)
     */
    @Nullable
    public synchronized Integer getRainfallCharacteristicEnvironmentalSensingTriggerSettingCount(int index) {
        Integer count = null;
        if (mEnvironmentalSensingService != null) {
            count = mEnvironmentalSensingService.getRainfallCharacteristicEnvironmentalSensingTriggerSettingCount(index);
        }
        return count;
    }

    /**
     * @see #hasRainfallCharacteristicEnvironmentalSensingConfiguration(int)
     */
    public synchronized Boolean hasRainfallCharacteristicEnvironmentalSensingConfiguration() {
        return hasRainfallCharacteristicEnvironmentalSensingConfiguration(0);
    }

    /**
     * @see EnvironmentalSensingService#hasRainfallCharacteristicEnvironmentalSensingConfiguration(int)
     */
    public synchronized Boolean hasRainfallCharacteristicEnvironmentalSensingConfiguration(int index) {
        Boolean result = null;
        if (mEnvironmentalSensingService != null) {
            result = mEnvironmentalSensingService.hasRainfallCharacteristicEnvironmentalSensingConfiguration(index);
        }
        return result;
    }

    /**
     * @see #hasRainfallCharacteristicCharacteristicUserDescription(int)
     */
    public synchronized Boolean hasRainfallCharacteristicCharacteristicUserDescription() {
        return hasRainfallCharacteristicCharacteristicUserDescription(0);
    }

    /**
     * @see EnvironmentalSensingService#hasRainfallCharacteristicCharacteristicUserDescription(int)
     */
    public synchronized Boolean hasRainfallCharacteristicCharacteristicUserDescription(int index) {
        Boolean result = null;
        if (mEnvironmentalSensingService != null) {
            result = mEnvironmentalSensingService.hasRainfallCharacteristicCharacteristicUserDescription(index);
        }
        return result;
    }

    /**
     * @see #hasRainfallCharacteristicValidRange(int)
     */
    public synchronized Boolean hasRainfallCharacteristicValidRange() {
        return hasRainfallCharacteristicValidRange(0);
    }

    /**
     * @see EnvironmentalSensingService#hasRainfallCharacteristicValidRange(int)
     */
    public synchronized Boolean hasRainfallCharacteristicValidRange(int index) {
        Boolean result = null;
        if (mEnvironmentalSensingService != null) {
            result = mEnvironmentalSensingService.hasRainfallCharacteristicValidRange(index);
        }
        return result;
    }

    /**
     * @see #getRainfall(int)
     */
    @Nullable
    public synchronized Integer getRainfall() {
        return getRainfall(0);
    }

    /**
     * @see EnvironmentalSensingService#getRainfall(int)
     */
    @Nullable
    public synchronized Integer getRainfall(int index) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.getRainfall(index);
        }
        return taskId;
    }

    /**
     * @see #startRainfallNotification(int)
     */
    @Nullable
    public synchronized Integer startRainfallNotification() {
        return startRainfallNotification(0);
    }

    /**
     * @see EnvironmentalSensingService#startRainfallNotification(int)
     */
    @Nullable
    public synchronized Integer startRainfallNotification(int index) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.startRainfallNotification(index);
        }
        return taskId;
    }

    /**
     * @see #startRainfallNotification(int)
     */
    @Nullable
    public synchronized Integer stopRainfallNotification() {
        return stopRainfallNotification(0);
    }

    /**
     * @see EnvironmentalSensingService#stopRainfallNotification(int)
     */
    @Nullable
    public synchronized Integer stopRainfallNotification(int index) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.stopRainfallNotification(index);
        }
        return taskId;
    }

    /**
     * @see #getRainfallEnvironmentalSensingMeasurement(int)
     */
    @Nullable
    public synchronized Integer getRainfallEnvironmentalSensingMeasurement() {
        return getRainfallEnvironmentalSensingMeasurement(0);
    }

    /**
     * @see EnvironmentalSensingService#getRainfallEnvironmentalSensingMeasurement(int)
     */
    @Nullable
    public synchronized Integer getRainfallEnvironmentalSensingMeasurement(int index) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.getRainfallEnvironmentalSensingMeasurement(index);
        }
        return taskId;
    }

    /**
     * @see #getRainfallEnvironmentalSensingTriggerSetting(int, int)
     */
    @Nullable
    public synchronized Integer getRainfallEnvironmentalSensingTriggerSetting() {
        return getRainfallEnvironmentalSensingTriggerSetting(0, 0);
    }

    /**
     * @see EnvironmentalSensingService#getRainfallEnvironmentalSensingTriggerSetting(int, int)
     */
    @Nullable
    public synchronized Integer getRainfallEnvironmentalSensingTriggerSetting(int characteristicIndex, int descriptorIndex) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.getRainfallEnvironmentalSensingTriggerSetting(characteristicIndex, descriptorIndex);
        }
        return taskId;
    }

    /**
     * @see #setRainfallEnvironmentalSensingTriggerSetting(int, int, EnvironmentalSensingTriggerSetting)
     */
    @Nullable
    public synchronized Integer setRainfallEnvironmentalSensingTriggerSetting(@NonNull EnvironmentalSensingTriggerSetting environmentalSensingTriggerSetting) {
        return setRainfallEnvironmentalSensingTriggerSetting(0, 0, environmentalSensingTriggerSetting);
    }

    /**
     * @see EnvironmentalSensingService#setRainfallEnvironmentalSensingTriggerSetting(int, int, EnvironmentalSensingTriggerSetting)
     */
    @Nullable
    public synchronized Integer setRainfallEnvironmentalSensingTriggerSetting(int characteristicIndex, int descriptorIndex, @NonNull EnvironmentalSensingTriggerSetting environmentalSensingTriggerSetting) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.setRainfallEnvironmentalSensingTriggerSetting(characteristicIndex, descriptorIndex, environmentalSensingTriggerSetting);
        }
        return taskId;
    }

    /**
     * @see #getRainfallEnvironmentalSensingConfiguration(int)
     */
    @Nullable
    public synchronized Integer getRainfallEnvironmentalSensingConfiguration() {
        return getRainfallEnvironmentalSensingConfiguration(0);
    }

    /**
     * @see EnvironmentalSensingService#getRainfallEnvironmentalSensingConfiguration(int)
     */
    @Nullable
    public synchronized Integer getRainfallEnvironmentalSensingConfiguration(int index) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.getRainfallEnvironmentalSensingConfiguration(index);
        }
        return taskId;
    }

    /**
     * @see #setRainfallEnvironmentalSensingConfiguration(int, EnvironmentalSensingConfiguration)
     */
    @Nullable
    public synchronized Integer setRainfallEnvironmentalSensingConfiguration(@NonNull EnvironmentalSensingConfiguration environmentalSensingConfiguration) {
        return setRainfallEnvironmentalSensingConfiguration(0, environmentalSensingConfiguration);
    }

    /**
     * @see EnvironmentalSensingService#setRainfallEnvironmentalSensingConfiguration(int, EnvironmentalSensingConfiguration)
     */
    @Nullable
    public synchronized Integer setRainfallEnvironmentalSensingConfiguration(int index, @NonNull EnvironmentalSensingConfiguration environmentalSensingConfiguration) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.setRainfallEnvironmentalSensingConfiguration(index, environmentalSensingConfiguration);
        }
        return taskId;
    }

    /**
     * @see #getRainfallCharacteristicUserDescription(int)
     */
    @Nullable
    public synchronized Integer getRainfallCharacteristicUserDescription() {
        return getRainfallCharacteristicUserDescription(0);
    }

    /**
     * @see EnvironmentalSensingService#getRainfallCharacteristicUserDescription(int)
     */
    @Nullable
    public synchronized Integer getRainfallCharacteristicUserDescription(int index) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.getRainfallCharacteristicUserDescription(index);
        }
        return taskId;
    }

    /**
     * @see #setRainfallCharacteristicUserDescription(int, CharacteristicUserDescription)
     */
    @Nullable
    public synchronized Integer setRainfallCharacteristicUserDescription(@NonNull CharacteristicUserDescription characteristicUserDescription) {
        return setRainfallCharacteristicUserDescription(0, characteristicUserDescription);
    }

    /**
     * @see EnvironmentalSensingService#setRainfallCharacteristicUserDescription(int, CharacteristicUserDescription)
     */
    @Nullable
    public synchronized Integer setRainfallCharacteristicUserDescription(int index, @NonNull CharacteristicUserDescription characteristicUserDescription) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.setRainfallCharacteristicUserDescription(index, characteristicUserDescription);
        }
        return taskId;
    }

    /**
     * @see #getRainfallValidRange(int)
     */
    @Nullable
    public synchronized Integer getRainfallValidRange() {
        return getRainfallValidRange(0);
    }

    /**
     * @see EnvironmentalSensingService#getRainfallValidRange(int)
     */
    @Nullable
    public synchronized Integer getRainfallValidRange(int index) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.getRainfallValidRange(index);
        }
        return taskId;
    }

    /**
     * @see EnvironmentalSensingService#getSulfurDioxideConcentrationCount()
     */
    @Nullable
    public synchronized Integer getSulfurDioxideConcentrationCount() {
        Integer count = null;
        if (mEnvironmentalSensingService != null) {
            count = mEnvironmentalSensingService.getSulfurDioxideConcentrationCount();
        }
        return count;
    }

    /**
     * @see #canSulfurDioxideConcentrationNotify(int)
     */
    public synchronized Boolean canSulfurDioxideConcentrationNotify() {
        return canSulfurDioxideConcentrationNotify(0);
    }

    /**
     * @see EnvironmentalSensingService#canSulfurDioxideConcentrationNotify(int)
     */
    public synchronized Boolean canSulfurDioxideConcentrationNotify(int index) {
        Boolean result = null;
        if (mEnvironmentalSensingService != null) {
            result = mEnvironmentalSensingService.canSulfurDioxideConcentrationNotify(index);
        }
        return result;
    }

    /**
     * @see #hasSulfurDioxideConcentrationCharacteristicEnvironmentalSensingMeasurement(int)
     */
    public synchronized Boolean hasSulfurDioxideConcentrationCharacteristicEnvironmentalSensingMeasurement() {
        return hasSulfurDioxideConcentrationCharacteristicEnvironmentalSensingMeasurement(0);
    }

    /**
     * @see EnvironmentalSensingService#hasSulfurDioxideConcentrationCharacteristicEnvironmentalSensingMeasurement(int)
     */
    public synchronized Boolean hasSulfurDioxideConcentrationCharacteristicEnvironmentalSensingMeasurement(int index) {
        Boolean result = null;
        if (mEnvironmentalSensingService != null) {
            result = mEnvironmentalSensingService.hasSulfurDioxideConcentrationCharacteristicEnvironmentalSensingMeasurement(index);
        }
        return result;
    }

    /**
     * @see #getSulfurDioxideConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount(int)
     */
    public synchronized Integer getSulfurDioxideConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount() {
        return getSulfurDioxideConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount(0);
    }

    /**
     * @see EnvironmentalSensingService#getSulfurDioxideConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount(int)
     */
    @Nullable
    public synchronized Integer getSulfurDioxideConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount(int index) {
        Integer count = null;
        if (mEnvironmentalSensingService != null) {
            count = mEnvironmentalSensingService.getSulfurDioxideConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount(index);
        }
        return count;
    }

    /**
     * @see #hasSulfurDioxideConcentrationCharacteristicEnvironmentalSensingConfiguration(int)
     */
    public synchronized Boolean hasSulfurDioxideConcentrationCharacteristicEnvironmentalSensingConfiguration() {
        return hasSulfurDioxideConcentrationCharacteristicEnvironmentalSensingConfiguration(0);
    }

    /**
     * @see EnvironmentalSensingService#hasSulfurDioxideConcentrationCharacteristicEnvironmentalSensingConfiguration(int)
     */
    public synchronized Boolean hasSulfurDioxideConcentrationCharacteristicEnvironmentalSensingConfiguration(int index) {
        Boolean result = null;
        if (mEnvironmentalSensingService != null) {
            result = mEnvironmentalSensingService.hasSulfurDioxideConcentrationCharacteristicEnvironmentalSensingConfiguration(index);
        }
        return result;
    }

    /**
     * @see #hasSulfurDioxideConcentrationCharacteristicCharacteristicUserDescription(int)
     */
    public synchronized Boolean hasSulfurDioxideConcentrationCharacteristicCharacteristicUserDescription() {
        return hasSulfurDioxideConcentrationCharacteristicCharacteristicUserDescription(0);
    }

    /**
     * @see EnvironmentalSensingService#hasSulfurDioxideConcentrationCharacteristicCharacteristicUserDescription(int)
     */
    public synchronized Boolean hasSulfurDioxideConcentrationCharacteristicCharacteristicUserDescription(int index) {
        Boolean result = null;
        if (mEnvironmentalSensingService != null) {
            result = mEnvironmentalSensingService.hasSulfurDioxideConcentrationCharacteristicCharacteristicUserDescription(index);
        }
        return result;
    }

    /**
     * @see #hasSulfurDioxideConcentrationCharacteristicValidRange(int)
     */
    public synchronized Boolean hasSulfurDioxideConcentrationCharacteristicValidRange() {
        return hasSulfurDioxideConcentrationCharacteristicValidRange(0);
    }

    /**
     * @see EnvironmentalSensingService#hasSulfurDioxideConcentrationCharacteristicValidRange(int)
     */
    public synchronized Boolean hasSulfurDioxideConcentrationCharacteristicValidRange(int index) {
        Boolean result = null;
        if (mEnvironmentalSensingService != null) {
            result = mEnvironmentalSensingService.hasSulfurDioxideConcentrationCharacteristicValidRange(index);
        }
        return result;
    }

    /**
     * @see #getSulfurDioxideConcentration(int)
     */
    @Nullable
    public synchronized Integer getSulfurDioxideConcentration() {
        return getSulfurDioxideConcentration(0);
    }

    /**
     * @see EnvironmentalSensingService#getSulfurDioxideConcentration(int)
     */
    @Nullable
    public synchronized Integer getSulfurDioxideConcentration(int index) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.getSulfurDioxideConcentration(index);
        }
        return taskId;
    }

    /**
     * @see #startSulfurDioxideConcentrationNotification(int)
     */
    @Nullable
    public synchronized Integer startSulfurDioxideConcentrationNotification() {
        return startSulfurDioxideConcentrationNotification(0);
    }

    /**
     * @see EnvironmentalSensingService#startSulfurDioxideConcentrationNotification(int)
     */
    @Nullable
    public synchronized Integer startSulfurDioxideConcentrationNotification(int index) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.startSulfurDioxideConcentrationNotification(index);
        }
        return taskId;
    }

    /**
     * @see #startSulfurDioxideConcentrationNotification(int)
     */
    @Nullable
    public synchronized Integer stopSulfurDioxideConcentrationNotification() {
        return stopSulfurDioxideConcentrationNotification(0);
    }

    /**
     * @see EnvironmentalSensingService#stopSulfurDioxideConcentrationNotification(int)
     */
    @Nullable
    public synchronized Integer stopSulfurDioxideConcentrationNotification(int index) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.stopSulfurDioxideConcentrationNotification(index);
        }
        return taskId;
    }

    /**
     * @see #getSulfurDioxideConcentrationEnvironmentalSensingMeasurement(int)
     */
    @Nullable
    public synchronized Integer getSulfurDioxideConcentrationEnvironmentalSensingMeasurement() {
        return getSulfurDioxideConcentrationEnvironmentalSensingMeasurement(0);
    }

    /**
     * @see EnvironmentalSensingService#getSulfurDioxideConcentrationEnvironmentalSensingMeasurement(int)
     */
    @Nullable
    public synchronized Integer getSulfurDioxideConcentrationEnvironmentalSensingMeasurement(int index) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.getSulfurDioxideConcentrationEnvironmentalSensingMeasurement(index);
        }
        return taskId;
    }

    /**
     * @see #getSulfurDioxideConcentrationEnvironmentalSensingTriggerSetting(int, int)
     */
    @Nullable
    public synchronized Integer getSulfurDioxideConcentrationEnvironmentalSensingTriggerSetting() {
        return getSulfurDioxideConcentrationEnvironmentalSensingTriggerSetting(0, 0);
    }

    /**
     * @see EnvironmentalSensingService#getSulfurDioxideConcentrationEnvironmentalSensingTriggerSetting(int, int)
     */
    @Nullable
    public synchronized Integer getSulfurDioxideConcentrationEnvironmentalSensingTriggerSetting(int characteristicIndex, int descriptorIndex) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.getSulfurDioxideConcentrationEnvironmentalSensingTriggerSetting(characteristicIndex, descriptorIndex);
        }
        return taskId;
    }

    /**
     * @see #setSulfurDioxideConcentrationEnvironmentalSensingTriggerSetting(int, int, EnvironmentalSensingTriggerSetting)
     */
    @Nullable
    public synchronized Integer setSulfurDioxideConcentrationEnvironmentalSensingTriggerSetting(@NonNull EnvironmentalSensingTriggerSetting environmentalSensingTriggerSetting) {
        return setSulfurDioxideConcentrationEnvironmentalSensingTriggerSetting(0, 0, environmentalSensingTriggerSetting);
    }

    /**
     * @see EnvironmentalSensingService#setSulfurDioxideConcentrationEnvironmentalSensingTriggerSetting(int, int, EnvironmentalSensingTriggerSetting)
     */
    @Nullable
    public synchronized Integer setSulfurDioxideConcentrationEnvironmentalSensingTriggerSetting(int characteristicIndex, int descriptorIndex, @NonNull EnvironmentalSensingTriggerSetting environmentalSensingTriggerSetting) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.setSulfurDioxideConcentrationEnvironmentalSensingTriggerSetting(characteristicIndex, descriptorIndex, environmentalSensingTriggerSetting);
        }
        return taskId;
    }

    /**
     * @see #getSulfurDioxideConcentrationEnvironmentalSensingConfiguration(int)
     */
    @Nullable
    public synchronized Integer getSulfurDioxideConcentrationEnvironmentalSensingConfiguration() {
        return getSulfurDioxideConcentrationEnvironmentalSensingConfiguration(0);
    }

    /**
     * @see EnvironmentalSensingService#getSulfurDioxideConcentrationEnvironmentalSensingConfiguration(int)
     */
    @Nullable
    public synchronized Integer getSulfurDioxideConcentrationEnvironmentalSensingConfiguration(int index) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.getSulfurDioxideConcentrationEnvironmentalSensingConfiguration(index);
        }
        return taskId;
    }

    /**
     * @see #setSulfurDioxideConcentrationEnvironmentalSensingConfiguration(int, EnvironmentalSensingConfiguration)
     */
    @Nullable
    public synchronized Integer setSulfurDioxideConcentrationEnvironmentalSensingConfiguration(@NonNull EnvironmentalSensingConfiguration environmentalSensingConfiguration) {
        return setSulfurDioxideConcentrationEnvironmentalSensingConfiguration(0, environmentalSensingConfiguration);
    }

    /**
     * @see EnvironmentalSensingService#setSulfurDioxideConcentrationEnvironmentalSensingConfiguration(int, EnvironmentalSensingConfiguration)
     */
    @Nullable
    public synchronized Integer setSulfurDioxideConcentrationEnvironmentalSensingConfiguration(int index, @NonNull EnvironmentalSensingConfiguration environmentalSensingConfiguration) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.setSulfurDioxideConcentrationEnvironmentalSensingConfiguration(index, environmentalSensingConfiguration);
        }
        return taskId;
    }

    /**
     * @see #getSulfurDioxideConcentrationCharacteristicUserDescription(int)
     */
    @Nullable
    public synchronized Integer getSulfurDioxideConcentrationCharacteristicUserDescription() {
        return getSulfurDioxideConcentrationCharacteristicUserDescription(0);
    }

    /**
     * @see EnvironmentalSensingService#getSulfurDioxideConcentrationCharacteristicUserDescription(int)
     */
    @Nullable
    public synchronized Integer getSulfurDioxideConcentrationCharacteristicUserDescription(int index) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.getSulfurDioxideConcentrationCharacteristicUserDescription(index);
        }
        return taskId;
    }

    /**
     * @see #setSulfurDioxideConcentrationCharacteristicUserDescription(int, CharacteristicUserDescription)
     */
    @Nullable
    public synchronized Integer setSulfurDioxideConcentrationCharacteristicUserDescription(@NonNull CharacteristicUserDescription characteristicUserDescription) {
        return setSulfurDioxideConcentrationCharacteristicUserDescription(0, characteristicUserDescription);
    }

    /**
     * @see EnvironmentalSensingService#setSulfurDioxideConcentrationCharacteristicUserDescription(int, CharacteristicUserDescription)
     */
    @Nullable
    public synchronized Integer setSulfurDioxideConcentrationCharacteristicUserDescription(int index, @NonNull CharacteristicUserDescription characteristicUserDescription) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.setSulfurDioxideConcentrationCharacteristicUserDescription(index, characteristicUserDescription);
        }
        return taskId;
    }

    /**
     * @see #getSulfurDioxideConcentrationValidRange(int)
     */
    @Nullable
    public synchronized Integer getSulfurDioxideConcentrationValidRange() {
        return getSulfurDioxideConcentrationValidRange(0);
    }

    /**
     * @see EnvironmentalSensingService#getSulfurDioxideConcentrationValidRange(int)
     */
    @Nullable
    public synchronized Integer getSulfurDioxideConcentrationValidRange(int index) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.getSulfurDioxideConcentrationValidRange(index);
        }
        return taskId;
    }

    /**
     * @see EnvironmentalSensingService#getSulfurHexafluorideConcentrationCount()
     */
    @Nullable
    public synchronized Integer getSulfurHexafluorideConcentrationCount() {
        Integer count = null;
        if (mEnvironmentalSensingService != null) {
            count = mEnvironmentalSensingService.getSulfurHexafluorideConcentrationCount();
        }
        return count;
    }

    /**
     * @see #canSulfurHexafluorideConcentrationNotify(int)
     */
    public synchronized Boolean canSulfurHexafluorideConcentrationNotify() {
        return canSulfurHexafluorideConcentrationNotify(0);
    }

    /**
     * @see EnvironmentalSensingService#canSulfurHexafluorideConcentrationNotify(int)
     */
    public synchronized Boolean canSulfurHexafluorideConcentrationNotify(int index) {
        Boolean result = null;
        if (mEnvironmentalSensingService != null) {
            result = mEnvironmentalSensingService.canSulfurHexafluorideConcentrationNotify(index);
        }
        return result;
    }

    /**
     * @see #hasSulfurHexafluorideConcentrationCharacteristicEnvironmentalSensingMeasurement(int)
     */
    public synchronized Boolean hasSulfurHexafluorideConcentrationCharacteristicEnvironmentalSensingMeasurement() {
        return hasSulfurHexafluorideConcentrationCharacteristicEnvironmentalSensingMeasurement(0);
    }

    /**
     * @see EnvironmentalSensingService#hasSulfurHexafluorideConcentrationCharacteristicEnvironmentalSensingMeasurement(int)
     */
    public synchronized Boolean hasSulfurHexafluorideConcentrationCharacteristicEnvironmentalSensingMeasurement(int index) {
        Boolean result = null;
        if (mEnvironmentalSensingService != null) {
            result = mEnvironmentalSensingService.hasSulfurHexafluorideConcentrationCharacteristicEnvironmentalSensingMeasurement(index);
        }
        return result;
    }

    /**
     * @see #getSulfurHexafluorideConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount(int)
     */
    public synchronized Integer getSulfurHexafluorideConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount() {
        return getSulfurHexafluorideConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount(0);
    }

    /**
     * @see EnvironmentalSensingService#getSulfurHexafluorideConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount(int)
     */
    @Nullable
    public synchronized Integer getSulfurHexafluorideConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount(int index) {
        Integer count = null;
        if (mEnvironmentalSensingService != null) {
            count = mEnvironmentalSensingService.getSulfurHexafluorideConcentrationCharacteristicEnvironmentalSensingTriggerSettingCount(index);
        }
        return count;
    }

    /**
     * @see #hasSulfurHexafluorideConcentrationCharacteristicEnvironmentalSensingConfiguration(int)
     */
    public synchronized Boolean hasSulfurHexafluorideConcentrationCharacteristicEnvironmentalSensingConfiguration() {
        return hasSulfurHexafluorideConcentrationCharacteristicEnvironmentalSensingConfiguration(0);
    }

    /**
     * @see EnvironmentalSensingService#hasSulfurHexafluorideConcentrationCharacteristicEnvironmentalSensingConfiguration(int)
     */
    public synchronized Boolean hasSulfurHexafluorideConcentrationCharacteristicEnvironmentalSensingConfiguration(int index) {
        Boolean result = null;
        if (mEnvironmentalSensingService != null) {
            result = mEnvironmentalSensingService.hasSulfurHexafluorideConcentrationCharacteristicEnvironmentalSensingConfiguration(index);
        }
        return result;
    }

    /**
     * @see #hasSulfurHexafluorideConcentrationCharacteristicCharacteristicUserDescription(int)
     */
    public synchronized Boolean hasSulfurHexafluorideConcentrationCharacteristicCharacteristicUserDescription() {
        return hasSulfurHexafluorideConcentrationCharacteristicCharacteristicUserDescription(0);
    }

    /**
     * @see EnvironmentalSensingService#hasSulfurHexafluorideConcentrationCharacteristicCharacteristicUserDescription(int)
     */
    public synchronized Boolean hasSulfurHexafluorideConcentrationCharacteristicCharacteristicUserDescription(int index) {
        Boolean result = null;
        if (mEnvironmentalSensingService != null) {
            result = mEnvironmentalSensingService.hasSulfurHexafluorideConcentrationCharacteristicCharacteristicUserDescription(index);
        }
        return result;
    }

    /**
     * @see #hasSulfurHexafluorideConcentrationCharacteristicValidRange(int)
     */
    public synchronized Boolean hasSulfurHexafluorideConcentrationCharacteristicValidRange() {
        return hasSulfurHexafluorideConcentrationCharacteristicValidRange(0);
    }

    /**
     * @see EnvironmentalSensingService#hasSulfurHexafluorideConcentrationCharacteristicValidRange(int)
     */
    public synchronized Boolean hasSulfurHexafluorideConcentrationCharacteristicValidRange(int index) {
        Boolean result = null;
        if (mEnvironmentalSensingService != null) {
            result = mEnvironmentalSensingService.hasSulfurHexafluorideConcentrationCharacteristicValidRange(index);
        }
        return result;
    }

    /**
     * @see #getSulfurHexafluorideConcentration(int)
     */
    @Nullable
    public synchronized Integer getSulfurHexafluorideConcentration() {
        return getSulfurHexafluorideConcentration(0);
    }

    /**
     * @see EnvironmentalSensingService#getSulfurHexafluorideConcentration(int)
     */
    @Nullable
    public synchronized Integer getSulfurHexafluorideConcentration(int index) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.getSulfurHexafluorideConcentration(index);
        }
        return taskId;
    }

    /**
     * @see #startSulfurHexafluorideConcentrationNotification(int)
     */
    @Nullable
    public synchronized Integer startSulfurHexafluorideConcentrationNotification() {
        return startSulfurHexafluorideConcentrationNotification(0);
    }

    /**
     * @see EnvironmentalSensingService#startSulfurHexafluorideConcentrationNotification(int)
     */
    @Nullable
    public synchronized Integer startSulfurHexafluorideConcentrationNotification(int index) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.startSulfurHexafluorideConcentrationNotification(index);
        }
        return taskId;
    }

    /**
     * @see #startSulfurHexafluorideConcentrationNotification(int)
     */
    @Nullable
    public synchronized Integer stopSulfurHexafluorideConcentrationNotification() {
        return stopSulfurHexafluorideConcentrationNotification(0);
    }

    /**
     * @see EnvironmentalSensingService#stopSulfurHexafluorideConcentrationNotification(int)
     */
    @Nullable
    public synchronized Integer stopSulfurHexafluorideConcentrationNotification(int index) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.stopSulfurHexafluorideConcentrationNotification(index);
        }
        return taskId;
    }

    /**
     * @see #getSulfurHexafluorideConcentrationEnvironmentalSensingMeasurement(int)
     */
    @Nullable
    public synchronized Integer getSulfurHexafluorideConcentrationEnvironmentalSensingMeasurement() {
        return getSulfurHexafluorideConcentrationEnvironmentalSensingMeasurement(0);
    }

    /**
     * @see EnvironmentalSensingService#getSulfurHexafluorideConcentrationEnvironmentalSensingMeasurement(int)
     */
    @Nullable
    public synchronized Integer getSulfurHexafluorideConcentrationEnvironmentalSensingMeasurement(int index) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.getSulfurHexafluorideConcentrationEnvironmentalSensingMeasurement(index);
        }
        return taskId;
    }

    /**
     * @see #getSulfurHexafluorideConcentrationEnvironmentalSensingTriggerSetting(int, int)
     */
    @Nullable
    public synchronized Integer getSulfurHexafluorideConcentrationEnvironmentalSensingTriggerSetting() {
        return getSulfurHexafluorideConcentrationEnvironmentalSensingTriggerSetting(0, 0);
    }

    /**
     * @see EnvironmentalSensingService#getSulfurHexafluorideConcentrationEnvironmentalSensingTriggerSetting(int, int)
     */
    @Nullable
    public synchronized Integer getSulfurHexafluorideConcentrationEnvironmentalSensingTriggerSetting(int characteristicIndex, int descriptorIndex) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.getSulfurHexafluorideConcentrationEnvironmentalSensingTriggerSetting(characteristicIndex, descriptorIndex);
        }
        return taskId;
    }

    /**
     * @see #setSulfurHexafluorideConcentrationEnvironmentalSensingTriggerSetting(int, int, EnvironmentalSensingTriggerSetting)
     */
    @Nullable
    public synchronized Integer setSulfurHexafluorideConcentrationEnvironmentalSensingTriggerSetting(@NonNull EnvironmentalSensingTriggerSetting environmentalSensingTriggerSetting) {
        return setSulfurHexafluorideConcentrationEnvironmentalSensingTriggerSetting(0, 0, environmentalSensingTriggerSetting);
    }

    /**
     * @see EnvironmentalSensingService#setSulfurHexafluorideConcentrationEnvironmentalSensingTriggerSetting(int, int, EnvironmentalSensingTriggerSetting)
     */
    @Nullable
    public synchronized Integer setSulfurHexafluorideConcentrationEnvironmentalSensingTriggerSetting(int characteristicIndex, int descriptorIndex, @NonNull EnvironmentalSensingTriggerSetting environmentalSensingTriggerSetting) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.setSulfurHexafluorideConcentrationEnvironmentalSensingTriggerSetting(characteristicIndex, descriptorIndex, environmentalSensingTriggerSetting);
        }
        return taskId;
    }

    /**
     * @see #getSulfurHexafluorideConcentrationEnvironmentalSensingConfiguration(int)
     */
    @Nullable
    public synchronized Integer getSulfurHexafluorideConcentrationEnvironmentalSensingConfiguration() {
        return getSulfurHexafluorideConcentrationEnvironmentalSensingConfiguration(0);
    }

    /**
     * @see EnvironmentalSensingService#getSulfurHexafluorideConcentrationEnvironmentalSensingConfiguration(int)
     */
    @Nullable
    public synchronized Integer getSulfurHexafluorideConcentrationEnvironmentalSensingConfiguration(int index) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.getSulfurHexafluorideConcentrationEnvironmentalSensingConfiguration(index);
        }
        return taskId;
    }

    /**
     * @see #setSulfurHexafluorideConcentrationEnvironmentalSensingConfiguration(int, EnvironmentalSensingConfiguration)
     */
    @Nullable
    public synchronized Integer setSulfurHexafluorideConcentrationEnvironmentalSensingConfiguration(@NonNull EnvironmentalSensingConfiguration environmentalSensingConfiguration) {
        return setSulfurHexafluorideConcentrationEnvironmentalSensingConfiguration(0, environmentalSensingConfiguration);
    }

    /**
     * @see EnvironmentalSensingService#setSulfurHexafluorideConcentrationEnvironmentalSensingConfiguration(int, EnvironmentalSensingConfiguration)
     */
    @Nullable
    public synchronized Integer setSulfurHexafluorideConcentrationEnvironmentalSensingConfiguration(int index, @NonNull EnvironmentalSensingConfiguration environmentalSensingConfiguration) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.setSulfurHexafluorideConcentrationEnvironmentalSensingConfiguration(index, environmentalSensingConfiguration);
        }
        return taskId;
    }

    /**
     * @see #getSulfurHexafluorideConcentrationCharacteristicUserDescription(int)
     */
    @Nullable
    public synchronized Integer getSulfurHexafluorideConcentrationCharacteristicUserDescription() {
        return getSulfurHexafluorideConcentrationCharacteristicUserDescription(0);
    }

    /**
     * @see EnvironmentalSensingService#getSulfurHexafluorideConcentrationCharacteristicUserDescription(int)
     */
    @Nullable
    public synchronized Integer getSulfurHexafluorideConcentrationCharacteristicUserDescription(int index) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.getSulfurHexafluorideConcentrationCharacteristicUserDescription(index);
        }
        return taskId;
    }

    /**
     * @see #setSulfurHexafluorideConcentrationCharacteristicUserDescription(int, CharacteristicUserDescription)
     */
    @Nullable
    public synchronized Integer setSulfurHexafluorideConcentrationCharacteristicUserDescription(@NonNull CharacteristicUserDescription characteristicUserDescription) {
        return setSulfurHexafluorideConcentrationCharacteristicUserDescription(0, characteristicUserDescription);
    }

    /**
     * @see EnvironmentalSensingService#setSulfurHexafluorideConcentrationCharacteristicUserDescription(int, CharacteristicUserDescription)
     */
    @Nullable
    public synchronized Integer setSulfurHexafluorideConcentrationCharacteristicUserDescription(int index, @NonNull CharacteristicUserDescription characteristicUserDescription) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.setSulfurHexafluorideConcentrationCharacteristicUserDescription(index, characteristicUserDescription);
        }
        return taskId;
    }

    /**
     * @see #getSulfurHexafluorideConcentrationValidRange(int)
     */
    @Nullable
    public synchronized Integer getSulfurHexafluorideConcentrationValidRange() {
        return getSulfurHexafluorideConcentrationValidRange(0);
    }

    /**
     * @see EnvironmentalSensingService#getSulfurHexafluorideConcentrationValidRange(int)
     */
    @Nullable
    public synchronized Integer getSulfurHexafluorideConcentrationValidRange(int index) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.getSulfurHexafluorideConcentrationValidRange(index);
        }
        return taskId;
    }

    /**
     * @see EnvironmentalSensingService#getTemperatureCount()
     */
    @Nullable
    public synchronized Integer getTemperatureCount() {
        Integer count = null;
        if (mEnvironmentalSensingService != null) {
            count = mEnvironmentalSensingService.getTemperatureCount();
        }
        return count;
    }

    /**
     * @see #canTemperatureNotify(int)
     */
    public synchronized Boolean canTemperatureNotify() {
        return canTemperatureNotify(0);
    }

    /**
     * @see EnvironmentalSensingService#canTemperatureNotify(int)
     */
    public synchronized Boolean canTemperatureNotify(int index) {
        Boolean result = null;
        if (mEnvironmentalSensingService != null) {
            result = mEnvironmentalSensingService.canTemperatureNotify(index);
        }
        return result;
    }

    /**
     * @see #hasTemperatureCharacteristicEnvironmentalSensingMeasurement(int)
     */
    public synchronized Boolean hasTemperatureCharacteristicEnvironmentalSensingMeasurement() {
        return hasTemperatureCharacteristicEnvironmentalSensingMeasurement(0);
    }

    /**
     * @see EnvironmentalSensingService#hasTemperatureCharacteristicEnvironmentalSensingMeasurement(int)
     */
    public synchronized Boolean hasTemperatureCharacteristicEnvironmentalSensingMeasurement(int index) {
        Boolean result = null;
        if (mEnvironmentalSensingService != null) {
            result = mEnvironmentalSensingService.hasTemperatureCharacteristicEnvironmentalSensingMeasurement(index);
        }
        return result;
    }

    /**
     * @see #getTemperatureCharacteristicEnvironmentalSensingTriggerSettingCount(int)
     */
    public synchronized Integer getTemperatureCharacteristicEnvironmentalSensingTriggerSettingCount() {
        return getTemperatureCharacteristicEnvironmentalSensingTriggerSettingCount(0);
    }

    /**
     * @see EnvironmentalSensingService#getTemperatureCharacteristicEnvironmentalSensingTriggerSettingCount(int)
     */
    @Nullable
    public synchronized Integer getTemperatureCharacteristicEnvironmentalSensingTriggerSettingCount(int index) {
        Integer count = null;
        if (mEnvironmentalSensingService != null) {
            count = mEnvironmentalSensingService.getTemperatureCharacteristicEnvironmentalSensingTriggerSettingCount(index);
        }
        return count;
    }

    /**
     * @see #hasTemperatureCharacteristicEnvironmentalSensingConfiguration(int)
     */
    public synchronized Boolean hasTemperatureCharacteristicEnvironmentalSensingConfiguration() {
        return hasTemperatureCharacteristicEnvironmentalSensingConfiguration(0);
    }

    /**
     * @see EnvironmentalSensingService#hasTemperatureCharacteristicEnvironmentalSensingConfiguration(int)
     */
    public synchronized Boolean hasTemperatureCharacteristicEnvironmentalSensingConfiguration(int index) {
        Boolean result = null;
        if (mEnvironmentalSensingService != null) {
            result = mEnvironmentalSensingService.hasTemperatureCharacteristicEnvironmentalSensingConfiguration(index);
        }
        return result;
    }

    /**
     * @see #hasTemperatureCharacteristicCharacteristicUserDescription(int)
     */
    public synchronized Boolean hasTemperatureCharacteristicCharacteristicUserDescription() {
        return hasTemperatureCharacteristicCharacteristicUserDescription(0);
    }

    /**
     * @see EnvironmentalSensingService#hasTemperatureCharacteristicCharacteristicUserDescription(int)
     */
    public synchronized Boolean hasTemperatureCharacteristicCharacteristicUserDescription(int index) {
        Boolean result = null;
        if (mEnvironmentalSensingService != null) {
            result = mEnvironmentalSensingService.hasTemperatureCharacteristicCharacteristicUserDescription(index);
        }
        return result;
    }

    /**
     * @see #hasTemperatureCharacteristicValidRange(int)
     */
    public synchronized Boolean hasTemperatureCharacteristicValidRange() {
        return hasTemperatureCharacteristicValidRange(0);
    }

    /**
     * @see EnvironmentalSensingService#hasTemperatureCharacteristicValidRange(int)
     */
    public synchronized Boolean hasTemperatureCharacteristicValidRange(int index) {
        Boolean result = null;
        if (mEnvironmentalSensingService != null) {
            result = mEnvironmentalSensingService.hasTemperatureCharacteristicValidRange(index);
        }
        return result;
    }

    /**
     * @see #getTemperature(int)
     */
    @Nullable
    public synchronized Integer getTemperature() {
        return getTemperature(0);
    }

    /**
     * @see EnvironmentalSensingService#getTemperature(int)
     */
    @Nullable
    public synchronized Integer getTemperature(int index) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.getTemperature(index);
        }
        return taskId;
    }

    /**
     * @see #startTemperatureNotification(int)
     */
    @Nullable
    public synchronized Integer startTemperatureNotification() {
        return startTemperatureNotification(0);
    }

    /**
     * @see EnvironmentalSensingService#startTemperatureNotification(int)
     */
    @Nullable
    public synchronized Integer startTemperatureNotification(int index) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.startTemperatureNotification(index);
        }
        return taskId;
    }

    /**
     * @see #startTemperatureNotification(int)
     */
    @Nullable
    public synchronized Integer stopTemperatureNotification() {
        return stopTemperatureNotification(0);
    }

    /**
     * @see EnvironmentalSensingService#stopTemperatureNotification(int)
     */
    @Nullable
    public synchronized Integer stopTemperatureNotification(int index) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.stopTemperatureNotification(index);
        }
        return taskId;
    }

    /**
     * @see #getTemperatureEnvironmentalSensingMeasurement(int)
     */
    @Nullable
    public synchronized Integer getTemperatureEnvironmentalSensingMeasurement() {
        return getTemperatureEnvironmentalSensingMeasurement(0);
    }

    /**
     * @see EnvironmentalSensingService#getTemperatureEnvironmentalSensingMeasurement(int)
     */
    @Nullable
    public synchronized Integer getTemperatureEnvironmentalSensingMeasurement(int index) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.getTemperatureEnvironmentalSensingMeasurement(index);
        }
        return taskId;
    }

    /**
     * @see #getTemperatureEnvironmentalSensingTriggerSetting(int, int)
     */
    @Nullable
    public synchronized Integer getTemperatureEnvironmentalSensingTriggerSetting() {
        return getTemperatureEnvironmentalSensingTriggerSetting(0, 0);
    }

    /**
     * @see EnvironmentalSensingService#getTemperatureEnvironmentalSensingTriggerSetting(int, int)
     */
    @Nullable
    public synchronized Integer getTemperatureEnvironmentalSensingTriggerSetting(int characteristicIndex, int descriptorIndex) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.getTemperatureEnvironmentalSensingTriggerSetting(characteristicIndex, descriptorIndex);
        }
        return taskId;
    }

    /**
     * @see #setTemperatureEnvironmentalSensingTriggerSetting(int, int, EnvironmentalSensingTriggerSetting)
     */
    @Nullable
    public synchronized Integer setTemperatureEnvironmentalSensingTriggerSetting(@NonNull EnvironmentalSensingTriggerSetting environmentalSensingTriggerSetting) {
        return setTemperatureEnvironmentalSensingTriggerSetting(0, 0, environmentalSensingTriggerSetting);
    }

    /**
     * @see EnvironmentalSensingService#setTemperatureEnvironmentalSensingTriggerSetting(int, int, EnvironmentalSensingTriggerSetting)
     */
    @Nullable
    public synchronized Integer setTemperatureEnvironmentalSensingTriggerSetting(int characteristicIndex, int descriptorIndex, @NonNull EnvironmentalSensingTriggerSetting environmentalSensingTriggerSetting) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.setTemperatureEnvironmentalSensingTriggerSetting(characteristicIndex, descriptorIndex, environmentalSensingTriggerSetting);
        }
        return taskId;
    }

    /**
     * @see #getTemperatureEnvironmentalSensingConfiguration(int)
     */
    @Nullable
    public synchronized Integer getTemperatureEnvironmentalSensingConfiguration() {
        return getTemperatureEnvironmentalSensingConfiguration(0);
    }

    /**
     * @see EnvironmentalSensingService#getTemperatureEnvironmentalSensingConfiguration(int)
     */
    @Nullable
    public synchronized Integer getTemperatureEnvironmentalSensingConfiguration(int index) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.getTemperatureEnvironmentalSensingConfiguration(index);
        }
        return taskId;
    }

    /**
     * @see #setTemperatureEnvironmentalSensingConfiguration(int, EnvironmentalSensingConfiguration)
     */
    @Nullable
    public synchronized Integer setTemperatureEnvironmentalSensingConfiguration(@NonNull EnvironmentalSensingConfiguration environmentalSensingConfiguration) {
        return setTemperatureEnvironmentalSensingConfiguration(0, environmentalSensingConfiguration);
    }

    /**
     * @see EnvironmentalSensingService#setTemperatureEnvironmentalSensingConfiguration(int, EnvironmentalSensingConfiguration)
     */
    @Nullable
    public synchronized Integer setTemperatureEnvironmentalSensingConfiguration(int index, @NonNull EnvironmentalSensingConfiguration environmentalSensingConfiguration) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.setTemperatureEnvironmentalSensingConfiguration(index, environmentalSensingConfiguration);
        }
        return taskId;
    }

    /**
     * @see #getTemperatureCharacteristicUserDescription(int)
     */
    @Nullable
    public synchronized Integer getTemperatureCharacteristicUserDescription() {
        return getTemperatureCharacteristicUserDescription(0);
    }

    /**
     * @see EnvironmentalSensingService#getTemperatureCharacteristicUserDescription(int)
     */
    @Nullable
    public synchronized Integer getTemperatureCharacteristicUserDescription(int index) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.getTemperatureCharacteristicUserDescription(index);
        }
        return taskId;
    }

    /**
     * @see #setTemperatureCharacteristicUserDescription(int, CharacteristicUserDescription)
     */
    @Nullable
    public synchronized Integer setTemperatureCharacteristicUserDescription(@NonNull CharacteristicUserDescription characteristicUserDescription) {
        return setTemperatureCharacteristicUserDescription(0, characteristicUserDescription);
    }

    /**
     * @see EnvironmentalSensingService#setTemperatureCharacteristicUserDescription(int, CharacteristicUserDescription)
     */
    @Nullable
    public synchronized Integer setTemperatureCharacteristicUserDescription(int index, @NonNull CharacteristicUserDescription characteristicUserDescription) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.setTemperatureCharacteristicUserDescription(index, characteristicUserDescription);
        }
        return taskId;
    }

    /**
     * @see #getTemperatureValidRange(int)
     */
    @Nullable
    public synchronized Integer getTemperatureValidRange() {
        return getTemperatureValidRange(0);
    }

    /**
     * @see EnvironmentalSensingService#getTemperatureValidRange(int)
     */
    @Nullable
    public synchronized Integer getTemperatureValidRange(int index) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.getTemperatureValidRange(index);
        }
        return taskId;
    }

    /**
     * @see EnvironmentalSensingService#getTrueWindDirectionCount()
     */
    @Nullable
    public synchronized Integer getTrueWindDirectionCount() {
        Integer count = null;
        if (mEnvironmentalSensingService != null) {
            count = mEnvironmentalSensingService.getTrueWindDirectionCount();
        }
        return count;
    }

    /**
     * @see #canTrueWindDirectionNotify(int)
     */
    public synchronized Boolean canTrueWindDirectionNotify() {
        return canTrueWindDirectionNotify(0);
    }

    /**
     * @see EnvironmentalSensingService#canTrueWindDirectionNotify(int)
     */
    public synchronized Boolean canTrueWindDirectionNotify(int index) {
        Boolean result = null;
        if (mEnvironmentalSensingService != null) {
            result = mEnvironmentalSensingService.canTrueWindDirectionNotify(index);
        }
        return result;
    }

    /**
     * @see #hasTrueWindDirectionCharacteristicEnvironmentalSensingMeasurement(int)
     */
    public synchronized Boolean hasTrueWindDirectionCharacteristicEnvironmentalSensingMeasurement() {
        return hasTrueWindDirectionCharacteristicEnvironmentalSensingMeasurement(0);
    }

    /**
     * @see EnvironmentalSensingService#hasTrueWindDirectionCharacteristicEnvironmentalSensingMeasurement(int)
     */
    public synchronized Boolean hasTrueWindDirectionCharacteristicEnvironmentalSensingMeasurement(int index) {
        Boolean result = null;
        if (mEnvironmentalSensingService != null) {
            result = mEnvironmentalSensingService.hasTrueWindDirectionCharacteristicEnvironmentalSensingMeasurement(index);
        }
        return result;
    }

    /**
     * @see #getTrueWindDirectionCharacteristicEnvironmentalSensingTriggerSettingCount(int)
     */
    public synchronized Integer getTrueWindDirectionCharacteristicEnvironmentalSensingTriggerSettingCount() {
        return getTrueWindDirectionCharacteristicEnvironmentalSensingTriggerSettingCount(0);
    }

    /**
     * @see EnvironmentalSensingService#getTrueWindDirectionCharacteristicEnvironmentalSensingTriggerSettingCount(int)
     */
    @Nullable
    public synchronized Integer getTrueWindDirectionCharacteristicEnvironmentalSensingTriggerSettingCount(int index) {
        Integer count = null;
        if (mEnvironmentalSensingService != null) {
            count = mEnvironmentalSensingService.getTrueWindDirectionCharacteristicEnvironmentalSensingTriggerSettingCount(index);
        }
        return count;
    }

    /**
     * @see #hasTrueWindDirectionCharacteristicEnvironmentalSensingConfiguration(int)
     */
    public synchronized Boolean hasTrueWindDirectionCharacteristicEnvironmentalSensingConfiguration() {
        return hasTrueWindDirectionCharacteristicEnvironmentalSensingConfiguration(0);
    }

    /**
     * @see EnvironmentalSensingService#hasTrueWindDirectionCharacteristicEnvironmentalSensingConfiguration(int)
     */
    public synchronized Boolean hasTrueWindDirectionCharacteristicEnvironmentalSensingConfiguration(int index) {
        Boolean result = null;
        if (mEnvironmentalSensingService != null) {
            result = mEnvironmentalSensingService.hasTrueWindDirectionCharacteristicEnvironmentalSensingConfiguration(index);
        }
        return result;
    }

    /**
     * @see #hasTrueWindDirectionCharacteristicCharacteristicUserDescription(int)
     */
    public synchronized Boolean hasTrueWindDirectionCharacteristicCharacteristicUserDescription() {
        return hasTrueWindDirectionCharacteristicCharacteristicUserDescription(0);
    }

    /**
     * @see EnvironmentalSensingService#hasTrueWindDirectionCharacteristicCharacteristicUserDescription(int)
     */
    public synchronized Boolean hasTrueWindDirectionCharacteristicCharacteristicUserDescription(int index) {
        Boolean result = null;
        if (mEnvironmentalSensingService != null) {
            result = mEnvironmentalSensingService.hasTrueWindDirectionCharacteristicCharacteristicUserDescription(index);
        }
        return result;
    }

    /**
     * @see #hasTrueWindDirectionCharacteristicValidRange(int)
     */
    public synchronized Boolean hasTrueWindDirectionCharacteristicValidRange() {
        return hasTrueWindDirectionCharacteristicValidRange(0);
    }

    /**
     * @see EnvironmentalSensingService#hasTrueWindDirectionCharacteristicValidRange(int)
     */
    public synchronized Boolean hasTrueWindDirectionCharacteristicValidRange(int index) {
        Boolean result = null;
        if (mEnvironmentalSensingService != null) {
            result = mEnvironmentalSensingService.hasTrueWindDirectionCharacteristicValidRange(index);
        }
        return result;
    }

    /**
     * @see #getTrueWindDirection(int)
     */
    @Nullable
    public synchronized Integer getTrueWindDirection() {
        return getTrueWindDirection(0);
    }

    /**
     * @see EnvironmentalSensingService#getTrueWindDirection(int)
     */
    @Nullable
    public synchronized Integer getTrueWindDirection(int index) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.getTrueWindDirection(index);
        }
        return taskId;
    }

    /**
     * @see #startTrueWindDirectionNotification(int)
     */
    @Nullable
    public synchronized Integer startTrueWindDirectionNotification() {
        return startTrueWindDirectionNotification(0);
    }

    /**
     * @see EnvironmentalSensingService#startTrueWindDirectionNotification(int)
     */
    @Nullable
    public synchronized Integer startTrueWindDirectionNotification(int index) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.startTrueWindDirectionNotification(index);
        }
        return taskId;
    }

    /**
     * @see #startTrueWindDirectionNotification(int)
     */
    @Nullable
    public synchronized Integer stopTrueWindDirectionNotification() {
        return stopTrueWindDirectionNotification(0);
    }

    /**
     * @see EnvironmentalSensingService#stopTrueWindDirectionNotification(int)
     */
    @Nullable
    public synchronized Integer stopTrueWindDirectionNotification(int index) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.stopTrueWindDirectionNotification(index);
        }
        return taskId;
    }

    /**
     * @see #getTrueWindDirectionEnvironmentalSensingMeasurement(int)
     */
    @Nullable
    public synchronized Integer getTrueWindDirectionEnvironmentalSensingMeasurement() {
        return getTrueWindDirectionEnvironmentalSensingMeasurement(0);
    }

    /**
     * @see EnvironmentalSensingService#getTrueWindDirectionEnvironmentalSensingMeasurement(int)
     */
    @Nullable
    public synchronized Integer getTrueWindDirectionEnvironmentalSensingMeasurement(int index) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.getTrueWindDirectionEnvironmentalSensingMeasurement(index);
        }
        return taskId;
    }

    /**
     * @see #getTrueWindDirectionEnvironmentalSensingTriggerSetting(int, int)
     */
    @Nullable
    public synchronized Integer getTrueWindDirectionEnvironmentalSensingTriggerSetting() {
        return getTrueWindDirectionEnvironmentalSensingTriggerSetting(0, 0);
    }

    /**
     * @see EnvironmentalSensingService#getTrueWindDirectionEnvironmentalSensingTriggerSetting(int, int)
     */
    @Nullable
    public synchronized Integer getTrueWindDirectionEnvironmentalSensingTriggerSetting(int characteristicIndex, int descriptorIndex) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.getTrueWindDirectionEnvironmentalSensingTriggerSetting(characteristicIndex, descriptorIndex);
        }
        return taskId;
    }

    /**
     * @see #setTrueWindDirectionEnvironmentalSensingTriggerSetting(int, int, EnvironmentalSensingTriggerSetting)
     */
    @Nullable
    public synchronized Integer setTrueWindDirectionEnvironmentalSensingTriggerSetting(@NonNull EnvironmentalSensingTriggerSetting environmentalSensingTriggerSetting) {
        return setTrueWindDirectionEnvironmentalSensingTriggerSetting(0, 0, environmentalSensingTriggerSetting);
    }

    /**
     * @see EnvironmentalSensingService#setTrueWindDirectionEnvironmentalSensingTriggerSetting(int, int, EnvironmentalSensingTriggerSetting)
     */
    @Nullable
    public synchronized Integer setTrueWindDirectionEnvironmentalSensingTriggerSetting(int characteristicIndex, int descriptorIndex, @NonNull EnvironmentalSensingTriggerSetting environmentalSensingTriggerSetting) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.setTrueWindDirectionEnvironmentalSensingTriggerSetting(characteristicIndex, descriptorIndex, environmentalSensingTriggerSetting);
        }
        return taskId;
    }

    /**
     * @see #getTrueWindDirectionEnvironmentalSensingConfiguration(int)
     */
    @Nullable
    public synchronized Integer getTrueWindDirectionEnvironmentalSensingConfiguration() {
        return getTrueWindDirectionEnvironmentalSensingConfiguration(0);
    }

    /**
     * @see EnvironmentalSensingService#getTrueWindDirectionEnvironmentalSensingConfiguration(int)
     */
    @Nullable
    public synchronized Integer getTrueWindDirectionEnvironmentalSensingConfiguration(int index) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.getTrueWindDirectionEnvironmentalSensingConfiguration(index);
        }
        return taskId;
    }

    /**
     * @see #setTrueWindDirectionEnvironmentalSensingConfiguration(int, EnvironmentalSensingConfiguration)
     */
    @Nullable
    public synchronized Integer setTrueWindDirectionEnvironmentalSensingConfiguration(@NonNull EnvironmentalSensingConfiguration environmentalSensingConfiguration) {
        return setTrueWindDirectionEnvironmentalSensingConfiguration(0, environmentalSensingConfiguration);
    }

    /**
     * @see EnvironmentalSensingService#setTrueWindDirectionEnvironmentalSensingConfiguration(int, EnvironmentalSensingConfiguration)
     */
    @Nullable
    public synchronized Integer setTrueWindDirectionEnvironmentalSensingConfiguration(int index, @NonNull EnvironmentalSensingConfiguration environmentalSensingConfiguration) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.setTrueWindDirectionEnvironmentalSensingConfiguration(index, environmentalSensingConfiguration);
        }
        return taskId;
    }

    /**
     * @see #getTrueWindDirectionCharacteristicUserDescription(int)
     */
    @Nullable
    public synchronized Integer getTrueWindDirectionCharacteristicUserDescription() {
        return getTrueWindDirectionCharacteristicUserDescription(0);
    }

    /**
     * @see EnvironmentalSensingService#getTrueWindDirectionCharacteristicUserDescription(int)
     */
    @Nullable
    public synchronized Integer getTrueWindDirectionCharacteristicUserDescription(int index) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.getTrueWindDirectionCharacteristicUserDescription(index);
        }
        return taskId;
    }

    /**
     * @see #setTrueWindDirectionCharacteristicUserDescription(int, CharacteristicUserDescription)
     */
    @Nullable
    public synchronized Integer setTrueWindDirectionCharacteristicUserDescription(@NonNull CharacteristicUserDescription characteristicUserDescription) {
        return setTrueWindDirectionCharacteristicUserDescription(0, characteristicUserDescription);
    }

    /**
     * @see EnvironmentalSensingService#setTrueWindDirectionCharacteristicUserDescription(int, CharacteristicUserDescription)
     */
    @Nullable
    public synchronized Integer setTrueWindDirectionCharacteristicUserDescription(int index, @NonNull CharacteristicUserDescription characteristicUserDescription) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.setTrueWindDirectionCharacteristicUserDescription(index, characteristicUserDescription);
        }
        return taskId;
    }

    /**
     * @see #getTrueWindDirectionValidRange(int)
     */
    @Nullable
    public synchronized Integer getTrueWindDirectionValidRange() {
        return getTrueWindDirectionValidRange(0);
    }

    /**
     * @see EnvironmentalSensingService#getTrueWindDirectionValidRange(int)
     */
    @Nullable
    public synchronized Integer getTrueWindDirectionValidRange(int index) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.getTrueWindDirectionValidRange(index);
        }
        return taskId;
    }

    /**
     * @see EnvironmentalSensingService#getTrueWindSpeedCount()
     */
    @Nullable
    public synchronized Integer getTrueWindSpeedCount() {
        Integer count = null;
        if (mEnvironmentalSensingService != null) {
            count = mEnvironmentalSensingService.getTrueWindSpeedCount();
        }
        return count;
    }

    /**
     * @see #canTrueWindSpeedNotify(int)
     */
    public synchronized Boolean canTrueWindSpeedNotify() {
        return canTrueWindSpeedNotify(0);
    }

    /**
     * @see EnvironmentalSensingService#canTrueWindSpeedNotify(int)
     */
    public synchronized Boolean canTrueWindSpeedNotify(int index) {
        Boolean result = null;
        if (mEnvironmentalSensingService != null) {
            result = mEnvironmentalSensingService.canTrueWindSpeedNotify(index);
        }
        return result;
    }

    /**
     * @see #hasTrueWindSpeedCharacteristicEnvironmentalSensingMeasurement(int)
     */
    public synchronized Boolean hasTrueWindSpeedCharacteristicEnvironmentalSensingMeasurement() {
        return hasTrueWindSpeedCharacteristicEnvironmentalSensingMeasurement(0);
    }

    /**
     * @see EnvironmentalSensingService#hasTrueWindSpeedCharacteristicEnvironmentalSensingMeasurement(int)
     */
    public synchronized Boolean hasTrueWindSpeedCharacteristicEnvironmentalSensingMeasurement(int index) {
        Boolean result = null;
        if (mEnvironmentalSensingService != null) {
            result = mEnvironmentalSensingService.hasTrueWindSpeedCharacteristicEnvironmentalSensingMeasurement(index);
        }
        return result;
    }

    /**
     * @see #getTrueWindSpeedCharacteristicEnvironmentalSensingTriggerSettingCount(int)
     */
    public synchronized Integer getTrueWindSpeedCharacteristicEnvironmentalSensingTriggerSettingCount() {
        return getTrueWindSpeedCharacteristicEnvironmentalSensingTriggerSettingCount(0);
    }

    /**
     * @see EnvironmentalSensingService#getTrueWindSpeedCharacteristicEnvironmentalSensingTriggerSettingCount(int)
     */
    @Nullable
    public synchronized Integer getTrueWindSpeedCharacteristicEnvironmentalSensingTriggerSettingCount(int index) {
        Integer count = null;
        if (mEnvironmentalSensingService != null) {
            count = mEnvironmentalSensingService.getTrueWindSpeedCharacteristicEnvironmentalSensingTriggerSettingCount(index);
        }
        return count;
    }

    /**
     * @see #hasTrueWindSpeedCharacteristicEnvironmentalSensingConfiguration(int)
     */
    public synchronized Boolean hasTrueWindSpeedCharacteristicEnvironmentalSensingConfiguration() {
        return hasTrueWindSpeedCharacteristicEnvironmentalSensingConfiguration(0);
    }

    /**
     * @see EnvironmentalSensingService#hasTrueWindSpeedCharacteristicEnvironmentalSensingConfiguration(int)
     */
    public synchronized Boolean hasTrueWindSpeedCharacteristicEnvironmentalSensingConfiguration(int index) {
        Boolean result = null;
        if (mEnvironmentalSensingService != null) {
            result = mEnvironmentalSensingService.hasTrueWindSpeedCharacteristicEnvironmentalSensingConfiguration(index);
        }
        return result;
    }

    /**
     * @see #hasTrueWindSpeedCharacteristicCharacteristicUserDescription(int)
     */
    public synchronized Boolean hasTrueWindSpeedCharacteristicCharacteristicUserDescription() {
        return hasTrueWindSpeedCharacteristicCharacteristicUserDescription(0);
    }

    /**
     * @see EnvironmentalSensingService#hasTrueWindSpeedCharacteristicCharacteristicUserDescription(int)
     */
    public synchronized Boolean hasTrueWindSpeedCharacteristicCharacteristicUserDescription(int index) {
        Boolean result = null;
        if (mEnvironmentalSensingService != null) {
            result = mEnvironmentalSensingService.hasTrueWindSpeedCharacteristicCharacteristicUserDescription(index);
        }
        return result;
    }

    /**
     * @see #hasTrueWindSpeedCharacteristicValidRange(int)
     */
    public synchronized Boolean hasTrueWindSpeedCharacteristicValidRange() {
        return hasTrueWindSpeedCharacteristicValidRange(0);
    }

    /**
     * @see EnvironmentalSensingService#hasTrueWindSpeedCharacteristicValidRange(int)
     */
    public synchronized Boolean hasTrueWindSpeedCharacteristicValidRange(int index) {
        Boolean result = null;
        if (mEnvironmentalSensingService != null) {
            result = mEnvironmentalSensingService.hasTrueWindSpeedCharacteristicValidRange(index);
        }
        return result;
    }

    /**
     * @see #getTrueWindSpeed(int)
     */
    @Nullable
    public synchronized Integer getTrueWindSpeed() {
        return getTrueWindSpeed(0);
    }

    /**
     * @see EnvironmentalSensingService#getTrueWindSpeed(int)
     */
    @Nullable
    public synchronized Integer getTrueWindSpeed(int index) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.getTrueWindSpeed(index);
        }
        return taskId;
    }

    /**
     * @see #startTrueWindSpeedNotification(int)
     */
    @Nullable
    public synchronized Integer startTrueWindSpeedNotification() {
        return startTrueWindSpeedNotification(0);
    }

    /**
     * @see EnvironmentalSensingService#startTrueWindSpeedNotification(int)
     */
    @Nullable
    public synchronized Integer startTrueWindSpeedNotification(int index) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.startTrueWindSpeedNotification(index);
        }
        return taskId;
    }

    /**
     * @see #startTrueWindSpeedNotification(int)
     */
    @Nullable
    public synchronized Integer stopTrueWindSpeedNotification() {
        return stopTrueWindSpeedNotification(0);
    }

    /**
     * @see EnvironmentalSensingService#stopTrueWindSpeedNotification(int)
     */
    @Nullable
    public synchronized Integer stopTrueWindSpeedNotification(int index) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.stopTrueWindSpeedNotification(index);
        }
        return taskId;
    }

    /**
     * @see #getTrueWindSpeedEnvironmentalSensingMeasurement(int)
     */
    @Nullable
    public synchronized Integer getTrueWindSpeedEnvironmentalSensingMeasurement() {
        return getTrueWindSpeedEnvironmentalSensingMeasurement(0);
    }

    /**
     * @see EnvironmentalSensingService#getTrueWindSpeedEnvironmentalSensingMeasurement(int)
     */
    @Nullable
    public synchronized Integer getTrueWindSpeedEnvironmentalSensingMeasurement(int index) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.getTrueWindSpeedEnvironmentalSensingMeasurement(index);
        }
        return taskId;
    }

    /**
     * @see #getTrueWindSpeedEnvironmentalSensingTriggerSetting(int, int)
     */
    @Nullable
    public synchronized Integer getTrueWindSpeedEnvironmentalSensingTriggerSetting() {
        return getTrueWindSpeedEnvironmentalSensingTriggerSetting(0, 0);
    }

    /**
     * @see EnvironmentalSensingService#getTrueWindSpeedEnvironmentalSensingTriggerSetting(int, int)
     */
    @Nullable
    public synchronized Integer getTrueWindSpeedEnvironmentalSensingTriggerSetting(int characteristicIndex, int descriptorIndex) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.getTrueWindSpeedEnvironmentalSensingTriggerSetting(characteristicIndex, descriptorIndex);
        }
        return taskId;
    }

    /**
     * @see #setTrueWindSpeedEnvironmentalSensingTriggerSetting(int, int, EnvironmentalSensingTriggerSetting)
     */
    @Nullable
    public synchronized Integer setTrueWindSpeedEnvironmentalSensingTriggerSetting(@NonNull EnvironmentalSensingTriggerSetting environmentalSensingTriggerSetting) {
        return setTrueWindSpeedEnvironmentalSensingTriggerSetting(0, 0, environmentalSensingTriggerSetting);
    }

    /**
     * @see EnvironmentalSensingService#setTrueWindSpeedEnvironmentalSensingTriggerSetting(int, int, EnvironmentalSensingTriggerSetting)
     */
    @Nullable
    public synchronized Integer setTrueWindSpeedEnvironmentalSensingTriggerSetting(int characteristicIndex, int descriptorIndex, @NonNull EnvironmentalSensingTriggerSetting environmentalSensingTriggerSetting) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.setTrueWindSpeedEnvironmentalSensingTriggerSetting(characteristicIndex, descriptorIndex, environmentalSensingTriggerSetting);
        }
        return taskId;
    }

    /**
     * @see #getTrueWindSpeedEnvironmentalSensingConfiguration(int)
     */
    @Nullable
    public synchronized Integer getTrueWindSpeedEnvironmentalSensingConfiguration() {
        return getTrueWindSpeedEnvironmentalSensingConfiguration(0);
    }

    /**
     * @see EnvironmentalSensingService#getTrueWindSpeedEnvironmentalSensingConfiguration(int)
     */
    @Nullable
    public synchronized Integer getTrueWindSpeedEnvironmentalSensingConfiguration(int index) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.getTrueWindSpeedEnvironmentalSensingConfiguration(index);
        }
        return taskId;
    }

    /**
     * @see #setTrueWindSpeedEnvironmentalSensingConfiguration(int, EnvironmentalSensingConfiguration)
     */
    @Nullable
    public synchronized Integer setTrueWindSpeedEnvironmentalSensingConfiguration(@NonNull EnvironmentalSensingConfiguration environmentalSensingConfiguration) {
        return setTrueWindSpeedEnvironmentalSensingConfiguration(0, environmentalSensingConfiguration);
    }

    /**
     * @see EnvironmentalSensingService#setTrueWindSpeedEnvironmentalSensingConfiguration(int, EnvironmentalSensingConfiguration)
     */
    @Nullable
    public synchronized Integer setTrueWindSpeedEnvironmentalSensingConfiguration(int index, @NonNull EnvironmentalSensingConfiguration environmentalSensingConfiguration) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.setTrueWindSpeedEnvironmentalSensingConfiguration(index, environmentalSensingConfiguration);
        }
        return taskId;
    }

    /**
     * @see #getTrueWindSpeedCharacteristicUserDescription(int)
     */
    @Nullable
    public synchronized Integer getTrueWindSpeedCharacteristicUserDescription() {
        return getTrueWindSpeedCharacteristicUserDescription(0);
    }

    /**
     * @see EnvironmentalSensingService#getTrueWindSpeedCharacteristicUserDescription(int)
     */
    @Nullable
    public synchronized Integer getTrueWindSpeedCharacteristicUserDescription(int index) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.getTrueWindSpeedCharacteristicUserDescription(index);
        }
        return taskId;
    }

    /**
     * @see #setTrueWindSpeedCharacteristicUserDescription(int, CharacteristicUserDescription)
     */
    @Nullable
    public synchronized Integer setTrueWindSpeedCharacteristicUserDescription(@NonNull CharacteristicUserDescription characteristicUserDescription) {
        return setTrueWindSpeedCharacteristicUserDescription(0, characteristicUserDescription);
    }

    /**
     * @see EnvironmentalSensingService#setTrueWindSpeedCharacteristicUserDescription(int, CharacteristicUserDescription)
     */
    @Nullable
    public synchronized Integer setTrueWindSpeedCharacteristicUserDescription(int index, @NonNull CharacteristicUserDescription characteristicUserDescription) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.setTrueWindSpeedCharacteristicUserDescription(index, characteristicUserDescription);
        }
        return taskId;
    }

    /**
     * @see #getTrueWindSpeedValidRange(int)
     */
    @Nullable
    public synchronized Integer getTrueWindSpeedValidRange() {
        return getTrueWindSpeedValidRange(0);
    }

    /**
     * @see EnvironmentalSensingService#getTrueWindSpeedValidRange(int)
     */
    @Nullable
    public synchronized Integer getTrueWindSpeedValidRange(int index) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.getTrueWindSpeedValidRange(index);
        }
        return taskId;
    }

    /**
     * @see EnvironmentalSensingService#getUVIndexCount()
     */
    @Nullable
    public synchronized Integer getUVIndexCount() {
        Integer count = null;
        if (mEnvironmentalSensingService != null) {
            count = mEnvironmentalSensingService.getUVIndexCount();
        }
        return count;
    }

    /**
     * @see #canUVIndexNotify(int)
     */
    public synchronized Boolean canUVIndexNotify() {
        return canUVIndexNotify(0);
    }

    /**
     * @see EnvironmentalSensingService#canUVIndexNotify(int)
     */
    public synchronized Boolean canUVIndexNotify(int index) {
        Boolean result = null;
        if (mEnvironmentalSensingService != null) {
            result = mEnvironmentalSensingService.canUVIndexNotify(index);
        }
        return result;
    }

    /**
     * @see #hasUVIndexCharacteristicEnvironmentalSensingMeasurement(int)
     */
    public synchronized Boolean hasUVIndexCharacteristicEnvironmentalSensingMeasurement() {
        return hasUVIndexCharacteristicEnvironmentalSensingMeasurement(0);
    }

    /**
     * @see EnvironmentalSensingService#hasUVIndexCharacteristicEnvironmentalSensingMeasurement(int)
     */
    public synchronized Boolean hasUVIndexCharacteristicEnvironmentalSensingMeasurement(int index) {
        Boolean result = null;
        if (mEnvironmentalSensingService != null) {
            result = mEnvironmentalSensingService.hasUVIndexCharacteristicEnvironmentalSensingMeasurement(index);
        }
        return result;
    }

    /**
     * @see #getUVIndexCharacteristicEnvironmentalSensingTriggerSettingCount(int)
     */
    public synchronized Integer getUVIndexCharacteristicEnvironmentalSensingTriggerSettingCount() {
        return getUVIndexCharacteristicEnvironmentalSensingTriggerSettingCount(0);
    }

    /**
     * @see EnvironmentalSensingService#getUVIndexCharacteristicEnvironmentalSensingTriggerSettingCount(int)
     */
    @Nullable
    public synchronized Integer getUVIndexCharacteristicEnvironmentalSensingTriggerSettingCount(int index) {
        Integer count = null;
        if (mEnvironmentalSensingService != null) {
            count = mEnvironmentalSensingService.getUVIndexCharacteristicEnvironmentalSensingTriggerSettingCount(index);
        }
        return count;
    }

    /**
     * @see #hasUVIndexCharacteristicEnvironmentalSensingConfiguration(int)
     */
    public synchronized Boolean hasUVIndexCharacteristicEnvironmentalSensingConfiguration() {
        return hasUVIndexCharacteristicEnvironmentalSensingConfiguration(0);
    }

    /**
     * @see EnvironmentalSensingService#hasUVIndexCharacteristicEnvironmentalSensingConfiguration(int)
     */
    public synchronized Boolean hasUVIndexCharacteristicEnvironmentalSensingConfiguration(int index) {
        Boolean result = null;
        if (mEnvironmentalSensingService != null) {
            result = mEnvironmentalSensingService.hasUVIndexCharacteristicEnvironmentalSensingConfiguration(index);
        }
        return result;
    }

    /**
     * @see #hasUVIndexCharacteristicCharacteristicUserDescription(int)
     */
    public synchronized Boolean hasUVIndexCharacteristicCharacteristicUserDescription() {
        return hasUVIndexCharacteristicCharacteristicUserDescription(0);
    }

    /**
     * @see EnvironmentalSensingService#hasUVIndexCharacteristicCharacteristicUserDescription(int)
     */
    public synchronized Boolean hasUVIndexCharacteristicCharacteristicUserDescription(int index) {
        Boolean result = null;
        if (mEnvironmentalSensingService != null) {
            result = mEnvironmentalSensingService.hasUVIndexCharacteristicCharacteristicUserDescription(index);
        }
        return result;
    }

    /**
     * @see #hasUVIndexCharacteristicValidRange(int)
     */
    public synchronized Boolean hasUVIndexCharacteristicValidRange() {
        return hasUVIndexCharacteristicValidRange(0);
    }

    /**
     * @see EnvironmentalSensingService#hasUVIndexCharacteristicValidRange(int)
     */
    public synchronized Boolean hasUVIndexCharacteristicValidRange(int index) {
        Boolean result = null;
        if (mEnvironmentalSensingService != null) {
            result = mEnvironmentalSensingService.hasUVIndexCharacteristicValidRange(index);
        }
        return result;
    }

    /**
     * @see #getUVIndex(int)
     */
    @Nullable
    public synchronized Integer getUVIndex() {
        return getUVIndex(0);
    }

    /**
     * @see EnvironmentalSensingService#getUVIndex(int)
     */
    @Nullable
    public synchronized Integer getUVIndex(int index) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.getUVIndex(index);
        }
        return taskId;
    }

    /**
     * @see #startUVIndexNotification(int)
     */
    @Nullable
    public synchronized Integer startUVIndexNotification() {
        return startUVIndexNotification(0);
    }

    /**
     * @see EnvironmentalSensingService#startUVIndexNotification(int)
     */
    @Nullable
    public synchronized Integer startUVIndexNotification(int index) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.startUVIndexNotification(index);
        }
        return taskId;
    }

    /**
     * @see #startUVIndexNotification(int)
     */
    @Nullable
    public synchronized Integer stopUVIndexNotification() {
        return stopUVIndexNotification(0);
    }

    /**
     * @see EnvironmentalSensingService#stopUVIndexNotification(int)
     */
    @Nullable
    public synchronized Integer stopUVIndexNotification(int index) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.stopUVIndexNotification(index);
        }
        return taskId;
    }

    /**
     * @see #getUVIndexEnvironmentalSensingMeasurement(int)
     */
    @Nullable
    public synchronized Integer getUVIndexEnvironmentalSensingMeasurement() {
        return getUVIndexEnvironmentalSensingMeasurement(0);
    }

    /**
     * @see EnvironmentalSensingService#getUVIndexEnvironmentalSensingMeasurement(int)
     */
    @Nullable
    public synchronized Integer getUVIndexEnvironmentalSensingMeasurement(int index) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.getUVIndexEnvironmentalSensingMeasurement(index);
        }
        return taskId;
    }

    /**
     * @see #getUVIndexEnvironmentalSensingTriggerSetting(int, int)
     */
    @Nullable
    public synchronized Integer getUVIndexEnvironmentalSensingTriggerSetting() {
        return getUVIndexEnvironmentalSensingTriggerSetting(0, 0);
    }

    /**
     * @see EnvironmentalSensingService#getUVIndexEnvironmentalSensingTriggerSetting(int, int)
     */
    @Nullable
    public synchronized Integer getUVIndexEnvironmentalSensingTriggerSetting(int characteristicIndex, int descriptorIndex) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.getUVIndexEnvironmentalSensingTriggerSetting(characteristicIndex, descriptorIndex);
        }
        return taskId;
    }

    /**
     * @see #setUVIndexEnvironmentalSensingTriggerSetting(int, int, EnvironmentalSensingTriggerSetting)
     */
    @Nullable
    public synchronized Integer setUVIndexEnvironmentalSensingTriggerSetting(@NonNull EnvironmentalSensingTriggerSetting environmentalSensingTriggerSetting) {
        return setUVIndexEnvironmentalSensingTriggerSetting(0, 0, environmentalSensingTriggerSetting);
    }

    /**
     * @see EnvironmentalSensingService#setUVIndexEnvironmentalSensingTriggerSetting(int, int, EnvironmentalSensingTriggerSetting)
     */
    @Nullable
    public synchronized Integer setUVIndexEnvironmentalSensingTriggerSetting(int characteristicIndex, int descriptorIndex, @NonNull EnvironmentalSensingTriggerSetting environmentalSensingTriggerSetting) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.setUVIndexEnvironmentalSensingTriggerSetting(characteristicIndex, descriptorIndex, environmentalSensingTriggerSetting);
        }
        return taskId;
    }

    /**
     * @see #getUVIndexEnvironmentalSensingConfiguration(int)
     */
    @Nullable
    public synchronized Integer getUVIndexEnvironmentalSensingConfiguration() {
        return getUVIndexEnvironmentalSensingConfiguration(0);
    }

    /**
     * @see EnvironmentalSensingService#getUVIndexEnvironmentalSensingConfiguration(int)
     */
    @Nullable
    public synchronized Integer getUVIndexEnvironmentalSensingConfiguration(int index) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.getUVIndexEnvironmentalSensingConfiguration(index);
        }
        return taskId;
    }

    /**
     * @see #setUVIndexEnvironmentalSensingConfiguration(int, EnvironmentalSensingConfiguration)
     */
    @Nullable
    public synchronized Integer setUVIndexEnvironmentalSensingConfiguration(@NonNull EnvironmentalSensingConfiguration environmentalSensingConfiguration) {
        return setUVIndexEnvironmentalSensingConfiguration(0, environmentalSensingConfiguration);
    }

    /**
     * @see EnvironmentalSensingService#setUVIndexEnvironmentalSensingConfiguration(int, EnvironmentalSensingConfiguration)
     */
    @Nullable
    public synchronized Integer setUVIndexEnvironmentalSensingConfiguration(int index, @NonNull EnvironmentalSensingConfiguration environmentalSensingConfiguration) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.setUVIndexEnvironmentalSensingConfiguration(index, environmentalSensingConfiguration);
        }
        return taskId;
    }

    /**
     * @see #getUVIndexCharacteristicUserDescription(int)
     */
    @Nullable
    public synchronized Integer getUVIndexCharacteristicUserDescription() {
        return getUVIndexCharacteristicUserDescription(0);
    }

    /**
     * @see EnvironmentalSensingService#getUVIndexCharacteristicUserDescription(int)
     */
    @Nullable
    public synchronized Integer getUVIndexCharacteristicUserDescription(int index) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.getUVIndexCharacteristicUserDescription(index);
        }
        return taskId;
    }

    /**
     * @see #setUVIndexCharacteristicUserDescription(int, CharacteristicUserDescription)
     */
    @Nullable
    public synchronized Integer setUVIndexCharacteristicUserDescription(@NonNull CharacteristicUserDescription characteristicUserDescription) {
        return setUVIndexCharacteristicUserDescription(0, characteristicUserDescription);
    }

    /**
     * @see EnvironmentalSensingService#setUVIndexCharacteristicUserDescription(int, CharacteristicUserDescription)
     */
    @Nullable
    public synchronized Integer setUVIndexCharacteristicUserDescription(int index, @NonNull CharacteristicUserDescription characteristicUserDescription) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.setUVIndexCharacteristicUserDescription(index, characteristicUserDescription);
        }
        return taskId;
    }

    /**
     * @see #getUVIndexValidRange(int)
     */
    @Nullable
    public synchronized Integer getUVIndexValidRange() {
        return getUVIndexValidRange(0);
    }

    /**
     * @see EnvironmentalSensingService#getUVIndexValidRange(int)
     */
    @Nullable
    public synchronized Integer getUVIndexValidRange(int index) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.getUVIndexValidRange(index);
        }
        return taskId;
    }

    /**
     * @see EnvironmentalSensingService#getWindChillCount()
     */
    @Nullable
    public synchronized Integer getWindChillCount() {
        Integer count = null;
        if (mEnvironmentalSensingService != null) {
            count = mEnvironmentalSensingService.getWindChillCount();
        }
        return count;
    }

    /**
     * @see #canWindChillNotify(int)
     */
    public synchronized Boolean canWindChillNotify() {
        return canWindChillNotify(0);
    }

    /**
     * @see EnvironmentalSensingService#canWindChillNotify(int)
     */
    public synchronized Boolean canWindChillNotify(int index) {
        Boolean result = null;
        if (mEnvironmentalSensingService != null) {
            result = mEnvironmentalSensingService.canWindChillNotify(index);
        }
        return result;
    }

    /**
     * @see #hasWindChillCharacteristicEnvironmentalSensingMeasurement(int)
     */
    public synchronized Boolean hasWindChillCharacteristicEnvironmentalSensingMeasurement() {
        return hasWindChillCharacteristicEnvironmentalSensingMeasurement(0);
    }

    /**
     * @see EnvironmentalSensingService#hasWindChillCharacteristicEnvironmentalSensingMeasurement(int)
     */
    public synchronized Boolean hasWindChillCharacteristicEnvironmentalSensingMeasurement(int index) {
        Boolean result = null;
        if (mEnvironmentalSensingService != null) {
            result = mEnvironmentalSensingService.hasWindChillCharacteristicEnvironmentalSensingMeasurement(index);
        }
        return result;
    }

    /**
     * @see #getWindChillCharacteristicEnvironmentalSensingTriggerSettingCount(int)
     */
    public synchronized Integer getWindChillCharacteristicEnvironmentalSensingTriggerSettingCount() {
        return getWindChillCharacteristicEnvironmentalSensingTriggerSettingCount(0);
    }

    /**
     * @see EnvironmentalSensingService#getWindChillCharacteristicEnvironmentalSensingTriggerSettingCount(int)
     */
    @Nullable
    public synchronized Integer getWindChillCharacteristicEnvironmentalSensingTriggerSettingCount(int index) {
        Integer count = null;
        if (mEnvironmentalSensingService != null) {
            count = mEnvironmentalSensingService.getWindChillCharacteristicEnvironmentalSensingTriggerSettingCount(index);
        }
        return count;
    }

    /**
     * @see #hasWindChillCharacteristicEnvironmentalSensingConfiguration(int)
     */
    public synchronized Boolean hasWindChillCharacteristicEnvironmentalSensingConfiguration() {
        return hasWindChillCharacteristicEnvironmentalSensingConfiguration(0);
    }

    /**
     * @see EnvironmentalSensingService#hasWindChillCharacteristicEnvironmentalSensingConfiguration(int)
     */
    public synchronized Boolean hasWindChillCharacteristicEnvironmentalSensingConfiguration(int index) {
        Boolean result = null;
        if (mEnvironmentalSensingService != null) {
            result = mEnvironmentalSensingService.hasWindChillCharacteristicEnvironmentalSensingConfiguration(index);
        }
        return result;
    }

    /**
     * @see #hasWindChillCharacteristicCharacteristicUserDescription(int)
     */
    public synchronized Boolean hasWindChillCharacteristicCharacteristicUserDescription() {
        return hasWindChillCharacteristicCharacteristicUserDescription(0);
    }

    /**
     * @see EnvironmentalSensingService#hasWindChillCharacteristicCharacteristicUserDescription(int)
     */
    public synchronized Boolean hasWindChillCharacteristicCharacteristicUserDescription(int index) {
        Boolean result = null;
        if (mEnvironmentalSensingService != null) {
            result = mEnvironmentalSensingService.hasWindChillCharacteristicCharacteristicUserDescription(index);
        }
        return result;
    }

    /**
     * @see #hasWindChillCharacteristicValidRange(int)
     */
    public synchronized Boolean hasWindChillCharacteristicValidRange() {
        return hasWindChillCharacteristicValidRange(0);
    }

    /**
     * @see EnvironmentalSensingService#hasWindChillCharacteristicValidRange(int)
     */
    public synchronized Boolean hasWindChillCharacteristicValidRange(int index) {
        Boolean result = null;
        if (mEnvironmentalSensingService != null) {
            result = mEnvironmentalSensingService.hasWindChillCharacteristicValidRange(index);
        }
        return result;
    }

    /**
     * @see #getWindChill(int)
     */
    @Nullable
    public synchronized Integer getWindChill() {
        return getWindChill(0);
    }

    /**
     * @see EnvironmentalSensingService#getWindChill(int)
     */
    @Nullable
    public synchronized Integer getWindChill(int index) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.getWindChill(index);
        }
        return taskId;
    }

    /**
     * @see #startWindChillNotification(int)
     */
    @Nullable
    public synchronized Integer startWindChillNotification() {
        return startWindChillNotification(0);
    }

    /**
     * @see EnvironmentalSensingService#startWindChillNotification(int)
     */
    @Nullable
    public synchronized Integer startWindChillNotification(int index) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.startWindChillNotification(index);
        }
        return taskId;
    }

    /**
     * @see #startWindChillNotification(int)
     */
    @Nullable
    public synchronized Integer stopWindChillNotification() {
        return stopWindChillNotification(0);
    }

    /**
     * @see EnvironmentalSensingService#stopWindChillNotification(int)
     */
    @Nullable
    public synchronized Integer stopWindChillNotification(int index) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.stopWindChillNotification(index);
        }
        return taskId;
    }

    /**
     * @see #getWindChillEnvironmentalSensingMeasurement(int)
     */
    @Nullable
    public synchronized Integer getWindChillEnvironmentalSensingMeasurement() {
        return getWindChillEnvironmentalSensingMeasurement(0);
    }

    /**
     * @see EnvironmentalSensingService#getWindChillEnvironmentalSensingMeasurement(int)
     */
    @Nullable
    public synchronized Integer getWindChillEnvironmentalSensingMeasurement(int index) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.getWindChillEnvironmentalSensingMeasurement(index);
        }
        return taskId;
    }

    /**
     * @see #getWindChillEnvironmentalSensingTriggerSetting(int, int)
     */
    @Nullable
    public synchronized Integer getWindChillEnvironmentalSensingTriggerSetting() {
        return getWindChillEnvironmentalSensingTriggerSetting(0, 0);
    }

    /**
     * @see EnvironmentalSensingService#getWindChillEnvironmentalSensingTriggerSetting(int, int)
     */
    @Nullable
    public synchronized Integer getWindChillEnvironmentalSensingTriggerSetting(int characteristicIndex, int descriptorIndex) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.getWindChillEnvironmentalSensingTriggerSetting(characteristicIndex, descriptorIndex);
        }
        return taskId;
    }

    /**
     * @see #setWindChillEnvironmentalSensingTriggerSetting(int, int, EnvironmentalSensingTriggerSetting)
     */
    @Nullable
    public synchronized Integer setWindChillEnvironmentalSensingTriggerSetting(@NonNull EnvironmentalSensingTriggerSetting environmentalSensingTriggerSetting) {
        return setWindChillEnvironmentalSensingTriggerSetting(0, 0, environmentalSensingTriggerSetting);
    }

    /**
     * @see EnvironmentalSensingService#setWindChillEnvironmentalSensingTriggerSetting(int, int, EnvironmentalSensingTriggerSetting)
     */
    @Nullable
    public synchronized Integer setWindChillEnvironmentalSensingTriggerSetting(int characteristicIndex, int descriptorIndex, @NonNull EnvironmentalSensingTriggerSetting environmentalSensingTriggerSetting) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.setWindChillEnvironmentalSensingTriggerSetting(characteristicIndex, descriptorIndex, environmentalSensingTriggerSetting);
        }
        return taskId;
    }

    /**
     * @see #getWindChillEnvironmentalSensingConfiguration(int)
     */
    @Nullable
    public synchronized Integer getWindChillEnvironmentalSensingConfiguration() {
        return getWindChillEnvironmentalSensingConfiguration(0);
    }

    /**
     * @see EnvironmentalSensingService#getWindChillEnvironmentalSensingConfiguration(int)
     */
    @Nullable
    public synchronized Integer getWindChillEnvironmentalSensingConfiguration(int index) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.getWindChillEnvironmentalSensingConfiguration(index);
        }
        return taskId;
    }

    /**
     * @see #setWindChillEnvironmentalSensingConfiguration(int, EnvironmentalSensingConfiguration)
     */
    @Nullable
    public synchronized Integer setWindChillEnvironmentalSensingConfiguration(@NonNull EnvironmentalSensingConfiguration environmentalSensingConfiguration) {
        return setWindChillEnvironmentalSensingConfiguration(0, environmentalSensingConfiguration);
    }

    /**
     * @see EnvironmentalSensingService#setWindChillEnvironmentalSensingConfiguration(int, EnvironmentalSensingConfiguration)
     */
    @Nullable
    public synchronized Integer setWindChillEnvironmentalSensingConfiguration(int index, @NonNull EnvironmentalSensingConfiguration environmentalSensingConfiguration) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.setWindChillEnvironmentalSensingConfiguration(index, environmentalSensingConfiguration);
        }
        return taskId;
    }

    /**
     * @see #getWindChillCharacteristicUserDescription(int)
     */
    @Nullable
    public synchronized Integer getWindChillCharacteristicUserDescription() {
        return getWindChillCharacteristicUserDescription(0);
    }

    /**
     * @see EnvironmentalSensingService#getWindChillCharacteristicUserDescription(int)
     */
    @Nullable
    public synchronized Integer getWindChillCharacteristicUserDescription(int index) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.getWindChillCharacteristicUserDescription(index);
        }
        return taskId;
    }

    /**
     * @see #setWindChillCharacteristicUserDescription(int, CharacteristicUserDescription)
     */
    @Nullable
    public synchronized Integer setWindChillCharacteristicUserDescription(@NonNull CharacteristicUserDescription characteristicUserDescription) {
        return setWindChillCharacteristicUserDescription(0, characteristicUserDescription);
    }

    /**
     * @see EnvironmentalSensingService#setWindChillCharacteristicUserDescription(int, CharacteristicUserDescription)
     */
    @Nullable
    public synchronized Integer setWindChillCharacteristicUserDescription(int index, @NonNull CharacteristicUserDescription characteristicUserDescription) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.setWindChillCharacteristicUserDescription(index, characteristicUserDescription);
        }
        return taskId;
    }

    /**
     * @see #getWindChillValidRange(int)
     */
    @Nullable
    public synchronized Integer getWindChillValidRange() {
        return getWindChillValidRange(0);
    }

    /**
     * @see EnvironmentalSensingService#getWindChillValidRange(int)
     */
    @Nullable
    public synchronized Integer getWindChillValidRange(int index) {
        Integer taskId = null;
        if (mEnvironmentalSensingService != null) {
            taskId = mEnvironmentalSensingService.getWindChillValidRange(index);
        }
        return taskId;
    }

    /**
     * @see DeviceInformationService#hasManufacturerNameString()
     */
    @Nullable
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
    @Nullable
    public synchronized Boolean hasModelNumberString() {
        Boolean result = null;
        if (mDeviceInformationService != null) {
            result = mDeviceInformationService.hasModelNumberString();
        }
        return result;
    }

    /**
     * @see DeviceInformationService#getManufacturerNameString()
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
     * @see DeviceInformationService#getModelNumberString()
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
     * get available Battery Service count
     *
     * @return available Battery Service count. if {@code null} returned, profile is not ready or no Battery Service
     * @see BatteryService#getBatteryLevelCount()
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
     * get Battery Level
     *
     * @param index Battery Service index
     * @return task id. if {@code null} returned, profile is not ready, index is out of range or no Battery Service
     * @see BatteryService#getBatteryLevel(int)
     */
    @Nullable
    public synchronized Integer getBatteryLevel(int index) {
        Integer batteryLevel = null;
        if (mBatteryService != null) {
            batteryLevel = mBatteryService.getBatteryLevel(index);
        }
        return batteryLevel;
    }

    /**
     * @see #canBatteryLevelNotify(int)
     */
    public synchronized Boolean canBatteryLevelNotify() {
        return canBatteryLevelNotify(0);
    }

    /**
     * get Battery Level's notify status
     *
     * @param index Battery Service index
     * @return {@code true}:target Battery Service can notify, {@code false}:can not notify. if {@code null} returned, profile is not ready or no Battery Service
     * @see BatteryService#canBatteryLevelNotify(int)
     */
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
     * get Battery Level's Characteristic Presentation Format
     *
     * @param index Battery Service index
     * @return task id. if {@code null} returned, service is not ready or index is out of range. if {@code null} returned, profile is not ready or no Battery Service
     * @see BatteryService#getBatteryLevelCharacteristicPresentationFormat(int)
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
     * get Battery Level's Client Characteristic Configuration
     *
     * @param index Battery Service index
     * @return task id. if {@code null} returned, service is not ready or index is out of range. if {@code null} returned, profile is not ready or no Battery Service
     * @see BatteryService#getBatteryLevelClientCharacteristicConfiguration(int)
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
     * start Battery Level's notification
     *
     * @param index Battery Service index
     * @return task id. if {@code null} returned, service is not ready or index is out of range. if {@code null} returned, profile is not ready or no Battery Service
     * @see BatteryService#startBatteryLevelNotification(int)
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
     * stop Battery Level's notification
     *
     * @param index Battery Service index
     * @return task id. if {@code null} returned, service is not ready or index is out of range. if {@code null} returned, profile is not ready or no Battery Service
     * @see BatteryService#stopBatteryLevelNotification(int)
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
     * {@inheritDoc}
     */
    @Override
    public BondedDeviceDatabaseHelper getDatabaseHelper() {
        return EnvironmentalSensingProfileBondedDatabaseHelper.getInstance(mContext);
    }

    /**
     * create {@link EnvironmentalSensingService}, {@link DeviceInformationService} and {@link BatteryService}
     *
     * @see #connect(BluetoothDevice)
     */
    @Override
    public synchronized void createServices() {
        super.createServices();
        if (mEnvironmentalSensingService == null) {
            mEnvironmentalSensingService = new EnvironmentalSensingService(mBLEConnection, mEnvironmentalSensingProfileCallback, null);
        }
        if (mDeviceInformationService == null) {
            mDeviceInformationService = new DeviceInformationService(mBLEConnection, mEnvironmentalSensingProfileCallback, null);
        }
        if (mBatteryService == null) {
            mBatteryService = new BatteryService(mBLEConnection, mEnvironmentalSensingProfileCallback, null);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void quit() {
        super.quit();
        mEnvironmentalSensingService = null;
        mDeviceInformationService = null;
        mBatteryService = null;
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
                if (DEVICE_INFORMATION_SERVICE.equals(bluetoothGattService.getUuid())) {
                    mHasDeviceInformationService = true;
                } else if (BATTERY_SERVICE.equals(bluetoothGattService.getUuid())) {
                    mHasBatteryService = true;
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
        return new EnvironmentalSensingProfileScanCallback(this, null);
    }

    /**
     * {@inheritDoc}
     */
    @NonNull
    @Override
    protected FilteredLeScanCallback createFilteredLeScanCallback() {
        return new EnvironmentalSensingProfileLeScanCallback(this, null);
    }

}
