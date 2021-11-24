package org.im97mori.ble.service.ans.peripheral;

import static org.im97mori.ble.constants.CharacteristicUUID.ALERT_NOTIFICATION_CONTROL_POINT_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.NEW_ALERT_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.SUPPORTED_NEW_ALERT_CATEGORY_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.SUPPORTED_UNREAD_ALERT_CATEGORY_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.UNREAD_ALERT_STATUS_CHARACTERISTIC;
import static org.im97mori.ble.constants.DescriptorUUID.CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
import static org.im97mori.ble.constants.ErrorCode.APPLICATION_ERROR_9F;
import static org.im97mori.ble.constants.ErrorCode.COMMAND_NOT_SUPPORTED;
import static org.im97mori.ble.constants.ServiceUUID.ALERT_NOTIFICATION_SERVICE;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattServer;
import android.bluetooth.BluetoothGattService;
import android.bluetooth.le.AdvertiseSettings;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Pair;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.im97mori.ble.BLEServerConnection;
import org.im97mori.ble.CharacteristicData;
import org.im97mori.ble.DescriptorData;
import org.im97mori.ble.MockData;
import org.im97mori.ble.ServiceData;
import org.im97mori.ble.characteristic.core.AlertCategoryIdBitMaskUtils;
import org.im97mori.ble.characteristic.u2a44.AlertNotificationControlPoint;
import org.im97mori.ble.characteristic.u2a45.UnreadAlertStatus;
import org.im97mori.ble.characteristic.u2a46.NewAlert;
import org.im97mori.ble.characteristic.u2a47.SupportedNewAlertCategory;
import org.im97mori.ble.characteristic.u2a48.SupportedUnreadAlertCategory;
import org.im97mori.ble.service.ans.AlertNotificationCategoryIdUtils;
import org.im97mori.ble.service.peripheral.AbstractServiceMockCallback;
import org.im97mori.ble.task.NotificationTask;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Alert Notification Service (Service UUID: 0x1811) for Peripheral
 */
public class AlertNotificationServiceMockCallback extends AbstractServiceMockCallback {

    /**
     * KEY:CATEGORY_ID
     */
    public static final String KEY_CATEGORY_ID = "KEY_CATEGORY_ID";

    /**
     * Builder for {@link AlertNotificationServiceMockCallback}
     *
     * @param <T> subclass of {@link AlertNotificationServiceMockCallback}
     */
    public static class Builder<T extends AlertNotificationServiceMockCallback> extends AbstractServiceMockCallback.Builder<AlertNotificationServiceMockCallback> {

        /**
         * Supported New Alert Category data
         */
        protected CharacteristicData mSupportedNewAlertCategory;

        /**
         * New Alert data
         */
        protected NewAlertCharacteristicData mNewAlert;

        /**
         * Supported Unread Alert Category data
         */
        protected CharacteristicData mSupportedUnreadAlertCategory;

        /**
         * Unread Alert Status data
         */
        protected UnreadAlertStatusCharacteristicData mUnreadAlertStatus;

        /**
         * Alert Notification Control Point data
         */
        protected AlertNotificationControlPointCharacteristicData mAlertNotificationControlPoint;

        /**
         * @see #addSupportedNewAlertCategory(byte[])
         */
        @NonNull
        public Builder<T> addSupportedNewAlertCategory(@NonNull SupportedNewAlertCategory supportedNewAlertCategory) {
            return addSupportedNewAlertCategory(supportedNewAlertCategory.getBytes());
        }

        /**
         * @see #addSupportedNewAlertCategory(int, long, byte[])
         */
        @NonNull
        public Builder<T> addSupportedNewAlertCategory(@NonNull byte[] value) {
            return addSupportedNewAlertCategory(BluetoothGatt.GATT_SUCCESS, 0, value);
        }

        /**
         * add Supported New Alert Category characteristic
         *
         * @param responseCode response code, {@link BluetoothGatt#GATT_SUCCESS} or etc
         * @param delay        response delay(millis)
         * @param value        data for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> addSupportedNewAlertCategory(int responseCode, long delay, @NonNull byte[] value) {
            mSupportedNewAlertCategory = new CharacteristicData(SUPPORTED_NEW_ALERT_CATEGORY_CHARACTERISTIC
                    , BluetoothGattCharacteristic.PROPERTY_READ
                    , BluetoothGattCharacteristic.PERMISSION_READ
                    , Collections.emptyList()
                    , responseCode
                    , delay
                    , value
                    , 0);
            return this;
        }

        /**
         * remove upported New Alert Category characteristic
         *
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> removeSupportedNewAlertCategory() {
            mSupportedNewAlertCategory = null;
            return this;
        }

        /**
         * add New Alert characteristic
         *
         * @param simpleAlertNumberOfNewAlert               Number of New Alert:Simple Alert
         * @param simpleAlertTextStringInformation          Text String Information:Alert
         * @param emailNumberOfNewAlert                     Number of New Alert:Email
         * @param emailTextStringInformation                Text String Information:Email
         * @param newsNumberOfNewAlert                      Number of New Alert:News
         * @param newsTextStringInformation                 Text String Information:News
         * @param callNumberOfNewAlert                      Number of New Alert:Call
         * @param callTextStringInformation                 Text String Information:Call
         * @param missedCallNumberOfNewAlert                Number of New Alert:Missed call
         * @param missedCallTextStringInformation           Text String Information:Missed call
         * @param smsMmsNumberOfNewAlert                    Number of New Alert:SMS/MMS
         * @param smsMmsTextStringInformation               Text String Information:SMS/MMS
         * @param voiceMailNumberOfNewAlert                 Number of New Alert:Voice mail
         * @param voiceMailTextStringInformation            Text String Information:Voice mail
         * @param scheduleNumberOfNewAlert                  Number of New Alert:Schedule
         * @param scheduleTextStringInformation             Text String Information:Schedule
         * @param highPrioritizedAlertNumberOfNewAlert      Number of New Alert:High Prioritized Alert
         * @param highPrioritizedAlertTextStringInformation Text String Information:High Prioritized Alert
         * @param instantMessageAlertNumberOfNewAlert       Number of New Alert:Instant Message
         * @param instantMessageTextStringInformation       Text String Information:Instant Message
         * @param descriptorResponseCode                    descritptor response code for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 3rd parameter
         * @param descriptorDelay                           descritptor response delay(millis)
         * @param descriptorValue                           descriptor data array for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> addNewAlert(
                int simpleAlertNumberOfNewAlert
                , @Nullable String simpleAlertTextStringInformation
                , int emailNumberOfNewAlert
                , @Nullable String emailTextStringInformation
                , int newsNumberOfNewAlert
                , @Nullable String newsTextStringInformation
                , int callNumberOfNewAlert
                , @Nullable String callTextStringInformation
                , int missedCallNumberOfNewAlert
                , @Nullable String missedCallTextStringInformation
                , int smsMmsNumberOfNewAlert
                , @Nullable String smsMmsTextStringInformation
                , int voiceMailNumberOfNewAlert
                , @Nullable String voiceMailTextStringInformation
                , int scheduleNumberOfNewAlert
                , @Nullable String scheduleTextStringInformation
                , int highPrioritizedAlertNumberOfNewAlert
                , @Nullable String highPrioritizedAlertTextStringInformation
                , int instantMessageAlertNumberOfNewAlert
                , @Nullable String instantMessageTextStringInformation
                , int descriptorResponseCode
                , long descriptorDelay
                , @NonNull byte[] descriptorValue) {
            mNewAlert = new NewAlertCharacteristicData(simpleAlertNumberOfNewAlert
                    , simpleAlertTextStringInformation
                    , emailNumberOfNewAlert
                    , emailTextStringInformation
                    , newsNumberOfNewAlert
                    , newsTextStringInformation
                    , callNumberOfNewAlert
                    , callTextStringInformation
                    , missedCallNumberOfNewAlert
                    , missedCallTextStringInformation
                    , smsMmsNumberOfNewAlert
                    , smsMmsTextStringInformation
                    , voiceMailNumberOfNewAlert
                    , voiceMailTextStringInformation
                    , scheduleNumberOfNewAlert
                    , scheduleTextStringInformation
                    , highPrioritizedAlertNumberOfNewAlert
                    , highPrioritizedAlertTextStringInformation
                    , instantMessageAlertNumberOfNewAlert
                    , instantMessageTextStringInformation
                    , Collections.singletonList(new DescriptorData(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR
                    , BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE
                    , descriptorResponseCode
                    , descriptorDelay
                    , descriptorValue)));
            return this;
        }

        /**
         * remove New Alert characteristic
         *
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> removeNewAlert() {
            mNewAlert = null;
            return this;
        }

        /**
         * @see #addSupportedUnreadAlertCategory(byte[])
         */
        @NonNull
        public Builder<T> addSupportedUnreadAlertCategory(@NonNull SupportedUnreadAlertCategory supportedUnreadAlertCategory) {
            return addSupportedUnreadAlertCategory(supportedUnreadAlertCategory.getBytes());
        }

        /**
         * @see #addSupportedNewAlertCategory(int, long, byte[])
         */
        @NonNull
        public Builder<T> addSupportedUnreadAlertCategory(@NonNull byte[] value) {
            return addSupportedUnreadAlertCategory(BluetoothGatt.GATT_SUCCESS, 0, value);
        }

        /**
         * add Supported Unread Alert Category characteristic
         *
         * @param responseCode response code, {@link BluetoothGatt#GATT_SUCCESS} or etc
         * @param delay        response delay(millis)
         * @param value        data for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> addSupportedUnreadAlertCategory(int responseCode, long delay, @NonNull byte[] value) {
            mSupportedUnreadAlertCategory = new CharacteristicData(SUPPORTED_UNREAD_ALERT_CATEGORY_CHARACTERISTIC
                    , BluetoothGattCharacteristic.PROPERTY_READ
                    , BluetoothGattCharacteristic.PERMISSION_READ
                    , Collections.emptyList()
                    , responseCode
                    , delay
                    , value
                    , 0);
            return this;
        }

        /**
         * remove Supported New Alert Category characteristic
         *
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> removeSupportedUnreadAlertCategory() {
            mSupportedUnreadAlertCategory = null;
            return this;
        }

        /**
         * add Unread Alert Status characteristic
         *
         * @param simpleAlertUnreadCount          Unread Count:Simple Alert
         * @param emailUnreadCount                Unread Count:Email
         * @param newsUnreadCount                 Unread Count:News
         * @param callUnreadCount                 Unread Count:Call
         * @param missedCallUnreadCount           Unread Count:Missed call
         * @param smsMmsUnreadCount               Unread Count:SMS/MMS
         * @param voiceMailUnreadCount            Unread Count:Voice mail
         * @param scheduleUnreadCount             Unread Count:Schedule
         * @param highPrioritizedAlertUnreadCount Unread Count:High Prioritized Alert
         * @param instantMessageAlertUnreadCount  Unread Count:Instant Message
         * @param descriptorResponseCode          descritptor response code for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 3rd parameter
         * @param descriptorDelay                 descritptor response delay(millis)
         * @param descriptorValue                 descriptor data array for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> addUnreadAlertStatus(int simpleAlertUnreadCount
                , int emailUnreadCount
                , int newsUnreadCount
                , int callUnreadCount
                , int missedCallUnreadCount
                , int smsMmsUnreadCount
                , int voiceMailUnreadCount
                , int scheduleUnreadCount
                , int highPrioritizedAlertUnreadCount
                , int instantMessageAlertUnreadCount
                , int descriptorResponseCode
                , long descriptorDelay
                , @NonNull byte[] descriptorValue) {
            mUnreadAlertStatus = new UnreadAlertStatusCharacteristicData(simpleAlertUnreadCount
                    , emailUnreadCount
                    , newsUnreadCount
                    , callUnreadCount
                    , missedCallUnreadCount
                    , smsMmsUnreadCount
                    , voiceMailUnreadCount
                    , scheduleUnreadCount
                    , highPrioritizedAlertUnreadCount
                    , instantMessageAlertUnreadCount
                    , Collections.singletonList(new DescriptorData(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR
                    , BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE
                    , descriptorResponseCode
                    , descriptorDelay
                    , descriptorValue)));
            return this;
        }

        /**
         * remove Unread Alert Status characteristic
         *
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> removeUnreadAlertStatus() {
            mUnreadAlertStatus = null;
            return this;
        }

        /**
         * add Alert Notification Control Point characteristic
         *
         * @param enableNewAlertNotificationResponseValue           characteristic response code for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter(Enable New Alert Notification response)
         * @param enableUnreadAlertStatusNotificationResponseValue  characteristic response code for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter(Enable Unread Alert Status Notification response)
         * @param disableNewAlertNotificationResponseValue          characteristic response code for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter(Disable New Alert Notification response)
         * @param disableUnreadAlertStatusNotificationResponseValue characteristic response code for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter(Disable Unread Alert Status Notification response)
         * @param notifyNewAlertImmediatelyResponseValue            characteristic response code for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter(Notify New Alert immediately response)
         * @param notifyUnreadAlertStatusImmediatelyResponseValue   characteristic response code for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter(Notify Unread Alert Status immediately response)
         * @param delay                                             response delay(millis)
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> addAlertNotificationControlPoint(int enableNewAlertNotificationResponseValue
                , int enableUnreadAlertStatusNotificationResponseValue
                , int disableNewAlertNotificationResponseValue
                , int disableUnreadAlertStatusNotificationResponseValue
                , int notifyNewAlertImmediatelyResponseValue
                , int notifyUnreadAlertStatusImmediatelyResponseValue
                , long delay) {
            mAlertNotificationControlPoint = new AlertNotificationControlPointCharacteristicData(
                    enableNewAlertNotificationResponseValue
                    , enableUnreadAlertStatusNotificationResponseValue
                    , disableNewAlertNotificationResponseValue
                    , disableUnreadAlertStatusNotificationResponseValue
                    , notifyNewAlertImmediatelyResponseValue
                    , notifyUnreadAlertStatusImmediatelyResponseValue
                    , delay
            );
            return this;
        }

        /**
         * remove Alert Notification Control Point characteristic
         *
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> removeAlertNotificationControlPoint() {
            mAlertNotificationControlPoint = null;
            return this;
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        @Override
        public MockData createMockData() {
            List<CharacteristicData> characteristicList = new ArrayList<>();

            if (mSupportedNewAlertCategory == null) {
                throw new RuntimeException("no Supported New Alert Category data");
            } else {
                characteristicList.add(mSupportedNewAlertCategory);
            }
            if (mNewAlert == null) {
                throw new RuntimeException("no New Alert data");
            } else {
                characteristicList.add(mNewAlert);
            }
            if (mSupportedUnreadAlertCategory == null) {
                throw new RuntimeException("no Supported Unread Alert Category data");
            } else {
                characteristicList.add(mSupportedUnreadAlertCategory);
            }
            if (mUnreadAlertStatus == null) {
                throw new RuntimeException("no Unread Alert Status data");
            } else {
                characteristicList.add(mUnreadAlertStatus);
            }
            if (mAlertNotificationControlPoint == null) {
                throw new RuntimeException("no Alert Notification Control Point data");
            } else {
                characteristicList.add(mAlertNotificationControlPoint);
            }

            ServiceData serviceData = new ServiceData(ALERT_NOTIFICATION_SERVICE, BluetoothGattService.SERVICE_TYPE_PRIMARY, characteristicList);
            return new MockData(Collections.singletonList(serviceData));
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        @Override
        public AlertNotificationServiceMockCallback build() {
            return new AlertNotificationServiceMockCallback(createMockData(), false);
        }
    }

    /**
     * New Alert status map
     */
    private final Map<Integer, Boolean> mNewAlertEnableMap = new HashMap<>();

    /**
     * Unread Alert status map
     */
    private final Map<Integer, Boolean> mUnreadAlertEnableMap = new HashMap<>();

    /**
     * @param mockData   {@link MockData} instance
     * @param isFallback fallback flag
     */
    public AlertNotificationServiceMockCallback(@NonNull MockData mockData, boolean isFallback) {
        super(mockData, isFallback);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onServerStopped() {
        mNewAlertEnableMap.clear();
        mUnreadAlertEnableMap.clear();
        super.onServerStopped();
    }

    /**
     * check supported category
     *
     * @param categoryId target category id
     * @param bitMask0   bitmask information from {@link SupportedNewAlertCategory#getCategoryIdBitMask0()} or {@link SupportedUnreadAlertCategory#getCategoryIdBitMask0()}
     * @param bitMask1   bitmask information from {@link SupportedNewAlertCategory#getCategoryIdBitMask1()} or {@link SupportedUnreadAlertCategory#getCategoryIdBitMask1()}
     * @return {@code true}:supported, {@code false}:not supported
     */
    protected boolean isCategorySupported(int categoryId, int bitMask0, int bitMask1) {
        return AlertNotificationCategoryIdUtils.isCategoryIdSimpleAlert(categoryId) && AlertCategoryIdBitMaskUtils.isCategoryIdBitMask0SimpleAlertSupported(bitMask0)
                || AlertNotificationCategoryIdUtils.isCategoryIdEmail(categoryId) && AlertCategoryIdBitMaskUtils.isCategoryIdBitMask0EmailSupported(bitMask0)
                || AlertNotificationCategoryIdUtils.isCategoryIdNews(categoryId) && AlertCategoryIdBitMaskUtils.isCategoryIdBitMask0NewsSupported(bitMask0)
                || AlertNotificationCategoryIdUtils.isCategoryIdCall(categoryId) && AlertCategoryIdBitMaskUtils.isCategoryIdBitMask0CallSupported(bitMask0)
                || AlertNotificationCategoryIdUtils.isCategoryIdMissedCall(categoryId) && AlertCategoryIdBitMaskUtils.isCategoryIdBitMask0CallSupported(bitMask0)
                || AlertNotificationCategoryIdUtils.isCategoryIdSmsMms(categoryId) && AlertCategoryIdBitMaskUtils.isCategoryIdBitMask0SmsMmsSupported(bitMask0)
                || AlertNotificationCategoryIdUtils.isCategoryIdVoiceMail(categoryId) && AlertCategoryIdBitMaskUtils.isCategoryIdBitMask0VoiceMailSupported(bitMask0)
                || AlertNotificationCategoryIdUtils.isCategoryIdSchedule(categoryId) && AlertCategoryIdBitMaskUtils.isCategoryIdBitMask0ScheduleSupported(bitMask0)
                || AlertNotificationCategoryIdUtils.isCategoryIdHighPrioritizedAlert(categoryId) && AlertCategoryIdBitMaskUtils.isCategoryIdBitMask1HighPrioritizedAlertSupported(bitMask1)
                || AlertNotificationCategoryIdUtils.isCategoryIdInstantMessage(categoryId) && AlertCategoryIdBitMaskUtils.isCategoryIdBitMask1InstantMessageAlertSupported(bitMask1)
                || AlertNotificationCategoryIdUtils.isCategoryIdAll(categoryId);
    }

    /**
     * {@inheritDoc}
     */
    @SuppressLint("MissingPermission")
    @Override
    public synchronized boolean onCharacteristicWriteRequest(@NonNull BLEServerConnection bleServerConnection, @NonNull BluetoothDevice device, int requestId, @NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic, boolean preparedWrite, boolean responseNeeded, int offset, @NonNull byte[] value, boolean force) {
        boolean result = false;
        BluetoothGattServer bluetoothGattServer = bleServerConnection.getBluetoothGattServer();

        if (bluetoothGattServer != null) {
            UUID characteristicUUID = bluetoothGattCharacteristic.getUuid();
            if (ALERT_NOTIFICATION_CONTROL_POINT_CHARACTERISTIC.equals(characteristicUUID)) {
                long now = SystemClock.elapsedRealtime();
                BluetoothGattService bluetoothGattService = bluetoothGattCharacteristic.getService();
                UUID serviceUUID = bluetoothGattService.getUuid();
                int serviceInstanceId = bluetoothGattService.getInstanceId();
                Map<Pair<UUID, Integer>, CharacteristicData> characteristicMap = mRemappedServiceCharacteristicMap.get(Pair.create(serviceUUID, serviceInstanceId));
                if (characteristicMap == null) {
                    if (force && responseNeeded) {
                        result = bluetoothGattServer.sendResponse(device, requestId, APPLICATION_ERROR_9F, offset, null);
                    }
                } else {
                    int characteristicInstanceId = bluetoothGattCharacteristic.getInstanceId();
                    CharacteristicData characteristicData = characteristicMap.get(Pair.create(characteristicUUID, characteristicInstanceId));
                    if (characteristicData instanceof AlertNotificationControlPointCharacteristicData) {
                        AlertNotificationControlPointCharacteristicData alertNotificationControlPointCharacteristicData = (AlertNotificationControlPointCharacteristicData) characteristicData;
                        AlertNotificationControlPoint alertNotificationControlPoint = new AlertNotificationControlPoint(value);
                        SupportedNewAlertCategory supportedNewAlertCategory = null;
                        SupportedUnreadAlertCategory supportedUnreadAlertCategory = null;
                        for (Map.Entry<Pair<UUID, Integer>, CharacteristicData> entry : characteristicMap.entrySet()) {
                            if (SUPPORTED_NEW_ALERT_CATEGORY_CHARACTERISTIC.equals(entry.getKey().first)) {
                                supportedNewAlertCategory = new SupportedNewAlertCategory(entry.getValue().getBytes());
                            } else if (SUPPORTED_UNREAD_ALERT_CATEGORY_CHARACTERISTIC.equals(entry.getKey().first)) {
                                supportedUnreadAlertCategory = new SupportedUnreadAlertCategory(entry.getValue().getBytes());
                            }
                        }

                        int responseCode;
                        if (alertNotificationControlPoint.isCommandIdEnableNewIncomingAlertNotification()) {
                            if (supportedNewAlertCategory != null && isCategorySupported(alertNotificationControlPoint.getCategoryId(), supportedNewAlertCategory.getCategoryIdBitMask0(), supportedNewAlertCategory.getCategoryIdBitMask1())) {
                                responseCode = alertNotificationControlPointCharacteristicData.enableNewAlertNotificationResponseValue;
                            } else {
                                responseCode = COMMAND_NOT_SUPPORTED;
                            }
                        } else if (alertNotificationControlPoint.isCommandIdEnableUnreadCategoryStatusNotification()) {
                            if (supportedUnreadAlertCategory != null && isCategorySupported(alertNotificationControlPoint.getCategoryId(), supportedUnreadAlertCategory.getCategoryIdBitMask0(), supportedUnreadAlertCategory.getCategoryIdBitMask1())) {
                                responseCode = alertNotificationControlPointCharacteristicData.enableUnreadAlertStatusNotificationResponseValue;
                            } else {
                                responseCode = COMMAND_NOT_SUPPORTED;
                            }
                        } else if (alertNotificationControlPoint.isCommandIdDisableNewIncomingAlertNotification()) {
                            if (supportedNewAlertCategory != null && isCategorySupported(alertNotificationControlPoint.getCategoryId(), supportedNewAlertCategory.getCategoryIdBitMask0(), supportedNewAlertCategory.getCategoryIdBitMask1())) {
                                responseCode = alertNotificationControlPointCharacteristicData.disableNewAlertNotificationResponseValue;
                            } else {
                                responseCode = COMMAND_NOT_SUPPORTED;
                            }
                        } else if (alertNotificationControlPoint.isCommandIdDisableeUnreadCategoryStatusNotification()) {
                            if (supportedUnreadAlertCategory != null && isCategorySupported(alertNotificationControlPoint.getCategoryId(), supportedUnreadAlertCategory.getCategoryIdBitMask0(), supportedUnreadAlertCategory.getCategoryIdBitMask1())) {
                                responseCode = alertNotificationControlPointCharacteristicData.disableUnreadAlertStatusNotificationResponseValue;
                            } else {
                                responseCode = COMMAND_NOT_SUPPORTED;
                            }
                        } else if (alertNotificationControlPoint.isCommandIdNotifyNewIncomingAlertImmediately()) {
                            responseCode = alertNotificationControlPointCharacteristicData.notifyNewAlertImmediatelyResponseValue;
                        } else if (alertNotificationControlPoint.isCommandIdNotifyUnreadCategoryStatusImmediately()) {
                            responseCode = alertNotificationControlPointCharacteristicData.notifyUnreadAlertStatusImmediatelyResponseValue;
                        } else {
                            responseCode = COMMAND_NOT_SUPPORTED;
                        }
                        delay(now, alertNotificationControlPointCharacteristicData.delay);

                        if (responseNeeded) {
                            result = bluetoothGattServer.sendResponse(device, requestId, responseCode, offset, preparedWrite ? value : null);
                        } else {
                            result = true;
                        }

                        if (result && BluetoothGatt.GATT_SUCCESS == responseCode) {
                            int categoryId = alertNotificationControlPoint.getCategoryId();
                            if (alertNotificationControlPoint.isCommandIdEnableNewIncomingAlertNotification()) {
                                if (AlertNotificationCategoryIdUtils.isCategoryIdAll(categoryId)) {
                                    if (supportedNewAlertCategory != null) {
                                        if (isCategorySupported(AlertNotificationCategoryIdUtils.CATEGORY_ID_SIMPLE_ALERT, supportedNewAlertCategory.getCategoryIdBitMask0(), supportedNewAlertCategory.getCategoryIdBitMask1())) {
                                            mNewAlertEnableMap.put(AlertNotificationCategoryIdUtils.CATEGORY_ID_SIMPLE_ALERT, true);
                                        }
                                        if (isCategorySupported(AlertNotificationCategoryIdUtils.CATEGORY_ID_EMAIL, supportedNewAlertCategory.getCategoryIdBitMask0(), supportedNewAlertCategory.getCategoryIdBitMask1())) {
                                            mNewAlertEnableMap.put(AlertNotificationCategoryIdUtils.CATEGORY_ID_EMAIL, true);
                                        }
                                        if (isCategorySupported(AlertNotificationCategoryIdUtils.CATEGORY_ID_NEWS, supportedNewAlertCategory.getCategoryIdBitMask0(), supportedNewAlertCategory.getCategoryIdBitMask1())) {
                                            mNewAlertEnableMap.put(AlertNotificationCategoryIdUtils.CATEGORY_ID_NEWS, true);
                                        }
                                        if (isCategorySupported(AlertNotificationCategoryIdUtils.CATEGORY_ID_CALL, supportedNewAlertCategory.getCategoryIdBitMask0(), supportedNewAlertCategory.getCategoryIdBitMask1())) {
                                            mNewAlertEnableMap.put(AlertNotificationCategoryIdUtils.CATEGORY_ID_CALL, true);
                                        }
                                        if (isCategorySupported(AlertNotificationCategoryIdUtils.CATEGORY_ID_MISSED_CALL, supportedNewAlertCategory.getCategoryIdBitMask0(), supportedNewAlertCategory.getCategoryIdBitMask1())) {
                                            mNewAlertEnableMap.put(AlertNotificationCategoryIdUtils.CATEGORY_ID_MISSED_CALL, true);
                                        }
                                        if (isCategorySupported(AlertNotificationCategoryIdUtils.CATEGORY_ID_SMS_MMS, supportedNewAlertCategory.getCategoryIdBitMask0(), supportedNewAlertCategory.getCategoryIdBitMask1())) {
                                            mNewAlertEnableMap.put(AlertNotificationCategoryIdUtils.CATEGORY_ID_SMS_MMS, true);
                                        }
                                        if (isCategorySupported(AlertNotificationCategoryIdUtils.CATEGORY_ID_VOICE_MAIL, supportedNewAlertCategory.getCategoryIdBitMask0(), supportedNewAlertCategory.getCategoryIdBitMask1())) {
                                            mNewAlertEnableMap.put(AlertNotificationCategoryIdUtils.CATEGORY_ID_VOICE_MAIL, true);
                                        }
                                        if (isCategorySupported(AlertNotificationCategoryIdUtils.CATEGORY_ID_SCHEDULE, supportedNewAlertCategory.getCategoryIdBitMask0(), supportedNewAlertCategory.getCategoryIdBitMask1())) {
                                            mNewAlertEnableMap.put(AlertNotificationCategoryIdUtils.CATEGORY_ID_SCHEDULE, true);
                                        }
                                        if (isCategorySupported(AlertNotificationCategoryIdUtils.CATEGORY_ID_HIGH_PRIORITIZED_ALERT, supportedNewAlertCategory.getCategoryIdBitMask0(), supportedNewAlertCategory.getCategoryIdBitMask1())) {
                                            mNewAlertEnableMap.put(AlertNotificationCategoryIdUtils.CATEGORY_ID_HIGH_PRIORITIZED_ALERT, true);
                                        }
                                        if (isCategorySupported(AlertNotificationCategoryIdUtils.CATEGORY_ID_INSTANT_MESSAGE, supportedNewAlertCategory.getCategoryIdBitMask0(), supportedNewAlertCategory.getCategoryIdBitMask1())) {
                                            mNewAlertEnableMap.put(AlertNotificationCategoryIdUtils.CATEGORY_ID_INSTANT_MESSAGE, true);
                                        }
                                    }
                                } else {
                                    mNewAlertEnableMap.put(categoryId, true);
                                }
                            } else if (alertNotificationControlPoint.isCommandIdEnableUnreadCategoryStatusNotification()) {
                                if (AlertNotificationCategoryIdUtils.isCategoryIdAll(categoryId)) {
                                    if (supportedUnreadAlertCategory != null) {
                                        if (isCategorySupported(AlertNotificationCategoryIdUtils.CATEGORY_ID_SIMPLE_ALERT, supportedUnreadAlertCategory.getCategoryIdBitMask0(), supportedUnreadAlertCategory.getCategoryIdBitMask1())) {
                                            mUnreadAlertEnableMap.put(AlertNotificationCategoryIdUtils.CATEGORY_ID_SIMPLE_ALERT, true);
                                        }
                                        if (isCategorySupported(AlertNotificationCategoryIdUtils.CATEGORY_ID_EMAIL, supportedUnreadAlertCategory.getCategoryIdBitMask0(), supportedUnreadAlertCategory.getCategoryIdBitMask1())) {
                                            mUnreadAlertEnableMap.put(AlertNotificationCategoryIdUtils.CATEGORY_ID_EMAIL, true);
                                        }
                                        if (isCategorySupported(AlertNotificationCategoryIdUtils.CATEGORY_ID_NEWS, supportedUnreadAlertCategory.getCategoryIdBitMask0(), supportedUnreadAlertCategory.getCategoryIdBitMask1())) {
                                            mUnreadAlertEnableMap.put(AlertNotificationCategoryIdUtils.CATEGORY_ID_NEWS, true);
                                        }
                                        if (isCategorySupported(AlertNotificationCategoryIdUtils.CATEGORY_ID_CALL, supportedUnreadAlertCategory.getCategoryIdBitMask0(), supportedUnreadAlertCategory.getCategoryIdBitMask1())) {
                                            mUnreadAlertEnableMap.put(AlertNotificationCategoryIdUtils.CATEGORY_ID_CALL, true);
                                        }
                                        if (isCategorySupported(AlertNotificationCategoryIdUtils.CATEGORY_ID_MISSED_CALL, supportedUnreadAlertCategory.getCategoryIdBitMask0(), supportedUnreadAlertCategory.getCategoryIdBitMask1())) {
                                            mUnreadAlertEnableMap.put(AlertNotificationCategoryIdUtils.CATEGORY_ID_MISSED_CALL, true);
                                        }
                                        if (isCategorySupported(AlertNotificationCategoryIdUtils.CATEGORY_ID_SMS_MMS, supportedUnreadAlertCategory.getCategoryIdBitMask0(), supportedUnreadAlertCategory.getCategoryIdBitMask1())) {
                                            mUnreadAlertEnableMap.put(AlertNotificationCategoryIdUtils.CATEGORY_ID_SMS_MMS, true);
                                        }
                                        if (isCategorySupported(AlertNotificationCategoryIdUtils.CATEGORY_ID_VOICE_MAIL, supportedUnreadAlertCategory.getCategoryIdBitMask0(), supportedUnreadAlertCategory.getCategoryIdBitMask1())) {
                                            mUnreadAlertEnableMap.put(AlertNotificationCategoryIdUtils.CATEGORY_ID_VOICE_MAIL, true);
                                        }
                                        if (isCategorySupported(AlertNotificationCategoryIdUtils.CATEGORY_ID_SCHEDULE, supportedUnreadAlertCategory.getCategoryIdBitMask0(), supportedUnreadAlertCategory.getCategoryIdBitMask1())) {
                                            mUnreadAlertEnableMap.put(AlertNotificationCategoryIdUtils.CATEGORY_ID_SCHEDULE, true);
                                        }
                                        if (isCategorySupported(AlertNotificationCategoryIdUtils.CATEGORY_ID_HIGH_PRIORITIZED_ALERT, supportedUnreadAlertCategory.getCategoryIdBitMask0(), supportedUnreadAlertCategory.getCategoryIdBitMask1())) {
                                            mUnreadAlertEnableMap.put(AlertNotificationCategoryIdUtils.CATEGORY_ID_HIGH_PRIORITIZED_ALERT, true);
                                        }
                                        if (isCategorySupported(AlertNotificationCategoryIdUtils.CATEGORY_ID_INSTANT_MESSAGE, supportedUnreadAlertCategory.getCategoryIdBitMask0(), supportedUnreadAlertCategory.getCategoryIdBitMask1())) {
                                            mUnreadAlertEnableMap.put(AlertNotificationCategoryIdUtils.CATEGORY_ID_INSTANT_MESSAGE, true);
                                        }
                                    }
                                } else {
                                    mUnreadAlertEnableMap.put(categoryId, true);
                                }
                            } else if (alertNotificationControlPoint.isCommandIdDisableNewIncomingAlertNotification()) {
                                if (AlertNotificationCategoryIdUtils.isCategoryIdAll(categoryId)) {
                                    mNewAlertEnableMap.clear();
                                } else {
                                    mNewAlertEnableMap.remove(categoryId);
                                }
                            } else if (alertNotificationControlPoint.isCommandIdDisableeUnreadCategoryStatusNotification()) {
                                if (AlertNotificationCategoryIdUtils.isCategoryIdAll(categoryId)) {
                                    mUnreadAlertEnableMap.clear();
                                } else {
                                    mUnreadAlertEnableMap.remove(categoryId);
                                }
                            } else if (alertNotificationControlPoint.isCommandIdNotifyNewIncomingAlertImmediately()) {
                                for (Map.Entry<Pair<UUID, Integer>, CharacteristicData> characteristicDataEntry : characteristicMap.entrySet()) {
                                    Pair<UUID, Integer> characteristicDataEntryKey = characteristicDataEntry.getKey();
                                    if (NEW_ALERT_CHARACTERISTIC.equals(characteristicDataEntryKey.first)) {
                                        Map<Pair<UUID, Integer>, DescriptorData> descriptorDataMap = mRemappedCharacteristicDescriptorMap.get(characteristicDataEntryKey);
                                        if (descriptorDataMap != null) {
                                            for (Map.Entry<Pair<UUID, Integer>, DescriptorData> descriptorDataEntry : descriptorDataMap.entrySet()) {
                                                if (CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR.equals(descriptorDataEntry.getKey().first)) {
                                                    Bundle argument = new Bundle();
                                                    argument.putInt(KEY_CATEGORY_ID, categoryId);
                                                    startNotification(null, bleServerConnection, device, serviceUUID, serviceInstanceId, characteristicDataEntryKey.first, characteristicDataEntryKey.second, descriptorDataEntry.getKey().second, NOTIFICATION_INTERVAL, 1, argument);
                                                    break;
                                                }
                                            }
                                        }
                                        break;
                                    }
                                }
                            } else if (alertNotificationControlPoint.isCommandIdNotifyUnreadCategoryStatusImmediately()) {
                                for (Map.Entry<Pair<UUID, Integer>, CharacteristicData> characteristicDataEntry : characteristicMap.entrySet()) {
                                    Pair<UUID, Integer> characteristicDataEntryKey = characteristicDataEntry.getKey();
                                    if (UNREAD_ALERT_STATUS_CHARACTERISTIC.equals(characteristicDataEntryKey.first)) {
                                        Map<Pair<UUID, Integer>, DescriptorData> descriptorDataMap = mRemappedCharacteristicDescriptorMap.get(characteristicDataEntryKey);
                                        if (descriptorDataMap != null) {
                                            for (Map.Entry<Pair<UUID, Integer>, DescriptorData> descriptorDataEntry : descriptorDataMap.entrySet()) {
                                                if (CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR.equals(descriptorDataEntry.getKey().first)) {
                                                    Bundle argument = new Bundle();
                                                    argument.putInt(KEY_CATEGORY_ID, categoryId);
                                                    startNotification(null, bleServerConnection, device, serviceUUID, serviceInstanceId, characteristicDataEntryKey.first, characteristicDataEntryKey.second, descriptorDataEntry.getKey().second, NOTIFICATION_INTERVAL, 1, argument);
                                                    break;
                                                }
                                            }
                                        }
                                        break;
                                    }
                                }
                            }
                        }
                    }

                    if (force && !result && responseNeeded) {
                        result = bluetoothGattServer.sendResponse(device, requestId, APPLICATION_ERROR_9F, offset, null);
                    }
                }
            } else {
                result = super.onCharacteristicWriteRequest(bleServerConnection, device, requestId, bluetoothGattCharacteristic, preparedWrite, responseNeeded, offset, value, force);
            }
        }
        return result;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected synchronized void startNotification(@Nullable Integer taskId, @NonNull BLEServerConnection bleServerConnection, @Nullable BluetoothDevice device, @NonNull UUID serviceUUID, int serviceInstanceId, @NonNull UUID characteristicUUID, int characteristicInstanceId, int descriptorInstanceId, long delay, @Nullable Integer notificationCount, @Nullable Bundle argument) {
        if (NEW_ALERT_CHARACTERISTIC.equals(characteristicUUID) && argument != null && argument.containsKey(KEY_CATEGORY_ID)) {
            Map<Pair<UUID, Integer>, CharacteristicData> characteristicMap = mRemappedServiceCharacteristicMap.get(Pair.create(serviceUUID, serviceInstanceId));
            if (characteristicMap != null) {
                CharacteristicData characteristicData = characteristicMap.get(Pair.create(characteristicUUID, characteristicInstanceId));
                if (characteristicData instanceof NewAlertCharacteristicData) {
                    int targetNotificationCount = notificationCount == null ? characteristicData.notificationCount : notificationCount;
                    if (targetNotificationCount != 0) {
                        final NewAlertCharacteristicData newAlertCharacteristicData = (NewAlertCharacteristicData) characteristicData;
                        Bundle bundle = new Bundle();
                        bundle.putInt(KEY_NOTIFICATION_COUNT, notificationCount == null ? newAlertCharacteristicData.notificationCount : notificationCount);
                        bundle.putInt(KEY_DESCRIPTOR_INSTANCE_ID, descriptorInstanceId);
                        bundle.putBundle(KEY_ORIGINAL_ARGUMENT, argument);

                        Boolean isConfirm = null;
                        Map<Pair<UUID, Integer>, DescriptorData> descriptorDataMap = mRemappedCharacteristicDescriptorMap.get(Pair.create(characteristicUUID, characteristicInstanceId));
                        if (descriptorDataMap != null) {
                            DescriptorData descriptorData = descriptorDataMap.get(Pair.create(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, descriptorInstanceId));
                            if (descriptorData != null) {
                                if ((newAlertCharacteristicData.property & BluetoothGattCharacteristic.PROPERTY_NOTIFY) != 0 && Arrays.equals(BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE, descriptorData.getBytes())) {
                                    isConfirm = false;
                                } else if ((newAlertCharacteristicData.property & BluetoothGattCharacteristic.PROPERTY_INDICATE) != 0 && Arrays.equals(BluetoothGattDescriptor.ENABLE_INDICATION_VALUE, descriptorData.getBytes())) {
                                    isConfirm = true;
                                }
                            }
                        }

                        if (isConfirm != null) {
                            int categoryId = argument.getInt(KEY_CATEGORY_ID);
                            List<NewAlert> newAlertList = new LinkedList<>();
                            for (Map.Entry<Integer, Boolean> entry : mNewAlertEnableMap.entrySet()) {
                                final int currentCategoryId = entry.getKey();
                                if ((AlertNotificationCategoryIdUtils.isCategoryIdAll(categoryId) || categoryId == currentCategoryId) && entry.getValue()) {
                                    if (entry.getValue()) {
                                        if (AlertNotificationCategoryIdUtils.isCategoryIdSimpleAlert(currentCategoryId)) {
                                            newAlertList.add(new NewAlert(currentCategoryId, newAlertCharacteristicData.simpleAlertNumberOfNewAlert, newAlertCharacteristicData.simpleAlertTextStringInformation));
                                        } else if (AlertNotificationCategoryIdUtils.isCategoryIdEmail(currentCategoryId)) {
                                            newAlertList.add(new NewAlert(currentCategoryId, newAlertCharacteristicData.emailNumberOfNewAlert, newAlertCharacteristicData.emailTextStringInformation));
                                        } else if (AlertNotificationCategoryIdUtils.isCategoryIdNews(currentCategoryId)) {
                                            newAlertList.add(new NewAlert(currentCategoryId, newAlertCharacteristicData.newsNumberOfNewAlert, newAlertCharacteristicData.newsTextStringInformation));
                                        } else if (AlertNotificationCategoryIdUtils.isCategoryIdCall(currentCategoryId)) {
                                            newAlertList.add(new NewAlert(currentCategoryId, newAlertCharacteristicData.callNumberOfNewAlert, newAlertCharacteristicData.callTextStringInformation));
                                        } else if (AlertNotificationCategoryIdUtils.isCategoryIdMissedCall(currentCategoryId)) {
                                            newAlertList.add(new NewAlert(currentCategoryId, newAlertCharacteristicData.missedCallNumberOfNewAlert, newAlertCharacteristicData.missedCallTextStringInformation));
                                        } else if (AlertNotificationCategoryIdUtils.isCategoryIdSmsMms(currentCategoryId)) {
                                            newAlertList.add(new NewAlert(currentCategoryId, newAlertCharacteristicData.smsMmsNumberOfNewAlert, newAlertCharacteristicData.smsMmsTextStringInformation));
                                        } else if (AlertNotificationCategoryIdUtils.isCategoryIdVoiceMail(currentCategoryId)) {
                                            newAlertList.add(new NewAlert(currentCategoryId, newAlertCharacteristicData.voiceMailNumberOfNewAlert, newAlertCharacteristicData.voiceMailTextStringInformation));
                                        } else if (AlertNotificationCategoryIdUtils.isCategoryIdSchedule(currentCategoryId)) {
                                            newAlertList.add(new NewAlert(currentCategoryId, newAlertCharacteristicData.scheduleNumberOfNewAlert, newAlertCharacteristicData.scheduleTextStringInformation));
                                        } else if (AlertNotificationCategoryIdUtils.isCategoryIdHighPrioritizedAlert(currentCategoryId)) {
                                            newAlertList.add(new NewAlert(currentCategoryId, newAlertCharacteristicData.highPrioritizedAlertNumberOfNewAlert, newAlertCharacteristicData.highPrioritizedAlertTextStringInformation));
                                        } else if (AlertNotificationCategoryIdUtils.isCategoryIdInstantMessage(currentCategoryId)) {
                                            newAlertList.add(new NewAlert(currentCategoryId, newAlertCharacteristicData.instantMessageAlertNumberOfNewAlert, newAlertCharacteristicData.instantMessageTextStringInformation));
                                        }
                                    }
                                }
                            }
                            for (NewAlert newAlert : newAlertList) {
                                if (device == null) {
                                    for (BluetoothDevice bluetoothDevice : mConnectedDeviceSet) {
                                        bleServerConnection.createNotificationTask(bluetoothDevice
                                                , serviceUUID
                                                , serviceInstanceId
                                                , characteristicUUID
                                                , characteristicInstanceId
                                                , newAlert
                                                , isConfirm
                                                , NotificationTask.TIMEOUT_MILLIS
                                                , delay
                                                , bundle
                                                , this);
                                    }
                                } else {
                                    if (mConnectedDeviceSet.contains(device)) {
                                        bleServerConnection.createNotificationTask(device
                                                , serviceUUID
                                                , serviceInstanceId
                                                , characteristicUUID
                                                , characteristicInstanceId
                                                , newAlert
                                                , isConfirm
                                                , NotificationTask.TIMEOUT_MILLIS
                                                , delay
                                                , bundle
                                                , this);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } else if (UNREAD_ALERT_STATUS_CHARACTERISTIC.equals(characteristicUUID) && argument != null && argument.containsKey(KEY_CATEGORY_ID)) {
            Map<Pair<UUID, Integer>, CharacteristicData> characteristicMap = mRemappedServiceCharacteristicMap.get(Pair.create(serviceUUID, serviceInstanceId));
            if (characteristicMap != null) {
                CharacteristicData characteristicData = characteristicMap.get(Pair.create(characteristicUUID, characteristicInstanceId));
                if (characteristicData instanceof UnreadAlertStatusCharacteristicData) {
                    int targetNotificationCount = notificationCount == null ? characteristicData.notificationCount : notificationCount;
                    if (targetNotificationCount != 0) {
                        final UnreadAlertStatusCharacteristicData unreadAlertStatusCharacteristicData = (UnreadAlertStatusCharacteristicData) characteristicData;
                        Bundle bundle = new Bundle();
                        bundle.putInt(KEY_NOTIFICATION_COUNT, notificationCount == null ? unreadAlertStatusCharacteristicData.notificationCount : notificationCount);
                        bundle.putInt(KEY_DESCRIPTOR_INSTANCE_ID, descriptorInstanceId);
                        bundle.putBundle(KEY_ORIGINAL_ARGUMENT, argument);

                        Boolean isConfirm = null;
                        Map<Pair<UUID, Integer>, DescriptorData> descriptorDataMap = mRemappedCharacteristicDescriptorMap.get(Pair.create(characteristicUUID, characteristicInstanceId));
                        if (descriptorDataMap != null) {
                            DescriptorData descriptorData = descriptorDataMap.get(Pair.create(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, descriptorInstanceId));
                            if (descriptorData != null) {
                                if ((unreadAlertStatusCharacteristicData.property & BluetoothGattCharacteristic.PROPERTY_NOTIFY) != 0 && Arrays.equals(BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE, descriptorData.getBytes())) {
                                    isConfirm = false;
                                } else if ((unreadAlertStatusCharacteristicData.property & BluetoothGattCharacteristic.PROPERTY_INDICATE) != 0 && Arrays.equals(BluetoothGattDescriptor.ENABLE_INDICATION_VALUE, descriptorData.getBytes())) {
                                    isConfirm = true;
                                }
                            }
                        }

                        if (isConfirm != null) {
                            int categoryId = argument.getInt(KEY_CATEGORY_ID);
                            List<UnreadAlertStatus> unreadAlertStatusList = new LinkedList<>();
                            for (Map.Entry<Integer, Boolean> entry : mUnreadAlertEnableMap.entrySet()) {
                                final int currentCategoryId = entry.getKey();
                                if ((AlertNotificationCategoryIdUtils.isCategoryIdAll(categoryId) || categoryId == currentCategoryId) && entry.getValue()) {
                                    if (entry.getValue()) {
                                        if (AlertNotificationCategoryIdUtils.isCategoryIdSimpleAlert(currentCategoryId)) {
                                            unreadAlertStatusList.add(new UnreadAlertStatus(currentCategoryId, unreadAlertStatusCharacteristicData.simpleAlertUnreadCount));
                                        } else if (AlertNotificationCategoryIdUtils.isCategoryIdEmail(currentCategoryId)) {
                                            unreadAlertStatusList.add(new UnreadAlertStatus(currentCategoryId, unreadAlertStatusCharacteristicData.emailUnreadCount));
                                        } else if (AlertNotificationCategoryIdUtils.isCategoryIdNews(currentCategoryId)) {
                                            unreadAlertStatusList.add(new UnreadAlertStatus(currentCategoryId, unreadAlertStatusCharacteristicData.newsUnreadCount));
                                        } else if (AlertNotificationCategoryIdUtils.isCategoryIdCall(currentCategoryId)) {
                                            unreadAlertStatusList.add(new UnreadAlertStatus(currentCategoryId, unreadAlertStatusCharacteristicData.callUnreadCount));
                                        } else if (AlertNotificationCategoryIdUtils.isCategoryIdMissedCall(currentCategoryId)) {
                                            unreadAlertStatusList.add(new UnreadAlertStatus(currentCategoryId, unreadAlertStatusCharacteristicData.missedCallUnreadCount));
                                        } else if (AlertNotificationCategoryIdUtils.isCategoryIdSmsMms(currentCategoryId)) {
                                            unreadAlertStatusList.add(new UnreadAlertStatus(currentCategoryId, unreadAlertStatusCharacteristicData.smsMmsUnreadCount));
                                        } else if (AlertNotificationCategoryIdUtils.isCategoryIdVoiceMail(currentCategoryId)) {
                                            unreadAlertStatusList.add(new UnreadAlertStatus(currentCategoryId, unreadAlertStatusCharacteristicData.voiceMailUnreadCount));
                                        } else if (AlertNotificationCategoryIdUtils.isCategoryIdSchedule(currentCategoryId)) {
                                            unreadAlertStatusList.add(new UnreadAlertStatus(currentCategoryId, unreadAlertStatusCharacteristicData.scheduleUnreadCount));
                                        } else if (AlertNotificationCategoryIdUtils.isCategoryIdHighPrioritizedAlert(currentCategoryId)) {
                                            unreadAlertStatusList.add(new UnreadAlertStatus(currentCategoryId, unreadAlertStatusCharacteristicData.highPrioritizedAlertUnreadCount));
                                        } else if (AlertNotificationCategoryIdUtils.isCategoryIdInstantMessage(currentCategoryId)) {
                                            unreadAlertStatusList.add(new UnreadAlertStatus(currentCategoryId, unreadAlertStatusCharacteristicData.instantMessageAlertUnreadCount));
                                        }
                                    }
                                }
                            }
                            for (UnreadAlertStatus unreadAlertStatus : unreadAlertStatusList) {
                                if (device == null) {
                                    for (BluetoothDevice bluetoothDevice : mConnectedDeviceSet) {
                                        bleServerConnection.createNotificationTask(bluetoothDevice
                                                , serviceUUID
                                                , serviceInstanceId
                                                , characteristicUUID
                                                , characteristicInstanceId
                                                , unreadAlertStatus
                                                , isConfirm
                                                , NotificationTask.TIMEOUT_MILLIS
                                                , delay
                                                , bundle
                                                , this);
                                    }
                                } else {
                                    if (mConnectedDeviceSet.contains(device)) {
                                        bleServerConnection.createNotificationTask(device
                                                , serviceUUID
                                                , serviceInstanceId
                                                , characteristicUUID
                                                , characteristicInstanceId
                                                , unreadAlertStatus
                                                , isConfirm
                                                , NotificationTask.TIMEOUT_MILLIS
                                                , delay
                                                , bundle
                                                , this);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } else {
            super.startNotification(taskId, bleServerConnection, device, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorInstanceId, delay, notificationCount, argument);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onServiceAddFailed(@NonNull Integer taskId, @NonNull BLEServerConnection bleServerConnection, @NonNull BluetoothGattService bluetoothGattService, int status, @Nullable Bundle argument) {
        // do nothing
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onServiceAddTimeout(@NonNull Integer taskId, @NonNull BLEServerConnection bleServerConnection, @NonNull BluetoothGattService bluetoothGattService, long timeout, @Nullable Bundle argument) {
        // do nothing
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onServiceRemoveFailed(@NonNull Integer taskId, @NonNull BLEServerConnection bleServerConnection, @NonNull BluetoothGattService bluetoothGattService, int status, @Nullable Bundle argument) {
        // do nothing
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onServiceRemoveTimeout(@NonNull Integer taskId, @NonNull BLEServerConnection bleServerConnection, @NonNull BluetoothGattService bluetoothGattService, long timeout, @Nullable Bundle argument) {
        // do nothing
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onAdvertisingStartSuccess(@NonNull AdvertiseSettings advertiseSettings) {
        // do nothing
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onAdvertisingStartFailed(@Nullable Integer errorCode) {
        // do nothing
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onAdvertisingFinished() {
        // do nothing
    }

}
