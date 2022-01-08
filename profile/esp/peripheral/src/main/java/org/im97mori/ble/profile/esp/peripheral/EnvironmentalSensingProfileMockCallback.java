package org.im97mori.ble.profile.esp.peripheral;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.im97mori.ble.BLEServerCallback;
import org.im97mori.ble.characteristic.u2a19.BatteryLevel;
import org.im97mori.ble.characteristic.u2a24.ModelNumberString;
import org.im97mori.ble.characteristic.u2a29.ManufacturerNameString;
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
import org.im97mori.ble.descriptor.u2904.CharacteristicPresentationFormat;
import org.im97mori.ble.descriptor.u2906.ValidRange;
import org.im97mori.ble.descriptor.u290b.EnvironmentalSensingConfiguration;
import org.im97mori.ble.descriptor.u290c.EnvironmentalSensingMeasurement;
import org.im97mori.ble.descriptor.u290d.EnvironmentalSensingTriggerSetting;
import org.im97mori.ble.profile.peripheral.AbstractProfileMockCallback;
import org.im97mori.ble.service.bas.peripheral.BatteryServiceMockCallback;
import org.im97mori.ble.service.dis.peripheral.DeviceInformationServiceMockCallback;
import org.im97mori.ble.service.ess.peripheral.EnvironmentalSensingServiceMockCallback;

import java.util.Arrays;
import java.util.UUID;
import java.util.stream.Stream;

import static org.im97mori.ble.constants.ServiceUUID.ENVIRONMENTAL_SENSING_SERVICE;

/**
 * Environmental Sensing Profile for Peripheral
 */
public class EnvironmentalSensingProfileMockCallback extends AbstractProfileMockCallback {

    /**
     * Builder for {@link EnvironmentalSensingProfileMockCallback}
     *
     * @param <T> subclass of {@link EnvironmentalSensingProfileMockCallback}
     */
    public static class Builder<T extends EnvironmentalSensingProfileMockCallback> {

        /**
         * {@link Context} instance
         */
        protected final Context mContext;

        /**
         * {@link org.im97mori.ble.service.ess.peripheral.EnvironmentalSensingServiceMockCallback.Builder} instance
         */
        protected final EnvironmentalSensingServiceMockCallback.Builder<? extends EnvironmentalSensingServiceMockCallback> mEnvironmentalSensingServiceMockCallbackBuilder;

        /**
         * {@link org.im97mori.ble.service.dis.peripheral.DeviceInformationServiceMockCallback.Builder} instance
         */
        protected final DeviceInformationServiceMockCallback.Builder<? extends DeviceInformationServiceMockCallback> mDeviceInformationServiceMockCallbackBuilder;

        /**
         * {@link org.im97mori.ble.service.bas.peripheral.BatteryServiceMockCallback.Builder} instance
         */
        protected final BatteryServiceMockCallback.Builder<? extends BatteryServiceMockCallback> mBatteryServiceMockCallbackBuilder;

        /**
         * flag for Manufacturer Name String data
         */
        protected boolean mHasManufacturerNameString;

        /**
         * flag for Model Number String data
         */
        protected boolean mHasModelNumberString;

        /**
         * @param context                                        {@link Context} instance
         * @param environmentalSensingServiceMockCallbackBuilder {@link org.im97mori.ble.service.ess.peripheral.EnvironmentalSensingServiceMockCallback.Builder} instance
         * @param deviceInformationServiceMockCallbackBuilder    {@link org.im97mori.ble.service.dis.peripheral.DeviceInformationServiceMockCallback.Builder} instance
         * @param batteryServiceMockCallbackBuilder              {@link org.im97mori.ble.service.bas.peripheral.BatteryServiceMockCallback.Builder} instance
         */
        public Builder(@NonNull Context context
                , @NonNull EnvironmentalSensingServiceMockCallback.Builder<? extends EnvironmentalSensingServiceMockCallback> environmentalSensingServiceMockCallbackBuilder
                , @Nullable DeviceInformationServiceMockCallback.Builder<? extends DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder
                , @Nullable BatteryServiceMockCallback.Builder<? extends BatteryServiceMockCallback> batteryServiceMockCallbackBuilder) {
            mContext = context;
            mEnvironmentalSensingServiceMockCallbackBuilder = environmentalSensingServiceMockCallbackBuilder;
            mDeviceInformationServiceMockCallbackBuilder = deviceInformationServiceMockCallbackBuilder;
            mBatteryServiceMockCallbackBuilder = batteryServiceMockCallbackBuilder;
        }

        /**
         * @see #addDescriptorValueChanged(int, long, byte[])
         */
        @NonNull
        public Builder<T> addDescriptorValueChanged(@NonNull ClientCharacteristicConfiguration clientCharacteristicConfiguration) {
            return addDescriptorValueChanged(BluetoothGatt.GATT_SUCCESS, 0, clientCharacteristicConfiguration.getBytes());
        }

        /**
         * @see org.im97mori.ble.service.ess.peripheral.EnvironmentalSensingServiceMockCallback.Builder#addDescriptorValueChanged(int, long, byte[])
         */
        @NonNull
        public Builder<T> addDescriptorValueChanged(int descriptorResponseCode, long descriptorDelay, @NonNull byte[] descriptorValue) {
            mEnvironmentalSensingServiceMockCallbackBuilder.addDescriptorValueChanged(descriptorResponseCode, descriptorDelay, descriptorValue);
            return this;
        }

        /**
         * @see org.im97mori.ble.service.ess.peripheral.EnvironmentalSensingServiceMockCallback.Builder#removeDescriptorValueChanged()
         */
        @NonNull
        public Builder<T> removeDescriptorValueChanged() {
            mEnvironmentalSensingServiceMockCallbackBuilder.removeDescriptorValueChanged();
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
         * @see org.im97mori.ble.service.ess.peripheral.EnvironmentalSensingServiceMockCallback.Builder#addApparentWindDirection(int, int, int, long, byte[])
         */
        @NonNull
        public Builder<T> addApparentWindDirection(int index, int property, int responseCode, long delay, @NonNull byte[] value) {
            mEnvironmentalSensingServiceMockCallbackBuilder.addApparentWindDirection(index, property, responseCode, delay, value);
            return this;
        }

        /**
         * @see org.im97mori.ble.service.ess.peripheral.EnvironmentalSensingServiceMockCallback.Builder#removeApparentWindDirection(int)
         */
        @NonNull
        public Builder<T> removeApparentWindDirection(int index) {
            mEnvironmentalSensingServiceMockCallbackBuilder.removeApparentWindDirection(index);
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
         * @see org.im97mori.ble.service.ess.peripheral.EnvironmentalSensingServiceMockCallback.Builder#setApparentWindDirectionEsMeasurement(int, int, long, byte[])
         */
        @NonNull
        public Builder<T> setApparentWindDirectionEsMeasurement(int index, int responseCode, long delay, @NonNull byte[] value) {
            mEnvironmentalSensingServiceMockCallbackBuilder.setApparentWindDirectionEsMeasurement(index, responseCode, delay, value);
            return this;
        }

        /**
         * @see org.im97mori.ble.service.ess.peripheral.EnvironmentalSensingServiceMockCallback.Builder#removeApparentWindDirectionEsMeasurement(int)
         */
        @NonNull
        public Builder<T> removeApparentWindDirectionEsMeasurement(int index) {
            mEnvironmentalSensingServiceMockCallbackBuilder.removeApparentWindDirectionEsMeasurement(index);
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
         * @see org.im97mori.ble.service.ess.peripheral.EnvironmentalSensingServiceMockCallback.Builder#setApparentWindDirectionEsTriggerSetting(int, int, int, int, long, byte[])
         */
        @NonNull
        public Builder<T> setApparentWindDirectionEsTriggerSetting(int characteristicIndex, int descriptorIndex, int permission, int responseCode, long delay, @NonNull byte[] value) {
            mEnvironmentalSensingServiceMockCallbackBuilder.setApparentWindDirectionEsTriggerSetting(characteristicIndex, descriptorIndex, permission, responseCode, delay, value);
            return this;
        }

        /**
         * @see org.im97mori.ble.service.ess.peripheral.EnvironmentalSensingServiceMockCallback.Builder#removeApparentWindDirectionEsTriggerSetting(int, int)
         */
        @NonNull
        public Builder<T> removeApparentWindDirectionEsTriggerSetting(int characteristicIndex, int descriptorIndex) {
            mEnvironmentalSensingServiceMockCallbackBuilder.removeApparentWindDirectionEsTriggerSetting(characteristicIndex, descriptorIndex);
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
         * @see org.im97mori.ble.service.ess.peripheral.EnvironmentalSensingServiceMockCallback.Builder#setApparentWindDirectionEsConfiguration(int, int, int, long, byte[])
         */
        @NonNull
        public Builder<T> setApparentWindDirectionEsConfiguration(int index, int permission, int responseCode, long delay, @NonNull byte[] value) {
            mEnvironmentalSensingServiceMockCallbackBuilder.setApparentWindDirectionEsConfiguration(index, permission, responseCode, delay, value);
            return this;
        }

        /**
         * @see org.im97mori.ble.service.ess.peripheral.EnvironmentalSensingServiceMockCallback.Builder#removeApparentWindDirectionEsConfiguration(int)
         */
        @NonNull
        public Builder<T> removeApparentWindDirectionEsConfiguration(int index) {
            mEnvironmentalSensingServiceMockCallbackBuilder.removeApparentWindDirectionEsConfiguration(index);
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
         * @see org.im97mori.ble.service.ess.peripheral.EnvironmentalSensingServiceMockCallback.Builder#setApparentWindDirectionCharacteristicUserDescription(int, int, long, byte[])
         */
        @NonNull
        public Builder<T> setApparentWindDirectionCharacteristicUserDescription(int index, int responseCode, long delay, @NonNull byte[] value) {
            mEnvironmentalSensingServiceMockCallbackBuilder.setApparentWindDirectionCharacteristicUserDescription(index, responseCode, delay, value);
            return this;
        }

        /**
         * @see org.im97mori.ble.service.ess.peripheral.EnvironmentalSensingServiceMockCallback.Builder#removeApparentWindDirectionCharacteristicUserDescription(int)
         */
        @NonNull
        public Builder<T> removeApparentWindDirectionCharacteristicUserDescription(int index) {
            mEnvironmentalSensingServiceMockCallbackBuilder.removeApparentWindDirectionCharacteristicUserDescription(index);
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
         * @see org.im97mori.ble.service.ess.peripheral.EnvironmentalSensingServiceMockCallback.Builder#setApparentWindDirectionValidRange(int, int, long, byte[])
         */
        @NonNull
        public Builder<T> setApparentWindDirectionValidRange(int index, int responseCode, long delay, @NonNull byte[] value) {
            mEnvironmentalSensingServiceMockCallbackBuilder.setApparentWindDirectionValidRange(index, responseCode, delay, value);
            return this;
        }

        /**
         * @see org.im97mori.ble.service.ess.peripheral.EnvironmentalSensingServiceMockCallback.Builder#removeApparentWindDirectionValidRange(int)
         */
        @NonNull
        public Builder<T> removeApparentWindDirectionValidRange(int index) {
            mEnvironmentalSensingServiceMockCallbackBuilder.removeApparentWindDirectionValidRange(index);
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
         * @see org.im97mori.ble.service.ess.peripheral.EnvironmentalSensingServiceMockCallback.Builder#addApparentWindSpeed(int, int, int, long, byte[])
         */
        @NonNull
        public Builder<T> addApparentWindSpeed(int index, int property, int responseCode, long delay, @NonNull byte[] value) {
            mEnvironmentalSensingServiceMockCallbackBuilder.addApparentWindSpeed(index, property, responseCode, delay, value);
            return this;
        }

        /**
         * @see org.im97mori.ble.service.ess.peripheral.EnvironmentalSensingServiceMockCallback.Builder#removeApparentWindSpeed(int)
         */
        @NonNull
        public Builder<T> removeApparentWindSpeed(int index) {
            mEnvironmentalSensingServiceMockCallbackBuilder.removeApparentWindSpeed(index);
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
         * @see org.im97mori.ble.service.ess.peripheral.EnvironmentalSensingServiceMockCallback.Builder#setApparentWindSpeedEsMeasurement(int, int, long, byte[])
         */
        @NonNull
        public Builder<T> setApparentWindSpeedEsMeasurement(int index, int responseCode, long delay, @NonNull byte[] value) {
            mEnvironmentalSensingServiceMockCallbackBuilder.setApparentWindSpeedEsMeasurement(index, responseCode, delay, value);
            return this;
        }

        /**
         * @see org.im97mori.ble.service.ess.peripheral.EnvironmentalSensingServiceMockCallback.Builder#removeApparentWindSpeedEsMeasurement(int)
         */
        @NonNull
        public Builder<T> removeApparentWindSpeedEsMeasurement(int index) {
            mEnvironmentalSensingServiceMockCallbackBuilder.removeApparentWindSpeedEsMeasurement(index);
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
         * @see org.im97mori.ble.service.ess.peripheral.EnvironmentalSensingServiceMockCallback.Builder#setApparentWindSpeedEsTriggerSetting(int, int, int, int, long, byte[])
         */
        @NonNull
        public Builder<T> setApparentWindSpeedEsTriggerSetting(int characteristicIndex, int descriptorIndex, int permission, int responseCode, long delay, @NonNull byte[] value) {
            mEnvironmentalSensingServiceMockCallbackBuilder.setApparentWindSpeedEsTriggerSetting(characteristicIndex, descriptorIndex, permission, responseCode, delay, value);
            return this;
        }

        /**
         * @see org.im97mori.ble.service.ess.peripheral.EnvironmentalSensingServiceMockCallback.Builder#removeApparentWindSpeedEsTriggerSetting(int, int)
         */
        @NonNull
        public Builder<T> removeApparentWindSpeedEsTriggerSetting(int characteristicIndex, int descriptorIndex) {
            mEnvironmentalSensingServiceMockCallbackBuilder.removeApparentWindSpeedEsTriggerSetting(characteristicIndex, descriptorIndex);
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
         * @see org.im97mori.ble.service.ess.peripheral.EnvironmentalSensingServiceMockCallback.Builder#setApparentWindSpeedEsConfiguration(int, int, int, long, byte[])
         */
        @NonNull
        public Builder<T> setApparentWindSpeedEsConfiguration(int index, int permission, int responseCode, long delay, @NonNull byte[] value) {
            mEnvironmentalSensingServiceMockCallbackBuilder.setApparentWindSpeedEsConfiguration(index, permission, responseCode, delay, value);
            return this;
        }

        /**
         * @see org.im97mori.ble.service.ess.peripheral.EnvironmentalSensingServiceMockCallback.Builder#removeApparentWindSpeedEsConfiguration(int)
         */
        @NonNull
        public Builder<T> removeApparentWindSpeedEsConfiguration(int index) {
            mEnvironmentalSensingServiceMockCallbackBuilder.removeApparentWindSpeedEsConfiguration(index);
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
         * @see org.im97mori.ble.service.ess.peripheral.EnvironmentalSensingServiceMockCallback.Builder#setApparentWindSpeedCharacteristicUserDescription(int, int, long, byte[])
         */
        @NonNull
        public Builder<T> setApparentWindSpeedCharacteristicUserDescription(int index, int responseCode, long delay, @NonNull byte[] value) {
            mEnvironmentalSensingServiceMockCallbackBuilder.setApparentWindSpeedCharacteristicUserDescription(index, responseCode, delay, value);
            return this;
        }

        /**
         * @see org.im97mori.ble.service.ess.peripheral.EnvironmentalSensingServiceMockCallback.Builder#removeApparentWindSpeedCharacteristicUserDescription(int)
         */
        @NonNull
        public Builder<T> removeApparentWindSpeedCharacteristicUserDescription(int index) {
            mEnvironmentalSensingServiceMockCallbackBuilder.removeApparentWindSpeedCharacteristicUserDescription(index);
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
         * @see org.im97mori.ble.service.ess.peripheral.EnvironmentalSensingServiceMockCallback.Builder#setApparentWindSpeedValidRange(int, int, long, byte[])
         */
        @NonNull
        public Builder<T> setApparentWindSpeedValidRange(int index, int responseCode, long delay, @NonNull byte[] value) {
            mEnvironmentalSensingServiceMockCallbackBuilder.setApparentWindSpeedValidRange(index, responseCode, delay, value);
            return this;
        }

        /**
         * @see org.im97mori.ble.service.ess.peripheral.EnvironmentalSensingServiceMockCallback.Builder#removeApparentWindSpeedValidRange(int)
         */
        @NonNull
        public Builder<T> removeApparentWindSpeedValidRange(int index) {
            mEnvironmentalSensingServiceMockCallbackBuilder.removeApparentWindSpeedValidRange(index);
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
         * @see org.im97mori.ble.service.ess.peripheral.EnvironmentalSensingServiceMockCallback.Builder#addDewPoint(int, int, int, long, byte[])
         */
        @NonNull
        public Builder<T> addDewPoint(int index, int property, int responseCode, long delay, @NonNull byte[] value) {
            mEnvironmentalSensingServiceMockCallbackBuilder.addDewPoint(index, property, responseCode, delay, value);
            return this;
        }

        /**
         * @see org.im97mori.ble.service.ess.peripheral.EnvironmentalSensingServiceMockCallback.Builder#removeDewPoint(int)
         */
        @NonNull
        public Builder<T> removeDewPoint(int index) {
            mEnvironmentalSensingServiceMockCallbackBuilder.removeDewPoint(index);
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
         * @see org.im97mori.ble.service.ess.peripheral.EnvironmentalSensingServiceMockCallback.Builder#setDewPointEsMeasurement(int, int, long, byte[])
         */
        @NonNull
        public Builder<T> setDewPointEsMeasurement(int index, int responseCode, long delay, @NonNull byte[] value) {
            mEnvironmentalSensingServiceMockCallbackBuilder.setDewPointEsMeasurement(index, responseCode, delay, value);
            return this;
        }

        /**
         * @see org.im97mori.ble.service.ess.peripheral.EnvironmentalSensingServiceMockCallback.Builder#removeDewPointEsMeasurement(int)
         */
        @NonNull
        public Builder<T> removeDewPointEsMeasurement(int index) {
            mEnvironmentalSensingServiceMockCallbackBuilder.removeDewPointEsMeasurement(index);
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
         * @see org.im97mori.ble.service.ess.peripheral.EnvironmentalSensingServiceMockCallback.Builder#setDewPointEsTriggerSetting(int, int, int, int, long, byte[])
         */
        @NonNull
        public Builder<T> setDewPointEsTriggerSetting(int characteristicIndex, int descriptorIndex, int permission, int responseCode, long delay, @NonNull byte[] value) {
            mEnvironmentalSensingServiceMockCallbackBuilder.setDewPointEsTriggerSetting(characteristicIndex, descriptorIndex, permission, responseCode, delay, value);
            return this;
        }

        /**
         * @see org.im97mori.ble.service.ess.peripheral.EnvironmentalSensingServiceMockCallback.Builder#removeDewPointEsTriggerSetting(int, int)
         */
        @NonNull
        public Builder<T> removeDewPointEsTriggerSetting(int characteristicIndex, int descriptorIndex) {
            mEnvironmentalSensingServiceMockCallbackBuilder.removeDewPointEsTriggerSetting(characteristicIndex, descriptorIndex);
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
         * @see org.im97mori.ble.service.ess.peripheral.EnvironmentalSensingServiceMockCallback.Builder#setDewPointEsConfiguration(int, int, int, long, byte[])
         */
        @NonNull
        public Builder<T> setDewPointEsConfiguration(int index, int permission, int responseCode, long delay, @NonNull byte[] value) {
            mEnvironmentalSensingServiceMockCallbackBuilder.setDewPointEsConfiguration(index, permission, responseCode, delay, value);
            return this;
        }

        /**
         * @see org.im97mori.ble.service.ess.peripheral.EnvironmentalSensingServiceMockCallback.Builder#removeDewPointEsConfiguration(int)
         */
        @NonNull
        public Builder<T> removeDewPointEsConfiguration(int index) {
            mEnvironmentalSensingServiceMockCallbackBuilder.removeDewPointEsConfiguration(index);
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
         * @see org.im97mori.ble.service.ess.peripheral.EnvironmentalSensingServiceMockCallback.Builder#setDewPointCharacteristicUserDescription(int, int, long, byte[])
         */
        @NonNull
        public Builder<T> setDewPointCharacteristicUserDescription(int index, int responseCode, long delay, @NonNull byte[] value) {
            mEnvironmentalSensingServiceMockCallbackBuilder.setDewPointCharacteristicUserDescription(index, responseCode, delay, value);
            return this;
        }

        /**
         * @see org.im97mori.ble.service.ess.peripheral.EnvironmentalSensingServiceMockCallback.Builder#removeDewPointCharacteristicUserDescription(int)
         */
        @NonNull
        public Builder<T> removeDewPointCharacteristicUserDescription(int index) {
            mEnvironmentalSensingServiceMockCallbackBuilder.removeDewPointCharacteristicUserDescription(index);
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
         * @see org.im97mori.ble.service.ess.peripheral.EnvironmentalSensingServiceMockCallback.Builder#setDewPointValidRange(int, int, long, byte[])
         */
        @NonNull
        public Builder<T> setDewPointValidRange(int index, int responseCode, long delay, @NonNull byte[] value) {
            mEnvironmentalSensingServiceMockCallbackBuilder.setDewPointValidRange(index, responseCode, delay, value);
            return this;
        }

        /**
         * @see org.im97mori.ble.service.ess.peripheral.EnvironmentalSensingServiceMockCallback.Builder#removeDewPointValidRange(int)
         */
        @NonNull
        public Builder<T> removeDewPointValidRange(int index) {
            mEnvironmentalSensingServiceMockCallbackBuilder.removeDewPointValidRange(index);
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
         * @see org.im97mori.ble.service.ess.peripheral.EnvironmentalSensingServiceMockCallback.Builder#addElevation(int, int, int, long, byte[])
         */
        @NonNull
        public Builder<T> addElevation(int index, int property, int responseCode, long delay, @NonNull byte[] value) {
            mEnvironmentalSensingServiceMockCallbackBuilder.addElevation(index, property, responseCode, delay, value);
            return this;
        }

        /**
         * @see org.im97mori.ble.service.ess.peripheral.EnvironmentalSensingServiceMockCallback.Builder#removeElevation(int)
         */
        @NonNull
        public Builder<T> removeElevation(int index) {
            mEnvironmentalSensingServiceMockCallbackBuilder.removeElevation(index);
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
         * @see org.im97mori.ble.service.ess.peripheral.EnvironmentalSensingServiceMockCallback.Builder#setElevationEsMeasurement(int, int, long, byte[])
         */
        @NonNull
        public Builder<T> setElevationEsMeasurement(int index, int responseCode, long delay, @NonNull byte[] value) {
            mEnvironmentalSensingServiceMockCallbackBuilder.setElevationEsMeasurement(index, responseCode, delay, value);
            return this;
        }

        /**
         * @see org.im97mori.ble.service.ess.peripheral.EnvironmentalSensingServiceMockCallback.Builder#removeElevationEsMeasurement(int)
         */
        @NonNull
        public Builder<T> removeElevationEsMeasurement(int index) {
            mEnvironmentalSensingServiceMockCallbackBuilder.removeElevationEsMeasurement(index);
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
         * @see org.im97mori.ble.service.ess.peripheral.EnvironmentalSensingServiceMockCallback.Builder#setElevationEsTriggerSetting(int, int, int, int, long, byte[])
         */
        @NonNull
        public Builder<T> setElevationEsTriggerSetting(int characteristicIndex, int descriptorIndex, int permission, int responseCode, long delay, @NonNull byte[] value) {
            mEnvironmentalSensingServiceMockCallbackBuilder.setElevationEsTriggerSetting(characteristicIndex, descriptorIndex, permission, responseCode, delay, value);
            return this;
        }

        /**
         * @see org.im97mori.ble.service.ess.peripheral.EnvironmentalSensingServiceMockCallback.Builder#removeElevationEsTriggerSetting(int, int)
         */
        @NonNull
        public Builder<T> removeElevationEsTriggerSetting(int characteristicIndex, int descriptorIndex) {
            mEnvironmentalSensingServiceMockCallbackBuilder.removeElevationEsTriggerSetting(characteristicIndex, descriptorIndex);
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
         * @see org.im97mori.ble.service.ess.peripheral.EnvironmentalSensingServiceMockCallback.Builder#setElevationEsConfiguration(int, int, int, long, byte[])
         */
        @NonNull
        public Builder<T> setElevationEsConfiguration(int index, int permission, int responseCode, long delay, @NonNull byte[] value) {
            mEnvironmentalSensingServiceMockCallbackBuilder.setElevationEsConfiguration(index, permission, responseCode, delay, value);
            return this;
        }

        /**
         * @see org.im97mori.ble.service.ess.peripheral.EnvironmentalSensingServiceMockCallback.Builder#removeElevationEsConfiguration(int)
         */
        @NonNull
        public Builder<T> removeElevationEsConfiguration(int index) {
            mEnvironmentalSensingServiceMockCallbackBuilder.removeElevationEsConfiguration(index);
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
         * @see org.im97mori.ble.service.ess.peripheral.EnvironmentalSensingServiceMockCallback.Builder#setElevationCharacteristicUserDescription(int, int, long, byte[])
         */
        @NonNull
        public Builder<T> setElevationCharacteristicUserDescription(int index, int responseCode, long delay, @NonNull byte[] value) {
            mEnvironmentalSensingServiceMockCallbackBuilder.setElevationCharacteristicUserDescription(index, responseCode, delay, value);
            return this;
        }

        /**
         * @see org.im97mori.ble.service.ess.peripheral.EnvironmentalSensingServiceMockCallback.Builder#removeElevationCharacteristicUserDescription(int)
         */
        @NonNull
        public Builder<T> removeElevationCharacteristicUserDescription(int index) {
            mEnvironmentalSensingServiceMockCallbackBuilder.removeElevationCharacteristicUserDescription(index);
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
         * @see org.im97mori.ble.service.ess.peripheral.EnvironmentalSensingServiceMockCallback.Builder#setElevationValidRange(int, int, long, byte[])
         */
        @NonNull
        public Builder<T> setElevationValidRange(int index, int responseCode, long delay, @NonNull byte[] value) {
            mEnvironmentalSensingServiceMockCallbackBuilder.setElevationValidRange(index, responseCode, delay, value);
            return this;
        }

        /**
         * @see org.im97mori.ble.service.ess.peripheral.EnvironmentalSensingServiceMockCallback.Builder#removeElevationValidRange(int)
         */
        @NonNull
        public Builder<T> removeElevationValidRange(int index) {
            mEnvironmentalSensingServiceMockCallbackBuilder.removeElevationValidRange(index);
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
         * @see org.im97mori.ble.service.ess.peripheral.EnvironmentalSensingServiceMockCallback.Builder#addGustFactor(int, int, int, long, byte[])
         */
        @NonNull
        public Builder<T> addGustFactor(int index, int property, int responseCode, long delay, @NonNull byte[] value) {
            mEnvironmentalSensingServiceMockCallbackBuilder.addGustFactor(index, property, responseCode, delay, value);
            return this;
        }

        /**
         * @see org.im97mori.ble.service.ess.peripheral.EnvironmentalSensingServiceMockCallback.Builder#removeGustFactor(int)
         */
        @NonNull
        public Builder<T> removeGustFactor(int index) {
            mEnvironmentalSensingServiceMockCallbackBuilder.removeGustFactor(index);
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
         * @see org.im97mori.ble.service.ess.peripheral.EnvironmentalSensingServiceMockCallback.Builder#setGustFactorEsMeasurement(int, int, long, byte[])
         */
        @NonNull
        public Builder<T> setGustFactorEsMeasurement(int index, int responseCode, long delay, @NonNull byte[] value) {
            mEnvironmentalSensingServiceMockCallbackBuilder.setGustFactorEsMeasurement(index, responseCode, delay, value);
            return this;
        }

        /**
         * @see org.im97mori.ble.service.ess.peripheral.EnvironmentalSensingServiceMockCallback.Builder#removeGustFactorEsMeasurement(int)
         */
        @NonNull
        public Builder<T> removeGustFactorEsMeasurement(int index) {
            mEnvironmentalSensingServiceMockCallbackBuilder.removeGustFactorEsMeasurement(index);
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
         * @see org.im97mori.ble.service.ess.peripheral.EnvironmentalSensingServiceMockCallback.Builder#setGustFactorEsTriggerSetting(int, int, int, int, long, byte[])
         */
        @NonNull
        public Builder<T> setGustFactorEsTriggerSetting(int characteristicIndex, int descriptorIndex, int permission, int responseCode, long delay, @NonNull byte[] value) {
            mEnvironmentalSensingServiceMockCallbackBuilder.setGustFactorEsTriggerSetting(characteristicIndex, descriptorIndex, permission, responseCode, delay, value);
            return this;
        }

        /**
         * @see org.im97mori.ble.service.ess.peripheral.EnvironmentalSensingServiceMockCallback.Builder#removeGustFactorEsTriggerSetting(int, int)
         */
        @NonNull
        public Builder<T> removeGustFactorEsTriggerSetting(int characteristicIndex, int descriptorIndex) {
            mEnvironmentalSensingServiceMockCallbackBuilder.removeGustFactorEsTriggerSetting(characteristicIndex, descriptorIndex);
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
         * @see org.im97mori.ble.service.ess.peripheral.EnvironmentalSensingServiceMockCallback.Builder#setGustFactorEsConfiguration(int, int, int, long, byte[])
         */
        @NonNull
        public Builder<T> setGustFactorEsConfiguration(int index, int permission, int responseCode, long delay, @NonNull byte[] value) {
            mEnvironmentalSensingServiceMockCallbackBuilder.setGustFactorEsConfiguration(index, permission, responseCode, delay, value);
            return this;
        }

        /**
         * @see org.im97mori.ble.service.ess.peripheral.EnvironmentalSensingServiceMockCallback.Builder#removeGustFactorEsConfiguration(int)
         */
        @NonNull
        public Builder<T> removeGustFactorEsConfiguration(int index) {
            mEnvironmentalSensingServiceMockCallbackBuilder.removeGustFactorEsConfiguration(index);
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
         * @see org.im97mori.ble.service.ess.peripheral.EnvironmentalSensingServiceMockCallback.Builder#setGustFactorCharacteristicUserDescription(int, int, long, byte[])
         */
        @NonNull
        public Builder<T> setGustFactorCharacteristicUserDescription(int index, int responseCode, long delay, @NonNull byte[] value) {
            mEnvironmentalSensingServiceMockCallbackBuilder.setGustFactorCharacteristicUserDescription(index, responseCode, delay, value);
            return this;
        }

        /**
         * @see org.im97mori.ble.service.ess.peripheral.EnvironmentalSensingServiceMockCallback.Builder#removeGustFactorCharacteristicUserDescription(int)
         */
        @NonNull
        public Builder<T> removeGustFactorCharacteristicUserDescription(int index) {
            mEnvironmentalSensingServiceMockCallbackBuilder.removeGustFactorCharacteristicUserDescription(index);
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
         * @see org.im97mori.ble.service.ess.peripheral.EnvironmentalSensingServiceMockCallback.Builder#setGustFactorValidRange(int, int, long, byte[])
         */
        @NonNull
        public Builder<T> setGustFactorValidRange(int index, int responseCode, long delay, @NonNull byte[] value) {
            mEnvironmentalSensingServiceMockCallbackBuilder.setGustFactorValidRange(index, responseCode, delay, value);
            return this;
        }

        /**
         * @see org.im97mori.ble.service.ess.peripheral.EnvironmentalSensingServiceMockCallback.Builder#removeGustFactorValidRange(int)
         */
        @NonNull
        public Builder<T> removeGustFactorValidRange(int index) {
            mEnvironmentalSensingServiceMockCallbackBuilder.removeGustFactorValidRange(index);
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
         * @see org.im97mori.ble.service.ess.peripheral.EnvironmentalSensingServiceMockCallback.Builder#addHeatIndex(int, int, int, long, byte[])
         */
        @NonNull
        public Builder<T> addHeatIndex(int index, int property, int responseCode, long delay, @NonNull byte[] value) {
            mEnvironmentalSensingServiceMockCallbackBuilder.addHeatIndex(index, property, responseCode, delay, value);
            return this;
        }

        /**
         * @see org.im97mori.ble.service.ess.peripheral.EnvironmentalSensingServiceMockCallback.Builder#removeHeatIndex(int)
         */
        @NonNull
        public Builder<T> removeHeatIndex(int index) {
            mEnvironmentalSensingServiceMockCallbackBuilder.removeHeatIndex(index);
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
         * @see org.im97mori.ble.service.ess.peripheral.EnvironmentalSensingServiceMockCallback.Builder#setHeatIndexEsMeasurement(int, int, long, byte[])
         */
        @NonNull
        public Builder<T> setHeatIndexEsMeasurement(int index, int responseCode, long delay, @NonNull byte[] value) {
            mEnvironmentalSensingServiceMockCallbackBuilder.setHeatIndexEsMeasurement(index, responseCode, delay, value);
            return this;
        }

        /**
         * @see org.im97mori.ble.service.ess.peripheral.EnvironmentalSensingServiceMockCallback.Builder#removeHeatIndexEsMeasurement(int)
         */
        @NonNull
        public Builder<T> removeHeatIndexEsMeasurement(int index) {
            mEnvironmentalSensingServiceMockCallbackBuilder.removeHeatIndexEsMeasurement(index);
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
         * @see org.im97mori.ble.service.ess.peripheral.EnvironmentalSensingServiceMockCallback.Builder#setHeatIndexEsTriggerSetting(int, int, int, int, long, byte[])
         */
        @NonNull
        public Builder<T> setHeatIndexEsTriggerSetting(int characteristicIndex, int descriptorIndex, int permission, int responseCode, long delay, @NonNull byte[] value) {
            mEnvironmentalSensingServiceMockCallbackBuilder.setHeatIndexEsTriggerSetting(characteristicIndex, descriptorIndex, permission, responseCode, delay, value);
            return this;
        }

        /**
         * @see org.im97mori.ble.service.ess.peripheral.EnvironmentalSensingServiceMockCallback.Builder#removeHeatIndexEsTriggerSetting(int, int)
         */
        @NonNull
        public Builder<T> removeHeatIndexEsTriggerSetting(int characteristicIndex, int descriptorIndex) {
            mEnvironmentalSensingServiceMockCallbackBuilder.removeHeatIndexEsTriggerSetting(characteristicIndex, descriptorIndex);
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
         * @see org.im97mori.ble.service.ess.peripheral.EnvironmentalSensingServiceMockCallback.Builder#setHeatIndexEsConfiguration(int, int, int, long, byte[])
         */
        @NonNull
        public Builder<T> setHeatIndexEsConfiguration(int index, int permission, int responseCode, long delay, @NonNull byte[] value) {
            mEnvironmentalSensingServiceMockCallbackBuilder.setHeatIndexEsConfiguration(index, permission, responseCode, delay, value);
            return this;
        }

        /**
         * @see org.im97mori.ble.service.ess.peripheral.EnvironmentalSensingServiceMockCallback.Builder#removeHeatIndexEsConfiguration(int)
         */
        @NonNull
        public Builder<T> removeHeatIndexEsConfiguration(int index) {
            mEnvironmentalSensingServiceMockCallbackBuilder.removeHeatIndexEsConfiguration(index);
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
         * @see org.im97mori.ble.service.ess.peripheral.EnvironmentalSensingServiceMockCallback.Builder#addHumidity(int, int, int, long, byte[])
         */
        @NonNull
        public Builder<T> addHumidity(int index, int property, int responseCode, long delay, @NonNull byte[] value) {
            mEnvironmentalSensingServiceMockCallbackBuilder.addHumidity(index, property, responseCode, delay, value);
            return this;
        }

        /**
         * @see org.im97mori.ble.service.ess.peripheral.EnvironmentalSensingServiceMockCallback.Builder#removeHumidity(int)
         */
        @NonNull
        public Builder<T> removeHumidity(int index) {
            mEnvironmentalSensingServiceMockCallbackBuilder.removeHumidity(index);
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
         * @see org.im97mori.ble.service.ess.peripheral.EnvironmentalSensingServiceMockCallback.Builder#setHumidityEsMeasurement(int, int, long, byte[])
         */
        @NonNull
        public Builder<T> setHumidityEsMeasurement(int index, int responseCode, long delay, @NonNull byte[] value) {
            mEnvironmentalSensingServiceMockCallbackBuilder.setHumidityEsMeasurement(index, responseCode, delay, value);
            return this;
        }

        /**
         * @see org.im97mori.ble.service.ess.peripheral.EnvironmentalSensingServiceMockCallback.Builder#removeHumidityEsMeasurement(int)
         */
        @NonNull
        public Builder<T> removeHumidityEsMeasurement(int index) {
            mEnvironmentalSensingServiceMockCallbackBuilder.removeHumidityEsMeasurement(index);
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
         * @see org.im97mori.ble.service.ess.peripheral.EnvironmentalSensingServiceMockCallback.Builder#setHumidityEsTriggerSetting(int, int, int, int, long, byte[])
         */
        @NonNull
        public Builder<T> setHumidityEsTriggerSetting(int characteristicIndex, int descriptorIndex, int permission, int responseCode, long delay, @NonNull byte[] value) {
            mEnvironmentalSensingServiceMockCallbackBuilder.setHumidityEsTriggerSetting(characteristicIndex, descriptorIndex, permission, responseCode, delay, value);
            return this;
        }

        /**
         * @see org.im97mori.ble.service.ess.peripheral.EnvironmentalSensingServiceMockCallback.Builder#removeHumidityEsTriggerSetting(int, int)
         */
        @NonNull
        public Builder<T> removeHumidityEsTriggerSetting(int characteristicIndex, int descriptorIndex) {
            mEnvironmentalSensingServiceMockCallbackBuilder.removeHumidityEsTriggerSetting(characteristicIndex, descriptorIndex);
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
         * @see org.im97mori.ble.service.ess.peripheral.EnvironmentalSensingServiceMockCallback.Builder#setHumidityEsConfiguration(int, int, int, long, byte[])
         */
        @NonNull
        public Builder<T> setHumidityEsConfiguration(int index, int permission, int responseCode, long delay, @NonNull byte[] value) {
            mEnvironmentalSensingServiceMockCallbackBuilder.setHumidityEsConfiguration(index, permission, responseCode, delay, value);
            return this;
        }

        /**
         * @see org.im97mori.ble.service.ess.peripheral.EnvironmentalSensingServiceMockCallback.Builder#removeHumidityEsConfiguration(int)
         */
        @NonNull
        public Builder<T> removeHumidityEsConfiguration(int index) {
            mEnvironmentalSensingServiceMockCallbackBuilder.removeHumidityEsConfiguration(index);
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
         * @see org.im97mori.ble.service.ess.peripheral.EnvironmentalSensingServiceMockCallback.Builder#setHumidityCharacteristicUserDescription(int, int, long, byte[])
         */
        @NonNull
        public Builder<T> setHumidityCharacteristicUserDescription(int index, int responseCode, long delay, @NonNull byte[] value) {
            mEnvironmentalSensingServiceMockCallbackBuilder.setHumidityCharacteristicUserDescription(index, responseCode, delay, value);
            return this;
        }

        /**
         * @see org.im97mori.ble.service.ess.peripheral.EnvironmentalSensingServiceMockCallback.Builder#removeHumidityCharacteristicUserDescription(int)
         */
        @NonNull
        public Builder<T> removeHumidityCharacteristicUserDescription(int index) {
            mEnvironmentalSensingServiceMockCallbackBuilder.removeHumidityCharacteristicUserDescription(index);
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
         * @see org.im97mori.ble.service.ess.peripheral.EnvironmentalSensingServiceMockCallback.Builder#setHumidityValidRange(int, int, long, byte[])
         */
        @NonNull
        public Builder<T> setHumidityValidRange(int index, int responseCode, long delay, @NonNull byte[] value) {
            mEnvironmentalSensingServiceMockCallbackBuilder.setHumidityValidRange(index, responseCode, delay, value);
            return this;
        }

        /**
         * @see org.im97mori.ble.service.ess.peripheral.EnvironmentalSensingServiceMockCallback.Builder#removeHumidityValidRange(int)
         */
        @NonNull
        public Builder<T> removeHumidityValidRange(int index) {
            mEnvironmentalSensingServiceMockCallbackBuilder.removeHumidityValidRange(index);
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
         * @see org.im97mori.ble.service.ess.peripheral.EnvironmentalSensingServiceMockCallback.Builder#setHeatIndexCharacteristicUserDescription(int, int, long, byte[])
         */
        @NonNull
        public Builder<T> setHeatIndexCharacteristicUserDescription(int index, int responseCode, long delay, @NonNull byte[] value) {
            mEnvironmentalSensingServiceMockCallbackBuilder.setHeatIndexCharacteristicUserDescription(index, responseCode, delay, value);
            return this;
        }

        /**
         * @see org.im97mori.ble.service.ess.peripheral.EnvironmentalSensingServiceMockCallback.Builder#removeHeatIndexCharacteristicUserDescription(int)
         */
        @NonNull
        public Builder<T> removeHeatIndexCharacteristicUserDescription(int index) {
            mEnvironmentalSensingServiceMockCallbackBuilder.removeHeatIndexCharacteristicUserDescription(index);
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
         * @see org.im97mori.ble.service.ess.peripheral.EnvironmentalSensingServiceMockCallback.Builder#setHeatIndexValidRange(int, int, long, byte[])
         */
        @NonNull
        public Builder<T> setHeatIndexValidRange(int index, int responseCode, long delay, @NonNull byte[] value) {
            mEnvironmentalSensingServiceMockCallbackBuilder.setHeatIndexValidRange(index, responseCode, delay, value);
            return this;
        }

        /**
         * @see org.im97mori.ble.service.ess.peripheral.EnvironmentalSensingServiceMockCallback.Builder#removeHeatIndexValidRange(int)
         */
        @NonNull
        public Builder<T> removeHeatIndexValidRange(int index) {
            mEnvironmentalSensingServiceMockCallbackBuilder.removeHeatIndexValidRange(index);
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
         * @see org.im97mori.ble.service.ess.peripheral.EnvironmentalSensingServiceMockCallback.Builder#addIrradiance(int, int, int, long, byte[])
         */
        @NonNull
        public Builder<T> addIrradiance(int index, int property, int responseCode, long delay, @NonNull byte[] value) {
            mEnvironmentalSensingServiceMockCallbackBuilder.addIrradiance(index, property, responseCode, delay, value);
            return this;
        }

        /**
         * @see org.im97mori.ble.service.ess.peripheral.EnvironmentalSensingServiceMockCallback.Builder#removeIrradiance(int)
         */
        @NonNull
        public Builder<T> removeIrradiance(int index) {
            mEnvironmentalSensingServiceMockCallbackBuilder.removeIrradiance(index);
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
         * @see org.im97mori.ble.service.ess.peripheral.EnvironmentalSensingServiceMockCallback.Builder#setIrradianceEsMeasurement(int, int, long, byte[])
         */
        @NonNull
        public Builder<T> setIrradianceEsMeasurement(int index, int responseCode, long delay, @NonNull byte[] value) {
            mEnvironmentalSensingServiceMockCallbackBuilder.setIrradianceEsMeasurement(index, responseCode, delay, value);
            return this;
        }

        /**
         * @see org.im97mori.ble.service.ess.peripheral.EnvironmentalSensingServiceMockCallback.Builder#removeIrradianceEsMeasurement(int)
         */
        @NonNull
        public Builder<T> removeIrradianceEsMeasurement(int index) {
            mEnvironmentalSensingServiceMockCallbackBuilder.removeIrradianceEsMeasurement(index);
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
         * @see org.im97mori.ble.service.ess.peripheral.EnvironmentalSensingServiceMockCallback.Builder#setIrradianceEsTriggerSetting(int, int, int, int, long, byte[])
         */
        @NonNull
        public Builder<T> setIrradianceEsTriggerSetting(int characteristicIndex, int descriptorIndex, int permission, int responseCode, long delay, @NonNull byte[] value) {
            mEnvironmentalSensingServiceMockCallbackBuilder.setIrradianceEsTriggerSetting(characteristicIndex, descriptorIndex, permission, responseCode, delay, value);
            return this;
        }

        /**
         * @see org.im97mori.ble.service.ess.peripheral.EnvironmentalSensingServiceMockCallback.Builder#removeIrradianceEsTriggerSetting(int, int)
         */
        @NonNull
        public Builder<T> removeIrradianceEsTriggerSetting(int characteristicIndex, int descriptorIndex) {
            mEnvironmentalSensingServiceMockCallbackBuilder.removeIrradianceEsTriggerSetting(characteristicIndex, descriptorIndex);
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
         * @see org.im97mori.ble.service.ess.peripheral.EnvironmentalSensingServiceMockCallback.Builder#setIrradianceEsConfiguration(int, int, int, long, byte[])
         */
        @NonNull
        public Builder<T> setIrradianceEsConfiguration(int index, int permission, int responseCode, long delay, @NonNull byte[] value) {
            mEnvironmentalSensingServiceMockCallbackBuilder.setIrradianceEsConfiguration(index, permission, responseCode, delay, value);
            return this;
        }

        /**
         * @see org.im97mori.ble.service.ess.peripheral.EnvironmentalSensingServiceMockCallback.Builder#removeIrradianceEsConfiguration(int)
         */
        @NonNull
        public Builder<T> removeIrradianceEsConfiguration(int index) {
            mEnvironmentalSensingServiceMockCallbackBuilder.removeIrradianceEsConfiguration(index);
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
         * @see org.im97mori.ble.service.ess.peripheral.EnvironmentalSensingServiceMockCallback.Builder#setIrradianceCharacteristicUserDescription(int, int, long, byte[])
         */
        @NonNull
        public Builder<T> setIrradianceCharacteristicUserDescription(int index, int responseCode, long delay, @NonNull byte[] value) {
            mEnvironmentalSensingServiceMockCallbackBuilder.setIrradianceCharacteristicUserDescription(index, responseCode, delay, value);
            return this;
        }

        /**
         * @see org.im97mori.ble.service.ess.peripheral.EnvironmentalSensingServiceMockCallback.Builder#removeIrradianceCharacteristicUserDescription(int)
         */
        @NonNull
        public Builder<T> removeIrradianceCharacteristicUserDescription(int index) {
            mEnvironmentalSensingServiceMockCallbackBuilder.removeIrradianceCharacteristicUserDescription(index);
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
         * @see org.im97mori.ble.service.ess.peripheral.EnvironmentalSensingServiceMockCallback.Builder#setIrradianceValidRange(int, int, long, byte[])
         */
        @NonNull
        public Builder<T> setIrradianceValidRange(int index, int responseCode, long delay, @NonNull byte[] value) {
            mEnvironmentalSensingServiceMockCallbackBuilder.setIrradianceValidRange(index, responseCode, delay, value);
            return this;
        }

        /**
         * @see org.im97mori.ble.service.ess.peripheral.EnvironmentalSensingServiceMockCallback.Builder#removeIrradianceValidRange(int)
         */
        @NonNull
        public Builder<T> removeIrradianceValidRange(int index) {
            mEnvironmentalSensingServiceMockCallbackBuilder.removeIrradianceValidRange(index);
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
         * @see org.im97mori.ble.service.ess.peripheral.EnvironmentalSensingServiceMockCallback.Builder#addPollenConcentration(int, int, int, long, byte[])
         */
        @NonNull
        public Builder<T> addPollenConcentration(int index, int property, int responseCode, long delay, @NonNull byte[] value) {
            mEnvironmentalSensingServiceMockCallbackBuilder.addPollenConcentration(index, property, responseCode, delay, value);
            return this;
        }

        /**
         * @see org.im97mori.ble.service.ess.peripheral.EnvironmentalSensingServiceMockCallback.Builder#removePollenConcentration(int)
         */
        @NonNull
        public Builder<T> removePollenConcentration(int index) {
            mEnvironmentalSensingServiceMockCallbackBuilder.removePollenConcentration(index);
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
         * @see org.im97mori.ble.service.ess.peripheral.EnvironmentalSensingServiceMockCallback.Builder#setPollenConcentrationEsMeasurement(int, int, long, byte[])
         */
        @NonNull
        public Builder<T> setPollenConcentrationEsMeasurement(int index, int responseCode, long delay, @NonNull byte[] value) {
            mEnvironmentalSensingServiceMockCallbackBuilder.setPollenConcentrationEsMeasurement(index, responseCode, delay, value);
            return this;
        }

        /**
         * @see org.im97mori.ble.service.ess.peripheral.EnvironmentalSensingServiceMockCallback.Builder#removePollenConcentrationEsMeasurement(int)
         */
        @NonNull
        public Builder<T> removePollenConcentrationEsMeasurement(int index) {
            mEnvironmentalSensingServiceMockCallbackBuilder.removePollenConcentrationEsMeasurement(index);
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
         * @see org.im97mori.ble.service.ess.peripheral.EnvironmentalSensingServiceMockCallback.Builder#setPollenConcentrationEsTriggerSetting(int, int, int, int, long, byte[])
         */
        @NonNull
        public Builder<T> setPollenConcentrationEsTriggerSetting(int characteristicIndex, int descriptorIndex, int permission, int responseCode, long delay, @NonNull byte[] value) {
            mEnvironmentalSensingServiceMockCallbackBuilder.setPollenConcentrationEsTriggerSetting(characteristicIndex, descriptorIndex, permission, responseCode, delay, value);
            return this;
        }

        /**
         * @see org.im97mori.ble.service.ess.peripheral.EnvironmentalSensingServiceMockCallback.Builder#removePollenConcentrationEsTriggerSetting(int, int)
         */
        @NonNull
        public Builder<T> removePollenConcentrationEsTriggerSetting(int characteristicIndex, int descriptorIndex) {
            mEnvironmentalSensingServiceMockCallbackBuilder.removePollenConcentrationEsTriggerSetting(characteristicIndex, descriptorIndex);
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
         * @see org.im97mori.ble.service.ess.peripheral.EnvironmentalSensingServiceMockCallback.Builder#setPollenConcentrationEsConfiguration(int, int, int, long, byte[])
         */
        @NonNull
        public Builder<T> setPollenConcentrationEsConfiguration(int index, int permission, int responseCode, long delay, @NonNull byte[] value) {
            mEnvironmentalSensingServiceMockCallbackBuilder.setPollenConcentrationEsConfiguration(index, permission, responseCode, delay, value);
            return this;
        }

        /**
         * @see org.im97mori.ble.service.ess.peripheral.EnvironmentalSensingServiceMockCallback.Builder#removePollenConcentrationEsConfiguration(int)
         */
        @NonNull
        public Builder<T> removePollenConcentrationEsConfiguration(int index) {
            mEnvironmentalSensingServiceMockCallbackBuilder.removePollenConcentrationEsConfiguration(index);
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
         * @see org.im97mori.ble.service.ess.peripheral.EnvironmentalSensingServiceMockCallback.Builder#setPollenConcentrationCharacteristicUserDescription(int, int, long, byte[])
         */
        @NonNull
        public Builder<T> setPollenConcentrationCharacteristicUserDescription(int index, int responseCode, long delay, @NonNull byte[] value) {
            mEnvironmentalSensingServiceMockCallbackBuilder.setPollenConcentrationCharacteristicUserDescription(index, responseCode, delay, value);
            return this;
        }

        /**
         * @see org.im97mori.ble.service.ess.peripheral.EnvironmentalSensingServiceMockCallback.Builder#removePollenConcentrationCharacteristicUserDescription(int)
         */
        @NonNull
        public Builder<T> removePollenConcentrationCharacteristicUserDescription(int index) {
            mEnvironmentalSensingServiceMockCallbackBuilder.removePollenConcentrationCharacteristicUserDescription(index);
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
         * @see org.im97mori.ble.service.ess.peripheral.EnvironmentalSensingServiceMockCallback.Builder#setPollenConcentrationValidRange(int, int, long, byte[])
         */
        @NonNull
        public Builder<T> setPollenConcentrationValidRange(int index, int responseCode, long delay, @NonNull byte[] value) {
            mEnvironmentalSensingServiceMockCallbackBuilder.setPollenConcentrationValidRange(index, responseCode, delay, value);
            return this;
        }

        /**
         * @see org.im97mori.ble.service.ess.peripheral.EnvironmentalSensingServiceMockCallback.Builder#removePollenConcentrationValidRange(int)
         */
        @NonNull
        public Builder<T> removePollenConcentrationValidRange(int index) {
            mEnvironmentalSensingServiceMockCallbackBuilder.removePollenConcentrationValidRange(index);
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
         * @see org.im97mori.ble.service.ess.peripheral.EnvironmentalSensingServiceMockCallback.Builder#addRainfall(int, int, int, long, byte[])
         */
        @NonNull
        public Builder<T> addRainfall(int index, int property, int responseCode, long delay, @NonNull byte[] value) {
            mEnvironmentalSensingServiceMockCallbackBuilder.addRainfall(index, property, responseCode, delay, value);
            return this;
        }

        /**
         * @see org.im97mori.ble.service.ess.peripheral.EnvironmentalSensingServiceMockCallback.Builder#removeRainfall(int)
         */
        @NonNull
        public Builder<T> removeRainfall(int index) {
            mEnvironmentalSensingServiceMockCallbackBuilder.removeRainfall(index);
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
         * @see org.im97mori.ble.service.ess.peripheral.EnvironmentalSensingServiceMockCallback.Builder#setRainfallEsMeasurement(int, int, long, byte[])
         */
        @NonNull
        public Builder<T> setRainfallEsMeasurement(int index, int responseCode, long delay, @NonNull byte[] value) {
            mEnvironmentalSensingServiceMockCallbackBuilder.setRainfallEsMeasurement(index, responseCode, delay, value);
            return this;
        }

        /**
         * @see org.im97mori.ble.service.ess.peripheral.EnvironmentalSensingServiceMockCallback.Builder#removeRainfallEsMeasurement(int)
         */
        @NonNull
        public Builder<T> removeRainfallEsMeasurement(int index) {
            mEnvironmentalSensingServiceMockCallbackBuilder.removeRainfallEsMeasurement(index);
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
         * @see org.im97mori.ble.service.ess.peripheral.EnvironmentalSensingServiceMockCallback.Builder#setRainfallEsTriggerSetting(int, int, int, int, long, byte[])
         */
        @NonNull
        public Builder<T> setRainfallEsTriggerSetting(int characteristicIndex, int descriptorIndex, int permission, int responseCode, long delay, @NonNull byte[] value) {
            mEnvironmentalSensingServiceMockCallbackBuilder.setRainfallEsTriggerSetting(characteristicIndex, descriptorIndex, permission, responseCode, delay, value);
            return this;
        }

        /**
         * @see org.im97mori.ble.service.ess.peripheral.EnvironmentalSensingServiceMockCallback.Builder#removeRainfallEsTriggerSetting(int, int)
         */
        @NonNull
        public Builder<T> removeRainfallEsTriggerSetting(int characteristicIndex, int descriptorIndex) {
            mEnvironmentalSensingServiceMockCallbackBuilder.removeRainfallEsTriggerSetting(characteristicIndex, descriptorIndex);
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
         * @see org.im97mori.ble.service.ess.peripheral.EnvironmentalSensingServiceMockCallback.Builder#setRainfallEsConfiguration(int, int, int, long, byte[])
         */
        @NonNull
        public Builder<T> setRainfallEsConfiguration(int index, int permission, int responseCode, long delay, @NonNull byte[] value) {
            mEnvironmentalSensingServiceMockCallbackBuilder.setRainfallEsConfiguration(index, permission, responseCode, delay, value);
            return this;
        }

        /**
         * @see org.im97mori.ble.service.ess.peripheral.EnvironmentalSensingServiceMockCallback.Builder#removeRainfallEsConfiguration(int)
         */
        @NonNull
        public Builder<T> removeRainfallEsConfiguration(int index) {
            mEnvironmentalSensingServiceMockCallbackBuilder.removeRainfallEsConfiguration(index);
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
         * @see org.im97mori.ble.service.ess.peripheral.EnvironmentalSensingServiceMockCallback.Builder#setRainfallCharacteristicUserDescription(int, int, long, byte[])
         */
        @NonNull
        public Builder<T> setRainfallCharacteristicUserDescription(int index, int responseCode, long delay, @NonNull byte[] value) {
            mEnvironmentalSensingServiceMockCallbackBuilder.setRainfallCharacteristicUserDescription(index, responseCode, delay, value);
            return this;
        }

        /**
         * @see org.im97mori.ble.service.ess.peripheral.EnvironmentalSensingServiceMockCallback.Builder#removeRainfallCharacteristicUserDescription(int)
         */
        @NonNull
        public Builder<T> removeRainfallCharacteristicUserDescription(int index) {
            mEnvironmentalSensingServiceMockCallbackBuilder.removeRainfallCharacteristicUserDescription(index);
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
         * @see org.im97mori.ble.service.ess.peripheral.EnvironmentalSensingServiceMockCallback.Builder#setRainfallValidRange(int, int, long, byte[])
         */
        @NonNull
        public Builder<T> setRainfallValidRange(int index, int responseCode, long delay, @NonNull byte[] value) {
            mEnvironmentalSensingServiceMockCallbackBuilder.setRainfallValidRange(index, responseCode, delay, value);
            return this;
        }

        /**
         * @see org.im97mori.ble.service.ess.peripheral.EnvironmentalSensingServiceMockCallback.Builder#removeRainfallValidRange(int)
         */
        @NonNull
        public Builder<T> removeRainfallValidRange(int index) {
            mEnvironmentalSensingServiceMockCallbackBuilder.removeRainfallValidRange(index);
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
         * @see org.im97mori.ble.service.ess.peripheral.EnvironmentalSensingServiceMockCallback.Builder#addPressure(int, int, int, long, byte[])
         */
        @NonNull
        public Builder<T> addPressure(int index, int property, int responseCode, long delay, @NonNull byte[] value) {
            mEnvironmentalSensingServiceMockCallbackBuilder.addPressure(index, property, responseCode, delay, value);
            return this;
        }

        /**
         * @see org.im97mori.ble.service.ess.peripheral.EnvironmentalSensingServiceMockCallback.Builder#removePressure(int)
         */
        @NonNull
        public Builder<T> removePressure(int index) {
            mEnvironmentalSensingServiceMockCallbackBuilder.removePressure(index);
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
         * @see org.im97mori.ble.service.ess.peripheral.EnvironmentalSensingServiceMockCallback.Builder#setPressureEsMeasurement(int, int, long, byte[])
         */
        @NonNull
        public Builder<T> setPressureEsMeasurement(int index, int responseCode, long delay, @NonNull byte[] value) {
            mEnvironmentalSensingServiceMockCallbackBuilder.setPressureEsMeasurement(index, responseCode, delay, value);
            return this;
        }

        /**
         * @see org.im97mori.ble.service.ess.peripheral.EnvironmentalSensingServiceMockCallback.Builder#removePressureEsMeasurement(int)
         */
        @NonNull
        public Builder<T> removePressureEsMeasurement(int index) {
            mEnvironmentalSensingServiceMockCallbackBuilder.removePressureEsMeasurement(index);
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
         * @see org.im97mori.ble.service.ess.peripheral.EnvironmentalSensingServiceMockCallback.Builder#setPressureEsTriggerSetting(int, int, int, int, long, byte[])
         */
        @NonNull
        public Builder<T> setPressureEsTriggerSetting(int characteristicIndex, int descriptorIndex, int permission, int responseCode, long delay, @NonNull byte[] value) {
            mEnvironmentalSensingServiceMockCallbackBuilder.setPressureEsTriggerSetting(characteristicIndex, descriptorIndex, permission, responseCode, delay, value);
            return this;
        }

        /**
         * @see org.im97mori.ble.service.ess.peripheral.EnvironmentalSensingServiceMockCallback.Builder#removePressureEsTriggerSetting(int, int)
         */
        @NonNull
        public Builder<T> removePressureEsTriggerSetting(int characteristicIndex, int descriptorIndex) {
            mEnvironmentalSensingServiceMockCallbackBuilder.removePressureEsTriggerSetting(characteristicIndex, descriptorIndex);
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
         * @see org.im97mori.ble.service.ess.peripheral.EnvironmentalSensingServiceMockCallback.Builder#setPressureEsConfiguration(int, int, int, long, byte[])
         */
        @NonNull
        public Builder<T> setPressureEsConfiguration(int index, int permission, int responseCode, long delay, @NonNull byte[] value) {
            mEnvironmentalSensingServiceMockCallbackBuilder.setPressureEsConfiguration(index, permission, responseCode, delay, value);
            return this;
        }

        /**
         * @see org.im97mori.ble.service.ess.peripheral.EnvironmentalSensingServiceMockCallback.Builder#removePressureEsConfiguration(int)
         */
        @NonNull
        public Builder<T> removePressureEsConfiguration(int index) {
            mEnvironmentalSensingServiceMockCallbackBuilder.removePressureEsConfiguration(index);
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
         * @see org.im97mori.ble.service.ess.peripheral.EnvironmentalSensingServiceMockCallback.Builder#setPressureCharacteristicUserDescription(int, int, long, byte[])
         */
        @NonNull
        public Builder<T> setPressureCharacteristicUserDescription(int index, int responseCode, long delay, @NonNull byte[] value) {
            mEnvironmentalSensingServiceMockCallbackBuilder.setPressureCharacteristicUserDescription(index, responseCode, delay, value);
            return this;
        }

        /**
         * @see org.im97mori.ble.service.ess.peripheral.EnvironmentalSensingServiceMockCallback.Builder#removePressureCharacteristicUserDescription(int)
         */
        @NonNull
        public Builder<T> removePressureCharacteristicUserDescription(int index) {
            mEnvironmentalSensingServiceMockCallbackBuilder.removePressureCharacteristicUserDescription(index);
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
         * @see org.im97mori.ble.service.ess.peripheral.EnvironmentalSensingServiceMockCallback.Builder#setPressureValidRange(int, int, long, byte[])
         */
        @NonNull
        public Builder<T> setPressureValidRange(int index, int responseCode, long delay, @NonNull byte[] value) {
            mEnvironmentalSensingServiceMockCallbackBuilder.setPressureValidRange(index, responseCode, delay, value);
            return this;
        }

        /**
         * @see org.im97mori.ble.service.ess.peripheral.EnvironmentalSensingServiceMockCallback.Builder#removePressureValidRange(int)
         */
        @NonNull
        public Builder<T> removePressureValidRange(int index) {
            mEnvironmentalSensingServiceMockCallbackBuilder.removePressureValidRange(index);
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
         * @see org.im97mori.ble.service.ess.peripheral.EnvironmentalSensingServiceMockCallback.Builder#addTemperature(int, int, int, long, byte[])
         */
        @NonNull
        public Builder<T> addTemperature(int index, int property, int responseCode, long delay, @NonNull byte[] value) {
            mEnvironmentalSensingServiceMockCallbackBuilder.addTemperature(index, property, responseCode, delay, value);
            return this;
        }

        /**
         * @see org.im97mori.ble.service.ess.peripheral.EnvironmentalSensingServiceMockCallback.Builder#removeTemperature(int)
         */
        @NonNull
        public Builder<T> removeTemperature(int index) {
            mEnvironmentalSensingServiceMockCallbackBuilder.removeTemperature(index);
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
         * @see org.im97mori.ble.service.ess.peripheral.EnvironmentalSensingServiceMockCallback.Builder#setTemperatureEsMeasurement(int, int, long, byte[])
         */
        @NonNull
        public Builder<T> setTemperatureEsMeasurement(int index, int responseCode, long delay, @NonNull byte[] value) {
            mEnvironmentalSensingServiceMockCallbackBuilder.setTemperatureEsMeasurement(index, responseCode, delay, value);
            return this;
        }

        /**
         * @see org.im97mori.ble.service.ess.peripheral.EnvironmentalSensingServiceMockCallback.Builder#removeTemperatureEsMeasurement(int)
         */
        @NonNull
        public Builder<T> removeTemperatureEsMeasurement(int index) {
            mEnvironmentalSensingServiceMockCallbackBuilder.removeTemperatureEsMeasurement(index);
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
         * @see org.im97mori.ble.service.ess.peripheral.EnvironmentalSensingServiceMockCallback.Builder#setTemperatureEsTriggerSetting(int, int, int, int, long, byte[])
         */
        @NonNull
        public Builder<T> setTemperatureEsTriggerSetting(int characteristicIndex, int descriptorIndex, int permission, int responseCode, long delay, @NonNull byte[] value) {
            mEnvironmentalSensingServiceMockCallbackBuilder.setTemperatureEsTriggerSetting(characteristicIndex, descriptorIndex, permission, responseCode, delay, value);
            return this;
        }

        /**
         * @see org.im97mori.ble.service.ess.peripheral.EnvironmentalSensingServiceMockCallback.Builder#removeTemperatureEsTriggerSetting(int, int)
         */
        @NonNull
        public Builder<T> removeTemperatureEsTriggerSetting(int characteristicIndex, int descriptorIndex) {
            mEnvironmentalSensingServiceMockCallbackBuilder.removeTemperatureEsTriggerSetting(characteristicIndex, descriptorIndex);
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
         * @see org.im97mori.ble.service.ess.peripheral.EnvironmentalSensingServiceMockCallback.Builder#setTemperatureEsConfiguration(int, int, int, long, byte[])
         */
        @NonNull
        public Builder<T> setTemperatureEsConfiguration(int index, int permission, int responseCode, long delay, @NonNull byte[] value) {
            mEnvironmentalSensingServiceMockCallbackBuilder.setTemperatureEsConfiguration(index, permission, responseCode, delay, value);
            return this;
        }

        /**
         * @see org.im97mori.ble.service.ess.peripheral.EnvironmentalSensingServiceMockCallback.Builder#removeTemperatureEsConfiguration(int)
         */
        @NonNull
        public Builder<T> removeTemperatureEsConfiguration(int index) {
            mEnvironmentalSensingServiceMockCallbackBuilder.removeTemperatureEsConfiguration(index);
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
         * @see org.im97mori.ble.service.ess.peripheral.EnvironmentalSensingServiceMockCallback.Builder#setTemperatureCharacteristicUserDescription(int, int, long, byte[])
         */
        @NonNull
        public Builder<T> setTemperatureCharacteristicUserDescription(int index, int responseCode, long delay, @NonNull byte[] value) {
            mEnvironmentalSensingServiceMockCallbackBuilder.setTemperatureCharacteristicUserDescription(index, responseCode, delay, value);
            return this;
        }

        /**
         * @see org.im97mori.ble.service.ess.peripheral.EnvironmentalSensingServiceMockCallback.Builder#removeTemperatureCharacteristicUserDescription(int)
         */
        @NonNull
        public Builder<T> removeTemperatureCharacteristicUserDescription(int index) {
            mEnvironmentalSensingServiceMockCallbackBuilder.removeTemperatureCharacteristicUserDescription(index);
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
         * @see org.im97mori.ble.service.ess.peripheral.EnvironmentalSensingServiceMockCallback.Builder#setTemperatureValidRange(int, int, long, byte[])
         */
        @NonNull
        public Builder<T> setTemperatureValidRange(int index, int responseCode, long delay, @NonNull byte[] value) {
            mEnvironmentalSensingServiceMockCallbackBuilder.setTemperatureValidRange(index, responseCode, delay, value);
            return this;
        }

        /**
         * @see org.im97mori.ble.service.ess.peripheral.EnvironmentalSensingServiceMockCallback.Builder#removeTemperatureValidRange(int)
         */
        @NonNull
        public Builder<T> removeTemperatureValidRange(int index) {
            mEnvironmentalSensingServiceMockCallbackBuilder.removeTemperatureValidRange(index);
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
         * @see org.im97mori.ble.service.ess.peripheral.EnvironmentalSensingServiceMockCallback.Builder#addTrueWindDirection(int, int, int, long, byte[])
         */
        @NonNull
        public Builder<T> addTrueWindDirection(int index, int property, int responseCode, long delay, @NonNull byte[] value) {
            mEnvironmentalSensingServiceMockCallbackBuilder.addTrueWindDirection(index, property, responseCode, delay, value);
            return this;
        }

        /**
         * @see org.im97mori.ble.service.ess.peripheral.EnvironmentalSensingServiceMockCallback.Builder#removeTrueWindDirection(int)
         */
        @NonNull
        public Builder<T> removeTrueWindDirection(int index) {
            mEnvironmentalSensingServiceMockCallbackBuilder.removeTrueWindDirection(index);
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
         * @see org.im97mori.ble.service.ess.peripheral.EnvironmentalSensingServiceMockCallback.Builder#setTrueWindDirectionEsMeasurement(int, int, long, byte[])
         */
        @NonNull
        public Builder<T> setTrueWindDirectionEsMeasurement(int index, int responseCode, long delay, @NonNull byte[] value) {
            mEnvironmentalSensingServiceMockCallbackBuilder.setTrueWindDirectionEsMeasurement(index, responseCode, delay, value);
            return this;
        }

        /**
         * @see org.im97mori.ble.service.ess.peripheral.EnvironmentalSensingServiceMockCallback.Builder#removeTrueWindDirectionEsMeasurement(int)
         */
        @NonNull
        public Builder<T> removeTrueWindDirectionEsMeasurement(int index) {
            mEnvironmentalSensingServiceMockCallbackBuilder.removeTrueWindDirectionEsMeasurement(index);
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
         * @see org.im97mori.ble.service.ess.peripheral.EnvironmentalSensingServiceMockCallback.Builder#setTrueWindDirectionEsTriggerSetting(int, int, int, int, long, byte[])
         */
        @NonNull
        public Builder<T> setTrueWindDirectionEsTriggerSetting(int characteristicIndex, int descriptorIndex, int permission, int responseCode, long delay, @NonNull byte[] value) {
            mEnvironmentalSensingServiceMockCallbackBuilder.setTrueWindDirectionEsTriggerSetting(characteristicIndex, descriptorIndex, permission, responseCode, delay, value);
            return this;
        }

        /**
         * @see org.im97mori.ble.service.ess.peripheral.EnvironmentalSensingServiceMockCallback.Builder#removeTrueWindDirectionEsTriggerSetting(int, int)
         */
        @NonNull
        public Builder<T> removeTrueWindDirectionEsTriggerSetting(int characteristicIndex, int descriptorIndex) {
            mEnvironmentalSensingServiceMockCallbackBuilder.removeTrueWindDirectionEsTriggerSetting(characteristicIndex, descriptorIndex);
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
         * @see org.im97mori.ble.service.ess.peripheral.EnvironmentalSensingServiceMockCallback.Builder#setTrueWindDirectionEsConfiguration(int, int, int, long, byte[])
         */
        @NonNull
        public Builder<T> setTrueWindDirectionEsConfiguration(int index, int permission, int responseCode, long delay, @NonNull byte[] value) {
            mEnvironmentalSensingServiceMockCallbackBuilder.setTrueWindDirectionEsConfiguration(index, permission, responseCode, delay, value);
            return this;
        }

        /**
         * @see org.im97mori.ble.service.ess.peripheral.EnvironmentalSensingServiceMockCallback.Builder#removeTrueWindDirectionEsConfiguration(int)
         */
        @NonNull
        public Builder<T> removeTrueWindDirectionEsConfiguration(int index) {
            mEnvironmentalSensingServiceMockCallbackBuilder.removeTrueWindDirectionEsConfiguration(index);
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
         * @see org.im97mori.ble.service.ess.peripheral.EnvironmentalSensingServiceMockCallback.Builder#setTrueWindDirectionCharacteristicUserDescription(int, int, long, byte[])
         */
        @NonNull
        public Builder<T> setTrueWindDirectionCharacteristicUserDescription(int index, int responseCode, long delay, @NonNull byte[] value) {
            mEnvironmentalSensingServiceMockCallbackBuilder.setTrueWindDirectionCharacteristicUserDescription(index, responseCode, delay, value);
            return this;
        }

        /**
         * @see org.im97mori.ble.service.ess.peripheral.EnvironmentalSensingServiceMockCallback.Builder#removeTrueWindDirectionCharacteristicUserDescription(int)
         */
        @NonNull
        public Builder<T> removeTrueWindDirectionCharacteristicUserDescription(int index) {
            mEnvironmentalSensingServiceMockCallbackBuilder.removeTrueWindDirectionCharacteristicUserDescription(index);
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
         * @see org.im97mori.ble.service.ess.peripheral.EnvironmentalSensingServiceMockCallback.Builder#setTrueWindDirectionValidRange(int, int, long, byte[])
         */
        @NonNull
        public Builder<T> setTrueWindDirectionValidRange(int index, int responseCode, long delay, @NonNull byte[] value) {
            mEnvironmentalSensingServiceMockCallbackBuilder.setTrueWindDirectionValidRange(index, responseCode, delay, value);
            return this;
        }

        /**
         * @see org.im97mori.ble.service.ess.peripheral.EnvironmentalSensingServiceMockCallback.Builder#removeTrueWindDirectionValidRange(int)
         */
        @NonNull
        public Builder<T> removeTrueWindDirectionValidRange(int index) {
            mEnvironmentalSensingServiceMockCallbackBuilder.removeTrueWindDirectionValidRange(index);
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
         * @see org.im97mori.ble.service.ess.peripheral.EnvironmentalSensingServiceMockCallback.Builder#addTrueWindSpeed(int, int, int, long, byte[])
         */
        @NonNull
        public Builder<T> addTrueWindSpeed(int index, int property, int responseCode, long delay, @NonNull byte[] value) {
            mEnvironmentalSensingServiceMockCallbackBuilder.addTrueWindSpeed(index, property, responseCode, delay, value);
            return this;
        }

        /**
         * @see org.im97mori.ble.service.ess.peripheral.EnvironmentalSensingServiceMockCallback.Builder#removeTrueWindSpeed(int)
         */
        @NonNull
        public Builder<T> removeTrueWindSpeed(int index) {
            mEnvironmentalSensingServiceMockCallbackBuilder.removeTrueWindSpeed(index);
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
         * @see org.im97mori.ble.service.ess.peripheral.EnvironmentalSensingServiceMockCallback.Builder#setTrueWindSpeedEsMeasurement(int, int, long, byte[])
         */
        @NonNull
        public Builder<T> setTrueWindSpeedEsMeasurement(int index, int responseCode, long delay, @NonNull byte[] value) {
            mEnvironmentalSensingServiceMockCallbackBuilder.setTrueWindSpeedEsMeasurement(index, responseCode, delay, value);
            return this;
        }

        /**
         * @see org.im97mori.ble.service.ess.peripheral.EnvironmentalSensingServiceMockCallback.Builder#removeTrueWindSpeedEsMeasurement(int)
         */
        @NonNull
        public Builder<T> removeTrueWindSpeedEsMeasurement(int index) {
            mEnvironmentalSensingServiceMockCallbackBuilder.removeTrueWindSpeedEsMeasurement(index);
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
         * @see org.im97mori.ble.service.ess.peripheral.EnvironmentalSensingServiceMockCallback.Builder#setTrueWindSpeedEsTriggerSetting(int, int, int, int, long, byte[])
         */
        @NonNull
        public Builder<T> setTrueWindSpeedEsTriggerSetting(int characteristicIndex, int descriptorIndex, int permission, int responseCode, long delay, @NonNull byte[] value) {
            mEnvironmentalSensingServiceMockCallbackBuilder.setTrueWindSpeedEsTriggerSetting(characteristicIndex, descriptorIndex, permission, responseCode, delay, value);
            return this;
        }

        /**
         * @see org.im97mori.ble.service.ess.peripheral.EnvironmentalSensingServiceMockCallback.Builder#removeTrueWindSpeedEsTriggerSetting(int, int)
         */
        @NonNull
        public Builder<T> removeTrueWindSpeedEsTriggerSetting(int characteristicIndex, int descriptorIndex) {
            mEnvironmentalSensingServiceMockCallbackBuilder.removeTrueWindSpeedEsTriggerSetting(characteristicIndex, descriptorIndex);
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
         * @see org.im97mori.ble.service.ess.peripheral.EnvironmentalSensingServiceMockCallback.Builder#setTrueWindSpeedEsConfiguration(int, int, int, long, byte[])
         */
        @NonNull
        public Builder<T> setTrueWindSpeedEsConfiguration(int index, int permission, int responseCode, long delay, @NonNull byte[] value) {
            mEnvironmentalSensingServiceMockCallbackBuilder.setTrueWindSpeedEsConfiguration(index, permission, responseCode, delay, value);
            return this;
        }

        /**
         * @see org.im97mori.ble.service.ess.peripheral.EnvironmentalSensingServiceMockCallback.Builder#removeTrueWindSpeedEsConfiguration(int)
         */
        @NonNull
        public Builder<T> removeTrueWindSpeedEsConfiguration(int index) {
            mEnvironmentalSensingServiceMockCallbackBuilder.removeTrueWindSpeedEsConfiguration(index);
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
         * @see org.im97mori.ble.service.ess.peripheral.EnvironmentalSensingServiceMockCallback.Builder#setTrueWindSpeedCharacteristicUserDescription(int, int, long, byte[])
         */
        @NonNull
        public Builder<T> setTrueWindSpeedCharacteristicUserDescription(int index, int responseCode, long delay, @NonNull byte[] value) {
            mEnvironmentalSensingServiceMockCallbackBuilder.setTrueWindSpeedCharacteristicUserDescription(index, responseCode, delay, value);
            return this;
        }

        /**
         * @see org.im97mori.ble.service.ess.peripheral.EnvironmentalSensingServiceMockCallback.Builder#removeTrueWindSpeedCharacteristicUserDescription(int)
         */
        @NonNull
        public Builder<T> removeTrueWindSpeedCharacteristicUserDescription(int index) {
            mEnvironmentalSensingServiceMockCallbackBuilder.removeTrueWindSpeedCharacteristicUserDescription(index);
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
         * @see org.im97mori.ble.service.ess.peripheral.EnvironmentalSensingServiceMockCallback.Builder#setTrueWindSpeedValidRange(int, int, long, byte[])
         */
        @NonNull
        public Builder<T> setTrueWindSpeedValidRange(int index, int responseCode, long delay, @NonNull byte[] value) {
            mEnvironmentalSensingServiceMockCallbackBuilder.setTrueWindSpeedValidRange(index, responseCode, delay, value);
            return this;
        }

        /**
         * @see org.im97mori.ble.service.ess.peripheral.EnvironmentalSensingServiceMockCallback.Builder#removeTrueWindSpeedValidRange(int)
         */
        @NonNull
        public Builder<T> removeTrueWindSpeedValidRange(int index) {
            mEnvironmentalSensingServiceMockCallbackBuilder.removeTrueWindSpeedValidRange(index);
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
         * @see org.im97mori.ble.service.ess.peripheral.EnvironmentalSensingServiceMockCallback.Builder#addUVIndex(int, int, int, long, byte[])
         */
        @NonNull
        public Builder<T> addUVIndex(int index, int property, int responseCode, long delay, @NonNull byte[] value) {
            mEnvironmentalSensingServiceMockCallbackBuilder.addUVIndex(index, property, responseCode, delay, value);
            return this;
        }

        /**
         * @see org.im97mori.ble.service.ess.peripheral.EnvironmentalSensingServiceMockCallback.Builder#removeUVIndex(int)
         */
        @NonNull
        public Builder<T> removeUVIndex(int index) {
            mEnvironmentalSensingServiceMockCallbackBuilder.removeUVIndex(index);
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
         * @see org.im97mori.ble.service.ess.peripheral.EnvironmentalSensingServiceMockCallback.Builder#setUVIndexEsMeasurement(int, int, long, byte[])
         */
        @NonNull
        public Builder<T> setUVIndexEsMeasurement(int index, int responseCode, long delay, @NonNull byte[] value) {
            mEnvironmentalSensingServiceMockCallbackBuilder.setUVIndexEsMeasurement(index, responseCode, delay, value);
            return this;
        }

        /**
         * @see org.im97mori.ble.service.ess.peripheral.EnvironmentalSensingServiceMockCallback.Builder#removeUVIndexEsMeasurement(int)
         */
        @NonNull
        public Builder<T> removeUVIndexEsMeasurement(int index) {
            mEnvironmentalSensingServiceMockCallbackBuilder.removeUVIndexEsMeasurement(index);
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
         * @see org.im97mori.ble.service.ess.peripheral.EnvironmentalSensingServiceMockCallback.Builder#setUVIndexEsTriggerSetting(int, int, int, int, long, byte[])
         */
        @NonNull
        public Builder<T> setUVIndexEsTriggerSetting(int characteristicIndex, int descriptorIndex, int permission, int responseCode, long delay, @NonNull byte[] value) {
            mEnvironmentalSensingServiceMockCallbackBuilder.setUVIndexEsTriggerSetting(characteristicIndex, descriptorIndex, permission, responseCode, delay, value);
            return this;
        }

        /**
         * @see org.im97mori.ble.service.ess.peripheral.EnvironmentalSensingServiceMockCallback.Builder#removeUVIndexEsTriggerSetting(int, int)
         */
        @NonNull
        public Builder<T> removeUVIndexEsTriggerSetting(int characteristicIndex, int descriptorIndex) {
            mEnvironmentalSensingServiceMockCallbackBuilder.removeUVIndexEsTriggerSetting(characteristicIndex, descriptorIndex);
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
         * @see org.im97mori.ble.service.ess.peripheral.EnvironmentalSensingServiceMockCallback.Builder#setUVIndexEsConfiguration(int, int, int, long, byte[])
         */
        @NonNull
        public Builder<T> setUVIndexEsConfiguration(int index, int permission, int responseCode, long delay, @NonNull byte[] value) {
            mEnvironmentalSensingServiceMockCallbackBuilder.setUVIndexEsConfiguration(index, permission, responseCode, delay, value);
            return this;
        }

        /**
         * @see org.im97mori.ble.service.ess.peripheral.EnvironmentalSensingServiceMockCallback.Builder#removeUVIndexEsConfiguration(int)
         */
        @NonNull
        public Builder<T> removeUVIndexEsConfiguration(int index) {
            mEnvironmentalSensingServiceMockCallbackBuilder.removeUVIndexEsConfiguration(index);
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
         * @see org.im97mori.ble.service.ess.peripheral.EnvironmentalSensingServiceMockCallback.Builder#setUVIndexCharacteristicUserDescription(int, int, long, byte[])
         */
        @NonNull
        public Builder<T> setUVIndexCharacteristicUserDescription(int index, int responseCode, long delay, @NonNull byte[] value) {
            mEnvironmentalSensingServiceMockCallbackBuilder.setUVIndexCharacteristicUserDescription(index, responseCode, delay, value);
            return this;
        }

        /**
         * @see org.im97mori.ble.service.ess.peripheral.EnvironmentalSensingServiceMockCallback.Builder#removeUVIndexCharacteristicUserDescription(int)
         */
        @NonNull
        public Builder<T> removeUVIndexCharacteristicUserDescription(int index) {
            mEnvironmentalSensingServiceMockCallbackBuilder.removeUVIndexCharacteristicUserDescription(index);
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
         * @see org.im97mori.ble.service.ess.peripheral.EnvironmentalSensingServiceMockCallback.Builder#setUVIndexValidRange(int, int, long, byte[])
         */
        @NonNull
        public Builder<T> setUVIndexValidRange(int index, int responseCode, long delay, @NonNull byte[] value) {
            mEnvironmentalSensingServiceMockCallbackBuilder.setUVIndexValidRange(index, responseCode, delay, value);
            return this;
        }

        /**
         * @see org.im97mori.ble.service.ess.peripheral.EnvironmentalSensingServiceMockCallback.Builder#removeUVIndexValidRange(int)
         */
        @NonNull
        public Builder<T> removeUVIndexValidRange(int index) {
            mEnvironmentalSensingServiceMockCallbackBuilder.removeUVIndexValidRange(index);
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
         * @see org.im97mori.ble.service.ess.peripheral.EnvironmentalSensingServiceMockCallback.Builder#addWindChill(int, int, int, long, byte[])
         */
        @NonNull
        public Builder<T> addWindChill(int index, int property, int responseCode, long delay, @NonNull byte[] value) {
            mEnvironmentalSensingServiceMockCallbackBuilder.addWindChill(index, property, responseCode, delay, value);
            return this;
        }

        /**
         * @see org.im97mori.ble.service.ess.peripheral.EnvironmentalSensingServiceMockCallback.Builder#removeWindChill(int)
         */
        @NonNull
        public Builder<T> removeWindChill(int index) {
            mEnvironmentalSensingServiceMockCallbackBuilder.removeWindChill(index);
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
         * @see org.im97mori.ble.service.ess.peripheral.EnvironmentalSensingServiceMockCallback.Builder#setWindChillEsMeasurement(int, int, long, byte[])
         */
        @NonNull
        public Builder<T> setWindChillEsMeasurement(int index, int responseCode, long delay, @NonNull byte[] value) {
            mEnvironmentalSensingServiceMockCallbackBuilder.setWindChillEsMeasurement(index, responseCode, delay, value);
            return this;
        }

        /**
         * @see org.im97mori.ble.service.ess.peripheral.EnvironmentalSensingServiceMockCallback.Builder#removeWindChillEsMeasurement(int)
         */
        @NonNull
        public Builder<T> removeWindChillEsMeasurement(int index) {
            mEnvironmentalSensingServiceMockCallbackBuilder.removeWindChillEsMeasurement(index);
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
         * @see org.im97mori.ble.service.ess.peripheral.EnvironmentalSensingServiceMockCallback.Builder#setWindChillEsTriggerSetting(int, int, int, int, long, byte[])
         */
        @NonNull
        public Builder<T> setWindChillEsTriggerSetting(int characteristicIndex, int descriptorIndex, int permission, int responseCode, long delay, @NonNull byte[] value) {
            mEnvironmentalSensingServiceMockCallbackBuilder.setWindChillEsTriggerSetting(characteristicIndex, descriptorIndex, permission, responseCode, delay, value);
            return this;
        }

        /**
         * @see org.im97mori.ble.service.ess.peripheral.EnvironmentalSensingServiceMockCallback.Builder#removeWindChillEsTriggerSetting(int, int)
         */
        @NonNull
        public Builder<T> removeWindChillEsTriggerSetting(int characteristicIndex, int descriptorIndex) {
            mEnvironmentalSensingServiceMockCallbackBuilder.removeWindChillEsTriggerSetting(characteristicIndex, descriptorIndex);
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
         * @see org.im97mori.ble.service.ess.peripheral.EnvironmentalSensingServiceMockCallback.Builder#setWindChillEsConfiguration(int, int, int, long, byte[])
         */
        @NonNull
        public Builder<T> setWindChillEsConfiguration(int index, int permission, int responseCode, long delay, @NonNull byte[] value) {
            mEnvironmentalSensingServiceMockCallbackBuilder.setWindChillEsConfiguration(index, permission, responseCode, delay, value);
            return this;
        }

        /**
         * @see org.im97mori.ble.service.ess.peripheral.EnvironmentalSensingServiceMockCallback.Builder#removeWindChillEsConfiguration(int)
         */
        @NonNull
        public Builder<T> removeWindChillEsConfiguration(int index) {
            mEnvironmentalSensingServiceMockCallbackBuilder.removeWindChillEsConfiguration(index);
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
         * @see org.im97mori.ble.service.ess.peripheral.EnvironmentalSensingServiceMockCallback.Builder#setWindChillCharacteristicUserDescription(int, int, long, byte[])
         */
        @NonNull
        public Builder<T> setWindChillCharacteristicUserDescription(int index, int responseCode, long delay, @NonNull byte[] value) {
            mEnvironmentalSensingServiceMockCallbackBuilder.setWindChillCharacteristicUserDescription(index, responseCode, delay, value);
            return this;
        }

        /**
         * @see org.im97mori.ble.service.ess.peripheral.EnvironmentalSensingServiceMockCallback.Builder#removeWindChillCharacteristicUserDescription(int)
         */
        @NonNull
        public Builder<T> removeWindChillCharacteristicUserDescription(int index) {
            mEnvironmentalSensingServiceMockCallbackBuilder.removeWindChillCharacteristicUserDescription(index);
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
         * @see org.im97mori.ble.service.ess.peripheral.EnvironmentalSensingServiceMockCallback.Builder#setWindChillValidRange(int, int, long, byte[])
         */
        @NonNull
        public Builder<T> setWindChillValidRange(int index, int responseCode, long delay, @NonNull byte[] value) {
            mEnvironmentalSensingServiceMockCallbackBuilder.setWindChillValidRange(index, responseCode, delay, value);
            return this;
        }

        /**
         * @see org.im97mori.ble.service.ess.peripheral.EnvironmentalSensingServiceMockCallback.Builder#removeWindChillValidRange(int)
         */
        @NonNull
        public Builder<T> removeWindChillValidRange(int index) {
            mEnvironmentalSensingServiceMockCallbackBuilder.removeWindChillValidRange(index);
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
         * @see org.im97mori.ble.service.ess.peripheral.EnvironmentalSensingServiceMockCallback.Builder#addBarometricPressureTrend(int, int, int, long, byte[])
         */
        @NonNull
        public Builder<T> addBarometricPressureTrend(int index, int property, int responseCode, long delay, @NonNull byte[] value) {
            mEnvironmentalSensingServiceMockCallbackBuilder.addBarometricPressureTrend(index, property, responseCode, delay, value);
            return this;
        }

        /**
         * @see org.im97mori.ble.service.ess.peripheral.EnvironmentalSensingServiceMockCallback.Builder#removeBarometricPressureTrend(int)
         */
        @NonNull
        public Builder<T> removeBarometricPressureTrend(int index) {
            mEnvironmentalSensingServiceMockCallbackBuilder.removeBarometricPressureTrend(index);
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
         * @see org.im97mori.ble.service.ess.peripheral.EnvironmentalSensingServiceMockCallback.Builder#setBarometricPressureTrendEsMeasurement(int, int, long, byte[])
         */
        @NonNull
        public Builder<T> setBarometricPressureTrendEsMeasurement(int index, int responseCode, long delay, @NonNull byte[] value) {
            mEnvironmentalSensingServiceMockCallbackBuilder.setBarometricPressureTrendEsMeasurement(index, responseCode, delay, value);
            return this;
        }

        /**
         * @see org.im97mori.ble.service.ess.peripheral.EnvironmentalSensingServiceMockCallback.Builder#removeBarometricPressureTrendEsMeasurement(int)
         */
        @NonNull
        public Builder<T> removeBarometricPressureTrendEsMeasurement(int index) {
            mEnvironmentalSensingServiceMockCallbackBuilder.removeBarometricPressureTrendEsMeasurement(index);
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
         * @see org.im97mori.ble.service.ess.peripheral.EnvironmentalSensingServiceMockCallback.Builder#setBarometricPressureTrendEsTriggerSetting(int, int, int, int, long, byte[])
         */
        @NonNull
        public Builder<T> setBarometricPressureTrendEsTriggerSetting(int characteristicIndex, int descriptorIndex, int permission, int responseCode, long delay, @NonNull byte[] value) {
            mEnvironmentalSensingServiceMockCallbackBuilder.setBarometricPressureTrendEsTriggerSetting(characteristicIndex, descriptorIndex, permission, responseCode, delay, value);
            return this;
        }

        /**
         * @see org.im97mori.ble.service.ess.peripheral.EnvironmentalSensingServiceMockCallback.Builder#removeBarometricPressureTrendEsTriggerSetting(int, int)
         */
        @NonNull
        public Builder<T> removeBarometricPressureTrendEsTriggerSetting(int characteristicIndex, int descriptorIndex) {
            mEnvironmentalSensingServiceMockCallbackBuilder.removeBarometricPressureTrendEsTriggerSetting(characteristicIndex, descriptorIndex);
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
         * @see org.im97mori.ble.service.ess.peripheral.EnvironmentalSensingServiceMockCallback.Builder#setBarometricPressureTrendEsConfiguration(int, int, int, long, byte[])
         */
        @NonNull
        public Builder<T> setBarometricPressureTrendEsConfiguration(int index, int permission, int responseCode, long delay, @NonNull byte[] value) {
            mEnvironmentalSensingServiceMockCallbackBuilder.setBarometricPressureTrendEsConfiguration(index, permission, responseCode, delay, value);
            return this;
        }

        /**
         * @see org.im97mori.ble.service.ess.peripheral.EnvironmentalSensingServiceMockCallback.Builder#removeBarometricPressureTrendEsConfiguration(int)
         */
        @NonNull
        public Builder<T> removeBarometricPressureTrendEsConfiguration(int index) {
            mEnvironmentalSensingServiceMockCallbackBuilder.removeBarometricPressureTrendEsConfiguration(index);
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
         * @see org.im97mori.ble.service.ess.peripheral.EnvironmentalSensingServiceMockCallback.Builder#setBarometricPressureTrendCharacteristicUserDescription(int, int, long, byte[])
         */
        @NonNull
        public Builder<T> setBarometricPressureTrendCharacteristicUserDescription(int index, int responseCode, long delay, @NonNull byte[] value) {
            mEnvironmentalSensingServiceMockCallbackBuilder.setBarometricPressureTrendCharacteristicUserDescription(index, responseCode, delay, value);
            return this;
        }

        /**
         * @see org.im97mori.ble.service.ess.peripheral.EnvironmentalSensingServiceMockCallback.Builder#removeBarometricPressureTrendCharacteristicUserDescription(int)
         */
        @NonNull
        public Builder<T> removeBarometricPressureTrendCharacteristicUserDescription(int index) {
            mEnvironmentalSensingServiceMockCallbackBuilder.removeBarometricPressureTrendCharacteristicUserDescription(index);
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
         * @see org.im97mori.ble.service.ess.peripheral.EnvironmentalSensingServiceMockCallback.Builder#setBarometricPressureTrendValidRange(int, int, long, byte[])
         */
        @NonNull
        public Builder<T> setBarometricPressureTrendValidRange(int index, int responseCode, long delay, @NonNull byte[] value) {
            mEnvironmentalSensingServiceMockCallbackBuilder.setBarometricPressureTrendValidRange(index, responseCode, delay, value);
            return this;
        }

        /**
         * @see org.im97mori.ble.service.ess.peripheral.EnvironmentalSensingServiceMockCallback.Builder#removeBarometricPressureTrendValidRange(int)
         */
        @NonNull
        public Builder<T> removeBarometricPressureTrendValidRange(int index) {
            mEnvironmentalSensingServiceMockCallbackBuilder.removeBarometricPressureTrendValidRange(index);
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
         * @see org.im97mori.ble.service.ess.peripheral.EnvironmentalSensingServiceMockCallback.Builder#addMagneticDeclination(int, int, int, long, byte[])
         */
        @NonNull
        public Builder<T> addMagneticDeclination(int index, int property, int responseCode, long delay, @NonNull byte[] value) {
            mEnvironmentalSensingServiceMockCallbackBuilder.addMagneticDeclination(index, property, responseCode, delay, value);
            return this;
        }

        /**
         * @see org.im97mori.ble.service.ess.peripheral.EnvironmentalSensingServiceMockCallback.Builder#removeMagneticDeclination(int)
         */
        @NonNull
        public Builder<T> removeMagneticDeclination(int index) {
            mEnvironmentalSensingServiceMockCallbackBuilder.removeMagneticDeclination(index);
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
         * @see org.im97mori.ble.service.ess.peripheral.EnvironmentalSensingServiceMockCallback.Builder#setMagneticDeclinationEsMeasurement(int, int, long, byte[])
         */
        @NonNull
        public Builder<T> setMagneticDeclinationEsMeasurement(int index, int responseCode, long delay, @NonNull byte[] value) {
            mEnvironmentalSensingServiceMockCallbackBuilder.setMagneticDeclinationEsMeasurement(index, responseCode, delay, value);
            return this;
        }

        /**
         * @see org.im97mori.ble.service.ess.peripheral.EnvironmentalSensingServiceMockCallback.Builder#removeMagneticDeclinationEsMeasurement(int)
         */
        @NonNull
        public Builder<T> removeMagneticDeclinationEsMeasurement(int index) {
            mEnvironmentalSensingServiceMockCallbackBuilder.removeMagneticDeclinationEsMeasurement(index);
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
         * @see org.im97mori.ble.service.ess.peripheral.EnvironmentalSensingServiceMockCallback.Builder#setMagneticDeclinationEsTriggerSetting(int, int, int, int, long, byte[])
         */
        @NonNull
        public Builder<T> setMagneticDeclinationEsTriggerSetting(int characteristicIndex, int descriptorIndex, int permission, int responseCode, long delay, @NonNull byte[] value) {
            mEnvironmentalSensingServiceMockCallbackBuilder.setMagneticDeclinationEsTriggerSetting(characteristicIndex, descriptorIndex, permission, responseCode, delay, value);
            return this;
        }

        /**
         * @see org.im97mori.ble.service.ess.peripheral.EnvironmentalSensingServiceMockCallback.Builder#removeMagneticDeclinationEsTriggerSetting(int, int)
         */
        @NonNull
        public Builder<T> removeMagneticDeclinationEsTriggerSetting(int characteristicIndex, int descriptorIndex) {
            mEnvironmentalSensingServiceMockCallbackBuilder.removeMagneticDeclinationEsTriggerSetting(characteristicIndex, descriptorIndex);
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
         * @see org.im97mori.ble.service.ess.peripheral.EnvironmentalSensingServiceMockCallback.Builder#setMagneticDeclinationEsConfiguration(int, int, int, long, byte[])
         */
        @NonNull
        public Builder<T> setMagneticDeclinationEsConfiguration(int index, int permission, int responseCode, long delay, @NonNull byte[] value) {
            mEnvironmentalSensingServiceMockCallbackBuilder.setMagneticDeclinationEsConfiguration(index, permission, responseCode, delay, value);
            return this;
        }

        /**
         * @see org.im97mori.ble.service.ess.peripheral.EnvironmentalSensingServiceMockCallback.Builder#removeMagneticDeclinationEsConfiguration(int)
         */
        @NonNull
        public Builder<T> removeMagneticDeclinationEsConfiguration(int index) {
            mEnvironmentalSensingServiceMockCallbackBuilder.removeMagneticDeclinationEsConfiguration(index);
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
         * @see org.im97mori.ble.service.ess.peripheral.EnvironmentalSensingServiceMockCallback.Builder#setMagneticDeclinationCharacteristicUserDescription(int, int, long, byte[])
         */
        @NonNull
        public Builder<T> setMagneticDeclinationCharacteristicUserDescription(int index, int responseCode, long delay, @NonNull byte[] value) {
            mEnvironmentalSensingServiceMockCallbackBuilder.setMagneticDeclinationCharacteristicUserDescription(index, responseCode, delay, value);
            return this;
        }

        /**
         * @see org.im97mori.ble.service.ess.peripheral.EnvironmentalSensingServiceMockCallback.Builder#removeMagneticDeclinationCharacteristicUserDescription(int)
         */
        @NonNull
        public Builder<T> removeMagneticDeclinationCharacteristicUserDescription(int index) {
            mEnvironmentalSensingServiceMockCallbackBuilder.removeMagneticDeclinationCharacteristicUserDescription(index);
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
         * @see org.im97mori.ble.service.ess.peripheral.EnvironmentalSensingServiceMockCallback.Builder#setMagneticDeclinationValidRange(int, int, long, byte[])
         */
        @NonNull
        public Builder<T> setMagneticDeclinationValidRange(int index, int responseCode, long delay, @NonNull byte[] value) {
            mEnvironmentalSensingServiceMockCallbackBuilder.setMagneticDeclinationValidRange(index, responseCode, delay, value);
            return this;
        }

        /**
         * @see org.im97mori.ble.service.ess.peripheral.EnvironmentalSensingServiceMockCallback.Builder#removeMagneticDeclinationValidRange(int)
         */
        @NonNull
        public Builder<T> removeMagneticDeclinationValidRange(int index) {
            mEnvironmentalSensingServiceMockCallbackBuilder.removeMagneticDeclinationValidRange(index);
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
         * @see org.im97mori.ble.service.ess.peripheral.EnvironmentalSensingServiceMockCallback.Builder#addMagneticFluxDensity2D(int, int, int, long, byte[])
         */
        @NonNull
        public Builder<T> addMagneticFluxDensity2D(int index, int property, int responseCode, long delay, @NonNull byte[] value) {
            mEnvironmentalSensingServiceMockCallbackBuilder.addMagneticFluxDensity2D(index, property, responseCode, delay, value);
            return this;
        }

        /**
         * @see org.im97mori.ble.service.ess.peripheral.EnvironmentalSensingServiceMockCallback.Builder#removeMagneticFluxDensity2D(int)
         */
        @NonNull
        public Builder<T> removeMagneticFluxDensity2D(int index) {
            mEnvironmentalSensingServiceMockCallbackBuilder.removeMagneticFluxDensity2D(index);
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
         * @see org.im97mori.ble.service.ess.peripheral.EnvironmentalSensingServiceMockCallback.Builder#setMagneticFluxDensity2DEsMeasurement(int, int, long, byte[])
         */
        @NonNull
        public Builder<T> setMagneticFluxDensity2DEsMeasurement(int index, int responseCode, long delay, @NonNull byte[] value) {
            mEnvironmentalSensingServiceMockCallbackBuilder.setMagneticFluxDensity2DEsMeasurement(index, responseCode, delay, value);
            return this;
        }

        /**
         * @see org.im97mori.ble.service.ess.peripheral.EnvironmentalSensingServiceMockCallback.Builder#removeMagneticFluxDensity2DEsMeasurement(int)
         */
        @NonNull
        public Builder<T> removeMagneticFluxDensity2DEsMeasurement(int index) {
            mEnvironmentalSensingServiceMockCallbackBuilder.removeMagneticFluxDensity2DEsMeasurement(index);
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
         * @see org.im97mori.ble.service.ess.peripheral.EnvironmentalSensingServiceMockCallback.Builder#setMagneticFluxDensity2DEsTriggerSetting(int, int, int, int, long, byte[])
         */
        @NonNull
        public Builder<T> setMagneticFluxDensity2DEsTriggerSetting(int characteristicIndex, int descriptorIndex, int permission, int responseCode, long delay, @NonNull byte[] value) {
            mEnvironmentalSensingServiceMockCallbackBuilder.setMagneticFluxDensity2DEsTriggerSetting(characteristicIndex, descriptorIndex, permission, responseCode, delay, value);
            return this;
        }

        /**
         * @see org.im97mori.ble.service.ess.peripheral.EnvironmentalSensingServiceMockCallback.Builder#removeMagneticFluxDensity2DEsTriggerSetting(int, int)
         */
        @NonNull
        public Builder<T> removeMagneticFluxDensity2DEsTriggerSetting(int characteristicIndex, int descriptorIndex) {
            mEnvironmentalSensingServiceMockCallbackBuilder.removeMagneticFluxDensity2DEsTriggerSetting(characteristicIndex, descriptorIndex);
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
         * @see org.im97mori.ble.service.ess.peripheral.EnvironmentalSensingServiceMockCallback.Builder#setMagneticFluxDensity2DEsConfiguration(int, int, int, long, byte[])
         */
        @NonNull
        public Builder<T> setMagneticFluxDensity2DEsConfiguration(int index, int permission, int responseCode, long delay, @NonNull byte[] value) {
            mEnvironmentalSensingServiceMockCallbackBuilder.setMagneticFluxDensity2DEsConfiguration(index, permission, responseCode, delay, value);
            return this;
        }

        /**
         * @see org.im97mori.ble.service.ess.peripheral.EnvironmentalSensingServiceMockCallback.Builder#removeMagneticFluxDensity2DEsConfiguration(int)
         */
        @NonNull
        public Builder<T> removeMagneticFluxDensity2DEsConfiguration(int index) {
            mEnvironmentalSensingServiceMockCallbackBuilder.removeMagneticFluxDensity2DEsConfiguration(index);
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
         * @see org.im97mori.ble.service.ess.peripheral.EnvironmentalSensingServiceMockCallback.Builder#setMagneticFluxDensity2DCharacteristicUserDescription(int, int, long, byte[])
         */
        @NonNull
        public Builder<T> setMagneticFluxDensity2DCharacteristicUserDescription(int index, int responseCode, long delay, @NonNull byte[] value) {
            mEnvironmentalSensingServiceMockCallbackBuilder.setMagneticFluxDensity2DCharacteristicUserDescription(index, responseCode, delay, value);
            return this;
        }

        /**
         * @see org.im97mori.ble.service.ess.peripheral.EnvironmentalSensingServiceMockCallback.Builder#removeMagneticFluxDensity2DCharacteristicUserDescription(int)
         */
        @NonNull
        public Builder<T> removeMagneticFluxDensity2DCharacteristicUserDescription(int index) {
            mEnvironmentalSensingServiceMockCallbackBuilder.removeMagneticFluxDensity2DCharacteristicUserDescription(index);
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
         * @see org.im97mori.ble.service.ess.peripheral.EnvironmentalSensingServiceMockCallback.Builder#setMagneticFluxDensity2DValidRange(int, int, long, byte[])
         */
        @NonNull
        public Builder<T> setMagneticFluxDensity2DValidRange(int index, int responseCode, long delay, @NonNull byte[] value) {
            mEnvironmentalSensingServiceMockCallbackBuilder.setMagneticFluxDensity2DValidRange(index, responseCode, delay, value);
            return this;
        }

        /**
         * @see org.im97mori.ble.service.ess.peripheral.EnvironmentalSensingServiceMockCallback.Builder#removeMagneticFluxDensity2DValidRange(int)
         */
        @NonNull
        public Builder<T> removeMagneticFluxDensity2DValidRange(int index) {
            mEnvironmentalSensingServiceMockCallbackBuilder.removeMagneticFluxDensity2DValidRange(index);
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
         * @see org.im97mori.ble.service.ess.peripheral.EnvironmentalSensingServiceMockCallback.Builder#addMagneticFluxDensity3D(int, int, int, long, byte[])
         */
        @NonNull
        public Builder<T> addMagneticFluxDensity3D(int index, int property, int responseCode, long delay, @NonNull byte[] value) {
            mEnvironmentalSensingServiceMockCallbackBuilder.addMagneticFluxDensity3D(index, property, responseCode, delay, value);
            return this;
        }

        /**
         * @see org.im97mori.ble.service.ess.peripheral.EnvironmentalSensingServiceMockCallback.Builder#removeMagneticFluxDensity3D(int)
         */
        @NonNull
        public Builder<T> removeMagneticFluxDensity3D(int index) {
            mEnvironmentalSensingServiceMockCallbackBuilder.removeMagneticFluxDensity3D(index);
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
         * @see org.im97mori.ble.service.ess.peripheral.EnvironmentalSensingServiceMockCallback.Builder#setMagneticFluxDensity3DEsMeasurement(int, int, long, byte[])
         */
        @NonNull
        public Builder<T> setMagneticFluxDensity3DEsMeasurement(int index, int responseCode, long delay, @NonNull byte[] value) {
            mEnvironmentalSensingServiceMockCallbackBuilder.setMagneticFluxDensity3DEsMeasurement(index, responseCode, delay, value);
            return this;
        }

        /**
         * @see org.im97mori.ble.service.ess.peripheral.EnvironmentalSensingServiceMockCallback.Builder#removeMagneticFluxDensity3DEsMeasurement(int)
         */
        @NonNull
        public Builder<T> removeMagneticFluxDensity3DEsMeasurement(int index) {
            mEnvironmentalSensingServiceMockCallbackBuilder.removeMagneticFluxDensity3DEsMeasurement(index);
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
         * @see org.im97mori.ble.service.ess.peripheral.EnvironmentalSensingServiceMockCallback.Builder#setMagneticFluxDensity3DEsTriggerSetting(int, int, int, int, long, byte[])
         */
        @NonNull
        public Builder<T> setMagneticFluxDensity3DEsTriggerSetting(int characteristicIndex, int descriptorIndex, int permission, int responseCode, long delay, @NonNull byte[] value) {
            mEnvironmentalSensingServiceMockCallbackBuilder.setMagneticFluxDensity3DEsTriggerSetting(characteristicIndex, descriptorIndex, permission, responseCode, delay, value);
            return this;
        }

        /**
         * @see org.im97mori.ble.service.ess.peripheral.EnvironmentalSensingServiceMockCallback.Builder#removeMagneticFluxDensity3DEsTriggerSetting(int, int)
         */
        @NonNull
        public Builder<T> removeMagneticFluxDensity3DEsTriggerSetting(int characteristicIndex, int descriptorIndex) {
            mEnvironmentalSensingServiceMockCallbackBuilder.removeMagneticFluxDensity3DEsTriggerSetting(characteristicIndex, descriptorIndex);
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
         * @see org.im97mori.ble.service.ess.peripheral.EnvironmentalSensingServiceMockCallback.Builder#setMagneticFluxDensity3DEsConfiguration(int, int, int, long, byte[])
         */
        @NonNull
        public Builder<T> setMagneticFluxDensity3DEsConfiguration(int index, int permission, int responseCode, long delay, @NonNull byte[] value) {
            mEnvironmentalSensingServiceMockCallbackBuilder.setMagneticFluxDensity3DEsConfiguration(index, permission, responseCode, delay, value);
            return this;
        }

        /**
         * @see org.im97mori.ble.service.ess.peripheral.EnvironmentalSensingServiceMockCallback.Builder#removeMagneticFluxDensity3DEsConfiguration(int)
         */
        @NonNull
        public Builder<T> removeMagneticFluxDensity3DEsConfiguration(int index) {
            mEnvironmentalSensingServiceMockCallbackBuilder.removeMagneticFluxDensity3DEsConfiguration(index);
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
         * @see org.im97mori.ble.service.ess.peripheral.EnvironmentalSensingServiceMockCallback.Builder#setMagneticFluxDensity3DCharacteristicUserDescription(int, int, long, byte[])
         */
        @NonNull
        public Builder<T> setMagneticFluxDensity3DCharacteristicUserDescription(int index, int responseCode, long delay, @NonNull byte[] value) {
            mEnvironmentalSensingServiceMockCallbackBuilder.setMagneticFluxDensity3DCharacteristicUserDescription(index, responseCode, delay, value);
            return this;
        }

        /**
         * @see org.im97mori.ble.service.ess.peripheral.EnvironmentalSensingServiceMockCallback.Builder#removeMagneticFluxDensity3DCharacteristicUserDescription(int)
         */
        @NonNull
        public Builder<T> removeMagneticFluxDensity3DCharacteristicUserDescription(int index) {
            mEnvironmentalSensingServiceMockCallbackBuilder.removeMagneticFluxDensity3DCharacteristicUserDescription(index);
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
         * @see org.im97mori.ble.service.ess.peripheral.EnvironmentalSensingServiceMockCallback.Builder#setMagneticFluxDensity3DValidRange(int, int, long, byte[])
         */
        @NonNull
        public Builder<T> setMagneticFluxDensity3DValidRange(int index, int responseCode, long delay, @NonNull byte[] value) {
            mEnvironmentalSensingServiceMockCallbackBuilder.setMagneticFluxDensity3DValidRange(index, responseCode, delay, value);
            return this;
        }

        /**
         * @see org.im97mori.ble.service.ess.peripheral.EnvironmentalSensingServiceMockCallback.Builder#removeMagneticFluxDensity3DValidRange(int)
         */
        @NonNull
        public Builder<T> removeMagneticFluxDensity3DValidRange(int index) {
            mEnvironmentalSensingServiceMockCallbackBuilder.removeMagneticFluxDensity3DValidRange(index);
            return this;
        }

        /**
         * @see #addManufacturerNameString(ManufacturerNameString)
         */
        @NonNull
        public Builder<T> addManufacturerNameString(@NonNull String manufacturerName) {
            return addManufacturerNameString(new ManufacturerNameString(manufacturerName));
        }

        /**
         * @see #addManufacturerNameString(byte[])
         */
        @NonNull
        public Builder<T> addManufacturerNameString(@NonNull ManufacturerNameString manufacturerNameString) {
            return addManufacturerNameString(manufacturerNameString.getBytes());
        }

        /**
         * @see #addManufacturerNameString(int, long, byte[])
         */
        @NonNull
        public Builder<T> addManufacturerNameString(@NonNull byte[] value) {
            return addManufacturerNameString(BluetoothGatt.GATT_SUCCESS
                    , 0
                    , value);
        }

        /**
         * @see org.im97mori.ble.service.dis.peripheral.DeviceInformationServiceMockCallback.Builder#addManufacturerNameString(int, long, byte[])
         */
        @NonNull
        public Builder<T> addManufacturerNameString(int responseCode, long delay, @NonNull byte[] value) {
            if (mDeviceInformationServiceMockCallbackBuilder != null) {
                mHasManufacturerNameString = true;
                mDeviceInformationServiceMockCallbackBuilder.addManufacturerNameString(responseCode, delay, value);
            }
            return this;
        }

        /**
         * @see org.im97mori.ble.service.dis.peripheral.DeviceInformationServiceMockCallback.Builder#removeManufacturerNameString()
         */
        @NonNull
        public Builder<T> removeManufacturerNameString() {
            if (mDeviceInformationServiceMockCallbackBuilder != null) {
                mHasManufacturerNameString = false;
                mDeviceInformationServiceMockCallbackBuilder.removeManufacturerNameString();
            }
            return this;
        }

        /**
         * @see #addModelNumberString(ModelNumberString)
         */
        @NonNull
        public Builder<T> addModelNumberString(@NonNull String modelNumber) {
            return addModelNumberString(new ModelNumberString(modelNumber));
        }

        /**
         * @see #addModelNumberString(byte[])
         */
        @NonNull
        public Builder<T> addModelNumberString(ModelNumberString modelNumberString) {
            return addModelNumberString(modelNumberString.getBytes());
        }

        /**
         * @see #addModelNumberString(int, long, byte[])
         */
        @NonNull
        public Builder<T> addModelNumberString(@NonNull byte[] value) {
            return addModelNumberString(BluetoothGatt.GATT_SUCCESS
                    , 0
                    , value);
        }

        /**
         * @see org.im97mori.ble.service.dis.peripheral.DeviceInformationServiceMockCallback.Builder#addModelNumberString(int, long, byte[])
         */
        @NonNull
        public Builder<T> addModelNumberString(int responseCode, long delay, @NonNull byte[] value) {
            if (mDeviceInformationServiceMockCallbackBuilder != null) {
                mHasModelNumberString = true;
                mDeviceInformationServiceMockCallbackBuilder.addModelNumberString(responseCode, delay, value);
            }
            return this;
        }

        /**
         * @see org.im97mori.ble.service.dis.peripheral.DeviceInformationServiceMockCallback.Builder#removeModelNumberString()
         */
        @NonNull
        public Builder<T> removeModelNumberString() {
            if (mDeviceInformationServiceMockCallbackBuilder != null) {
                mHasModelNumberString = false;
                mDeviceInformationServiceMockCallbackBuilder.removeModelNumberString();
            }
            return this;
        }

        /**
         * @see #addBatteryLevel(int, int, int, long, byte[], int)
         */
        @NonNull
        public Builder<T> addBatteryLevel(int index, @NonNull BatteryLevel batteryLevel) {
            return addBatteryLevel(index, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGatt.GATT_SUCCESS, 0, batteryLevel.getBytes(), -1);
        }

        /**
         * @see org.im97mori.ble.service.bas.peripheral.BatteryServiceMockCallback.Builder#addBatteryLevel(int, int, int, long, byte[], int)
         */
        @NonNull
        public Builder<T> addBatteryLevel(int index, int property, int responseCode, long delay, @NonNull byte[] value, int notificationCount) {
            if (mBatteryServiceMockCallbackBuilder != null) {
                mBatteryServiceMockCallbackBuilder.addBatteryLevel(index, property, responseCode, delay, value, notificationCount);
            }
            return this;
        }

        /**
         * @see org.im97mori.ble.service.bas.peripheral.BatteryServiceMockCallback.Builder#removeBatteryLevel(int)
         */
        @NonNull
        public Builder<T> removeBatteryLevel(int index) {
            if (mBatteryServiceMockCallbackBuilder != null) {
                mBatteryServiceMockCallbackBuilder.removeBatteryLevel(index);
            }
            return this;
        }

        /**
         * @see #setBatteryLevelCharacteristicPresentationFormat(int, int, long, byte[])
         */
        @NonNull
        public Builder<T> setBatteryLevelCharacteristicPresentationFormat(int index, @NonNull CharacteristicPresentationFormat characteristicPresentationFormat) {
            return setBatteryLevelCharacteristicPresentationFormat(index, BluetoothGatt.GATT_SUCCESS, 0, characteristicPresentationFormat.getBytes());
        }

        /**
         * @see org.im97mori.ble.service.bas.peripheral.BatteryServiceMockCallback.Builder#setBatteryLevelCharacteristicPresentationFormat(int, int, long, byte[])
         */
        @NonNull
        public Builder<T> setBatteryLevelCharacteristicPresentationFormat(int index, int responseCode, long delay, @NonNull byte[] value) {
            if (mBatteryServiceMockCallbackBuilder != null) {
                mBatteryServiceMockCallbackBuilder.setBatteryLevelCharacteristicPresentationFormat(index, responseCode, delay, value);
            }
            return this;
        }

        /**
         * @see org.im97mori.ble.service.bas.peripheral.BatteryServiceMockCallback.Builder#removeBatteryLevelCharacteristicPresentationFormat(int)
         */
        @NonNull
        public Builder<T> removeBatteryLevelCharacteristicPresentationFormat(int index) {
            if (mBatteryServiceMockCallbackBuilder != null) {
                mBatteryServiceMockCallbackBuilder.removeBatteryLevelCharacteristicPresentationFormat(index);
            }
            return this;
        }

        /**
         * @see #setBatteryLevelClientCharacteristicConfiguration(int, int, long, byte[])
         */
        public Builder<T> setBatteryLevelClientCharacteristicConfiguration(int index, @NonNull ClientCharacteristicConfiguration clientCharacteristicConfiguration) {
            return setBatteryLevelClientCharacteristicConfiguration(index, BluetoothGatt.GATT_SUCCESS, 0, clientCharacteristicConfiguration.getBytes());
        }

        /**
         * @see org.im97mori.ble.service.bas.peripheral.BatteryServiceMockCallback.Builder#setBatteryLevelClientCharacteristicConfiguration(int, int, long, byte[])
         */
        @NonNull
        public Builder<T> setBatteryLevelClientCharacteristicConfiguration(int index, int responseCode, long delay, @NonNull byte[] value) {
            if (mBatteryServiceMockCallbackBuilder != null) {
                mBatteryServiceMockCallbackBuilder.setBatteryLevelClientCharacteristicConfiguration(index, responseCode, delay, value);
            }
            return this;
        }

        /**
         * @see org.im97mori.ble.service.bas.peripheral.BatteryServiceMockCallback.Builder#removeBatteryLevelClientCharacteristicConfiguration(int)
         */
        @NonNull
        public Builder<T> removeBatteryLevelClientCharacteristicConfiguration(int index) {
            if (mBatteryServiceMockCallbackBuilder != null) {
                mBatteryServiceMockCallbackBuilder.removeBatteryLevelClientCharacteristicConfiguration(index);
            }
            return this;
        }

        /**
         * @return {@link EnvironmentalSensingProfileMockCallback} instance
         */
        public EnvironmentalSensingProfileMockCallback build() {
            if (mDeviceInformationServiceMockCallbackBuilder != null) {
                if (!mHasManufacturerNameString) {
                    throw new RuntimeException("no Manufacturer Name String data");
                }
                if (!mHasModelNumberString) {
                    throw new RuntimeException("no Model Number String data");
                }
            }
            return new EnvironmentalSensingProfileMockCallback(mContext
                    , mEnvironmentalSensingServiceMockCallbackBuilder.build()
                    , mDeviceInformationServiceMockCallbackBuilder == null ? null : mDeviceInformationServiceMockCallbackBuilder.build()
                    , mBatteryServiceMockCallbackBuilder == null ? null : mBatteryServiceMockCallbackBuilder.build());
        }

    }

    /**
     * @param context                                 {@link Context} instance
     * @param environmentalSensingServiceMockCallback {@link org.im97mori.ble.service.ess.peripheral.EnvironmentalSensingServiceMockCallback} instance
     * @param deviceInformationServiceMockCallback    {@link org.im97mori.ble.service.dis.peripheral.DeviceInformationServiceMockCallback} instance
     * @param batteryServiceMockCallback              {@link org.im97mori.ble.service.bas.peripheral.BatteryServiceMockCallback} instance
     * @param bleServerCallbacks                      callback array
     */
    public EnvironmentalSensingProfileMockCallback(@NonNull Context context
            , @NonNull EnvironmentalSensingServiceMockCallback environmentalSensingServiceMockCallback
            , @Nullable DeviceInformationServiceMockCallback deviceInformationServiceMockCallback
            , @Nullable BatteryServiceMockCallback batteryServiceMockCallback
            , @NonNull BLEServerCallback... bleServerCallbacks) {
        super(context
                , true
                , Stream.concat(Arrays.stream(bleServerCallbacks)
                        , Stream.of(environmentalSensingServiceMockCallback, deviceInformationServiceMockCallback, batteryServiceMockCallback))
                        .toArray(BLEServerCallback[]::new));
    }

    /**
     * {@inheritDoc}
     */
    @NonNull
    @Override
    public UUID getServiceUUID() {
        return ENVIRONMENTAL_SENSING_SERVICE;
    }

}
