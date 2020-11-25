package org.im97mori.ble.profile.aiop.peripheral;

import android.content.Context;

import androidx.annotation.NonNull;

import org.im97mori.ble.profile.peripheral.AbstractProfileMockCallback;
import org.im97mori.ble.service.aios.peripheral.AutomationIOServiceMockCallback;

import java.util.UUID;

import static org.im97mori.ble.BLEConstants.ServiceUUID.AUTOMATION_IO_SERVICE;

public class AutomationIOProfileMockCallback extends AbstractProfileMockCallback {

    /**
     * Builder for {@link AutomationIOProfileMockCallback}
     *
     * @param <T> subclass of {@link AutomationIOProfileMockCallback}
     */
    public static class Builder<T extends AutomationIOProfileMockCallback> {

        /**
         * {@link Context} instance
         */
        protected final Context mContext;

        /**
         * {@link org.im97mori.ble.service.aios.peripheral.AutomationIOServiceMockCallback.Builder} instance
         */
        protected final AutomationIOServiceMockCallback.Builder<? extends AutomationIOServiceMockCallback> mAutomationIOServiceMockCallbackBuilder;

        /**
         * @param context                                {@link Context} instance
         * @param automationIOServiceMockCallbackBuilder {@link org.im97mori.ble.service.aios.peripheral.AutomationIOServiceMockCallback.Builder} instance
         */
        public Builder(@NonNull Context context
                , @NonNull AutomationIOServiceMockCallback.Builder<? extends AutomationIOServiceMockCallback> automationIOServiceMockCallbackBuilder) {
            mContext = context;
            mAutomationIOServiceMockCallbackBuilder = automationIOServiceMockCallbackBuilder;
        }

        /**
         * @see org.im97mori.ble.service.aios.peripheral.AutomationIOServiceMockCallback.Builder#addDigital(int, int, int, long, byte[])
         */
        @NonNull
        public Builder<T> addDigital(int index, int property, int responseCode, long delay, @NonNull byte[] value) {
            mAutomationIOServiceMockCallbackBuilder.addDigital(index, property, responseCode, delay, value);
            return this;
        }

        /**
         * @see org.im97mori.ble.service.aios.peripheral.AutomationIOServiceMockCallback.Builder#removeDigital(int)
         */
        @NonNull
        public Builder<T> removeDigital(int index) {
            mAutomationIOServiceMockCallbackBuilder.removeDigital(index);
            return this;
        }

        /**
         * @see org.im97mori.ble.service.aios.peripheral.AutomationIOServiceMockCallback.Builder#addDigitalClientCharacteristicConfiguration(int, int, long, byte[])
         */
        @NonNull
        public Builder<T> addDigitalClientCharacteristicConfiguration(int index
                , int responseCode
                , long delay
                , @NonNull byte[] value) {
            mAutomationIOServiceMockCallbackBuilder.addDigitalClientCharacteristicConfiguration(index, responseCode, delay, value);
            return this;
        }

        /**
         * @see org.im97mori.ble.service.aios.peripheral.AutomationIOServiceMockCallback.Builder#removeDigitalClientCharacteristicConfiguration(int)
         */
        @NonNull
        public Builder<T> removeDigitalClientCharacteristicConfiguration(int index) {
            mAutomationIOServiceMockCallbackBuilder.removeDigitalClientCharacteristicConfiguration(index);
            return this;
        }

        /**
         * @see org.im97mori.ble.service.aios.peripheral.AutomationIOServiceMockCallback.Builder#addDigitalCharacteristicPresentationFormat(int, int, long, byte[])
         */
        @NonNull
        public Builder<T> addDigitalCharacteristicPresentationFormat(int index
                , int responseCode
                , long delay
                , @NonNull byte[] value) {
            mAutomationIOServiceMockCallbackBuilder.addDigitalCharacteristicPresentationFormat(index, responseCode, delay, value);
            return this;
        }

        /**
         * @see org.im97mori.ble.service.aios.peripheral.AutomationIOServiceMockCallback.Builder#removeDigitalCharacteristicPresentationFormat(int)
         */
        @NonNull
        public Builder<T> removeDigitalCharacteristicPresentationFormat(int index) {
            mAutomationIOServiceMockCallbackBuilder.removeDigitalCharacteristicPresentationFormat(index);
            return this;
        }

        /**
         * @see org.im97mori.ble.service.aios.peripheral.AutomationIOServiceMockCallback.Builder#addDigitalCharacteristicUserDescription(int, int, long, byte[])
         */
        @NonNull
        public Builder<T> addDigitalCharacteristicUserDescription(int index
                , int responseCode
                , long delay
                , @NonNull byte[] value) {
            mAutomationIOServiceMockCallbackBuilder.addDigitalCharacteristicUserDescription(index, responseCode, delay, value);
            return this;
        }

        /**
         * @see org.im97mori.ble.service.aios.peripheral.AutomationIOServiceMockCallback.Builder#removeDigitalCharacteristicUserDescription(int)
         */
        @NonNull
        public Builder<T> removeDigitalCharacteristicUserDescription(int index) {
            mAutomationIOServiceMockCallbackBuilder.removeDigitalCharacteristicUserDescription(index);
            return this;
        }

        /**
         * @see org.im97mori.ble.service.aios.peripheral.AutomationIOServiceMockCallback.Builder#addDigitalCharacteristicExtendedProperties(int, int, long, byte[])
         */
        @NonNull
        public Builder<T> addDigitalCharacteristicExtendedProperties(int index
                , int responseCode
                , long delay
                , @NonNull byte[] value) {
            mAutomationIOServiceMockCallbackBuilder.addDigitalCharacteristicExtendedProperties(index, responseCode, delay, value);
            return this;
        }

        /**
         * @see org.im97mori.ble.service.aios.peripheral.AutomationIOServiceMockCallback.Builder#removeDigitalCharacteristicExtendedProperties(int)
         */
        @NonNull
        public Builder<T> removeDigitalCharacteristicExtendedProperties(int index) {
            mAutomationIOServiceMockCallbackBuilder.removeDigitalCharacteristicExtendedProperties(index);
            return this;
        }

        /**
         * @see org.im97mori.ble.service.aios.peripheral.AutomationIOServiceMockCallback.Builder#addDigitalValueTriggerSetting(int, int, long, byte[])
         */
        @NonNull
        public Builder<T> addDigitalValueTriggerSetting(int index
                , int responseCode
                , long delay
                , @NonNull byte[] value) {
            mAutomationIOServiceMockCallbackBuilder.addDigitalValueTriggerSetting(index, responseCode, delay, value);
            return this;
        }

        /**
         * @see org.im97mori.ble.service.aios.peripheral.AutomationIOServiceMockCallback.Builder#removeDigitalValueTriggerSetting(int)
         */
        @NonNull
        public Builder<T> removeDigitalValueTriggerSetting(int index) {
            mAutomationIOServiceMockCallbackBuilder.removeDigitalValueTriggerSetting(index);
            return this;
        }

        /**
         * @see org.im97mori.ble.service.aios.peripheral.AutomationIOServiceMockCallback.Builder#addDigitalTimeTriggerSetting(int, int, long, byte[])
         */
        @NonNull
        public Builder<T> addDigitalTimeTriggerSetting(int index
                , int responseCode
                , long delay
                , @NonNull byte[] value) {
            mAutomationIOServiceMockCallbackBuilder.addDigitalTimeTriggerSetting(index, responseCode, delay, value);
            return this;
        }

        /**
         * @see org.im97mori.ble.service.aios.peripheral.AutomationIOServiceMockCallback.Builder#removeDigitalTimeTriggerSetting(int)
         */
        @NonNull
        public Builder<T> removeDigitalTimeTriggerSetting(int index) {
            mAutomationIOServiceMockCallbackBuilder.removeDigitalTimeTriggerSetting(index);
            return this;
        }

        /**
         * @see org.im97mori.ble.service.aios.peripheral.AutomationIOServiceMockCallback.Builder#addDigitalNumberOfDigitals(int, int, long, byte[])
         */
        @NonNull
        public Builder<T> addDigitalNumberOfDigitals(int index
                , int responseCode
                , long delay
                , @NonNull byte[] value) {
            mAutomationIOServiceMockCallbackBuilder.addDigitalNumberOfDigitals(index, responseCode, delay, value);
            return this;
        }

        /**
         * @see org.im97mori.ble.service.aios.peripheral.AutomationIOServiceMockCallback.Builder#removeDigitalNumberOfDigitals(int)
         */
        @NonNull
        public Builder<T> removeDigitalNumberOfDigitals(int index) {
            mAutomationIOServiceMockCallbackBuilder.removeDigitalNumberOfDigitals(index);
            return this;
        }

        /**
         * @see org.im97mori.ble.service.aios.peripheral.AutomationIOServiceMockCallback.Builder#addAnalog(int, int, int, long, byte[])
         */
        @NonNull
        public Builder<T> addAnalog(int index
                , int property
                , int responseCode
                , long delay
                , @NonNull byte[] value) {
            mAutomationIOServiceMockCallbackBuilder.addAnalog(index, property, responseCode, delay, value);
            return this;
        }

        /**
         * @see org.im97mori.ble.service.aios.peripheral.AutomationIOServiceMockCallback.Builder#removeAnalog(int)
         */
        @NonNull
        public Builder<T> removeAnalog(int index) {
            mAutomationIOServiceMockCallbackBuilder.removeAnalog(index);
            return this;
        }

        /**
         * @see org.im97mori.ble.service.aios.peripheral.AutomationIOServiceMockCallback.Builder#addAnalogClientCharacteristicConfiguration(int, int, long, byte[])
         */
        @NonNull
        public Builder<T> addAnalogClientCharacteristicConfiguration(int index
                , int responseCode
                , long delay
                , @NonNull byte[] value) {
            mAutomationIOServiceMockCallbackBuilder.addAnalogClientCharacteristicConfiguration(index, responseCode, delay, value);
            return this;
        }

        /**
         * @see org.im97mori.ble.service.aios.peripheral.AutomationIOServiceMockCallback.Builder#removeAnalogClientCharacteristicConfiguration(int)
         */
        @NonNull
        public Builder<T> removeAnalogClientCharacteristicConfiguration(int index) {
            mAutomationIOServiceMockCallbackBuilder.removeAnalogClientCharacteristicConfiguration(index);
            return this;
        }

        /**
         * @see org.im97mori.ble.service.aios.peripheral.AutomationIOServiceMockCallback.Builder#addAnalogCharacteristicPresentationFormat(int, int, long, byte[])
         */
        @NonNull
        public Builder<T> addAnalogCharacteristicPresentationFormat(int index
                , int responseCode
                , long delay
                , @NonNull byte[] value) {
            mAutomationIOServiceMockCallbackBuilder.addAnalogCharacteristicPresentationFormat(index, responseCode, delay, value);
            return this;
        }

        /**
         * @see org.im97mori.ble.service.aios.peripheral.AutomationIOServiceMockCallback.Builder#removeAnalogCharacteristicPresentationFormat(int)
         */
        @NonNull
        public Builder<T> removeAnalogCharacteristicPresentationFormat(int index) {
            mAutomationIOServiceMockCallbackBuilder.removeAnalogCharacteristicPresentationFormat(index);
            return this;
        }

        /**
         * @see org.im97mori.ble.service.aios.peripheral.AutomationIOServiceMockCallback.Builder#addAnalogCharacteristicUserDescription(int, int, long, byte[])
         */
        @NonNull
        public Builder<T> addAnalogCharacteristicUserDescription(int index
                , int responseCode
                , long delay
                , @NonNull byte[] value) {
            mAutomationIOServiceMockCallbackBuilder.addAnalogCharacteristicUserDescription(index, responseCode, delay, value);
            return this;
        }

        /**
         * @see org.im97mori.ble.service.aios.peripheral.AutomationIOServiceMockCallback.Builder#removeAnalogCharacteristicUserDescription(int)
         */
        @NonNull
        public Builder<T> removeAnalogCharacteristicUserDescription(int index) {
            mAutomationIOServiceMockCallbackBuilder.removeAnalogCharacteristicUserDescription(index);
            return this;
        }

        /**
         * @see org.im97mori.ble.service.aios.peripheral.AutomationIOServiceMockCallback.Builder#addAnalogCharacteristicExtendedProperties(int, int, long, byte[])
         */
        @NonNull
        public Builder<T> addAnalogCharacteristicExtendedProperties(int index
                , int responseCode
                , long delay
                , @NonNull byte[] value) {
            mAutomationIOServiceMockCallbackBuilder.addAnalogCharacteristicExtendedProperties(index, responseCode, delay, value);
            return this;
        }

        /**
         * @see org.im97mori.ble.service.aios.peripheral.AutomationIOServiceMockCallback.Builder#removeAnalogCharacteristicExtendedProperties(int)
         */
        @NonNull
        public Builder<T> removeAnalogCharacteristicExtendedProperties(int index) {
            mAutomationIOServiceMockCallbackBuilder.removeAnalogCharacteristicExtendedProperties(index);
            return this;
        }

        /**
         * @see org.im97mori.ble.service.aios.peripheral.AutomationIOServiceMockCallback.Builder#addAnalogValueTriggerSetting(int, int, long, byte[])
         */
        @NonNull
        public Builder<T> addAnalogValueTriggerSetting(int index
                , int responseCode
                , long delay
                , @NonNull byte[] value) {
            mAutomationIOServiceMockCallbackBuilder.addAnalogValueTriggerSetting(index, responseCode, delay, value);
            return this;
        }

        /**
         * @see org.im97mori.ble.service.aios.peripheral.AutomationIOServiceMockCallback.Builder#removeAnalogValueTriggerSetting(int)
         */
        @NonNull
        public Builder<T> removeAnalogValueTriggerSetting(int index) {
            mAutomationIOServiceMockCallbackBuilder.removeAnalogValueTriggerSetting(index);
            return this;
        }

        /**
         * @see org.im97mori.ble.service.aios.peripheral.AutomationIOServiceMockCallback.Builder#addAnalogTimeTriggerSetting(int, int, long, byte[])
         */
        @NonNull
        public Builder<T> addAnalogTimeTriggerSetting(int index
                , int responseCode
                , long delay
                , @NonNull byte[] value) {
            mAutomationIOServiceMockCallbackBuilder.addAnalogTimeTriggerSetting(index, responseCode, delay, value);
            return this;
        }

        /**
         * @see org.im97mori.ble.service.aios.peripheral.AutomationIOServiceMockCallback.Builder#removeAnalogTimeTriggerSetting(int)
         */
        @NonNull
        public Builder<T> removeAnalogTimeTriggerSetting(int index) {
            mAutomationIOServiceMockCallbackBuilder.removeAnalogTimeTriggerSetting(index);
            return this;
        }

        /**
         * @see org.im97mori.ble.service.aios.peripheral.AutomationIOServiceMockCallback.Builder#addAnalogValidRange(int, int, long, byte[])
         */
        @NonNull
        public Builder<T> addAnalogValidRange(int index
                , int responseCode
                , long delay
                , @NonNull byte[] value) {
            mAutomationIOServiceMockCallbackBuilder.addAnalogValidRange(index, responseCode, delay, value);
            return this;
        }

        /**
         * @see org.im97mori.ble.service.aios.peripheral.AutomationIOServiceMockCallback.Builder#removeAnalogValidRange(int)
         */
        @NonNull
        public Builder<T> removeAnalogValidRange(int index) {
            mAutomationIOServiceMockCallbackBuilder.removeAnalogValidRange(index);
            return this;
        }

        /**
         * @see org.im97mori.ble.service.aios.peripheral.AutomationIOServiceMockCallback.Builder#addAggregate(int, int, long)
         */
        @NonNull
        public Builder<T> addAggregate(int property
                , int responseCode
                , long delay) {
            mAutomationIOServiceMockCallbackBuilder.addAggregate(property, responseCode, delay);
            return this;
        }

        /**
         * @see org.im97mori.ble.service.aios.peripheral.AutomationIOServiceMockCallback.Builder#removeAggregate()
         */
        @NonNull
        public Builder<T> removeAggregate() {
            mAutomationIOServiceMockCallbackBuilder.removeAggregate();
            return this;
        }

        /**
         * @see org.im97mori.ble.service.aios.peripheral.AutomationIOServiceMockCallback.Builder#addAggregateClientCharacteristicConfiguration(int, long, byte[])
         */
        @NonNull
        public Builder<T> addAggregateClientCharacteristicConfiguration(int responseCode
                , long delay
                , @NonNull byte[] value) {
            mAutomationIOServiceMockCallbackBuilder.addAggregateClientCharacteristicConfiguration(responseCode, delay, value);
            return this;
        }

        /**
         * @see org.im97mori.ble.service.aios.peripheral.AutomationIOServiceMockCallback.Builder#removeAggregateClientCharacteristicConfiguration()
         */
        @NonNull
        public Builder<T> removeAggregateClientCharacteristicConfiguration() {
            mAutomationIOServiceMockCallbackBuilder.removeAggregateClientCharacteristicConfiguration();
            return this;
        }

        /**
         * @return {@link AutomationIOProfileMockCallback} instance
         */
        public AutomationIOProfileMockCallback build() {
            return new AutomationIOProfileMockCallback(mContext, mAutomationIOServiceMockCallbackBuilder.build());
        }
    }

    /**
     * @param context                         {@link Context} instance
     * @param automationIOServiceMockCallback {@link org.im97mori.ble.service.aios.peripheral.AutomationIOServiceMockCallback} instance
     */
    public AutomationIOProfileMockCallback(@NonNull Context context, @NonNull AutomationIOServiceMockCallback automationIOServiceMockCallback) {
        super(context, true, automationIOServiceMockCallback);
    }

    /**
     * {@inheritDoc}
     */
    @NonNull
    @Override
    public UUID getServiceUUID() {
        return AUTOMATION_IO_SERVICE;
    }

}
