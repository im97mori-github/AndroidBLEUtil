package org.im97mori.ble.service.aios.peripheral;

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
import android.text.format.DateUtils;
import android.util.Pair;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.im97mori.ble.BLEServerConnection;
import org.im97mori.ble.BLEUtils;
import org.im97mori.ble.BLEUtilsAndroid;
import org.im97mori.ble.ByteArrayInterface;
import org.im97mori.ble.CharacteristicData;
import org.im97mori.ble.DescriptorData;
import org.im97mori.ble.MockData;
import org.im97mori.ble.ServiceData;
import org.im97mori.ble.callback.NotificationData;
import org.im97mori.ble.characteristic.core.AutomationIoUtils;
import org.im97mori.ble.characteristic.u2a58.Analog;
import org.im97mori.ble.descriptor.u2904.CharacteristicPresentationFormat;
import org.im97mori.ble.descriptor.u2906.ValidRange;
import org.im97mori.ble.descriptor.u2909.NumberOfDigitals;
import org.im97mori.ble.descriptor.u290a.ValueTriggerSetting;
import org.im97mori.ble.descriptor.u290e.TimeTriggerSetting;
import org.im97mori.ble.service.peripheral.AbstractServiceMockCallback;
import org.im97mori.ble.task.NotificationTask;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import static org.im97mori.ble.constants.CharacteristicUUID.AGGREGATE_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.ANALOG_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.DIGITAL_CHARACTERISTIC;
import static org.im97mori.ble.constants.DescriptorUUID.CHARACTERISTIC_EXTENDED_PROPERTIES_DESCRIPTOR;
import static org.im97mori.ble.constants.DescriptorUUID.CHARACTERISTIC_PRESENTATION_FORMAT_DESCRIPTOR;
import static org.im97mori.ble.constants.DescriptorUUID.CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR;
import static org.im97mori.ble.constants.DescriptorUUID.CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
import static org.im97mori.ble.constants.DescriptorUUID.NUMBER_OF_DIGITALS_DESCRIPTOR;
import static org.im97mori.ble.constants.DescriptorUUID.TIME_TRIGGER_SETTING_DESCRIPTOR;
import static org.im97mori.ble.constants.DescriptorUUID.VALID_RANGE_DESCRIPTOR;
import static org.im97mori.ble.constants.DescriptorUUID.VALUE_TRIGGER_SETTING_DESCRIPTOR;
import static org.im97mori.ble.constants.ErrorCodeAndroid.APPLICATION_ERROR_9F;
import static org.im97mori.ble.constants.ServiceUUID.AUTOMATION_IO_SERVICE;

/**
 * Automation IO Service (Service UUID: 0x1815) for Peripheral
 * (writable Characteristic User Description is not supported)
 */
public class AutomationIOServiceMockCallback extends AbstractServiceMockCallback {

    /**
     * KEY:NEXT_NOTIFICATION
     */
    protected static final String KEY_NEXT_NOTIFICATION = "KEY_NEXT_NOTIFICATION";

    /**
     * Builder for {@link AutomationIOServiceMockCallback}
     *
     * @param <T> subclass of {@link AutomationIOServiceMockCallback}
     */
    public static class Builder<T extends AutomationIOServiceMockCallback> extends AbstractServiceMockCallback.Builder<AutomationIOServiceMockCallback> {

        /**
         * Digital characteristic map
         */
        protected final Map<Integer, CharacteristicData> mDigitalMap = new HashMap<>();

        /**
         * Digital characteristic Client Characteristic Configuration descriptor map
         */
        protected final Map<Integer, DescriptorData> mDigitalClientCharacteristicConfigurationMap = new HashMap<>();

        /**
         * Digital characteristic Characteristic Presentation Format descriptor map
         */
        protected final Map<Integer, DescriptorData> mDigitalCharacteristicPresentationFormatMap = new HashMap<>();

        /**
         * Digital characteristic Characteristic User Description descriptor map
         */
        protected final Map<Integer, DescriptorData> mDigitalCharacteristicUserDescriptionMap = new HashMap<>();

        /**
         * Digital characteristic Characteristic Extended Properties descriptor map
         */
        protected final Map<Integer, DescriptorData> mDigitalCharacteristicExtendedPropertiesMap = new HashMap<>();

        /**
         * Digital characteristic Value Trigger Setting descriptor map
         */
        protected final Map<Integer, DescriptorData> mDigitalValueTriggerSettingMap = new HashMap<>();

        /**
         * Digital characteristic Time Trigger Setting descriptor map
         */
        protected final Map<Integer, DescriptorData> mDigitalTimeTriggerSettingMap = new HashMap<>();

        /**
         * Digital characteristic Number Of Digitals descriptor map
         */
        protected final Map<Integer, DescriptorData> mDigitalNumberOfDigitalsMap = new HashMap<>();

        /**
         * Analog characteristic map
         */
        protected final Map<Integer, CharacteristicData> mAnalogMap = new HashMap<>();

        /**
         * Analog characteristic Client Characteristic Configuration descriptor map
         */
        protected final Map<Integer, DescriptorData> mAnalogClientCharacteristicConfigurationMap = new HashMap<>();

        /**
         * Analog characteristic Characteristic Presentation Format descriptor map
         */
        protected final Map<Integer, DescriptorData> mAnalogCharacteristicPresentationFormatMap = new HashMap<>();

        /**
         * Analog characteristic Characteristic User Description descriptor map
         */
        protected final Map<Integer, DescriptorData> mAnalogCharacteristicUserDescriptionMap = new HashMap<>();

        /**
         * Analog characteristic Characteristic Extended Properties descriptor map
         */
        protected final Map<Integer, DescriptorData> mAnalogCharacteristicExtendedPropertiesMap = new HashMap<>();

        /**
         * Analog characteristic Value Trigger Setting descriptor map
         */
        protected final Map<Integer, DescriptorData> mAnalogValueTriggerSettingMap = new HashMap<>();

        /**
         * Analog characteristic Time Trigger Setting descriptor map
         */
        protected final Map<Integer, DescriptorData> mAnalogTimeTriggerSettingMap = new HashMap<>();

        /**
         * Analog characteristic Valid Range descriptor map
         */
        protected final Map<Integer, DescriptorData> mAnalogValidRangeMap = new HashMap<>();

        /**
         * Aggregate characteristic data
         */
        protected CharacteristicData mAggregateData;

        /**
         * Aggregate characteristic Client Characteristic Configuration descriptor data
         */
        protected DescriptorData mAggregateClientCharacteristicConfigurationData;

        /**
         * add Digital characteristic
         *
         * @param index        Digital characteristic index
         * @param property     combination of
         *                     {@link android.bluetooth.BluetoothGattCharacteristic#PROPERTY_READ}
         *                     {@link android.bluetooth.BluetoothGattCharacteristic#PROPERTY_WRITE}
         *                     {@link android.bluetooth.BluetoothGattCharacteristic#PROPERTY_WRITE_NO_RESPONSE}
         *                     {@link android.bluetooth.BluetoothGattCharacteristic#PROPERTY_NOTIFY}
         *                     {@link android.bluetooth.BluetoothGattCharacteristic#PROPERTY_INDICATE}
         * @param responseCode response code, {@link android.bluetooth.BluetoothGatt#GATT_SUCCESS} or etc
         * @param delay        response delay(millis)
         * @param value        data for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> addDigital(int index, int property, int responseCode, long delay, @NonNull byte[] value) {
            int permission = 0;
            if ((property & BluetoothGattCharacteristic.PROPERTY_READ) != 0) {
                permission |= BluetoothGattCharacteristic.PERMISSION_READ;
            }
            if (((property & BluetoothGattCharacteristic.PROPERTY_WRITE) == BluetoothGattCharacteristic.PROPERTY_WRITE)
                    || ((property & BluetoothGattCharacteristic.PROPERTY_WRITE_NO_RESPONSE) == BluetoothGattCharacteristic.PROPERTY_WRITE_NO_RESPONSE)) {
                permission |= BluetoothGattCharacteristic.PERMISSION_WRITE;
            }
            mDigitalMap.put(index, new CharacteristicData(DIGITAL_CHARACTERISTIC
                    , property
                    , permission
                    , new ArrayList<>()
                    , responseCode
                    , delay
                    , value
                    , -1));
            return this;
        }

        /**
         * remove Digital characteristic
         *
         * @param index Digital characteristic index
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> removeDigital(int index) {
            mDigitalMap.remove(index);
            return this;
        }

        /**
         * add Digital characteristic Client Characteristic Configuration descriptor
         *
         * @param index        Digital characteristic Client Characteristic Configuration index
         * @param responseCode response code, {@link android.bluetooth.BluetoothGatt#GATT_SUCCESS} or etc
         * @param delay        response delay(millis)
         * @param value        data for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> addDigitalClientCharacteristicConfiguration(int index
                , int responseCode
                , long delay
                , @NonNull byte[] value) {
            mDigitalClientCharacteristicConfigurationMap.put(index
                    , new DescriptorData(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR
                            , BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE
                            , responseCode
                            , delay
                            , value));
            return this;
        }

        /**
         * remove Digital characteristic Client Characteristic Configuration descriptor
         *
         * @param index Digital characteristic Client Characteristic Configuration descriptor index
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> removeDigitalClientCharacteristicConfiguration(int index) {
            mDigitalClientCharacteristicConfigurationMap.remove(index);
            return this;
        }

        /**
         * add Digital characteristic Characteristic Presentation Format descriptor
         *
         * @param index        Digital characteristic Characteristic Presentation Format descriptor index
         * @param responseCode response code, {@link android.bluetooth.BluetoothGatt#GATT_SUCCESS} or etc
         * @param delay        response delay(millis)
         * @param value        data for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> addDigitalCharacteristicPresentationFormat(int index
                , int responseCode
                , long delay
                , @NonNull byte[] value) {
            mDigitalCharacteristicPresentationFormatMap.put(index
                    , new DescriptorData(CHARACTERISTIC_PRESENTATION_FORMAT_DESCRIPTOR
                            , BluetoothGattDescriptor.PERMISSION_READ
                            , responseCode
                            , delay
                            , value));
            return this;
        }

        /**
         * remove Digital characteristic Characteristic Presentation Format descriptor
         *
         * @param index Digital characteristic Characteristic Presentation Format descriptor index
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> removeDigitalCharacteristicPresentationFormat(int index) {
            mDigitalCharacteristicPresentationFormatMap.remove(index);
            return this;
        }

        /**
         * add Digital characteristic Characteristic User Description descriptor
         *
         * @param index        Digital characteristic Characteristic User Description descriptor index
         * @param responseCode response code, {@link android.bluetooth.BluetoothGatt#GATT_SUCCESS} or etc
         * @param delay        response delay(millis)
         * @param value        data for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> addDigitalCharacteristicUserDescription(int index
                , int responseCode
                , long delay
                , @NonNull byte[] value) {
            mDigitalCharacteristicUserDescriptionMap.put(index
                    , new DescriptorData(CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR
                            , BluetoothGattDescriptor.PERMISSION_READ
                            , responseCode
                            , delay
                            , value));
            return this;
        }

        /**
         * remove Digital characteristic Characteristic User Description descriptor
         *
         * @param index Digital characteristic Characteristic User Description descriptor index
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> removeDigitalCharacteristicUserDescription(int index) {
            mDigitalCharacteristicUserDescriptionMap.remove(index);
            return this;
        }

        /**
         * add Digital characteristic Characteristic Extended Properties descriptor
         *
         * @param index        Digital characteristic Characteristic Extended Properties descriptor index
         * @param responseCode response code, {@link android.bluetooth.BluetoothGatt#GATT_SUCCESS} or etc
         * @param delay        response delay(millis)
         * @param value        data for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> addDigitalCharacteristicExtendedProperties(int index
                , int responseCode
                , long delay
                , @NonNull byte[] value) {
            mDigitalCharacteristicExtendedPropertiesMap.put(index
                    , new DescriptorData(CHARACTERISTIC_EXTENDED_PROPERTIES_DESCRIPTOR
                            , BluetoothGattDescriptor.PERMISSION_READ
                            , responseCode
                            , delay
                            , value));
            return this;
        }

        /**
         * remove Digital characteristic Characteristic Extended Properties descriptor
         *
         * @param index Digital characteristic Characteristic Extended Properties descriptor index
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> removeDigitalCharacteristicExtendedProperties(int index) {
            mDigitalCharacteristicExtendedPropertiesMap.remove(index);
            return this;
        }

        /**
         * add Digital characteristic Value Trigger Setting descriptor
         *
         * @param index        Digital characteristic Value Trigger Setting descriptor index
         * @param responseCode response code, {@link android.bluetooth.BluetoothGatt#GATT_SUCCESS} or etc
         * @param delay        response delay(millis)
         * @param value        data for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> addDigitalValueTriggerSetting(int index
                , int responseCode
                , long delay
                , @NonNull byte[] value) {
            mDigitalValueTriggerSettingMap.put(index
                    , new DescriptorData(VALUE_TRIGGER_SETTING_DESCRIPTOR
                            , BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE
                            , responseCode
                            , delay
                            , value));
            return this;
        }

        /**
         * remove Digital characteristic Value Trigger Setting descriptor
         *
         * @param index Digital characteristic Value Trigger Setting descriptor index
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> removeDigitalValueTriggerSetting(int index) {
            mDigitalValueTriggerSettingMap.remove(index);
            return this;
        }

        /**
         * add Digital characteristic Time Trigger Setting descriptor
         *
         * @param index        Digital characteristic Time Trigger Setting descriptor index
         * @param responseCode response code, {@link android.bluetooth.BluetoothGatt#GATT_SUCCESS} or etc
         * @param delay        response delay(millis)
         * @param value        data for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> addDigitalTimeTriggerSetting(int index
                , int responseCode
                , long delay
                , @NonNull byte[] value) {
            mDigitalTimeTriggerSettingMap.put(index
                    , new DescriptorData(TIME_TRIGGER_SETTING_DESCRIPTOR
                            , BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE
                            , responseCode
                            , delay
                            , value));
            return this;
        }

        /**
         * remove Digital characteristic Time Trigger Setting descriptor
         *
         * @param index Digital characteristic Time Trigger Setting descriptor index
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> removeDigitalTimeTriggerSetting(int index) {
            mDigitalTimeTriggerSettingMap.remove(index);
            return this;
        }

        /**
         * add Digital characteristic Number Of Digitals descriptor
         *
         * @param index        Digital characteristic Number Of Digitals descriptor index
         * @param responseCode response code, {@link android.bluetooth.BluetoothGatt#GATT_SUCCESS} or etc
         * @param delay        response delay(millis)
         * @param value        data for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> addDigitalNumberOfDigitals(int index
                , int responseCode
                , long delay
                , @NonNull byte[] value) {
            mDigitalNumberOfDigitalsMap.put(index
                    , new DescriptorData(NUMBER_OF_DIGITALS_DESCRIPTOR
                            , BluetoothGattDescriptor.PERMISSION_READ
                            , responseCode
                            , delay
                            , value));
            return this;
        }

        /**
         * remove Digital characteristic Number Of Digitals descriptor
         *
         * @param index Digital characteristic Number Of Digitals descriptor index
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> removeDigitalNumberOfDigitals(int index) {
            mDigitalNumberOfDigitalsMap.remove(index);
            return this;
        }

        /**
         * add Analog characteristic
         *
         * @param index        Analog characteristic index
         * @param property     combination of
         *                     {@link android.bluetooth.BluetoothGattCharacteristic#PROPERTY_READ}
         *                     {@link android.bluetooth.BluetoothGattCharacteristic#PROPERTY_WRITE}
         *                     {@link android.bluetooth.BluetoothGattCharacteristic#PROPERTY_WRITE_NO_RESPONSE}
         *                     {@link android.bluetooth.BluetoothGattCharacteristic#PROPERTY_NOTIFY}
         *                     {@link android.bluetooth.BluetoothGattCharacteristic#PROPERTY_INDICATE}
         * @param responseCode response code, {@link android.bluetooth.BluetoothGatt#GATT_SUCCESS} or etc
         * @param delay        response delay(millis)
         * @param value        data for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> addAnalog(int index
                , int property
                , int responseCode
                , long delay
                , @NonNull byte[] value) {
            int permission = 0;
            if ((property & BluetoothGattCharacteristic.PROPERTY_READ) != 0) {
                permission |= BluetoothGattCharacteristic.PERMISSION_READ;
            }
            if (((property & BluetoothGattCharacteristic.PROPERTY_WRITE) == BluetoothGattCharacteristic.PROPERTY_WRITE)
                    || ((property & BluetoothGattCharacteristic.PROPERTY_WRITE_NO_RESPONSE) == BluetoothGattCharacteristic.PROPERTY_WRITE_NO_RESPONSE)) {
                permission |= BluetoothGattCharacteristic.PERMISSION_WRITE;
            }
            mAnalogMap.put(index, new CharacteristicData(ANALOG_CHARACTERISTIC
                    , property
                    , permission
                    , new ArrayList<>()
                    , responseCode
                    , delay
                    , value
                    , -1));
            return this;
        }

        /**
         * remove Analog characteristic
         *
         * @param index Analog characteristic index
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> removeAnalog(int index) {
            mAnalogMap.remove(index);
            return this;
        }

        /**
         * add Analog characteristic Client Characteristic Configuration descriptor
         *
         * @param index        Analog characteristic Client Characteristic Configuration index
         * @param responseCode response code, {@link android.bluetooth.BluetoothGatt#GATT_SUCCESS} or etc
         * @param delay        response delay(millis)
         * @param value        data for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> addAnalogClientCharacteristicConfiguration(int index
                , int responseCode
                , long delay
                , @NonNull byte[] value) {
            mAnalogClientCharacteristicConfigurationMap.put(index
                    , new DescriptorData(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR
                            , BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE
                            , responseCode
                            , delay
                            , value));
            return this;
        }

        /**
         * remove Analog characteristic Client Characteristic Configuration descriptor
         *
         * @param index Analog characteristic Client Characteristic Configuration descriptor index
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> removeAnalogClientCharacteristicConfiguration(int index) {
            mAnalogClientCharacteristicConfigurationMap.remove(index);
            return this;
        }

        /**
         * add Analog characteristic Characteristic Presentation Format descriptor
         *
         * @param index        Analog characteristic Characteristic Presentation Format descriptor index
         * @param responseCode response code, {@link android.bluetooth.BluetoothGatt#GATT_SUCCESS} or etc
         * @param delay        response delay(millis)
         * @param value        data for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> addAnalogCharacteristicPresentationFormat(int index
                , int responseCode
                , long delay
                , @NonNull byte[] value) {
            mAnalogCharacteristicPresentationFormatMap.put(index
                    , new DescriptorData(CHARACTERISTIC_PRESENTATION_FORMAT_DESCRIPTOR
                            , BluetoothGattDescriptor.PERMISSION_READ
                            , responseCode
                            , delay
                            , value));
            return this;
        }

        /**
         * remove Analog characteristic Characteristic Presentation Format descriptor
         *
         * @param index Analog characteristic Characteristic Presentation Format descriptor index
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> removeAnalogCharacteristicPresentationFormat(int index) {
            mAnalogCharacteristicPresentationFormatMap.remove(index);
            return this;
        }

        /**
         * add Analog characteristic Characteristic User Description descriptor
         *
         * @param index        Analog characteristic Characteristic User Description descriptor index
         * @param responseCode response code, {@link android.bluetooth.BluetoothGatt#GATT_SUCCESS} or etc
         * @param delay        response delay(millis)
         * @param value        data for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> addAnalogCharacteristicUserDescription(int index
                , int responseCode
                , long delay
                , @NonNull byte[] value) {
            mAnalogCharacteristicUserDescriptionMap.put(index
                    , new DescriptorData(CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR
                            , BluetoothGattDescriptor.PERMISSION_READ
                            , responseCode
                            , delay
                            , value));
            return this;
        }

        /**
         * remove Analog characteristic Characteristic User Description descriptor
         *
         * @param index Analog characteristic Characteristic User Description descriptor index
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> removeAnalogCharacteristicUserDescription(int index) {
            mAnalogCharacteristicUserDescriptionMap.remove(index);
            return this;
        }

        /**
         * add Analog characteristic Characteristic Extended Properties descriptor
         *
         * @param index        Analog characteristic Characteristic Extended Properties descriptor index
         * @param responseCode response code, {@link android.bluetooth.BluetoothGatt#GATT_SUCCESS} or etc
         * @param delay        response delay(millis)
         * @param value        data for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> addAnalogCharacteristicExtendedProperties(int index
                , int responseCode
                , long delay
                , @NonNull byte[] value) {
            mAnalogCharacteristicExtendedPropertiesMap.put(index
                    , new DescriptorData(CHARACTERISTIC_EXTENDED_PROPERTIES_DESCRIPTOR
                            , BluetoothGattDescriptor.PERMISSION_READ
                            , responseCode
                            , delay
                            , value));
            return this;
        }

        /**
         * remove Analog characteristic Characteristic Extended Properties descriptor
         *
         * @param index Analog characteristic Characteristic Extended Properties descriptor index
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> removeAnalogCharacteristicExtendedProperties(int index) {
            mAnalogCharacteristicExtendedPropertiesMap.remove(index);
            return this;
        }

        /**
         * add Analog characteristic Value Trigger Setting descriptor
         *
         * @param index        Analog characteristic Value Trigger Setting descriptor index
         * @param responseCode response code, {@link android.bluetooth.BluetoothGatt#GATT_SUCCESS} or etc
         * @param delay        response delay(millis)
         * @param value        data for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> addAnalogValueTriggerSetting(int index
                , int responseCode
                , long delay
                , @NonNull byte[] value) {
            mAnalogValueTriggerSettingMap.put(index
                    , new DescriptorData(VALUE_TRIGGER_SETTING_DESCRIPTOR
                            , BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE
                            , responseCode
                            , delay
                            , value));
            return this;
        }

        /**
         * remove Analog characteristic Value Trigger Setting descriptor
         *
         * @param index Analog characteristic Value Trigger Setting descriptor index
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> removeAnalogValueTriggerSetting(int index) {
            mAnalogValueTriggerSettingMap.remove(index);
            return this;
        }

        /**
         * add Analog characteristic Time Trigger Setting descriptor
         *
         * @param index        Analog characteristic Time Trigger Setting descriptor index
         * @param responseCode response code, {@link android.bluetooth.BluetoothGatt#GATT_SUCCESS} or etc
         * @param delay        response delay(millis)
         * @param value        data for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> addAnalogTimeTriggerSetting(int index
                , int responseCode
                , long delay
                , @NonNull byte[] value) {
            mAnalogTimeTriggerSettingMap.put(index
                    , new DescriptorData(TIME_TRIGGER_SETTING_DESCRIPTOR
                            , BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE
                            , responseCode
                            , delay
                            , value));
            return this;
        }

        /**
         * remove Analog characteristic Time Trigger Setting descriptor
         *
         * @param index Analog characteristic Time Trigger Setting descriptor index
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> removeAnalogTimeTriggerSetting(int index) {
            mAnalogTimeTriggerSettingMap.remove(index);
            return this;
        }

        /**
         * add Analog characteristic Valid Range descriptor
         *
         * @param index        Analog characteristic Valid Range descriptor index
         * @param responseCode response code, {@link android.bluetooth.BluetoothGatt#GATT_SUCCESS} or etc
         * @param delay        response delay(millis)
         * @param value        data for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> addAnalogValidRange(int index
                , int responseCode
                , long delay
                , @NonNull byte[] value) {
            mAnalogValidRangeMap.put(index
                    , new DescriptorData(VALID_RANGE_DESCRIPTOR
                            , BluetoothGattDescriptor.PERMISSION_READ
                            , responseCode
                            , delay
                            , value));
            return this;
        }

        /**
         * remove Analog characteristic Valid Range descriptor
         *
         * @param index Analog characteristic Valid Range descriptor index
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> removeAnalogValidRange(int index) {
            mAnalogValidRangeMap.remove(index);
            return this;
        }

        /**
         * add Aggregate characteristic
         *
         * @param property     combination of
         *                     {@link android.bluetooth.BluetoothGattCharacteristic#PROPERTY_READ}
         *                     {@link android.bluetooth.BluetoothGattCharacteristic#PROPERTY_NOTIFY}
         * @param responseCode response code, {@link android.bluetooth.BluetoothGatt#GATT_SUCCESS} or etc
         * @param delay        response delay(millis)
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> addAggregate(int property
                , int responseCode
                , long delay) {
            int permission = 0;
            if ((property & BluetoothGattCharacteristic.PROPERTY_READ) != 0) {
                permission |= BluetoothGattCharacteristic.PERMISSION_READ;
            }
            mAggregateData = new CharacteristicData(AGGREGATE_CHARACTERISTIC
                    , property
                    , permission
                    , new ArrayList<>()
                    , responseCode
                    , delay
                    , new byte[0]
                    , -1);
            return this;
        }

        /**
         * remove Aggregate characteristic
         *
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> removeAggregate() {
            mAggregateData = null;
            return this;
        }

        /**
         * add Aggregate characteristic Client Characteristic Configuration descriptor
         *
         * @param responseCode response code, {@link android.bluetooth.BluetoothGatt#GATT_SUCCESS} or etc
         * @param delay        response delay(millis)
         * @param value        data for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> addAggregateClientCharacteristicConfiguration(int responseCode
                , long delay
                , @NonNull byte[] value) {
            mAggregateClientCharacteristicConfigurationData =
                    new DescriptorData(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR
                            , BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE
                            , responseCode
                            , delay
                            , value);
            return this;
        }

        /**
         * remove Aggregate characteristic Client Characteristic Configuration descriptor
         *
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> removeAggregateClientCharacteristicConfiguration() {
            mAggregateClientCharacteristicConfigurationData = null;
            return this;
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        @Override
        public MockData createMockData() {
            if (mDigitalMap.isEmpty() && mAnalogMap.isEmpty()) {
                throw new RuntimeException("Digital and Analog Characteristic not found");
            }

            List<CharacteristicData> characteristicDataList = new ArrayList<>();

            boolean isNotificatable;
            boolean isIndicatable;
            boolean isAggregateNotificatable;
            if (mAggregateData != null) {
                isNotificatable = (mAggregateData.property & BluetoothGattCharacteristic.PROPERTY_NOTIFY) != 0;
                isIndicatable = (mAggregateData.property & BluetoothGattCharacteristic.PROPERTY_INDICATE) != 0;
                if (isNotificatable && isIndicatable) {
                    throw new RuntimeException("The Indicate and Notify properties shall not be permitted simultaneously for Aggregate characteristic");
                } else if (isNotificatable || isIndicatable) {
                    if (mAggregateClientCharacteristicConfigurationData == null) {
                        mAggregateData.descriptorDataList.add(new DescriptorData(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, BluetoothGatt.GATT_SUCCESS, 0, BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE));
                    } else {
                        mAggregateData.descriptorDataList.add(mAggregateClientCharacteristicConfigurationData);
                    }
                }
                characteristicDataList.add(mAggregateData);
                isAggregateNotificatable = isNotificatable | isIndicatable;
                if (isAggregateNotificatable && (mAggregateData.property & BluetoothGattCharacteristic.PROPERTY_READ) == 0) {
                    throw new RuntimeException("Aggregate characteristic Read property is not supported");
                }
            } else {
                isAggregateNotificatable = false;
            }

            CharacteristicData characteristicData;
            DescriptorData descriptorData;

            List<CharacteristicPresentationFormat> characteristicPresentationFormatList = new LinkedList<>();

            List<Integer> keyList = new ArrayList<>(mDigitalMap.keySet());
            Collections.sort(keyList);
            for (Integer index : keyList) {
                characteristicData = mDigitalMap.get(index);

                if (characteristicData != null) {
                    isNotificatable = (characteristicData.property & BluetoothGattCharacteristic.PROPERTY_NOTIFY) != 0;
                    isIndicatable = (characteristicData.property & BluetoothGattCharacteristic.PROPERTY_INDICATE) != 0;
                    if (isNotificatable && isIndicatable) {
                        throw new RuntimeException("The Indicate and Notify properties shall not be permitted simultaneously for Digital characteristic. index:" + index);
                    } else if (isNotificatable || isIndicatable) {
                        if ((characteristicData.property & BluetoothGattCharacteristic.PROPERTY_READ) == 0) {
                            throw new RuntimeException("Indicate or Notify property shall be supported only if the Read property is supported for the characteristic. index:" + index);
                        } else if (isAggregateNotificatable) {
                            throw new RuntimeException("The Indicate and Notify properties are excluded for the Digital characteristic if the Aggregate characteristic is supported. index:" + index);
                        }
                        descriptorData = mDigitalClientCharacteristicConfigurationMap.get(index);
                        if (descriptorData == null) {
                            descriptorData = new DescriptorData(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, BluetoothGatt.GATT_SUCCESS, 0, BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE);
                        }
                        characteristicData.descriptorDataList.add(descriptorData);
                    }

                    descriptorData = mDigitalCharacteristicPresentationFormatMap.get(index);
                    if (descriptorData == null && mDigitalMap.size() > 1) {
                        throw new RuntimeException("Digital characteristic Characteristic Presentation Format descriptor not found. index:" + index);
                    } else if (descriptorData != null) {
                        if (BLEUtils.createUInt16(new CharacteristicPresentationFormat(descriptorData.getBytes()).getDescription(), 0) == 0) {
                            throw new RuntimeException("Description values from 0x0001 and upwards shall be used to uniquely identify each Digital characteristic. index:" + index);
                        } else {
                            characteristicData.descriptorDataList.add(descriptorData);
                            characteristicPresentationFormatList.add(new CharacteristicPresentationFormat(descriptorData.getBytes()));
                        }
                    }

                    descriptorData = mDigitalCharacteristicExtendedPropertiesMap.get(index);
                    if (descriptorData != null) {
                        characteristicData.descriptorDataList.add(descriptorData);
                    }

                    descriptorData = mDigitalCharacteristicUserDescriptionMap.get(index);
                    if (descriptorData != null) {
                        characteristicData.descriptorDataList.add(descriptorData);
                    }

                    if (isNotificatable || isIndicatable || isAggregateNotificatable) {
                        descriptorData = mDigitalValueTriggerSettingMap.get(index);
                        if (descriptorData != null) {
                            characteristicData.descriptorDataList.add(descriptorData);

                            descriptorData = mDigitalTimeTriggerSettingMap.get(index);
                            if (descriptorData != null) {
                                characteristicData.descriptorDataList.add(descriptorData);
                            }
                        }
                    }

                    descriptorData = mDigitalNumberOfDigitalsMap.get(index);
                    if (descriptorData == null) {
                        throw new RuntimeException("Number of Digitals descriptor not found. index:" + index);
                    } else {
                        NumberOfDigitals numberOfDigitals = new NumberOfDigitals(descriptorData.getBytes());
                        int bits = numberOfDigitals.getNoOfDigitals() * 2;
                        if (bits <= characteristicData.data.length * 8) {
                            characteristicData.data = AutomationIOServiceMockCallback.sanitizeDigitalData(characteristicData.data, numberOfDigitals);
                            characteristicData.descriptorDataList.add(descriptorData);
                        } else {
                            throw new RuntimeException("Data size not match. index:" + index);
                        }

                        characteristicDataList.add(characteristicData);
                    }
                }
            }

            Set<Integer> uniquelyIdentifySet = new HashSet<>();
            for (CharacteristicPresentationFormat characteristicPresentationFormat : characteristicPresentationFormatList) {
                uniquelyIdentifySet.add(BLEUtils.createUInt16(characteristicPresentationFormat.getDescription(), 0));
            }
            if (uniquelyIdentifySet.size() != characteristicPresentationFormatList.size()) {
                throw new RuntimeException("Description values from 0x0001 and upwards shall be used to uniquely identify each Digital characteristic");
            }

            uniquelyIdentifySet.clear();
            characteristicPresentationFormatList.clear();

            keyList = new ArrayList<>(mAnalogMap.keySet());
            Collections.sort(keyList);
            for (Integer index : keyList) {
                characteristicData = mAnalogMap.get(index);

                if (characteristicData != null) {
                    isNotificatable = (characteristicData.property & BluetoothGattCharacteristic.PROPERTY_NOTIFY) != 0;
                    isIndicatable = (characteristicData.property & BluetoothGattCharacteristic.PROPERTY_INDICATE) != 0;
                    if (isNotificatable && isIndicatable) {
                        throw new RuntimeException("The Indicate and Notify properties shall not be permitted simultaneously for Analog characteristic. index:" + index);
                    } else if (isNotificatable || isIndicatable) {
                        if ((characteristicData.property & BluetoothGattCharacteristic.PROPERTY_READ) == 0) {
                            throw new RuntimeException("Indicate or Notify property shall be supported only if the Read property is supported for the characteristic. index:" + index);
                        } else if (isAggregateNotificatable) {
                            throw new RuntimeException("The Indicate and Notify properties are excluded for the Analog characteristic if the Aggregate characteristic is supported. index:" + index);
                        }
                        descriptorData = mAnalogClientCharacteristicConfigurationMap.get(index);
                        if (descriptorData == null) {
                            descriptorData = new DescriptorData(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, BluetoothGatt.GATT_SUCCESS, 0, BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE);
                        }
                        characteristicData.descriptorDataList.add(descriptorData);
                    }

                    descriptorData = mAnalogCharacteristicPresentationFormatMap.get(index);
                    if (descriptorData == null && mAnalogMap.size() > 1) {
                        throw new RuntimeException("Analog characteristic Characteristic Presentation Format descriptor not found. index:" + index);
                    } else if (descriptorData != null) {
                        CharacteristicPresentationFormat characteristicPresentationFormat = new CharacteristicPresentationFormat(descriptorData.getBytes());
                        if (BLEUtils.createUInt16(characteristicPresentationFormat.getDescription(), 0) == 0) {
                            throw new RuntimeException("Description values from 0x0001 and upwards shall be used to uniquely identify each Analog characteristic. index:" + index);
                        } else if (!characteristicPresentationFormat.isFormatUnsigned8BitInteger()
                                && !characteristicPresentationFormat.isFormatUnsigned12BitInteger()
                                && !characteristicPresentationFormat.isFormatUnsigned16BitInteger()
                                && !characteristicPresentationFormat.isFormatSigned8BitInteger()
                                && !characteristicPresentationFormat.isFormatSigned12BitInteger()
                                && !characteristicPresentationFormat.isFormatSigned16BitInteger()
                                && !characteristicPresentationFormat.isFormatIEEE11073_16BitSfloat()
                                && !characteristicPresentationFormat.isFormatIEEE20601Format()) {
                            throw new RuntimeException("The allowed values for the format field are uint8, uint12, uint16, sint8, sint12, sint16, SFLOAT, and duint16. index:" + index);
                        } else {
                            characteristicData.descriptorDataList.add(descriptorData);
                            characteristicPresentationFormatList.add(new CharacteristicPresentationFormat(descriptorData.getBytes()));
                        }
                    }

                    descriptorData = mAnalogCharacteristicExtendedPropertiesMap.get(index);
                    if (descriptorData != null) {
                        characteristicData.descriptorDataList.add(descriptorData);
                    }

                    descriptorData = mAnalogCharacteristicUserDescriptionMap.get(index);
                    if (descriptorData != null) {
                        characteristicData.descriptorDataList.add(descriptorData);
                    }

                    if (isNotificatable || isIndicatable || isAggregateNotificatable) {
                        descriptorData = mAnalogValueTriggerSettingMap.get(index);
                        if (descriptorData != null) {
                            characteristicData.descriptorDataList.add(descriptorData);

                            descriptorData = mAnalogTimeTriggerSettingMap.get(index);
                            if (descriptorData != null) {
                                characteristicData.descriptorDataList.add(descriptorData);
                            }
                        }
                    }

                    descriptorData = mAnalogValidRangeMap.get(index);
                    if (descriptorData == null) {
                        throw new RuntimeException("Valid Range descriptor not found. index:" + index);
                    } else if (characteristicData.getBytes().length != 2) {
                        throw new RuntimeException("Data size not match. index:" + index);
                    } else if (descriptorData.getBytes().length != 4) {
                        throw new RuntimeException("Valid Range descriptor Data size not match. index:" + index);
                    } else {
                        int uint16Value = BLEUtils.createUInt16(characteristicData.getBytes(), 0);
                        ValidRange validRange = new ValidRange(descriptorData.getBytes());
                        if (uint16Value >= validRange.getLowerInclusiveValueUint16() && uint16Value <= validRange.getUpperInclusiveValueUint16()) {
                            characteristicData.descriptorDataList.add(descriptorData);
                        } else {
                            throw new RuntimeException("Analog data is not in Valid Range. index:" + index);
                        }
                    }

                    characteristicDataList.add(characteristicData);
                }
            }

            for (CharacteristicPresentationFormat characteristicPresentationFormat : characteristicPresentationFormatList) {
                uniquelyIdentifySet.add(BLEUtils.createUInt16(characteristicPresentationFormat.getDescription(), 0));
            }
            if (uniquelyIdentifySet.size() != characteristicPresentationFormatList.size()) {
                throw new RuntimeException("Description values from 0x0001 and upwards shall be used to uniquely identify each Analog characteristic");
            }

            return new MockData(Collections.singletonList(new ServiceData(AUTOMATION_IO_SERVICE, BluetoothGattService.SERVICE_TYPE_PRIMARY, characteristicDataList)));
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        @Override
        public AutomationIOServiceMockCallback build() {
            return new AutomationIOServiceMockCallback(createMockData(), false);
        }

    }

    /**
     * sanitize digital data
     *
     * @param data             original data array
     * @param numberOfDigitals digital data count (1 data = 2bits)
     * @return sanitized digital data
     */
    @NonNull
    private static byte[] sanitizeDigitalData(@NonNull byte[] data, @NonNull NumberOfDigitals numberOfDigitals) {
        int bits = numberOfDigitals.getNoOfDigitals() * 2;
        int byteLength = bits / 8 + 1;
        byte[] resultData = Arrays.copyOfRange(data, 0, byteLength);
        if ((bits % 8) != 0) {
            resultData[byteLength - 1] &= 0xff >> (8 - bits % 8);
        }
        return resultData;
    }

    /**
     * Digital or Analog's characteristic update count with Value Trigger Setting
     */
    protected final Map<Pair<UUID, Integer>, Integer> mUpdateCountMap = new HashMap<>();

    /**
     * Digital or Analog's last notify / indicate timestamp map
     */
    protected final Map<Pair<UUID, Integer>, Long> mLastNotifyMap = new HashMap<>();

    /**
     * @param mockData   {@link MockData} instance
     * @param isFallback fallback flag
     */
    public AutomationIOServiceMockCallback(@NonNull MockData mockData, boolean isFallback) {
        super(mockData, isFallback);
    }

    /**
     * {@inheritDoc}
     */
    @SuppressLint("MissingPermission")
    @Override
    public synchronized boolean onCharacteristicReadRequest(@NonNull BLEServerConnection bleServerConnection, @NonNull BluetoothDevice device, int requestId, int offset, @NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic, boolean force) {
        boolean result = false;

        UUID characteristicUUID = bluetoothGattCharacteristic.getUuid();
        if (AGGREGATE_CHARACTERISTIC.equals(characteristicUUID)) {
            BluetoothGattServer bluetoothGattServer = bleServerConnection.getBluetoothGattServer();
            if (bluetoothGattServer != null) {
                long now = SystemClock.elapsedRealtime();
                BluetoothGattService bluetoothGattService = bluetoothGattCharacteristic.getService();
                UUID serviceUUID = bluetoothGattService.getUuid();
                int serviceInstanceId = bluetoothGattService.getInstanceId();
                Map<Pair<UUID, Integer>, CharacteristicData> characteristicMap = mRemappedServiceCharacteristicMap.get(Pair.create(serviceUUID, serviceInstanceId));
                if (characteristicMap != null) {

                    int characteristicInstanceId = bluetoothGattCharacteristic.getInstanceId();
                    CharacteristicData characteristicData = characteristicMap.get(Pair.create(characteristicUUID, characteristicInstanceId));
                    if (characteristicData != null) {
                        delay(now, characteristicData.delay);

                        byte[] data = createAggregateData(characteristicMap).getBytes();
                        result = bluetoothGattServer.sendResponse(device
                                , requestId
                                , characteristicData.responseCode
                                , offset
                                , Arrays.copyOfRange(data, offset, data.length));
                    }
                }

                if (force && !result) {
                    result = bluetoothGattServer.sendResponse(device, requestId, APPLICATION_ERROR_9F, offset, null);
                }
            }
        } else {
            result = super.onCharacteristicReadRequest(bleServerConnection, device, requestId, offset, bluetoothGattCharacteristic, force);
        }

        return result;
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
                UUID characteristicUUID = bluetoothGattCharacteristic.getUuid();
                int characteristicInstanceId = bluetoothGattCharacteristic.getInstanceId();
                Pair<UUID, Integer> characteristicKeyPair = Pair.create(characteristicUUID, characteristicInstanceId);
                CharacteristicData characteristicData = characteristicMap.get(characteristicKeyPair);
                if (characteristicData != null) {
                    delay(now, characteristicData.delay);

                    int responseCode;
                    NumberOfDigitals numberOfDigitals = null;
                    if (DIGITAL_CHARACTERISTIC.equals(characteristicUUID)) {
                        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(NUMBER_OF_DIGITALS_DESCRIPTOR);
                        if (bluetoothGattDescriptor == null) {
                            responseCode = APPLICATION_ERROR_9F;
                        } else {
                            Map<Pair<UUID, Integer>, DescriptorData> descriptorDataMap = mRemappedCharacteristicDescriptorMap.get(characteristicKeyPair);
                            if (descriptorDataMap == null) {
                                responseCode = APPLICATION_ERROR_9F;
                            } else {
                                UUID descriptorUUID = bluetoothGattDescriptor.getUuid();
                                int descriptorInstanceId = BLEUtilsAndroid.getDescriptorInstanceId(bluetoothGattDescriptor);
                                Pair<UUID, Integer> descriptorPair = Pair.create(descriptorUUID, descriptorInstanceId);
                                DescriptorData descriptorData = descriptorDataMap.get(descriptorPair);
                                if (descriptorData == null) {
                                    responseCode = APPLICATION_ERROR_9F;
                                } else {
                                    numberOfDigitals = new NumberOfDigitals(descriptorData.getBytes());
                                    int bitCount = numberOfDigitals.getNoOfDigitals() * 2;
                                    if (bitCount <= (value.length - offset) * 8) {
                                        responseCode = characteristicData.responseCode;
                                    } else {
                                        responseCode = APPLICATION_ERROR_9F;
                                    }
                                }
                            }
                        }

                        if (BluetoothGatt.GATT_SUCCESS == responseCode) {
                            bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(VALUE_TRIGGER_SETTING_DESCRIPTOR);
                            if (bluetoothGattDescriptor != null) {
                                Map<Pair<UUID, Integer>, DescriptorData> descriptorDataMap = mRemappedCharacteristicDescriptorMap.get(characteristicKeyPair);
                                if (descriptorDataMap != null) {
                                    UUID descriptorUUID = bluetoothGattDescriptor.getUuid();
                                    int descriptorInstanceId = BLEUtilsAndroid.getDescriptorInstanceId(bluetoothGattDescriptor);
                                    Pair<UUID, Integer> descriptorPair = Pair.create(descriptorUUID, descriptorInstanceId);
                                    DescriptorData descriptorData = descriptorDataMap.get(descriptorPair);
                                    if (descriptorData != null) {
                                        ValueTriggerSetting valueTriggerSetting = new ValueTriggerSetting(descriptorData.getBytes());
                                        boolean isCountup = false;
                                        if (valueTriggerSetting.isNone0()) {
                                            isCountup = true;
                                        } else if (valueTriggerSetting.isBitMask4()) {
                                            byte[] checkTarget = characteristicData.getBytes();
                                            byte[] lastBits = new byte[checkTarget.length];
                                            byte[] currentBits = new byte[checkTarget.length];
                                            for (int i = 0; i < checkTarget.length; i++) {
                                                lastBits[i] = (byte) (checkTarget[i] & valueTriggerSetting.getValueBitMask()[i]);
                                            }
                                            checkTarget = Arrays.copyOfRange(value, offset, value.length);
                                            for (int i = 0; i < checkTarget.length; i++) {
                                                currentBits[i] = (byte) (checkTarget[i] & valueTriggerSetting.getValueBitMask()[i]);
                                            }
                                            isCountup = Arrays.equals(lastBits, currentBits);
                                        }
                                        if (isCountup) {
                                            Integer count = mUpdateCountMap.get(characteristicKeyPair);
                                            if (count == null) {
                                                count = -1;
                                            }
                                            count++;
                                            mUpdateCountMap.put(characteristicKeyPair, count);
                                        }
                                    }
                                }
                            }

                            if (responseNeeded) {
                                result = bluetoothGattServer.sendResponse(device, requestId, responseCode, offset, null);
                            } else {
                                result = true;
                            }

                            if (result) {
                                mIsReliable |= preparedWrite;

                                byte[] digitalData = sanitizeDigitalData(value, numberOfDigitals);
                                if (mIsReliable) {
                                    characteristicData.temporaryData = digitalData;
                                } else {
                                    characteristicData.currentData = digitalData;
                                }
                            }

                            Integer descriptorInstanceId = null;
                            bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR);
                            if (bluetoothGattDescriptor == null) {
                                bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(AGGREGATE_CHARACTERISTIC);
                                if (bluetoothGattCharacteristic != null) {
                                    bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR);
                                    if (bluetoothGattDescriptor != null) {
                                        descriptorInstanceId = BLEUtilsAndroid.getDescriptorInstanceId(bluetoothGattDescriptor);
                                    }
                                }
                            } else {
                                descriptorInstanceId = BLEUtilsAndroid.getDescriptorInstanceId(bluetoothGattDescriptor);
                            }
                            if (descriptorInstanceId != null) {
                                startNotification(null, bleServerConnection, null, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorInstanceId, 0, null, null);
                            }
                        }
                    } else if (ANALOG_CHARACTERISTIC.equals(characteristicUUID)) {
                        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(VALID_RANGE_DESCRIPTOR);
                        if (bluetoothGattDescriptor == null) {
                            responseCode = characteristicData.responseCode;
                        } else {
                            Map<Pair<UUID, Integer>, DescriptorData> descriptorDataMap = mRemappedCharacteristicDescriptorMap.get(characteristicKeyPair);
                            if (descriptorDataMap == null) {
                                responseCode = APPLICATION_ERROR_9F;
                            } else {
                                UUID descriptorUUID = bluetoothGattDescriptor.getUuid();
                                int descriptorInstanceId = BLEUtilsAndroid.getDescriptorInstanceId(bluetoothGattDescriptor);
                                Pair<UUID, Integer> descriptorPair = Pair.create(descriptorUUID, descriptorInstanceId);
                                DescriptorData descriptorData = descriptorDataMap.get(descriptorPair);
                                if (descriptorData == null) {
                                    responseCode = APPLICATION_ERROR_9F;
                                } else {
                                    if (value.length - offset < 2) {
                                        responseCode = APPLICATION_ERROR_9F;
                                    } else {
                                        int uint16Value = BLEUtils.createUInt16(value, offset);
                                        ValidRange validRange = new ValidRange(descriptorData.getBytes());
                                        if (uint16Value >= validRange.getLowerInclusiveValueUint16() && uint16Value <= validRange.getUpperInclusiveValueUint16()) {
                                            responseCode = characteristicData.responseCode;
                                        } else {
                                            responseCode = APPLICATION_ERROR_9F;
                                        }
                                    }
                                }
                            }
                        }

                        if (BluetoothGatt.GATT_SUCCESS == responseCode) {
                            bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(VALUE_TRIGGER_SETTING_DESCRIPTOR);
                            if (bluetoothGattDescriptor != null) {
                                Map<Pair<UUID, Integer>, DescriptorData> descriptorDataMap = mRemappedCharacteristicDescriptorMap.get(characteristicKeyPair);
                                if (descriptorDataMap != null) {
                                    UUID descriptorUUID = bluetoothGattDescriptor.getUuid();
                                    int descriptorInstanceId = BLEUtilsAndroid.getDescriptorInstanceId(bluetoothGattDescriptor);
                                    Pair<UUID, Integer> descriptorPair = Pair.create(descriptorUUID, descriptorInstanceId);
                                    DescriptorData valueTriggerDescriptorData = descriptorDataMap.get(descriptorPair);
                                    if (valueTriggerDescriptorData != null) {
                                        ValueTriggerSetting valueTriggerSetting = new ValueTriggerSetting(valueTriggerDescriptorData.getBytes());
                                        boolean isCountup = false;
                                        Analog lastAnalogData = new Analog(characteristicData.getBytes());
                                        bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(CHARACTERISTIC_PRESENTATION_FORMAT_DESCRIPTOR);
                                        CharacteristicPresentationFormat characteristicPresentationFormat = null;
                                        if (bluetoothGattDescriptor != null) {
                                            descriptorUUID = bluetoothGattDescriptor.getUuid();
                                            descriptorInstanceId = BLEUtilsAndroid.getDescriptorInstanceId(bluetoothGattDescriptor);
                                            descriptorPair = Pair.create(descriptorUUID, descriptorInstanceId);
                                            DescriptorData characteristicPresentationFormatDescriptorData = descriptorDataMap.get(descriptorPair);
                                            if (characteristicPresentationFormatDescriptorData != null) {
                                                characteristicPresentationFormat = new CharacteristicPresentationFormat(characteristicPresentationFormatDescriptorData.getBytes());
                                            }
                                        }
                                        if (characteristicPresentationFormat == null) {
                                            characteristicPresentationFormat = new CharacteristicPresentationFormat(CharacteristicPresentationFormat.FORMAT_UNSIGNED_16_BIT_INTEGER, 0, 0, 0, new byte[0]);
                                        }
                                        int lastAnalogValue = (int) AutomationIoUtils.getAnalogWithFormat(lastAnalogData.getAnalog(), characteristicPresentationFormat, 0);
                                        int currentAnalogValue = (int) AutomationIoUtils.getAnalogWithFormat(Arrays.copyOfRange(value, offset, value.length), characteristicPresentationFormat, 0);
                                        if (valueTriggerSetting.isNone0()) {
                                            isCountup = true;
                                        } else if (valueTriggerSetting.isAnalog1()) {
                                            int boundary = valueTriggerSetting.getValueAnalog();
                                            if (lastAnalogValue == boundary && (currentAnalogValue < boundary || currentAnalogValue > boundary)) {
                                                isCountup = true;
                                            }
                                        } else if (valueTriggerSetting.isAnalog2()) {
                                            int boundary = valueTriggerSetting.getValueAnalog();
                                            if (lastAnalogValue == boundary && (currentAnalogValue < boundary || currentAnalogValue > boundary)
                                                    || currentAnalogValue == boundary && (lastAnalogValue < boundary || lastAnalogValue > boundary)) {
                                                isCountup = true;
                                            }
                                        } else if (valueTriggerSetting.isAnalog3()) {
                                            int boundary = valueTriggerSetting.getValueAnalog();
                                            if (lastAnalogValue < boundary && currentAnalogValue > boundary) {
                                                isCountup = true;
                                            }
                                        } else if (valueTriggerSetting.isAnalogInterval5()) {
                                            int boundaryOne = valueTriggerSetting.getValueAnalogOne();
                                            int boundaryTwo = valueTriggerSetting.getValueAnalogTwo();
                                            if ((lastAnalogValue < boundaryOne && lastAnalogValue > boundaryTwo)
                                                    && (currentAnalogValue > boundaryOne || currentAnalogValue < boundaryTwo)) {
                                                isCountup = true;
                                            }
                                        } else if (valueTriggerSetting.isAnalogInterval6()) {
                                            int boundaryOne = valueTriggerSetting.getValueAnalogOne();
                                            int boundaryTwo = valueTriggerSetting.getValueAnalogTwo();
                                            if ((lastAnalogValue == boundaryOne || lastAnalogValue == boundaryTwo)
                                                    && (currentAnalogValue != boundaryOne || currentAnalogValue != boundaryTwo)) {
                                                isCountup = true;
                                            }
                                        }
                                        if (isCountup) {
                                            Integer count = mUpdateCountMap.get(characteristicKeyPair);
                                            if (count == null) {
                                                count = -1;
                                            }
                                            count++;
                                            mUpdateCountMap.put(characteristicKeyPair, count);
                                        }
                                    }
                                }
                            }

                            if (responseNeeded) {
                                result = bluetoothGattServer.sendResponse(device, requestId, responseCode, offset, null);
                            } else {
                                result = true;
                            }

                            if (result) {
                                mIsReliable |= preparedWrite;

                                if (mIsReliable) {
                                    characteristicData.temporaryData = Arrays.copyOfRange(value, offset, 2);
                                } else {
                                    characteristicData.currentData = Arrays.copyOfRange(value, offset, 2);
                                }
                            }

                            Integer descriptorInstanceId = null;
                            bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR);
                            if (bluetoothGattDescriptor == null) {
                                bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(AGGREGATE_CHARACTERISTIC);
                                if (bluetoothGattCharacteristic != null) {
                                    bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR);
                                    if (bluetoothGattDescriptor != null) {
                                        descriptorInstanceId = BLEUtilsAndroid.getDescriptorInstanceId(bluetoothGattDescriptor);
                                    }
                                }
                            } else {
                                descriptorInstanceId = BLEUtilsAndroid.getDescriptorInstanceId(bluetoothGattDescriptor);
                            }
                            if (descriptorInstanceId != null) {
                                startNotification(null, bleServerConnection, null, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorInstanceId, 0, null, null);
                            }
                        }
                    } else {
                        responseCode = characteristicData.responseCode;

                        if (responseNeeded) {
                            result = bluetoothGattServer.sendResponse(device, requestId, responseCode, offset, null);
                        } else {
                            result = true;
                        }

                        if (result && BluetoothGatt.GATT_SUCCESS == responseCode) {
                            mIsReliable |= preparedWrite;

                            if (mIsReliable) {
                                characteristicData.temporaryData = Arrays.copyOfRange(value, offset, value.length);
                            } else {
                                characteristicData.currentData = Arrays.copyOfRange(value, offset, value.length);
                            }
                        }
                    }
                }

                if (force && !result && responseNeeded) {
                    result = bluetoothGattServer.sendResponse(device, requestId, APPLICATION_ERROR_9F, offset, null);
                }
            }
        }
        return result;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressLint("MissingPermission")
    @Override
    public synchronized boolean onDescriptorWriteRequest(@NonNull BLEServerConnection bleServerConnection, @NonNull BluetoothDevice device, int requestId, @NonNull BluetoothGattDescriptor bluetoothGattDescriptor, boolean preparedWrite, boolean responseNeeded, int offset, @NonNull byte[] value, boolean force) {
        boolean result = false;

        long now = SystemClock.elapsedRealtime();
        BluetoothGattServer bluetoothGattServer = bleServerConnection.getBluetoothGattServer();

        if (bluetoothGattServer != null) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattDescriptor.getCharacteristic();
            BluetoothGattService bluetoothGattService = bluetoothGattCharacteristic.getService();
            UUID serviceUUID = bluetoothGattService.getUuid();
            int serviceInstanceId = bluetoothGattService.getInstanceId();
            UUID characteristicUUID = bluetoothGattCharacteristic.getUuid();
            int characteristicInstanceId = bluetoothGattCharacteristic.getInstanceId();
            Map<Pair<UUID, Integer>, DescriptorData> descriptorDataMap = mRemappedCharacteristicDescriptorMap.get(Pair.create(characteristicUUID, characteristicInstanceId));
            if (descriptorDataMap != null) {
                UUID descriptorUUID = bluetoothGattDescriptor.getUuid();
                int descriptorInstanceId = BLEUtilsAndroid.getDescriptorInstanceId(bluetoothGattDescriptor);
                Pair<UUID, Integer> descriptorPair = Pair.create(descriptorUUID, descriptorInstanceId);

                DescriptorData descriptorData = descriptorDataMap.get(descriptorPair);
                if (descriptorData != null) {
                    delay(now, descriptorData.delay);

                    if (responseNeeded) {
                        result = bluetoothGattServer.sendResponse(device, requestId, descriptorData.responseCode, offset, null);
                    } else {
                        result = true;
                    }

                    if (result && BluetoothGatt.GATT_SUCCESS == descriptorData.responseCode) {
                        mIsReliable |= preparedWrite;

                        if (mIsReliable) {
                            descriptorData.temporaryData = value;
                        } else {
                            byte[] oldData = descriptorData.getBytes();
                            descriptorData.currentData = value;

                            if (CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR.equals(descriptorUUID)) {
                                if (!Arrays.equals(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE, descriptorData.getBytes())
                                        && Arrays.equals(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE, oldData)) {
                                    startNotification(null, bleServerConnection, null, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorInstanceId, 0, null, null);
                                } else if (Arrays.equals(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE, descriptorData.getBytes())
                                        && !Arrays.equals(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE, oldData)) {
                                    mActivatedNotificationMap.remove(new NotificationData(device, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId));
                                }
                            } else if (VALUE_TRIGGER_SETTING_DESCRIPTOR.equals(descriptorUUID)) {
                                for (Pair<UUID, Integer> pair : descriptorDataMap.keySet()) {
                                    if (TIME_TRIGGER_SETTING_DESCRIPTOR.equals(pair.first)) {
                                        descriptorData = descriptorDataMap.get(pair);
                                        if (descriptorData != null) {
                                            descriptorData.currentData = null;
                                        }
                                        break;
                                    }
                                }
                            }
                        }
                    }
                }
            }

            if (force && !result && responseNeeded) {
                result = bluetoothGattServer.sendResponse(device, requestId, APPLICATION_ERROR_9F, offset, null);
            }
        }
        return result;
    }

    /**
     * create Aggreate data
     *
     * @param characteristicMap characteristic map
     * @return Aggregate data {@link ByteArrayInterface} instance
     */
    @NonNull
    protected ByteArrayInterface createAggregateData(@NonNull Map<Pair<UUID, Integer>, CharacteristicData> characteristicMap) {
        List<Pair<Pair<UUID, Integer>, Integer>> digitalList = new LinkedList<>();
        List<Pair<CharacteristicData, Integer>> analogList = new LinkedList<>();
        for (Map.Entry<Pair<UUID, Integer>, CharacteristicData> characteristicEntry : characteristicMap.entrySet()) {
            Pair<UUID, Integer> characteristicKey = characteristicEntry.getKey();
            CharacteristicData characteristicData = characteristicEntry.getValue();
            if ((DIGITAL_CHARACTERISTIC.equals(characteristicKey.first) || ANALOG_CHARACTERISTIC.equals(characteristicKey.first)
                    && (characteristicData.property & BluetoothGattCharacteristic.PROPERTY_READ) != 0)) {
                Integer order = null;
                Map<Pair<UUID, Integer>, DescriptorData> descriptorDataMap = mRemappedCharacteristicDescriptorMap.get(characteristicKey);
                if (descriptorDataMap != null) {
                    for (Map.Entry<Pair<UUID, Integer>, DescriptorData> descriptorEntry : descriptorDataMap.entrySet()) {
                        Pair<UUID, Integer> descriptorKey = descriptorEntry.getKey();
                        if (CHARACTERISTIC_PRESENTATION_FORMAT_DESCRIPTOR.equals(descriptorKey.first)) {
                            order = BLEUtils.createUInt16(new CharacteristicPresentationFormat(descriptorEntry.getValue().getBytes()).getDescription(), 0);
                            break;
                        }
                    }
                }
                if (DIGITAL_CHARACTERISTIC.equals(characteristicKey.first)) {
                    digitalList.add(Pair.create(characteristicKey, order));
                } else {
                    analogList.add(Pair.create(characteristicEntry.getValue(), order));
                }
            }
        }

        Collections.sort(digitalList, (o1, o2) -> o1.second.compareTo(o2.second));
        Collections.sort(analogList, (o1, o2) -> o1.second.compareTo(o2.second));


        int totalBits = 0;
        int[] numberOfDigitalBits = new int[digitalList.size()];
        for (int i = 0; i < digitalList.size(); i++) {
            Map<Pair<UUID, Integer>, DescriptorData> descriptorDataMap = mRemappedCharacteristicDescriptorMap.get(digitalList.get(i).first);
            if (descriptorDataMap != null) {
                for (Map.Entry<Pair<UUID, Integer>, DescriptorData> descriptorEntry : descriptorDataMap.entrySet()) {
                    Pair<UUID, Integer> descriptorKey = descriptorEntry.getKey();
                    if (NUMBER_OF_DIGITALS_DESCRIPTOR.equals(descriptorKey.first)) {
                        NumberOfDigitals numberOfDigitals = new NumberOfDigitals(descriptorEntry.getValue().getBytes());
                        numberOfDigitalBits[i] = numberOfDigitals.getNoOfDigitals() * 2;
                        totalBits += numberOfDigitalBits[i];
                        break;
                    }
                }
            }
        }

        final byte[] aggregateData = new byte[totalBits / 8 + (totalBits % 8 == 0 ? 0 : 1) + analogList.size() * 2];
        int currentBitsPosition = 0;

        for (int i = 0; i < digitalList.size(); i++) {
            CharacteristicData characteristicData = characteristicMap.get(digitalList.get(i).first);
            if (characteristicData != null) {
                byte[] currentDataArray = characteristicData.getBytes();
                for (int j = 0; j < currentDataArray.length; j++) {
                    byte currentData = currentDataArray[j];
                    int leftShift = currentBitsPosition % 8;
                    int digitalDataIndex = currentBitsPosition / 8;
                    aggregateData[digitalDataIndex] |= (0xff & (currentData << leftShift));
                    if (leftShift != 0 && digitalDataIndex + 1 < aggregateData.length) {
                        aggregateData[digitalDataIndex + 1] |= ((0xff & currentData) >> (8 - leftShift));
                    }

                    if (j == currentDataArray.length - 1) {
                        currentBitsPosition += (numberOfDigitalBits[i] % 8);
                    } else {
                        currentBitsPosition += 8;
                    }
                }
            }
        }

        for (int i = 0; i < analogList.size(); i++) {
            CharacteristicData characteristicData = analogList.get(i).first;
            if (characteristicData != null) {
                byte[] currentDataArray = characteristicData.getBytes();
                for (byte currentData : currentDataArray) {
                    int leftShift = currentBitsPosition % 8;
                    int analogDataIndex = currentBitsPosition / 8;
                    aggregateData[analogDataIndex] |= (0xff & (currentData << leftShift));
                    if (leftShift != 0 && analogDataIndex + 1 < aggregateData.length) {
                        aggregateData[analogDataIndex + 1] |= ((0xff & currentData) >> (8 - leftShift));
                    }
                    currentBitsPosition += 8;
                }
            }
        }

        return () -> aggregateData;

    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected synchronized void startNotification(@Nullable Integer taskId, @NonNull BLEServerConnection bleServerConnection, @Nullable BluetoothDevice device, @NonNull UUID serviceUUID, int serviceInstanceId, @NonNull UUID characteristicUUID, int characteristicInstanceId, int descriptorInstanceId, long delay, @Nullable Integer notificationCount, @Nullable Bundle argument) {
        if (DIGITAL_CHARACTERISTIC.equals(characteristicUUID) || ANALOG_CHARACTERISTIC.equals(characteristicUUID)) {
            Map<Pair<UUID, Integer>, CharacteristicData> characteristicMap = mRemappedServiceCharacteristicMap.get(Pair.create(serviceUUID, serviceInstanceId));
            if (characteristicMap != null) {
                Pair<UUID, Integer> characteristicKey = Pair.create(characteristicUUID, characteristicInstanceId);
                CharacteristicData characteristicData = characteristicMap.get(characteristicKey);
                if (characteristicData != null) {
                    Map<Pair<UUID, Integer>, DescriptorData> descriptorDataMap = mRemappedCharacteristicDescriptorMap.get(characteristicKey);
                    if (descriptorDataMap != null) {
                        Bundle bundle = new Bundle();
                        Boolean isConfirm = null;

                        DescriptorData descriptorData = descriptorDataMap.get(Pair.create(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, descriptorInstanceId));
                        if (descriptorData != null) {
                            if ((characteristicData.property & BluetoothGattCharacteristic.PROPERTY_NOTIFY) != 0 && Arrays.equals(BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE, descriptorData.getBytes())) {
                                isConfirm = false;
                            } else if ((characteristicData.property & BluetoothGattCharacteristic.PROPERTY_INDICATE) != 0 && Arrays.equals(BluetoothGattDescriptor.ENABLE_INDICATION_VALUE, descriptorData.getBytes())) {
                                isConfirm = true;
                            }
                        }

                        if (isConfirm != null) {
                            DescriptorData timeTriggerSettingDescriptorData = null;
                            for (Map.Entry<Pair<UUID, Integer>, DescriptorData> entry : descriptorDataMap.entrySet()) {
                                if (TIME_TRIGGER_SETTING_DESCRIPTOR.equals(entry.getKey().first)) {
                                    timeTriggerSettingDescriptorData = entry.getValue();
                                    break;
                                }
                            }

                            boolean isTimeTriggered = false;
                            if (timeTriggerSettingDescriptorData == null) {
                                isTimeTriggered = true;
                            } else {
                                TimeTriggerSetting timeTriggerSetting = new TimeTriggerSetting(timeTriggerSettingDescriptorData.getBytes());
                                if (timeTriggerSetting.isConditionNoTimeBasedTriggeringUsed()) {
                                    isTimeTriggered = true;
                                } else if (timeTriggerSetting.isConditionIndicatesOrNotifiedIUnconditionallyAfterASettableTime()) {
                                    bundle.putInt(KEY_NEXT_NOTIFICATION, timeTriggerSetting.getValueTimeInterval());
                                    isTimeTriggered = true;
                                } else if (timeTriggerSetting.isConditionNotIndicatedOrNotifiedMoreOftenThanASettableTime()) {
                                    int timeInterval = timeTriggerSetting.getValueTimeInterval();
                                    Long lastNotifyTime = mLastNotifyMap.get(characteristicKey);
                                    if (lastNotifyTime == null || (SystemClock.elapsedRealtime() - lastNotifyTime) > timeInterval * DateUtils.SECOND_IN_MILLIS) {
                                        isTimeTriggered = true;
                                    }
                                } else if (timeTriggerSetting.isConditionChangedMoreOfthenThan()) {
                                    Integer count = mUpdateCountMap.get(characteristicKey);
                                    if (count != null && count > timeTriggerSetting.getValueCount()) {
                                        mUpdateCountMap.put(characteristicKey, 0);
                                        isTimeTriggered = true;
                                    }
                                }
                            }

                            if (isTimeTriggered) {
                                bundle.putInt(KEY_NOTIFICATION_COUNT, notificationCount == null ? characteristicData.notificationCount : notificationCount);
                                bundle.putInt(KEY_DESCRIPTOR_INSTANCE_ID, descriptorInstanceId);
                                if (argument != null) {
                                    bundle.putBundle(KEY_ORIGINAL_ARGUMENT, argument);
                                }
                                mLastNotifyMap.put(characteristicKey, SystemClock.elapsedRealtime());

                                NotificationData notificationData;
                                if (device == null) {
                                    for (BluetoothDevice bluetoothDevice : mConnectedDeviceSet) {
                                        notificationData = new NotificationData(bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId);
                                        if (!mActivatedNotificationMap.containsKey(notificationData)) {
                                            Integer newTaskId = bleServerConnection.createNotificationTask(bluetoothDevice
                                                    , serviceUUID
                                                    , serviceInstanceId
                                                    , characteristicUUID
                                                    , characteristicInstanceId
                                                    , characteristicData
                                                    , isConfirm
                                                    , NotificationTask.TIMEOUT_MILLIS
                                                    , delay
                                                    , bundle
                                                    , this);
                                            if (newTaskId != null) {
                                                mActivatedNotificationMap.put(notificationData, newTaskId);
                                            }
                                        }
                                    }
                                } else {
                                    notificationData = new NotificationData(device, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId);
                                    if (mConnectedDeviceSet.contains(device)) {
                                        Integer currentTaskId = mActivatedNotificationMap.get(notificationData);
                                        if (currentTaskId == null || currentTaskId.equals(taskId)) {
                                            Integer newTaskId = bleServerConnection.createNotificationTask(device
                                                    , serviceUUID
                                                    , serviceInstanceId
                                                    , characteristicUUID
                                                    , characteristicInstanceId
                                                    , characteristicData
                                                    , isConfirm
                                                    , NotificationTask.TIMEOUT_MILLIS
                                                    , delay
                                                    , bundle
                                                    , this);
                                            if (newTaskId != null) {
                                                mActivatedNotificationMap.put(notificationData, newTaskId);
                                            }
                                        }
                                    } else {
                                        mActivatedNotificationMap.remove(notificationData);
                                    }
                                }
                            } else if (taskId != null && device != null) {
                                mActivatedNotificationMap.remove(new NotificationData(device, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId));
                            }
                        }
                    }
                }
            }
        } else if (AGGREGATE_CHARACTERISTIC.equals(characteristicUUID)) {
            Map<Pair<UUID, Integer>, CharacteristicData> characteristicMap = mRemappedServiceCharacteristicMap.get(Pair.create(serviceUUID, serviceInstanceId));
            if (characteristicMap != null) {
                Pair<UUID, Integer> characteristicKey = Pair.create(characteristicUUID, characteristicInstanceId);
                CharacteristicData characteristicData = characteristicMap.get(characteristicKey);
                if (characteristicData != null) {
                    Map<Pair<UUID, Integer>, DescriptorData> descriptorDataMap = mRemappedCharacteristicDescriptorMap.get(characteristicKey);
                    if (descriptorDataMap != null) {
                        Bundle bundle = new Bundle();
                        Boolean isConfirm = null;

                        DescriptorData descriptorData = descriptorDataMap.get(Pair.create(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, descriptorInstanceId));
                        if (descriptorData != null) {
                            if ((characteristicData.property & BluetoothGattCharacteristic.PROPERTY_NOTIFY) != 0 && Arrays.equals(BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE, descriptorData.getBytes())) {
                                isConfirm = false;
                            } else if ((characteristicData.property & BluetoothGattCharacteristic.PROPERTY_INDICATE) != 0 && Arrays.equals(BluetoothGattDescriptor.ENABLE_INDICATION_VALUE, descriptorData.getBytes())) {
                                isConfirm = true;
                            }

                            if (isConfirm != null) {
                                boolean isTimeTriggered = false;
                                List<Integer> intervalList = new LinkedList<>();
                                for (Map.Entry<Pair<UUID, Integer>, CharacteristicData> characteristicEntry : characteristicMap.entrySet()) {
                                    boolean isCurrentTimeTriggered = false;
                                    Pair<UUID, Integer> currentCharacteristicKey = characteristicEntry.getKey();
                                    CharacteristicData currentCharacteristicData = characteristicEntry.getValue();
                                    boolean hasTimeTriggerSettingDescriptor = false;
                                    if ((DIGITAL_CHARACTERISTIC.equals(currentCharacteristicKey.first) || ANALOG_CHARACTERISTIC.equals(currentCharacteristicKey.first))
                                            && (currentCharacteristicData.property & BluetoothGattCharacteristic.PROPERTY_READ) != 0) {
                                        Map<Pair<UUID, Integer>, DescriptorData> currentDescriptorDataMap = mRemappedCharacteristicDescriptorMap.get(currentCharacteristicKey);
                                        if (currentDescriptorDataMap != null) {
                                            for (Map.Entry<Pair<UUID, Integer>, DescriptorData> currentDescriptorEntry : currentDescriptorDataMap.entrySet()) {
                                                if (TIME_TRIGGER_SETTING_DESCRIPTOR.equals(currentDescriptorEntry.getKey().first)) {
                                                    hasTimeTriggerSettingDescriptor = true;
                                                    DescriptorData timeTriggerSettingDescriptorData = currentDescriptorEntry.getValue();

                                                    if (timeTriggerSettingDescriptorData != null) {
                                                        TimeTriggerSetting timeTriggerSetting = new TimeTriggerSetting(timeTriggerSettingDescriptorData.getBytes());
                                                        if (timeTriggerSetting.isConditionNoTimeBasedTriggeringUsed()) {
                                                            isCurrentTimeTriggered = true;
                                                        } else if (timeTriggerSetting.isConditionIndicatesOrNotifiedIUnconditionallyAfterASettableTime()) {
                                                            intervalList.add(timeTriggerSetting.getValueTimeInterval());
                                                            isCurrentTimeTriggered = true;
                                                        } else if (timeTriggerSetting.isConditionNotIndicatedOrNotifiedMoreOftenThanASettableTime()) {
                                                            int timeInterval = timeTriggerSetting.getValueTimeInterval();
                                                            Long lastNotifyTime = mLastNotifyMap.get(currentCharacteristicKey);
                                                            if (lastNotifyTime == null || (SystemClock.elapsedRealtime() - lastNotifyTime) > timeInterval * DateUtils.SECOND_IN_MILLIS) {
                                                                isCurrentTimeTriggered = true;
                                                            }
                                                        } else if (timeTriggerSetting.isConditionChangedMoreOfthenThan()) {
                                                            Integer count = mUpdateCountMap.get(currentCharacteristicKey);
                                                            if (count != null && count > timeTriggerSetting.getValueCount()) {
                                                                mUpdateCountMap.put(currentCharacteristicKey, 0);
                                                                isCurrentTimeTriggered = true;
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }

                                    if (isCurrentTimeTriggered) {
                                        mLastNotifyMap.put(currentCharacteristicKey, SystemClock.elapsedRealtime());
                                    }
                                    isTimeTriggered |= isCurrentTimeTriggered;
                                    isTimeTriggered |= !hasTimeTriggerSettingDescriptor;
                                }

                                if (isTimeTriggered) {
                                    bundle.putInt(KEY_NOTIFICATION_COUNT, notificationCount == null ? characteristicData.notificationCount : notificationCount);
                                    bundle.putInt(KEY_DESCRIPTOR_INSTANCE_ID, descriptorInstanceId);
                                    if (argument != null) {
                                        bundle.putBundle(KEY_ORIGINAL_ARGUMENT, argument);
                                    }
                                    if (!intervalList.isEmpty()) {
                                        Collections.sort(intervalList);
                                        bundle.putInt(KEY_NEXT_NOTIFICATION, intervalList.get(0));
                                    }

                                    ByteArrayInterface aggregateData = createAggregateData(characteristicMap);

                                    NotificationData notificationData;
                                    if (device == null) {
                                        for (BluetoothDevice bluetoothDevice : mConnectedDeviceSet) {
                                            notificationData = new NotificationData(bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId);
                                            if (!mActivatedNotificationMap.containsKey(notificationData)) {
                                                Integer newTaskId = bleServerConnection.createNotificationTask(bluetoothDevice
                                                        , serviceUUID
                                                        , serviceInstanceId
                                                        , characteristicUUID
                                                        , characteristicInstanceId
                                                        , aggregateData
                                                        , isConfirm
                                                        , NotificationTask.TIMEOUT_MILLIS
                                                        , delay
                                                        , bundle
                                                        , this);
                                                if (newTaskId != null) {
                                                    mActivatedNotificationMap.put(notificationData, newTaskId);
                                                }
                                            }
                                        }
                                    } else {
                                        notificationData = new NotificationData(device, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId);
                                        if (mConnectedDeviceSet.contains(device)) {
                                            Integer currentTaskId = mActivatedNotificationMap.get(notificationData);
                                            if (currentTaskId == null || currentTaskId.equals(taskId)) {
                                                Integer newTaskId = bleServerConnection.createNotificationTask(device
                                                        , serviceUUID
                                                        , serviceInstanceId
                                                        , characteristicUUID
                                                        , characteristicInstanceId
                                                        , aggregateData
                                                        , isConfirm
                                                        , NotificationTask.TIMEOUT_MILLIS
                                                        , delay
                                                        , bundle
                                                        , this);
                                                if (newTaskId != null) {
                                                    mActivatedNotificationMap.put(notificationData, newTaskId);
                                                }
                                            }
                                        } else {
                                            mActivatedNotificationMap.remove(notificationData);
                                        }
                                    }
                                } else if (taskId != null && device != null) {
                                    mActivatedNotificationMap.remove(new NotificationData(device, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId));
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
    protected synchronized void repeatNotification(@NonNull Integer taskId, @NonNull BLEServerConnection bleServerConnection, @NonNull BluetoothDevice device, @NonNull UUID serviceUUID, int serviceInstanceId, @NonNull UUID characteristicUUID, int characteristicInstanceId, @Nullable Bundle argument) {
        Map<Pair<UUID, Integer>, CharacteristicData> characteristicMap = mRemappedServiceCharacteristicMap.get(Pair.create(serviceUUID, serviceInstanceId));
        if (characteristicMap != null) {
            CharacteristicData characteristicData = characteristicMap.get(Pair.create(characteristicUUID, characteristicInstanceId));
            if (characteristicData != null && argument != null && argument.containsKey(KEY_NOTIFICATION_COUNT)) {
                int notificationCount = argument.getInt(KEY_NOTIFICATION_COUNT);
                if (notificationCount > 0) {
                    notificationCount--;
                }
                if (notificationCount == 0) {
                    mActivatedNotificationMap.remove(new NotificationData(device, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId));
                } else {
                    int descriptorInstanceId = argument.getInt(KEY_DESCRIPTOR_INSTANCE_ID, -1);
                    long delay;
                    if (argument.containsKey(KEY_NEXT_NOTIFICATION)) {
                        delay = argument.getInt(KEY_NEXT_NOTIFICATION) * DateUtils.SECOND_IN_MILLIS;
                    } else {
                        delay = NOTIFICATION_INTERVAL;
                    }
                    startNotification(taskId, bleServerConnection, device, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorInstanceId, delay, notificationCount, null);
                }
            }
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
