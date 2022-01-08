package org.im97mori.ble.profile.wsp.peripheral;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.im97mori.ble.BLEServerCallback;
import org.im97mori.ble.characteristic.u2a0f.LocalTimeInformation;
import org.im97mori.ble.characteristic.u2a14.ReferenceTimeInformation;
import org.im97mori.ble.characteristic.u2a19.BatteryLevel;
import org.im97mori.ble.characteristic.u2a23.SystemId;
import org.im97mori.ble.characteristic.u2a24.ModelNumberString;
import org.im97mori.ble.characteristic.u2a29.ManufacturerNameString;
import org.im97mori.ble.characteristic.u2a2b.CurrentTime;
import org.im97mori.ble.characteristic.u2a80.Age;
import org.im97mori.ble.characteristic.u2a85.DateOfBirth;
import org.im97mori.ble.characteristic.u2a8a.FirstName;
import org.im97mori.ble.characteristic.u2a8c.Gender;
import org.im97mori.ble.characteristic.u2a8e.Height;
import org.im97mori.ble.characteristic.u2a9d.WeightMeasurement;
import org.im97mori.ble.characteristic.u2a9e.WeightScaleFeature;
import org.im97mori.ble.descriptor.u2902.ClientCharacteristicConfiguration;
import org.im97mori.ble.descriptor.u2904.CharacteristicPresentationFormat;
import org.im97mori.ble.profile.peripheral.AbstractProfileMockCallback;
import org.im97mori.ble.service.bas.peripheral.BatteryServiceMockCallback;
import org.im97mori.ble.service.cts.peripheral.CurrentTimeServiceMockCallback;
import org.im97mori.ble.service.dis.peripheral.DeviceInformationServiceMockCallback;
import org.im97mori.ble.service.uds.peripheral.UserDataServiceMockCallback;
import org.im97mori.ble.service.wss.peripheral.WeightScaleServiceMockCallback;

import java.util.Arrays;
import java.util.UUID;
import java.util.stream.Stream;

import static org.im97mori.ble.constants.ServiceUUID.WEIGHT_SCALE_SERVICE;

/**
 * Weight Scale Profile for Peripheral
 * (Body composition service is not supported)
 */
public class WeightScaleProfileMockCallback extends AbstractProfileMockCallback {

    /**
     * Builder for {@link WeightScaleProfileMockCallback}
     *
     * @param <T> subclass of {@link WeightScaleProfileMockCallback}
     */
    public static class Builder<T extends WeightScaleProfileMockCallback> {

        /**
         * {@link Context} instance
         */
        protected final Context mContext;

        /**
         * {@link org.im97mori.ble.service.wss.peripheral.WeightScaleServiceMockCallback.Builder} instance
         */
        protected final WeightScaleServiceMockCallback.Builder<? extends WeightScaleServiceMockCallback> mWeightScaleServiceMockCallbackBuilder;

        /**
         * {@link org.im97mori.ble.service.dis.peripheral.DeviceInformationServiceMockCallback.Builder} instance
         */
        protected final DeviceInformationServiceMockCallback.Builder<? extends DeviceInformationServiceMockCallback> mDeviceInformationServiceMockCallbackBuilder;

        /**
         * {@link org.im97mori.ble.service.uds.peripheral.UserDataServiceMockCallback.Builder} instance
         */
        protected final UserDataServiceMockCallback.Builder<? extends UserDataServiceMockCallback> mUserDataServiceMockCallbackBuilder;

        /**
         * {@link org.im97mori.ble.service.bas.peripheral.BatteryServiceMockCallback.Builder} instance
         */
        protected final BatteryServiceMockCallback.Builder<? extends BatteryServiceMockCallback> mBatteryServiceMockCallbackBuilder;

        /**
         * {@link org.im97mori.ble.service.cts.peripheral.CurrentTimeServiceMockCallback.Builder} instance
         */
        protected final CurrentTimeServiceMockCallback.Builder<? extends CurrentTimeServiceMockCallback> mCurrentTimeServiceMockCallbackBuilder;

        /**
         * flag for Manufacturer Name String data
         */
        protected boolean mHasManufacturerNameString;

        /**
         * flag for Model Number String data
         */
        protected boolean mHasModelNumberString;

        /**
         * Weight Scale Feature data
         */
        protected byte[] mWeightScaleFeatureCharacteristicData;

        /**
         * @param context                                     {@link Context} instance
         * @param weightScaleServiceMockCallbackBuilder       {@link WspWeightScaleServiceMockCallback.Builder} instance
         * @param deviceInformationServiceMockCallbackBuilder {@link org.im97mori.ble.service.dis.peripheral.DeviceInformationServiceMockCallback.Builder} instance
         * @param userDataServiceMockCallbackBuilder          {@link org.im97mori.ble.service.uds.peripheral.UserDataServiceMockCallback.Builder} instance
         * @param batteryServiceMockCallbackBuilder           {@link org.im97mori.ble.service.bas.peripheral.BatteryServiceMockCallback.Builder} instance
         * @param currentTimeServiceMockCallbackBuilder       {@link org.im97mori.ble.service.cts.peripheral.CurrentTimeServiceMockCallback.Builder} instance
         */
        public Builder(@NonNull Context context
                , @NonNull WeightScaleServiceMockCallback.Builder<? extends WeightScaleServiceMockCallback> weightScaleServiceMockCallbackBuilder
                , @NonNull DeviceInformationServiceMockCallback.Builder<? extends DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder
                , @Nullable UserDataServiceMockCallback.Builder<? extends UserDataServiceMockCallback> userDataServiceMockCallbackBuilder
                , @Nullable BatteryServiceMockCallback.Builder<? extends BatteryServiceMockCallback> batteryServiceMockCallbackBuilder
                , @Nullable CurrentTimeServiceMockCallback.Builder<? extends CurrentTimeServiceMockCallback> currentTimeServiceMockCallbackBuilder) {
            mContext = context;
            mWeightScaleServiceMockCallbackBuilder = weightScaleServiceMockCallbackBuilder;
            mDeviceInformationServiceMockCallbackBuilder = deviceInformationServiceMockCallbackBuilder;
            mUserDataServiceMockCallbackBuilder = userDataServiceMockCallbackBuilder;
            mBatteryServiceMockCallbackBuilder = batteryServiceMockCallbackBuilder;
            mCurrentTimeServiceMockCallbackBuilder = currentTimeServiceMockCallbackBuilder;
        }

        /**
         * @see #addWeightScaleFeature(byte[])
         */
        @NonNull
        public Builder<T> addWeightScaleFeature(@NonNull WeightScaleFeature weightScaleFeature) {
            return addWeightScaleFeature(weightScaleFeature.getBytes());
        }

        /**
         * @see #addWeightScaleFeature(int, long, byte[])
         */
        @NonNull
        public Builder<T> addWeightScaleFeature(@NonNull byte[] value) {
            return addWeightScaleFeature(BluetoothGatt.GATT_SUCCESS
                    , 0
                    , value);
        }

        /**
         * @see org.im97mori.ble.service.wss.peripheral.WeightScaleServiceMockCallback.Builder#addWeightScaleFeature(int, long, byte[])
         */
        @NonNull
        public Builder<T> addWeightScaleFeature(int responseCode, long delay, @NonNull byte[] value) {
            mWeightScaleFeatureCharacteristicData = value;
            mWeightScaleServiceMockCallbackBuilder.addWeightScaleFeature(responseCode, delay, value);
            return this;
        }

        /**
         * @see org.im97mori.ble.service.wss.peripheral.WeightScaleServiceMockCallback.Builder#removeWeightScaleFeature()
         */
        @NonNull
        public Builder<T> removeWeightScaleFeature() {
            mWeightScaleFeatureCharacteristicData = null;
            mWeightScaleServiceMockCallbackBuilder.removeWeightScaleFeature();
            return this;
        }

        /**
         * @see #addWeightMeasurement(int, long, byte[], int, int, long, byte[])
         */
        @NonNull
        public Builder<T> addWeightMeasurement(@NonNull WeightMeasurement weightMeasurement, @NonNull ClientCharacteristicConfiguration clientCharacteristicConfiguration) {
            return addWeightMeasurement(BluetoothGatt.GATT_SUCCESS, 0, weightMeasurement.getBytes(), -1, BluetoothGatt.GATT_SUCCESS, 0, clientCharacteristicConfiguration.getBytes());
        }

        /**
         * @see org.im97mori.ble.service.wss.peripheral.WeightScaleServiceMockCallback.Builder#addWeightMeasurement(int, long, byte[], int, int, long, byte[])
         */
        @NonNull
        public Builder<T> addWeightMeasurement(int characteristicResponseCode, long characteristicDelay, @NonNull byte[] characteristicValue, int notificationCount, int descriptorResponseCode, long descriptorDelay, @NonNull byte[] descriptorValue) {
            mWeightScaleServiceMockCallbackBuilder.addWeightMeasurement(characteristicResponseCode, characteristicDelay, characteristicValue, notificationCount, descriptorResponseCode, descriptorDelay, descriptorValue);
            return this;
        }

        /**
         * @see org.im97mori.ble.service.wss.peripheral.WeightScaleServiceMockCallback.Builder#removeWeightMeasurement()
         */
        @NonNull
        public Builder<T> removeWeightMeasurement() {
            mWeightScaleServiceMockCallbackBuilder.removeWeightMeasurement();
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
            mHasManufacturerNameString = true;
            mDeviceInformationServiceMockCallbackBuilder.addManufacturerNameString(responseCode, delay, value);
            return this;
        }

        /**
         * remove Manufacturer Name String characteristic
         *
         * @return {@link org.im97mori.ble.service.dis.peripheral.DeviceInformationServiceMockCallback.Builder} instance
         */
        @NonNull
        public Builder<T> removeManufacturerNameString() {
            mHasManufacturerNameString = false;
            mDeviceInformationServiceMockCallbackBuilder.removeManufacturerNameString();
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
            mHasModelNumberString = true;
            mDeviceInformationServiceMockCallbackBuilder.addModelNumberString(responseCode, delay, value);
            return this;
        }

        /**
         * @see org.im97mori.ble.service.dis.peripheral.DeviceInformationServiceMockCallback.Builder#removeModelNumberString()
         */
        @NonNull
        public Builder<T> removeModelNumberString() {
            mHasModelNumberString = false;
            mDeviceInformationServiceMockCallbackBuilder.removeModelNumberString();
            return this;
        }

        /**
         * @see #addSystemId(SystemId)
         */
        public Builder<T> addSystemId(long manufacturerIdentifier, int organizationallyUniqueIdentifier) {
            return addSystemId(new SystemId(manufacturerIdentifier, organizationallyUniqueIdentifier));
        }

        /**
         * @see #addSystemId(byte[])
         */
        public Builder<T> addSystemId(SystemId systemId) {
            return addSystemId(systemId.getBytes());
        }

        /**
         * @see #addSystemId(int, long, byte[])
         */
        public Builder<T> addSystemId(@NonNull byte[] value) {
            return addSystemId(BluetoothGatt.GATT_SUCCESS
                    , 0
                    , value);
        }

        /**
         * @see org.im97mori.ble.service.dis.peripheral.DeviceInformationServiceMockCallback.Builder#addSystemId(int, long, byte[])
         */
        public Builder<T> addSystemId(int responseCode, long delay, @NonNull byte[] value) {
            mDeviceInformationServiceMockCallbackBuilder.addSystemId(responseCode, delay, value);
            return this;
        }

        /**
         * @see org.im97mori.ble.service.dis.peripheral.DeviceInformationServiceMockCallback.Builder#removeSystemId()
         */
        public Builder<T> removeSystemId() {
            mDeviceInformationServiceMockCallbackBuilder.removeSystemId();
            return this;
        }

        /**
         * @see #addFirstName(FirstName)
         */
        @NonNull
        public Builder<T> addFirstName(@NonNull String firstName) {
            return addFirstName(new FirstName(firstName));
        }

        /**
         * @see #addFirstName(byte[])
         */
        @NonNull
        public Builder<T> addFirstName(@NonNull FirstName firstName) {
            return addFirstName(firstName.getBytes());
        }

        /**
         * @see #addFirstName(int, long, byte[])
         */
        @NonNull
        public Builder<T> addFirstName(@NonNull byte[] value) {
            return addFirstName(BluetoothGatt.GATT_SUCCESS
                    , 0
                    , value);
        }

        /**
         * @see org.im97mori.ble.service.uds.peripheral.UserDataServiceMockCallback.Builder#addFirstName(int, long, byte[])
         */
        @NonNull
        public Builder<T> addFirstName(int responseCode, long delay, @NonNull byte[] value) {
            if (mUserDataServiceMockCallbackBuilder != null) {
                mUserDataServiceMockCallbackBuilder.addFirstName(responseCode, delay, value);
            }
            return this;
        }

        /**
         * @see org.im97mori.ble.service.uds.peripheral.UserDataServiceMockCallback.Builder#removeFirstName()
         */
        @NonNull
        public Builder<T> removeFirstName() {
            if (mUserDataServiceMockCallbackBuilder != null) {
                mUserDataServiceMockCallbackBuilder.removeFirstName();
            }
            return this;
        }

        /**
         * @see #addAge(Age)
         */
        @NonNull
        public Builder<T> addAge(int age) {
            return addAge(new Age(age));
        }

        /**
         * @see #addAge(byte[])
         */
        @NonNull
        public Builder<T> addAge(@NonNull Age age) {
            return addAge(age.getBytes());
        }

        /**
         * @see #addAge(int, long, byte[])
         */
        @NonNull
        public Builder<T> addAge(@NonNull byte[] value) {
            return addAge(BluetoothGatt.GATT_SUCCESS
                    , 0
                    , value);
        }

        /**
         * @see org.im97mori.ble.service.uds.peripheral.UserDataServiceMockCallback.Builder#addAge(int, long, byte[])
         */
        @NonNull
        public Builder<T> addAge(int responseCode, long delay, @NonNull byte[] value) {
            if (mUserDataServiceMockCallbackBuilder != null) {
                mUserDataServiceMockCallbackBuilder.addAge(responseCode, delay, value);
            }
            return this;
        }

        /**
         * @see org.im97mori.ble.service.uds.peripheral.UserDataServiceMockCallback.Builder#removeAge()
         */
        @NonNull
        public Builder<T> removeAge() {
            if (mUserDataServiceMockCallbackBuilder != null) {
                mUserDataServiceMockCallbackBuilder.removeAge();
            }
            return this;
        }

        /**
         * @see #addDateOfBirth(DateOfBirth)
         */
        @NonNull
        public Builder<T> addDateOfBirth(int year, int month, int day) {
            return addDateOfBirth(new DateOfBirth(year, month, day));
        }

        /**
         * @see #addDateOfBirth(byte[])
         */
        @NonNull
        public Builder<T> addDateOfBirth(@NonNull DateOfBirth dateOfBirth) {
            return addDateOfBirth(dateOfBirth.getBytes());
        }

        /**
         * @see #addDateOfBirth(int, long, byte[])
         */
        @NonNull
        public Builder<T> addDateOfBirth(@NonNull byte[] value) {
            return addDateOfBirth(BluetoothGatt.GATT_SUCCESS
                    , 0
                    , value);
        }

        /**
         * @see org.im97mori.ble.service.uds.peripheral.UserDataServiceMockCallback.Builder#addDateOfBirth(int, long, byte[])
         */
        @NonNull
        public Builder<T> addDateOfBirth(int responseCode, long delay, @NonNull byte[] value) {
            if (mUserDataServiceMockCallbackBuilder != null) {
                mUserDataServiceMockCallbackBuilder.addDateOfBirth(responseCode, delay, value);
            }
            return this;
        }

        /**
         * @see org.im97mori.ble.service.uds.peripheral.UserDataServiceMockCallback.Builder#removeDateOfBirth()
         */
        @NonNull
        public Builder<T> removeDateOfBirth() {
            if (mUserDataServiceMockCallbackBuilder != null) {
                mUserDataServiceMockCallbackBuilder.removeDateOfBirth();
            }
            return this;
        }

        /**
         * @see #addGender(Gender)
         */
        @NonNull
        public Builder<T> addGender(int gender) {
            return addGender(new Gender(gender));
        }

        /**
         * @see #addGender(byte[])
         */
        @NonNull
        public Builder<T> addGender(@NonNull Gender gender) {
            return addGender(gender.getBytes());
        }

        /**
         * @see #addGender(int, long, byte[])
         */
        @NonNull
        public Builder<T> addGender(@NonNull byte[] value) {
            return addGender(BluetoothGatt.GATT_SUCCESS
                    , 0
                    , value);
        }

        /**
         * @see org.im97mori.ble.service.uds.peripheral.UserDataServiceMockCallback.Builder#addGender(int, long, byte[])
         */
        @NonNull
        public Builder<T> addGender(int responseCode, long delay, @NonNull byte[] value) {
            if (mUserDataServiceMockCallbackBuilder != null) {
                mUserDataServiceMockCallbackBuilder.addGender(responseCode, delay, value);
            }
            return this;
        }

        /**
         * @see org.im97mori.ble.service.uds.peripheral.UserDataServiceMockCallback.Builder#removeGender()
         */
        @NonNull
        public Builder<T> removeGender() {
            if (mUserDataServiceMockCallbackBuilder != null) {
                mUserDataServiceMockCallbackBuilder.removeGender();
            }
            return this;
        }

        /**
         * @see #addHeight(Height)
         */
        @NonNull
        public Builder<T> addHeight(int height) {
            return addHeight(new Height(height));
        }

        /**
         * @see #addHeight(byte[])
         */
        @NonNull
        public Builder<T> addHeight(@NonNull Height height) {
            return addHeight(height.getBytes());
        }

        /**
         * @see #addHeight(int, long, byte[])
         */
        @NonNull
        public Builder<T> addHeight(@NonNull byte[] value) {
            return addHeight(BluetoothGatt.GATT_SUCCESS
                    , 0
                    , value);
        }

        /**
         * @see org.im97mori.ble.service.uds.peripheral.UserDataServiceMockCallback.Builder#addHeight(int, long, byte[])
         */
        @NonNull
        public Builder<T> addHeight(int responseCode, long delay, @NonNull byte[] value) {
            if (mUserDataServiceMockCallbackBuilder != null) {
                mUserDataServiceMockCallbackBuilder.addHeight(responseCode, delay, value);
            }
            return this;
        }

        /**
         * @see org.im97mori.ble.service.uds.peripheral.UserDataServiceMockCallback.Builder#removeHeight()
         */
        @NonNull
        public Builder<T> removeHeight() {
            if (mUserDataServiceMockCallbackBuilder != null) {
                mUserDataServiceMockCallbackBuilder.removeHeight();
            }
            return this;
        }

        /**
         * @see #addDatabaseChangeIncrement(int, long, boolean, int, long, byte[])
         */
        @NonNull
        public Builder<T> addDatabaseChangeIncrement(@NonNull ClientCharacteristicConfiguration clientCharacteristicConfiguration) {
            return addDatabaseChangeIncrement(BluetoothGatt.GATT_SUCCESS, 0, true, BluetoothGatt.GATT_SUCCESS, 0, clientCharacteristicConfiguration.getBytes());
        }

        /**
         * @see org.im97mori.ble.service.uds.peripheral.UserDataServiceMockCallback.Builder#addDatabaseChangeIncrement(ClientCharacteristicConfiguration)
         */
        @NonNull
        public Builder<T> addDatabaseChangeIncrement(int characteristicResponseCode, long characteristicDelay, boolean isNotificatable, int descriptorResponseCode, long descriptorDelay, @NonNull byte[] descriptorValue) {
            if (mUserDataServiceMockCallbackBuilder != null) {
                mUserDataServiceMockCallbackBuilder.addDatabaseChangeIncrement(characteristicResponseCode, characteristicDelay, isNotificatable, descriptorResponseCode, descriptorDelay, descriptorValue);
            }
            return this;
        }

        /**
         * @see org.im97mori.ble.service.uds.peripheral.UserDataServiceMockCallback.Builder#removeDatabaseChangeIncrement()
         */
        @NonNull
        public Builder<T> removeDatabaseChangeIncrement() {
            if (mUserDataServiceMockCallbackBuilder != null) {
                mUserDataServiceMockCallbackBuilder.removeDatabaseChangeIncrement();
            }
            return this;
        }

        /**
         * @see #addUserIndex()
         */
        @NonNull
        public Builder<T> addUserIndex() {
            return addUserIndex(BluetoothGatt.GATT_SUCCESS, 0);
        }

        /**
         * @see org.im97mori.ble.service.uds.peripheral.UserDataServiceMockCallback.Builder#addUserIndex(int, long)
         */
        @NonNull
        public Builder<T> addUserIndex(int responseCode, long delay) {
            if (mUserDataServiceMockCallbackBuilder != null) {
                mUserDataServiceMockCallbackBuilder.addUserIndex(responseCode, delay);
            }
            return this;
        }

        /**
         * @see org.im97mori.ble.service.uds.peripheral.UserDataServiceMockCallback.Builder#removeUserIndex()
         */
        @NonNull
        public Builder<T> removeUserIndex() {
            if (mUserDataServiceMockCallbackBuilder != null) {
                mUserDataServiceMockCallbackBuilder.removeUserIndex();
            }
            return this;
        }

        /**
         * @see #addRegisteredUser(int, long, int, long, byte[])
         */
        @NonNull
        public Builder<T> addRegisteredUser(@NonNull ClientCharacteristicConfiguration clientCharacteristicConfiguration) {
            return addRegisteredUser(BluetoothGatt.GATT_SUCCESS, 0, 0, 0, clientCharacteristicConfiguration.getBytes());
        }

        /**
         * @see org.im97mori.ble.service.uds.peripheral.UserDataServiceMockCallback.Builder#addRegisteredUser(int, long, int, long, byte[])
         */
        @NonNull
        public Builder<T> addRegisteredUser(int characteristicResponseCode, long characteristicDelay, int descriptorResponseCode, long descriptorDelay, @NonNull byte[] descriptorValue) {
            if (mUserDataServiceMockCallbackBuilder != null) {
                mUserDataServiceMockCallbackBuilder.addRegisteredUser(characteristicResponseCode, characteristicDelay, descriptorResponseCode, descriptorDelay, descriptorValue);
            }
            return this;
        }

        /**
         * @see org.im97mori.ble.service.uds.peripheral.UserDataServiceMockCallback.Builder#removeRegisteredUser()
         */
        @NonNull
        public Builder<T> removeRegisteredUser() {
            if (mUserDataServiceMockCallbackBuilder != null) {
                mUserDataServiceMockCallbackBuilder.removeRegisteredUser();
            }
            return this;
        }

        /**
         * @see org.im97mori.ble.service.uds.peripheral.UserDataServiceMockCallback.Builder#addUserControlPoint(long, int, int, int, int, int, int, long, byte[])
         */
        @NonNull
        public Builder<T> addUserControlPoint(long characteristicDelay
                , int registerNewUserResponseValue
                , int consentResponseValue
                , int deleteUserDataResponseValue
                , int listAllUsersResponseValue
                , int deleteUsersResponseValue
                , int descriptorResponseCode
                , long descriptorDelay
                , @NonNull byte[] descriptorValue) {
            if (mUserDataServiceMockCallbackBuilder != null) {
                mUserDataServiceMockCallbackBuilder.addUserControlPoint(characteristicDelay, registerNewUserResponseValue, consentResponseValue, deleteUserDataResponseValue, listAllUsersResponseValue, deleteUsersResponseValue, descriptorResponseCode, descriptorDelay, descriptorValue);
            }
            return this;
        }

        /**
         * @see org.im97mori.ble.service.uds.peripheral.UserDataServiceMockCallback.Builder#removeUserControlPoint()
         */
        @NonNull
        public Builder<T> removeUserControlPoint() {
            if (mUserDataServiceMockCallbackBuilder != null) {
                mUserDataServiceMockCallbackBuilder.removeUserControlPoint();
            }
            return this;
        }

        /**
         * @see #addBatteryLevel(int, int, int, long, byte[], int)
         */
        @NonNull
        public Builder<T> addBatteryLevel(int index, @NonNull BatteryLevel batteryLevel) {
            return addBatteryLevel(index, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGattCharacteristic.PERMISSION_READ, 0, batteryLevel.getBytes(), -1);
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
        public Builder<T> setBatteryLevelCharacteristicPresentationFormat(int index, CharacteristicPresentationFormat characteristicPresentationFormat) {
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
        public Builder<T> setBatteryLevelClientCharacteristicConfiguration(int index, ClientCharacteristicConfiguration clientCharacteristicConfiguration) {
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
         * @see #addCurrentTime(boolean, int, long, byte[], int, int, long, byte[])
         */
        @NonNull
        public Builder<T> addCurrentTime(@NonNull CurrentTime currentTime, @NonNull ClientCharacteristicConfiguration clientCharacteristicConfiguration) {
            return addCurrentTime(true, BluetoothGatt.GATT_SUCCESS, 0, currentTime.getBytes(), 1, BluetoothGatt.GATT_SUCCESS, 0, clientCharacteristicConfiguration.getBytes());
        }

        /**
         * @see org.im97mori.ble.service.cts.peripheral.CurrentTimeServiceMockCallback.Builder#addCurrentTime(boolean, int, long, byte[], int, int, long, byte[])
         */
        @NonNull
        public Builder<T> addCurrentTime(boolean isWritable, int characteristicResponseCode, long characteristicDelay, @NonNull byte[] characteristicValue, int notificationCount, int descriptorResponseCode, long descriptorDelay, @NonNull byte[] descriptorValue) {
            if (mCurrentTimeServiceMockCallbackBuilder != null) {
                mCurrentTimeServiceMockCallbackBuilder.addCurrentTime(isWritable, characteristicResponseCode, characteristicDelay, characteristicValue, notificationCount, descriptorResponseCode, descriptorDelay, descriptorValue);
            }
            return this;
        }

        /**
         * @see org.im97mori.ble.service.cts.peripheral.CurrentTimeServiceMockCallback.Builder#removeCurrentTime()
         */
        @NonNull
        public Builder<T> removeCurrentTime() {
            if (mCurrentTimeServiceMockCallbackBuilder != null) {
                mCurrentTimeServiceMockCallbackBuilder.removeCurrentTime();
            }
            return this;
        }

        /**
         * @see #addLocalTimeInformation(byte[])
         */
        @NonNull
        public Builder<T> addLocalTimeInformation(@NonNull LocalTimeInformation localTimeInformation) {
            return addLocalTimeInformation(localTimeInformation.getBytes());
        }

        /**
         * @see #addLocalTimeInformation(boolean, int, long, byte[])
         */
        @NonNull
        public Builder<T> addLocalTimeInformation(@NonNull byte[] value) {
            return addLocalTimeInformation(true, BluetoothGatt.GATT_SUCCESS, 0, value);
        }

        /**
         * @see org.im97mori.ble.service.cts.peripheral.CurrentTimeServiceMockCallback.Builder#addLocalTimeInformation(boolean, int, long, byte[])
         */
        @NonNull
        public Builder<T> addLocalTimeInformation(boolean isWritable, int responseCode, long delay, @NonNull byte[] value) {
            if (mCurrentTimeServiceMockCallbackBuilder != null) {
                mCurrentTimeServiceMockCallbackBuilder.addLocalTimeInformation(isWritable, responseCode, delay, value);
            }
            return this;
        }

        /**
         * @see org.im97mori.ble.service.cts.peripheral.CurrentTimeServiceMockCallback.Builder#removeLocalTimeInformation()
         */
        @NonNull
        public Builder<T> removeLocalTimeInformation() {
            if (mCurrentTimeServiceMockCallbackBuilder != null) {
                mCurrentTimeServiceMockCallbackBuilder.removeLocalTimeInformation();
            }
            return this;
        }

        /**
         * @see #addReferenceTimeInformation(byte[])
         */
        @NonNull
        public Builder<T> addReferenceTimeInformation(@NonNull ReferenceTimeInformation referenceTimeInformation) {
            return addReferenceTimeInformation(referenceTimeInformation.getBytes());
        }

        /**
         * @see #addReferenceTimeInformation(int, long, byte[])
         */
        @NonNull
        public Builder<T> addReferenceTimeInformation(@NonNull byte[] value) {
            return addReferenceTimeInformation(BluetoothGatt.GATT_SUCCESS, 0, value);
        }

        /**
         * @see org.im97mori.ble.service.cts.peripheral.CurrentTimeServiceMockCallback.Builder#addReferenceTimeInformation(int, long, byte[])
         */
        @NonNull
        public Builder<T> addReferenceTimeInformation(int responseCode, long delay, @NonNull byte[] value) {
            if (mCurrentTimeServiceMockCallbackBuilder != null) {
                mCurrentTimeServiceMockCallbackBuilder.addReferenceTimeInformation(responseCode, delay, value);
            }
            return this;
        }

        /**
         * @see org.im97mori.ble.service.cts.peripheral.CurrentTimeServiceMockCallback.Builder#removeReferenceTimeInformation()
         */
        @NonNull
        public Builder<T> removeReferenceTimeInformation() {
            if (mCurrentTimeServiceMockCallbackBuilder != null) {
                mCurrentTimeServiceMockCallbackBuilder.removeReferenceTimeInformation();
            }
            return this;
        }

        /**
         * @return {@link WeightScaleProfileMockCallback} instance
         */
        public WeightScaleProfileMockCallback build() {
            UserDataServiceMockCallback userDataServiceMockCallback = null;
            if (mWeightScaleFeatureCharacteristicData == null) {
                throw new RuntimeException("no Weight Scale Feature data");
            } else {
                WeightScaleFeature weightScaleFeature = new WeightScaleFeature(mWeightScaleFeatureCharacteristicData);
                if (weightScaleFeature.isWeightScaleFeatureMultipleUsersSupported()) {
                    if (mUserDataServiceMockCallbackBuilder == null) {
                        throw new RuntimeException("no User Data Service");
                    } else {
                        userDataServiceMockCallback = mUserDataServiceMockCallbackBuilder.build();
                        if (mWeightScaleServiceMockCallbackBuilder instanceof WspWeightScaleServiceMockCallback.Builder) {
                            ((WspWeightScaleServiceMockCallback.Builder<?>) mWeightScaleServiceMockCallbackBuilder).setUserDataServiceMockCallback(userDataServiceMockCallback);
                        }
                    }
                }
            }

            if (!mHasManufacturerNameString) {
                throw new RuntimeException("no Manufacturer Name String data");
            }
            if (!mHasModelNumberString) {
                throw new RuntimeException("no Model Number String data");
            }

            return new WeightScaleProfileMockCallback(mContext
                    , mWeightScaleServiceMockCallbackBuilder.build()
                    , mDeviceInformationServiceMockCallbackBuilder.build()
                    , userDataServiceMockCallback
                    , mBatteryServiceMockCallbackBuilder == null ? null : mBatteryServiceMockCallbackBuilder.build()
                    , mCurrentTimeServiceMockCallbackBuilder == null ? null : mCurrentTimeServiceMockCallbackBuilder.build());
        }

    }

    /**
     * @param context                              {@link Context} instance
     * @param weightScaleServiceMockCallback       {@link WspWeightScaleServiceMockCallback} instance
     * @param deviceInformationServiceMockCallback {@link DeviceInformationServiceMockCallback} instance
     * @param userDataServiceMockCallback          {@link UserDataServiceMockCallback} instance
     * @param batteryServiceMockCallback           {@link BatteryServiceMockCallback} instance
     * @param currentTimeServiceMockCallback       {@link CurrentTimeServiceMockCallback} instance
     * @param bleServerCallbacks                   callback array
     */
    public WeightScaleProfileMockCallback(@NonNull Context context
            , @NonNull WeightScaleServiceMockCallback weightScaleServiceMockCallback
            , @NonNull DeviceInformationServiceMockCallback deviceInformationServiceMockCallback
            , @Nullable UserDataServiceMockCallback userDataServiceMockCallback
            , @Nullable BatteryServiceMockCallback batteryServiceMockCallback
            , @Nullable CurrentTimeServiceMockCallback currentTimeServiceMockCallback
            , @NonNull BLEServerCallback... bleServerCallbacks) {
        super(context
                , true
                , Stream.concat(Arrays.stream(bleServerCallbacks)
                        , Stream.of(weightScaleServiceMockCallback, deviceInformationServiceMockCallback, userDataServiceMockCallback, batteryServiceMockCallback, currentTimeServiceMockCallback))
                        .toArray(BLEServerCallback[]::new));
    }

    /**
     * {@inheritDoc}
     */
    @NonNull
    @Override
    public UUID getServiceUUID() {
        return WEIGHT_SCALE_SERVICE;
    }

}
