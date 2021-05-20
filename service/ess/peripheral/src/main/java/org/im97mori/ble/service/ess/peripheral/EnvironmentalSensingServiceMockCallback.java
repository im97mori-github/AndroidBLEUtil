package org.im97mori.ble.service.ess.peripheral;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import android.bluetooth.le.AdvertiseSettings;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.im97mori.ble.BLEServerConnection;
import org.im97mori.ble.CharacteristicData;
import org.im97mori.ble.DescriptorData;
import org.im97mori.ble.MockData;
import org.im97mori.ble.ServiceData;
import org.im97mori.ble.characteristic.u2a2c.MagneticDeclination;
import org.im97mori.ble.characteristic.u2a6c.Elevation;
import org.im97mori.ble.characteristic.u2a6d.Pressure;
import org.im97mori.ble.characteristic.u2a6e.Temperature;
import org.im97mori.ble.characteristic.u2a6f.Humidity;
import org.im97mori.ble.characteristic.u2a70.TrueWindSpeed;
import org.im97mori.ble.characteristic.u2a71.TrueWindDirection;
import org.im97mori.ble.characteristic.u2a72.ApparentWindSpeed;
import org.im97mori.ble.characteristic.u2a73.ApparentWindDirection;
import org.im97mori.ble.characteristic.u2a74.GustFactor;
import org.im97mori.ble.characteristic.u2a75.PollenConcentration;
import org.im97mori.ble.characteristic.u2a76.UVIndex;
import org.im97mori.ble.characteristic.u2a77.Irradiance;
import org.im97mori.ble.characteristic.u2a78.Rainfall;
import org.im97mori.ble.characteristic.u2a79.WindChill;
import org.im97mori.ble.characteristic.u2a7a.HeatIndex;
import org.im97mori.ble.characteristic.u2a7b.DewPoint;
import org.im97mori.ble.characteristic.u2aa0.MagneticFluxDensity2D;
import org.im97mori.ble.characteristic.u2aa1.MagneticFluxDensity3D;
import org.im97mori.ble.characteristic.u2aa3.BarometricPressureTrend;
import org.im97mori.ble.descriptor.u2901.CharacteristicUserDescription;
import org.im97mori.ble.descriptor.u2902.ClientCharacteristicConfiguration;
import org.im97mori.ble.descriptor.u2906.ValidRange;
import org.im97mori.ble.descriptor.u290b.EnvironmentalSensingConfiguration;
import org.im97mori.ble.descriptor.u290c.EnvironmentalSensingMeasurement;
import org.im97mori.ble.descriptor.u290d.EnvironmentalSensingTriggerSetting;
import org.im97mori.ble.service.peripheral.AbstractServiceMockCallback;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.APPARENT_WIND_DIRECTION_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.CharacteristicUUID.APPARENT_WIND_SPEED_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.CharacteristicUUID.BAROMETRIC_PRESSURE_TREND_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.CharacteristicUUID.DESCRIPTOR_VALUE_CHANGED_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.CharacteristicUUID.DEW_POINT_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.CharacteristicUUID.ELEVATION_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.CharacteristicUUID.GUST_FACTOR_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.CharacteristicUUID.HEAT_INDEX_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.CharacteristicUUID.HUMIDITY_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.CharacteristicUUID.IRRADIANCE_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.CharacteristicUUID.MAGNETIC_DECLINATION_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.CharacteristicUUID.MAGNETIC_FLUX_DENSITY_2D_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.CharacteristicUUID.MAGNETIC_FLUX_DENSITY_3D_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.CharacteristicUUID.POLLEN_CONCENTRATION_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.CharacteristicUUID.PRESSURE_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.CharacteristicUUID.RAINFALL_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.CharacteristicUUID.TEMPERATURE_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.CharacteristicUUID.TRUE_WIND_DIRECTION_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.CharacteristicUUID.TRUE_WIND_SPEED_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.CharacteristicUUID.UV_INDEX_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.CharacteristicUUID.WIND_CHILL_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.DescriptorUUID.CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR;
import static org.im97mori.ble.BLEConstants.DescriptorUUID.CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
import static org.im97mori.ble.BLEConstants.DescriptorUUID.ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR;
import static org.im97mori.ble.BLEConstants.DescriptorUUID.ENVIRONMENTAL_SENSING_MEASUREMENT_DESCRIPTOR;
import static org.im97mori.ble.BLEConstants.DescriptorUUID.ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR;
import static org.im97mori.ble.BLEConstants.DescriptorUUID.VALID_RANGE_DESCRIPTOR;
import static org.im97mori.ble.BLEConstants.ServiceUUID.ENVIRONMENTAL_SENSING_SERVICE;

/**
 * Environmental Sensing Service (Service UUID: 0x181A) for Peripheral
 * (writable Characteristic User Description is not supported)
 */
public class EnvironmentalSensingServiceMockCallback extends AbstractServiceMockCallback {

    /**
     * Builder for {@link EnvironmentalSensingServiceMockCallback}
     *
     * @param <T> subclass of {@link EnvironmentalSensingServiceMockCallback}
     */
    public static class Builder<T extends EnvironmentalSensingServiceMockCallback> extends AbstractServiceMockCallback.Builder<EnvironmentalSensingServiceMockCallback> {

        /**
         * Descriptor Value Changed data
         */
        protected CharacteristicData mDescriptorValueChanged;

        /**
         * ES data
         */
        protected final Map<UUID, Map<Integer, CharacteristicData>> mEsCharacteristicDataMap = new HashMap<>();

        /**
         * ES Measurement map
         */
        protected final Map<UUID, Map<Integer, DescriptorData>> mEsMeasurementMap = new HashMap<>();

        /**
         * ES Trigger Setting map
         */
        protected final Map<UUID, Map<Integer, Map<Integer, DescriptorData>>> mEsTriggerSettingMap = new HashMap<>();

        /**
         * ES Configuration map
         */
        protected final Map<UUID, Map<Integer, DescriptorData>> mEsConfigurationMap = new HashMap<>();

        /**
         * Characteristic User Description map
         */
        protected final Map<UUID, Map<Integer, DescriptorData>> mCharacteristicUserDescriptionMap = new HashMap<>();

        /**
         * Valid Range map
         */
        protected final Map<UUID, Map<Integer, DescriptorData>> mValidRangeMap = new HashMap<>();

        /**
         * @see #addDescriptorValueChanged(int, long, byte[])
         */
        @NonNull
        public Builder<T> addDescriptorValueChanged(@NonNull ClientCharacteristicConfiguration clientCharacteristicConfiguration) {
            return addDescriptorValueChanged(BluetoothGatt.GATT_SUCCESS, 0, clientCharacteristicConfiguration.getBytes());
        }

        /**
         * add Descriptor Value Changed characteristic
         *
         * @param descriptorResponseCode descritptor response code for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 3rd parameter
         * @param descriptorDelay        descritptor response delay(millis)
         * @param descriptorValue        descriptor data array for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> addDescriptorValueChanged(int descriptorResponseCode, long descriptorDelay, @NonNull byte[] descriptorValue) {
            mDescriptorValueChanged = new CharacteristicData(DESCRIPTOR_VALUE_CHANGED_CHARACTERISTIC
                    , BluetoothGattCharacteristic.PROPERTY_INDICATE
                    , 0
                    , Collections.singletonList(new DescriptorData(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR
                    , BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE
                    , descriptorResponseCode
                    , descriptorDelay
                    , descriptorValue))
                    , BluetoothGatt.GATT_SUCCESS
                    , 0
                    , null
                    , 0);
            return this;
        }

        /**
         * remove Descriptor Value Changed characteristic
         *
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> removeDescriptorValueChanged() {
            mDescriptorValueChanged = null;
            return this;
        }

        /**
         * @see #addApparentWindDirection(int, int, int, long, byte[])
         */
        @NonNull
        public Builder<T> addApparentWindDirection(int index, @NonNull ApparentWindDirection apparentWindDirection) {
            return addApparentWindDirection(index, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, BluetoothGattCharacteristic.PERMISSION_READ, 0, apparentWindDirection.getBytes());
        }

        /**
         * add Apparent Wind Direction characteristic
         *
         * @param index        Apparent Wind Direction index
         * @param property     combination of
         *                     {@link android.bluetooth.BluetoothGattCharacteristic#PROPERTY_READ}
         *                     {@link android.bluetooth.BluetoothGattCharacteristic#PROPERTY_NOTIFY}
         * @param responseCode response code, {@link android.bluetooth.BluetoothGatt#GATT_SUCCESS} or etc
         * @param delay        response delay(millis)
         * @param value        data for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> addApparentWindDirection(int index, int property, int responseCode, long delay, @NonNull byte[] value) {
            Map<Integer, CharacteristicData> characteristicDataMap = mEsCharacteristicDataMap.get(APPARENT_WIND_DIRECTION_CHARACTERISTIC);
            if (characteristicDataMap == null) {
                characteristicDataMap = new HashMap<>();
                mEsCharacteristicDataMap.put(APPARENT_WIND_DIRECTION_CHARACTERISTIC, characteristicDataMap);
            }
            characteristicDataMap.put(index, new CharacteristicData(APPARENT_WIND_DIRECTION_CHARACTERISTIC, property, BluetoothGattCharacteristic.PERMISSION_READ, new ArrayList<>(), responseCode, delay, value, 0));
            return this;
        }

        /**
         * remove Apparent Wind Direction characteristic
         *
         * @param index Apparent Wind Direction index
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> removeApparentWindDirection(int index) {
            Map<Integer, CharacteristicData> characteristicDataMap = mEsCharacteristicDataMap.get(APPARENT_WIND_DIRECTION_CHARACTERISTIC);
            if (characteristicDataMap == null) {
                characteristicDataMap = new HashMap<>();
                mEsCharacteristicDataMap.put(APPARENT_WIND_DIRECTION_CHARACTERISTIC, characteristicDataMap);
            }
            characteristicDataMap.remove(index);
            return this;
        }

        /**
         * @see #setApparentWindDirectionEsMeasurement(int, int, long, byte[])
         */
        @NonNull
        public Builder<T> setApparentWindDirectionEsMeasurement(int index, EnvironmentalSensingMeasurement environmentalSensingMeasurement) {
            return setApparentWindDirectionEsMeasurement(index, BluetoothGatt.GATT_SUCCESS, 0, environmentalSensingMeasurement.getBytes());
        }

        /**
         * add Apparent Wind Direction's ES Measurement descriptor
         *
         * @param index        Apparent Wind Direction index
         * @param responseCode response code, {@link android.bluetooth.BluetoothGatt#GATT_SUCCESS} or etc
         * @param delay        response delay(millis)
         * @param value        data for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> setApparentWindDirectionEsMeasurement(int index, int responseCode, long delay, @NonNull byte[] value) {
            Map<Integer, DescriptorData> descriptorDataMap = mEsMeasurementMap.get(APPARENT_WIND_DIRECTION_CHARACTERISTIC);
            if (descriptorDataMap == null) {
                descriptorDataMap = new HashMap<>();
                mEsMeasurementMap.put(APPARENT_WIND_DIRECTION_CHARACTERISTIC, descriptorDataMap);
            }
            descriptorDataMap.put(index, new DescriptorData(ENVIRONMENTAL_SENSING_MEASUREMENT_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ, responseCode, delay, value));
            return this;
        }

        /**
         * remove Apparent Wind Direction's ES Measurement descriptor
         *
         * @param index Apparent Wind Direction index
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> removeApparentWindDirectionEsMeasurement(int index) {
            Map<Integer, DescriptorData> descriptorDataMap = mEsMeasurementMap.get(APPARENT_WIND_DIRECTION_CHARACTERISTIC);
            if (descriptorDataMap == null) {
                descriptorDataMap = new HashMap<>();
                mEsMeasurementMap.put(APPARENT_WIND_DIRECTION_CHARACTERISTIC, descriptorDataMap);
            }
            descriptorDataMap.remove(index);
            return this;
        }

        /**
         * @see #setApparentWindDirectionEsTriggerSetting(int, int, int, int, long, byte[])
         */
        @NonNull
        public Builder<T> setApparentWindDirectionEsTriggerSetting(int characteristicIndex, int descriptorIndex, EnvironmentalSensingTriggerSetting environmentalSensingTriggerSetting) {
            return setApparentWindDirectionEsTriggerSetting(characteristicIndex, descriptorIndex, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, BluetoothGatt.GATT_SUCCESS, 0, environmentalSensingTriggerSetting.getBytes());
        }

        /**
         * add Apparent Wind Direction's ES Trigger Setting descriptor
         *
         * @param characteristicIndex Apparent Wind Direction index
         * @param descriptorIndex     Environmental Sensing Trigger Setting index(0 - 2)
         * @param permission          combination of
         *                            {@link BluetoothGattDescriptor#PERMISSION_READ}
         *                            {@link BluetoothGattDescriptor#PERMISSION_WRITE}
         * @param responseCode        response code, {@link BluetoothGatt#GATT_SUCCESS} or etc
         * @param delay               response delay(millis)
         * @param value               data for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> setApparentWindDirectionEsTriggerSetting(int characteristicIndex, int descriptorIndex, int permission, int responseCode, long delay, @NonNull byte[] value) {
            Map<Integer, Map<Integer, DescriptorData>> characteristicDataMap = mEsTriggerSettingMap.get(APPARENT_WIND_DIRECTION_CHARACTERISTIC);
            if (characteristicDataMap == null) {
                characteristicDataMap = new HashMap<>();
                mEsTriggerSettingMap.put(APPARENT_WIND_DIRECTION_CHARACTERISTIC, characteristicDataMap);
            }
            Map<Integer, DescriptorData> descriptorDataMap = characteristicDataMap.get(characteristicIndex);
            if (descriptorDataMap == null) {
                descriptorDataMap = new HashMap<>();
                characteristicDataMap.put(characteristicIndex, descriptorDataMap);
            }
            descriptorDataMap.put(descriptorIndex, new DescriptorData(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR, permission, responseCode, delay, value));
            return this;
        }

        /**
         * remove Apparent Wind Direction's ES Trigger Setting descriptor
         *
         * @param characteristicIndex Apparent Wind Direction index
         * @param descriptorIndex     Environmental Sensing Trigger Setting index(0 - 2)
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> removeApparentWindDirectionEsTriggerSetting(int characteristicIndex, int descriptorIndex) {
            Map<Integer, Map<Integer, DescriptorData>> characteristicDataMap = mEsTriggerSettingMap.get(APPARENT_WIND_DIRECTION_CHARACTERISTIC);
            if (characteristicDataMap == null) {
                characteristicDataMap = new HashMap<>();
                mEsTriggerSettingMap.put(APPARENT_WIND_DIRECTION_CHARACTERISTIC, characteristicDataMap);
            }
            Map<Integer, DescriptorData> descriptorDataMap = characteristicDataMap.get(characteristicIndex);
            if (descriptorDataMap == null) {
                descriptorDataMap = new HashMap<>();
                characteristicDataMap.put(characteristicIndex, descriptorDataMap);
            }
            descriptorDataMap.remove(descriptorIndex);
            return this;
        }

        /**
         * @see #setApparentWindDirectionEsConfiguration(int, int, int, long, byte[])
         */
        @NonNull
        public Builder<T> setApparentWindDirectionEsConfiguration(int index, EnvironmentalSensingConfiguration environmentalSensingConfiguration) {
            return setApparentWindDirectionEsConfiguration(index, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, BluetoothGatt.GATT_SUCCESS, 0, environmentalSensingConfiguration.getBytes());
        }

        /**
         * add Apparent Wind Direction's ES Configuration descriptor
         *
         * @param index        Apparent Wind Direction index
         * @param permission   combination of
         *                     {@link android.bluetooth.BluetoothGattDescriptor#PERMISSION_READ}
         *                     {@link android.bluetooth.BluetoothGattDescriptor#PERMISSION_WRITE}
         * @param responseCode response code, {@link android.bluetooth.BluetoothGatt#GATT_SUCCESS} or etc
         * @param delay        response delay(millis)
         * @param value        data for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> setApparentWindDirectionEsConfiguration(int index, int permission, int responseCode, long delay, @NonNull byte[] value) {
            Map<Integer, DescriptorData> descriptorDataMap = mEsConfigurationMap.get(APPARENT_WIND_DIRECTION_CHARACTERISTIC);
            if (descriptorDataMap == null) {
                descriptorDataMap = new HashMap<>();
                mEsConfigurationMap.put(APPARENT_WIND_DIRECTION_CHARACTERISTIC, descriptorDataMap);
            }
            descriptorDataMap.put(index, new DescriptorData(ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR, permission, responseCode, delay, value));
            return this;
        }

        /**
         * remove Apparent Wind Direction's ES Configuration descriptor
         *
         * @param index Apparent Wind Direction index
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> removeApparentWindDirectionEsConfiguration(int index) {
            Map<Integer, DescriptorData> descriptorDataMap = mEsConfigurationMap.get(APPARENT_WIND_DIRECTION_CHARACTERISTIC);
            if (descriptorDataMap == null) {
                descriptorDataMap = new HashMap<>();
                mEsConfigurationMap.put(APPARENT_WIND_DIRECTION_CHARACTERISTIC, descriptorDataMap);
            }
            descriptorDataMap.remove(index);
            return this;
        }

        /**
         * @see #setApparentWindDirectionCharacteristicUserDescription(int, int, long, byte[])
         */
        @NonNull
        public Builder<T> setApparentWindDirectionCharacteristicUserDescription(int index, CharacteristicUserDescription characteristicUserDescription) {
            return setApparentWindDirectionCharacteristicUserDescription(index, BluetoothGatt.GATT_SUCCESS, 0, characteristicUserDescription.getBytes());
        }

        /**
         * add Apparent Wind Direction's Characteristic User Description descriptor
         *
         * @param index        Apparent Wind Direction index
         * @param responseCode response code, {@link android.bluetooth.BluetoothGatt#GATT_SUCCESS} or etc
         * @param delay        response delay(millis)
         * @param value        data for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> setApparentWindDirectionCharacteristicUserDescription(int index, int responseCode, long delay, @NonNull byte[] value) {
            Map<Integer, DescriptorData> descriptorDataMap = mCharacteristicUserDescriptionMap.get(APPARENT_WIND_DIRECTION_CHARACTERISTIC);
            if (descriptorDataMap == null) {
                descriptorDataMap = new HashMap<>();
                mCharacteristicUserDescriptionMap.put(APPARENT_WIND_DIRECTION_CHARACTERISTIC, descriptorDataMap);
            }
            descriptorDataMap.put(index, new DescriptorData(CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ, responseCode, delay, value));
            return this;
        }

        /**
         * remove Apparent Wind Direction's Characteristic User Description descriptor
         *
         * @param index Apparent Wind Direction index
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> removeApparentWindDirectionCharacteristicUserDescription(int index) {
            Map<Integer, DescriptorData> descriptorDataMap = mCharacteristicUserDescriptionMap.get(APPARENT_WIND_DIRECTION_CHARACTERISTIC);
            if (descriptorDataMap == null) {
                descriptorDataMap = new HashMap<>();
                mCharacteristicUserDescriptionMap.put(APPARENT_WIND_DIRECTION_CHARACTERISTIC, descriptorDataMap);
            }
            descriptorDataMap.remove(index);
            return this;
        }

        /**
         * @see #setApparentWindDirectionValidRange(int, int, long, byte[])
         */
        @NonNull
        public Builder<T> setApparentWindDirectionValidRange(int index, ValidRange validRange) {
            return setApparentWindDirectionValidRange(index, BluetoothGatt.GATT_SUCCESS, 0, validRange.getBytes());
        }

        /**
         * add Apparent Wind Direction's Valid Range descriptor
         *
         * @param index        Apparent Wind Direction index
         * @param responseCode response code, {@link android.bluetooth.BluetoothGatt#GATT_SUCCESS} or etc
         * @param delay        response delay(millis)
         * @param value        data for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> setApparentWindDirectionValidRange(int index, int responseCode, long delay, @NonNull byte[] value) {
            Map<Integer, DescriptorData> descriptorDataMap = mValidRangeMap.get(APPARENT_WIND_DIRECTION_CHARACTERISTIC);
            if (descriptorDataMap == null) {
                descriptorDataMap = new HashMap<>();
                mValidRangeMap.put(APPARENT_WIND_DIRECTION_CHARACTERISTIC, descriptorDataMap);
            }
            descriptorDataMap.put(index, new DescriptorData(VALID_RANGE_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ, responseCode, delay, value));
            return this;
        }

        /**
         * remove Apparent Wind Direction's Valid Range descriptor
         *
         * @param index Apparent Wind Direction index
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> removeApparentWindDirectionValidRange(int index) {
            Map<Integer, DescriptorData> descriptorDataMap = mValidRangeMap.get(APPARENT_WIND_DIRECTION_CHARACTERISTIC);
            if (descriptorDataMap == null) {
                descriptorDataMap = new HashMap<>();
                mValidRangeMap.put(APPARENT_WIND_DIRECTION_CHARACTERISTIC, descriptorDataMap);
            }
            descriptorDataMap.remove(index);
            return this;
        }

        /**
         * @see #addApparentWindSpeed(int, int, int, long, byte[])
         */
        @NonNull
        public Builder<T> addApparentWindSpeed(int index, @NonNull ApparentWindSpeed apparentWindSpeed) {
            return addApparentWindSpeed(index, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, BluetoothGattCharacteristic.PERMISSION_READ, 0, apparentWindSpeed.getBytes());
        }

        /**
         * add Apparent Wind Speed characteristic
         *
         * @param index        Apparent Wind Speed index
         * @param property     combination of
         *                     {@link android.bluetooth.BluetoothGattCharacteristic#PROPERTY_READ}
         *                     {@link android.bluetooth.BluetoothGattCharacteristic#PROPERTY_NOTIFY}
         * @param responseCode response code, {@link android.bluetooth.BluetoothGatt#GATT_SUCCESS} or etc
         * @param delay        response delay(millis)
         * @param value        data for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> addApparentWindSpeed(int index, int property, int responseCode, long delay, @NonNull byte[] value) {
            Map<Integer, CharacteristicData> characteristicDataMap = mEsCharacteristicDataMap.get(APPARENT_WIND_SPEED_CHARACTERISTIC);
            if (characteristicDataMap == null) {
                characteristicDataMap = new HashMap<>();
                mEsCharacteristicDataMap.put(APPARENT_WIND_SPEED_CHARACTERISTIC, characteristicDataMap);
            }
            characteristicDataMap.put(index, new CharacteristicData(APPARENT_WIND_SPEED_CHARACTERISTIC, property, BluetoothGattCharacteristic.PERMISSION_READ, new ArrayList<>(), responseCode, delay, value, 0));
            return this;
        }

        /**
         * remove Apparent Wind Speed characteristic
         *
         * @param index Apparent Wind Speed index
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> removeApparentWindSpeed(int index) {
            Map<Integer, CharacteristicData> characteristicDataMap = mEsCharacteristicDataMap.get(APPARENT_WIND_SPEED_CHARACTERISTIC);
            if (characteristicDataMap == null) {
                characteristicDataMap = new HashMap<>();
                mEsCharacteristicDataMap.put(APPARENT_WIND_SPEED_CHARACTERISTIC, characteristicDataMap);
            }
            characteristicDataMap.remove(index);
            return this;
        }

        /**
         * @see #setApparentWindSpeedEsMeasurement(int, int, long, byte[])
         */
        @NonNull
        public Builder<T> setApparentWindSpeedEsMeasurement(int index, EnvironmentalSensingMeasurement environmentalSensingMeasurement) {
            return setApparentWindSpeedEsMeasurement(index, BluetoothGatt.GATT_SUCCESS, 0, environmentalSensingMeasurement.getBytes());
        }

        /**
         * add Apparent Wind Speed's ES Measurement descriptor
         *
         * @param index        Apparent Wind Speed index
         * @param responseCode response code, {@link android.bluetooth.BluetoothGatt#GATT_SUCCESS} or etc
         * @param delay        response delay(millis)
         * @param value        data for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> setApparentWindSpeedEsMeasurement(int index, int responseCode, long delay, @NonNull byte[] value) {
            Map<Integer, DescriptorData> descriptorDataMap = mEsMeasurementMap.get(APPARENT_WIND_SPEED_CHARACTERISTIC);
            if (descriptorDataMap == null) {
                descriptorDataMap = new HashMap<>();
                mEsMeasurementMap.put(APPARENT_WIND_SPEED_CHARACTERISTIC, descriptorDataMap);
            }
            descriptorDataMap.put(index, new DescriptorData(ENVIRONMENTAL_SENSING_MEASUREMENT_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ, responseCode, delay, value));
            return this;
        }

        /**
         * remove Apparent Wind Speed's ES Measurement descriptor
         *
         * @param index Apparent Wind Speed index
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> removeApparentWindSpeedEsMeasurement(int index) {
            Map<Integer, DescriptorData> descriptorDataMap = mEsMeasurementMap.get(APPARENT_WIND_SPEED_CHARACTERISTIC);
            if (descriptorDataMap == null) {
                descriptorDataMap = new HashMap<>();
                mEsMeasurementMap.put(APPARENT_WIND_SPEED_CHARACTERISTIC, descriptorDataMap);
            }
            descriptorDataMap.remove(index);
            return this;
        }

        /**
         * @see #setApparentWindSpeedEsTriggerSetting(int, int, int, int, long, byte[])
         */
        @NonNull
        public Builder<T> setApparentWindSpeedEsTriggerSetting(int characteristicIndex, int descriptorIndex, EnvironmentalSensingTriggerSetting environmentalSensingTriggerSetting) {
            return setApparentWindSpeedEsTriggerSetting(characteristicIndex, descriptorIndex, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, BluetoothGatt.GATT_SUCCESS, 0, environmentalSensingTriggerSetting.getBytes());
        }

        /**
         * add Apparent Wind Speed's ES Trigger Setting descriptor
         *
         * @param characteristicIndex Apparent Wind Speed index
         * @param descriptorIndex     Environmental Sensing Trigger Setting index(0 - 2)
         * @param permission          combination of
         *                            {@link android.bluetooth.BluetoothGattDescriptor#PERMISSION_READ}
         *                            {@link android.bluetooth.BluetoothGattDescriptor#PERMISSION_WRITE}
         * @param responseCode        response code, {@link android.bluetooth.BluetoothGatt#GATT_SUCCESS} or etc
         * @param delay               response delay(millis)
         * @param value               data for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> setApparentWindSpeedEsTriggerSetting(int characteristicIndex, int descriptorIndex, int permission, int responseCode, long delay, @NonNull byte[] value) {
            Map<Integer, Map<Integer, DescriptorData>> characteristicDataMap = mEsTriggerSettingMap.get(APPARENT_WIND_SPEED_CHARACTERISTIC);
            if (characteristicDataMap == null) {
                characteristicDataMap = new HashMap<>();
                mEsTriggerSettingMap.put(APPARENT_WIND_SPEED_CHARACTERISTIC, characteristicDataMap);
            }
            Map<Integer, DescriptorData> descriptorDataMap = characteristicDataMap.get(characteristicIndex);
            if (descriptorDataMap == null) {
                descriptorDataMap = new HashMap<>();
                characteristicDataMap.put(characteristicIndex, descriptorDataMap);
            }
            descriptorDataMap.put(descriptorIndex, new DescriptorData(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR, permission, responseCode, delay, value));
            return this;
        }

        /**
         * remove Apparent Wind Speed's ES Trigger Setting descriptor
         *
         * @param characteristicIndex Apparent Wind Speed index
         * @param descriptorIndex     Environmental Sensing Trigger Setting index(0 - 2)
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> removeApparentWindSpeedEsTriggerSetting(int characteristicIndex, int descriptorIndex) {
            Map<Integer, Map<Integer, DescriptorData>> characteristicDataMap = mEsTriggerSettingMap.get(APPARENT_WIND_SPEED_CHARACTERISTIC);
            if (characteristicDataMap == null) {
                characteristicDataMap = new HashMap<>();
                mEsTriggerSettingMap.put(APPARENT_WIND_SPEED_CHARACTERISTIC, characteristicDataMap);
            }
            Map<Integer, DescriptorData> descriptorDataMap = characteristicDataMap.get(characteristicIndex);
            if (descriptorDataMap == null) {
                descriptorDataMap = new HashMap<>();
                characteristicDataMap.put(characteristicIndex, descriptorDataMap);
            }
            descriptorDataMap.remove(descriptorIndex);
            return this;
        }

        /**
         * @see #setApparentWindSpeedEsConfiguration(int, int, int, long, byte[])
         */
        @NonNull
        public Builder<T> setApparentWindSpeedEsConfiguration(int index, EnvironmentalSensingConfiguration environmentalSensingConfiguration) {
            return setApparentWindSpeedEsConfiguration(index, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, BluetoothGatt.GATT_SUCCESS, 0, environmentalSensingConfiguration.getBytes());
        }

        /**
         * add Apparent Wind Speed's ES Configuration descriptor
         *
         * @param index        Apparent Wind Speed index
         * @param permission   combination of
         *                     {@link android.bluetooth.BluetoothGattDescriptor#PERMISSION_READ}
         *                     {@link android.bluetooth.BluetoothGattDescriptor#PERMISSION_WRITE}
         * @param responseCode response code, {@link android.bluetooth.BluetoothGatt#GATT_SUCCESS} or etc
         * @param delay        response delay(millis)
         * @param value        data for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> setApparentWindSpeedEsConfiguration(int index, int permission, int responseCode, long delay, @NonNull byte[] value) {
            Map<Integer, DescriptorData> descriptorDataMap = mEsConfigurationMap.get(APPARENT_WIND_SPEED_CHARACTERISTIC);
            if (descriptorDataMap == null) {
                descriptorDataMap = new HashMap<>();
                mEsConfigurationMap.put(APPARENT_WIND_SPEED_CHARACTERISTIC, descriptorDataMap);
            }
            descriptorDataMap.put(index, new DescriptorData(ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR, permission, responseCode, delay, value));
            return this;
        }

        /**
         * remove Apparent Wind Speed's ES Configuration descriptor
         *
         * @param index Apparent Wind Speed index
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> removeApparentWindSpeedEsConfiguration(int index) {
            Map<Integer, DescriptorData> descriptorDataMap = mEsConfigurationMap.get(APPARENT_WIND_SPEED_CHARACTERISTIC);
            if (descriptorDataMap == null) {
                descriptorDataMap = new HashMap<>();
                mEsConfigurationMap.put(APPARENT_WIND_SPEED_CHARACTERISTIC, descriptorDataMap);
            }
            descriptorDataMap.remove(index);
            return this;
        }

        /**
         * @see #setApparentWindSpeedCharacteristicUserDescription(int, int, long, byte[])
         */
        @NonNull
        public Builder<T> setApparentWindSpeedCharacteristicUserDescription(int index, CharacteristicUserDescription characteristicUserDescription) {
            return setApparentWindSpeedCharacteristicUserDescription(index, BluetoothGatt.GATT_SUCCESS, 0, characteristicUserDescription.getBytes());
        }

        /**
         * add Apparent Wind Speed's Characteristic User Description descriptor
         *
         * @param index        Apparent Wind Speed index
         * @param responseCode response code, {@link android.bluetooth.BluetoothGatt#GATT_SUCCESS} or etc
         * @param delay        response delay(millis)
         * @param value        data for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> setApparentWindSpeedCharacteristicUserDescription(int index, int responseCode, long delay, @NonNull byte[] value) {
            Map<Integer, DescriptorData> descriptorDataMap = mCharacteristicUserDescriptionMap.get(APPARENT_WIND_SPEED_CHARACTERISTIC);
            if (descriptorDataMap == null) {
                descriptorDataMap = new HashMap<>();
                mCharacteristicUserDescriptionMap.put(APPARENT_WIND_SPEED_CHARACTERISTIC, descriptorDataMap);
            }
            descriptorDataMap.put(index, new DescriptorData(CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ, responseCode, delay, value));
            return this;
        }

        /**
         * remove Apparent Wind Speed's Characteristic User Description descriptor
         *
         * @param index Apparent Wind Speed index
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> removeApparentWindSpeedCharacteristicUserDescription(int index) {
            Map<Integer, DescriptorData> descriptorDataMap = mCharacteristicUserDescriptionMap.get(APPARENT_WIND_SPEED_CHARACTERISTIC);
            if (descriptorDataMap == null) {
                descriptorDataMap = new HashMap<>();
                mCharacteristicUserDescriptionMap.put(APPARENT_WIND_SPEED_CHARACTERISTIC, descriptorDataMap);
            }
            descriptorDataMap.remove(index);
            return this;
        }

        /**
         * @see #setApparentWindSpeedValidRange(int, int, long, byte[])
         */
        @NonNull
        public Builder<T> setApparentWindSpeedValidRange(int index, ValidRange validRange) {
            return setApparentWindSpeedValidRange(index, BluetoothGatt.GATT_SUCCESS, 0, validRange.getBytes());
        }

        /**
         * add Apparent Wind Speed's Valid Range descriptor
         *
         * @param index        Apparent Wind Speed index
         * @param responseCode response code, {@link android.bluetooth.BluetoothGatt#GATT_SUCCESS} or etc
         * @param delay        response delay(millis)
         * @param value        data for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> setApparentWindSpeedValidRange(int index, int responseCode, long delay, @NonNull byte[] value) {
            Map<Integer, DescriptorData> descriptorDataMap = mValidRangeMap.get(APPARENT_WIND_SPEED_CHARACTERISTIC);
            if (descriptorDataMap == null) {
                descriptorDataMap = new HashMap<>();
                mValidRangeMap.put(APPARENT_WIND_SPEED_CHARACTERISTIC, descriptorDataMap);
            }
            descriptorDataMap.put(index, new DescriptorData(VALID_RANGE_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ, responseCode, delay, value));
            return this;
        }

        /**
         * remove Apparent Wind Speed's Valid Range descriptor
         *
         * @param index Apparent Wind Speed index
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> removeApparentWindSpeedValidRange(int index) {
            Map<Integer, DescriptorData> descriptorDataMap = mValidRangeMap.get(APPARENT_WIND_SPEED_CHARACTERISTIC);
            if (descriptorDataMap == null) {
                descriptorDataMap = new HashMap<>();
                mValidRangeMap.put(APPARENT_WIND_SPEED_CHARACTERISTIC, descriptorDataMap);
            }
            descriptorDataMap.remove(index);
            return this;
        }

        /**
         * @see #addDewPoint(int, int, int, long, byte[])
         */
        @NonNull
        public Builder<T> addDewPoint(int index, @NonNull DewPoint dewPoint) {
            return addDewPoint(index, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, BluetoothGattCharacteristic.PERMISSION_READ, 0, dewPoint.getBytes());
        }

        /**
         * add Dew Point characteristic
         *
         * @param index        Dew Point index
         * @param property     combination of
         *                     {@link android.bluetooth.BluetoothGattCharacteristic#PROPERTY_READ}
         *                     {@link android.bluetooth.BluetoothGattCharacteristic#PROPERTY_NOTIFY}
         * @param responseCode response code, {@link android.bluetooth.BluetoothGatt#GATT_SUCCESS} or etc
         * @param delay        response delay(millis)
         * @param value        data for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> addDewPoint(int index, int property, int responseCode, long delay, @NonNull byte[] value) {
            Map<Integer, CharacteristicData> characteristicDataMap = mEsCharacteristicDataMap.get(DEW_POINT_CHARACTERISTIC);
            if (characteristicDataMap == null) {
                characteristicDataMap = new HashMap<>();
                mEsCharacteristicDataMap.put(DEW_POINT_CHARACTERISTIC, characteristicDataMap);
            }
            characteristicDataMap.put(index, new CharacteristicData(DEW_POINT_CHARACTERISTIC, property, BluetoothGattCharacteristic.PERMISSION_READ, new ArrayList<>(), responseCode, delay, value, 0));
            return this;
        }

        /**
         * remove Dew Point characteristic
         *
         * @param index Dew Point index
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> removeDewPoint(int index) {
            Map<Integer, CharacteristicData> characteristicDataMap = mEsCharacteristicDataMap.get(DEW_POINT_CHARACTERISTIC);
            if (characteristicDataMap == null) {
                characteristicDataMap = new HashMap<>();
                mEsCharacteristicDataMap.put(DEW_POINT_CHARACTERISTIC, characteristicDataMap);
            }
            characteristicDataMap.remove(index);
            return this;
        }

        /**
         * @see #setDewPointEsMeasurement(int, int, long, byte[])
         */
        @NonNull
        public Builder<T> setDewPointEsMeasurement(int index, EnvironmentalSensingMeasurement environmentalSensingMeasurement) {
            return setDewPointEsMeasurement(index, BluetoothGatt.GATT_SUCCESS, 0, environmentalSensingMeasurement.getBytes());
        }

        /**
         * add Dew Point's ES Measurement descriptor
         *
         * @param index        Dew Point index
         * @param responseCode response code, {@link android.bluetooth.BluetoothGatt#GATT_SUCCESS} or etc
         * @param delay        response delay(millis)
         * @param value        data for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> setDewPointEsMeasurement(int index, int responseCode, long delay, @NonNull byte[] value) {
            Map<Integer, DescriptorData> descriptorDataMap = mEsMeasurementMap.get(DEW_POINT_CHARACTERISTIC);
            if (descriptorDataMap == null) {
                descriptorDataMap = new HashMap<>();
                mEsMeasurementMap.put(DEW_POINT_CHARACTERISTIC, descriptorDataMap);
            }
            descriptorDataMap.put(index, new DescriptorData(ENVIRONMENTAL_SENSING_MEASUREMENT_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ, responseCode, delay, value));
            return this;
        }

        /**
         * remove Dew Point's ES Measurement descriptor
         *
         * @param index Dew Point index
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> removeDewPointEsMeasurement(int index) {
            Map<Integer, DescriptorData> descriptorDataMap = mEsMeasurementMap.get(DEW_POINT_CHARACTERISTIC);
            if (descriptorDataMap == null) {
                descriptorDataMap = new HashMap<>();
                mEsMeasurementMap.put(DEW_POINT_CHARACTERISTIC, descriptorDataMap);
            }
            descriptorDataMap.remove(index);
            return this;
        }

        /**
         * @see #setDewPointEsTriggerSetting(int, int, int, int, long, byte[])
         */
        @NonNull
        public Builder<T> setDewPointEsTriggerSetting(int characteristicIndex, int descriptorIndex, EnvironmentalSensingTriggerSetting environmentalSensingTriggerSetting) {
            return setDewPointEsTriggerSetting(characteristicIndex, descriptorIndex, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, BluetoothGatt.GATT_SUCCESS, 0, environmentalSensingTriggerSetting.getBytes());
        }

        /**
         * add Dew Point's ES Trigger Setting descriptor
         *
         * @param characteristicIndex Dew Point index
         * @param descriptorIndex     Environmental Sensing Trigger Setting index(0 - 2)
         * @param permission          combination of
         *                            {@link android.bluetooth.BluetoothGattDescriptor#PERMISSION_READ}
         *                            {@link android.bluetooth.BluetoothGattDescriptor#PERMISSION_WRITE}
         * @param responseCode        response code, {@link android.bluetooth.BluetoothGatt#GATT_SUCCESS} or etc
         * @param delay               response delay(millis)
         * @param value               data for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> setDewPointEsTriggerSetting(int characteristicIndex, int descriptorIndex, int permission, int responseCode, long delay, @NonNull byte[] value) {
            Map<Integer, Map<Integer, DescriptorData>> characteristicDataMap = mEsTriggerSettingMap.get(DEW_POINT_CHARACTERISTIC);
            if (characteristicDataMap == null) {
                characteristicDataMap = new HashMap<>();
                mEsTriggerSettingMap.put(DEW_POINT_CHARACTERISTIC, characteristicDataMap);
            }
            Map<Integer, DescriptorData> descriptorDataMap = characteristicDataMap.get(characteristicIndex);
            if (descriptorDataMap == null) {
                descriptorDataMap = new HashMap<>();
                characteristicDataMap.put(characteristicIndex, descriptorDataMap);
            }
            descriptorDataMap.put(descriptorIndex, new DescriptorData(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR, permission, responseCode, delay, value));
            return this;
        }

        /**
         * remove Dew Point's ES Trigger Setting descriptor
         *
         * @param characteristicIndex Dew Point index
         * @param descriptorIndex     Environmental Sensing Trigger Setting index(0 - 2)
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> removeDewPointEsTriggerSetting(int characteristicIndex, int descriptorIndex) {
            Map<Integer, Map<Integer, DescriptorData>> characteristicDataMap = mEsTriggerSettingMap.get(DEW_POINT_CHARACTERISTIC);
            if (characteristicDataMap == null) {
                characteristicDataMap = new HashMap<>();
                mEsTriggerSettingMap.put(DEW_POINT_CHARACTERISTIC, characteristicDataMap);
            }
            Map<Integer, DescriptorData> descriptorDataMap = characteristicDataMap.get(characteristicIndex);
            if (descriptorDataMap == null) {
                descriptorDataMap = new HashMap<>();
                characteristicDataMap.put(characteristicIndex, descriptorDataMap);
            }
            descriptorDataMap.remove(descriptorIndex);
            return this;
        }

        /**
         * @see #setDewPointEsConfiguration(int, int, int, long, byte[])
         */
        @NonNull
        public Builder<T> setDewPointEsConfiguration(int index, EnvironmentalSensingConfiguration environmentalSensingConfiguration) {
            return setDewPointEsConfiguration(index, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, BluetoothGatt.GATT_SUCCESS, 0, environmentalSensingConfiguration.getBytes());
        }

        /**
         * add Dew Point's ES Configuration descriptor
         *
         * @param index        Dew Point index
         * @param permission   combination of
         *                     {@link android.bluetooth.BluetoothGattDescriptor#PERMISSION_READ}
         *                     {@link android.bluetooth.BluetoothGattDescriptor#PERMISSION_WRITE}
         * @param responseCode response code, {@link android.bluetooth.BluetoothGatt#GATT_SUCCESS} or etc
         * @param delay        response delay(millis)
         * @param value        data for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> setDewPointEsConfiguration(int index, int permission, int responseCode, long delay, @NonNull byte[] value) {
            Map<Integer, DescriptorData> descriptorDataMap = mEsConfigurationMap.get(DEW_POINT_CHARACTERISTIC);
            if (descriptorDataMap == null) {
                descriptorDataMap = new HashMap<>();
                mEsConfigurationMap.put(DEW_POINT_CHARACTERISTIC, descriptorDataMap);
            }
            descriptorDataMap.put(index, new DescriptorData(ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR, permission, responseCode, delay, value));
            return this;
        }

        /**
         * remove Dew Point's ES Configuration descriptor
         *
         * @param index Dew Point index
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> removeDewPointEsConfiguration(int index) {
            Map<Integer, DescriptorData> descriptorDataMap = mEsConfigurationMap.get(DEW_POINT_CHARACTERISTIC);
            if (descriptorDataMap == null) {
                descriptorDataMap = new HashMap<>();
                mEsConfigurationMap.put(DEW_POINT_CHARACTERISTIC, descriptorDataMap);
            }
            descriptorDataMap.remove(index);
            return this;
        }

        /**
         * @see #setDewPointCharacteristicUserDescription(int, int, long, byte[])
         */
        @NonNull
        public Builder<T> setDewPointCharacteristicUserDescription(int index, CharacteristicUserDescription characteristicUserDescription) {
            return setDewPointCharacteristicUserDescription(index, BluetoothGatt.GATT_SUCCESS, 0, characteristicUserDescription.getBytes());
        }

        /**
         * add Dew Point's Characteristic User Description descriptor
         *
         * @param index        Dew Point index
         * @param responseCode response code, {@link android.bluetooth.BluetoothGatt#GATT_SUCCESS} or etc
         * @param delay        response delay(millis)
         * @param value        data for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> setDewPointCharacteristicUserDescription(int index, int responseCode, long delay, @NonNull byte[] value) {
            Map<Integer, DescriptorData> descriptorDataMap = mCharacteristicUserDescriptionMap.get(DEW_POINT_CHARACTERISTIC);
            if (descriptorDataMap == null) {
                descriptorDataMap = new HashMap<>();
                mCharacteristicUserDescriptionMap.put(DEW_POINT_CHARACTERISTIC, descriptorDataMap);
            }
            descriptorDataMap.put(index, new DescriptorData(CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ, responseCode, delay, value));
            return this;
        }

        /**
         * remove Dew Point's Characteristic User Description descriptor
         *
         * @param index Dew Point index
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> removeDewPointCharacteristicUserDescription(int index) {
            Map<Integer, DescriptorData> descriptorDataMap = mCharacteristicUserDescriptionMap.get(DEW_POINT_CHARACTERISTIC);
            if (descriptorDataMap == null) {
                descriptorDataMap = new HashMap<>();
                mCharacteristicUserDescriptionMap.put(DEW_POINT_CHARACTERISTIC, descriptorDataMap);
            }
            descriptorDataMap.remove(index);
            return this;
        }

        /**
         * @see #setDewPointValidRange(int, int, long, byte[])
         */
        @NonNull
        public Builder<T> setDewPointValidRange(int index, ValidRange validRange) {
            return setDewPointValidRange(index, BluetoothGatt.GATT_SUCCESS, 0, validRange.getBytes());
        }

        /**
         * add Dew Point's Valid Range descriptor
         *
         * @param index        Dew Point index
         * @param responseCode response code, {@link android.bluetooth.BluetoothGatt#GATT_SUCCESS} or etc
         * @param delay        response delay(millis)
         * @param value        data for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> setDewPointValidRange(int index, int responseCode, long delay, @NonNull byte[] value) {
            Map<Integer, DescriptorData> descriptorDataMap = mValidRangeMap.get(DEW_POINT_CHARACTERISTIC);
            if (descriptorDataMap == null) {
                descriptorDataMap = new HashMap<>();
                mValidRangeMap.put(DEW_POINT_CHARACTERISTIC, descriptorDataMap);
            }
            descriptorDataMap.put(index, new DescriptorData(VALID_RANGE_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ, responseCode, delay, value));
            return this;
        }

        /**
         * remove Dew Point's Valid Range descriptor
         *
         * @param index Dew Point index
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> removeDewPointValidRange(int index) {
            Map<Integer, DescriptorData> descriptorDataMap = mValidRangeMap.get(DEW_POINT_CHARACTERISTIC);
            if (descriptorDataMap == null) {
                descriptorDataMap = new HashMap<>();
                mValidRangeMap.put(DEW_POINT_CHARACTERISTIC, descriptorDataMap);
            }
            descriptorDataMap.remove(index);
            return this;
        }

        /**
         * @see #addElevation(int, int, int, long, byte[])
         */
        @NonNull
        public Builder<T> addElevation(int index, @NonNull Elevation elevation) {
            return addElevation(index, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, BluetoothGattCharacteristic.PERMISSION_READ, 0, elevation.getBytes());
        }

        /**
         * add Elevation characteristic
         *
         * @param index        Elevation index
         * @param property     combination of
         *                     {@link android.bluetooth.BluetoothGattCharacteristic#PROPERTY_READ}
         *                     {@link android.bluetooth.BluetoothGattCharacteristic#PROPERTY_NOTIFY}
         * @param responseCode response code, {@link android.bluetooth.BluetoothGatt#GATT_SUCCESS} or etc
         * @param delay        response delay(millis)
         * @param value        data for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> addElevation(int index, int property, int responseCode, long delay, @NonNull byte[] value) {
            Map<Integer, CharacteristicData> characteristicDataMap = mEsCharacteristicDataMap.get(ELEVATION_CHARACTERISTIC);
            if (characteristicDataMap == null) {
                characteristicDataMap = new HashMap<>();
                mEsCharacteristicDataMap.put(ELEVATION_CHARACTERISTIC, characteristicDataMap);
            }
            characteristicDataMap.put(index, new CharacteristicData(ELEVATION_CHARACTERISTIC, property, BluetoothGattCharacteristic.PERMISSION_READ, new ArrayList<>(), responseCode, delay, value, 0));
            return this;
        }

        /**
         * remove Elevation characteristic
         *
         * @param index Elevation index
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> removeElevation(int index) {
            Map<Integer, CharacteristicData> characteristicDataMap = mEsCharacteristicDataMap.get(ELEVATION_CHARACTERISTIC);
            if (characteristicDataMap == null) {
                characteristicDataMap = new HashMap<>();
                mEsCharacteristicDataMap.put(ELEVATION_CHARACTERISTIC, characteristicDataMap);
            }
            characteristicDataMap.remove(index);
            return this;
        }

        /**
         * @see #setElevationEsMeasurement(int, int, long, byte[])
         */
        @NonNull
        public Builder<T> setElevationEsMeasurement(int index, EnvironmentalSensingMeasurement environmentalSensingMeasurement) {
            return setElevationEsMeasurement(index, BluetoothGatt.GATT_SUCCESS, 0, environmentalSensingMeasurement.getBytes());
        }

        /**
         * add Elevation's ES Measurement descriptor
         *
         * @param index        Elevation index
         * @param responseCode response code, {@link android.bluetooth.BluetoothGatt#GATT_SUCCESS} or etc
         * @param delay        response delay(millis)
         * @param value        data for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> setElevationEsMeasurement(int index, int responseCode, long delay, @NonNull byte[] value) {
            Map<Integer, DescriptorData> descriptorDataMap = mEsMeasurementMap.get(ELEVATION_CHARACTERISTIC);
            if (descriptorDataMap == null) {
                descriptorDataMap = new HashMap<>();
                mEsMeasurementMap.put(ELEVATION_CHARACTERISTIC, descriptorDataMap);
            }
            descriptorDataMap.put(index, new DescriptorData(ENVIRONMENTAL_SENSING_MEASUREMENT_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ, responseCode, delay, value));
            return this;
        }

        /**
         * remove Elevation's ES Measurement descriptor
         *
         * @param index Elevation index
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> removeElevationEsMeasurement(int index) {
            Map<Integer, DescriptorData> descriptorDataMap = mEsMeasurementMap.get(ELEVATION_CHARACTERISTIC);
            if (descriptorDataMap == null) {
                descriptorDataMap = new HashMap<>();
                mEsMeasurementMap.put(ELEVATION_CHARACTERISTIC, descriptorDataMap);
            }
            descriptorDataMap.remove(index);
            return this;
        }

        /**
         * @see #setElevationEsTriggerSetting(int, int, int, int, long, byte[])
         */
        @NonNull
        public Builder<T> setElevationEsTriggerSetting(int characteristicIndex, int descriptorIndex, EnvironmentalSensingTriggerSetting environmentalSensingTriggerSetting) {
            return setElevationEsTriggerSetting(characteristicIndex, descriptorIndex, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, BluetoothGatt.GATT_SUCCESS, 0, environmentalSensingTriggerSetting.getBytes());
        }

        /**
         * add Elevation's ES Trigger Setting descriptor
         *
         * @param characteristicIndex Elevation index
         * @param descriptorIndex     Environmental Sensing Trigger Setting index(0 - 2)
         * @param permission          combination of
         *                            {@link android.bluetooth.BluetoothGattDescriptor#PERMISSION_READ}
         *                            {@link android.bluetooth.BluetoothGattDescriptor#PERMISSION_WRITE}
         * @param responseCode        response code, {@link android.bluetooth.BluetoothGatt#GATT_SUCCESS} or etc
         * @param delay               response delay(millis)
         * @param value               data for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> setElevationEsTriggerSetting(int characteristicIndex, int descriptorIndex, int permission, int responseCode, long delay, @NonNull byte[] value) {
            Map<Integer, Map<Integer, DescriptorData>> characteristicDataMap = mEsTriggerSettingMap.get(ELEVATION_CHARACTERISTIC);
            if (characteristicDataMap == null) {
                characteristicDataMap = new HashMap<>();
                mEsTriggerSettingMap.put(ELEVATION_CHARACTERISTIC, characteristicDataMap);
            }
            Map<Integer, DescriptorData> descriptorDataMap = characteristicDataMap.get(characteristicIndex);
            if (descriptorDataMap == null) {
                descriptorDataMap = new HashMap<>();
                characteristicDataMap.put(characteristicIndex, descriptorDataMap);
            }
            descriptorDataMap.put(descriptorIndex, new DescriptorData(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR, permission, responseCode, delay, value));
            return this;
        }

        /**
         * remove Elevation's ES Trigger Setting descriptor
         *
         * @param characteristicIndex Elevation index
         * @param descriptorIndex     Environmental Sensing Trigger Setting index(0 - 2)
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> removeElevationEsTriggerSetting(int characteristicIndex, int descriptorIndex) {
            Map<Integer, Map<Integer, DescriptorData>> characteristicDataMap = mEsTriggerSettingMap.get(ELEVATION_CHARACTERISTIC);
            if (characteristicDataMap == null) {
                characteristicDataMap = new HashMap<>();
                mEsTriggerSettingMap.put(ELEVATION_CHARACTERISTIC, characteristicDataMap);
            }
            Map<Integer, DescriptorData> descriptorDataMap = characteristicDataMap.get(characteristicIndex);
            if (descriptorDataMap == null) {
                descriptorDataMap = new HashMap<>();
                characteristicDataMap.put(characteristicIndex, descriptorDataMap);
            }
            descriptorDataMap.remove(descriptorIndex);
            return this;
        }

        /**
         * @see #setElevationEsConfiguration(int, int, int, long, byte[])
         */
        @NonNull
        public Builder<T> setElevationEsConfiguration(int index, EnvironmentalSensingConfiguration environmentalSensingConfiguration) {
            return setElevationEsConfiguration(index, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, BluetoothGatt.GATT_SUCCESS, 0, environmentalSensingConfiguration.getBytes());
        }

        /**
         * add Elevation's ES Configuration descriptor
         *
         * @param index        Elevation index
         * @param permission   combination of
         *                     {@link android.bluetooth.BluetoothGattDescriptor#PERMISSION_READ}
         *                     {@link android.bluetooth.BluetoothGattDescriptor#PERMISSION_WRITE}
         * @param responseCode response code, {@link android.bluetooth.BluetoothGatt#GATT_SUCCESS} or etc
         * @param delay        response delay(millis)
         * @param value        data for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> setElevationEsConfiguration(int index, int permission, int responseCode, long delay, @NonNull byte[] value) {
            Map<Integer, DescriptorData> descriptorDataMap = mEsConfigurationMap.get(ELEVATION_CHARACTERISTIC);
            if (descriptorDataMap == null) {
                descriptorDataMap = new HashMap<>();
                mEsConfigurationMap.put(ELEVATION_CHARACTERISTIC, descriptorDataMap);
            }
            descriptorDataMap.put(index, new DescriptorData(ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR, permission, responseCode, delay, value));
            return this;
        }

        /**
         * remove Elevation's ES Configuration descriptor
         *
         * @param index Elevation index
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> removeElevationEsConfiguration(int index) {
            Map<Integer, DescriptorData> descriptorDataMap = mEsConfigurationMap.get(ELEVATION_CHARACTERISTIC);
            if (descriptorDataMap == null) {
                descriptorDataMap = new HashMap<>();
                mEsConfigurationMap.put(ELEVATION_CHARACTERISTIC, descriptorDataMap);
            }
            descriptorDataMap.remove(index);
            return this;
        }

        /**
         * @see #setElevationCharacteristicUserDescription(int, int, long, byte[])
         */
        @NonNull
        public Builder<T> setElevationCharacteristicUserDescription(int index, CharacteristicUserDescription characteristicUserDescription) {
            return setElevationCharacteristicUserDescription(index, BluetoothGatt.GATT_SUCCESS, 0, characteristicUserDescription.getBytes());
        }

        /**
         * add Elevation's Characteristic User Description descriptor
         *
         * @param index        Elevation index
         * @param responseCode response code, {@link android.bluetooth.BluetoothGatt#GATT_SUCCESS} or etc
         * @param delay        response delay(millis)
         * @param value        data for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> setElevationCharacteristicUserDescription(int index, int responseCode, long delay, @NonNull byte[] value) {
            Map<Integer, DescriptorData> descriptorDataMap = mCharacteristicUserDescriptionMap.get(ELEVATION_CHARACTERISTIC);
            if (descriptorDataMap == null) {
                descriptorDataMap = new HashMap<>();
                mCharacteristicUserDescriptionMap.put(ELEVATION_CHARACTERISTIC, descriptorDataMap);
            }
            descriptorDataMap.put(index, new DescriptorData(CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ, responseCode, delay, value));
            return this;
        }

        /**
         * remove Elevation's Characteristic User Description descriptor
         *
         * @param index Elevation index
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> removeElevationCharacteristicUserDescription(int index) {
            Map<Integer, DescriptorData> descriptorDataMap = mCharacteristicUserDescriptionMap.get(ELEVATION_CHARACTERISTIC);
            if (descriptorDataMap == null) {
                descriptorDataMap = new HashMap<>();
                mCharacteristicUserDescriptionMap.put(ELEVATION_CHARACTERISTIC, descriptorDataMap);
            }
            descriptorDataMap.remove(index);
            return this;
        }

        /**
         * @see #setElevationValidRange(int, int, long, byte[])
         */
        @NonNull
        public Builder<T> setElevationValidRange(int index, ValidRange validRange) {
            return setElevationValidRange(index, BluetoothGatt.GATT_SUCCESS, 0, validRange.getBytes());
        }

        /**
         * add Elevation's Valid Range descriptor
         *
         * @param index        Elevation index
         * @param responseCode response code, {@link android.bluetooth.BluetoothGatt#GATT_SUCCESS} or etc
         * @param delay        response delay(millis)
         * @param value        data for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> setElevationValidRange(int index, int responseCode, long delay, @NonNull byte[] value) {
            Map<Integer, DescriptorData> descriptorDataMap = mValidRangeMap.get(ELEVATION_CHARACTERISTIC);
            if (descriptorDataMap == null) {
                descriptorDataMap = new HashMap<>();
                mValidRangeMap.put(ELEVATION_CHARACTERISTIC, descriptorDataMap);
            }
            descriptorDataMap.put(index, new DescriptorData(VALID_RANGE_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ, responseCode, delay, value));
            return this;
        }

        /**
         * remove Elevation's Valid Range descriptor
         *
         * @param index Elevation index
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> removeElevationValidRange(int index) {
            Map<Integer, DescriptorData> descriptorDataMap = mValidRangeMap.get(ELEVATION_CHARACTERISTIC);
            if (descriptorDataMap == null) {
                descriptorDataMap = new HashMap<>();
                mValidRangeMap.put(ELEVATION_CHARACTERISTIC, descriptorDataMap);
            }
            descriptorDataMap.remove(index);
            return this;
        }

        /**
         * @see #addGustFactor(int, int, int, long, byte[])
         */
        @NonNull
        public Builder<T> addGustFactor(int index, @NonNull GustFactor gustFactor) {
            return addGustFactor(index, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, BluetoothGattCharacteristic.PERMISSION_READ, 0, gustFactor.getBytes());
        }

        /**
         * add Gust Factor characteristic
         *
         * @param index        Gust Factor index
         * @param property     combination of
         *                     {@link android.bluetooth.BluetoothGattCharacteristic#PROPERTY_READ}
         *                     {@link android.bluetooth.BluetoothGattCharacteristic#PROPERTY_NOTIFY}
         * @param responseCode response code, {@link android.bluetooth.BluetoothGatt#GATT_SUCCESS} or etc
         * @param delay        response delay(millis)
         * @param value        data for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> addGustFactor(int index, int property, int responseCode, long delay, @NonNull byte[] value) {
            Map<Integer, CharacteristicData> characteristicDataMap = mEsCharacteristicDataMap.get(GUST_FACTOR_CHARACTERISTIC);
            if (characteristicDataMap == null) {
                characteristicDataMap = new HashMap<>();
                mEsCharacteristicDataMap.put(GUST_FACTOR_CHARACTERISTIC, characteristicDataMap);
            }
            characteristicDataMap.put(index, new CharacteristicData(GUST_FACTOR_CHARACTERISTIC, property, BluetoothGattCharacteristic.PERMISSION_READ, new ArrayList<>(), responseCode, delay, value, 0));
            return this;
        }

        /**
         * remove Gust Factor characteristic
         *
         * @param index Gust Factor index
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> removeGustFactor(int index) {
            Map<Integer, CharacteristicData> characteristicDataMap = mEsCharacteristicDataMap.get(GUST_FACTOR_CHARACTERISTIC);
            if (characteristicDataMap == null) {
                characteristicDataMap = new HashMap<>();
                mEsCharacteristicDataMap.put(GUST_FACTOR_CHARACTERISTIC, characteristicDataMap);
            }
            characteristicDataMap.remove(index);
            return this;
        }

        /**
         * @see #setGustFactorEsMeasurement(int, int, long, byte[])
         */
        @NonNull
        public Builder<T> setGustFactorEsMeasurement(int index, EnvironmentalSensingMeasurement environmentalSensingMeasurement) {
            return setGustFactorEsMeasurement(index, BluetoothGatt.GATT_SUCCESS, 0, environmentalSensingMeasurement.getBytes());
        }

        /**
         * add Gust Factor's ES Measurement descriptor
         *
         * @param index        Gust Factor index
         * @param responseCode response code, {@link android.bluetooth.BluetoothGatt#GATT_SUCCESS} or etc
         * @param delay        response delay(millis)
         * @param value        data for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> setGustFactorEsMeasurement(int index, int responseCode, long delay, @NonNull byte[] value) {
            Map<Integer, DescriptorData> descriptorDataMap = mEsMeasurementMap.get(GUST_FACTOR_CHARACTERISTIC);
            if (descriptorDataMap == null) {
                descriptorDataMap = new HashMap<>();
                mEsMeasurementMap.put(GUST_FACTOR_CHARACTERISTIC, descriptorDataMap);
            }
            descriptorDataMap.put(index, new DescriptorData(ENVIRONMENTAL_SENSING_MEASUREMENT_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ, responseCode, delay, value));
            return this;
        }

        /**
         * remove Gust Factor's ES Measurement descriptor
         *
         * @param index Gust Factor index
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> removeGustFactorEsMeasurement(int index) {
            Map<Integer, DescriptorData> descriptorDataMap = mEsMeasurementMap.get(GUST_FACTOR_CHARACTERISTIC);
            if (descriptorDataMap == null) {
                descriptorDataMap = new HashMap<>();
                mEsMeasurementMap.put(GUST_FACTOR_CHARACTERISTIC, descriptorDataMap);
            }
            descriptorDataMap.remove(index);
            return this;
        }

        /**
         * @see #setGustFactorEsTriggerSetting(int, int, int, int, long, byte[])
         */
        @NonNull
        public Builder<T> setGustFactorEsTriggerSetting(int characteristicIndex, int descriptorIndex, EnvironmentalSensingTriggerSetting environmentalSensingTriggerSetting) {
            return setGustFactorEsTriggerSetting(characteristicIndex, descriptorIndex, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, BluetoothGatt.GATT_SUCCESS, 0, environmentalSensingTriggerSetting.getBytes());
        }

        /**
         * add Gust Factor's ES Trigger Setting descriptor
         *
         * @param characteristicIndex Gust Factor index
         * @param descriptorIndex     Environmental Sensing Trigger Setting index(0 - 2)
         * @param permission          combination of
         *                            {@link android.bluetooth.BluetoothGattDescriptor#PERMISSION_READ}
         *                            {@link android.bluetooth.BluetoothGattDescriptor#PERMISSION_WRITE}
         * @param responseCode        response code, {@link android.bluetooth.BluetoothGatt#GATT_SUCCESS} or etc
         * @param delay               response delay(millis)
         * @param value               data for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> setGustFactorEsTriggerSetting(int characteristicIndex, int descriptorIndex, int permission, int responseCode, long delay, @NonNull byte[] value) {
            Map<Integer, Map<Integer, DescriptorData>> characteristicDataMap = mEsTriggerSettingMap.get(GUST_FACTOR_CHARACTERISTIC);
            if (characteristicDataMap == null) {
                characteristicDataMap = new HashMap<>();
                mEsTriggerSettingMap.put(GUST_FACTOR_CHARACTERISTIC, characteristicDataMap);
            }
            Map<Integer, DescriptorData> descriptorDataMap = characteristicDataMap.get(characteristicIndex);
            if (descriptorDataMap == null) {
                descriptorDataMap = new HashMap<>();
                characteristicDataMap.put(characteristicIndex, descriptorDataMap);
            }
            descriptorDataMap.put(descriptorIndex, new DescriptorData(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR, permission, responseCode, delay, value));
            return this;
        }

        /**
         * remove Gust Factor's ES Trigger Setting descriptor
         *
         * @param characteristicIndex Gust Factor index
         * @param descriptorIndex     Environmental Sensing Trigger Setting index(0 - 2)
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> removeGustFactorEsTriggerSetting(int characteristicIndex, int descriptorIndex) {
            Map<Integer, Map<Integer, DescriptorData>> characteristicDataMap = mEsTriggerSettingMap.get(GUST_FACTOR_CHARACTERISTIC);
            if (characteristicDataMap == null) {
                characteristicDataMap = new HashMap<>();
                mEsTriggerSettingMap.put(GUST_FACTOR_CHARACTERISTIC, characteristicDataMap);
            }
            Map<Integer, DescriptorData> descriptorDataMap = characteristicDataMap.get(characteristicIndex);
            if (descriptorDataMap == null) {
                descriptorDataMap = new HashMap<>();
                characteristicDataMap.put(characteristicIndex, descriptorDataMap);
            }
            descriptorDataMap.remove(descriptorIndex);
            return this;
        }

        /**
         * @see #setGustFactorEsConfiguration(int, int, int, long, byte[])
         */
        @NonNull
        public Builder<T> setGustFactorEsConfiguration(int index, EnvironmentalSensingConfiguration environmentalSensingConfiguration) {
            return setGustFactorEsConfiguration(index, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, BluetoothGatt.GATT_SUCCESS, 0, environmentalSensingConfiguration.getBytes());
        }

        /**
         * add Gust Factor's ES Configuration descriptor
         *
         * @param index        Gust Factor index
         * @param permission   combination of
         *                     {@link android.bluetooth.BluetoothGattDescriptor#PERMISSION_READ}
         *                     {@link android.bluetooth.BluetoothGattDescriptor#PERMISSION_WRITE}
         * @param responseCode response code, {@link android.bluetooth.BluetoothGatt#GATT_SUCCESS} or etc
         * @param delay        response delay(millis)
         * @param value        data for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> setGustFactorEsConfiguration(int index, int permission, int responseCode, long delay, @NonNull byte[] value) {
            Map<Integer, DescriptorData> descriptorDataMap = mEsConfigurationMap.get(GUST_FACTOR_CHARACTERISTIC);
            if (descriptorDataMap == null) {
                descriptorDataMap = new HashMap<>();
                mEsConfigurationMap.put(GUST_FACTOR_CHARACTERISTIC, descriptorDataMap);
            }
            descriptorDataMap.put(index, new DescriptorData(ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR, permission, responseCode, delay, value));
            return this;
        }

        /**
         * remove Gust Factor's ES Configuration descriptor
         *
         * @param index Gust Factor index
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> removeGustFactorEsConfiguration(int index) {
            Map<Integer, DescriptorData> descriptorDataMap = mEsConfigurationMap.get(GUST_FACTOR_CHARACTERISTIC);
            if (descriptorDataMap == null) {
                descriptorDataMap = new HashMap<>();
                mEsConfigurationMap.put(GUST_FACTOR_CHARACTERISTIC, descriptorDataMap);
            }
            descriptorDataMap.remove(index);
            return this;
        }

        /**
         * @see #setGustFactorCharacteristicUserDescription(int, int, long, byte[])
         */
        @NonNull
        public Builder<T> setGustFactorCharacteristicUserDescription(int index, CharacteristicUserDescription characteristicUserDescription) {
            return setGustFactorCharacteristicUserDescription(index, BluetoothGatt.GATT_SUCCESS, 0, characteristicUserDescription.getBytes());
        }

        /**
         * add Gust Factor's Characteristic User Description descriptor
         *
         * @param index        Gust Factor index
         * @param responseCode response code, {@link android.bluetooth.BluetoothGatt#GATT_SUCCESS} or etc
         * @param delay        response delay(millis)
         * @param value        data for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> setGustFactorCharacteristicUserDescription(int index, int responseCode, long delay, @NonNull byte[] value) {
            Map<Integer, DescriptorData> descriptorDataMap = mCharacteristicUserDescriptionMap.get(GUST_FACTOR_CHARACTERISTIC);
            if (descriptorDataMap == null) {
                descriptorDataMap = new HashMap<>();
                mCharacteristicUserDescriptionMap.put(GUST_FACTOR_CHARACTERISTIC, descriptorDataMap);
            }
            descriptorDataMap.put(index, new DescriptorData(CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ, responseCode, delay, value));
            return this;
        }

        /**
         * remove Gust Factor's Characteristic User Description descriptor
         *
         * @param index Gust Factor index
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> removeGustFactorCharacteristicUserDescription(int index) {
            Map<Integer, DescriptorData> descriptorDataMap = mCharacteristicUserDescriptionMap.get(GUST_FACTOR_CHARACTERISTIC);
            if (descriptorDataMap == null) {
                descriptorDataMap = new HashMap<>();
                mCharacteristicUserDescriptionMap.put(GUST_FACTOR_CHARACTERISTIC, descriptorDataMap);
            }
            descriptorDataMap.remove(index);
            return this;
        }

        /**
         * @see #setGustFactorValidRange(int, int, long, byte[])
         */
        @NonNull
        public Builder<T> setGustFactorValidRange(int index, ValidRange validRange) {
            return setGustFactorValidRange(index, BluetoothGatt.GATT_SUCCESS, 0, validRange.getBytes());
        }

        /**
         * add Gust Factor's Valid Range descriptor
         *
         * @param index        Gust Factor index
         * @param responseCode response code, {@link android.bluetooth.BluetoothGatt#GATT_SUCCESS} or etc
         * @param delay        response delay(millis)
         * @param value        data for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> setGustFactorValidRange(int index, int responseCode, long delay, @NonNull byte[] value) {
            Map<Integer, DescriptorData> descriptorDataMap = mValidRangeMap.get(GUST_FACTOR_CHARACTERISTIC);
            if (descriptorDataMap == null) {
                descriptorDataMap = new HashMap<>();
                mValidRangeMap.put(GUST_FACTOR_CHARACTERISTIC, descriptorDataMap);
            }
            descriptorDataMap.put(index, new DescriptorData(VALID_RANGE_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ, responseCode, delay, value));
            return this;
        }

        /**
         * remove AGust Factor's Valid Range descriptor
         *
         * @param index Gust Factor index
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> removeGustFactorValidRange(int index) {
            Map<Integer, DescriptorData> descriptorDataMap = mValidRangeMap.get(GUST_FACTOR_CHARACTERISTIC);
            if (descriptorDataMap == null) {
                descriptorDataMap = new HashMap<>();
                mValidRangeMap.put(GUST_FACTOR_CHARACTERISTIC, descriptorDataMap);
            }
            descriptorDataMap.remove(index);
            return this;
        }

        /**
         * @see #addHeatIndex(int, int, int, long, byte[])
         */
        @NonNull
        public Builder<T> addHeatIndex(int index, @NonNull HeatIndex heatIndex) {
            return addHeatIndex(index, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, BluetoothGattCharacteristic.PERMISSION_READ, 0, heatIndex.getBytes());
        }

        /**
         * add Heat Index characteristic
         *
         * @param index        Heat Index index
         * @param property     combination of
         *                     {@link android.bluetooth.BluetoothGattCharacteristic#PROPERTY_READ}
         *                     {@link android.bluetooth.BluetoothGattCharacteristic#PROPERTY_NOTIFY}
         * @param responseCode response code, {@link android.bluetooth.BluetoothGatt#GATT_SUCCESS} or etc
         * @param delay        response delay(millis)
         * @param value        data for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> addHeatIndex(int index, int property, int responseCode, long delay, @NonNull byte[] value) {
            Map<Integer, CharacteristicData> characteristicDataMap = mEsCharacteristicDataMap.get(HEAT_INDEX_CHARACTERISTIC);
            if (characteristicDataMap == null) {
                characteristicDataMap = new HashMap<>();
                mEsCharacteristicDataMap.put(HEAT_INDEX_CHARACTERISTIC, characteristicDataMap);
            }
            characteristicDataMap.put(index, new CharacteristicData(HEAT_INDEX_CHARACTERISTIC, property, BluetoothGattCharacteristic.PERMISSION_READ, new ArrayList<>(), responseCode, delay, value, 0));
            return this;
        }

        /**
         * remove Heat Index characteristic
         *
         * @param index Heat Index index
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> removeHeatIndex(int index) {
            Map<Integer, CharacteristicData> characteristicDataMap = mEsCharacteristicDataMap.get(HEAT_INDEX_CHARACTERISTIC);
            if (characteristicDataMap == null) {
                characteristicDataMap = new HashMap<>();
                mEsCharacteristicDataMap.put(HEAT_INDEX_CHARACTERISTIC, characteristicDataMap);
            }
            characteristicDataMap.remove(index);
            return this;
        }

        /**
         * @see #setHeatIndexEsMeasurement(int, int, long, byte[])
         */
        @NonNull
        public Builder<T> setHeatIndexEsMeasurement(int index, EnvironmentalSensingMeasurement environmentalSensingMeasurement) {
            return setHeatIndexEsMeasurement(index, BluetoothGatt.GATT_SUCCESS, 0, environmentalSensingMeasurement.getBytes());
        }

        /**
         * add Heat Index's ES Measurement descriptor
         *
         * @param index        Heat Index index
         * @param responseCode response code, {@link android.bluetooth.BluetoothGatt#GATT_SUCCESS} or etc
         * @param delay        response delay(millis)
         * @param value        data for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> setHeatIndexEsMeasurement(int index, int responseCode, long delay, @NonNull byte[] value) {
            Map<Integer, DescriptorData> descriptorDataMap = mEsMeasurementMap.get(HEAT_INDEX_CHARACTERISTIC);
            if (descriptorDataMap == null) {
                descriptorDataMap = new HashMap<>();
                mEsMeasurementMap.put(HEAT_INDEX_CHARACTERISTIC, descriptorDataMap);
            }
            descriptorDataMap.put(index, new DescriptorData(ENVIRONMENTAL_SENSING_MEASUREMENT_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ, responseCode, delay, value));
            return this;
        }

        /**
         * remove Heat Index's ES Measurement descriptor
         *
         * @param index Heat Index index
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> removeHeatIndexEsMeasurement(int index) {
            Map<Integer, DescriptorData> descriptorDataMap = mEsMeasurementMap.get(HEAT_INDEX_CHARACTERISTIC);
            if (descriptorDataMap == null) {
                descriptorDataMap = new HashMap<>();
                mEsMeasurementMap.put(HEAT_INDEX_CHARACTERISTIC, descriptorDataMap);
            }
            descriptorDataMap.remove(index);
            return this;
        }

        /**
         * @see #setHeatIndexEsTriggerSetting(int, int, int, int, long, byte[])
         */
        @NonNull
        public Builder<T> setHeatIndexEsTriggerSetting(int characteristicIndex, int descriptorIndex, EnvironmentalSensingTriggerSetting environmentalSensingTriggerSetting) {
            return setHeatIndexEsTriggerSetting(characteristicIndex, descriptorIndex, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, BluetoothGatt.GATT_SUCCESS, 0, environmentalSensingTriggerSetting.getBytes());
        }

        /**
         * add Heat Index's ES Trigger Setting descriptor
         *
         * @param characteristicIndex Heat Index index
         * @param descriptorIndex     Environmental Sensing Trigger Setting index(0 - 2)
         * @param permission          combination of
         *                            {@link android.bluetooth.BluetoothGattDescriptor#PERMISSION_READ}
         *                            {@link android.bluetooth.BluetoothGattDescriptor#PERMISSION_WRITE}
         * @param responseCode        response code, {@link android.bluetooth.BluetoothGatt#GATT_SUCCESS} or etc
         * @param delay               response delay(millis)
         * @param value               data for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> setHeatIndexEsTriggerSetting(int characteristicIndex, int descriptorIndex, int permission, int responseCode, long delay, @NonNull byte[] value) {
            Map<Integer, Map<Integer, DescriptorData>> characteristicDataMap = mEsTriggerSettingMap.get(HEAT_INDEX_CHARACTERISTIC);
            if (characteristicDataMap == null) {
                characteristicDataMap = new HashMap<>();
                mEsTriggerSettingMap.put(HEAT_INDEX_CHARACTERISTIC, characteristicDataMap);
            }
            Map<Integer, DescriptorData> descriptorDataMap = characteristicDataMap.get(characteristicIndex);
            if (descriptorDataMap == null) {
                descriptorDataMap = new HashMap<>();
                characteristicDataMap.put(characteristicIndex, descriptorDataMap);
            }
            descriptorDataMap.put(descriptorIndex, new DescriptorData(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR, permission, responseCode, delay, value));
            return this;
        }

        /**
         * remove Heat Index's ES Trigger Setting descriptor
         *
         * @param characteristicIndex Heat Index index
         * @param descriptorIndex     Environmental Sensing Trigger Setting index(0 - 2)
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> removeHeatIndexEsTriggerSetting(int characteristicIndex, int descriptorIndex) {
            Map<Integer, Map<Integer, DescriptorData>> characteristicDataMap = mEsTriggerSettingMap.get(HEAT_INDEX_CHARACTERISTIC);
            if (characteristicDataMap == null) {
                characteristicDataMap = new HashMap<>();
                mEsTriggerSettingMap.put(HEAT_INDEX_CHARACTERISTIC, characteristicDataMap);
            }
            Map<Integer, DescriptorData> descriptorDataMap = characteristicDataMap.get(characteristicIndex);
            if (descriptorDataMap == null) {
                descriptorDataMap = new HashMap<>();
                characteristicDataMap.put(characteristicIndex, descriptorDataMap);
            }
            descriptorDataMap.remove(descriptorIndex);
            return this;
        }

        /**
         * @see #setHeatIndexEsConfiguration(int, int, int, long, byte[])
         */
        @NonNull
        public Builder<T> setHeatIndexEsConfiguration(int index, EnvironmentalSensingConfiguration environmentalSensingConfiguration) {
            return setHeatIndexEsConfiguration(index, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, BluetoothGatt.GATT_SUCCESS, 0, environmentalSensingConfiguration.getBytes());
        }

        /**
         * add Heat Index's ES Configuration descriptor
         *
         * @param index        Heat Index index
         * @param permission   combination of
         *                     {@link android.bluetooth.BluetoothGattDescriptor#PERMISSION_READ}
         *                     {@link android.bluetooth.BluetoothGattDescriptor#PERMISSION_WRITE}
         * @param responseCode response code, {@link android.bluetooth.BluetoothGatt#GATT_SUCCESS} or etc
         * @param delay        response delay(millis)
         * @param value        data for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> setHeatIndexEsConfiguration(int index, int permission, int responseCode, long delay, @NonNull byte[] value) {
            Map<Integer, DescriptorData> descriptorDataMap = mEsConfigurationMap.get(HEAT_INDEX_CHARACTERISTIC);
            if (descriptorDataMap == null) {
                descriptorDataMap = new HashMap<>();
                mEsConfigurationMap.put(HEAT_INDEX_CHARACTERISTIC, descriptorDataMap);
            }
            descriptorDataMap.put(index, new DescriptorData(ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR, permission, responseCode, delay, value));
            return this;
        }

        /**
         * remove Heat Index's ES Configuration descriptor
         *
         * @param index Heat Index index
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> removeHeatIndexEsConfiguration(int index) {
            Map<Integer, DescriptorData> descriptorDataMap = mEsConfigurationMap.get(HEAT_INDEX_CHARACTERISTIC);
            if (descriptorDataMap == null) {
                descriptorDataMap = new HashMap<>();
                mEsConfigurationMap.put(HEAT_INDEX_CHARACTERISTIC, descriptorDataMap);
            }
            descriptorDataMap.remove(index);
            return this;
        }

        /**
         * @see #setHeatIndexCharacteristicUserDescription(int, int, long, byte[])
         */
        @NonNull
        public Builder<T> setHeatIndexCharacteristicUserDescription(int index, CharacteristicUserDescription characteristicUserDescription) {
            return setHeatIndexCharacteristicUserDescription(index, BluetoothGatt.GATT_SUCCESS, 0, characteristicUserDescription.getBytes());
        }

        /**
         * add Heat Index's Characteristic User Description descriptor
         *
         * @param index        Heat Index index
         * @param responseCode response code, {@link android.bluetooth.BluetoothGatt#GATT_SUCCESS} or etc
         * @param delay        response delay(millis)
         * @param value        data for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> setHeatIndexCharacteristicUserDescription(int index, int responseCode, long delay, @NonNull byte[] value) {
            Map<Integer, DescriptorData> descriptorDataMap = mCharacteristicUserDescriptionMap.get(HEAT_INDEX_CHARACTERISTIC);
            if (descriptorDataMap == null) {
                descriptorDataMap = new HashMap<>();
                mCharacteristicUserDescriptionMap.put(HEAT_INDEX_CHARACTERISTIC, descriptorDataMap);
            }
            descriptorDataMap.put(index, new DescriptorData(CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ, responseCode, delay, value));
            return this;
        }

        /**
         * remove Heat Index's Characteristic User Description descriptor
         *
         * @param index Heat Index index
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> removeHeatIndexCharacteristicUserDescription(int index) {
            Map<Integer, DescriptorData> descriptorDataMap = mCharacteristicUserDescriptionMap.get(HEAT_INDEX_CHARACTERISTIC);
            if (descriptorDataMap == null) {
                descriptorDataMap = new HashMap<>();
                mCharacteristicUserDescriptionMap.put(HEAT_INDEX_CHARACTERISTIC, descriptorDataMap);
            }
            descriptorDataMap.remove(index);
            return this;
        }

        /**
         * @see #setHeatIndexValidRange(int, int, long, byte[])
         */
        @NonNull
        public Builder<T> setHeatIndexValidRange(int index, ValidRange validRange) {
            return setHeatIndexValidRange(index, BluetoothGatt.GATT_SUCCESS, 0, validRange.getBytes());
        }

        /**
         * add Heat Index's Valid Range descriptor
         *
         * @param index        Heat Index index
         * @param responseCode response code, {@link android.bluetooth.BluetoothGatt#GATT_SUCCESS} or etc
         * @param delay        response delay(millis)
         * @param value        data for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> setHeatIndexValidRange(int index, int responseCode, long delay, @NonNull byte[] value) {
            Map<Integer, DescriptorData> descriptorDataMap = mValidRangeMap.get(HEAT_INDEX_CHARACTERISTIC);
            if (descriptorDataMap == null) {
                descriptorDataMap = new HashMap<>();
                mValidRangeMap.put(HEAT_INDEX_CHARACTERISTIC, descriptorDataMap);
            }
            descriptorDataMap.put(index, new DescriptorData(VALID_RANGE_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ, responseCode, delay, value));
            return this;
        }

        /**
         * remove Heat Index's Valid Range descriptor
         *
         * @param index Heat Index index
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> removeHeatIndexValidRange(int index) {
            Map<Integer, DescriptorData> descriptorDataMap = mValidRangeMap.get(HEAT_INDEX_CHARACTERISTIC);
            if (descriptorDataMap == null) {
                descriptorDataMap = new HashMap<>();
                mValidRangeMap.put(HEAT_INDEX_CHARACTERISTIC, descriptorDataMap);
            }
            descriptorDataMap.remove(index);
            return this;
        }

        /**
         * @see #addHumidity(int, int, int, long, byte[])
         */
        @NonNull
        public Builder<T> addHumidity(int index, @NonNull Humidity humidity) {
            return addHumidity(index, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, BluetoothGattCharacteristic.PERMISSION_READ, 0, humidity.getBytes());
        }

        /**
         * add Humidity characteristic
         *
         * @param index        Humidity index
         * @param property     combination of
         *                     {@link android.bluetooth.BluetoothGattCharacteristic#PROPERTY_READ}
         *                     {@link android.bluetooth.BluetoothGattCharacteristic#PROPERTY_NOTIFY}
         * @param responseCode response code, {@link android.bluetooth.BluetoothGatt#GATT_SUCCESS} or etc
         * @param delay        response delay(millis)
         * @param value        data for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> addHumidity(int index, int property, int responseCode, long delay, @NonNull byte[] value) {
            Map<Integer, CharacteristicData> characteristicDataMap = mEsCharacteristicDataMap.get(HUMIDITY_CHARACTERISTIC);
            if (characteristicDataMap == null) {
                characteristicDataMap = new HashMap<>();
                mEsCharacteristicDataMap.put(HUMIDITY_CHARACTERISTIC, characteristicDataMap);
            }
            characteristicDataMap.put(index, new CharacteristicData(HUMIDITY_CHARACTERISTIC, property, BluetoothGattCharacteristic.PERMISSION_READ, new ArrayList<>(), responseCode, delay, value, 0));
            return this;
        }

        /**
         * remove Humidity characteristic
         *
         * @param index Humidity index
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> removeHumidity(int index) {
            Map<Integer, CharacteristicData> characteristicDataMap = mEsCharacteristicDataMap.get(HUMIDITY_CHARACTERISTIC);
            if (characteristicDataMap == null) {
                characteristicDataMap = new HashMap<>();
                mEsCharacteristicDataMap.put(HUMIDITY_CHARACTERISTIC, characteristicDataMap);
            }
            characteristicDataMap.remove(index);
            return this;
        }

        /**
         * @see #setHumidityEsMeasurement(int, int, long, byte[])
         */
        @NonNull
        public Builder<T> setHumidityEsMeasurement(int index, EnvironmentalSensingMeasurement environmentalSensingMeasurement) {
            return setHumidityEsMeasurement(index, BluetoothGatt.GATT_SUCCESS, 0, environmentalSensingMeasurement.getBytes());
        }

        /**
         * add Humidity's ES Measurement descriptor
         *
         * @param index        Humidity index
         * @param responseCode response code, {@link android.bluetooth.BluetoothGatt#GATT_SUCCESS} or etc
         * @param delay        response delay(millis)
         * @param value        data for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> setHumidityEsMeasurement(int index, int responseCode, long delay, @NonNull byte[] value) {
            Map<Integer, DescriptorData> descriptorDataMap = mEsMeasurementMap.get(HUMIDITY_CHARACTERISTIC);
            if (descriptorDataMap == null) {
                descriptorDataMap = new HashMap<>();
                mEsMeasurementMap.put(HUMIDITY_CHARACTERISTIC, descriptorDataMap);
            }
            descriptorDataMap.put(index, new DescriptorData(ENVIRONMENTAL_SENSING_MEASUREMENT_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ, responseCode, delay, value));
            return this;
        }

        /**
         * remove Humidity's ES Measurement descriptor
         *
         * @param index Humidity index
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> removeHumidityEsMeasurement(int index) {
            Map<Integer, DescriptorData> descriptorDataMap = mEsMeasurementMap.get(HUMIDITY_CHARACTERISTIC);
            if (descriptorDataMap == null) {
                descriptorDataMap = new HashMap<>();
                mEsMeasurementMap.put(HUMIDITY_CHARACTERISTIC, descriptorDataMap);
            }
            descriptorDataMap.remove(index);
            return this;
        }

        /**
         * @see #setHumidityEsTriggerSetting(int, int, int, int, long, byte[])
         */
        @NonNull
        public Builder<T> setHumidityEsTriggerSetting(int characteristicIndex, int descriptorIndex, EnvironmentalSensingTriggerSetting environmentalSensingTriggerSetting) {
            return setHumidityEsTriggerSetting(characteristicIndex, descriptorIndex, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, BluetoothGatt.GATT_SUCCESS, 0, environmentalSensingTriggerSetting.getBytes());
        }

        /**
         * add Humidity's ES Trigger Setting descriptor
         *
         * @param characteristicIndex Humidity index
         * @param descriptorIndex     Environmental Sensing Trigger Setting index(0 - 2)
         * @param permission          combination of
         *                            {@link android.bluetooth.BluetoothGattDescriptor#PERMISSION_READ}
         *                            {@link android.bluetooth.BluetoothGattDescriptor#PERMISSION_WRITE}
         * @param responseCode        response code, {@link android.bluetooth.BluetoothGatt#GATT_SUCCESS} or etc
         * @param delay               response delay(millis)
         * @param value               data for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> setHumidityEsTriggerSetting(int characteristicIndex, int descriptorIndex, int permission, int responseCode, long delay, @NonNull byte[] value) {
            Map<Integer, Map<Integer, DescriptorData>> characteristicDataMap = mEsTriggerSettingMap.get(HUMIDITY_CHARACTERISTIC);
            if (characteristicDataMap == null) {
                characteristicDataMap = new HashMap<>();
                mEsTriggerSettingMap.put(HUMIDITY_CHARACTERISTIC, characteristicDataMap);
            }
            Map<Integer, DescriptorData> descriptorDataMap = characteristicDataMap.get(characteristicIndex);
            if (descriptorDataMap == null) {
                descriptorDataMap = new HashMap<>();
                characteristicDataMap.put(characteristicIndex, descriptorDataMap);
            }
            descriptorDataMap.put(descriptorIndex, new DescriptorData(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR, permission, responseCode, delay, value));
            return this;
        }

        /**
         * remove Humidity's ES Trigger Setting descriptor
         *
         * @param characteristicIndex Humidity index
         * @param descriptorIndex     Environmental Sensing Trigger Setting index(0 - 2)
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> removeHumidityEsTriggerSetting(int characteristicIndex, int descriptorIndex) {
            Map<Integer, Map<Integer, DescriptorData>> characteristicDataMap = mEsTriggerSettingMap.get(HUMIDITY_CHARACTERISTIC);
            if (characteristicDataMap == null) {
                characteristicDataMap = new HashMap<>();
                mEsTriggerSettingMap.put(HUMIDITY_CHARACTERISTIC, characteristicDataMap);
            }
            Map<Integer, DescriptorData> descriptorDataMap = characteristicDataMap.get(characteristicIndex);
            if (descriptorDataMap == null) {
                descriptorDataMap = new HashMap<>();
                characteristicDataMap.put(characteristicIndex, descriptorDataMap);
            }
            descriptorDataMap.remove(descriptorIndex);
            return this;
        }

        /**
         * @see #setHumidityEsConfiguration(int, int, int, long, byte[])
         */
        @NonNull
        public Builder<T> setHumidityEsConfiguration(int index, EnvironmentalSensingConfiguration environmentalSensingConfiguration) {
            return setHumidityEsConfiguration(index, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, BluetoothGatt.GATT_SUCCESS, 0, environmentalSensingConfiguration.getBytes());
        }

        /**
         * add Humidity's ES Configuration descriptor
         *
         * @param index        Humidity index
         * @param permission   combination of
         *                     {@link android.bluetooth.BluetoothGattDescriptor#PERMISSION_READ}
         *                     {@link android.bluetooth.BluetoothGattDescriptor#PERMISSION_WRITE}
         * @param responseCode response code, {@link android.bluetooth.BluetoothGatt#GATT_SUCCESS} or etc
         * @param delay        response delay(millis)
         * @param value        data for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> setHumidityEsConfiguration(int index, int permission, int responseCode, long delay, @NonNull byte[] value) {
            Map<Integer, DescriptorData> descriptorDataMap = mEsConfigurationMap.get(HUMIDITY_CHARACTERISTIC);
            if (descriptorDataMap == null) {
                descriptorDataMap = new HashMap<>();
                mEsConfigurationMap.put(HUMIDITY_CHARACTERISTIC, descriptorDataMap);
            }
            descriptorDataMap.put(index, new DescriptorData(ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR, permission, responseCode, delay, value));
            return this;
        }

        /**
         * remove Humidity's ES Configuration descriptor
         *
         * @param index Humidity index
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> removeHumidityEsConfiguration(int index) {
            Map<Integer, DescriptorData> descriptorDataMap = mEsConfigurationMap.get(HUMIDITY_CHARACTERISTIC);
            if (descriptorDataMap == null) {
                descriptorDataMap = new HashMap<>();
                mEsConfigurationMap.put(HUMIDITY_CHARACTERISTIC, descriptorDataMap);
            }
            descriptorDataMap.remove(index);
            return this;
        }

        /**
         * @see #setHumidityCharacteristicUserDescription(int, int, long, byte[])
         */
        @NonNull
        public Builder<T> setHumidityCharacteristicUserDescription(int index, CharacteristicUserDescription characteristicUserDescription) {
            return setHumidityCharacteristicUserDescription(index, BluetoothGatt.GATT_SUCCESS, 0, characteristicUserDescription.getBytes());
        }

        /**
         * add Humidity's Characteristic User Description descriptor
         *
         * @param index        Humidity index
         * @param responseCode response code, {@link android.bluetooth.BluetoothGatt#GATT_SUCCESS} or etc
         * @param delay        response delay(millis)
         * @param value        data for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> setHumidityCharacteristicUserDescription(int index, int responseCode, long delay, @NonNull byte[] value) {
            Map<Integer, DescriptorData> descriptorDataMap = mCharacteristicUserDescriptionMap.get(HUMIDITY_CHARACTERISTIC);
            if (descriptorDataMap == null) {
                descriptorDataMap = new HashMap<>();
                mCharacteristicUserDescriptionMap.put(HUMIDITY_CHARACTERISTIC, descriptorDataMap);
            }
            descriptorDataMap.put(index, new DescriptorData(CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ, responseCode, delay, value));
            return this;
        }

        /**
         * remove Humidity's Characteristic User Description descriptor
         *
         * @param index Humidity index
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> removeHumidityCharacteristicUserDescription(int index) {
            Map<Integer, DescriptorData> descriptorDataMap = mCharacteristicUserDescriptionMap.get(HUMIDITY_CHARACTERISTIC);
            if (descriptorDataMap == null) {
                descriptorDataMap = new HashMap<>();
                mCharacteristicUserDescriptionMap.put(HUMIDITY_CHARACTERISTIC, descriptorDataMap);
            }
            descriptorDataMap.remove(index);
            return this;
        }

        /**
         * @see #setHumidityValidRange(int, int, long, byte[])
         */
        @NonNull
        public Builder<T> setHumidityValidRange(int index, ValidRange validRange) {
            return setHumidityValidRange(index, BluetoothGatt.GATT_SUCCESS, 0, validRange.getBytes());
        }

        /**
         * add Humidity's Valid Range descriptor
         *
         * @param index        Humidity index
         * @param responseCode response code, {@link android.bluetooth.BluetoothGatt#GATT_SUCCESS} or etc
         * @param delay        response delay(millis)
         * @param value        data for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> setHumidityValidRange(int index, int responseCode, long delay, @NonNull byte[] value) {
            Map<Integer, DescriptorData> descriptorDataMap = mValidRangeMap.get(HUMIDITY_CHARACTERISTIC);
            if (descriptorDataMap == null) {
                descriptorDataMap = new HashMap<>();
                mValidRangeMap.put(HUMIDITY_CHARACTERISTIC, descriptorDataMap);
            }
            descriptorDataMap.put(index, new DescriptorData(VALID_RANGE_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ, responseCode, delay, value));
            return this;
        }

        /**
         * remove AHumidity's Valid Range descriptor
         *
         * @param index Humidity index
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> removeHumidityValidRange(int index) {
            Map<Integer, DescriptorData> descriptorDataMap = mValidRangeMap.get(HUMIDITY_CHARACTERISTIC);
            if (descriptorDataMap == null) {
                descriptorDataMap = new HashMap<>();
                mValidRangeMap.put(HUMIDITY_CHARACTERISTIC, descriptorDataMap);
            }
            descriptorDataMap.remove(index);
            return this;
        }

        /**
         * @see #addIrradiance(int, int, int, long, byte[])
         */
        @NonNull
        public Builder<T> addIrradiance(int index, @NonNull Irradiance irradiance) {
            return addIrradiance(index, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, BluetoothGattCharacteristic.PERMISSION_READ, 0, irradiance.getBytes());
        }

        /**
         * add Irradiance characteristic
         *
         * @param index        Irradiance index
         * @param property     combination of
         *                     {@link android.bluetooth.BluetoothGattCharacteristic#PROPERTY_READ}
         *                     {@link android.bluetooth.BluetoothGattCharacteristic#PROPERTY_NOTIFY}
         * @param responseCode response code, {@link android.bluetooth.BluetoothGatt#GATT_SUCCESS} or etc
         * @param delay        response delay(millis)
         * @param value        data for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> addIrradiance(int index, int property, int responseCode, long delay, @NonNull byte[] value) {
            Map<Integer, CharacteristicData> characteristicDataMap = mEsCharacteristicDataMap.get(IRRADIANCE_CHARACTERISTIC);
            if (characteristicDataMap == null) {
                characteristicDataMap = new HashMap<>();
                mEsCharacteristicDataMap.put(IRRADIANCE_CHARACTERISTIC, characteristicDataMap);
            }
            characteristicDataMap.put(index, new CharacteristicData(IRRADIANCE_CHARACTERISTIC, property, BluetoothGattCharacteristic.PERMISSION_READ, new ArrayList<>(), responseCode, delay, value, 0));
            return this;
        }

        /**
         * remove Irradiance characteristic
         *
         * @param index Irradiance index
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> removeIrradiance(int index) {
            Map<Integer, CharacteristicData> characteristicDataMap = mEsCharacteristicDataMap.get(IRRADIANCE_CHARACTERISTIC);
            if (characteristicDataMap == null) {
                characteristicDataMap = new HashMap<>();
                mEsCharacteristicDataMap.put(IRRADIANCE_CHARACTERISTIC, characteristicDataMap);
            }
            characteristicDataMap.remove(index);
            return this;
        }

        /**
         * @see #setIrradianceEsMeasurement(int, int, long, byte[])
         */
        @NonNull
        public Builder<T> setIrradianceEsMeasurement(int index, EnvironmentalSensingMeasurement environmentalSensingMeasurement) {
            return setIrradianceEsMeasurement(index, BluetoothGatt.GATT_SUCCESS, 0, environmentalSensingMeasurement.getBytes());
        }

        /**
         * add Irradiance's ES Measurement descriptor
         *
         * @param index        Irradiance index
         * @param responseCode response code, {@link android.bluetooth.BluetoothGatt#GATT_SUCCESS} or etc
         * @param delay        response delay(millis)
         * @param value        data for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> setIrradianceEsMeasurement(int index, int responseCode, long delay, @NonNull byte[] value) {
            Map<Integer, DescriptorData> descriptorDataMap = mEsMeasurementMap.get(IRRADIANCE_CHARACTERISTIC);
            if (descriptorDataMap == null) {
                descriptorDataMap = new HashMap<>();
                mEsMeasurementMap.put(IRRADIANCE_CHARACTERISTIC, descriptorDataMap);
            }
            descriptorDataMap.put(index, new DescriptorData(ENVIRONMENTAL_SENSING_MEASUREMENT_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ, responseCode, delay, value));
            return this;
        }

        /**
         * remove Irradiance's ES Measurement descriptor
         *
         * @param index Irradiance index
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> removeIrradianceEsMeasurement(int index) {
            Map<Integer, DescriptorData> descriptorDataMap = mEsMeasurementMap.get(IRRADIANCE_CHARACTERISTIC);
            if (descriptorDataMap == null) {
                descriptorDataMap = new HashMap<>();
                mEsMeasurementMap.put(IRRADIANCE_CHARACTERISTIC, descriptorDataMap);
            }
            descriptorDataMap.remove(index);
            return this;
        }

        /**
         * @see #setIrradianceEsTriggerSetting(int, int, int, int, long, byte[])
         */
        @NonNull
        public Builder<T> setIrradianceEsTriggerSetting(int characteristicIndex, int descriptorIndex, EnvironmentalSensingTriggerSetting environmentalSensingTriggerSetting) {
            return setIrradianceEsTriggerSetting(characteristicIndex, descriptorIndex, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, BluetoothGatt.GATT_SUCCESS, 0, environmentalSensingTriggerSetting.getBytes());
        }

        /**
         * add Irradiance's ES Trigger Setting descriptor
         *
         * @param characteristicIndex Irradiance index
         * @param descriptorIndex     Environmental Sensing Trigger Setting index(0 - 2)
         * @param permission          combination of
         *                            {@link android.bluetooth.BluetoothGattDescriptor#PERMISSION_READ}
         *                            {@link android.bluetooth.BluetoothGattDescriptor#PERMISSION_WRITE}
         * @param responseCode        response code, {@link android.bluetooth.BluetoothGatt#GATT_SUCCESS} or etc
         * @param delay               response delay(millis)
         * @param value               data for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> setIrradianceEsTriggerSetting(int characteristicIndex, int descriptorIndex, int permission, int responseCode, long delay, @NonNull byte[] value) {
            Map<Integer, Map<Integer, DescriptorData>> characteristicDataMap = mEsTriggerSettingMap.get(IRRADIANCE_CHARACTERISTIC);
            if (characteristicDataMap == null) {
                characteristicDataMap = new HashMap<>();
                mEsTriggerSettingMap.put(IRRADIANCE_CHARACTERISTIC, characteristicDataMap);
            }
            Map<Integer, DescriptorData> descriptorDataMap = characteristicDataMap.get(characteristicIndex);
            if (descriptorDataMap == null) {
                descriptorDataMap = new HashMap<>();
                characteristicDataMap.put(characteristicIndex, descriptorDataMap);
            }
            descriptorDataMap.put(descriptorIndex, new DescriptorData(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR, permission, responseCode, delay, value));
            return this;
        }

        /**
         * remove Irradiance's ES Trigger Setting descriptor
         *
         * @param characteristicIndex Irradiance index
         * @param descriptorIndex     Environmental Sensing Trigger Setting index(0 - 2)
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> removeIrradianceEsTriggerSetting(int characteristicIndex, int descriptorIndex) {
            Map<Integer, Map<Integer, DescriptorData>> characteristicDataMap = mEsTriggerSettingMap.get(IRRADIANCE_CHARACTERISTIC);
            if (characteristicDataMap == null) {
                characteristicDataMap = new HashMap<>();
                mEsTriggerSettingMap.put(IRRADIANCE_CHARACTERISTIC, characteristicDataMap);
            }
            Map<Integer, DescriptorData> descriptorDataMap = characteristicDataMap.get(characteristicIndex);
            if (descriptorDataMap == null) {
                descriptorDataMap = new HashMap<>();
                characteristicDataMap.put(characteristicIndex, descriptorDataMap);
            }
            descriptorDataMap.remove(descriptorIndex);
            return this;
        }

        /**
         * @see #setIrradianceEsConfiguration(int, int, int, long, byte[])
         */
        @NonNull
        public Builder<T> setIrradianceEsConfiguration(int index, EnvironmentalSensingConfiguration environmentalSensingConfiguration) {
            return setIrradianceEsConfiguration(index, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, BluetoothGatt.GATT_SUCCESS, 0, environmentalSensingConfiguration.getBytes());
        }

        /**
         * add Irradiance's ES Configuration descriptor
         *
         * @param index        Irradiance index
         * @param permission   combination of
         *                     {@link android.bluetooth.BluetoothGattDescriptor#PERMISSION_READ}
         *                     {@link android.bluetooth.BluetoothGattDescriptor#PERMISSION_WRITE}
         * @param responseCode response code, {@link android.bluetooth.BluetoothGatt#GATT_SUCCESS} or etc
         * @param delay        response delay(millis)
         * @param value        data for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> setIrradianceEsConfiguration(int index, int permission, int responseCode, long delay, @NonNull byte[] value) {
            Map<Integer, DescriptorData> descriptorDataMap = mEsConfigurationMap.get(IRRADIANCE_CHARACTERISTIC);
            if (descriptorDataMap == null) {
                descriptorDataMap = new HashMap<>();
                mEsConfigurationMap.put(IRRADIANCE_CHARACTERISTIC, descriptorDataMap);
            }
            descriptorDataMap.put(index, new DescriptorData(ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR, permission, responseCode, delay, value));
            return this;
        }

        /**
         * remove Irradiance's ES Configuration descriptor
         *
         * @param index Irradiance index
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> removeIrradianceEsConfiguration(int index) {
            Map<Integer, DescriptorData> descriptorDataMap = mEsConfigurationMap.get(IRRADIANCE_CHARACTERISTIC);
            if (descriptorDataMap == null) {
                descriptorDataMap = new HashMap<>();
                mEsConfigurationMap.put(IRRADIANCE_CHARACTERISTIC, descriptorDataMap);
            }
            descriptorDataMap.remove(index);
            return this;
        }

        /**
         * @see #setIrradianceCharacteristicUserDescription(int, int, long, byte[])
         */
        @NonNull
        public Builder<T> setIrradianceCharacteristicUserDescription(int index, CharacteristicUserDescription characteristicUserDescription) {
            return setIrradianceCharacteristicUserDescription(index, BluetoothGatt.GATT_SUCCESS, 0, characteristicUserDescription.getBytes());
        }

        /**
         * add Irradiance's Characteristic User Description descriptor
         *
         * @param index        Irradiance index
         * @param responseCode response code, {@link android.bluetooth.BluetoothGatt#GATT_SUCCESS} or etc
         * @param delay        response delay(millis)
         * @param value        data for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> setIrradianceCharacteristicUserDescription(int index, int responseCode, long delay, @NonNull byte[] value) {
            Map<Integer, DescriptorData> descriptorDataMap = mCharacteristicUserDescriptionMap.get(IRRADIANCE_CHARACTERISTIC);
            if (descriptorDataMap == null) {
                descriptorDataMap = new HashMap<>();
                mCharacteristicUserDescriptionMap.put(IRRADIANCE_CHARACTERISTIC, descriptorDataMap);
            }
            descriptorDataMap.put(index, new DescriptorData(CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ, responseCode, delay, value));
            return this;
        }

        /**
         * remove Irradiance's Characteristic User Description descriptor
         *
         * @param index Irradiance index
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> removeIrradianceCharacteristicUserDescription(int index) {
            Map<Integer, DescriptorData> descriptorDataMap = mCharacteristicUserDescriptionMap.get(IRRADIANCE_CHARACTERISTIC);
            if (descriptorDataMap == null) {
                descriptorDataMap = new HashMap<>();
                mCharacteristicUserDescriptionMap.put(IRRADIANCE_CHARACTERISTIC, descriptorDataMap);
            }
            descriptorDataMap.remove(index);
            return this;
        }

        /**
         * @see #setIrradianceValidRange(int, int, long, byte[])
         */
        @NonNull
        public Builder<T> setIrradianceValidRange(int index, ValidRange validRange) {
            return setIrradianceValidRange(index, BluetoothGatt.GATT_SUCCESS, 0, validRange.getBytes());
        }

        /**
         * add AIrradiance's Valid Range descriptor
         *
         * @param index        Irradiance index
         * @param responseCode response code, {@link android.bluetooth.BluetoothGatt#GATT_SUCCESS} or etc
         * @param delay        response delay(millis)
         * @param value        data for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> setIrradianceValidRange(int index, int responseCode, long delay, @NonNull byte[] value) {
            Map<Integer, DescriptorData> descriptorDataMap = mValidRangeMap.get(IRRADIANCE_CHARACTERISTIC);
            if (descriptorDataMap == null) {
                descriptorDataMap = new HashMap<>();
                mValidRangeMap.put(IRRADIANCE_CHARACTERISTIC, descriptorDataMap);
            }
            descriptorDataMap.put(index, new DescriptorData(VALID_RANGE_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ, responseCode, delay, value));
            return this;
        }

        /**
         * remove Irradiance's Valid Range descriptor
         *
         * @param index Irradiance index
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> removeIrradianceValidRange(int index) {
            Map<Integer, DescriptorData> descriptorDataMap = mValidRangeMap.get(IRRADIANCE_CHARACTERISTIC);
            if (descriptorDataMap == null) {
                descriptorDataMap = new HashMap<>();
                mValidRangeMap.put(IRRADIANCE_CHARACTERISTIC, descriptorDataMap);
            }
            descriptorDataMap.remove(index);
            return this;
        }

        /**
         * @see #addPollenConcentration(int, int, int, long, byte[])
         */
        @NonNull
        public Builder<T> addPollenConcentration(int index, @NonNull PollenConcentration pollenConcentration) {
            return addPollenConcentration(index, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, BluetoothGattCharacteristic.PERMISSION_READ, 0, pollenConcentration.getBytes());
        }

        /**
         * add Pollen Concentration characteristic
         *
         * @param index        Pollen Concentration index
         * @param property     combination of
         *                     {@link android.bluetooth.BluetoothGattCharacteristic#PROPERTY_READ}
         *                     {@link android.bluetooth.BluetoothGattCharacteristic#PROPERTY_NOTIFY}
         * @param responseCode response code, {@link android.bluetooth.BluetoothGatt#GATT_SUCCESS} or etc
         * @param delay        response delay(millis)
         * @param value        data for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> addPollenConcentration(int index, int property, int responseCode, long delay, @NonNull byte[] value) {
            Map<Integer, CharacteristicData> characteristicDataMap = mEsCharacteristicDataMap.get(POLLEN_CONCENTRATION_CHARACTERISTIC);
            if (characteristicDataMap == null) {
                characteristicDataMap = new HashMap<>();
                mEsCharacteristicDataMap.put(POLLEN_CONCENTRATION_CHARACTERISTIC, characteristicDataMap);
            }
            characteristicDataMap.put(index, new CharacteristicData(POLLEN_CONCENTRATION_CHARACTERISTIC, property, BluetoothGattCharacteristic.PERMISSION_READ, new ArrayList<>(), responseCode, delay, value, 0));
            return this;
        }

        /**
         * remove Pollen Concentration characteristic
         *
         * @param index Pollen Concentration index
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> removePollenConcentration(int index) {
            Map<Integer, CharacteristicData> characteristicDataMap = mEsCharacteristicDataMap.get(POLLEN_CONCENTRATION_CHARACTERISTIC);
            if (characteristicDataMap == null) {
                characteristicDataMap = new HashMap<>();
                mEsCharacteristicDataMap.put(POLLEN_CONCENTRATION_CHARACTERISTIC, characteristicDataMap);
            }
            characteristicDataMap.remove(index);
            return this;
        }

        /**
         * @see #setPollenConcentrationEsMeasurement(int, int, long, byte[])
         */
        @NonNull
        public Builder<T> setPollenConcentrationEsMeasurement(int index, EnvironmentalSensingMeasurement environmentalSensingMeasurement) {
            return setPollenConcentrationEsMeasurement(index, BluetoothGatt.GATT_SUCCESS, 0, environmentalSensingMeasurement.getBytes());
        }

        /**
         * add Pollen Concentration's ES Measurement descriptor
         *
         * @param index        Pollen Concentration index
         * @param responseCode response code, {@link android.bluetooth.BluetoothGatt#GATT_SUCCESS} or etc
         * @param delay        response delay(millis)
         * @param value        data for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> setPollenConcentrationEsMeasurement(int index, int responseCode, long delay, @NonNull byte[] value) {
            Map<Integer, DescriptorData> descriptorDataMap = mEsMeasurementMap.get(POLLEN_CONCENTRATION_CHARACTERISTIC);
            if (descriptorDataMap == null) {
                descriptorDataMap = new HashMap<>();
                mEsMeasurementMap.put(POLLEN_CONCENTRATION_CHARACTERISTIC, descriptorDataMap);
            }
            descriptorDataMap.put(index, new DescriptorData(ENVIRONMENTAL_SENSING_MEASUREMENT_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ, responseCode, delay, value));
            return this;
        }

        /**
         * remove Pollen Concentration's ES Measurement descriptor
         *
         * @param index Pollen Concentration index
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> removePollenConcentrationEsMeasurement(int index) {
            Map<Integer, DescriptorData> descriptorDataMap = mEsMeasurementMap.get(POLLEN_CONCENTRATION_CHARACTERISTIC);
            if (descriptorDataMap == null) {
                descriptorDataMap = new HashMap<>();
                mEsMeasurementMap.put(POLLEN_CONCENTRATION_CHARACTERISTIC, descriptorDataMap);
            }
            descriptorDataMap.remove(index);
            return this;
        }

        /**
         * @see #setPollenConcentrationEsTriggerSetting(int, int, int, int, long, byte[])
         */
        @NonNull
        public Builder<T> setPollenConcentrationEsTriggerSetting(int characteristicIndex, int descriptorIndex, EnvironmentalSensingTriggerSetting environmentalSensingTriggerSetting) {
            return setPollenConcentrationEsTriggerSetting(characteristicIndex, descriptorIndex, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, BluetoothGatt.GATT_SUCCESS, 0, environmentalSensingTriggerSetting.getBytes());
        }

        /**
         * add Pollen Concentration's ES Trigger Setting descriptor
         *
         * @param characteristicIndex Pollen Concentration index
         * @param descriptorIndex     Environmental Sensing Trigger Setting index(0 - 2)
         * @param permission          combination of
         *                            {@link android.bluetooth.BluetoothGattDescriptor#PERMISSION_READ}
         *                            {@link android.bluetooth.BluetoothGattDescriptor#PERMISSION_WRITE}
         * @param responseCode        response code, {@link android.bluetooth.BluetoothGatt#GATT_SUCCESS} or etc
         * @param delay               response delay(millis)
         * @param value               data for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> setPollenConcentrationEsTriggerSetting(int characteristicIndex, int descriptorIndex, int permission, int responseCode, long delay, @NonNull byte[] value) {
            Map<Integer, Map<Integer, DescriptorData>> characteristicDataMap = mEsTriggerSettingMap.get(POLLEN_CONCENTRATION_CHARACTERISTIC);
            if (characteristicDataMap == null) {
                characteristicDataMap = new HashMap<>();
                mEsTriggerSettingMap.put(POLLEN_CONCENTRATION_CHARACTERISTIC, characteristicDataMap);
            }
            Map<Integer, DescriptorData> descriptorDataMap = characteristicDataMap.get(characteristicIndex);
            if (descriptorDataMap == null) {
                descriptorDataMap = new HashMap<>();
                characteristicDataMap.put(characteristicIndex, descriptorDataMap);
            }
            descriptorDataMap.put(descriptorIndex, new DescriptorData(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR, permission, responseCode, delay, value));
            return this;
        }

        /**
         * remove Pollen Concentration's ES Trigger Setting descriptor
         *
         * @param characteristicIndex Pollen Concentration index
         * @param descriptorIndex     Environmental Sensing Trigger Setting index(0 - 2)
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> removePollenConcentrationEsTriggerSetting(int characteristicIndex, int descriptorIndex) {
            Map<Integer, Map<Integer, DescriptorData>> characteristicDataMap = mEsTriggerSettingMap.get(POLLEN_CONCENTRATION_CHARACTERISTIC);
            if (characteristicDataMap == null) {
                characteristicDataMap = new HashMap<>();
                mEsTriggerSettingMap.put(POLLEN_CONCENTRATION_CHARACTERISTIC, characteristicDataMap);
            }
            Map<Integer, DescriptorData> descriptorDataMap = characteristicDataMap.get(characteristicIndex);
            if (descriptorDataMap == null) {
                descriptorDataMap = new HashMap<>();
                characteristicDataMap.put(characteristicIndex, descriptorDataMap);
            }
            descriptorDataMap.remove(descriptorIndex);
            return this;
        }

        /**
         * @see #setPollenConcentrationEsConfiguration(int, int, int, long, byte[])
         */
        @NonNull
        public Builder<T> setPollenConcentrationEsConfiguration(int index, EnvironmentalSensingConfiguration environmentalSensingConfiguration) {
            return setPollenConcentrationEsConfiguration(index, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, BluetoothGatt.GATT_SUCCESS, 0, environmentalSensingConfiguration.getBytes());
        }

        /**
         * add Pollen Concentration's ES Configuration descriptor
         *
         * @param index        Pollen Concentration index
         * @param permission   combination of
         *                     {@link android.bluetooth.BluetoothGattDescriptor#PERMISSION_READ}
         *                     {@link android.bluetooth.BluetoothGattDescriptor#PERMISSION_WRITE}
         * @param responseCode response code, {@link android.bluetooth.BluetoothGatt#GATT_SUCCESS} or etc
         * @param delay        response delay(millis)
         * @param value        data for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> setPollenConcentrationEsConfiguration(int index, int permission, int responseCode, long delay, @NonNull byte[] value) {
            Map<Integer, DescriptorData> descriptorDataMap = mEsConfigurationMap.get(POLLEN_CONCENTRATION_CHARACTERISTIC);
            if (descriptorDataMap == null) {
                descriptorDataMap = new HashMap<>();
                mEsConfigurationMap.put(POLLEN_CONCENTRATION_CHARACTERISTIC, descriptorDataMap);
            }
            descriptorDataMap.put(index, new DescriptorData(ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR, permission, responseCode, delay, value));
            return this;
        }

        /**
         * remove Pollen Concentration's ES Configuration descriptor
         *
         * @param index Pollen Concentration index
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> removePollenConcentrationEsConfiguration(int index) {
            Map<Integer, DescriptorData> descriptorDataMap = mEsConfigurationMap.get(POLLEN_CONCENTRATION_CHARACTERISTIC);
            if (descriptorDataMap == null) {
                descriptorDataMap = new HashMap<>();
                mEsConfigurationMap.put(POLLEN_CONCENTRATION_CHARACTERISTIC, descriptorDataMap);
            }
            descriptorDataMap.remove(index);
            return this;
        }

        /**
         * @see #setPollenConcentrationCharacteristicUserDescription(int, int, long, byte[])
         */
        @NonNull
        public Builder<T> setPollenConcentrationCharacteristicUserDescription(int index, CharacteristicUserDescription characteristicUserDescription) {
            return setPollenConcentrationCharacteristicUserDescription(index, BluetoothGatt.GATT_SUCCESS, 0, characteristicUserDescription.getBytes());
        }

        /**
         * add Pollen Concentration's Characteristic User Description descriptor
         *
         * @param index        Pollen Concentration index
         * @param responseCode response code, {@link android.bluetooth.BluetoothGatt#GATT_SUCCESS} or etc
         * @param delay        response delay(millis)
         * @param value        data for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> setPollenConcentrationCharacteristicUserDescription(int index, int responseCode, long delay, @NonNull byte[] value) {
            Map<Integer, DescriptorData> descriptorDataMap = mCharacteristicUserDescriptionMap.get(POLLEN_CONCENTRATION_CHARACTERISTIC);
            if (descriptorDataMap == null) {
                descriptorDataMap = new HashMap<>();
                mCharacteristicUserDescriptionMap.put(POLLEN_CONCENTRATION_CHARACTERISTIC, descriptorDataMap);
            }
            descriptorDataMap.put(index, new DescriptorData(CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ, responseCode, delay, value));
            return this;
        }

        /**
         * remove APollen Concentration's Characteristic User Description descriptor
         *
         * @param index Pollen Concentration index
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> removePollenConcentrationCharacteristicUserDescription(int index) {
            Map<Integer, DescriptorData> descriptorDataMap = mCharacteristicUserDescriptionMap.get(POLLEN_CONCENTRATION_CHARACTERISTIC);
            if (descriptorDataMap == null) {
                descriptorDataMap = new HashMap<>();
                mCharacteristicUserDescriptionMap.put(POLLEN_CONCENTRATION_CHARACTERISTIC, descriptorDataMap);
            }
            descriptorDataMap.remove(index);
            return this;
        }

        /**
         * @see #setPollenConcentrationValidRange(int, int, long, byte[])
         */
        @NonNull
        public Builder<T> setPollenConcentrationValidRange(int index, ValidRange validRange) {
            return setPollenConcentrationValidRange(index, BluetoothGatt.GATT_SUCCESS, 0, validRange.getBytes());
        }

        /**
         * add Pollen Concentration's Valid Range descriptor
         *
         * @param index        Pollen Concentration index
         * @param responseCode response code, {@link android.bluetooth.BluetoothGatt#GATT_SUCCESS} or etc
         * @param delay        response delay(millis)
         * @param value        data for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> setPollenConcentrationValidRange(int index, int responseCode, long delay, @NonNull byte[] value) {
            Map<Integer, DescriptorData> descriptorDataMap = mValidRangeMap.get(POLLEN_CONCENTRATION_CHARACTERISTIC);
            if (descriptorDataMap == null) {
                descriptorDataMap = new HashMap<>();
                mValidRangeMap.put(POLLEN_CONCENTRATION_CHARACTERISTIC, descriptorDataMap);
            }
            descriptorDataMap.put(index, new DescriptorData(VALID_RANGE_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ, responseCode, delay, value));
            return this;
        }

        /**
         * remove Pollen Concentration's Valid Range descriptor
         *
         * @param index Pollen Concentration index
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> removePollenConcentrationValidRange(int index) {
            Map<Integer, DescriptorData> descriptorDataMap = mValidRangeMap.get(POLLEN_CONCENTRATION_CHARACTERISTIC);
            if (descriptorDataMap == null) {
                descriptorDataMap = new HashMap<>();
                mValidRangeMap.put(POLLEN_CONCENTRATION_CHARACTERISTIC, descriptorDataMap);
            }
            descriptorDataMap.remove(index);
            return this;
        }

        /**
         * @see #addRainfall(int, int, int, long, byte[])
         */
        @NonNull
        public Builder<T> addRainfall(int index, @NonNull Rainfall rainfall) {
            return addRainfall(index, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, BluetoothGattCharacteristic.PERMISSION_READ, 0, rainfall.getBytes());
        }

        /**
         * add Rainfall characteristic
         *
         * @param index        Rainfall index
         * @param property     combination of
         *                     {@link android.bluetooth.BluetoothGattCharacteristic#PROPERTY_READ}
         *                     {@link android.bluetooth.BluetoothGattCharacteristic#PROPERTY_NOTIFY}
         * @param responseCode response code, {@link android.bluetooth.BluetoothGatt#GATT_SUCCESS} or etc
         * @param delay        response delay(millis)
         * @param value        data for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> addRainfall(int index, int property, int responseCode, long delay, @NonNull byte[] value) {
            Map<Integer, CharacteristicData> characteristicDataMap = mEsCharacteristicDataMap.get(RAINFALL_CHARACTERISTIC);
            if (characteristicDataMap == null) {
                characteristicDataMap = new HashMap<>();
                mEsCharacteristicDataMap.put(RAINFALL_CHARACTERISTIC, characteristicDataMap);
            }
            characteristicDataMap.put(index, new CharacteristicData(RAINFALL_CHARACTERISTIC, property, BluetoothGattCharacteristic.PERMISSION_READ, new ArrayList<>(), responseCode, delay, value, 0));
            return this;
        }

        /**
         * remove Rainfall characteristic
         *
         * @param index Rainfall index
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> removeRainfall(int index) {
            Map<Integer, CharacteristicData> characteristicDataMap = mEsCharacteristicDataMap.get(RAINFALL_CHARACTERISTIC);
            if (characteristicDataMap == null) {
                characteristicDataMap = new HashMap<>();
                mEsCharacteristicDataMap.put(RAINFALL_CHARACTERISTIC, characteristicDataMap);
            }
            characteristicDataMap.remove(index);
            return this;
        }

        /**
         * @see #setRainfallEsMeasurement(int, int, long, byte[])
         */
        @NonNull
        public Builder<T> setRainfallEsMeasurement(int index, EnvironmentalSensingMeasurement environmentalSensingMeasurement) {
            return setRainfallEsMeasurement(index, BluetoothGatt.GATT_SUCCESS, 0, environmentalSensingMeasurement.getBytes());
        }

        /**
         * add Rainfall's ES Measurement descriptor
         *
         * @param index        Rainfall index
         * @param responseCode response code, {@link android.bluetooth.BluetoothGatt#GATT_SUCCESS} or etc
         * @param delay        response delay(millis)
         * @param value        data for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> setRainfallEsMeasurement(int index, int responseCode, long delay, @NonNull byte[] value) {
            Map<Integer, DescriptorData> descriptorDataMap = mEsMeasurementMap.get(RAINFALL_CHARACTERISTIC);
            if (descriptorDataMap == null) {
                descriptorDataMap = new HashMap<>();
                mEsMeasurementMap.put(RAINFALL_CHARACTERISTIC, descriptorDataMap);
            }
            descriptorDataMap.put(index, new DescriptorData(ENVIRONMENTAL_SENSING_MEASUREMENT_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ, responseCode, delay, value));
            return this;
        }

        /**
         * remove Rainfall's ES Measurement descriptor
         *
         * @param index Rainfall index
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> removeRainfallEsMeasurement(int index) {
            Map<Integer, DescriptorData> descriptorDataMap = mEsMeasurementMap.get(RAINFALL_CHARACTERISTIC);
            if (descriptorDataMap == null) {
                descriptorDataMap = new HashMap<>();
                mEsMeasurementMap.put(RAINFALL_CHARACTERISTIC, descriptorDataMap);
            }
            descriptorDataMap.remove(index);
            return this;
        }

        /**
         * @see #setRainfallEsTriggerSetting(int, int, int, int, long, byte[])
         */
        @NonNull
        public Builder<T> setRainfallEsTriggerSetting(int characteristicIndex, int descriptorIndex, EnvironmentalSensingTriggerSetting environmentalSensingTriggerSetting) {
            return setRainfallEsTriggerSetting(characteristicIndex, descriptorIndex, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, BluetoothGatt.GATT_SUCCESS, 0, environmentalSensingTriggerSetting.getBytes());
        }

        /**
         * add Rainfall's ES Trigger Setting descriptor
         *
         * @param characteristicIndex Rainfall index
         * @param descriptorIndex     Environmental Sensing Trigger Setting index(0 - 2)
         * @param permission          combination of
         *                            {@link android.bluetooth.BluetoothGattDescriptor#PERMISSION_READ}
         *                            {@link android.bluetooth.BluetoothGattDescriptor#PERMISSION_WRITE}
         * @param responseCode        response code, {@link android.bluetooth.BluetoothGatt#GATT_SUCCESS} or etc
         * @param delay               response delay(millis)
         * @param value               data for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> setRainfallEsTriggerSetting(int characteristicIndex, int descriptorIndex, int permission, int responseCode, long delay, @NonNull byte[] value) {
            Map<Integer, Map<Integer, DescriptorData>> characteristicDataMap = mEsTriggerSettingMap.get(RAINFALL_CHARACTERISTIC);
            if (characteristicDataMap == null) {
                characteristicDataMap = new HashMap<>();
                mEsTriggerSettingMap.put(RAINFALL_CHARACTERISTIC, characteristicDataMap);
            }
            Map<Integer, DescriptorData> descriptorDataMap = characteristicDataMap.get(characteristicIndex);
            if (descriptorDataMap == null) {
                descriptorDataMap = new HashMap<>();
                characteristicDataMap.put(characteristicIndex, descriptorDataMap);
            }
            descriptorDataMap.put(descriptorIndex, new DescriptorData(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR, permission, responseCode, delay, value));
            return this;
        }

        /**
         * remove Rainfall's ES Trigger Setting descriptor
         *
         * @param characteristicIndex Rainfall index
         * @param descriptorIndex     Environmental Sensing Trigger Setting index(0 - 2)
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> removeRainfallEsTriggerSetting(int characteristicIndex, int descriptorIndex) {
            Map<Integer, Map<Integer, DescriptorData>> characteristicDataMap = mEsTriggerSettingMap.get(RAINFALL_CHARACTERISTIC);
            if (characteristicDataMap == null) {
                characteristicDataMap = new HashMap<>();
                mEsTriggerSettingMap.put(RAINFALL_CHARACTERISTIC, characteristicDataMap);
            }
            Map<Integer, DescriptorData> descriptorDataMap = characteristicDataMap.get(characteristicIndex);
            if (descriptorDataMap == null) {
                descriptorDataMap = new HashMap<>();
                characteristicDataMap.put(characteristicIndex, descriptorDataMap);
            }
            descriptorDataMap.remove(descriptorIndex);
            return this;
        }

        /**
         * @see #setRainfallEsConfiguration(int, int, int, long, byte[])
         */
        @NonNull
        public Builder<T> setRainfallEsConfiguration(int index, EnvironmentalSensingConfiguration environmentalSensingConfiguration) {
            return setRainfallEsConfiguration(index, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, BluetoothGatt.GATT_SUCCESS, 0, environmentalSensingConfiguration.getBytes());
        }

        /**
         * add Rainfall's ES Configuration descriptor
         *
         * @param index        Rainfall index
         * @param permission   combination of
         *                     {@link android.bluetooth.BluetoothGattDescriptor#PERMISSION_READ}
         *                     {@link android.bluetooth.BluetoothGattDescriptor#PERMISSION_WRITE}
         * @param responseCode response code, {@link android.bluetooth.BluetoothGatt#GATT_SUCCESS} or etc
         * @param delay        response delay(millis)
         * @param value        data for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> setRainfallEsConfiguration(int index, int permission, int responseCode, long delay, @NonNull byte[] value) {
            Map<Integer, DescriptorData> descriptorDataMap = mEsConfigurationMap.get(RAINFALL_CHARACTERISTIC);
            if (descriptorDataMap == null) {
                descriptorDataMap = new HashMap<>();
                mEsConfigurationMap.put(RAINFALL_CHARACTERISTIC, descriptorDataMap);
            }
            descriptorDataMap.put(index, new DescriptorData(ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR, permission, responseCode, delay, value));
            return this;
        }

        /**
         * remove Rainfall's ES Configuration descriptor
         *
         * @param index Rainfall index
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> removeRainfallEsConfiguration(int index) {
            Map<Integer, DescriptorData> descriptorDataMap = mEsConfigurationMap.get(RAINFALL_CHARACTERISTIC);
            if (descriptorDataMap == null) {
                descriptorDataMap = new HashMap<>();
                mEsConfigurationMap.put(RAINFALL_CHARACTERISTIC, descriptorDataMap);
            }
            descriptorDataMap.remove(index);
            return this;
        }

        /**
         * @see #setRainfallCharacteristicUserDescription(int, int, long, byte[])
         */
        @NonNull
        public Builder<T> setRainfallCharacteristicUserDescription(int index, CharacteristicUserDescription characteristicUserDescription) {
            return setRainfallCharacteristicUserDescription(index, BluetoothGatt.GATT_SUCCESS, 0, characteristicUserDescription.getBytes());
        }

        /**
         * add Rainfall's Characteristic User Description descriptor
         *
         * @param index        Rainfall index
         * @param responseCode response code, {@link android.bluetooth.BluetoothGatt#GATT_SUCCESS} or etc
         * @param delay        response delay(millis)
         * @param value        data for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> setRainfallCharacteristicUserDescription(int index, int responseCode, long delay, @NonNull byte[] value) {
            Map<Integer, DescriptorData> descriptorDataMap = mCharacteristicUserDescriptionMap.get(RAINFALL_CHARACTERISTIC);
            if (descriptorDataMap == null) {
                descriptorDataMap = new HashMap<>();
                mCharacteristicUserDescriptionMap.put(RAINFALL_CHARACTERISTIC, descriptorDataMap);
            }
            descriptorDataMap.put(index, new DescriptorData(CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ, responseCode, delay, value));
            return this;
        }

        /**
         * remove Rainfall's Characteristic User Description descriptor
         *
         * @param index Rainfall index
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> removeRainfallCharacteristicUserDescription(int index) {
            Map<Integer, DescriptorData> descriptorDataMap = mCharacteristicUserDescriptionMap.get(RAINFALL_CHARACTERISTIC);
            if (descriptorDataMap == null) {
                descriptorDataMap = new HashMap<>();
                mCharacteristicUserDescriptionMap.put(RAINFALL_CHARACTERISTIC, descriptorDataMap);
            }
            descriptorDataMap.remove(index);
            return this;
        }

        /**
         * @see #setRainfallValidRange(int, int, long, byte[])
         */
        @NonNull
        public Builder<T> setRainfallValidRange(int index, ValidRange validRange) {
            return setRainfallValidRange(index, BluetoothGatt.GATT_SUCCESS, 0, validRange.getBytes());
        }

        /**
         * add Rainfall's Valid Range descriptor
         *
         * @param index        Rainfall index
         * @param responseCode response code, {@link android.bluetooth.BluetoothGatt#GATT_SUCCESS} or etc
         * @param delay        response delay(millis)
         * @param value        data for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> setRainfallValidRange(int index, int responseCode, long delay, @NonNull byte[] value) {
            Map<Integer, DescriptorData> descriptorDataMap = mValidRangeMap.get(RAINFALL_CHARACTERISTIC);
            if (descriptorDataMap == null) {
                descriptorDataMap = new HashMap<>();
                mValidRangeMap.put(RAINFALL_CHARACTERISTIC, descriptorDataMap);
            }
            descriptorDataMap.put(index, new DescriptorData(VALID_RANGE_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ, responseCode, delay, value));
            return this;
        }

        /**
         * remove Rainfall's Valid Range descriptor
         *
         * @param index Rainfall index
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> removeRainfallValidRange(int index) {
            Map<Integer, DescriptorData> descriptorDataMap = mValidRangeMap.get(RAINFALL_CHARACTERISTIC);
            if (descriptorDataMap == null) {
                descriptorDataMap = new HashMap<>();
                mValidRangeMap.put(RAINFALL_CHARACTERISTIC, descriptorDataMap);
            }
            descriptorDataMap.remove(index);
            return this;
        }

        /**
         * @see #addPressure(int, int, int, long, byte[])
         */
        @NonNull
        public Builder<T> addPressure(int index, @NonNull Pressure pressure) {
            return addPressure(index, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, BluetoothGattCharacteristic.PERMISSION_READ, 0, pressure.getBytes());
        }

        /**
         * add Pressure characteristic
         *
         * @param index        Pressure index
         * @param property     combination of
         *                     {@link android.bluetooth.BluetoothGattCharacteristic#PROPERTY_READ}
         *                     {@link android.bluetooth.BluetoothGattCharacteristic#PROPERTY_NOTIFY}
         * @param responseCode response code, {@link android.bluetooth.BluetoothGatt#GATT_SUCCESS} or etc
         * @param delay        response delay(millis)
         * @param value        data for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> addPressure(int index, int property, int responseCode, long delay, @NonNull byte[] value) {
            Map<Integer, CharacteristicData> characteristicDataMap = mEsCharacteristicDataMap.get(PRESSURE_CHARACTERISTIC);
            if (characteristicDataMap == null) {
                characteristicDataMap = new HashMap<>();
                mEsCharacteristicDataMap.put(PRESSURE_CHARACTERISTIC, characteristicDataMap);
            }
            characteristicDataMap.put(index, new CharacteristicData(PRESSURE_CHARACTERISTIC, property, BluetoothGattCharacteristic.PERMISSION_READ, new ArrayList<>(), responseCode, delay, value, 0));
            return this;
        }

        /**
         * remove Pressure characteristic
         *
         * @param index Pressure index
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> removePressure(int index) {
            Map<Integer, CharacteristicData> characteristicDataMap = mEsCharacteristicDataMap.get(PRESSURE_CHARACTERISTIC);
            if (characteristicDataMap == null) {
                characteristicDataMap = new HashMap<>();
                mEsCharacteristicDataMap.put(PRESSURE_CHARACTERISTIC, characteristicDataMap);
            }
            characteristicDataMap.remove(index);
            return this;
        }

        /**
         * @see #setPressureEsMeasurement(int, int, long, byte[])
         */
        @NonNull
        public Builder<T> setPressureEsMeasurement(int index, EnvironmentalSensingMeasurement environmentalSensingMeasurement) {
            return setPressureEsMeasurement(index, BluetoothGatt.GATT_SUCCESS, 0, environmentalSensingMeasurement.getBytes());
        }

        /**
         * add Pressure's ES Measurement descriptor
         *
         * @param index        Pressure index
         * @param responseCode response code, {@link android.bluetooth.BluetoothGatt#GATT_SUCCESS} or etc
         * @param delay        response delay(millis)
         * @param value        data for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> setPressureEsMeasurement(int index, int responseCode, long delay, @NonNull byte[] value) {
            Map<Integer, DescriptorData> descriptorDataMap = mEsMeasurementMap.get(PRESSURE_CHARACTERISTIC);
            if (descriptorDataMap == null) {
                descriptorDataMap = new HashMap<>();
                mEsMeasurementMap.put(PRESSURE_CHARACTERISTIC, descriptorDataMap);
            }
            descriptorDataMap.put(index, new DescriptorData(ENVIRONMENTAL_SENSING_MEASUREMENT_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ, responseCode, delay, value));
            return this;
        }

        /**
         * remove Pressure's ES Measurement descriptor
         *
         * @param index Pressure index
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> removePressureEsMeasurement(int index) {
            Map<Integer, DescriptorData> descriptorDataMap = mEsMeasurementMap.get(PRESSURE_CHARACTERISTIC);
            if (descriptorDataMap == null) {
                descriptorDataMap = new HashMap<>();
                mEsMeasurementMap.put(PRESSURE_CHARACTERISTIC, descriptorDataMap);
            }
            descriptorDataMap.remove(index);
            return this;
        }

        /**
         * @see #setPressureEsTriggerSetting(int, int, int, int, long, byte[])
         */
        @NonNull
        public Builder<T> setPressureEsTriggerSetting(int characteristicIndex, int descriptorIndex, EnvironmentalSensingTriggerSetting environmentalSensingTriggerSetting) {
            return setPressureEsTriggerSetting(characteristicIndex, descriptorIndex, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, BluetoothGatt.GATT_SUCCESS, 0, environmentalSensingTriggerSetting.getBytes());
        }

        /**
         * add Pressure's ES Trigger Setting descriptor
         *
         * @param characteristicIndex Pressure index
         * @param descriptorIndex     Environmental Sensing Trigger Setting index(0 - 2)
         * @param permission          combination of
         *                            {@link android.bluetooth.BluetoothGattDescriptor#PERMISSION_READ}
         *                            {@link android.bluetooth.BluetoothGattDescriptor#PERMISSION_WRITE}
         * @param responseCode        response code, {@link android.bluetooth.BluetoothGatt#GATT_SUCCESS} or etc
         * @param delay               response delay(millis)
         * @param value               data for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> setPressureEsTriggerSetting(int characteristicIndex, int descriptorIndex, int permission, int responseCode, long delay, @NonNull byte[] value) {
            Map<Integer, Map<Integer, DescriptorData>> characteristicDataMap = mEsTriggerSettingMap.get(PRESSURE_CHARACTERISTIC);
            if (characteristicDataMap == null) {
                characteristicDataMap = new HashMap<>();
                mEsTriggerSettingMap.put(PRESSURE_CHARACTERISTIC, characteristicDataMap);
            }
            Map<Integer, DescriptorData> descriptorDataMap = characteristicDataMap.get(characteristicIndex);
            if (descriptorDataMap == null) {
                descriptorDataMap = new HashMap<>();
                characteristicDataMap.put(characteristicIndex, descriptorDataMap);
            }
            descriptorDataMap.put(descriptorIndex, new DescriptorData(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR, permission, responseCode, delay, value));
            return this;
        }

        /**
         * remove Pressure's ES Trigger Setting descriptor
         *
         * @param characteristicIndex Pressure index
         * @param descriptorIndex     Environmental Sensing Trigger Setting index(0 - 2)
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> removePressureEsTriggerSetting(int characteristicIndex, int descriptorIndex) {
            Map<Integer, Map<Integer, DescriptorData>> characteristicDataMap = mEsTriggerSettingMap.get(PRESSURE_CHARACTERISTIC);
            if (characteristicDataMap == null) {
                characteristicDataMap = new HashMap<>();
                mEsTriggerSettingMap.put(PRESSURE_CHARACTERISTIC, characteristicDataMap);
            }
            Map<Integer, DescriptorData> descriptorDataMap = characteristicDataMap.get(characteristicIndex);
            if (descriptorDataMap == null) {
                descriptorDataMap = new HashMap<>();
                characteristicDataMap.put(characteristicIndex, descriptorDataMap);
            }
            descriptorDataMap.remove(descriptorIndex);
            return this;
        }

        /**
         * @see #setPressureEsConfiguration(int, int, int, long, byte[])
         */
        @NonNull
        public Builder<T> setPressureEsConfiguration(int index, EnvironmentalSensingConfiguration environmentalSensingConfiguration) {
            return setPressureEsConfiguration(index, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, BluetoothGatt.GATT_SUCCESS, 0, environmentalSensingConfiguration.getBytes());
        }

        /**
         * add Pressure's ES Configuration descriptor
         *
         * @param index        Pressure index
         * @param permission   combination of
         *                     {@link android.bluetooth.BluetoothGattDescriptor#PERMISSION_READ}
         *                     {@link android.bluetooth.BluetoothGattDescriptor#PERMISSION_WRITE}
         * @param responseCode response code, {@link android.bluetooth.BluetoothGatt#GATT_SUCCESS} or etc
         * @param delay        response delay(millis)
         * @param value        data for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> setPressureEsConfiguration(int index, int permission, int responseCode, long delay, @NonNull byte[] value) {
            Map<Integer, DescriptorData> descriptorDataMap = mEsConfigurationMap.get(PRESSURE_CHARACTERISTIC);
            if (descriptorDataMap == null) {
                descriptorDataMap = new HashMap<>();
                mEsConfigurationMap.put(PRESSURE_CHARACTERISTIC, descriptorDataMap);
            }
            descriptorDataMap.put(index, new DescriptorData(ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR, permission, responseCode, delay, value));
            return this;
        }

        /**
         * remove Pressure's ES Configuration descriptor
         *
         * @param index Pressure index
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> removePressureEsConfiguration(int index) {
            Map<Integer, DescriptorData> descriptorDataMap = mEsConfigurationMap.get(PRESSURE_CHARACTERISTIC);
            if (descriptorDataMap == null) {
                descriptorDataMap = new HashMap<>();
                mEsConfigurationMap.put(PRESSURE_CHARACTERISTIC, descriptorDataMap);
            }
            descriptorDataMap.remove(index);
            return this;
        }

        /**
         * @see #setPressureCharacteristicUserDescription(int, int, long, byte[])
         */
        @NonNull
        public Builder<T> setPressureCharacteristicUserDescription(int index, CharacteristicUserDescription characteristicUserDescription) {
            return setPressureCharacteristicUserDescription(index, BluetoothGatt.GATT_SUCCESS, 0, characteristicUserDescription.getBytes());
        }

        /**
         * add Pressure's Characteristic User Description descriptor
         *
         * @param index        Pressure index
         * @param responseCode response code, {@link android.bluetooth.BluetoothGatt#GATT_SUCCESS} or etc
         * @param delay        response delay(millis)
         * @param value        data for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> setPressureCharacteristicUserDescription(int index, int responseCode, long delay, @NonNull byte[] value) {
            Map<Integer, DescriptorData> descriptorDataMap = mCharacteristicUserDescriptionMap.get(PRESSURE_CHARACTERISTIC);
            if (descriptorDataMap == null) {
                descriptorDataMap = new HashMap<>();
                mCharacteristicUserDescriptionMap.put(PRESSURE_CHARACTERISTIC, descriptorDataMap);
            }
            descriptorDataMap.put(index, new DescriptorData(CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ, responseCode, delay, value));
            return this;
        }

        /**
         * remove Pressure's Characteristic User Description descriptor
         *
         * @param index Pressure index
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> removePressureCharacteristicUserDescription(int index) {
            Map<Integer, DescriptorData> descriptorDataMap = mCharacteristicUserDescriptionMap.get(PRESSURE_CHARACTERISTIC);
            if (descriptorDataMap == null) {
                descriptorDataMap = new HashMap<>();
                mCharacteristicUserDescriptionMap.put(PRESSURE_CHARACTERISTIC, descriptorDataMap);
            }
            descriptorDataMap.remove(index);
            return this;
        }

        /**
         * @see #setPressureValidRange(int, int, long, byte[])
         */
        @NonNull
        public Builder<T> setPressureValidRange(int index, ValidRange validRange) {
            return setPressureValidRange(index, BluetoothGatt.GATT_SUCCESS, 0, validRange.getBytes());
        }

        /**
         * add Pressure's Valid Range descriptor
         *
         * @param index        Pressure index
         * @param responseCode response code, {@link android.bluetooth.BluetoothGatt#GATT_SUCCESS} or etc
         * @param delay        response delay(millis)
         * @param value        data for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> setPressureValidRange(int index, int responseCode, long delay, @NonNull byte[] value) {
            Map<Integer, DescriptorData> descriptorDataMap = mValidRangeMap.get(PRESSURE_CHARACTERISTIC);
            if (descriptorDataMap == null) {
                descriptorDataMap = new HashMap<>();
                mValidRangeMap.put(PRESSURE_CHARACTERISTIC, descriptorDataMap);
            }
            descriptorDataMap.put(index, new DescriptorData(VALID_RANGE_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ, responseCode, delay, value));
            return this;
        }

        /**
         * remove Pressure's Valid Range descriptor
         *
         * @param index Pressure index
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> removePressureValidRange(int index) {
            Map<Integer, DescriptorData> descriptorDataMap = mValidRangeMap.get(PRESSURE_CHARACTERISTIC);
            if (descriptorDataMap == null) {
                descriptorDataMap = new HashMap<>();
                mValidRangeMap.put(PRESSURE_CHARACTERISTIC, descriptorDataMap);
            }
            descriptorDataMap.remove(index);
            return this;
        }

        /**
         * @see #addTemperature(int, int, int, long, byte[])
         */
        @NonNull
        public Builder<T> addTemperature(int index, @NonNull Temperature temperature) {
            return addTemperature(index, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, BluetoothGattCharacteristic.PERMISSION_READ, 0, temperature.getBytes());
        }

        /**
         * add Temperature characteristic
         *
         * @param index        Temperature index
         * @param property     combination of
         *                     {@link android.bluetooth.BluetoothGattCharacteristic#PROPERTY_READ}
         *                     {@link android.bluetooth.BluetoothGattCharacteristic#PROPERTY_NOTIFY}
         * @param responseCode response code, {@link android.bluetooth.BluetoothGatt#GATT_SUCCESS} or etc
         * @param delay        response delay(millis)
         * @param value        data for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> addTemperature(int index, int property, int responseCode, long delay, @NonNull byte[] value) {
            Map<Integer, CharacteristicData> characteristicDataMap = mEsCharacteristicDataMap.get(TEMPERATURE_CHARACTERISTIC);
            if (characteristicDataMap == null) {
                characteristicDataMap = new HashMap<>();
                mEsCharacteristicDataMap.put(TEMPERATURE_CHARACTERISTIC, characteristicDataMap);
            }
            characteristicDataMap.put(index, new CharacteristicData(TEMPERATURE_CHARACTERISTIC, property, BluetoothGattCharacteristic.PERMISSION_READ, new ArrayList<>(), responseCode, delay, value, 0));
            return this;
        }

        /**
         * remove Temperature characteristic
         *
         * @param index Temperature index
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> removeTemperature(int index) {
            Map<Integer, CharacteristicData> characteristicDataMap = mEsCharacteristicDataMap.get(TEMPERATURE_CHARACTERISTIC);
            if (characteristicDataMap == null) {
                characteristicDataMap = new HashMap<>();
                mEsCharacteristicDataMap.put(TEMPERATURE_CHARACTERISTIC, characteristicDataMap);
            }
            characteristicDataMap.remove(index);
            return this;
        }

        /**
         * @see #setTemperatureEsMeasurement(int, int, long, byte[])
         */
        @NonNull
        public Builder<T> setTemperatureEsMeasurement(int index, EnvironmentalSensingMeasurement environmentalSensingMeasurement) {
            return setTemperatureEsMeasurement(index, BluetoothGatt.GATT_SUCCESS, 0, environmentalSensingMeasurement.getBytes());
        }

        /**
         * add Temperature's ES Measurement descriptor
         *
         * @param index        Temperature index
         * @param responseCode response code, {@link android.bluetooth.BluetoothGatt#GATT_SUCCESS} or etc
         * @param delay        response delay(millis)
         * @param value        data for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> setTemperatureEsMeasurement(int index, int responseCode, long delay, @NonNull byte[] value) {
            Map<Integer, DescriptorData> descriptorDataMap = mEsMeasurementMap.get(TEMPERATURE_CHARACTERISTIC);
            if (descriptorDataMap == null) {
                descriptorDataMap = new HashMap<>();
                mEsMeasurementMap.put(TEMPERATURE_CHARACTERISTIC, descriptorDataMap);
            }
            descriptorDataMap.put(index, new DescriptorData(ENVIRONMENTAL_SENSING_MEASUREMENT_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ, responseCode, delay, value));
            return this;
        }

        /**
         * remove Temperature's ES Measurement descriptor
         *
         * @param index Temperature index
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> removeTemperatureEsMeasurement(int index) {
            Map<Integer, DescriptorData> descriptorDataMap = mEsMeasurementMap.get(TEMPERATURE_CHARACTERISTIC);
            if (descriptorDataMap == null) {
                descriptorDataMap = new HashMap<>();
                mEsMeasurementMap.put(TEMPERATURE_CHARACTERISTIC, descriptorDataMap);
            }
            descriptorDataMap.remove(index);
            return this;
        }

        /**
         * @see #setTemperatureEsTriggerSetting(int, int, int, int, long, byte[])
         */
        @NonNull
        public Builder<T> setTemperatureEsTriggerSetting(int characteristicIndex, int descriptorIndex, EnvironmentalSensingTriggerSetting environmentalSensingTriggerSetting) {
            return setTemperatureEsTriggerSetting(characteristicIndex, descriptorIndex, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, BluetoothGatt.GATT_SUCCESS, 0, environmentalSensingTriggerSetting.getBytes());
        }

        /**
         * add Temperature's ES Trigger Setting descriptor
         *
         * @param characteristicIndex Temperature index
         * @param descriptorIndex     Environmental Sensing Trigger Setting index(0 - 2)
         * @param permission          combination of
         *                            {@link android.bluetooth.BluetoothGattDescriptor#PERMISSION_READ}
         *                            {@link android.bluetooth.BluetoothGattDescriptor#PERMISSION_WRITE}
         * @param responseCode        response code, {@link android.bluetooth.BluetoothGatt#GATT_SUCCESS} or etc
         * @param delay               response delay(millis)
         * @param value               data for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> setTemperatureEsTriggerSetting(int characteristicIndex, int descriptorIndex, int permission, int responseCode, long delay, @NonNull byte[] value) {
            Map<Integer, Map<Integer, DescriptorData>> characteristicDataMap = mEsTriggerSettingMap.get(TEMPERATURE_CHARACTERISTIC);
            if (characteristicDataMap == null) {
                characteristicDataMap = new HashMap<>();
                mEsTriggerSettingMap.put(TEMPERATURE_CHARACTERISTIC, characteristicDataMap);
            }
            Map<Integer, DescriptorData> descriptorDataMap = characteristicDataMap.get(characteristicIndex);
            if (descriptorDataMap == null) {
                descriptorDataMap = new HashMap<>();
                characteristicDataMap.put(characteristicIndex, descriptorDataMap);
            }
            descriptorDataMap.put(descriptorIndex, new DescriptorData(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR, permission, responseCode, delay, value));
            return this;
        }

        /**
         * remove Temperature's ES Trigger Setting descriptor
         *
         * @param characteristicIndex Temperature index
         * @param descriptorIndex     Environmental Sensing Trigger Setting index(0 - 2)
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> removeTemperatureEsTriggerSetting(int characteristicIndex, int descriptorIndex) {
            Map<Integer, Map<Integer, DescriptorData>> characteristicDataMap = mEsTriggerSettingMap.get(TEMPERATURE_CHARACTERISTIC);
            if (characteristicDataMap == null) {
                characteristicDataMap = new HashMap<>();
                mEsTriggerSettingMap.put(TEMPERATURE_CHARACTERISTIC, characteristicDataMap);
            }
            Map<Integer, DescriptorData> descriptorDataMap = characteristicDataMap.get(characteristicIndex);
            if (descriptorDataMap == null) {
                descriptorDataMap = new HashMap<>();
                characteristicDataMap.put(characteristicIndex, descriptorDataMap);
            }
            descriptorDataMap.remove(descriptorIndex);
            return this;
        }

        /**
         * @see #setTemperatureEsConfiguration(int, int, int, long, byte[])
         */
        @NonNull
        public Builder<T> setTemperatureEsConfiguration(int index, EnvironmentalSensingConfiguration environmentalSensingConfiguration) {
            return setTemperatureEsConfiguration(index, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, BluetoothGatt.GATT_SUCCESS, 0, environmentalSensingConfiguration.getBytes());
        }

        /**
         * add Temperature's ES Configuration descriptor
         *
         * @param index        Temperature index
         * @param permission   combination of
         *                     {@link android.bluetooth.BluetoothGattDescriptor#PERMISSION_READ}
         *                     {@link android.bluetooth.BluetoothGattDescriptor#PERMISSION_WRITE}
         * @param responseCode response code, {@link android.bluetooth.BluetoothGatt#GATT_SUCCESS} or etc
         * @param delay        response delay(millis)
         * @param value        data for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> setTemperatureEsConfiguration(int index, int permission, int responseCode, long delay, @NonNull byte[] value) {
            Map<Integer, DescriptorData> descriptorDataMap = mEsConfigurationMap.get(TEMPERATURE_CHARACTERISTIC);
            if (descriptorDataMap == null) {
                descriptorDataMap = new HashMap<>();
                mEsConfigurationMap.put(TEMPERATURE_CHARACTERISTIC, descriptorDataMap);
            }
            descriptorDataMap.put(index, new DescriptorData(ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR, permission, responseCode, delay, value));
            return this;
        }

        /**
         * remove Temperature's ES Configuration descriptor
         *
         * @param index Temperature index
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> removeTemperatureEsConfiguration(int index) {
            Map<Integer, DescriptorData> descriptorDataMap = mEsConfigurationMap.get(TEMPERATURE_CHARACTERISTIC);
            if (descriptorDataMap == null) {
                descriptorDataMap = new HashMap<>();
                mEsConfigurationMap.put(TEMPERATURE_CHARACTERISTIC, descriptorDataMap);
            }
            descriptorDataMap.remove(index);
            return this;
        }

        /**
         * @see #setTemperatureCharacteristicUserDescription(int, int, long, byte[])
         */
        @NonNull
        public Builder<T> setTemperatureCharacteristicUserDescription(int index, CharacteristicUserDescription characteristicUserDescription) {
            return setTemperatureCharacteristicUserDescription(index, BluetoothGatt.GATT_SUCCESS, 0, characteristicUserDescription.getBytes());
        }

        /**
         * add Temperature's Characteristic User Description descriptor
         *
         * @param index        Temperature index
         * @param responseCode response code, {@link android.bluetooth.BluetoothGatt#GATT_SUCCESS} or etc
         * @param delay        response delay(millis)
         * @param value        data for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> setTemperatureCharacteristicUserDescription(int index, int responseCode, long delay, @NonNull byte[] value) {
            Map<Integer, DescriptorData> descriptorDataMap = mCharacteristicUserDescriptionMap.get(TEMPERATURE_CHARACTERISTIC);
            if (descriptorDataMap == null) {
                descriptorDataMap = new HashMap<>();
                mCharacteristicUserDescriptionMap.put(TEMPERATURE_CHARACTERISTIC, descriptorDataMap);
            }
            descriptorDataMap.put(index, new DescriptorData(CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ, responseCode, delay, value));
            return this;
        }

        /**
         * remove Temperature's Characteristic User Description descriptor
         *
         * @param index Temperature index
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> removeTemperatureCharacteristicUserDescription(int index) {
            Map<Integer, DescriptorData> descriptorDataMap = mCharacteristicUserDescriptionMap.get(TEMPERATURE_CHARACTERISTIC);
            if (descriptorDataMap == null) {
                descriptorDataMap = new HashMap<>();
                mCharacteristicUserDescriptionMap.put(TEMPERATURE_CHARACTERISTIC, descriptorDataMap);
            }
            descriptorDataMap.remove(index);
            return this;
        }

        /**
         * @see #setTemperatureValidRange(int, int, long, byte[])
         */
        @NonNull
        public Builder<T> setTemperatureValidRange(int index, ValidRange validRange) {
            return setTemperatureValidRange(index, BluetoothGatt.GATT_SUCCESS, 0, validRange.getBytes());
        }

        /**
         * add Temperature's Valid Range descriptor
         *
         * @param index        Temperature index
         * @param responseCode response code, {@link android.bluetooth.BluetoothGatt#GATT_SUCCESS} or etc
         * @param delay        response delay(millis)
         * @param value        data for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> setTemperatureValidRange(int index, int responseCode, long delay, @NonNull byte[] value) {
            Map<Integer, DescriptorData> descriptorDataMap = mValidRangeMap.get(TEMPERATURE_CHARACTERISTIC);
            if (descriptorDataMap == null) {
                descriptorDataMap = new HashMap<>();
                mValidRangeMap.put(TEMPERATURE_CHARACTERISTIC, descriptorDataMap);
            }
            descriptorDataMap.put(index, new DescriptorData(VALID_RANGE_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ, responseCode, delay, value));
            return this;
        }

        /**
         * remove Temperature's Valid Range descriptor
         *
         * @param index Temperature index
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> removeTemperatureValidRange(int index) {
            Map<Integer, DescriptorData> descriptorDataMap = mValidRangeMap.get(TEMPERATURE_CHARACTERISTIC);
            if (descriptorDataMap == null) {
                descriptorDataMap = new HashMap<>();
                mValidRangeMap.put(TEMPERATURE_CHARACTERISTIC, descriptorDataMap);
            }
            descriptorDataMap.remove(index);
            return this;
        }

        /**
         * @see #addTrueWindDirection(int, int, int, long, byte[])
         */
        @NonNull
        public Builder<T> addTrueWindDirection(int index, @NonNull TrueWindDirection trueWindDirection) {
            return addTrueWindDirection(index, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, BluetoothGattCharacteristic.PERMISSION_READ, 0, trueWindDirection.getBytes());
        }

        /**
         * add True Wind Direction characteristic
         *
         * @param index        True Wind Direction index
         * @param property     combination of
         *                     {@link android.bluetooth.BluetoothGattCharacteristic#PROPERTY_READ}
         *                     {@link android.bluetooth.BluetoothGattCharacteristic#PROPERTY_NOTIFY}
         * @param responseCode response code, {@link android.bluetooth.BluetoothGatt#GATT_SUCCESS} or etc
         * @param delay        response delay(millis)
         * @param value        data for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> addTrueWindDirection(int index, int property, int responseCode, long delay, @NonNull byte[] value) {
            Map<Integer, CharacteristicData> characteristicDataMap = mEsCharacteristicDataMap.get(TRUE_WIND_DIRECTION_CHARACTERISTIC);
            if (characteristicDataMap == null) {
                characteristicDataMap = new HashMap<>();
                mEsCharacteristicDataMap.put(TRUE_WIND_DIRECTION_CHARACTERISTIC, characteristicDataMap);
            }
            characteristicDataMap.put(index, new CharacteristicData(TRUE_WIND_DIRECTION_CHARACTERISTIC, property, BluetoothGattCharacteristic.PERMISSION_READ, new ArrayList<>(), responseCode, delay, value, 0));
            return this;
        }

        /**
         * remove True Wind Direction characteristic
         *
         * @param index True Wind Direction index
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> removeTrueWindDirection(int index) {
            Map<Integer, CharacteristicData> characteristicDataMap = mEsCharacteristicDataMap.get(TRUE_WIND_DIRECTION_CHARACTERISTIC);
            if (characteristicDataMap == null) {
                characteristicDataMap = new HashMap<>();
                mEsCharacteristicDataMap.put(TRUE_WIND_DIRECTION_CHARACTERISTIC, characteristicDataMap);
            }
            characteristicDataMap.remove(index);
            return this;
        }

        /**
         * @see #setTrueWindDirectionEsMeasurement(int, int, long, byte[])
         */
        @NonNull
        public Builder<T> setTrueWindDirectionEsMeasurement(int index, EnvironmentalSensingMeasurement environmentalSensingMeasurement) {
            return setTrueWindDirectionEsMeasurement(index, BluetoothGatt.GATT_SUCCESS, 0, environmentalSensingMeasurement.getBytes());
        }

        /**
         * add True Wind Direction's ES Measurement descriptor
         *
         * @param index        True Wind Direction index
         * @param responseCode response code, {@link android.bluetooth.BluetoothGatt#GATT_SUCCESS} or etc
         * @param delay        response delay(millis)
         * @param value        data for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> setTrueWindDirectionEsMeasurement(int index, int responseCode, long delay, @NonNull byte[] value) {
            Map<Integer, DescriptorData> descriptorDataMap = mEsMeasurementMap.get(TRUE_WIND_DIRECTION_CHARACTERISTIC);
            if (descriptorDataMap == null) {
                descriptorDataMap = new HashMap<>();
                mEsMeasurementMap.put(TRUE_WIND_DIRECTION_CHARACTERISTIC, descriptorDataMap);
            }
            descriptorDataMap.put(index, new DescriptorData(ENVIRONMENTAL_SENSING_MEASUREMENT_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ, responseCode, delay, value));
            return this;
        }

        /**
         * remove True Wind Direction's ES Measurement descriptor
         *
         * @param index True Wind Direction index
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> removeTrueWindDirectionEsMeasurement(int index) {
            Map<Integer, DescriptorData> descriptorDataMap = mEsMeasurementMap.get(TRUE_WIND_DIRECTION_CHARACTERISTIC);
            if (descriptorDataMap == null) {
                descriptorDataMap = new HashMap<>();
                mEsMeasurementMap.put(TRUE_WIND_DIRECTION_CHARACTERISTIC, descriptorDataMap);
            }
            descriptorDataMap.remove(index);
            return this;
        }

        /**
         * @see #setTrueWindDirectionEsTriggerSetting(int, int, int, int, long, byte[])
         */
        @NonNull
        public Builder<T> setTrueWindDirectionEsTriggerSetting(int characteristicIndex, int descriptorIndex, EnvironmentalSensingTriggerSetting environmentalSensingTriggerSetting) {
            return setTrueWindDirectionEsTriggerSetting(characteristicIndex, descriptorIndex, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, BluetoothGatt.GATT_SUCCESS, 0, environmentalSensingTriggerSetting.getBytes());
        }

        /**
         * add True Wind Direction's ES Trigger Setting descriptor
         *
         * @param characteristicIndex True Wind Direction index
         * @param descriptorIndex     Environmental Sensing Trigger Setting index(0 - 2)
         * @param permission          combination of
         *                            {@link android.bluetooth.BluetoothGattDescriptor#PERMISSION_READ}
         *                            {@link android.bluetooth.BluetoothGattDescriptor#PERMISSION_WRITE}
         * @param responseCode        response code, {@link android.bluetooth.BluetoothGatt#GATT_SUCCESS} or etc
         * @param delay               response delay(millis)
         * @param value               data for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> setTrueWindDirectionEsTriggerSetting(int characteristicIndex, int descriptorIndex, int permission, int responseCode, long delay, @NonNull byte[] value) {
            Map<Integer, Map<Integer, DescriptorData>> characteristicDataMap = mEsTriggerSettingMap.get(TRUE_WIND_DIRECTION_CHARACTERISTIC);
            if (characteristicDataMap == null) {
                characteristicDataMap = new HashMap<>();
                mEsTriggerSettingMap.put(TRUE_WIND_DIRECTION_CHARACTERISTIC, characteristicDataMap);
            }
            Map<Integer, DescriptorData> descriptorDataMap = characteristicDataMap.get(characteristicIndex);
            if (descriptorDataMap == null) {
                descriptorDataMap = new HashMap<>();
                characteristicDataMap.put(characteristicIndex, descriptorDataMap);
            }
            descriptorDataMap.put(descriptorIndex, new DescriptorData(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR, permission, responseCode, delay, value));
            return this;
        }

        /**
         * remove True Wind Direction's ES Trigger Setting descriptor
         *
         * @param characteristicIndex True Wind Direction index
         * @param descriptorIndex     Environmental Sensing Trigger Setting index(0 - 2)
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> removeTrueWindDirectionEsTriggerSetting(int characteristicIndex, int descriptorIndex) {
            Map<Integer, Map<Integer, DescriptorData>> characteristicDataMap = mEsTriggerSettingMap.get(TRUE_WIND_DIRECTION_CHARACTERISTIC);
            if (characteristicDataMap == null) {
                characteristicDataMap = new HashMap<>();
                mEsTriggerSettingMap.put(TRUE_WIND_DIRECTION_CHARACTERISTIC, characteristicDataMap);
            }
            Map<Integer, DescriptorData> descriptorDataMap = characteristicDataMap.get(characteristicIndex);
            if (descriptorDataMap == null) {
                descriptorDataMap = new HashMap<>();
                characteristicDataMap.put(characteristicIndex, descriptorDataMap);
            }
            descriptorDataMap.remove(descriptorIndex);
            return this;
        }

        /**
         * @see #setTrueWindDirectionEsConfiguration(int, int, int, long, byte[])
         */
        @NonNull
        public Builder<T> setTrueWindDirectionEsConfiguration(int index, EnvironmentalSensingConfiguration environmentalSensingConfiguration) {
            return setTrueWindDirectionEsConfiguration(index, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, BluetoothGatt.GATT_SUCCESS, 0, environmentalSensingConfiguration.getBytes());
        }

        /**
         * add True Wind Direction's ES Configuration descriptor
         *
         * @param index        True Wind Direction index
         * @param permission   combination of
         *                     {@link android.bluetooth.BluetoothGattDescriptor#PERMISSION_READ}
         *                     {@link android.bluetooth.BluetoothGattDescriptor#PERMISSION_WRITE}
         * @param responseCode response code, {@link android.bluetooth.BluetoothGatt#GATT_SUCCESS} or etc
         * @param delay        response delay(millis)
         * @param value        data for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> setTrueWindDirectionEsConfiguration(int index, int permission, int responseCode, long delay, @NonNull byte[] value) {
            Map<Integer, DescriptorData> descriptorDataMap = mEsConfigurationMap.get(TRUE_WIND_DIRECTION_CHARACTERISTIC);
            if (descriptorDataMap == null) {
                descriptorDataMap = new HashMap<>();
                mEsConfigurationMap.put(TRUE_WIND_DIRECTION_CHARACTERISTIC, descriptorDataMap);
            }
            descriptorDataMap.put(index, new DescriptorData(ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR, permission, responseCode, delay, value));
            return this;
        }

        /**
         * remove True Wind Direction's ES Configuration descriptor
         *
         * @param index True Wind Direction index
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> removeTrueWindDirectionEsConfiguration(int index) {
            Map<Integer, DescriptorData> descriptorDataMap = mEsConfigurationMap.get(TRUE_WIND_DIRECTION_CHARACTERISTIC);
            if (descriptorDataMap == null) {
                descriptorDataMap = new HashMap<>();
                mEsConfigurationMap.put(TRUE_WIND_DIRECTION_CHARACTERISTIC, descriptorDataMap);
            }
            descriptorDataMap.remove(index);
            return this;
        }

        /**
         * @see #setTrueWindDirectionCharacteristicUserDescription(int, int, long, byte[])
         */
        @NonNull
        public Builder<T> setTrueWindDirectionCharacteristicUserDescription(int index, CharacteristicUserDescription characteristicUserDescription) {
            return setTrueWindDirectionCharacteristicUserDescription(index, BluetoothGatt.GATT_SUCCESS, 0, characteristicUserDescription.getBytes());
        }

        /**
         * add True Wind Direction's Characteristic User Description descriptor
         *
         * @param index        True Wind Direction index
         * @param responseCode response code, {@link android.bluetooth.BluetoothGatt#GATT_SUCCESS} or etc
         * @param delay        response delay(millis)
         * @param value        data for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> setTrueWindDirectionCharacteristicUserDescription(int index, int responseCode, long delay, @NonNull byte[] value) {
            Map<Integer, DescriptorData> descriptorDataMap = mCharacteristicUserDescriptionMap.get(TRUE_WIND_DIRECTION_CHARACTERISTIC);
            if (descriptorDataMap == null) {
                descriptorDataMap = new HashMap<>();
                mCharacteristicUserDescriptionMap.put(TRUE_WIND_DIRECTION_CHARACTERISTIC, descriptorDataMap);
            }
            descriptorDataMap.put(index, new DescriptorData(CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ, responseCode, delay, value));
            return this;
        }

        /**
         * remove True Wind Direction's Characteristic User Description descriptor
         *
         * @param index True Wind Direction index
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> removeTrueWindDirectionCharacteristicUserDescription(int index) {
            Map<Integer, DescriptorData> descriptorDataMap = mCharacteristicUserDescriptionMap.get(TRUE_WIND_DIRECTION_CHARACTERISTIC);
            if (descriptorDataMap == null) {
                descriptorDataMap = new HashMap<>();
                mCharacteristicUserDescriptionMap.put(TRUE_WIND_DIRECTION_CHARACTERISTIC, descriptorDataMap);
            }
            descriptorDataMap.remove(index);
            return this;
        }

        /**
         * @see #setTrueWindDirectionValidRange(int, int, long, byte[])
         */
        @NonNull
        public Builder<T> setTrueWindDirectionValidRange(int index, ValidRange validRange) {
            return setTrueWindDirectionValidRange(index, BluetoothGatt.GATT_SUCCESS, 0, validRange.getBytes());
        }

        /**
         * add True Wind Direction's Valid Range descriptor
         *
         * @param index        True Wind Direction index
         * @param responseCode response code, {@link android.bluetooth.BluetoothGatt#GATT_SUCCESS} or etc
         * @param delay        response delay(millis)
         * @param value        data for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> setTrueWindDirectionValidRange(int index, int responseCode, long delay, @NonNull byte[] value) {
            Map<Integer, DescriptorData> descriptorDataMap = mValidRangeMap.get(TRUE_WIND_DIRECTION_CHARACTERISTIC);
            if (descriptorDataMap == null) {
                descriptorDataMap = new HashMap<>();
                mValidRangeMap.put(TRUE_WIND_DIRECTION_CHARACTERISTIC, descriptorDataMap);
            }
            descriptorDataMap.put(index, new DescriptorData(VALID_RANGE_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ, responseCode, delay, value));
            return this;
        }

        /**
         * remove True Wind Direction's Valid Range descriptor
         *
         * @param index True Wind Direction index
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> removeTrueWindDirectionValidRange(int index) {
            Map<Integer, DescriptorData> descriptorDataMap = mValidRangeMap.get(TRUE_WIND_DIRECTION_CHARACTERISTIC);
            if (descriptorDataMap == null) {
                descriptorDataMap = new HashMap<>();
                mValidRangeMap.put(TRUE_WIND_DIRECTION_CHARACTERISTIC, descriptorDataMap);
            }
            descriptorDataMap.remove(index);
            return this;
        }

        /**
         * @see #addTrueWindSpeed(int, int, int, long, byte[])
         */
        @NonNull
        public Builder<T> addTrueWindSpeed(int index, @NonNull TrueWindSpeed trueWindSpeed) {
            return addTrueWindSpeed(index, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, BluetoothGattCharacteristic.PERMISSION_READ, 0, trueWindSpeed.getBytes());
        }

        /**
         * add True Wind Speed characteristic
         *
         * @param index        True Wind Speed index
         * @param property     combination of
         *                     {@link android.bluetooth.BluetoothGattCharacteristic#PROPERTY_READ}
         *                     {@link android.bluetooth.BluetoothGattCharacteristic#PROPERTY_NOTIFY}
         * @param responseCode response code, {@link android.bluetooth.BluetoothGatt#GATT_SUCCESS} or etc
         * @param delay        response delay(millis)
         * @param value        data for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> addTrueWindSpeed(int index, int property, int responseCode, long delay, @NonNull byte[] value) {
            Map<Integer, CharacteristicData> characteristicDataMap = mEsCharacteristicDataMap.get(TRUE_WIND_SPEED_CHARACTERISTIC);
            if (characteristicDataMap == null) {
                characteristicDataMap = new HashMap<>();
                mEsCharacteristicDataMap.put(TRUE_WIND_SPEED_CHARACTERISTIC, characteristicDataMap);
            }
            characteristicDataMap.put(index, new CharacteristicData(TRUE_WIND_SPEED_CHARACTERISTIC, property, BluetoothGattCharacteristic.PERMISSION_READ, new ArrayList<>(), responseCode, delay, value, 0));
            return this;
        }

        /**
         * remove True Wind Speed characteristic
         *
         * @param index True Wind Speed index
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> removeTrueWindSpeed(int index) {
            Map<Integer, CharacteristicData> characteristicDataMap = mEsCharacteristicDataMap.get(TRUE_WIND_SPEED_CHARACTERISTIC);
            if (characteristicDataMap == null) {
                characteristicDataMap = new HashMap<>();
                mEsCharacteristicDataMap.put(TRUE_WIND_SPEED_CHARACTERISTIC, characteristicDataMap);
            }
            characteristicDataMap.remove(index);
            return this;
        }

        /**
         * @see #setTrueWindSpeedEsMeasurement(int, int, long, byte[])
         */
        @NonNull
        public Builder<T> setTrueWindSpeedEsMeasurement(int index, EnvironmentalSensingMeasurement environmentalSensingMeasurement) {
            return setTrueWindSpeedEsMeasurement(index, BluetoothGatt.GATT_SUCCESS, 0, environmentalSensingMeasurement.getBytes());
        }

        /**
         * add True Wind Speed's ES Measurement descriptor
         *
         * @param index        True Wind Speed index
         * @param responseCode response code, {@link android.bluetooth.BluetoothGatt#GATT_SUCCESS} or etc
         * @param delay        response delay(millis)
         * @param value        data for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> setTrueWindSpeedEsMeasurement(int index, int responseCode, long delay, @NonNull byte[] value) {
            Map<Integer, DescriptorData> descriptorDataMap = mEsMeasurementMap.get(TRUE_WIND_SPEED_CHARACTERISTIC);
            if (descriptorDataMap == null) {
                descriptorDataMap = new HashMap<>();
                mEsMeasurementMap.put(TRUE_WIND_SPEED_CHARACTERISTIC, descriptorDataMap);
            }
            descriptorDataMap.put(index, new DescriptorData(ENVIRONMENTAL_SENSING_MEASUREMENT_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ, responseCode, delay, value));
            return this;
        }

        /**
         * remove True Wind Speed's ES Measurement descriptor
         *
         * @param index True Wind Speed index
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> removeTrueWindSpeedEsMeasurement(int index) {
            Map<Integer, DescriptorData> descriptorDataMap = mEsMeasurementMap.get(TRUE_WIND_SPEED_CHARACTERISTIC);
            if (descriptorDataMap == null) {
                descriptorDataMap = new HashMap<>();
                mEsMeasurementMap.put(TRUE_WIND_SPEED_CHARACTERISTIC, descriptorDataMap);
            }
            descriptorDataMap.remove(index);
            return this;
        }

        /**
         * @see #setTrueWindSpeedEsTriggerSetting(int, int, int, int, long, byte[])
         */
        @NonNull
        public Builder<T> setTrueWindSpeedEsTriggerSetting(int characteristicIndex, int descriptorIndex, EnvironmentalSensingTriggerSetting environmentalSensingTriggerSetting) {
            return setTrueWindSpeedEsTriggerSetting(characteristicIndex, descriptorIndex, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, BluetoothGatt.GATT_SUCCESS, 0, environmentalSensingTriggerSetting.getBytes());
        }

        /**
         * add True Wind Speed's ES Trigger Setting descriptor
         *
         * @param characteristicIndex True Wind Speed index
         * @param descriptorIndex     Environmental Sensing Trigger Setting index(0 - 2)
         * @param permission          combination of
         *                            {@link android.bluetooth.BluetoothGattDescriptor#PERMISSION_READ}
         *                            {@link android.bluetooth.BluetoothGattDescriptor#PERMISSION_WRITE}
         * @param responseCode        response code, {@link android.bluetooth.BluetoothGatt#GATT_SUCCESS} or etc
         * @param delay               response delay(millis)
         * @param value               data for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> setTrueWindSpeedEsTriggerSetting(int characteristicIndex, int descriptorIndex, int permission, int responseCode, long delay, @NonNull byte[] value) {
            Map<Integer, Map<Integer, DescriptorData>> characteristicDataMap = mEsTriggerSettingMap.get(TRUE_WIND_SPEED_CHARACTERISTIC);
            if (characteristicDataMap == null) {
                characteristicDataMap = new HashMap<>();
                mEsTriggerSettingMap.put(TRUE_WIND_SPEED_CHARACTERISTIC, characteristicDataMap);
            }
            Map<Integer, DescriptorData> descriptorDataMap = characteristicDataMap.get(characteristicIndex);
            if (descriptorDataMap == null) {
                descriptorDataMap = new HashMap<>();
                characteristicDataMap.put(characteristicIndex, descriptorDataMap);
            }
            descriptorDataMap.put(descriptorIndex, new DescriptorData(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR, permission, responseCode, delay, value));
            return this;
        }

        /**
         * remove True Wind Speed's ES Trigger Setting descriptor
         *
         * @param characteristicIndex True Wind Speed index
         * @param descriptorIndex     Environmental Sensing Trigger Setting index(0 - 2)
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> removeTrueWindSpeedEsTriggerSetting(int characteristicIndex, int descriptorIndex) {
            Map<Integer, Map<Integer, DescriptorData>> characteristicDataMap = mEsTriggerSettingMap.get(TRUE_WIND_SPEED_CHARACTERISTIC);
            if (characteristicDataMap == null) {
                characteristicDataMap = new HashMap<>();
                mEsTriggerSettingMap.put(TRUE_WIND_SPEED_CHARACTERISTIC, characteristicDataMap);
            }
            Map<Integer, DescriptorData> descriptorDataMap = characteristicDataMap.get(characteristicIndex);
            if (descriptorDataMap == null) {
                descriptorDataMap = new HashMap<>();
                characteristicDataMap.put(characteristicIndex, descriptorDataMap);
            }
            descriptorDataMap.remove(descriptorIndex);
            return this;
        }

        /**
         * @see #setTrueWindSpeedEsConfiguration(int, int, int, long, byte[])
         */
        @NonNull
        public Builder<T> setTrueWindSpeedEsConfiguration(int index, EnvironmentalSensingConfiguration environmentalSensingConfiguration) {
            return setTrueWindSpeedEsConfiguration(index, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, BluetoothGatt.GATT_SUCCESS, 0, environmentalSensingConfiguration.getBytes());
        }

        /**
         * add True Wind Speed's ES Configuration descriptor
         *
         * @param index        True Wind Speed index
         * @param permission   combination of
         *                     {@link android.bluetooth.BluetoothGattDescriptor#PERMISSION_READ}
         *                     {@link android.bluetooth.BluetoothGattDescriptor#PERMISSION_WRITE}
         * @param responseCode response code, {@link android.bluetooth.BluetoothGatt#GATT_SUCCESS} or etc
         * @param delay        response delay(millis)
         * @param value        data for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> setTrueWindSpeedEsConfiguration(int index, int permission, int responseCode, long delay, @NonNull byte[] value) {
            Map<Integer, DescriptorData> descriptorDataMap = mEsConfigurationMap.get(TRUE_WIND_SPEED_CHARACTERISTIC);
            if (descriptorDataMap == null) {
                descriptorDataMap = new HashMap<>();
                mEsConfigurationMap.put(TRUE_WIND_SPEED_CHARACTERISTIC, descriptorDataMap);
            }
            descriptorDataMap.put(index, new DescriptorData(ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR, permission, responseCode, delay, value));
            return this;
        }

        /**
         * remove True Wind Speed's ES Configuration descriptor
         *
         * @param index True Wind Speed index
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> removeTrueWindSpeedEsConfiguration(int index) {
            Map<Integer, DescriptorData> descriptorDataMap = mEsConfigurationMap.get(TRUE_WIND_SPEED_CHARACTERISTIC);
            if (descriptorDataMap == null) {
                descriptorDataMap = new HashMap<>();
                mEsConfigurationMap.put(TRUE_WIND_SPEED_CHARACTERISTIC, descriptorDataMap);
            }
            descriptorDataMap.remove(index);
            return this;
        }

        /**
         * @see #setTrueWindSpeedCharacteristicUserDescription(int, int, long, byte[])
         */
        @NonNull
        public Builder<T> setTrueWindSpeedCharacteristicUserDescription(int index, CharacteristicUserDescription characteristicUserDescription) {
            return setTrueWindSpeedCharacteristicUserDescription(index, BluetoothGatt.GATT_SUCCESS, 0, characteristicUserDescription.getBytes());
        }

        /**
         * add True Wind Speed's Characteristic User Description descriptor
         *
         * @param index        True Wind Speed index
         * @param responseCode response code, {@link android.bluetooth.BluetoothGatt#GATT_SUCCESS} or etc
         * @param delay        response delay(millis)
         * @param value        data for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> setTrueWindSpeedCharacteristicUserDescription(int index, int responseCode, long delay, @NonNull byte[] value) {
            Map<Integer, DescriptorData> descriptorDataMap = mCharacteristicUserDescriptionMap.get(TRUE_WIND_SPEED_CHARACTERISTIC);
            if (descriptorDataMap == null) {
                descriptorDataMap = new HashMap<>();
                mCharacteristicUserDescriptionMap.put(TRUE_WIND_SPEED_CHARACTERISTIC, descriptorDataMap);
            }
            descriptorDataMap.put(index, new DescriptorData(CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ, responseCode, delay, value));
            return this;
        }

        /**
         * remove True Wind Speed's Characteristic User Description descriptor
         *
         * @param index True Wind Speed index
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> removeTrueWindSpeedCharacteristicUserDescription(int index) {
            Map<Integer, DescriptorData> descriptorDataMap = mCharacteristicUserDescriptionMap.get(TRUE_WIND_SPEED_CHARACTERISTIC);
            if (descriptorDataMap == null) {
                descriptorDataMap = new HashMap<>();
                mCharacteristicUserDescriptionMap.put(TRUE_WIND_SPEED_CHARACTERISTIC, descriptorDataMap);
            }
            descriptorDataMap.remove(index);
            return this;
        }

        /**
         * @see #setTrueWindSpeedValidRange(int, int, long, byte[])
         */
        @NonNull
        public Builder<T> setTrueWindSpeedValidRange(int index, ValidRange validRange) {
            return setTrueWindSpeedValidRange(index, BluetoothGatt.GATT_SUCCESS, 0, validRange.getBytes());
        }

        /**
         * add True Wind Speed's Valid Range descriptor
         *
         * @param index        True Wind Speed index
         * @param responseCode response code, {@link android.bluetooth.BluetoothGatt#GATT_SUCCESS} or etc
         * @param delay        response delay(millis)
         * @param value        data for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> setTrueWindSpeedValidRange(int index, int responseCode, long delay, @NonNull byte[] value) {
            Map<Integer, DescriptorData> descriptorDataMap = mValidRangeMap.get(TRUE_WIND_SPEED_CHARACTERISTIC);
            if (descriptorDataMap == null) {
                descriptorDataMap = new HashMap<>();
                mValidRangeMap.put(TRUE_WIND_SPEED_CHARACTERISTIC, descriptorDataMap);
            }
            descriptorDataMap.put(index, new DescriptorData(VALID_RANGE_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ, responseCode, delay, value));
            return this;
        }

        /**
         * remove True Wind Speed's Valid Range descriptor
         *
         * @param index True Wind Speed index
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> removeTrueWindSpeedValidRange(int index) {
            Map<Integer, DescriptorData> descriptorDataMap = mValidRangeMap.get(TRUE_WIND_SPEED_CHARACTERISTIC);
            if (descriptorDataMap == null) {
                descriptorDataMap = new HashMap<>();
                mValidRangeMap.put(TRUE_WIND_SPEED_CHARACTERISTIC, descriptorDataMap);
            }
            descriptorDataMap.remove(index);
            return this;
        }

        /**
         * @see #addUVIndex(int, int, int, long, byte[])
         */
        @NonNull
        public Builder<T> addUVIndex(int index, @NonNull UVIndex uvIndex) {
            return addUVIndex(index, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, BluetoothGattCharacteristic.PERMISSION_READ, 0, uvIndex.getBytes());
        }

        /**
         * add UV Index characteristic
         *
         * @param index        UV Index index
         * @param property     combination of
         *                     {@link android.bluetooth.BluetoothGattCharacteristic#PROPERTY_READ}
         *                     {@link android.bluetooth.BluetoothGattCharacteristic#PROPERTY_NOTIFY}
         * @param responseCode response code, {@link android.bluetooth.BluetoothGatt#GATT_SUCCESS} or etc
         * @param delay        response delay(millis)
         * @param value        data for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> addUVIndex(int index, int property, int responseCode, long delay, @NonNull byte[] value) {
            Map<Integer, CharacteristicData> characteristicDataMap = mEsCharacteristicDataMap.get(UV_INDEX_CHARACTERISTIC);
            if (characteristicDataMap == null) {
                characteristicDataMap = new HashMap<>();
                mEsCharacteristicDataMap.put(UV_INDEX_CHARACTERISTIC, characteristicDataMap);
            }
            characteristicDataMap.put(index, new CharacteristicData(UV_INDEX_CHARACTERISTIC, property, BluetoothGattCharacteristic.PERMISSION_READ, new ArrayList<>(), responseCode, delay, value, 0));
            return this;
        }

        /**
         * remove UV Index characteristic
         *
         * @param index UV Index index
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> removeUVIndex(int index) {
            Map<Integer, CharacteristicData> characteristicDataMap = mEsCharacteristicDataMap.get(UV_INDEX_CHARACTERISTIC);
            if (characteristicDataMap == null) {
                characteristicDataMap = new HashMap<>();
                mEsCharacteristicDataMap.put(UV_INDEX_CHARACTERISTIC, characteristicDataMap);
            }
            characteristicDataMap.remove(index);
            return this;
        }

        /**
         * @see #setUVIndexEsMeasurement(int, int, long, byte[])
         */
        @NonNull
        public Builder<T> setUVIndexEsMeasurement(int index, EnvironmentalSensingMeasurement environmentalSensingMeasurement) {
            return setUVIndexEsMeasurement(index, BluetoothGatt.GATT_SUCCESS, 0, environmentalSensingMeasurement.getBytes());
        }

        /**
         * add UV Index's ES Measurement descriptor
         *
         * @param index        UV Index index
         * @param responseCode response code, {@link android.bluetooth.BluetoothGatt#GATT_SUCCESS} or etc
         * @param delay        response delay(millis)
         * @param value        data for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> setUVIndexEsMeasurement(int index, int responseCode, long delay, @NonNull byte[] value) {
            Map<Integer, DescriptorData> descriptorDataMap = mEsMeasurementMap.get(UV_INDEX_CHARACTERISTIC);
            if (descriptorDataMap == null) {
                descriptorDataMap = new HashMap<>();
                mEsMeasurementMap.put(UV_INDEX_CHARACTERISTIC, descriptorDataMap);
            }
            descriptorDataMap.put(index, new DescriptorData(ENVIRONMENTAL_SENSING_MEASUREMENT_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ, responseCode, delay, value));
            return this;
        }

        /**
         * remove UV Index's ES Measurement descriptor
         *
         * @param index UV Index index
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> removeUVIndexEsMeasurement(int index) {
            Map<Integer, DescriptorData> descriptorDataMap = mEsMeasurementMap.get(UV_INDEX_CHARACTERISTIC);
            if (descriptorDataMap == null) {
                descriptorDataMap = new HashMap<>();
                mEsMeasurementMap.put(UV_INDEX_CHARACTERISTIC, descriptorDataMap);
            }
            descriptorDataMap.remove(index);
            return this;
        }

        /**
         * @see #setUVIndexEsTriggerSetting(int, int, int, int, long, byte[])
         */
        @NonNull
        public Builder<T> setUVIndexEsTriggerSetting(int characteristicIndex, int descriptorIndex, EnvironmentalSensingTriggerSetting environmentalSensingTriggerSetting) {
            return setUVIndexEsTriggerSetting(characteristicIndex, descriptorIndex, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, BluetoothGatt.GATT_SUCCESS, 0, environmentalSensingTriggerSetting.getBytes());
        }

        /**
         * add UV Index's ES Trigger Setting descriptor
         *
         * @param characteristicIndex UV Index index
         * @param descriptorIndex     Environmental Sensing Trigger Setting index(0 - 2)
         * @param permission          combination of
         *                            {@link android.bluetooth.BluetoothGattDescriptor#PERMISSION_READ}
         *                            {@link android.bluetooth.BluetoothGattDescriptor#PERMISSION_WRITE}
         * @param responseCode        response code, {@link android.bluetooth.BluetoothGatt#GATT_SUCCESS} or etc
         * @param delay               response delay(millis)
         * @param value               data for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> setUVIndexEsTriggerSetting(int characteristicIndex, int descriptorIndex, int permission, int responseCode, long delay, @NonNull byte[] value) {
            Map<Integer, Map<Integer, DescriptorData>> characteristicDataMap = mEsTriggerSettingMap.get(UV_INDEX_CHARACTERISTIC);
            if (characteristicDataMap == null) {
                characteristicDataMap = new HashMap<>();
                mEsTriggerSettingMap.put(UV_INDEX_CHARACTERISTIC, characteristicDataMap);
            }
            Map<Integer, DescriptorData> descriptorDataMap = characteristicDataMap.get(characteristicIndex);
            if (descriptorDataMap == null) {
                descriptorDataMap = new HashMap<>();
                characteristicDataMap.put(characteristicIndex, descriptorDataMap);
            }
            descriptorDataMap.put(descriptorIndex, new DescriptorData(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR, permission, responseCode, delay, value));
            return this;
        }

        /**
         * remove UV Index's ES Trigger Setting descriptor
         *
         * @param characteristicIndex UV Index index
         * @param descriptorIndex     Environmental Sensing Trigger Setting index(0 - 2)
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> removeUVIndexEsTriggerSetting(int characteristicIndex, int descriptorIndex) {
            Map<Integer, Map<Integer, DescriptorData>> characteristicDataMap = mEsTriggerSettingMap.get(UV_INDEX_CHARACTERISTIC);
            if (characteristicDataMap == null) {
                characteristicDataMap = new HashMap<>();
                mEsTriggerSettingMap.put(UV_INDEX_CHARACTERISTIC, characteristicDataMap);
            }
            Map<Integer, DescriptorData> descriptorDataMap = characteristicDataMap.get(characteristicIndex);
            if (descriptorDataMap == null) {
                descriptorDataMap = new HashMap<>();
                characteristicDataMap.put(characteristicIndex, descriptorDataMap);
            }
            descriptorDataMap.remove(descriptorIndex);
            return this;
        }

        /**
         * @see #setUVIndexEsConfiguration(int, int, int, long, byte[])
         */
        @NonNull
        public Builder<T> setUVIndexEsConfiguration(int index, EnvironmentalSensingConfiguration environmentalSensingConfiguration) {
            return setUVIndexEsConfiguration(index, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, BluetoothGatt.GATT_SUCCESS, 0, environmentalSensingConfiguration.getBytes());
        }

        /**
         * add AUV Index's ES Configuration descriptor
         *
         * @param index        UV Index index
         * @param permission   combination of
         *                     {@link android.bluetooth.BluetoothGattDescriptor#PERMISSION_READ}
         *                     {@link android.bluetooth.BluetoothGattDescriptor#PERMISSION_WRITE}
         * @param responseCode response code, {@link android.bluetooth.BluetoothGatt#GATT_SUCCESS} or etc
         * @param delay        response delay(millis)
         * @param value        data for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> setUVIndexEsConfiguration(int index, int permission, int responseCode, long delay, @NonNull byte[] value) {
            Map<Integer, DescriptorData> descriptorDataMap = mEsConfigurationMap.get(UV_INDEX_CHARACTERISTIC);
            if (descriptorDataMap == null) {
                descriptorDataMap = new HashMap<>();
                mEsConfigurationMap.put(UV_INDEX_CHARACTERISTIC, descriptorDataMap);
            }
            descriptorDataMap.put(index, new DescriptorData(ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR, permission, responseCode, delay, value));
            return this;
        }

        /**
         * remove UV Index's ES Configuration descriptor
         *
         * @param index UV Index index
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> removeUVIndexEsConfiguration(int index) {
            Map<Integer, DescriptorData> descriptorDataMap = mEsConfigurationMap.get(UV_INDEX_CHARACTERISTIC);
            if (descriptorDataMap == null) {
                descriptorDataMap = new HashMap<>();
                mEsConfigurationMap.put(UV_INDEX_CHARACTERISTIC, descriptorDataMap);
            }
            descriptorDataMap.remove(index);
            return this;
        }

        /**
         * @see #setUVIndexCharacteristicUserDescription(int, int, long, byte[])
         */
        @NonNull
        public Builder<T> setUVIndexCharacteristicUserDescription(int index, CharacteristicUserDescription characteristicUserDescription) {
            return setUVIndexCharacteristicUserDescription(index, BluetoothGatt.GATT_SUCCESS, 0, characteristicUserDescription.getBytes());
        }

        /**
         * add UV Index's Characteristic User Description descriptor
         *
         * @param index        UV Index index
         * @param responseCode response code, {@link android.bluetooth.BluetoothGatt#GATT_SUCCESS} or etc
         * @param delay        response delay(millis)
         * @param value        data for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> setUVIndexCharacteristicUserDescription(int index, int responseCode, long delay, @NonNull byte[] value) {
            Map<Integer, DescriptorData> descriptorDataMap = mCharacteristicUserDescriptionMap.get(UV_INDEX_CHARACTERISTIC);
            if (descriptorDataMap == null) {
                descriptorDataMap = new HashMap<>();
                mCharacteristicUserDescriptionMap.put(UV_INDEX_CHARACTERISTIC, descriptorDataMap);
            }
            descriptorDataMap.put(index, new DescriptorData(CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ, responseCode, delay, value));
            return this;
        }

        /**
         * remove UV Index's Characteristic User Description descriptor
         *
         * @param index UV Index index
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> removeUVIndexCharacteristicUserDescription(int index) {
            Map<Integer, DescriptorData> descriptorDataMap = mCharacteristicUserDescriptionMap.get(UV_INDEX_CHARACTERISTIC);
            if (descriptorDataMap == null) {
                descriptorDataMap = new HashMap<>();
                mCharacteristicUserDescriptionMap.put(UV_INDEX_CHARACTERISTIC, descriptorDataMap);
            }
            descriptorDataMap.remove(index);
            return this;
        }

        /**
         * @see #setUVIndexValidRange(int, int, long, byte[])
         */
        @NonNull
        public Builder<T> setUVIndexValidRange(int index, ValidRange validRange) {
            return setUVIndexValidRange(index, BluetoothGatt.GATT_SUCCESS, 0, validRange.getBytes());
        }

        /**
         * add UV Index's Valid Range descriptor
         *
         * @param index        UV Index index
         * @param responseCode response code, {@link android.bluetooth.BluetoothGatt#GATT_SUCCESS} or etc
         * @param delay        response delay(millis)
         * @param value        data for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> setUVIndexValidRange(int index, int responseCode, long delay, @NonNull byte[] value) {
            Map<Integer, DescriptorData> descriptorDataMap = mValidRangeMap.get(UV_INDEX_CHARACTERISTIC);
            if (descriptorDataMap == null) {
                descriptorDataMap = new HashMap<>();
                mValidRangeMap.put(UV_INDEX_CHARACTERISTIC, descriptorDataMap);
            }
            descriptorDataMap.put(index, new DescriptorData(VALID_RANGE_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ, responseCode, delay, value));
            return this;
        }

        /**
         * remove UV Index's Valid Range descriptor
         *
         * @param index UV Index index
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> removeUVIndexValidRange(int index) {
            Map<Integer, DescriptorData> descriptorDataMap = mValidRangeMap.get(UV_INDEX_CHARACTERISTIC);
            if (descriptorDataMap == null) {
                descriptorDataMap = new HashMap<>();
                mValidRangeMap.put(UV_INDEX_CHARACTERISTIC, descriptorDataMap);
            }
            descriptorDataMap.remove(index);
            return this;
        }

        /**
         * @see #addWindChill(int, int, int, long, byte[])
         */
        @NonNull
        public Builder<T> addWindChill(int index, @NonNull WindChill windChill) {
            return addWindChill(index, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, BluetoothGattCharacteristic.PERMISSION_READ, 0, windChill.getBytes());
        }

        /**
         * add Wind Chill characteristic
         *
         * @param index        Wind Chill index
         * @param property     combination of
         *                     {@link android.bluetooth.BluetoothGattCharacteristic#PROPERTY_READ}
         *                     {@link android.bluetooth.BluetoothGattCharacteristic#PROPERTY_NOTIFY}
         * @param responseCode response code, {@link android.bluetooth.BluetoothGatt#GATT_SUCCESS} or etc
         * @param delay        response delay(millis)
         * @param value        data for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> addWindChill(int index, int property, int responseCode, long delay, @NonNull byte[] value) {
            Map<Integer, CharacteristicData> characteristicDataMap = mEsCharacteristicDataMap.get(WIND_CHILL_CHARACTERISTIC);
            if (characteristicDataMap == null) {
                characteristicDataMap = new HashMap<>();
                mEsCharacteristicDataMap.put(WIND_CHILL_CHARACTERISTIC, characteristicDataMap);
            }
            characteristicDataMap.put(index, new CharacteristicData(WIND_CHILL_CHARACTERISTIC, property, BluetoothGattCharacteristic.PERMISSION_READ, new ArrayList<>(), responseCode, delay, value, 0));
            return this;
        }

        /**
         * remove Wind Chill characteristic
         *
         * @param index Wind Chill index
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> removeWindChill(int index) {
            Map<Integer, CharacteristicData> characteristicDataMap = mEsCharacteristicDataMap.get(WIND_CHILL_CHARACTERISTIC);
            if (characteristicDataMap == null) {
                characteristicDataMap = new HashMap<>();
                mEsCharacteristicDataMap.put(WIND_CHILL_CHARACTERISTIC, characteristicDataMap);
            }
            characteristicDataMap.remove(index);
            return this;
        }

        /**
         * @see #setWindChillEsMeasurement(int, int, long, byte[])
         */
        @NonNull
        public Builder<T> setWindChillEsMeasurement(int index, EnvironmentalSensingMeasurement environmentalSensingMeasurement) {
            return setWindChillEsMeasurement(index, BluetoothGatt.GATT_SUCCESS, 0, environmentalSensingMeasurement.getBytes());
        }

        /**
         * add Wind Chill's ES Measurement descriptor
         *
         * @param index        Wind Chill index
         * @param responseCode response code, {@link android.bluetooth.BluetoothGatt#GATT_SUCCESS} or etc
         * @param delay        response delay(millis)
         * @param value        data for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> setWindChillEsMeasurement(int index, int responseCode, long delay, @NonNull byte[] value) {
            Map<Integer, DescriptorData> descriptorDataMap = mEsMeasurementMap.get(WIND_CHILL_CHARACTERISTIC);
            if (descriptorDataMap == null) {
                descriptorDataMap = new HashMap<>();
                mEsMeasurementMap.put(WIND_CHILL_CHARACTERISTIC, descriptorDataMap);
            }
            descriptorDataMap.put(index, new DescriptorData(ENVIRONMENTAL_SENSING_MEASUREMENT_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ, responseCode, delay, value));
            return this;
        }

        /**
         * remove Wind Chill's ES Measurement descriptor
         *
         * @param index Wind Chill index
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> removeWindChillEsMeasurement(int index) {
            Map<Integer, DescriptorData> descriptorDataMap = mEsMeasurementMap.get(WIND_CHILL_CHARACTERISTIC);
            if (descriptorDataMap == null) {
                descriptorDataMap = new HashMap<>();
                mEsMeasurementMap.put(WIND_CHILL_CHARACTERISTIC, descriptorDataMap);
            }
            descriptorDataMap.remove(index);
            return this;
        }

        /**
         * @see #setWindChillEsTriggerSetting(int, int, int, int, long, byte[])
         */
        @NonNull
        public Builder<T> setWindChillEsTriggerSetting(int characteristicIndex, int descriptorIndex, EnvironmentalSensingTriggerSetting environmentalSensingTriggerSetting) {
            return setWindChillEsTriggerSetting(characteristicIndex, descriptorIndex, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, BluetoothGatt.GATT_SUCCESS, 0, environmentalSensingTriggerSetting.getBytes());
        }

        /**
         * add Wind Chill's ES Trigger Setting descriptor
         *
         * @param characteristicIndex Wind Chill index
         * @param descriptorIndex     Environmental Sensing Trigger Setting index(0 - 2)
         * @param permission          combination of
         *                            {@link android.bluetooth.BluetoothGattDescriptor#PERMISSION_READ}
         *                            {@link android.bluetooth.BluetoothGattDescriptor#PERMISSION_WRITE}
         * @param responseCode        response code, {@link android.bluetooth.BluetoothGatt#GATT_SUCCESS} or etc
         * @param delay               response delay(millis)
         * @param value               data for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> setWindChillEsTriggerSetting(int characteristicIndex, int descriptorIndex, int permission, int responseCode, long delay, @NonNull byte[] value) {
            Map<Integer, Map<Integer, DescriptorData>> characteristicDataMap = mEsTriggerSettingMap.get(WIND_CHILL_CHARACTERISTIC);
            if (characteristicDataMap == null) {
                characteristicDataMap = new HashMap<>();
                mEsTriggerSettingMap.put(WIND_CHILL_CHARACTERISTIC, characteristicDataMap);
            }
            Map<Integer, DescriptorData> descriptorDataMap = characteristicDataMap.get(characteristicIndex);
            if (descriptorDataMap == null) {
                descriptorDataMap = new HashMap<>();
                characteristicDataMap.put(characteristicIndex, descriptorDataMap);
            }
            descriptorDataMap.put(descriptorIndex, new DescriptorData(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR, permission, responseCode, delay, value));
            return this;
        }

        /**
         * remove Wind Chill's ES Trigger Setting descriptor
         *
         * @param characteristicIndex Wind Chill index
         * @param descriptorIndex     Environmental Sensing Trigger Setting index(0 - 2)
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> removeWindChillEsTriggerSetting(int characteristicIndex, int descriptorIndex) {
            Map<Integer, Map<Integer, DescriptorData>> characteristicDataMap = mEsTriggerSettingMap.get(WIND_CHILL_CHARACTERISTIC);
            if (characteristicDataMap == null) {
                characteristicDataMap = new HashMap<>();
                mEsTriggerSettingMap.put(WIND_CHILL_CHARACTERISTIC, characteristicDataMap);
            }
            Map<Integer, DescriptorData> descriptorDataMap = characteristicDataMap.get(characteristicIndex);
            if (descriptorDataMap == null) {
                descriptorDataMap = new HashMap<>();
                characteristicDataMap.put(characteristicIndex, descriptorDataMap);
            }
            descriptorDataMap.remove(descriptorIndex);
            return this;
        }

        /**
         * @see #setWindChillEsConfiguration(int, int, int, long, byte[])
         */
        @NonNull
        public Builder<T> setWindChillEsConfiguration(int index, EnvironmentalSensingConfiguration environmentalSensingConfiguration) {
            return setWindChillEsConfiguration(index, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, BluetoothGatt.GATT_SUCCESS, 0, environmentalSensingConfiguration.getBytes());
        }

        /**
         * add Wind Chill's ES Configuration descriptor
         *
         * @param index        Wind Chill index
         * @param permission   combination of
         *                     {@link android.bluetooth.BluetoothGattDescriptor#PERMISSION_READ}
         *                     {@link android.bluetooth.BluetoothGattDescriptor#PERMISSION_WRITE}
         * @param responseCode response code, {@link android.bluetooth.BluetoothGatt#GATT_SUCCESS} or etc
         * @param delay        response delay(millis)
         * @param value        data for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> setWindChillEsConfiguration(int index, int permission, int responseCode, long delay, @NonNull byte[] value) {
            Map<Integer, DescriptorData> descriptorDataMap = mEsConfigurationMap.get(WIND_CHILL_CHARACTERISTIC);
            if (descriptorDataMap == null) {
                descriptorDataMap = new HashMap<>();
                mEsConfigurationMap.put(WIND_CHILL_CHARACTERISTIC, descriptorDataMap);
            }
            descriptorDataMap.put(index, new DescriptorData(ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR, permission, responseCode, delay, value));
            return this;
        }

        /**
         * remove Wind Chill's ES Configuration descriptor
         *
         * @param index Wind Chill index
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> removeWindChillEsConfiguration(int index) {
            Map<Integer, DescriptorData> descriptorDataMap = mEsConfigurationMap.get(WIND_CHILL_CHARACTERISTIC);
            if (descriptorDataMap == null) {
                descriptorDataMap = new HashMap<>();
                mEsConfigurationMap.put(WIND_CHILL_CHARACTERISTIC, descriptorDataMap);
            }
            descriptorDataMap.remove(index);
            return this;
        }

        /**
         * @see #setWindChillCharacteristicUserDescription(int, int, long, byte[])
         */
        @NonNull
        public Builder<T> setWindChillCharacteristicUserDescription(int index, CharacteristicUserDescription characteristicUserDescription) {
            return setWindChillCharacteristicUserDescription(index, BluetoothGatt.GATT_SUCCESS, 0, characteristicUserDescription.getBytes());
        }

        /**
         * add AWind Chill's Characteristic User Description descriptor
         *
         * @param index        Wind Chill index
         * @param responseCode response code, {@link android.bluetooth.BluetoothGatt#GATT_SUCCESS} or etc
         * @param delay        response delay(millis)
         * @param value        data for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> setWindChillCharacteristicUserDescription(int index, int responseCode, long delay, @NonNull byte[] value) {
            Map<Integer, DescriptorData> descriptorDataMap = mCharacteristicUserDescriptionMap.get(WIND_CHILL_CHARACTERISTIC);
            if (descriptorDataMap == null) {
                descriptorDataMap = new HashMap<>();
                mCharacteristicUserDescriptionMap.put(WIND_CHILL_CHARACTERISTIC, descriptorDataMap);
            }
            descriptorDataMap.put(index, new DescriptorData(CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ, responseCode, delay, value));
            return this;
        }

        /**
         * remove Wind Chill's Characteristic User Description descriptor
         *
         * @param index Wind Chill index
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> removeWindChillCharacteristicUserDescription(int index) {
            Map<Integer, DescriptorData> descriptorDataMap = mCharacteristicUserDescriptionMap.get(WIND_CHILL_CHARACTERISTIC);
            if (descriptorDataMap == null) {
                descriptorDataMap = new HashMap<>();
                mCharacteristicUserDescriptionMap.put(WIND_CHILL_CHARACTERISTIC, descriptorDataMap);
            }
            descriptorDataMap.remove(index);
            return this;
        }

        /**
         * @see #setWindChillValidRange(int, int, long, byte[])
         */
        @NonNull
        public Builder<T> setWindChillValidRange(int index, ValidRange validRange) {
            return setWindChillValidRange(index, BluetoothGatt.GATT_SUCCESS, 0, validRange.getBytes());
        }

        /**
         * add Wind Chill's Valid Range descriptor
         *
         * @param index        Wind Chill index
         * @param responseCode response code, {@link android.bluetooth.BluetoothGatt#GATT_SUCCESS} or etc
         * @param delay        response delay(millis)
         * @param value        data for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> setWindChillValidRange(int index, int responseCode, long delay, @NonNull byte[] value) {
            Map<Integer, DescriptorData> descriptorDataMap = mValidRangeMap.get(WIND_CHILL_CHARACTERISTIC);
            if (descriptorDataMap == null) {
                descriptorDataMap = new HashMap<>();
                mValidRangeMap.put(WIND_CHILL_CHARACTERISTIC, descriptorDataMap);
            }
            descriptorDataMap.put(index, new DescriptorData(VALID_RANGE_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ, responseCode, delay, value));
            return this;
        }

        /**
         * remove Wind Chill's Valid Range descriptor
         *
         * @param index Wind Chill index
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> removeWindChillValidRange(int index) {
            Map<Integer, DescriptorData> descriptorDataMap = mValidRangeMap.get(WIND_CHILL_CHARACTERISTIC);
            if (descriptorDataMap == null) {
                descriptorDataMap = new HashMap<>();
                mValidRangeMap.put(WIND_CHILL_CHARACTERISTIC, descriptorDataMap);
            }
            descriptorDataMap.remove(index);
            return this;
        }

        /**
         * @see #addBarometricPressureTrend(int, int, int, long, byte[])
         */
        @NonNull
        public Builder<T> addBarometricPressureTrend(int index, @NonNull BarometricPressureTrend barometricPressureTrend) {
            return addBarometricPressureTrend(index, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, BluetoothGattCharacteristic.PERMISSION_READ, 0, barometricPressureTrend.getBytes());
        }

        /**
         * add Barometric Pressure Trend characteristic
         *
         * @param index        Barometric Pressure Trend index
         * @param property     combination of
         *                     {@link android.bluetooth.BluetoothGattCharacteristic#PROPERTY_READ}
         *                     {@link android.bluetooth.BluetoothGattCharacteristic#PROPERTY_NOTIFY}
         * @param responseCode response code, {@link android.bluetooth.BluetoothGatt#GATT_SUCCESS} or etc
         * @param delay        response delay(millis)
         * @param value        data for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> addBarometricPressureTrend(int index, int property, int responseCode, long delay, @NonNull byte[] value) {
            Map<Integer, CharacteristicData> characteristicDataMap = mEsCharacteristicDataMap.get(BAROMETRIC_PRESSURE_TREND_CHARACTERISTIC);
            if (characteristicDataMap == null) {
                characteristicDataMap = new HashMap<>();
                mEsCharacteristicDataMap.put(BAROMETRIC_PRESSURE_TREND_CHARACTERISTIC, characteristicDataMap);
            }
            characteristicDataMap.put(index, new CharacteristicData(BAROMETRIC_PRESSURE_TREND_CHARACTERISTIC, property, BluetoothGattCharacteristic.PERMISSION_READ, new ArrayList<>(), responseCode, delay, value, 0));
            return this;
        }

        /**
         * remove Barometric Pressure Trend characteristic
         *
         * @param index Barometric Pressure Trend index
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> removeBarometricPressureTrend(int index) {
            Map<Integer, CharacteristicData> characteristicDataMap = mEsCharacteristicDataMap.get(BAROMETRIC_PRESSURE_TREND_CHARACTERISTIC);
            if (characteristicDataMap == null) {
                characteristicDataMap = new HashMap<>();
                mEsCharacteristicDataMap.put(BAROMETRIC_PRESSURE_TREND_CHARACTERISTIC, characteristicDataMap);
            }
            characteristicDataMap.remove(index);
            return this;
        }

        /**
         * @see #setBarometricPressureTrendEsMeasurement(int, int, long, byte[])
         */
        @NonNull
        public Builder<T> setBarometricPressureTrendEsMeasurement(int index, EnvironmentalSensingMeasurement environmentalSensingMeasurement) {
            return setBarometricPressureTrendEsMeasurement(index, BluetoothGatt.GATT_SUCCESS, 0, environmentalSensingMeasurement.getBytes());
        }

        /**
         * add Barometric Pressure Trend's ES Measurement descriptor
         *
         * @param index        Barometric Pressure Trend index
         * @param responseCode response code, {@link android.bluetooth.BluetoothGatt#GATT_SUCCESS} or etc
         * @param delay        response delay(millis)
         * @param value        data for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> setBarometricPressureTrendEsMeasurement(int index, int responseCode, long delay, @NonNull byte[] value) {
            Map<Integer, DescriptorData> descriptorDataMap = mEsMeasurementMap.get(BAROMETRIC_PRESSURE_TREND_CHARACTERISTIC);
            if (descriptorDataMap == null) {
                descriptorDataMap = new HashMap<>();
                mEsMeasurementMap.put(BAROMETRIC_PRESSURE_TREND_CHARACTERISTIC, descriptorDataMap);
            }
            descriptorDataMap.put(index, new DescriptorData(ENVIRONMENTAL_SENSING_MEASUREMENT_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ, responseCode, delay, value));
            return this;
        }

        /**
         * remove Barometric Pressure Trend's ES Measurement descriptor
         *
         * @param index Barometric Pressure Trend index
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> removeBarometricPressureTrendEsMeasurement(int index) {
            Map<Integer, DescriptorData> descriptorDataMap = mEsMeasurementMap.get(BAROMETRIC_PRESSURE_TREND_CHARACTERISTIC);
            if (descriptorDataMap == null) {
                descriptorDataMap = new HashMap<>();
                mEsMeasurementMap.put(BAROMETRIC_PRESSURE_TREND_CHARACTERISTIC, descriptorDataMap);
            }
            descriptorDataMap.remove(index);
            return this;
        }

        /**
         * @see #setBarometricPressureTrendEsTriggerSetting(int, int, int, int, long, byte[])
         */
        @NonNull
        public Builder<T> setBarometricPressureTrendEsTriggerSetting(int characteristicIndex, int descriptorIndex, EnvironmentalSensingTriggerSetting environmentalSensingTriggerSetting) {
            return setBarometricPressureTrendEsTriggerSetting(characteristicIndex, descriptorIndex, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, BluetoothGatt.GATT_SUCCESS, 0, environmentalSensingTriggerSetting.getBytes());
        }

        /**
         * add Barometric Pressure Trend's ES Trigger Setting descriptor
         *
         * @param characteristicIndex Barometric Pressure Trend index
         * @param descriptorIndex     Environmental Sensing Trigger Setting index(0 - 2)
         * @param permission          combination of
         *                            {@link android.bluetooth.BluetoothGattDescriptor#PERMISSION_READ}
         *                            {@link android.bluetooth.BluetoothGattDescriptor#PERMISSION_WRITE}
         * @param responseCode        response code, {@link android.bluetooth.BluetoothGatt#GATT_SUCCESS} or etc
         * @param delay               response delay(millis)
         * @param value               data for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> setBarometricPressureTrendEsTriggerSetting(int characteristicIndex, int descriptorIndex, int permission, int responseCode, long delay, @NonNull byte[] value) {
            Map<Integer, Map<Integer, DescriptorData>> characteristicDataMap = mEsTriggerSettingMap.get(BAROMETRIC_PRESSURE_TREND_CHARACTERISTIC);
            if (characteristicDataMap == null) {
                characteristicDataMap = new HashMap<>();
                mEsTriggerSettingMap.put(BAROMETRIC_PRESSURE_TREND_CHARACTERISTIC, characteristicDataMap);
            }
            Map<Integer, DescriptorData> descriptorDataMap = characteristicDataMap.get(characteristicIndex);
            if (descriptorDataMap == null) {
                descriptorDataMap = new HashMap<>();
                characteristicDataMap.put(characteristicIndex, descriptorDataMap);
            }
            descriptorDataMap.put(descriptorIndex, new DescriptorData(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR, permission, responseCode, delay, value));
            return this;
        }

        /**
         * remove Barometric Pressure Trend's ES Trigger Setting descriptor
         *
         * @param characteristicIndex Barometric Pressure Trend index
         * @param descriptorIndex     Environmental Sensing Trigger Setting index(0 - 2)
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> removeBarometricPressureTrendEsTriggerSetting(int characteristicIndex, int descriptorIndex) {
            Map<Integer, Map<Integer, DescriptorData>> characteristicDataMap = mEsTriggerSettingMap.get(BAROMETRIC_PRESSURE_TREND_CHARACTERISTIC);
            if (characteristicDataMap == null) {
                characteristicDataMap = new HashMap<>();
                mEsTriggerSettingMap.put(BAROMETRIC_PRESSURE_TREND_CHARACTERISTIC, characteristicDataMap);
            }
            Map<Integer, DescriptorData> descriptorDataMap = characteristicDataMap.get(characteristicIndex);
            if (descriptorDataMap == null) {
                descriptorDataMap = new HashMap<>();
                characteristicDataMap.put(characteristicIndex, descriptorDataMap);
            }
            descriptorDataMap.remove(descriptorIndex);
            return this;
        }

        /**
         * @see #setBarometricPressureTrendEsConfiguration(int, int, int, long, byte[])
         */
        @NonNull
        public Builder<T> setBarometricPressureTrendEsConfiguration(int index, EnvironmentalSensingConfiguration environmentalSensingConfiguration) {
            return setBarometricPressureTrendEsConfiguration(index, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, BluetoothGatt.GATT_SUCCESS, 0, environmentalSensingConfiguration.getBytes());
        }

        /**
         * add Barometric Pressure Trend's ES Configuration descriptor
         *
         * @param index        Barometric Pressure Trend index
         * @param permission   combination of
         *                     {@link android.bluetooth.BluetoothGattDescriptor#PERMISSION_READ}
         *                     {@link android.bluetooth.BluetoothGattDescriptor#PERMISSION_WRITE}
         * @param responseCode response code, {@link android.bluetooth.BluetoothGatt#GATT_SUCCESS} or etc
         * @param delay        response delay(millis)
         * @param value        data for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> setBarometricPressureTrendEsConfiguration(int index, int permission, int responseCode, long delay, @NonNull byte[] value) {
            Map<Integer, DescriptorData> descriptorDataMap = mEsConfigurationMap.get(BAROMETRIC_PRESSURE_TREND_CHARACTERISTIC);
            if (descriptorDataMap == null) {
                descriptorDataMap = new HashMap<>();
                mEsConfigurationMap.put(BAROMETRIC_PRESSURE_TREND_CHARACTERISTIC, descriptorDataMap);
            }
            descriptorDataMap.put(index, new DescriptorData(ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR, permission, responseCode, delay, value));
            return this;
        }

        /**
         * remove Barometric Pressure Trend's ES Configuration descriptor
         *
         * @param index Barometric Pressure Trend index
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> removeBarometricPressureTrendEsConfiguration(int index) {
            Map<Integer, DescriptorData> descriptorDataMap = mEsConfigurationMap.get(BAROMETRIC_PRESSURE_TREND_CHARACTERISTIC);
            if (descriptorDataMap == null) {
                descriptorDataMap = new HashMap<>();
                mEsConfigurationMap.put(BAROMETRIC_PRESSURE_TREND_CHARACTERISTIC, descriptorDataMap);
            }
            descriptorDataMap.remove(index);
            return this;
        }

        /**
         * @see #setBarometricPressureTrendCharacteristicUserDescription(int, int, long, byte[])
         */
        @NonNull
        public Builder<T> setBarometricPressureTrendCharacteristicUserDescription(int index, CharacteristicUserDescription characteristicUserDescription) {
            return setBarometricPressureTrendCharacteristicUserDescription(index, BluetoothGatt.GATT_SUCCESS, 0, characteristicUserDescription.getBytes());
        }

        /**
         * add Barometric Pressure Trend's Characteristic User Description descriptor
         *
         * @param index        Barometric Pressure Trend index
         * @param responseCode response code, {@link android.bluetooth.BluetoothGatt#GATT_SUCCESS} or etc
         * @param delay        response delay(millis)
         * @param value        data for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> setBarometricPressureTrendCharacteristicUserDescription(int index, int responseCode, long delay, @NonNull byte[] value) {
            Map<Integer, DescriptorData> descriptorDataMap = mCharacteristicUserDescriptionMap.get(BAROMETRIC_PRESSURE_TREND_CHARACTERISTIC);
            if (descriptorDataMap == null) {
                descriptorDataMap = new HashMap<>();
                mCharacteristicUserDescriptionMap.put(BAROMETRIC_PRESSURE_TREND_CHARACTERISTIC, descriptorDataMap);
            }
            descriptorDataMap.put(index, new DescriptorData(CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ, responseCode, delay, value));
            return this;
        }

        /**
         * remove Barometric Pressure Trend's Characteristic User Description descriptor
         *
         * @param index Barometric Pressure Trend index
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> removeBarometricPressureTrendCharacteristicUserDescription(int index) {
            Map<Integer, DescriptorData> descriptorDataMap = mCharacteristicUserDescriptionMap.get(BAROMETRIC_PRESSURE_TREND_CHARACTERISTIC);
            if (descriptorDataMap == null) {
                descriptorDataMap = new HashMap<>();
                mCharacteristicUserDescriptionMap.put(BAROMETRIC_PRESSURE_TREND_CHARACTERISTIC, descriptorDataMap);
            }
            descriptorDataMap.remove(index);
            return this;
        }

        /**
         * @see #setBarometricPressureTrendValidRange(int, int, long, byte[])
         */
        @NonNull
        public Builder<T> setBarometricPressureTrendValidRange(int index, ValidRange validRange) {
            return setBarometricPressureTrendValidRange(index, BluetoothGatt.GATT_SUCCESS, 0, validRange.getBytes());
        }

        /**
         * add Barometric Pressure Trend's Valid Range descriptor
         *
         * @param index        Barometric Pressure Trend index
         * @param responseCode response code, {@link android.bluetooth.BluetoothGatt#GATT_SUCCESS} or etc
         * @param delay        response delay(millis)
         * @param value        data for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> setBarometricPressureTrendValidRange(int index, int responseCode, long delay, @NonNull byte[] value) {
            Map<Integer, DescriptorData> descriptorDataMap = mValidRangeMap.get(BAROMETRIC_PRESSURE_TREND_CHARACTERISTIC);
            if (descriptorDataMap == null) {
                descriptorDataMap = new HashMap<>();
                mValidRangeMap.put(BAROMETRIC_PRESSURE_TREND_CHARACTERISTIC, descriptorDataMap);
            }
            descriptorDataMap.put(index, new DescriptorData(VALID_RANGE_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ, responseCode, delay, value));
            return this;
        }

        /**
         * remove Barometric Pressure Trend's Valid Range descriptor
         *
         * @param index Barometric Pressure Trend index
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> removeBarometricPressureTrendValidRange(int index) {
            Map<Integer, DescriptorData> descriptorDataMap = mValidRangeMap.get(BAROMETRIC_PRESSURE_TREND_CHARACTERISTIC);
            if (descriptorDataMap == null) {
                descriptorDataMap = new HashMap<>();
                mValidRangeMap.put(BAROMETRIC_PRESSURE_TREND_CHARACTERISTIC, descriptorDataMap);
            }
            descriptorDataMap.remove(index);
            return this;
        }

        /**
         * @see #addMagneticDeclination(int, int, int, long, byte[])
         */
        @NonNull
        public Builder<T> addMagneticDeclination(int index, @NonNull MagneticDeclination magneticDeclination) {
            return addMagneticDeclination(index, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, BluetoothGattCharacteristic.PERMISSION_READ, 0, magneticDeclination.getBytes());
        }

        /**
         * add Magnetic Declination characteristic
         *
         * @param index        Magnetic Declination index
         * @param property     combination of
         *                     {@link android.bluetooth.BluetoothGattCharacteristic#PROPERTY_READ}
         *                     {@link android.bluetooth.BluetoothGattCharacteristic#PROPERTY_NOTIFY}
         * @param responseCode response code, {@link android.bluetooth.BluetoothGatt#GATT_SUCCESS} or etc
         * @param delay        response delay(millis)
         * @param value        data for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> addMagneticDeclination(int index, int property, int responseCode, long delay, @NonNull byte[] value) {
            Map<Integer, CharacteristicData> characteristicDataMap = mEsCharacteristicDataMap.get(MAGNETIC_DECLINATION_CHARACTERISTIC);
            if (characteristicDataMap == null) {
                characteristicDataMap = new HashMap<>();
                mEsCharacteristicDataMap.put(MAGNETIC_DECLINATION_CHARACTERISTIC, characteristicDataMap);
            }
            characteristicDataMap.put(index, new CharacteristicData(MAGNETIC_DECLINATION_CHARACTERISTIC, property, BluetoothGattCharacteristic.PERMISSION_READ, new ArrayList<>(), responseCode, delay, value, 0));
            return this;
        }

        /**
         * remove Magnetic Declination characteristic
         *
         * @param index Magnetic Declination index
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> removeMagneticDeclination(int index) {
            Map<Integer, CharacteristicData> characteristicDataMap = mEsCharacteristicDataMap.get(MAGNETIC_DECLINATION_CHARACTERISTIC);
            if (characteristicDataMap == null) {
                characteristicDataMap = new HashMap<>();
                mEsCharacteristicDataMap.put(MAGNETIC_DECLINATION_CHARACTERISTIC, characteristicDataMap);
            }
            characteristicDataMap.remove(index);
            return this;
        }

        /**
         * @see #setMagneticDeclinationEsMeasurement(int, int, long, byte[])
         */
        @NonNull
        public Builder<T> setMagneticDeclinationEsMeasurement(int index, EnvironmentalSensingMeasurement environmentalSensingMeasurement) {
            return setMagneticDeclinationEsMeasurement(index, BluetoothGatt.GATT_SUCCESS, 0, environmentalSensingMeasurement.getBytes());
        }

        /**
         * add Magnetic Declination's ES Measurement descriptor
         *
         * @param index        Magnetic Declination index
         * @param responseCode response code, {@link android.bluetooth.BluetoothGatt#GATT_SUCCESS} or etc
         * @param delay        response delay(millis)
         * @param value        data for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> setMagneticDeclinationEsMeasurement(int index, int responseCode, long delay, @NonNull byte[] value) {
            Map<Integer, DescriptorData> descriptorDataMap = mEsMeasurementMap.get(MAGNETIC_DECLINATION_CHARACTERISTIC);
            if (descriptorDataMap == null) {
                descriptorDataMap = new HashMap<>();
                mEsMeasurementMap.put(MAGNETIC_DECLINATION_CHARACTERISTIC, descriptorDataMap);
            }
            descriptorDataMap.put(index, new DescriptorData(ENVIRONMENTAL_SENSING_MEASUREMENT_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ, responseCode, delay, value));
            return this;
        }

        /**
         * remove Magnetic Declination's ES Measurement descriptor
         *
         * @param index Magnetic Declination index
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> removeMagneticDeclinationEsMeasurement(int index) {
            Map<Integer, DescriptorData> descriptorDataMap = mEsMeasurementMap.get(MAGNETIC_DECLINATION_CHARACTERISTIC);
            if (descriptorDataMap == null) {
                descriptorDataMap = new HashMap<>();
                mEsMeasurementMap.put(MAGNETIC_DECLINATION_CHARACTERISTIC, descriptorDataMap);
            }
            descriptorDataMap.remove(index);
            return this;
        }

        /**
         * @see #setMagneticDeclinationEsTriggerSetting(int, int, int, int, long, byte[])
         */
        @NonNull
        public Builder<T> setMagneticDeclinationEsTriggerSetting(int characteristicIndex, int descriptorIndex, EnvironmentalSensingTriggerSetting environmentalSensingTriggerSetting) {
            return setMagneticDeclinationEsTriggerSetting(characteristicIndex, descriptorIndex, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, BluetoothGatt.GATT_SUCCESS, 0, environmentalSensingTriggerSetting.getBytes());
        }

        /**
         * add Magnetic Declination's ES Trigger Setting descriptor
         *
         * @param characteristicIndex Magnetic Declination index
         * @param descriptorIndex     Environmental Sensing Trigger Setting index(0 - 2)
         * @param permission          combination of
         *                            {@link android.bluetooth.BluetoothGattDescriptor#PERMISSION_READ}
         *                            {@link android.bluetooth.BluetoothGattDescriptor#PERMISSION_WRITE}
         * @param responseCode        response code, {@link android.bluetooth.BluetoothGatt#GATT_SUCCESS} or etc
         * @param delay               response delay(millis)
         * @param value               data for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> setMagneticDeclinationEsTriggerSetting(int characteristicIndex, int descriptorIndex, int permission, int responseCode, long delay, @NonNull byte[] value) {
            Map<Integer, Map<Integer, DescriptorData>> characteristicDataMap = mEsTriggerSettingMap.get(MAGNETIC_DECLINATION_CHARACTERISTIC);
            if (characteristicDataMap == null) {
                characteristicDataMap = new HashMap<>();
                mEsTriggerSettingMap.put(MAGNETIC_DECLINATION_CHARACTERISTIC, characteristicDataMap);
            }
            Map<Integer, DescriptorData> descriptorDataMap = characteristicDataMap.get(characteristicIndex);
            if (descriptorDataMap == null) {
                descriptorDataMap = new HashMap<>();
                characteristicDataMap.put(characteristicIndex, descriptorDataMap);
            }
            descriptorDataMap.put(descriptorIndex, new DescriptorData(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR, permission, responseCode, delay, value));
            return this;
        }

        /**
         * remove Magnetic Declination's ES Trigger Setting descriptor
         *
         * @param characteristicIndex Magnetic Declination index
         * @param descriptorIndex     Environmental Sensing Trigger Setting index(0 - 2)
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> removeMagneticDeclinationEsTriggerSetting(int characteristicIndex, int descriptorIndex) {
            Map<Integer, Map<Integer, DescriptorData>> characteristicDataMap = mEsTriggerSettingMap.get(MAGNETIC_DECLINATION_CHARACTERISTIC);
            if (characteristicDataMap == null) {
                characteristicDataMap = new HashMap<>();
                mEsTriggerSettingMap.put(MAGNETIC_DECLINATION_CHARACTERISTIC, characteristicDataMap);
            }
            Map<Integer, DescriptorData> descriptorDataMap = characteristicDataMap.get(characteristicIndex);
            if (descriptorDataMap == null) {
                descriptorDataMap = new HashMap<>();
                characteristicDataMap.put(characteristicIndex, descriptorDataMap);
            }
            descriptorDataMap.remove(descriptorIndex);
            return this;
        }

        /**
         * @see #setMagneticDeclinationEsConfiguration(int, int, int, long, byte[])
         */
        @NonNull
        public Builder<T> setMagneticDeclinationEsConfiguration(int index, EnvironmentalSensingConfiguration environmentalSensingConfiguration) {
            return setMagneticDeclinationEsConfiguration(index, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, BluetoothGatt.GATT_SUCCESS, 0, environmentalSensingConfiguration.getBytes());
        }

        /**
         * add Magnetic Declination's ES Configuration descriptor
         *
         * @param index        Magnetic Declination index
         * @param permission   combination of
         *                     {@link android.bluetooth.BluetoothGattDescriptor#PERMISSION_READ}
         *                     {@link android.bluetooth.BluetoothGattDescriptor#PERMISSION_WRITE}
         * @param responseCode response code, {@link android.bluetooth.BluetoothGatt#GATT_SUCCESS} or etc
         * @param delay        response delay(millis)
         * @param value        data for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> setMagneticDeclinationEsConfiguration(int index, int permission, int responseCode, long delay, @NonNull byte[] value) {
            Map<Integer, DescriptorData> descriptorDataMap = mEsConfigurationMap.get(MAGNETIC_DECLINATION_CHARACTERISTIC);
            if (descriptorDataMap == null) {
                descriptorDataMap = new HashMap<>();
                mEsConfigurationMap.put(MAGNETIC_DECLINATION_CHARACTERISTIC, descriptorDataMap);
            }
            descriptorDataMap.put(index, new DescriptorData(ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR, permission, responseCode, delay, value));
            return this;
        }

        /**
         * remove Magnetic Declination's ES Configuration descriptor
         *
         * @param index Magnetic Declination index
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> removeMagneticDeclinationEsConfiguration(int index) {
            Map<Integer, DescriptorData> descriptorDataMap = mEsConfigurationMap.get(MAGNETIC_DECLINATION_CHARACTERISTIC);
            if (descriptorDataMap == null) {
                descriptorDataMap = new HashMap<>();
                mEsConfigurationMap.put(MAGNETIC_DECLINATION_CHARACTERISTIC, descriptorDataMap);
            }
            descriptorDataMap.remove(index);
            return this;
        }

        /**
         * @see #setMagneticDeclinationCharacteristicUserDescription(int, int, long, byte[])
         */
        @NonNull
        public Builder<T> setMagneticDeclinationCharacteristicUserDescription(int index, CharacteristicUserDescription characteristicUserDescription) {
            return setMagneticDeclinationCharacteristicUserDescription(index, BluetoothGatt.GATT_SUCCESS, 0, characteristicUserDescription.getBytes());
        }

        /**
         * add Magnetic Declination's Characteristic User Description descriptor
         *
         * @param index        Magnetic Declination index
         * @param responseCode response code, {@link android.bluetooth.BluetoothGatt#GATT_SUCCESS} or etc
         * @param delay        response delay(millis)
         * @param value        data for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> setMagneticDeclinationCharacteristicUserDescription(int index, int responseCode, long delay, @NonNull byte[] value) {
            Map<Integer, DescriptorData> descriptorDataMap = mCharacteristicUserDescriptionMap.get(MAGNETIC_DECLINATION_CHARACTERISTIC);
            if (descriptorDataMap == null) {
                descriptorDataMap = new HashMap<>();
                mCharacteristicUserDescriptionMap.put(MAGNETIC_DECLINATION_CHARACTERISTIC, descriptorDataMap);
            }
            descriptorDataMap.put(index, new DescriptorData(CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ, responseCode, delay, value));
            return this;
        }

        /**
         * remove Magnetic Declination's Characteristic User Description descriptor
         *
         * @param index Magnetic Declination index
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> removeMagneticDeclinationCharacteristicUserDescription(int index) {
            Map<Integer, DescriptorData> descriptorDataMap = mCharacteristicUserDescriptionMap.get(MAGNETIC_DECLINATION_CHARACTERISTIC);
            if (descriptorDataMap == null) {
                descriptorDataMap = new HashMap<>();
                mCharacteristicUserDescriptionMap.put(MAGNETIC_DECLINATION_CHARACTERISTIC, descriptorDataMap);
            }
            descriptorDataMap.remove(index);
            return this;
        }

        /**
         * @see #setMagneticDeclinationValidRange(int, int, long, byte[])
         */
        @NonNull
        public Builder<T> setMagneticDeclinationValidRange(int index, ValidRange validRange) {
            return setMagneticDeclinationValidRange(index, BluetoothGatt.GATT_SUCCESS, 0, validRange.getBytes());
        }

        /**
         * add Magnetic Declination's Valid Range descriptor
         *
         * @param index        Magnetic Declination index
         * @param responseCode response code, {@link android.bluetooth.BluetoothGatt#GATT_SUCCESS} or etc
         * @param delay        response delay(millis)
         * @param value        data for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> setMagneticDeclinationValidRange(int index, int responseCode, long delay, @NonNull byte[] value) {
            Map<Integer, DescriptorData> descriptorDataMap = mValidRangeMap.get(MAGNETIC_DECLINATION_CHARACTERISTIC);
            if (descriptorDataMap == null) {
                descriptorDataMap = new HashMap<>();
                mValidRangeMap.put(MAGNETIC_DECLINATION_CHARACTERISTIC, descriptorDataMap);
            }
            descriptorDataMap.put(index, new DescriptorData(VALID_RANGE_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ, responseCode, delay, value));
            return this;
        }

        /**
         * remove Magnetic Declination's Valid Range descriptor
         *
         * @param index Magnetic Declination index
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> removeMagneticDeclinationValidRange(int index) {
            Map<Integer, DescriptorData> descriptorDataMap = mValidRangeMap.get(MAGNETIC_DECLINATION_CHARACTERISTIC);
            if (descriptorDataMap == null) {
                descriptorDataMap = new HashMap<>();
                mValidRangeMap.put(MAGNETIC_DECLINATION_CHARACTERISTIC, descriptorDataMap);
            }
            descriptorDataMap.remove(index);
            return this;
        }

        /**
         * @see #addMagneticFluxDensity2D(int, int, int, long, byte[])
         */
        @NonNull
        public Builder<T> addMagneticFluxDensity2D(int index, @NonNull MagneticFluxDensity2D magneticFluxDensity2D) {
            return addMagneticFluxDensity2D(index, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, BluetoothGattCharacteristic.PERMISSION_READ, 0, magneticFluxDensity2D.getBytes());
        }

        /**
         * add Magnetic Flux Density - 2D characteristic
         *
         * @param index        Magnetic Flux Density - 2D index
         * @param property     combination of
         *                     {@link android.bluetooth.BluetoothGattCharacteristic#PROPERTY_READ}
         *                     {@link android.bluetooth.BluetoothGattCharacteristic#PROPERTY_NOTIFY}
         * @param responseCode response code, {@link android.bluetooth.BluetoothGatt#GATT_SUCCESS} or etc
         * @param delay        response delay(millis)
         * @param value        data for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> addMagneticFluxDensity2D(int index, int property, int responseCode, long delay, @NonNull byte[] value) {
            Map<Integer, CharacteristicData> characteristicDataMap = mEsCharacteristicDataMap.get(MAGNETIC_FLUX_DENSITY_2D_CHARACTERISTIC);
            if (characteristicDataMap == null) {
                characteristicDataMap = new HashMap<>();
                mEsCharacteristicDataMap.put(MAGNETIC_FLUX_DENSITY_2D_CHARACTERISTIC, characteristicDataMap);
            }
            characteristicDataMap.put(index, new CharacteristicData(MAGNETIC_FLUX_DENSITY_2D_CHARACTERISTIC, property, BluetoothGattCharacteristic.PERMISSION_READ, new ArrayList<>(), responseCode, delay, value, 0));
            return this;
        }

        /**
         * remove Magnetic Flux Density - 2D characteristic
         *
         * @param index Magnetic Flux Density - 2D index
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> removeMagneticFluxDensity2D(int index) {
            Map<Integer, CharacteristicData> characteristicDataMap = mEsCharacteristicDataMap.get(MAGNETIC_FLUX_DENSITY_2D_CHARACTERISTIC);
            if (characteristicDataMap == null) {
                characteristicDataMap = new HashMap<>();
                mEsCharacteristicDataMap.put(MAGNETIC_FLUX_DENSITY_2D_CHARACTERISTIC, characteristicDataMap);
            }
            characteristicDataMap.remove(index);
            return this;
        }

        /**
         * @see #setMagneticFluxDensity2DEsMeasurement(int, int, long, byte[])
         */
        @NonNull
        public Builder<T> setMagneticFluxDensity2DEsMeasurement(int index, EnvironmentalSensingMeasurement environmentalSensingMeasurement) {
            return setMagneticFluxDensity2DEsMeasurement(index, BluetoothGatt.GATT_SUCCESS, 0, environmentalSensingMeasurement.getBytes());
        }

        /**
         * add Magnetic Flux Density - 2D's ES Measurement descriptor
         *
         * @param index        Magnetic Flux Density - 2D index
         * @param responseCode response code, {@link android.bluetooth.BluetoothGatt#GATT_SUCCESS} or etc
         * @param delay        response delay(millis)
         * @param value        data for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> setMagneticFluxDensity2DEsMeasurement(int index, int responseCode, long delay, @NonNull byte[] value) {
            Map<Integer, DescriptorData> descriptorDataMap = mEsMeasurementMap.get(MAGNETIC_FLUX_DENSITY_2D_CHARACTERISTIC);
            if (descriptorDataMap == null) {
                descriptorDataMap = new HashMap<>();
                mEsMeasurementMap.put(MAGNETIC_FLUX_DENSITY_2D_CHARACTERISTIC, descriptorDataMap);
            }
            descriptorDataMap.put(index, new DescriptorData(ENVIRONMENTAL_SENSING_MEASUREMENT_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ, responseCode, delay, value));
            return this;
        }

        /**
         * remove Magnetic Flux Density - 2D's ES Measurement descriptor
         *
         * @param index Magnetic Flux Density - 2D index
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> removeMagneticFluxDensity2DEsMeasurement(int index) {
            Map<Integer, DescriptorData> descriptorDataMap = mEsMeasurementMap.get(MAGNETIC_FLUX_DENSITY_2D_CHARACTERISTIC);
            if (descriptorDataMap == null) {
                descriptorDataMap = new HashMap<>();
                mEsMeasurementMap.put(MAGNETIC_FLUX_DENSITY_2D_CHARACTERISTIC, descriptorDataMap);
            }
            descriptorDataMap.remove(index);
            return this;
        }

        /**
         * @see #setMagneticFluxDensity2DEsTriggerSetting(int, int, int, int, long, byte[])
         */
        @NonNull
        public Builder<T> setMagneticFluxDensity2DEsTriggerSetting(int characteristicIndex, int descriptorIndex, EnvironmentalSensingTriggerSetting environmentalSensingTriggerSetting) {
            return setMagneticFluxDensity2DEsTriggerSetting(characteristicIndex, descriptorIndex, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, BluetoothGatt.GATT_SUCCESS, 0, environmentalSensingTriggerSetting.getBytes());
        }

        /**
         * add Magnetic Flux Density - 2D's ES Trigger Setting descriptor
         *
         * @param characteristicIndex Magnetic Flux Density - 2D index
         * @param descriptorIndex     Environmental Sensing Trigger Setting index(0 - 2)
         * @param permission          combination of
         *                            {@link android.bluetooth.BluetoothGattDescriptor#PERMISSION_READ}
         *                            {@link android.bluetooth.BluetoothGattDescriptor#PERMISSION_WRITE}
         * @param responseCode        response code, {@link android.bluetooth.BluetoothGatt#GATT_SUCCESS} or etc
         * @param delay               response delay(millis)
         * @param value               data for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> setMagneticFluxDensity2DEsTriggerSetting(int characteristicIndex, int descriptorIndex, int permission, int responseCode, long delay, @NonNull byte[] value) {
            Map<Integer, Map<Integer, DescriptorData>> characteristicDataMap = mEsTriggerSettingMap.get(MAGNETIC_FLUX_DENSITY_2D_CHARACTERISTIC);
            if (characteristicDataMap == null) {
                characteristicDataMap = new HashMap<>();
                mEsTriggerSettingMap.put(MAGNETIC_FLUX_DENSITY_2D_CHARACTERISTIC, characteristicDataMap);
            }
            Map<Integer, DescriptorData> descriptorDataMap = characteristicDataMap.get(characteristicIndex);
            if (descriptorDataMap == null) {
                descriptorDataMap = new HashMap<>();
                characteristicDataMap.put(characteristicIndex, descriptorDataMap);
            }
            descriptorDataMap.put(descriptorIndex, new DescriptorData(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR, permission, responseCode, delay, value));
            return this;
        }

        /**
         * remove Magnetic Flux Density - 2D's ES Trigger Setting descriptor
         *
         * @param characteristicIndex Magnetic Flux Density - 2D index
         * @param descriptorIndex     Environmental Sensing Trigger Setting index(0 - 2)
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> removeMagneticFluxDensity2DEsTriggerSetting(int characteristicIndex, int descriptorIndex) {
            Map<Integer, Map<Integer, DescriptorData>> characteristicDataMap = mEsTriggerSettingMap.get(MAGNETIC_FLUX_DENSITY_2D_CHARACTERISTIC);
            if (characteristicDataMap == null) {
                characteristicDataMap = new HashMap<>();
                mEsTriggerSettingMap.put(MAGNETIC_FLUX_DENSITY_2D_CHARACTERISTIC, characteristicDataMap);
            }
            Map<Integer, DescriptorData> descriptorDataMap = characteristicDataMap.get(characteristicIndex);
            if (descriptorDataMap == null) {
                descriptorDataMap = new HashMap<>();
                characteristicDataMap.put(characteristicIndex, descriptorDataMap);
            }
            descriptorDataMap.remove(descriptorIndex);
            return this;
        }

        /**
         * @see #setMagneticFluxDensity2DEsConfiguration(int, int, int, long, byte[])
         */
        @NonNull
        public Builder<T> setMagneticFluxDensity2DEsConfiguration(int index, EnvironmentalSensingConfiguration environmentalSensingConfiguration) {
            return setMagneticFluxDensity2DEsConfiguration(index, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, BluetoothGatt.GATT_SUCCESS, 0, environmentalSensingConfiguration.getBytes());
        }

        /**
         * add Magnetic Flux Density - 2D's ES Configuration descriptor
         *
         * @param index        Magnetic Flux Density - 2D index
         * @param permission   combination of
         *                     {@link android.bluetooth.BluetoothGattDescriptor#PERMISSION_READ}
         *                     {@link android.bluetooth.BluetoothGattDescriptor#PERMISSION_WRITE}
         * @param responseCode response code, {@link android.bluetooth.BluetoothGatt#GATT_SUCCESS} or etc
         * @param delay        response delay(millis)
         * @param value        data for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> setMagneticFluxDensity2DEsConfiguration(int index, int permission, int responseCode, long delay, @NonNull byte[] value) {
            Map<Integer, DescriptorData> descriptorDataMap = mEsConfigurationMap.get(MAGNETIC_FLUX_DENSITY_2D_CHARACTERISTIC);
            if (descriptorDataMap == null) {
                descriptorDataMap = new HashMap<>();
                mEsConfigurationMap.put(MAGNETIC_FLUX_DENSITY_2D_CHARACTERISTIC, descriptorDataMap);
            }
            descriptorDataMap.put(index, new DescriptorData(ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR, permission, responseCode, delay, value));
            return this;
        }

        /**
         * remove Magnetic Flux Density - 2D's ES Configuration descriptor
         *
         * @param index Magnetic Flux Density - 2D index
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> removeMagneticFluxDensity2DEsConfiguration(int index) {
            Map<Integer, DescriptorData> descriptorDataMap = mEsConfigurationMap.get(MAGNETIC_FLUX_DENSITY_2D_CHARACTERISTIC);
            if (descriptorDataMap == null) {
                descriptorDataMap = new HashMap<>();
                mEsConfigurationMap.put(MAGNETIC_FLUX_DENSITY_2D_CHARACTERISTIC, descriptorDataMap);
            }
            descriptorDataMap.remove(index);
            return this;
        }

        /**
         * @see #setMagneticFluxDensity2DCharacteristicUserDescription(int, int, long, byte[])
         */
        @NonNull
        public Builder<T> setMagneticFluxDensity2DCharacteristicUserDescription(int index, CharacteristicUserDescription characteristicUserDescription) {
            return setMagneticFluxDensity2DCharacteristicUserDescription(index, BluetoothGatt.GATT_SUCCESS, 0, characteristicUserDescription.getBytes());
        }

        /**
         * add Magnetic Flux Density - 2D's Characteristic User Description descriptor
         *
         * @param index        Magnetic Flux Density - 2D index
         * @param responseCode response code, {@link android.bluetooth.BluetoothGatt#GATT_SUCCESS} or etc
         * @param delay        response delay(millis)
         * @param value        data for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> setMagneticFluxDensity2DCharacteristicUserDescription(int index, int responseCode, long delay, @NonNull byte[] value) {
            Map<Integer, DescriptorData> descriptorDataMap = mCharacteristicUserDescriptionMap.get(MAGNETIC_FLUX_DENSITY_2D_CHARACTERISTIC);
            if (descriptorDataMap == null) {
                descriptorDataMap = new HashMap<>();
                mCharacteristicUserDescriptionMap.put(MAGNETIC_FLUX_DENSITY_2D_CHARACTERISTIC, descriptorDataMap);
            }
            descriptorDataMap.put(index, new DescriptorData(CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ, responseCode, delay, value));
            return this;
        }

        /**
         * remove Magnetic Flux Density - 2D's Characteristic User Description descriptor
         *
         * @param index Magnetic Flux Density - 2D index
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> removeMagneticFluxDensity2DCharacteristicUserDescription(int index) {
            Map<Integer, DescriptorData> descriptorDataMap = mCharacteristicUserDescriptionMap.get(MAGNETIC_FLUX_DENSITY_2D_CHARACTERISTIC);
            if (descriptorDataMap == null) {
                descriptorDataMap = new HashMap<>();
                mCharacteristicUserDescriptionMap.put(MAGNETIC_FLUX_DENSITY_2D_CHARACTERISTIC, descriptorDataMap);
            }
            descriptorDataMap.remove(index);
            return this;
        }

        /**
         * @see #setMagneticFluxDensity2DValidRange(int, int, long, byte[])
         */
        @NonNull
        public Builder<T> setMagneticFluxDensity2DValidRange(int index, ValidRange validRange) {
            return setMagneticFluxDensity2DValidRange(index, BluetoothGatt.GATT_SUCCESS, 0, validRange.getBytes());
        }

        /**
         * add Magnetic Flux Density - 2D's Valid Range descriptor
         *
         * @param index        Magnetic Flux Density - 2D index
         * @param responseCode response code, {@link android.bluetooth.BluetoothGatt#GATT_SUCCESS} or etc
         * @param delay        response delay(millis)
         * @param value        data for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> setMagneticFluxDensity2DValidRange(int index, int responseCode, long delay, @NonNull byte[] value) {
            Map<Integer, DescriptorData> descriptorDataMap = mValidRangeMap.get(MAGNETIC_FLUX_DENSITY_2D_CHARACTERISTIC);
            if (descriptorDataMap == null) {
                descriptorDataMap = new HashMap<>();
                mValidRangeMap.put(MAGNETIC_FLUX_DENSITY_2D_CHARACTERISTIC, descriptorDataMap);
            }
            descriptorDataMap.put(index, new DescriptorData(VALID_RANGE_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ, responseCode, delay, value));
            return this;
        }

        /**
         * remove Magnetic Flux Density - 2D's Valid Range descriptor
         *
         * @param index Magnetic Flux Density - 2D index
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> removeMagneticFluxDensity2DValidRange(int index) {
            Map<Integer, DescriptorData> descriptorDataMap = mValidRangeMap.get(MAGNETIC_FLUX_DENSITY_2D_CHARACTERISTIC);
            if (descriptorDataMap == null) {
                descriptorDataMap = new HashMap<>();
                mValidRangeMap.put(MAGNETIC_FLUX_DENSITY_2D_CHARACTERISTIC, descriptorDataMap);
            }
            descriptorDataMap.remove(index);
            return this;
        }

        /**
         * @see #addMagneticFluxDensity3D(int, int, int, long, byte[])
         */
        @NonNull
        public Builder<T> addMagneticFluxDensity3D(int index, @NonNull MagneticFluxDensity3D magneticFluxDensity3D) {
            return addMagneticFluxDensity3D(index, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, BluetoothGattCharacteristic.PERMISSION_READ, 0, magneticFluxDensity3D.getBytes());
        }

        /**
         * add Magnetic Flux Density - 3D characteristic
         *
         * @param index        Magnetic Flux Density - 3D index
         * @param property     combination of
         *                     {@link android.bluetooth.BluetoothGattCharacteristic#PROPERTY_READ}
         *                     {@link android.bluetooth.BluetoothGattCharacteristic#PROPERTY_NOTIFY}
         * @param responseCode response code, {@link android.bluetooth.BluetoothGatt#GATT_SUCCESS} or etc
         * @param delay        response delay(millis)
         * @param value        data for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> addMagneticFluxDensity3D(int index, int property, int responseCode, long delay, @NonNull byte[] value) {
            Map<Integer, CharacteristicData> characteristicDataMap = mEsCharacteristicDataMap.get(MAGNETIC_FLUX_DENSITY_3D_CHARACTERISTIC);
            if (characteristicDataMap == null) {
                characteristicDataMap = new HashMap<>();
                mEsCharacteristicDataMap.put(MAGNETIC_FLUX_DENSITY_3D_CHARACTERISTIC, characteristicDataMap);
            }
            characteristicDataMap.put(index, new CharacteristicData(MAGNETIC_FLUX_DENSITY_3D_CHARACTERISTIC, property, BluetoothGattCharacteristic.PERMISSION_READ, new ArrayList<>(), responseCode, delay, value, 0));
            return this;
        }

        /**
         * remove Magnetic Flux Density - 3D characteristic
         *
         * @param index Magnetic Flux Density - 3D index
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> removeMagneticFluxDensity3D(int index) {
            Map<Integer, CharacteristicData> characteristicDataMap = mEsCharacteristicDataMap.get(MAGNETIC_FLUX_DENSITY_3D_CHARACTERISTIC);
            if (characteristicDataMap == null) {
                characteristicDataMap = new HashMap<>();
                mEsCharacteristicDataMap.put(MAGNETIC_FLUX_DENSITY_3D_CHARACTERISTIC, characteristicDataMap);
            }
            characteristicDataMap.remove(index);
            return this;
        }

        /**
         * @see #setMagneticFluxDensity3DEsMeasurement(int, int, long, byte[])
         */
        @NonNull
        public Builder<T> setMagneticFluxDensity3DEsMeasurement(int index, EnvironmentalSensingMeasurement environmentalSensingMeasurement) {
            return setMagneticFluxDensity3DEsMeasurement(index, BluetoothGatt.GATT_SUCCESS, 0, environmentalSensingMeasurement.getBytes());
        }

        /**
         * add Magnetic Flux Density - 3D's ES Measurement descriptor
         *
         * @param index        Magnetic Flux Density - 3D index
         * @param responseCode response code, {@link android.bluetooth.BluetoothGatt#GATT_SUCCESS} or etc
         * @param delay        response delay(millis)
         * @param value        data for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> setMagneticFluxDensity3DEsMeasurement(int index, int responseCode, long delay, @NonNull byte[] value) {
            Map<Integer, DescriptorData> descriptorDataMap = mEsMeasurementMap.get(MAGNETIC_FLUX_DENSITY_3D_CHARACTERISTIC);
            if (descriptorDataMap == null) {
                descriptorDataMap = new HashMap<>();
                mEsMeasurementMap.put(MAGNETIC_FLUX_DENSITY_3D_CHARACTERISTIC, descriptorDataMap);
            }
            descriptorDataMap.put(index, new DescriptorData(ENVIRONMENTAL_SENSING_MEASUREMENT_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ, responseCode, delay, value));
            return this;
        }

        /**
         * remove Magnetic Flux Density - 3D's ES Measurement descriptor
         *
         * @param index Magnetic Flux Density - 3D index
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> removeMagneticFluxDensity3DEsMeasurement(int index) {
            Map<Integer, DescriptorData> descriptorDataMap = mEsMeasurementMap.get(MAGNETIC_FLUX_DENSITY_3D_CHARACTERISTIC);
            if (descriptorDataMap == null) {
                descriptorDataMap = new HashMap<>();
                mEsMeasurementMap.put(MAGNETIC_FLUX_DENSITY_3D_CHARACTERISTIC, descriptorDataMap);
            }
            descriptorDataMap.remove(index);
            return this;
        }

        /**
         * @see #setMagneticFluxDensity3DEsTriggerSetting(int, int, int, int, long, byte[])
         */
        @NonNull
        public Builder<T> setMagneticFluxDensity3DEsTriggerSetting(int characteristicIndex, int descriptorIndex, EnvironmentalSensingTriggerSetting environmentalSensingTriggerSetting) {
            return setMagneticFluxDensity3DEsTriggerSetting(characteristicIndex, descriptorIndex, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, BluetoothGatt.GATT_SUCCESS, 0, environmentalSensingTriggerSetting.getBytes());
        }

        /**
         * add Magnetic Flux Density - 3D's ES Trigger Setting descriptor
         *
         * @param characteristicIndex Magnetic Flux Density - 3D index
         * @param descriptorIndex     Environmental Sensing Trigger Setting index(0 - 2)
         * @param permission          combination of
         *                            {@link android.bluetooth.BluetoothGattDescriptor#PERMISSION_READ}
         *                            {@link android.bluetooth.BluetoothGattDescriptor#PERMISSION_WRITE}
         * @param responseCode        response code, {@link android.bluetooth.BluetoothGatt#GATT_SUCCESS} or etc
         * @param delay               response delay(millis)
         * @param value               data for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> setMagneticFluxDensity3DEsTriggerSetting(int characteristicIndex, int descriptorIndex, int permission, int responseCode, long delay, @NonNull byte[] value) {
            Map<Integer, Map<Integer, DescriptorData>> characteristicDataMap = mEsTriggerSettingMap.get(MAGNETIC_FLUX_DENSITY_3D_CHARACTERISTIC);
            if (characteristicDataMap == null) {
                characteristicDataMap = new HashMap<>();
                mEsTriggerSettingMap.put(MAGNETIC_FLUX_DENSITY_3D_CHARACTERISTIC, characteristicDataMap);
            }
            Map<Integer, DescriptorData> descriptorDataMap = characteristicDataMap.get(characteristicIndex);
            if (descriptorDataMap == null) {
                descriptorDataMap = new HashMap<>();
                characteristicDataMap.put(characteristicIndex, descriptorDataMap);
            }
            descriptorDataMap.put(descriptorIndex, new DescriptorData(ENVIRONMENTAL_SENSING_TRIGGER_SETTING_DESCRIPTOR, permission, responseCode, delay, value));
            return this;
        }

        /**
         * remove Magnetic Flux Density - 3D's ES Trigger Setting descriptor
         *
         * @param characteristicIndex Magnetic Flux Density - 3D index
         * @param descriptorIndex     Environmental Sensing Trigger Setting index(0 - 2)
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> removeMagneticFluxDensity3DEsTriggerSetting(int characteristicIndex, int descriptorIndex) {
            Map<Integer, Map<Integer, DescriptorData>> characteristicDataMap = mEsTriggerSettingMap.get(MAGNETIC_FLUX_DENSITY_3D_CHARACTERISTIC);
            if (characteristicDataMap == null) {
                characteristicDataMap = new HashMap<>();
                mEsTriggerSettingMap.put(MAGNETIC_FLUX_DENSITY_3D_CHARACTERISTIC, characteristicDataMap);
            }
            Map<Integer, DescriptorData> descriptorDataMap = characteristicDataMap.get(characteristicIndex);
            if (descriptorDataMap == null) {
                descriptorDataMap = new HashMap<>();
                characteristicDataMap.put(characteristicIndex, descriptorDataMap);
            }
            descriptorDataMap.remove(descriptorIndex);
            return this;
        }

        /**
         * @see #setMagneticFluxDensity3DEsConfiguration(int, int, int, long, byte[])
         */
        @NonNull
        public Builder<T> setMagneticFluxDensity3DEsConfiguration(int index, EnvironmentalSensingConfiguration environmentalSensingConfiguration) {
            return setMagneticFluxDensity3DEsConfiguration(index, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, BluetoothGatt.GATT_SUCCESS, 0, environmentalSensingConfiguration.getBytes());
        }

        /**
         * add Magnetic Flux Density - 3D's ES Configuration descriptor
         *
         * @param index        Magnetic Flux Density - 3D index
         * @param permission   combination of
         *                     {@link android.bluetooth.BluetoothGattDescriptor#PERMISSION_READ}
         *                     {@link android.bluetooth.BluetoothGattDescriptor#PERMISSION_WRITE}
         * @param responseCode response code, {@link android.bluetooth.BluetoothGatt#GATT_SUCCESS} or etc
         * @param delay        response delay(millis)
         * @param value        data for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> setMagneticFluxDensity3DEsConfiguration(int index, int permission, int responseCode, long delay, @NonNull byte[] value) {
            Map<Integer, DescriptorData> descriptorDataMap = mEsConfigurationMap.get(MAGNETIC_FLUX_DENSITY_3D_CHARACTERISTIC);
            if (descriptorDataMap == null) {
                descriptorDataMap = new HashMap<>();
                mEsConfigurationMap.put(MAGNETIC_FLUX_DENSITY_3D_CHARACTERISTIC, descriptorDataMap);
            }
            descriptorDataMap.put(index, new DescriptorData(ENVIRONMENTAL_SENSING_CONFIGURATION_DESCRIPTOR, permission, responseCode, delay, value));
            return this;
        }

        /**
         * remove Magnetic Flux Density - 3D's ES Configuration descriptor
         *
         * @param index Magnetic Flux Density - 3D index
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> removeMagneticFluxDensity3DEsConfiguration(int index) {
            Map<Integer, DescriptorData> descriptorDataMap = mEsConfigurationMap.get(MAGNETIC_FLUX_DENSITY_3D_CHARACTERISTIC);
            if (descriptorDataMap == null) {
                descriptorDataMap = new HashMap<>();
                mEsConfigurationMap.put(MAGNETIC_FLUX_DENSITY_3D_CHARACTERISTIC, descriptorDataMap);
            }
            descriptorDataMap.remove(index);
            return this;
        }

        /**
         * @see #setMagneticFluxDensity3DCharacteristicUserDescription(int, int, long, byte[])
         */
        @NonNull
        public Builder<T> setMagneticFluxDensity3DCharacteristicUserDescription(int index, CharacteristicUserDescription characteristicUserDescription) {
            return setMagneticFluxDensity3DCharacteristicUserDescription(index, BluetoothGatt.GATT_SUCCESS, 0, characteristicUserDescription.getBytes());
        }

        /**
         * add Magnetic Flux Density - 3D's Characteristic User Description descriptor
         *
         * @param index        Magnetic Flux Density - 3D index
         * @param responseCode response code, {@link android.bluetooth.BluetoothGatt#GATT_SUCCESS} or etc
         * @param delay        response delay(millis)
         * @param value        data for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> setMagneticFluxDensity3DCharacteristicUserDescription(int index, int responseCode, long delay, @NonNull byte[] value) {
            Map<Integer, DescriptorData> descriptorDataMap = mCharacteristicUserDescriptionMap.get(MAGNETIC_FLUX_DENSITY_3D_CHARACTERISTIC);
            if (descriptorDataMap == null) {
                descriptorDataMap = new HashMap<>();
                mCharacteristicUserDescriptionMap.put(MAGNETIC_FLUX_DENSITY_3D_CHARACTERISTIC, descriptorDataMap);
            }
            descriptorDataMap.put(index, new DescriptorData(CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ, responseCode, delay, value));
            return this;
        }

        /**
         * remove Magnetic Flux Density - 3D's Characteristic User Description descriptor
         *
         * @param index Magnetic Flux Density - 3D index
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> removeMagneticFluxDensity3DCharacteristicUserDescription(int index) {
            Map<Integer, DescriptorData> descriptorDataMap = mCharacteristicUserDescriptionMap.get(MAGNETIC_FLUX_DENSITY_3D_CHARACTERISTIC);
            if (descriptorDataMap == null) {
                descriptorDataMap = new HashMap<>();
                mCharacteristicUserDescriptionMap.put(MAGNETIC_FLUX_DENSITY_3D_CHARACTERISTIC, descriptorDataMap);
            }
            descriptorDataMap.remove(index);
            return this;
        }

        /**
         * @see #setMagneticFluxDensity3DValidRange(int, int, long, byte[])
         */
        @NonNull
        public Builder<T> setMagneticFluxDensity3DValidRange(int index, ValidRange validRange) {
            return setMagneticFluxDensity3DValidRange(index, BluetoothGatt.GATT_SUCCESS, 0, validRange.getBytes());
        }

        /**
         * add Magnetic Flux Density - 3D's Valid Range descriptor
         *
         * @param index        Magnetic Flux Density - 3D index
         * @param responseCode response code, {@link android.bluetooth.BluetoothGatt#GATT_SUCCESS} or etc
         * @param delay        response delay(millis)
         * @param value        data for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> setMagneticFluxDensity3DValidRange(int index, int responseCode, long delay, @NonNull byte[] value) {
            Map<Integer, DescriptorData> descriptorDataMap = mValidRangeMap.get(MAGNETIC_FLUX_DENSITY_3D_CHARACTERISTIC);
            if (descriptorDataMap == null) {
                descriptorDataMap = new HashMap<>();
                mValidRangeMap.put(MAGNETIC_FLUX_DENSITY_3D_CHARACTERISTIC, descriptorDataMap);
            }
            descriptorDataMap.put(index, new DescriptorData(VALID_RANGE_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ, responseCode, delay, value));
            return this;
        }

        /**
         * remove Magnetic Flux Density - 3D's Valid Range descriptor
         *
         * @param index Magnetic Flux Density - 3D index
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> removeMagneticFluxDensity3DValidRange(int index) {
            Map<Integer, DescriptorData> descriptorDataMap = mValidRangeMap.get(MAGNETIC_FLUX_DENSITY_3D_CHARACTERISTIC);
            if (descriptorDataMap == null) {
                descriptorDataMap = new HashMap<>();
                mValidRangeMap.put(MAGNETIC_FLUX_DENSITY_3D_CHARACTERISTIC, descriptorDataMap);
            }
            descriptorDataMap.remove(index);
            return this;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public MockData createMockData() {
            List<CharacteristicData> characteristicList = new ArrayList<>();

            boolean hasWritable = false;
            for (Map.Entry<UUID, Map<Integer, CharacteristicData>> esCharacteristicEntry : mEsCharacteristicDataMap.entrySet()) {
                UUID characteristicUUID = esCharacteristicEntry.getKey();
                Map<Integer, CharacteristicData> characteristicDataMap = esCharacteristicEntry.getValue();

                boolean hasMultipleCharacteristic = characteristicDataMap.size() > 1;
                List<Integer> keyList = new ArrayList<>(characteristicDataMap.keySet());
                Collections.sort(keyList);
                for (Integer characteristicIndex : keyList) {
                    CharacteristicData characteristicData = characteristicDataMap.get(characteristicIndex);
                    if (characteristicData != null) {
                        DescriptorData descriptorData;
                        Map<Integer, DescriptorData> descriptorDataMap = mEsMeasurementMap.get(characteristicUUID);
                        if (descriptorDataMap == null) {
                            if (hasMultipleCharacteristic) {
                                throw new RuntimeException("no ES Measurement data:" + characteristicUUID);
                            }
                        } else {
                            descriptorData = descriptorDataMap.get(characteristicIndex);
                            if (descriptorData == null) {
                                if (hasMultipleCharacteristic) {
                                    throw new RuntimeException("no ES Measurement data:" + characteristicUUID);
                                }
                            } else {
                                characteristicData.descriptorDataList.add(descriptorData);
                            }
                        }
                        if ((BluetoothGattCharacteristic.PROPERTY_NOTIFY & characteristicData.property) != 0) {
                            Map<Integer, Map<Integer, DescriptorData>> esTriggerSettingDescriptorDataMap = mEsTriggerSettingMap.get(characteristicUUID);
                            if (esTriggerSettingDescriptorDataMap == null) {
                                throw new RuntimeException("no ES Trigger Setting data:" + characteristicUUID);
                            } else {
                                descriptorDataMap = esTriggerSettingDescriptorDataMap.get(characteristicIndex);
                                if (descriptorDataMap == null) {
                                    throw new RuntimeException("no ES Trigger Setting data:" + characteristicUUID);
                                } else {
                                    DescriptorData esTriggerSettingDescriptorData0 = descriptorDataMap.get(0);
                                    DescriptorData esTriggerSettingDescriptorData1 = descriptorDataMap.get(1);
                                    DescriptorData esTriggerSettingDescriptorData2 = descriptorDataMap.get(2);
                                    if (esTriggerSettingDescriptorData0 == null
                                            && esTriggerSettingDescriptorData1 == null
                                            && esTriggerSettingDescriptorData2 == null) {
                                        throw new RuntimeException("no ES Trigger Setting data:" + characteristicUUID);
                                    } else {
                                        int triggerCount = 0;
                                        if (esTriggerSettingDescriptorData0 != null) {
                                            hasWritable |= (esTriggerSettingDescriptorData0.permission & BluetoothGattDescriptor.PERMISSION_WRITE) != 0;
                                            characteristicData.descriptorDataList.add(esTriggerSettingDescriptorData0);
                                            triggerCount++;
                                        }
                                        if (esTriggerSettingDescriptorData1 != null) {
                                            hasWritable |= (esTriggerSettingDescriptorData1.permission & BluetoothGattDescriptor.PERMISSION_WRITE) != 0;
                                            characteristicData.descriptorDataList.add(esTriggerSettingDescriptorData1);
                                            triggerCount++;
                                        }
                                        if (esTriggerSettingDescriptorData2 != null) {
                                            hasWritable |= (esTriggerSettingDescriptorData2.permission & BluetoothGattDescriptor.PERMISSION_WRITE) != 0;
                                            characteristicData.descriptorDataList.add(esTriggerSettingDescriptorData2);
                                            triggerCount++;
                                        }

                                        if (triggerCount > 1) {
                                            descriptorDataMap = mEsConfigurationMap.get(characteristicUUID);
                                            if (descriptorDataMap == null) {
                                                throw new RuntimeException("no ES Configuration data:" + characteristicUUID);
                                            } else {
                                                descriptorData = descriptorDataMap.get(characteristicIndex);
                                                if (descriptorData == null) {
                                                    throw new RuntimeException("no ES Configuration data:" + characteristicUUID);
                                                } else {
                                                    hasWritable |= (descriptorData.permission & BluetoothGattDescriptor.PERMISSION_WRITE) != 0;
                                                    characteristicData.descriptorDataList.add(descriptorData);
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        descriptorDataMap = mCharacteristicUserDescriptionMap.get(characteristicUUID);
                        if (descriptorDataMap != null) {
                            descriptorData = descriptorDataMap.get(characteristicIndex);
                            if (descriptorData != null) {
                                characteristicData.descriptorDataList.add(descriptorData);
                            }
                        }
                        descriptorDataMap = mValidRangeMap.get(characteristicUUID);
                        if (descriptorDataMap != null) {
                            descriptorData = descriptorDataMap.get(characteristicIndex);
                            if (descriptorData != null) {
                                characteristicData.descriptorDataList.add(descriptorData);
                            }
                        }
                        characteristicList.add(characteristicData);
                    }
                }
            }

            if (mDescriptorValueChanged == null) {
                if (hasWritable) {
                    throw new RuntimeException("no Descriptor Value Changed data");
                }
            } else {
                characteristicList.add(mDescriptorValueChanged);
            }

            ServiceData serviceData = new ServiceData(ENVIRONMENTAL_SENSING_SERVICE, BluetoothGattService.SERVICE_TYPE_PRIMARY, characteristicList);
            return new MockData(Collections.singletonList(serviceData));
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public EnvironmentalSensingServiceMockCallback build() {
            return new EnvironmentalSensingServiceMockCallback(createMockData(), false);
        }

    }

    /**
     * @param mockData   {@link MockData} instance
     * @param isFallback fallback flag
     */
    public EnvironmentalSensingServiceMockCallback(@NonNull MockData mockData, boolean isFallback) {
        super(mockData, isFallback);
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
