package org.im97mori.ble.service.aios.peripheral;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattServer;
import android.bluetooth.BluetoothGattService;
import android.bluetooth.le.AdvertiseSettings;
import android.os.Bundle;
import android.os.Parcel;
import android.os.SystemClock;
import android.util.Pair;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.im97mori.ble.BLEServerConnection;
import org.im97mori.ble.CharacteristicData;
import org.im97mori.ble.DescriptorData;
import org.im97mori.ble.MockData;
import org.im97mori.ble.ServiceData;
import org.im97mori.ble.callback.NotificationData;
import org.im97mori.ble.descriptor.u2900.CharacteristicExtendedProperties;
import org.im97mori.ble.service.peripheral.AbstractServiceMockCallback;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.AGGREGATE_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.CharacteristicUUID.DIGITAL_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.DescriptorUUID.CHARACTERISTIC_EXTENDED_PROPERTIES_DESCRIPTOR;
import static org.im97mori.ble.BLEConstants.DescriptorUUID.CHARACTERISTIC_PRESENTATION_FORMAT_DESCRIPTOR;
import static org.im97mori.ble.BLEConstants.DescriptorUUID.CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR;
import static org.im97mori.ble.BLEConstants.DescriptorUUID.CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
import static org.im97mori.ble.BLEConstants.DescriptorUUID.NUMBEROF_DIGITALS_DESCRIPTOR;
import static org.im97mori.ble.BLEConstants.DescriptorUUID.TIME_TRIGGER_SETTING_DESCRIPTOR;
import static org.im97mori.ble.BLEConstants.DescriptorUUID.VALID_RANGE_DESCRIPTOR;
import static org.im97mori.ble.BLEConstants.DescriptorUUID.VALUE_TRIGGER_SETTING_DESCRIPTOR;
import static org.im97mori.ble.BLEConstants.ErrorCodes.APPLICATION_ERROR_9F;
import static org.im97mori.ble.BLEConstants.ServiceUUID.AUTOMATION_IO_SERVICE;

// TODO notification関連
/**
 * Automation IO Service (Service UUID: 0x1815) for Peripheral
 */
public class AutomationIOServiceMockCallback extends AbstractServiceMockCallback {

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
         *                     {@link android.bluetooth.BluetoothGattCharacteristic#PROPERTY_NOTIFY}
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
            if ((property & BluetoothGattCharacteristic.PROPERTY_WRITE) != 0) {
                permission |= BluetoothGattCharacteristic.PERMISSION_WRITE;
            }
            mDigitalMap.put(index, new CharacteristicData(DIGITAL_CHARACTERISTIC
                    , property
                    , permission
                    , new ArrayList<DescriptorData>()
                    , responseCode
                    , delay
                    , value
                    , 1));
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
         * @param permission   {@link BluetoothGattDescriptor#BluetoothGattDescriptor(UUID, int)} 3rd parameter
         * @param responseCode response code, {@link android.bluetooth.BluetoothGatt#GATT_SUCCESS} or etc
         * @param delay        response delay(millis)
         * @param value        data for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> addDigitalCharacteristicUserDescription(int index
                , int permission
                , int responseCode
                , long delay
                , @NonNull byte[] value) {
            mDigitalCharacteristicUserDescriptionMap.put(index
                    , new DescriptorData(CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR
                            , permission
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
        public Builder<T> addDigitalTimeTriggerSettingSetting(int index
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
        public Builder<T> removeDigitalTimeTriggerSettingSetting(int index) {
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
                    , new DescriptorData(NUMBEROF_DIGITALS_DESCRIPTOR
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
         *                     {@link android.bluetooth.BluetoothGattCharacteristic#PROPERTY_NOTIFY}
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
            if ((property & BluetoothGattCharacteristic.PROPERTY_WRITE) != 0) {
                permission |= BluetoothGattCharacteristic.PERMISSION_WRITE;
            }
            mAnalogMap.put(index, new CharacteristicData(DIGITAL_CHARACTERISTIC
                    , property
                    , permission
                    , new ArrayList<DescriptorData>()
                    , responseCode
                    , delay
                    , value
                    , 1));
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
         * @param permission   {@link BluetoothGattDescriptor#BluetoothGattDescriptor(UUID, int)} 3rd parameter
         * @param responseCode response code, {@link android.bluetooth.BluetoothGatt#GATT_SUCCESS} or etc
         * @param delay        response delay(millis)
         * @param value        data for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> addAnalogCharacteristicUserDescription(int index
                , int permission
                , int responseCode
                , long delay
                , @NonNull byte[] value) {
            mAnalogCharacteristicUserDescriptionMap.put(index
                    , new DescriptorData(CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR
                            , permission
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
        public Builder<T> addAnalogTimeTriggerSettingSetting(int index
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
        public Builder<T> removeAnalogTimeTriggerSettingSetting(int index) {
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
        public Builder<T> addAnalogValidRangeSetting(int index
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
        public Builder<T> removeAnalogValidRangeSetting(int index) {
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
            if ((property & BluetoothGattCharacteristic.PROPERTY_WRITE) != 0) {
                permission |= BluetoothGattCharacteristic.PERMISSION_WRITE;
            }
            mAggregateData = new CharacteristicData(AGGREGATE_CHARACTERISTIC
                    , property
                    , permission
                    , new ArrayList<DescriptorData>()
                    , responseCode
                    , delay
                    , new byte[0]
                    , 1);
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
                } else if (!isNotificatable && isIndicatable && (mAggregateData.property & BluetoothGattCharacteristic.PROPERTY_READ) != 0) {
                    throw new RuntimeException("Aggregate Characteristic Read property is not supported");
                }
                characteristicDataList.add(mAggregateData);
                isAggregateNotificatable = isNotificatable | isIndicatable;
                if (!isAggregateNotificatable && (mAggregateData.property & BluetoothGattCharacteristic.PROPERTY_READ) != 0) {
                    throw new RuntimeException("Aggregate characteristic Read property is not supported");
                }
            } else {
                isAggregateNotificatable = false;
            }

            CharacteristicData characteristicData;
            DescriptorData descriptorData;
            CharacteristicExtendedProperties characteristicExtendedProperties;

            int index;
            for (Map.Entry<Integer, CharacteristicData> entry : mDigitalMap.entrySet()) {
                index = entry.getKey();
                characteristicData = entry.getValue();

                isNotificatable = (characteristicData.property & BluetoothGattCharacteristic.PROPERTY_NOTIFY) != 0;
                isIndicatable = (characteristicData.property & BluetoothGattCharacteristic.PROPERTY_INDICATE) != 0;
                if (isNotificatable && isIndicatable) {
                    throw new RuntimeException("The Indicate and Notify properties shall not be permitted simultaneously for Digital characteristic. index:" + index);
                } else if (isNotificatable || isIndicatable) {
                    if (isAggregateNotificatable) {
                        throw new RuntimeException("The Indicate and Notify properties are excluded for the Digital characteristic if the Aggregate characteristic is supported. index:" + index);
                    }
                    descriptorData = mDigitalClientCharacteristicConfigurationMap.get(index);
                    if (descriptorData == null) {
                        descriptorData = new DescriptorData(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, BluetoothGatt.GATT_SUCCESS, 0, BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE);
                    }
                    characteristicData.descriptorDataList.add(descriptorData);
                } else if ((!isNotificatable && !isIndicatable) && ((characteristicData.property & BluetoothGattCharacteristic.PROPERTY_READ) != 0)) {
                    throw new RuntimeException("Digital characteristic Read property is not supported. index:" + index);
                }

                descriptorData = mDigitalCharacteristicPresentationFormatMap.get(index);
                if (descriptorData == null && mDigitalMap.size() > 1) {
                    throw new RuntimeException("Digital characteristic Characteristic Presentation Format descriptor not found. index:" + index);
                }
                characteristicData.descriptorDataList.add(descriptorData);

                descriptorData = mDigitalCharacteristicExtendedPropertiesMap.get(index);
                if (descriptorData == null) {
                    characteristicExtendedProperties = null;
                } else {
                    characteristicExtendedProperties = new CharacteristicExtendedProperties(descriptorData.getBytes());
                    characteristicData.descriptorDataList.add(descriptorData);
                }

                descriptorData = mDigitalCharacteristicUserDescriptionMap.get(index);
                if (descriptorData != null) {
                    if ((descriptorData.permission & BluetoothGattDescriptor.PERMISSION_WRITE) != 0 && (characteristicExtendedProperties == null || characteristicExtendedProperties.isPropertiesWritableAuxiliariesDisabled())) {
                        throw new RuntimeException("Digital characteristic Characteristic User Description descriptor is not writable. index:" + index);
                    }
                    characteristicData.descriptorDataList.add(descriptorData);
                }

                if (isNotificatable || isAggregateNotificatable) {
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
                }
                characteristicData.descriptorDataList.add(descriptorData);

                characteristicDataList.add(characteristicData);
            }

            for (Map.Entry<Integer, CharacteristicData> entry : mAnalogMap.entrySet()) {
                index = entry.getKey();
                characteristicData = entry.getValue();

                isNotificatable = (characteristicData.property & BluetoothGattCharacteristic.PROPERTY_NOTIFY) != 0;
                isIndicatable = (characteristicData.property & BluetoothGattCharacteristic.PROPERTY_INDICATE) != 0;
                if (isNotificatable && isIndicatable) {
                    throw new RuntimeException("The Indicate and Notify properties shall not be permitted simultaneously for Analog characteristic. index" + index);
                } else if (isNotificatable || isIndicatable) {
                    if (isAggregateNotificatable) {
                        throw new RuntimeException("The Indicate and Notify properties are excluded for the Analog characteristic if the Aggregate characteristic is supported. index:" + index);
                    }
                    descriptorData = mAnalogClientCharacteristicConfigurationMap.get(index);
                    if (descriptorData == null) {
                        descriptorData = new DescriptorData(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, BluetoothGatt.GATT_SUCCESS, 0, BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE);
                    }
                    characteristicData.descriptorDataList.add(descriptorData);
                } else {
                    if ((characteristicData.property & BluetoothGattCharacteristic.PROPERTY_READ) != 0) {
                        throw new RuntimeException("Read property is not supported. index:" + index);
                    }
                }

                descriptorData = mAnalogCharacteristicPresentationFormatMap.get(index);
                if (descriptorData == null && mDigitalMap.size() > 1) {
                    throw new RuntimeException("Analog characteristic Characteristic Presentation Format descriptor not found. index:" + index);
                }
                characteristicData.descriptorDataList.add(descriptorData);

                descriptorData = mAnalogCharacteristicExtendedPropertiesMap.get(index);
                if (descriptorData == null) {
                    characteristicExtendedProperties = null;
                } else {
                    characteristicExtendedProperties = new CharacteristicExtendedProperties(descriptorData.getBytes());
                    characteristicData.descriptorDataList.add(descriptorData);
                }

                descriptorData = mAnalogCharacteristicUserDescriptionMap.get(index);
                if (descriptorData != null) {
                    if ((descriptorData.permission & BluetoothGattDescriptor.PERMISSION_WRITE) != 0 && (characteristicExtendedProperties == null || characteristicExtendedProperties.isPropertiesWritableAuxiliariesDisabled())) {
                        throw new RuntimeException("Analog characteristic Characteristic User Description descriptor is not writable. index:" + index);
                    }
                    characteristicData.descriptorDataList.add(descriptorData);
                }

                if (isNotificatable || isAggregateNotificatable) {
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
                }
                characteristicData.descriptorDataList.add(descriptorData);

                characteristicDataList.add(characteristicData);
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
     * @param mockData   {@link MockData} instance
     * @param isFallback fallback flag
     */
    public AutomationIOServiceMockCallback(@NonNull MockData mockData, boolean isFallback) {
        super(mockData, isFallback);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onServerStarted() {

    }

    /**
     * {@inheritDoc}
     */
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
                Parcel parcel = Parcel.obtain();
                bluetoothGattDescriptor.writeToParcel(parcel, 0);
                parcel.setDataPosition(0);
                parcel.readParcelable(getClass().getClassLoader());
                int descriptorInstanceId = parcel.readInt();
                parcel.recycle();
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
                                if (!Arrays.equals(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE, descriptorData.currentData)
                                        && Arrays.equals(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE, oldData)) {
                                    startNotification(null, bleServerConnection, null, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorInstanceId, 0, null, null);
                                } else if (Arrays.equals(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE, descriptorData.currentData)
                                        && !Arrays.equals(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE, oldData)) {
                                    mActivatedNotificationMap.remove(new NotificationData(device, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId));
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
     * {@inheritDoc}
     */
    @Override
    public void onServiceAddFailed(@NonNull Integer taskId, @NonNull BLEServerConnection bleServerConnection, @NonNull BluetoothGattService bluetoothGattService, int status, @Nullable Bundle argument) {

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onServiceAddTimeout(@NonNull Integer taskId, @NonNull BLEServerConnection bleServerConnection, @NonNull BluetoothGattService bluetoothGattService, long timeout, @Nullable Bundle argument) {

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onServiceRemoveFailed(@NonNull Integer taskId, @NonNull BLEServerConnection bleServerConnection, @NonNull BluetoothGattService bluetoothGattService, int status, @Nullable Bundle argument) {

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onServiceRemoveTimeout(@NonNull Integer taskId, @NonNull BLEServerConnection bleServerConnection, @NonNull BluetoothGattService bluetoothGattService, long timeout, @Nullable Bundle argument) {

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onAdvertisingStartSuccess(@NonNull AdvertiseSettings advertiseSettings) {

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onAdvertisingStartFailed(@Nullable Integer errorCode) {

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onAdvertisingFinished() {

    }

}
