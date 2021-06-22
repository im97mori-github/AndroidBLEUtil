package org.im97mori.ble.profile.anp.peripheral;

import android.bluetooth.BluetoothGatt;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.im97mori.ble.characteristic.u2a47.SupportedNewAlertCategory;
import org.im97mori.ble.characteristic.u2a48.SupportedUnreadAlertCategory;
import org.im97mori.ble.profile.peripheral.AbstractProfileMockCallback;
import org.im97mori.ble.service.ans.peripheral.AlertNotificationServiceMockCallback;

import java.util.UUID;

import static org.im97mori.ble.constants.ServiceUUID.ALERT_NOTIFICATION_SERVICE;

/**
 * Alert Notification Profile for Peripheral
 */
public class AlertNotificationProfileMockCallback extends AbstractProfileMockCallback {

    /**
     * Builder for {@link AlertNotificationProfileMockCallback}
     *
     * @param <T> subclass of {@link AlertNotificationProfileMockCallback}
     */
    public static class Builder<T extends AlertNotificationProfileMockCallback> {

        /**
         * {@link Context} instance
         */
        protected final Context mContext;

        /**
         * {@link org.im97mori.ble.service.ans.peripheral.AlertNotificationServiceMockCallback.Builder} instance
         */
        protected final AlertNotificationServiceMockCallback.Builder<? extends AlertNotificationServiceMockCallback> mAlertNotificationServiceMockCallbackBuilder;

        /**
         * @param context                                     {@link Context} instance
         * @param deviceInformationServiceMockCallbackBuilder {@link org.im97mori.ble.service.ans.peripheral.AlertNotificationServiceMockCallback.Builder} instance
         */
        public Builder(@NonNull Context context
                , @NonNull AlertNotificationServiceMockCallback.Builder<? extends AlertNotificationServiceMockCallback> deviceInformationServiceMockCallbackBuilder) {
            mContext = context;
            mAlertNotificationServiceMockCallbackBuilder = deviceInformationServiceMockCallbackBuilder;
        }

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
         * @see org.im97mori.ble.service.ans.peripheral.AlertNotificationServiceMockCallback.Builder#addSupportedNewAlertCategory(int, long, byte[])
         */
        @NonNull
        public Builder<T> addSupportedNewAlertCategory(int responseCode, long delay, @NonNull byte[] value) {
            mAlertNotificationServiceMockCallbackBuilder.addSupportedNewAlertCategory(responseCode, delay, value);
            return this;
        }

        /**
         * @see org.im97mori.ble.service.ans.peripheral.AlertNotificationServiceMockCallback.Builder#removeSupportedNewAlertCategory()
         */
        @NonNull
        public Builder<T> removeSupportedNewAlertCategory() {
            mAlertNotificationServiceMockCallbackBuilder.removeSupportedNewAlertCategory();
            return this;
        }

        /**
         * @see org.im97mori.ble.service.ans.peripheral.AlertNotificationServiceMockCallback.Builder#addNewAlert(int, String, int, String, int, String, int, String, int, String, int, String, int, String, int, String, int, String, int, String, int, long, byte[])
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
            mAlertNotificationServiceMockCallbackBuilder.addNewAlert(simpleAlertNumberOfNewAlert
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
                    , descriptorResponseCode
                    , descriptorDelay
                    , descriptorValue);
            return this;
        }

        /**
         * @see org.im97mori.ble.service.ans.peripheral.AlertNotificationServiceMockCallback.Builder#removeNewAlert()
         */
        @NonNull
        public Builder<T> removeNewAlert() {
            mAlertNotificationServiceMockCallbackBuilder.removeNewAlert();
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
         * @see org.im97mori.ble.service.ans.peripheral.AlertNotificationServiceMockCallback.Builder#addSupportedUnreadAlertCategory(int, long, byte[])
         */
        @NonNull
        public Builder<T> addSupportedUnreadAlertCategory(int responseCode, long delay, @NonNull byte[] value) {
            mAlertNotificationServiceMockCallbackBuilder.addSupportedUnreadAlertCategory(responseCode, delay, value);
            return this;
        }

        /**
         * @see org.im97mori.ble.service.ans.peripheral.AlertNotificationServiceMockCallback.Builder#removeSupportedUnreadAlertCategory()
         */
        @NonNull
        public Builder<T> removeSupportedUnreadAlertCategory() {
            mAlertNotificationServiceMockCallbackBuilder.removeSupportedUnreadAlertCategory();
            return this;
        }

        /**
         * @see org.im97mori.ble.service.ans.peripheral.AlertNotificationServiceMockCallback.Builder#addUnreadAlertStatus(int, int, int, int, int, int, int, int, int, int, int, long, byte[])
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
            mAlertNotificationServiceMockCallbackBuilder.addUnreadAlertStatus(simpleAlertUnreadCount
                    , emailUnreadCount
                    , newsUnreadCount
                    , callUnreadCount
                    , missedCallUnreadCount
                    , smsMmsUnreadCount
                    , voiceMailUnreadCount
                    , scheduleUnreadCount
                    , highPrioritizedAlertUnreadCount
                    , instantMessageAlertUnreadCount
                    , descriptorResponseCode
                    , descriptorDelay
                    , descriptorValue);
            return this;
        }

        /**
         * @see org.im97mori.ble.service.ans.peripheral.AlertNotificationServiceMockCallback.Builder#removeUnreadAlertStatus()
         */
        @NonNull
        public Builder<T> removeUnreadAlertStatus() {
            mAlertNotificationServiceMockCallbackBuilder.removeUnreadAlertStatus();
            return this;
        }

        /**
         * @see org.im97mori.ble.service.ans.peripheral.AlertNotificationServiceMockCallback.Builder#addAlertNotificationControlPoint(int, int, int, int, int, int, long)
         */
        @NonNull
        public Builder<T> addAlertNotificationControlPoint(int enableNewAlertNotificationResponseValue
                , int enableUnreadAlertStatusNotificationResponseValue
                , int disableNewAlertNotificationResponseValue
                , int disableUnreadAlertStatusNotificationResponseValue
                , int notifyNewAlertImmediatelyResponseValue
                , int notifyUnreadAlertStatusImmediatelyResponseValue
                , long delay) {
            mAlertNotificationServiceMockCallbackBuilder.addAlertNotificationControlPoint(enableNewAlertNotificationResponseValue
                    , enableUnreadAlertStatusNotificationResponseValue
                    , disableNewAlertNotificationResponseValue
                    , disableUnreadAlertStatusNotificationResponseValue
                    , notifyNewAlertImmediatelyResponseValue
                    , notifyUnreadAlertStatusImmediatelyResponseValue
                    , delay);
            return this;
        }

        /**
         * @see org.im97mori.ble.service.ans.peripheral.AlertNotificationServiceMockCallback.Builder#removeAlertNotificationControlPoint()
         */
        @NonNull
        public Builder<T> removeAlertNotificationControlPoint() {
            mAlertNotificationServiceMockCallbackBuilder.removeAlertNotificationControlPoint();
            return this;
        }

        /**
         * @return {@link AlertNotificationProfileMockCallback} instance
         */
        public AlertNotificationProfileMockCallback build() {
            return new AlertNotificationProfileMockCallback(mContext, mAlertNotificationServiceMockCallbackBuilder.build());
        }

    }

    /**
     * @param context                              {@link Context} instance
     * @param alertNotificationServiceMockCallback {@link org.im97mori.ble.service.ans.peripheral.AlertNotificationServiceMockCallback} instance
     */
    public AlertNotificationProfileMockCallback(@NonNull Context context, @NonNull AlertNotificationServiceMockCallback alertNotificationServiceMockCallback) {
        super(context, true, alertNotificationServiceMockCallback);
    }

    /**
     * {@inheritDoc}
     */
    @NonNull
    @Override
    public UUID getServiceUUID() {
        return ALERT_NOTIFICATION_SERVICE;
    }

}
