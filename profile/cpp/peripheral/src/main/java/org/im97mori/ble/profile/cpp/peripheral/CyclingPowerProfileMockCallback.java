package org.im97mori.ble.profile.cpp.peripheral;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.im97mori.ble.characteristic.u2a19.BatteryLevel;
import org.im97mori.ble.characteristic.u2a24.ModelNumberString;
import org.im97mori.ble.characteristic.u2a29.ManufacturerNameString;
import org.im97mori.ble.characteristic.u2a5d.SensorLocation;
import org.im97mori.ble.characteristic.u2a63.CyclingPowerMeasurement;
import org.im97mori.ble.characteristic.u2a64.CyclingPowerVector;
import org.im97mori.ble.characteristic.u2a65.CyclingPowerFeature;
import org.im97mori.ble.descriptor.u2902.ClientCharacteristicConfiguration;
import org.im97mori.ble.descriptor.u2904.CharacteristicPresentationFormat;
import org.im97mori.ble.profile.peripheral.AbstractProfileMockCallback;
import org.im97mori.ble.service.bas.peripheral.BatteryServiceMockCallback;
import org.im97mori.ble.service.cps.peripheral.CyclingPowerServiceMockCallback;
import org.im97mori.ble.service.dis.peripheral.DeviceInformationServiceMockCallback;

import java.util.UUID;

import static org.im97mori.ble.BLEConstants.ServiceUUID.CYCLING_POWER_SERVICE;

/**
 * Cycling Power Profile for Peripheral
 */
public class CyclingPowerProfileMockCallback extends AbstractProfileMockCallback {

    /**
     * Builder for {@link CyclingPowerProfileMockCallback}
     *
     * @param <T> subclass of {@link CyclingPowerProfileMockCallback}
     */
    public static class Builder<T extends CyclingPowerProfileMockCallback> {

        /**
         * {@link Context} instance
         */
        protected final Context mContext;

        /**
         * {@link org.im97mori.ble.service.cps.peripheral.CyclingPowerServiceMockCallback.Builder} instance
         */
        protected final CyclingPowerServiceMockCallback.Builder<? extends CyclingPowerServiceMockCallback> mCyclingPowerServiceMockCallbackBuilder;

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
         * @param context                                     {@link Context} instance
         * @param cyclingPowerServiceMockCallbackBuilder      {@link org.im97mori.ble.service.cps.peripheral.CyclingPowerServiceMockCallback.Builder} instance
         * @param deviceInformationServiceMockCallbackBuilder {@link org.im97mori.ble.service.dis.peripheral.DeviceInformationServiceMockCallback.Builder} instance
         * @param batteryServiceMockCallbackBuilder           {@link org.im97mori.ble.service.bas.peripheral.BatteryServiceMockCallback.Builder} instance
         */
        public Builder(@NonNull Context context
                , @NonNull CyclingPowerServiceMockCallback.Builder<? extends CyclingPowerServiceMockCallback> cyclingPowerServiceMockCallbackBuilder
                , @Nullable DeviceInformationServiceMockCallback.Builder<? extends DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder
                , @Nullable BatteryServiceMockCallback.Builder<? extends BatteryServiceMockCallback> batteryServiceMockCallbackBuilder) {
            mContext = context;
            mCyclingPowerServiceMockCallbackBuilder = cyclingPowerServiceMockCallbackBuilder;
            mDeviceInformationServiceMockCallbackBuilder = deviceInformationServiceMockCallbackBuilder;
            mBatteryServiceMockCallbackBuilder = batteryServiceMockCallbackBuilder;
        }

        /**
         * @see #addCyclingPowerFeature(byte[])
         */
        @NonNull
        public Builder<T> addCyclingPowerFeature(@NonNull CyclingPowerFeature bloodPressureFeature) {
            return addCyclingPowerFeature(bloodPressureFeature.getBytes());
        }

        /**
         * @see #addCyclingPowerFeature(int, long, byte[])
         */
        @NonNull
        public Builder<T> addCyclingPowerFeature(@NonNull byte[] value) {
            return addCyclingPowerFeature(BluetoothGatt.GATT_SUCCESS, 0, value);
        }

        /**
         * @see org.im97mori.ble.service.cps.peripheral.CyclingPowerServiceMockCallback.Builder#addCyclingPowerFeature(int, long, byte[])
         */
        @NonNull
        public Builder<T> addCyclingPowerFeature(int responseCode, long delay, @NonNull byte[] value) {
            mCyclingPowerServiceMockCallbackBuilder.addCyclingPowerFeature(responseCode, delay, value);
            return this;
        }

        /**
         * @see org.im97mori.ble.service.cps.peripheral.CyclingPowerServiceMockCallback.Builder#removeCyclingPowerFeature()
         */
        @NonNull
        public Builder<T> removeCyclingPowerFeature() {
            mCyclingPowerServiceMockCallbackBuilder.removeCyclingPowerFeature();
            return this;
        }

        /**
         * @see #addCyclingPowerMeasurement(int, long, byte[], int, int, long, byte[])
         */
        @NonNull
        public Builder<T> addCyclingPowerMeasurement(@NonNull CyclingPowerMeasurement cyclingPowerMeasurement, @NonNull ClientCharacteristicConfiguration clientCharacteristicConfiguration) {
            return addCyclingPowerMeasurement(BluetoothGatt.GATT_SUCCESS, 0, cyclingPowerMeasurement.getBytes(), -1, BluetoothGatt.GATT_SUCCESS, 0, clientCharacteristicConfiguration.getBytes());
        }

        /**
         * @see org.im97mori.ble.service.cps.peripheral.CyclingPowerServiceMockCallback.Builder#addCyclingPowerMeasurement(int, long, byte[], int, int, long, byte[])
         */
        @NonNull
        public Builder<T> addCyclingPowerMeasurement(int characteristicResponseCode, long characteristicDelay, @NonNull byte[] characteristicValue, int notificationCount, int descriptorResponseCode, long descriptorDelay, @NonNull byte[] descriptorValue) {
            mCyclingPowerServiceMockCallbackBuilder.addCyclingPowerMeasurement(characteristicResponseCode, characteristicDelay, characteristicValue, notificationCount, descriptorResponseCode, descriptorDelay, descriptorValue);
            return this;
        }

        /**
         * @see org.im97mori.ble.service.cps.peripheral.CyclingPowerServiceMockCallback.Builder#removeCyclingPowerMeasurement()
         */
        @NonNull
        public Builder<T> removeCyclingPowerMeasurement() {
            mCyclingPowerServiceMockCallbackBuilder.removeCyclingPowerMeasurement();
            return this;
        }

        /**
         * @see #addSensorLocation(byte[])
         */
        @NonNull
        public Builder<T> addSensorLocation(@NonNull SensorLocation sensorLocation) {
            return addSensorLocation(sensorLocation.getBytes());
        }

        /**
         * @see #addSensorLocation(int, long, byte[])
         */
        @NonNull
        public Builder<T> addSensorLocation(@NonNull byte[] value) {
            return addSensorLocation(BluetoothGatt.GATT_SUCCESS, 0, value);
        }

        /**
         * @see org.im97mori.ble.service.cps.peripheral.CyclingPowerServiceMockCallback.Builder#addSensorLocation(int, long, byte[])
         */
        @NonNull
        public Builder<T> addSensorLocation(int responseCode, long delay, @NonNull byte[] value) {
            mCyclingPowerServiceMockCallbackBuilder.addSensorLocation(responseCode, delay, value);
            return this;
        }

        /**
         * @see org.im97mori.ble.service.cps.peripheral.CyclingPowerServiceMockCallback.Builder#removeSensorLocation()
         */
        @NonNull
        public Builder<T> removeSensorLocation() {
            mCyclingPowerServiceMockCallbackBuilder.removeSensorLocation();
            return this;
        }


        /**
         * @see org.im97mori.ble.service.cps.peripheral.CyclingPowerServiceMockCallback.Builder#addCyclingPowerControlPoint(int, long, int, long, byte[], int, int, int, byte[], int, int, byte[], int, int, byte[], int, int, byte[], int, int, byte[], int, byte[], int, int, byte[], int, byte[], int, byte[])
         */
        @NonNull
        public Builder<T> addCyclingPowerControlPoint(int characteristicResponseCode
                , long characteristicDelay
                , int descriptorResponseCode
                , long descriptorDelay
                , @NonNull byte[] descriptorValue
                , int setCumulativeValueResponseValue
                , int updateSensorLocationResponseValue
                , int requestSupportedSensorLocationsResponseValue
                , @NonNull byte[] requestSupportedSensorLocationsResponseParameter
                , int setCrankLengthResponseValue
                , int requestCrankLengthResponseValue
                , @NonNull byte[] requestCrankLengthResponseParameter
                , int setChainLengthResponseValue
                , int requestChainLengthResponseValue
                , @NonNull byte[] requestChainLengthResponseParameter
                , int setChainWeightResponseValue
                , int requestChainWeightResponseValue
                , @NonNull byte[] requestChainWeightResponseParameter
                , int setSpanLengthResponseValue
                , int requestSpanLengthResponseValue
                , @NonNull byte[] requestSpanLengthResponseParameter
                , int startOffsetCompensationResponseValue
                , @NonNull byte[] startOffsetCompensationResponseParameter
                , int maskCyclingPowerMeasurementCharacteristicContentResponseValue
                , int requestSamplingRateResponseValue
                , @NonNull byte[] requestSamplingRateResponseParameter
                , int requestFactoryCalibrationDateResponseValue
                , @NonNull byte[] requestFactoryCalibrationDateResponseParameter
                , int startEnhancedOffsetCompensationResponseValue
                , @NonNull byte[] startEnhancedOffsetCompensationResponseParameter) {
            mCyclingPowerServiceMockCallbackBuilder.addCyclingPowerControlPoint(characteristicResponseCode, characteristicDelay, descriptorResponseCode, descriptorDelay, descriptorValue, setCumulativeValueResponseValue, updateSensorLocationResponseValue, requestSupportedSensorLocationsResponseValue, requestSupportedSensorLocationsResponseParameter, setCrankLengthResponseValue, requestCrankLengthResponseValue, requestCrankLengthResponseParameter, setChainLengthResponseValue, requestChainLengthResponseValue, requestChainLengthResponseParameter, setChainWeightResponseValue, requestChainWeightResponseValue, requestChainWeightResponseParameter, setSpanLengthResponseValue, requestSpanLengthResponseValue, requestSpanLengthResponseParameter, startOffsetCompensationResponseValue, startOffsetCompensationResponseParameter, maskCyclingPowerMeasurementCharacteristicContentResponseValue, requestSamplingRateResponseValue, requestSamplingRateResponseParameter, requestFactoryCalibrationDateResponseValue, requestFactoryCalibrationDateResponseParameter, startEnhancedOffsetCompensationResponseValue, startEnhancedOffsetCompensationResponseParameter);
            return this;
        }

        /**
         * @see org.im97mori.ble.service.cps.peripheral.CyclingPowerServiceMockCallback.Builder#removeCyclingPowerControlPoint()
         */
        @NonNull
        public Builder<T> removeCyclingPowerControlPoint() {
            mCyclingPowerServiceMockCallbackBuilder.removeCyclingPowerControlPoint();
            return this;
        }

        /**
         * @see #addCyclingPowerVector(int, long, byte[], int, int, long, byte[])
         */
        @NonNull
        public Builder<T> addCyclingPowerVector(@NonNull CyclingPowerVector cyclingPowerVector, @NonNull ClientCharacteristicConfiguration clientCharacteristicConfiguration) {
            return addCyclingPowerVector(BluetoothGatt.GATT_SUCCESS, 0, cyclingPowerVector.getBytes(), -1, BluetoothGatt.GATT_SUCCESS, 0, clientCharacteristicConfiguration.getBytes());
        }

        /**
         * @see org.im97mori.ble.service.cps.peripheral.CyclingPowerServiceMockCallback.Builder#addCyclingPowerVector(int, long, byte[], int, int, long, byte[])
         */
        @NonNull
        public Builder<T> addCyclingPowerVector(int characteristicResponseCode, long characteristicDelay, @NonNull byte[] characteristicValue, int notificationCount, int descriptorResponseCode, long descriptorDelay, @NonNull byte[] descriptorValue) {
            mCyclingPowerServiceMockCallbackBuilder.addCyclingPowerVector(characteristicResponseCode, characteristicDelay, characteristicValue, notificationCount, descriptorResponseCode, descriptorDelay, descriptorValue);
            return this;
        }

        /**
         * @see org.im97mori.ble.service.cps.peripheral.CyclingPowerServiceMockCallback.Builder#removeCyclingPowerVector()
         */
        @NonNull
        public Builder<T> removeCyclingPowerVector() {
            mCyclingPowerServiceMockCallbackBuilder.removeCyclingPowerVector();
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
         * @return {@link CyclingPowerProfileMockCallback} instance
         */
        public CyclingPowerProfileMockCallback build() {
            if (mDeviceInformationServiceMockCallbackBuilder != null) {
                if (!mHasManufacturerNameString) {
                    throw new RuntimeException("no Manufacturer Name String data");
                }
                if (!mHasModelNumberString) {
                    throw new RuntimeException("no Model Number String data");
                }
            }
            return new CyclingPowerProfileMockCallback(mContext
                    , mCyclingPowerServiceMockCallbackBuilder.build()
                    , mDeviceInformationServiceMockCallbackBuilder == null ? null : mDeviceInformationServiceMockCallbackBuilder.build()
                    , mBatteryServiceMockCallbackBuilder == null ? null : mBatteryServiceMockCallbackBuilder.build());
        }

    }

    /**
     * @param context                              {@link Context} instance
     * @param cyclingPowerServiceMockCallback      {@link CyclingPowerServiceMockCallback} instance
     * @param deviceInformationServiceMockCallback {@link DeviceInformationServiceMockCallback} instance
     * @param batteryServiceMockCallback           {@link BatteryServiceMockCallback} instance
     */
    public CyclingPowerProfileMockCallback(@NonNull Context context
            , @NonNull CyclingPowerServiceMockCallback cyclingPowerServiceMockCallback
            , @Nullable DeviceInformationServiceMockCallback deviceInformationServiceMockCallback
            , @Nullable BatteryServiceMockCallback batteryServiceMockCallback) {
        super(context, true, cyclingPowerServiceMockCallback, deviceInformationServiceMockCallback, batteryServiceMockCallback);
    }

    /**
     * {@inheritDoc}
     */
    @NonNull
    @Override
    public UUID getServiceUUID() {
        return CYCLING_POWER_SERVICE;
    }

}
