package org.im97mori.ble.profile.aiop.central;

import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.im97mori.ble.characteristic.u2a56.Digital;
import org.im97mori.ble.characteristic.u2a58.Analog;
import org.im97mori.ble.descriptor.u2901.CharacteristicUserDescription;
import org.im97mori.ble.descriptor.u290a.ValueTriggerSetting;
import org.im97mori.ble.descriptor.u290e.TimeTriggerSetting;
import org.im97mori.ble.profile.aiop.central.db.AutomationIOProfileBondedDatabaseHelper;
import org.im97mori.ble.profile.central.AbstractCentralProfile;
import org.im97mori.ble.profile.central.db.BondedDeviceDatabaseHelper;
import org.im97mori.ble.profile.central.task.ScanTask;
import org.im97mori.ble.service.aios.central.AutomationIOService;

/**
 * Automation IO Profile for Central
 */
public class AutomationIOProfile extends AbstractCentralProfile {

    /**
     * {@link AutomationIOProfileCallback} instance
     */
    protected final AutomationIOProfileCallback mAutomationIOProfileCallback;

    /**
     * {@link AutomationIOService} instance
     */
    protected AutomationIOService mAutomationIOService;

    /**
     * @param context                     {@link Context} instance
     * @param automationIOProfileCallback {@link AutomationIOProfileCallback} instance
     */
    public AutomationIOProfile(@NonNull Context context, @NonNull AutomationIOProfileCallback automationIOProfileCallback) {
        super(context, automationIOProfileCallback);
        mAutomationIOProfileCallback = automationIOProfileCallback;
    }

    /**
     * find Automation IO Profile device
     *
     * @param argument callback argument
     * @return task id. if {@code null} returned, task was not registed
     */
    @Nullable
    public synchronized Integer findAutomationIOProfileDevices(@Nullable Bundle argument) {
        return scanDevice(new AutomationIOProfileScanCallback(this, null), ScanTask.TIMEOUT_MILLIS, argument);
    }

    /**
     * @see AutomationIOService#getDigitalCharacteristicExtendedProperties(int)
     */
    public synchronized Integer getDigitalCount() {
        Integer count = null;
        if (mAutomationIOService != null) {
            count = mAutomationIOService.getDigitalCount();
        }
        return count;
    }

    /**
     * @see #isDigitalReadable(int)
     */
    public synchronized Boolean isDigitalReadable() {
        return isDigitalReadable(0);
    }

    /**
     * @see AutomationIOService#isDigitalReadable(int)
     */
    public synchronized Boolean isDigitalReadable(int index) {
        Boolean result = null;
        if (mAutomationIOService != null) {
            result = mAutomationIOService.isDigitalReadable(index);
        }
        return result;
    }

    /**
     * @see #isDigitalWritable(int)
     */
    public synchronized Boolean isDigitalWritable() {
        return isDigitalWritable(0);
    }

    /**
     * @see AutomationIOService#isDigitalWritable(int)
     */
    public synchronized Boolean isDigitalWritable(int index) {
        Boolean result = null;
        if (mAutomationIOService != null) {
            result = mAutomationIOService.isDigitalWritable(index);
        }
        return result;
    }

    /**
     * @see #isDigitalWritableWithNoResponse(int)
     */
    public synchronized Boolean isDigitalWritableWithNoResponse() {
        return isDigitalWritableWithNoResponse(0);
    }

    /**
     * @see AutomationIOService#isDigitalWritableWithNoResponse(int)
     */
    public synchronized Boolean isDigitalWritableWithNoResponse(int index) {
        Boolean result = null;
        if (mAutomationIOService != null) {
            result = mAutomationIOService.isDigitalWritableWithNoResponse(index);
        }
        return result;
    }

    /**
     * @see #isDigitalNotificatable(int)
     */
    public synchronized Boolean isDigitalNotificatable() {
        return isDigitalNotificatable(0);
    }

    /**
     * @see AutomationIOService#isDigitalNotificatable(int)
     */
    public synchronized Boolean isDigitalNotificatable(int index) {
        Boolean result = null;
        if (mAutomationIOService != null) {
            result = mAutomationIOService.isDigitalNotificatable(index);
        }
        return result;
    }

    /**
     * @see #isDigitalIndicatable(int)
     */
    public synchronized Boolean isDigitalIndicatable() {
        return isDigitalIndicatable(0);
    }

    /**
     * @see AutomationIOService#isDigitalIndicatable(int)
     */
    public synchronized Boolean isDigitalIndicatable(int index) {
        Boolean result = null;
        if (mAutomationIOService != null) {
            result = mAutomationIOService.isDigitalIndicatable(index);
        }
        return result;
    }

    /**
     * @see #hasDigitalCharacteristicPresentationFormat(int)
     */
    public synchronized Boolean hasDigitalCharacteristicPresentationFormat() {
        return hasDigitalCharacteristicPresentationFormat(0);
    }

    /**
     * @see AutomationIOService#hasDigitalCharacteristicPresentationFormat(int)
     */
    public synchronized Boolean hasDigitalCharacteristicPresentationFormat(int index) {
        Boolean result = null;
        if (mAutomationIOService != null) {
            result = mAutomationIOService.hasDigitalCharacteristicPresentationFormat(index);
        }
        return result;
    }

    /**
     * @see #hasDigitalCharacteristicUserDescription(int)
     */
    public synchronized Boolean hasDigitalCharacteristicUserDescription() {
        return hasDigitalCharacteristicUserDescription(0);
    }

    /**
     * @see AutomationIOService#hasDigitalCharacteristicUserDescription(int)
     */
    public synchronized Boolean hasDigitalCharacteristicUserDescription(int index) {
        Boolean result = null;
        if (mAutomationIOService != null) {
            result = mAutomationIOService.hasDigitalCharacteristicUserDescription(index);
        }
        return result;
    }

    /**
     * @see #isDigitalCharacteristicUserDescriptionWritable(int)
     */
    public synchronized Boolean isDigitalCharacteristicUserDescriptionWritable() {
        return isDigitalCharacteristicUserDescriptionWritable(0);
    }

    /**
     * @see AutomationIOService#isDigitalCharacteristicUserDescriptionWritable(int)
     */
    public synchronized Boolean isDigitalCharacteristicUserDescriptionWritable(int index) {
        Boolean result = null;
        if (mAutomationIOService != null) {
            result = mAutomationIOService.isDigitalCharacteristicUserDescriptionWritable(index);
        }
        return result;
    }

    /**
     * @see #hasDigitalCharacteristicExtendedProperties(int)
     */
    public synchronized Boolean hasDigitalCharacteristicExtendedProperties() {
        return hasDigitalCharacteristicExtendedProperties(0);
    }

    /**
     * @see AutomationIOService#hasDigitalCharacteristicExtendedProperties(int)
     */
    public synchronized Boolean hasDigitalCharacteristicExtendedProperties(int index) {
        Boolean result = null;
        if (mAutomationIOService != null) {
            result = mAutomationIOService.hasDigitalCharacteristicExtendedProperties(index);
        }
        return result;
    }

    /**
     * @see #hasDigitalValueTriggerSetting(int)
     */
    public synchronized Boolean hasDigitalValueTriggerSetting() {
        return hasDigitalValueTriggerSetting(0);
    }

    /**
     * @see AutomationIOService#hasDigitalValueTriggerSetting(int)
     */
    public synchronized Boolean hasDigitalValueTriggerSetting(int index) {
        Boolean result = null;
        if (mAutomationIOService != null) {
            result = mAutomationIOService.hasDigitalValueTriggerSetting(index);
        }
        return result;
    }

    /**
     * @see #hasDigitalTimeTriggerSetting(int)
     */
    public synchronized Boolean hasDigitalTimeTriggerSetting() {
        return hasDigitalTimeTriggerSetting(0);
    }

    /**
     * @see AutomationIOService#hasDigitalTimeTriggerSetting(int)
     */
    public synchronized Boolean hasDigitalTimeTriggerSetting(int index) {
        Boolean result = null;
        if (mAutomationIOService != null) {
            result = mAutomationIOService.hasDigitalTimeTriggerSetting(index);
        }
        return result;
    }

    /**
     * @see AutomationIOService#getAnalogCount()
     */
    public synchronized Integer getAnalogCount() {
        Integer count = null;
        if (mAutomationIOService != null) {
            count = mAutomationIOService.getAnalogCount();
        }
        return count;
    }

    /**
     * @see #isAnalogReadable(int)
     */
    public synchronized Boolean isAnalogReadable() {
        return isAnalogReadable(0);
    }

    /**
     * @see AutomationIOService#isAnalogReadable(int)
     */
    public synchronized Boolean isAnalogReadable(int index) {
        Boolean result = null;
        if (mAutomationIOService != null) {
            result = mAutomationIOService.isAnalogReadable(index);
        }
        return result;
    }

    /**
     * @see #isAnalogWritable(int)
     */
    public synchronized Boolean isAnalogWritable() {
        return isAnalogWritable(0);
    }

    /**
     * @see AutomationIOService#isAnalogWritable(int)
     */
    public synchronized Boolean isAnalogWritable(int index) {
        Boolean result = null;
        if (mAutomationIOService != null) {
            result = mAutomationIOService.isAnalogWritable(index);
        }
        return result;
    }

    /**
     * @see #isAnalogWritableWithNoResponse(int)
     */
    public synchronized Boolean isAnalogWritableWithNoResponse() {
        return isAnalogWritableWithNoResponse(0);
    }

    /**
     * @see AutomationIOService#isAnalogWritableWithNoResponse(int)
     */
    public synchronized Boolean isAnalogWritableWithNoResponse(int index) {
        Boolean result = null;
        if (mAutomationIOService != null) {
            result = mAutomationIOService.isAnalogWritableWithNoResponse(index);
        }
        return result;
    }

    /**
     * @see #isAnalogNotificatable(int)
     */
    public synchronized Boolean isAnalogNotificatable() {
        return isAnalogNotificatable(0);
    }

    /**
     * @see AutomationIOService#isAnalogNotificatable(int)
     */
    public synchronized Boolean isAnalogNotificatable(int index) {
        Boolean result = null;
        if (mAutomationIOService != null) {
            result = mAutomationIOService.isAnalogNotificatable(index);
        }
        return result;
    }

    /**
     * @see #isAnalogIndicatable(int)
     */
    public synchronized Boolean isAnalogIndicatable() {
        return isAnalogIndicatable(0);
    }

    /**
     * @see AutomationIOService#isAnalogIndicatable(int)
     */
    public synchronized Boolean isAnalogIndicatable(int index) {
        Boolean result = null;
        if (mAutomationIOService != null) {
            result = mAutomationIOService.isAnalogIndicatable(index);
        }
        return result;
    }

    /**
     * @see #hasAnalogCharacteristicPresentationFormat(int)
     */
    public synchronized Boolean hasAnalogCharacteristicPresentationFormat() {
        return hasAnalogCharacteristicPresentationFormat(0);
    }

    /**
     * @see AutomationIOService#hasAnalogCharacteristicPresentationFormat(int)
     */
    public synchronized Boolean hasAnalogCharacteristicPresentationFormat(int index) {
        Boolean result = null;
        if (mAutomationIOService != null) {
            result = mAutomationIOService.hasAnalogCharacteristicPresentationFormat(index);
        }
        return result;
    }

    /**
     * @see #hasAnalogCharacteristicUserDescription(int)
     */
    public synchronized Boolean hasAnalogCharacteristicUserDescription() {
        return hasAnalogCharacteristicUserDescription(0);
    }

    /**
     * @see AutomationIOService#hasAnalogCharacteristicUserDescription(int)
     */
    public synchronized Boolean hasAnalogCharacteristicUserDescription(int index) {
        Boolean result = null;
        if (mAutomationIOService != null) {
            result = mAutomationIOService.hasAnalogCharacteristicUserDescription(index);
        }
        return result;
    }

    /**
     * @see #isAnalogCharacteristicUserDescriptionWritable(int)
     */
    public synchronized Boolean isAnalogCharacteristicUserDescriptionWritable() {
        return isAnalogCharacteristicUserDescriptionWritable(0);
    }

    /**
     * @see AutomationIOService#isAnalogCharacteristicUserDescriptionWritable(int)
     */
    public synchronized Boolean isAnalogCharacteristicUserDescriptionWritable(int index) {
        Boolean result = null;
        if (mAutomationIOService != null) {
            result = mAutomationIOService.isAnalogCharacteristicUserDescriptionWritable(index);
        }
        return result;
    }

    /**
     * @see #hasAnalogCharacteristicExtendedProperties(int)
     */
    public synchronized Boolean hasAnalogCharacteristicExtendedProperties() {
        return hasAnalogCharacteristicExtendedProperties(0);
    }

    /**
     * @see AutomationIOService#hasAnalogCharacteristicExtendedProperties(int)
     */
    public synchronized Boolean hasAnalogCharacteristicExtendedProperties(int index) {
        Boolean result = null;
        if (mAutomationIOService != null) {
            result = mAutomationIOService.hasAnalogCharacteristicExtendedProperties(index);
        }
        return result;
    }

    /**
     * @see #hasAnalogValueTriggerSetting(int)
     */
    public synchronized Boolean hasAnalogValueTriggerSetting() {
        return hasAnalogValueTriggerSetting(0);
    }

    /**
     * @see AutomationIOService#hasAnalogValueTriggerSetting(int)
     */
    public synchronized Boolean hasAnalogValueTriggerSetting(int index) {
        Boolean result = null;
        if (mAutomationIOService != null) {
            result = mAutomationIOService.hasAnalogValueTriggerSetting(index);
        }
        return result;
    }

    /**
     * @see #hasAnalogTimeTriggerSetting(int)
     */
    public synchronized Boolean hasAnalogTimeTriggerSetting() {
        return hasAnalogTimeTriggerSetting(0);
    }

    /**
     * @see AutomationIOService#hasAnalogTimeTriggerSetting(int)
     */
    public synchronized Boolean hasAnalogTimeTriggerSetting(int index) {
        Boolean result = null;
        if (mAutomationIOService != null) {
            result = mAutomationIOService.hasAnalogTimeTriggerSetting(index);
        }
        return result;
    }

    /**
     * @see AutomationIOService#isAggregateSupporeted()
     */
    public synchronized Boolean isAggregateSupporeted() {
        Boolean result = null;
        if (mAutomationIOService != null) {
            result = mAutomationIOService.isAggregateSupporeted();
        }
        return result;
    }

    /**
     * @see AutomationIOService#isAggregateReadable()
     */
    public synchronized Boolean isAggregateReadable() {
        Boolean result = null;
        if (mAutomationIOService != null) {
            result = mAutomationIOService.isAggregateReadable();
        }
        return result;
    }

    /**
     * @see AutomationIOService#isAggregateNotificatable()
     */
    public synchronized Boolean isAggregateNotificatable() {
        Boolean result = null;
        if (mAutomationIOService != null) {
            result = mAutomationIOService.isAggregateNotificatable();
        }
        return result;
    }

    /**
     * @see AutomationIOService#isAggregateIndicatable()
     */
    public synchronized Boolean isAggregateIndicatable() {
        Boolean result = null;
        if (mAutomationIOService != null) {
            result = mAutomationIOService.isAggregateIndicatable();
        }
        return result;
    }

    /**
     * @see #getDigital(int)
     */
    @Nullable
    public synchronized Integer getDigital() {
        return getDigital(0);
    }

    /**
     * @see AutomationIOService#getDigital(int)
     */
    @Nullable
    public synchronized Integer getDigital(int index) {
        Integer taskId = null;
        if (mAutomationIOService != null) {
            taskId = mAutomationIOService.getDigital(index);
        }
        return taskId;
    }

    /**
     * @see #setDigital(int, Digital)
     */
    @Nullable
    public synchronized Integer setDigital(@NonNull Digital digital) {
        return setDigital(0, digital);
    }

    /**
     * @see AutomationIOService#setDigital(int, Digital)
     */
    @Nullable
    public synchronized Integer setDigital(int index, @NonNull Digital digital) {
        Integer taskId = null;
        if (mAutomationIOService != null) {
            taskId = mAutomationIOService.setDigital(index, digital);
        }
        return taskId;
    }

    /**
     * @see #setDigitalWithNoResponse(int, Digital)
     */
    @Nullable
    public synchronized Integer setDigitalWithNoResponse(@NonNull Digital digital) {
        return setDigitalWithNoResponse(0, digital);
    }

    /**
     * @see AutomationIOService#setDigitalWithNoResponse(int, Digital)
     */
    @Nullable
    public synchronized Integer setDigitalWithNoResponse(int index, @NonNull Digital digital) {
        Integer taskId = null;
        if (mAutomationIOService != null) {
            taskId = mAutomationIOService.setDigitalWithNoResponse(index, digital);
        }
        return taskId;
    }

    /**
     * @see #getDigitalClientCharacteristicConfiguration(int)
     */
    @Nullable
    public synchronized Integer getDigitalClientCharacteristicConfiguration() {
        return getDigitalClientCharacteristicConfiguration(0);
    }

    /**
     * @see AutomationIOService#getDigitalClientCharacteristicConfiguration(int)
     */
    @Nullable
    public synchronized Integer getDigitalClientCharacteristicConfiguration(int index) {
        Integer taskId = null;
        if (mAutomationIOService != null) {
            taskId = mAutomationIOService.getDigitalClientCharacteristicConfiguration(index);
        }
        return taskId;
    }

    /**
     * @see #startDigitalNotification(int)
     */
    @Nullable
    public synchronized Integer startDigitalNotification() {
        return startDigitalNotification(0);
    }

    /**
     * @see AutomationIOService#startDigitalNotification(int)
     */
    @Nullable
    public synchronized Integer startDigitalNotification(int index) {
        Integer taskId = null;
        if (mAutomationIOService != null) {
            taskId = mAutomationIOService.startDigitalNotification(index);
        }
        return taskId;
    }

    /**
     * @see #stopDigitalNotification(int)
     */
    @Nullable
    public synchronized Integer stopDigitalNotification() {
        return stopDigitalNotification(0);
    }

    /**
     * @see AutomationIOService#stopDigitalNotification(int)
     */
    @Nullable
    public synchronized Integer stopDigitalNotification(int index) {
        Integer taskId = null;
        if (mAutomationIOService != null) {
            taskId = mAutomationIOService.stopDigitalNotification(index);
        }
        return taskId;
    }

    /**
     * @see #startDigitalIndication(int)
     */
    @Nullable
    public synchronized Integer startDigitalIndication() {
        return startDigitalIndication(0);
    }

    /**
     * @see AutomationIOService#startDigitalIndication(int)
     */
    @Nullable
    public synchronized Integer startDigitalIndication(int index) {
        Integer taskId = null;
        if (mAutomationIOService != null) {
            taskId = mAutomationIOService.startDigitalIndication(index);
        }
        return taskId;
    }

    /**
     * @see #stopDigitalIndication(int)
     */
    @Nullable
    public synchronized Integer stopDigitalIndication() {
        return stopDigitalIndication(0);
    }

    /**
     * @see AutomationIOService#stopDigitalIndication(int)
     */
    @Nullable
    public synchronized Integer stopDigitalIndication(int index) {
        Integer taskId = null;
        if (mAutomationIOService != null) {
            taskId = mAutomationIOService.stopDigitalIndication(index);
        }
        return taskId;
    }

    /**
     * @see #getDigitalCharacteristicPresentationFormat(int)
     */
    @Nullable
    public synchronized Integer getDigitalCharacteristicPresentationFormat() {
        return getDigitalCharacteristicPresentationFormat(0);
    }

    /**
     * @see AutomationIOService#getDigitalCharacteristicPresentationFormat(int)
     */
    @Nullable
    public synchronized Integer getDigitalCharacteristicPresentationFormat(int index) {
        Integer taskId = null;
        if (mAutomationIOService != null) {
            taskId = mAutomationIOService.getDigitalCharacteristicPresentationFormat(index);
        }
        return taskId;
    }

    /**
     * @see #getDigitalCharacteristicUserDescription(int)
     */
    @Nullable
    public synchronized Integer getDigitalCharacteristicUserDescription() {
        return getDigitalCharacteristicUserDescription(0);
    }

    /**
     * @see AutomationIOService#getDigitalCharacteristicUserDescription(int)
     */
    @Nullable
    public synchronized Integer getDigitalCharacteristicUserDescription(int index) {
        Integer taskId = null;
        if (mAutomationIOService != null) {
            taskId = mAutomationIOService.getDigitalCharacteristicUserDescription(index);
        }
        return taskId;
    }

    /**
     * @see #setDigitalCharacteristicUserDescription(int, CharacteristicUserDescription)
     */
    @Nullable
    public synchronized Integer setDigitalCharacteristicUserDescription(@NonNull CharacteristicUserDescription characteristicUserDescription) {
        return setDigitalCharacteristicUserDescription(0, characteristicUserDescription);
    }

    /**
     * @see AutomationIOService#setDigitalCharacteristicUserDescription(int, CharacteristicUserDescription)
     */
    @Nullable
    public synchronized Integer setDigitalCharacteristicUserDescription(int index, @NonNull CharacteristicUserDescription characteristicUserDescription) {
        Integer taskId = null;
        if (mAutomationIOService != null) {
            taskId = mAutomationIOService.setDigitalCharacteristicUserDescription(index, characteristicUserDescription);
        }
        return taskId;
    }

    /**
     * @see #getDigitalCharacteristicExtendedProperties(int)
     */
    @Nullable
    public synchronized Integer getDigitalCharacteristicExtendedProperties() {
        return getDigitalCharacteristicExtendedProperties(0);
    }

    /**
     * @see AutomationIOService#getDigitalCharacteristicExtendedProperties(int)
     */
    @Nullable
    public synchronized Integer getDigitalCharacteristicExtendedProperties(int index) {
        Integer taskId = null;
        if (mAutomationIOService != null) {
            taskId = mAutomationIOService.getDigitalCharacteristicExtendedProperties(index);
        }
        return taskId;
    }

    /**
     * @see #getDigitalValueTriggerSetting(int)
     */
    @Nullable
    public synchronized Integer getDigitalValueTriggerSetting() {
        return getDigitalValueTriggerSetting(0);
    }

    /**
     * @see AutomationIOService#getDigitalValueTriggerSetting(int)
     */
    @Nullable
    public synchronized Integer getDigitalValueTriggerSetting(int index) {
        Integer taskId = null;
        if (mAutomationIOService != null) {
            taskId = mAutomationIOService.getDigitalValueTriggerSetting(index);
        }
        return taskId;
    }

    /**
     * @see #setDigitalValueTriggerSetting(int, ValueTriggerSetting)
     */
    @Nullable
    public synchronized Integer setDigitalValueTriggerSetting(@NonNull ValueTriggerSetting valueTriggerSetting) {
        return setDigitalValueTriggerSetting(0, valueTriggerSetting);
    }

    /**
     * @see AutomationIOService#setDigitalValueTriggerSetting(int, ValueTriggerSetting)
     */
    @Nullable
    public synchronized Integer setDigitalValueTriggerSetting(int index, @NonNull ValueTriggerSetting valueTriggerSetting) {
        Integer taskId = null;
        if (mAutomationIOService != null) {
            taskId = mAutomationIOService.setDigitalValueTriggerSetting(index, valueTriggerSetting);
        }
        return taskId;
    }

    /**
     * @see #getDigitalTimeTriggerSetting(int)
     */
    @Nullable
    public synchronized Integer getDigitalTimeTriggerSetting() {
        return getDigitalTimeTriggerSetting(0);
    }

    /**
     * @see AutomationIOService#getDigitalTimeTriggerSetting(int)
     */
    @Nullable
    public synchronized Integer getDigitalTimeTriggerSetting(int index) {
        Integer taskId = null;
        if (mAutomationIOService != null) {
            taskId = mAutomationIOService.getDigitalTimeTriggerSetting(index);
        }
        return taskId;
    }

    /**
     * @see #setDigitalTimeTriggerSetting(int, TimeTriggerSetting)
     */
    @Nullable
    public synchronized Integer setDigitalTimeTriggerSetting(@NonNull TimeTriggerSetting timeTriggerSetting) {
        return setDigitalTimeTriggerSetting(0, timeTriggerSetting);
    }

    /**
     * @see AutomationIOService#setDigitalTimeTriggerSetting(int, TimeTriggerSetting)
     */
    @Nullable
    public synchronized Integer setDigitalTimeTriggerSetting(int index, @NonNull TimeTriggerSetting timeTriggerSetting) {
        Integer taskId = null;
        if (mAutomationIOService != null) {
            taskId = mAutomationIOService.setDigitalTimeTriggerSetting(index, timeTriggerSetting);
        }
        return taskId;
    }

    /**
     * @see #getDigitalNumberOfDigitals(int)
     */
    @Nullable
    public synchronized Integer getDigitalNumberOfDigitals() {
        return getDigitalNumberOfDigitals(0);
    }

    /**
     * @see AutomationIOService#getDigitalNumberOfDigitals(int)
     */
    @Nullable
    public synchronized Integer getDigitalNumberOfDigitals(int index) {
        Integer taskId = null;
        if (mAutomationIOService != null) {
            taskId = mAutomationIOService.getDigitalNumberOfDigitals(index);
        }
        return taskId;
    }

    /**
     * @see #getAnalog(int)
     */
    @Nullable
    public synchronized Integer getAnalog() {
        return getAnalog(0);
    }

    /**
     * @see AutomationIOService#getAnalog(int)
     */
    @Nullable
    public synchronized Integer getAnalog(int index) {
        Integer taskId = null;
        if (mAutomationIOService != null) {
            taskId = mAutomationIOService.getAnalog(index);
        }
        return taskId;
    }

    /**
     * @see #setAnalog(int, Analog)
     */
    @Nullable
    public synchronized Integer setAnalog(@NonNull Analog analog) {
        return setAnalog(0, analog);
    }

    /**
     * @see AutomationIOService#setAnalog(int, Analog)
     */
    @Nullable
    public synchronized Integer setAnalog(int index, @NonNull Analog analog) {
        Integer taskId = null;
        if (mAutomationIOService != null) {
            taskId = mAutomationIOService.setAnalog(index, analog);
        }
        return taskId;
    }

    /**
     * @see #setAnalogWithNoResponse(int, Analog)
     */
    @Nullable
    public synchronized Integer setAnalogWithNoResponse(@NonNull Analog analog) {
        return setAnalogWithNoResponse(0, analog);
    }

    /**
     * @see AutomationIOService#setAnalogWithNoResponse(int, Analog)
     */
    @Nullable
    public synchronized Integer setAnalogWithNoResponse(int index, @NonNull Analog analog) {
        Integer taskId = null;
        if (mAutomationIOService != null) {
            taskId = mAutomationIOService.setAnalogWithNoResponse(index, analog);
        }
        return taskId;
    }

    /**
     * @see #getAnalogClientCharacteristicConfiguration(int)
     */
    @Nullable
    public synchronized Integer getAnalogClientCharacteristicConfiguration() {
        return getAnalogClientCharacteristicConfiguration(0);
    }

    /**
     * @see AutomationIOService#getAnalogClientCharacteristicConfiguration(int)
     */
    @Nullable
    public synchronized Integer getAnalogClientCharacteristicConfiguration(int index) {
        Integer taskId = null;
        if (mAutomationIOService != null) {
            taskId = mAutomationIOService.getAnalogClientCharacteristicConfiguration(index);
        }
        return taskId;
    }

    /**
     * @see #startAnalogNotification(int)
     */
    @Nullable
    public synchronized Integer startAnalogNotification() {
        return startAnalogNotification(0);
    }

    /**
     * @see AutomationIOService#startAnalogNotification(int)
     */
    @Nullable
    public synchronized Integer startAnalogNotification(int index) {
        Integer taskId = null;
        if (mAutomationIOService != null) {
            taskId = mAutomationIOService.startAnalogNotification(index);
        }
        return taskId;
    }

    /**
     * @see #stopAnalogNotification(int)
     */
    @Nullable
    public synchronized Integer stopAnalogNotification() {
        return stopAnalogNotification(0);
    }

    /**
     * @see AutomationIOService#stopAnalogNotification(int)
     */
    @Nullable
    public synchronized Integer stopAnalogNotification(int index) {
        Integer taskId = null;
        if (mAutomationIOService != null) {
            taskId = mAutomationIOService.stopAnalogNotification(index);
        }
        return taskId;
    }

    /**
     * @see #startAnalogIndication(int)
     */
    @Nullable
    public synchronized Integer startAnalogIndication() {
        return startAnalogIndication(0);
    }

    /**
     * @see AutomationIOService#startAnalogIndication(int)
     */
    @Nullable
    public synchronized Integer startAnalogIndication(int index) {
        Integer taskId = null;
        if (mAutomationIOService != null) {
            taskId = mAutomationIOService.startAnalogIndication(index);
        }
        return taskId;
    }

    /**
     * @see #stopAnalogIndication(int)
     */
    @Nullable
    public synchronized Integer stopAnalogIndication() {
        return stopAnalogIndication(0);
    }

    /**
     * @see AutomationIOService#stopAnalogIndication(int)
     */
    @Nullable
    public synchronized Integer stopAnalogIndication(int index) {
        Integer taskId = null;
        if (mAutomationIOService != null) {
            taskId = mAutomationIOService.stopAnalogIndication(index);
        }
        return taskId;
    }

    /**
     * @see #getAnalogCharacteristicPresentationFormat(int)
     */
    @Nullable
    public synchronized Integer getAnalogCharacteristicPresentationFormat() {
        return getAnalogCharacteristicPresentationFormat(0);
    }

    /**
     * @see AutomationIOService#getAnalogCharacteristicPresentationFormat(int)
     */
    @Nullable
    public synchronized Integer getAnalogCharacteristicPresentationFormat(int index) {
        Integer taskId = null;
        if (mAutomationIOService != null) {
            taskId = mAutomationIOService.getAnalogCharacteristicPresentationFormat(index);
        }
        return taskId;
    }

    /**
     * @see #getAnalogCharacteristicUserDescription(int)
     */
    @Nullable
    public synchronized Integer getAnalogCharacteristicUserDescription() {
        return getAnalogCharacteristicUserDescription(0);
    }

    /**
     * @see AutomationIOService#getAnalogCharacteristicUserDescription(int)
     */
    @Nullable
    public synchronized Integer getAnalogCharacteristicUserDescription(int index) {
        Integer taskId = null;
        if (mAutomationIOService != null) {
            taskId = mAutomationIOService.getAnalogCharacteristicUserDescription(index);
        }
        return taskId;
    }

    /**
     * @see #setAnalogCharacteristicUserDescription(int, CharacteristicUserDescription)
     */
    @Nullable
    public synchronized Integer setAnalogCharacteristicUserDescription(@NonNull CharacteristicUserDescription characteristicUserDescription) {
        return setAnalogCharacteristicUserDescription(0, characteristicUserDescription);
    }

    /**
     * @see AutomationIOService#setAnalogCharacteristicUserDescription(int, CharacteristicUserDescription)
     */
    @Nullable
    public synchronized Integer setAnalogCharacteristicUserDescription(int index, @NonNull CharacteristicUserDescription characteristicUserDescription) {
        Integer taskId = null;
        if (mAutomationIOService != null) {
            taskId = mAutomationIOService.setAnalogCharacteristicUserDescription(index, characteristicUserDescription);
        }
        return taskId;
    }

    /**
     * @see #getAnalogCharacteristicExtendedProperties(int)
     */
    @Nullable
    public synchronized Integer getAnalogCharacteristicExtendedProperties() {
        return getAnalogCharacteristicExtendedProperties(0);
    }

    /**
     * @see AutomationIOService#getAnalogCharacteristicExtendedProperties(int)
     */
    @Nullable
    public synchronized Integer getAnalogCharacteristicExtendedProperties(int index) {
        Integer taskId = null;
        if (mAutomationIOService != null) {
            taskId = mAutomationIOService.getAnalogCharacteristicExtendedProperties(index);
        }
        return taskId;
    }

    /**
     * @see #getAnalogCharacteristicExtendedProperties(int)
     */
    @Nullable
    public synchronized Integer getAnalogValueTriggerSetting() {
        return getAnalogValueTriggerSetting(0);
    }

    /**
     * @see AutomationIOService#getAnalogValueTriggerSetting(int)
     */
    @Nullable
    public synchronized Integer getAnalogValueTriggerSetting(int index) {
        Integer taskId = null;
        if (mAutomationIOService != null) {
            taskId = mAutomationIOService.getAnalogValueTriggerSetting(index);
        }
        return taskId;
    }

    /**
     * @see #setAnalogValueTriggerSetting(int, ValueTriggerSetting)
     */
    @Nullable
    public synchronized Integer setAnalogValueTriggerSetting(@NonNull ValueTriggerSetting valueTriggerSetting) {
        return setAnalogValueTriggerSetting(0, valueTriggerSetting);
    }

    /**
     * @see AutomationIOService#setAnalogValueTriggerSetting(int, ValueTriggerSetting)
     */
    @Nullable
    public synchronized Integer setAnalogValueTriggerSetting(int index, @NonNull ValueTriggerSetting valueTriggerSetting) {
        Integer taskId = null;
        if (mAutomationIOService != null) {
            taskId = mAutomationIOService.setAnalogValueTriggerSetting(index, valueTriggerSetting);
        }
        return taskId;
    }

    /**
     * @see #getAnalogTimeTriggerSetting(int)
     */
    @Nullable
    public synchronized Integer getAnalogTimeTriggerSetting() {
        return getAnalogTimeTriggerSetting(0);
    }

    /**
     * @see AutomationIOService#getAnalogTimeTriggerSetting(int)
     */
    @Nullable
    public synchronized Integer getAnalogTimeTriggerSetting(int index) {
        Integer taskId = null;
        if (mAutomationIOService != null) {
            taskId = mAutomationIOService.getAnalogTimeTriggerSetting(index);
        }
        return taskId;
    }

    /**
     * @see #setAnalogTimeTriggerSetting(int, TimeTriggerSetting)
     */
    @Nullable
    public synchronized Integer setAnalogTimeTriggerSetting(@NonNull TimeTriggerSetting timeTriggerSetting) {
        return setAnalogTimeTriggerSetting(0, timeTriggerSetting);
    }

    /**
     * @see AutomationIOService#setAnalogTimeTriggerSetting(int, TimeTriggerSetting)
     */
    @Nullable
    public synchronized Integer setAnalogTimeTriggerSetting(int index, @NonNull TimeTriggerSetting timeTriggerSetting) {
        Integer taskId = null;
        if (mAutomationIOService != null) {
            taskId = mAutomationIOService.setAnalogTimeTriggerSetting(index, timeTriggerSetting);
        }
        return taskId;
    }

    /**
     * @see #getAnalogValidRange(int)
     */
    @Nullable
    public synchronized Integer getAnalogValidRange() {
        return getAnalogValidRange(0);
    }

    /**
     * @see AutomationIOService#getAnalogValidRange(int)
     */
    @Nullable
    public synchronized Integer getAnalogValidRange(int index) {
        Integer taskId = null;
        if (mAutomationIOService != null) {
            taskId = mAutomationIOService.getAnalogValidRange(index);
        }
        return taskId;
    }

    /**
     * @see AutomationIOService#getAggregate()
     */
    @Nullable
    public synchronized Integer getAggregate() {
        Integer taskId = null;
        if (mAutomationIOService != null) {
            taskId = mAutomationIOService.getAggregate();
        }
        return taskId;
    }

    /**
     * @see AutomationIOService#getAggregateClientCharacteristicConfiguration()
     */
    @Nullable
    public synchronized Integer getAggregateClientCharacteristicConfiguration() {
        Integer taskId = null;
        if (mAutomationIOService != null) {
            taskId = mAutomationIOService.getAggregateClientCharacteristicConfiguration();
        }
        return taskId;
    }

    /**
     * @see AutomationIOService#startAggregateNotification()
     */
    @Nullable
    public synchronized Integer startAggregateNotification() {
        Integer taskId = null;
        if (mAutomationIOService != null) {
            taskId = mAutomationIOService.startAggregateNotification();
        }
        return taskId;
    }

    /**
     * @see AutomationIOService#startAggregateNotification()
     */
    @Nullable
    public synchronized Integer stopAggregateNotification() {
        Integer taskId = null;
        if (mAutomationIOService != null) {
            taskId = mAutomationIOService.stopAggregateNotification();
        }
        return taskId;
    }

    /**
     * @see AutomationIOService#startAggregateIndication()
     */
    @Nullable
    public synchronized Integer startAggregateIndication() {
        Integer taskId = null;
        if (mAutomationIOService != null) {
            taskId = mAutomationIOService.startAggregateIndication();
        }
        return taskId;
    }

    /**
     * @see AutomationIOService#stopAggregateIndication()
     */
    @Nullable
    public synchronized Integer stopAggregateIndication() {
        Integer taskId = null;
        if (mAutomationIOService != null) {
            taskId = mAutomationIOService.stopAggregateIndication();
        }
        return taskId;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BondedDeviceDatabaseHelper getDatabaseHelper() {
        return AutomationIOProfileBondedDatabaseHelper.getInstance(mContext);
    }

    /**
     * create {@link AutomationIOService}
     *
     * @see #connect(BluetoothDevice)
     */
    @Override
    public synchronized void createServices() {
        super.createServices();
        if (mAutomationIOService == null) {
            mAutomationIOService = new AutomationIOService(mBLEConnection, mAutomationIOProfileCallback, null);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void quit() {
        super.quit();
        mAutomationIOService = null;
    }

}
