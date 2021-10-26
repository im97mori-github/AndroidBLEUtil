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
     * {@link org.im97mori.ble.service.ess.central.EnvironmentalSensingService} instance
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
     * @see #isApparentWindDirectionNotificatable(int)
     */
    public synchronized Boolean isApparentWindDirectionNotificatable() {
        return isApparentWindDirectionNotificatable(0);
    }

    /**
     * @see EnvironmentalSensingService#isApparentWindDirectionNotificatable(int)
     */
    public synchronized Boolean isApparentWindDirectionNotificatable(int index) {
        Boolean result = null;
        if (mEnvironmentalSensingService != null) {
            result = mEnvironmentalSensingService.isApparentWindDirectionNotificatable(index);
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
     * @see #isApparentWindSpeedNotificatable(int)
     */
    public synchronized Boolean isApparentWindSpeedNotificatable() {
        return isApparentWindSpeedNotificatable(0);
    }

    /**
     * @see EnvironmentalSensingService#isApparentWindSpeedNotificatable(int)
     */
    public synchronized Boolean isApparentWindSpeedNotificatable(int index) {
        Boolean result = null;
        if (mEnvironmentalSensingService != null) {
            result = mEnvironmentalSensingService.isApparentWindSpeedNotificatable(index);
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
     * @see #isDewPointNotificatable(int)
     */
    public synchronized Boolean isDewPointNotificatable() {
        return isDewPointNotificatable(0);
    }

    /**
     * @see EnvironmentalSensingService#isDewPointNotificatable(int)
     */
    public synchronized Boolean isDewPointNotificatable(int index) {
        Boolean result = null;
        if (mEnvironmentalSensingService != null) {
            result = mEnvironmentalSensingService.isDewPointNotificatable(index);
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
     * @see #isElevationNotificatable(int)
     */
    public synchronized Boolean isElevationNotificatable() {
        return isElevationNotificatable(0);
    }

    /**
     * @see EnvironmentalSensingService#isElevationNotificatable(int)
     */
    public synchronized Boolean isElevationNotificatable(int index) {
        Boolean result = null;
        if (mEnvironmentalSensingService != null) {
            result = mEnvironmentalSensingService.isElevationNotificatable(index);
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
     * @see #isGustFactorNotificatable(int)
     */
    public synchronized Boolean isGustFactorNotificatable() {
        return isGustFactorNotificatable(0);
    }

    /**
     * @see EnvironmentalSensingService#isGustFactorNotificatable(int)
     */
    public synchronized Boolean isGustFactorNotificatable(int index) {
        Boolean result = null;
        if (mEnvironmentalSensingService != null) {
            result = mEnvironmentalSensingService.isGustFactorNotificatable(index);
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
     * @see #isHeatIndexNotificatable(int)
     */
    public synchronized Boolean isHeatIndexNotificatable() {
        return isHeatIndexNotificatable(0);
    }

    /**
     * @see EnvironmentalSensingService#isHeatIndexNotificatable(int)
     */
    public synchronized Boolean isHeatIndexNotificatable(int index) {
        Boolean result = null;
        if (mEnvironmentalSensingService != null) {
            result = mEnvironmentalSensingService.isHeatIndexNotificatable(index);
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
     * @see #isHumidityNotificatable(int)
     */
    public synchronized Boolean isHumidityNotificatable() {
        return isHumidityNotificatable(0);
    }

    /**
     * @see EnvironmentalSensingService#isHumidityNotificatable(int)
     */
    public synchronized Boolean isHumidityNotificatable(int index) {
        Boolean result = null;
        if (mEnvironmentalSensingService != null) {
            result = mEnvironmentalSensingService.isHumidityNotificatable(index);
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
     * @see #isIrradianceNotificatable(int)
     */
    public synchronized Boolean isIrradianceNotificatable() {
        return isIrradianceNotificatable(0);
    }

    /**
     * @see EnvironmentalSensingService#isIrradianceNotificatable(int)
     */
    public synchronized Boolean isIrradianceNotificatable(int index) {
        Boolean result = null;
        if (mEnvironmentalSensingService != null) {
            result = mEnvironmentalSensingService.isIrradianceNotificatable(index);
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
     * @see #isPollenConcentrationNotificatable(int)
     */
    public synchronized Boolean isPollenConcentrationNotificatable() {
        return isPollenConcentrationNotificatable(0);
    }

    /**
     * @see EnvironmentalSensingService#isPollenConcentrationNotificatable(int)
     */
    public synchronized Boolean isPollenConcentrationNotificatable(int index) {
        Boolean result = null;
        if (mEnvironmentalSensingService != null) {
            result = mEnvironmentalSensingService.isPollenConcentrationNotificatable(index);
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
     * @see #isRainfallNotificatable(int)
     */
    public synchronized Boolean isRainfallNotificatable() {
        return isRainfallNotificatable(0);
    }

    /**
     * @see EnvironmentalSensingService#isRainfallNotificatable(int)
     */
    public synchronized Boolean isRainfallNotificatable(int index) {
        Boolean result = null;
        if (mEnvironmentalSensingService != null) {
            result = mEnvironmentalSensingService.isRainfallNotificatable(index);
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
     * @see #isPressureNotificatable(int)
     */
    public synchronized Boolean isPressureNotificatable() {
        return isPressureNotificatable(0);
    }

    /**
     * @see EnvironmentalSensingService#isPressureNotificatable(int)
     */
    public synchronized Boolean isPressureNotificatable(int index) {
        Boolean result = null;
        if (mEnvironmentalSensingService != null) {
            result = mEnvironmentalSensingService.isPressureNotificatable(index);
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
     * @see #isTemperatureNotificatable(int)
     */
    public synchronized Boolean isTemperatureNotificatable() {
        return isTemperatureNotificatable(0);
    }

    /**
     * @see EnvironmentalSensingService#isTemperatureNotificatable(int)
     */
    public synchronized Boolean isTemperatureNotificatable(int index) {
        Boolean result = null;
        if (mEnvironmentalSensingService != null) {
            result = mEnvironmentalSensingService.isTemperatureNotificatable(index);
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
     * @see #isTrueWindDirectionNotificatable(int)
     */
    public synchronized Boolean isTrueWindDirectionNotificatable() {
        return isTrueWindDirectionNotificatable(0);
    }

    /**
     * @see EnvironmentalSensingService#isTrueWindDirectionNotificatable(int)
     */
    public synchronized Boolean isTrueWindDirectionNotificatable(int index) {
        Boolean result = null;
        if (mEnvironmentalSensingService != null) {
            result = mEnvironmentalSensingService.isTrueWindDirectionNotificatable(index);
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
     * @see #isTrueWindSpeedNotificatable(int)
     */
    public synchronized Boolean isTrueWindSpeedNotificatable() {
        return isTrueWindSpeedNotificatable(0);
    }

    /**
     * @see EnvironmentalSensingService#isTrueWindSpeedNotificatable(int)
     */
    public synchronized Boolean isTrueWindSpeedNotificatable(int index) {
        Boolean result = null;
        if (mEnvironmentalSensingService != null) {
            result = mEnvironmentalSensingService.isTrueWindSpeedNotificatable(index);
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
     * @see #isUVIndexNotificatable(int)
     */
    public synchronized Boolean isUVIndexNotificatable() {
        return isUVIndexNotificatable(0);
    }

    /**
     * @see EnvironmentalSensingService#isUVIndexNotificatable(int)
     */
    public synchronized Boolean isUVIndexNotificatable(int index) {
        Boolean result = null;
        if (mEnvironmentalSensingService != null) {
            result = mEnvironmentalSensingService.isUVIndexNotificatable(index);
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
     * @see #isWindChillNotificatable(int)
     */
    public synchronized Boolean isWindChillNotificatable() {
        return isWindChillNotificatable(0);
    }

    /**
     * @see EnvironmentalSensingService#isWindChillNotificatable(int)
     */
    public synchronized Boolean isWindChillNotificatable(int index) {
        Boolean result = null;
        if (mEnvironmentalSensingService != null) {
            result = mEnvironmentalSensingService.isWindChillNotificatable(index);
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
     * @see #isBarometricPressureTrendNotificatable(int)
     */
    public synchronized Boolean isBarometricPressureTrendNotificatable() {
        return isBarometricPressureTrendNotificatable(0);
    }

    /**
     * @see EnvironmentalSensingService#isBarometricPressureTrendNotificatable(int)
     */
    public synchronized Boolean isBarometricPressureTrendNotificatable(int index) {
        Boolean result = null;
        if (mEnvironmentalSensingService != null) {
            result = mEnvironmentalSensingService.isBarometricPressureTrendNotificatable(index);
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
     * @see #isMagneticDeclinationNotificatable(int)
     */
    public synchronized Boolean isMagneticDeclinationNotificatable() {
        return isMagneticDeclinationNotificatable(0);
    }

    /**
     * @see EnvironmentalSensingService#isMagneticDeclinationNotificatable(int)
     */
    public synchronized Boolean isMagneticDeclinationNotificatable(int index) {
        Boolean result = null;
        if (mEnvironmentalSensingService != null) {
            result = mEnvironmentalSensingService.isMagneticDeclinationNotificatable(index);
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
     * @see #isMagneticFluxDensity2DNotificatable(int)
     */
    public synchronized Boolean isMagneticFluxDensity2DNotificatable() {
        return isMagneticFluxDensity2DNotificatable(0);
    }

    /**
     * @see EnvironmentalSensingService#isMagneticFluxDensity2DNotificatable(int)
     */
    public synchronized Boolean isMagneticFluxDensity2DNotificatable(int index) {
        Boolean result = null;
        if (mEnvironmentalSensingService != null) {
            result = mEnvironmentalSensingService.isMagneticFluxDensity2DNotificatable(index);
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
     * @see #isMagneticFluxDensity3DNotificatable(int)
     */
    public synchronized Boolean isMagneticFluxDensity3DNotificatable() {
        return isMagneticFluxDensity3DNotificatable(0);
    }

    /**
     * @see EnvironmentalSensingService#isMagneticFluxDensity3DNotificatable(int)
     */
    public synchronized Boolean isMagneticFluxDensity3DNotificatable(int index) {
        Boolean result = null;
        if (mEnvironmentalSensingService != null) {
            result = mEnvironmentalSensingService.isMagneticFluxDensity3DNotificatable(index);
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
     * @see #isBatteryLevelNotificatable(int)
     */
    public synchronized Boolean isBatteryLevelNotificatable() {
        return isBatteryLevelNotificatable(0);
    }

    /**
     * get Battery Level's notificatable status
     *
     * @param index Battery Service index
     * @return {@code true}:target Battery Service is notificatable, {@code false}:not notificatable. if {@code null} returned, profile is not ready or no Battery Service
     * @see BatteryService#isBatteryLevelNotificatable(int)
     */
    public synchronized Boolean isBatteryLevelNotificatable(int index) {
        Boolean result = null;
        if (mBatteryService != null) {
            result = mBatteryService.isBatteryLevelNotificatable(index);
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
