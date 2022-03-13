package org.im97mori.ble.service.uds.peripheral;

import static org.im97mori.ble.constants.CharacteristicUUID.AEROBIC_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.AEROBIC_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.AEROBIC_THRESHOLD_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.AGE_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.ANAEROBIC_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.ANAEROBIC_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.ANAEROBIC_THRESHOLD_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.DATABASE_CHANGE_INCREMENT_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.DATE_OF_BIRTH_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.DATE_OF_THRESHOLD_ASSESSMENT_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.EMAIL_ADDRESS_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.FAT_BURN_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.FAT_BURN_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.FIRST_NAME_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.FIVE_ZONE_HEART_RATE_LIMITS_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.GENDER_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.HEART_RATE_MAX_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.HEIGHT_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.HIP_CIRCUMFERENCE_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.LANGUAGE_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.LAST_NAME_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.MAXIMUM_RECOMMENDED_HEART_RATE_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.REGISTERED_USER_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.RESTING_HEART_RATE_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.SPORT_TYPE_FOR_AEROBIC_AND_ANAEROBIC_THRESHOLDS_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.THREE_ZONE_HEART_RATE_LIMITS_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.TWO_ZONE_HEART_RATE_LIMITS_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.USER_CONTROL_POINT_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.USER_INDEX_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.VO2_MAX_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.WAIST_CIRCUMFERENCE_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.WEIGHT_CHARACTERISTIC;
import static org.im97mori.ble.constants.DescriptorUUID.CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
import static org.im97mori.ble.constants.ErrorCode.APPLICATION_ERROR_80;
import static org.im97mori.ble.constants.ErrorCode.APPLICATION_ERROR_9F;
import static org.im97mori.ble.constants.ErrorCode.CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR_IMPROPERLY_CONFIGURED;
import static org.im97mori.ble.constants.ErrorCode.PROCEDURE_ALREADY_IN_PROGRESS;
import static org.im97mori.ble.constants.ServiceUUID.USER_DATA_SERVICE;

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
import org.im97mori.ble.CharacteristicData;
import org.im97mori.ble.DescriptorData;
import org.im97mori.ble.ServiceData;
import org.im97mori.ble.characteristic.core.UserIndexUtils;
import org.im97mori.ble.characteristic.u2a7e.AerobicHeartRateLowerLimit;
import org.im97mori.ble.characteristic.u2a7f.AerobicThreshold;
import org.im97mori.ble.characteristic.u2a80.Age;
import org.im97mori.ble.characteristic.u2a81.AnaerobicHeartRateLowerLimit;
import org.im97mori.ble.characteristic.u2a82.AnaerobicHeartRateUpperLimit;
import org.im97mori.ble.characteristic.u2a83.AnaerobicThreshold;
import org.im97mori.ble.characteristic.u2a84.AerobicHeartRateUpperLimit;
import org.im97mori.ble.characteristic.u2a85.DateOfBirth;
import org.im97mori.ble.characteristic.u2a86.DateOfThresholdAssessment;
import org.im97mori.ble.characteristic.u2a87.EmailAddress;
import org.im97mori.ble.characteristic.u2a88.FatBurnHeartRateLowerLimit;
import org.im97mori.ble.characteristic.u2a89.FatBurnHeartRateUpperLimit;
import org.im97mori.ble.characteristic.u2a8a.FirstName;
import org.im97mori.ble.characteristic.u2a8b.FiveZoneHeartRateLimits;
import org.im97mori.ble.characteristic.u2a8c.Gender;
import org.im97mori.ble.characteristic.u2a8d.HeartRateMax;
import org.im97mori.ble.characteristic.u2a8e.Height;
import org.im97mori.ble.characteristic.u2a8f.HipCircumference;
import org.im97mori.ble.characteristic.u2a90.LastName;
import org.im97mori.ble.characteristic.u2a91.MaximumRecommendedHeartRate;
import org.im97mori.ble.characteristic.u2a92.RestingHeartRate;
import org.im97mori.ble.characteristic.u2a93.SportTypeForAerobicAndAnaerobicThresholds;
import org.im97mori.ble.characteristic.u2a94.ThreeZoneHeartRateLimits;
import org.im97mori.ble.characteristic.u2a95.TwoZoneHeartRateLimit;
import org.im97mori.ble.characteristic.u2a96.VO2Max;
import org.im97mori.ble.characteristic.u2a97.WaistCircumference;
import org.im97mori.ble.characteristic.u2a98.Weight;
import org.im97mori.ble.characteristic.u2a99.DatabaseChangeIncrement;
import org.im97mori.ble.characteristic.u2a9a.UserIndex;
import org.im97mori.ble.characteristic.u2a9f.UserControlPoint;
import org.im97mori.ble.characteristic.u2aa2.Language;
import org.im97mori.ble.characteristic.u2b37.RegisteredUser;
import org.im97mori.ble.descriptor.u2902.ClientCharacteristicConfiguration;
import org.im97mori.ble.service.peripheral.AbstractServiceMockCallback;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * User Data Service (Service UUID: 0x181C) for Peripheral
 */
public class UserDataServiceMockCallback extends AbstractServiceMockCallback {

    /**
     * User Data Characteristic UUID set
     */
    public static final Set<UUID> UDS_CHARACTERISTIC_SET;

    static {
        Set<UUID> set = new HashSet<>();
        set.add(AEROBIC_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC);
        set.add(AEROBIC_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC);
        set.add(AEROBIC_THRESHOLD_CHARACTERISTIC);
        set.add(AGE_CHARACTERISTIC);
        set.add(ANAEROBIC_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC);
        set.add(ANAEROBIC_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC);
        set.add(ANAEROBIC_THRESHOLD_CHARACTERISTIC);
        set.add(DATE_OF_BIRTH_CHARACTERISTIC);
        set.add(DATE_OF_THRESHOLD_ASSESSMENT_CHARACTERISTIC);
        set.add(EMAIL_ADDRESS_CHARACTERISTIC);
        set.add(FAT_BURN_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC);
        set.add(FAT_BURN_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC);
        set.add(FIRST_NAME_CHARACTERISTIC);
        set.add(FIVE_ZONE_HEART_RATE_LIMITS_CHARACTERISTIC);
        set.add(GENDER_CHARACTERISTIC);
        set.add(HEART_RATE_MAX_CHARACTERISTIC);
        set.add(HEIGHT_CHARACTERISTIC);
        set.add(HIP_CIRCUMFERENCE_CHARACTERISTIC);
        set.add(LANGUAGE_CHARACTERISTIC);
        set.add(LAST_NAME_CHARACTERISTIC);
        set.add(MAXIMUM_RECOMMENDED_HEART_RATE_CHARACTERISTIC);
        set.add(RESTING_HEART_RATE_CHARACTERISTIC);
        set.add(SPORT_TYPE_FOR_AEROBIC_AND_ANAEROBIC_THRESHOLDS_CHARACTERISTIC);
        set.add(THREE_ZONE_HEART_RATE_LIMITS_CHARACTERISTIC);
        set.add(TWO_ZONE_HEART_RATE_LIMITS_CHARACTERISTIC);
        set.add(VO2_MAX_CHARACTERISTIC);
        set.add(WAIST_CIRCUMFERENCE_CHARACTERISTIC);
        set.add(WEIGHT_CHARACTERISTIC);
        UDS_CHARACTERISTIC_SET = Collections.unmodifiableSet(Collections.synchronizedSet(set));
    }

    /**
     * KEY:REQUEST_ID
     */
    protected static final String KEY_REQUEST_ID = "KEY_REQUEST_ID";

    /**
     * list all uses indication timeout duration
     */
    protected static final long LIST_ALL_USERS_INDICATION_TIMEOUT = 30 * DateUtils.SECOND_IN_MILLIS;

    /**
     * Builder for {@link UserDataServiceMockCallback}
     *
     * @param <T> subclass of {@link UserDataServiceMockCallback}
     */
    public static class Builder<T extends UserDataServiceMockCallback> extends AbstractServiceMockCallback.Builder<UserDataServiceMockCallback, ServiceData> {

        /**
         * First Name data
         */
        protected UDSCharacteristicData mFirstNameData;

        /**
         * Last Name data
         */
        protected UDSCharacteristicData mLastNameData;

        /**
         * Email Address data
         */
        protected UDSCharacteristicData mEmailAddressData;

        /**
         * Age data
         */
        protected UDSCharacteristicData mAgeData;

        /**
         * Date of Birth data
         */
        protected UDSCharacteristicData mDateOfBirthData;

        /**
         * Gender data
         */
        protected UDSCharacteristicData mGenderData;

        /**
         * Weight data
         */
        protected UDSCharacteristicData mWeightData;

        /**
         * Height data
         */
        protected UDSCharacteristicData mHeightData;

        /**
         * VO2 Max data
         */
        protected UDSCharacteristicData mVO2MaxData;

        /**
         * Heart Rate Max data
         */
        protected UDSCharacteristicData mHeartRateMaxData;

        /**
         * Resting Heart Rate data
         */
        protected UDSCharacteristicData mRestingHeartRateData;

        /**
         * Maximum Recommended Heart Rate data
         */
        protected UDSCharacteristicData mMaximumRecommendedHeartRateData;

        /**
         * Aerobic Threshold data
         */
        protected UDSCharacteristicData mAerobicThresholdData;

        /**
         * Anaerobic Threshold data
         */
        protected UDSCharacteristicData mAnaerobicThresholdData;

        /**
         * Sport Type for Aerobic and Anaerobic Thresholds data
         */
        protected UDSCharacteristicData mSportTypeForAerobicAndAnaerobicThresholdsData;

        /**
         * Date of Threshold Assessment data
         */
        protected UDSCharacteristicData mDateOfThresholdAssessmentData;

        /**
         * Waist Circumference data
         */
        protected UDSCharacteristicData mWaistCircumferenceData;

        /**
         * Hip Circumference data
         */
        protected UDSCharacteristicData mHipCircumferenceData;

        /**
         * Fat Burn Heart Rate Lower Limit data
         */
        protected UDSCharacteristicData mFatBurnHeartRateLowerLimitData;

        /**
         * Fat Burn Heart Rate Upper Limit data
         */
        protected UDSCharacteristicData mFatBurnHeartRateUpperLimitData;

        /**
         * Aerobic Heart Rate Lower Limit data
         */
        protected UDSCharacteristicData mAerobicHeartRateLowerLimitData;

        /**
         * Aerobic Heart Rate Upper Limit data
         */
        protected UDSCharacteristicData mAerobicHeartRateUpperLimitData;

        /**
         * Anaerobic Heart Rate Lower Limit data
         */
        protected UDSCharacteristicData mAnaerobicHeartRateLowerLimitData;

        /**
         * Anaerobic Heart Rate Upper Limit data
         */
        protected UDSCharacteristicData mAnaerobicHeartRateUpperLimitData;

        /**
         * Five Zone Heart Rate Limits data
         */
        protected UDSCharacteristicData mFiveZoneHeartRateLimitsData;

        /**
         * Three Zone Heart Rate Limits data
         */
        protected UDSCharacteristicData mThreeZoneHeartRateLimitsData;

        /**
         * Two Zone Heart Rate Limit data
         */
        protected UDSCharacteristicData mTwoZoneHeartRateLimitData;

        /**
         * Language data
         */
        protected UDSCharacteristicData mLanguageData;

        /**
         * Database Change Increment data
         */
        protected CharacteristicData mDatabaseChangeIncrementData;

        /**
         * User Index data
         */
        protected CharacteristicData mUserIndexData;

        /**
         * User Control Point data
         */
        protected UserControlPointCharacteristicData mUserControlPointData;

        /**
         * Registered User data
         */
        protected CharacteristicData mRegisteredUserData;

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
         * add First Name characteristic
         *
         * @param responseCode response code for {@link BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 3rd parameter
         * @param delay        response delay(millis)
         * @param value        data array for {@link BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> addFirstName(int responseCode, long delay, @NonNull byte[] value) {
            mFirstNameData = new UDSCharacteristicData(FIRST_NAME_CHARACTERISTIC
                    , BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE
                    , BluetoothGattCharacteristic.PERMISSION_READ | BluetoothGattCharacteristic.PERMISSION_WRITE
                    , Collections.emptyList()
                    , responseCode
                    , delay
                    , value
                    , 0);
            return this;
        }

        /**
         * remove First Name characteristic
         *
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> removeFirstName() {
            mFirstNameData = null;
            return this;
        }

        /**
         * @see #addLastName(LastName)
         */
        @NonNull
        public Builder<T> addLastName(@NonNull String lastName) {
            return addLastName(new LastName(lastName));
        }

        /**
         * @see #addLastName(byte[])
         */
        @NonNull
        public Builder<T> addLastName(@NonNull LastName lastName) {
            return addLastName(lastName.getBytes());
        }

        /**
         * @see #addLastName(int, long, byte[])
         */
        @NonNull
        public Builder<T> addLastName(@NonNull byte[] value) {
            return addLastName(BluetoothGatt.GATT_SUCCESS
                    , 0
                    , value);
        }

        /**
         * add Last Name characteristic
         *
         * @param responseCode response code for {@link BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 3rd parameter
         * @param delay        response delay(millis)
         * @param value        data array for {@link BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> addLastName(int responseCode, long delay, @NonNull byte[] value) {
            mLastNameData = new UDSCharacteristicData(LAST_NAME_CHARACTERISTIC
                    , BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE
                    , BluetoothGattCharacteristic.PERMISSION_READ | BluetoothGattCharacteristic.PERMISSION_WRITE
                    , Collections.emptyList()
                    , responseCode
                    , delay
                    , value
                    , 0);
            return this;
        }

        /**
         * remove Last Name characteristic
         *
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> removeLastName() {
            mLastNameData = null;
            return this;
        }

        /**
         * @see #addEmailAddress(EmailAddress)
         */
        @NonNull
        public Builder<T> addEmailAddress(@NonNull String emailAddress) {
            return addEmailAddress(new EmailAddress(emailAddress));
        }

        /**
         * @see #addEmailAddress(byte[])
         */
        @NonNull
        public Builder<T> addEmailAddress(@NonNull EmailAddress emailAddress) {
            return addEmailAddress(emailAddress.getBytes());
        }

        /**
         * @see #addEmailAddress(int, long, byte[])
         */
        @NonNull
        public Builder<T> addEmailAddress(@NonNull byte[] value) {
            return addEmailAddress(BluetoothGatt.GATT_SUCCESS
                    , 0
                    , value);
        }

        /**
         * add Email Address characteristic
         *
         * @param responseCode response code for {@link BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 3rd parameter
         * @param delay        response delay(millis)
         * @param value        data array for {@link BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> addEmailAddress(int responseCode, long delay, @NonNull byte[] value) {
            mEmailAddressData = new UDSCharacteristicData(EMAIL_ADDRESS_CHARACTERISTIC
                    , BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE
                    , BluetoothGattCharacteristic.PERMISSION_READ | BluetoothGattCharacteristic.PERMISSION_WRITE
                    , Collections.emptyList()
                    , responseCode
                    , delay
                    , value
                    , 0);
            return this;
        }

        /**
         * remove Email Address characteristic
         *
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> removeEmailAddress() {
            mEmailAddressData = null;
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
         * add Age characteristic
         *
         * @param responseCode response code for {@link BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 3rd parameter
         * @param delay        response delay(millis)
         * @param value        data array for {@link BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> addAge(int responseCode, long delay, @NonNull byte[] value) {
            mAgeData = new UDSCharacteristicData(AGE_CHARACTERISTIC
                    , BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE
                    , BluetoothGattCharacteristic.PERMISSION_READ | BluetoothGattCharacteristic.PERMISSION_WRITE
                    , Collections.emptyList()
                    , responseCode
                    , delay
                    , value
                    , 0);
            return this;
        }

        /**
         * remove Age characteristic
         *
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> removeAge() {
            mAgeData = null;
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
         * add Date of Birth characteristic
         *
         * @param responseCode response code for {@link BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 3rd parameter
         * @param delay        response delay(millis)
         * @param value        data array for {@link BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> addDateOfBirth(int responseCode, long delay, @NonNull byte[] value) {
            mDateOfBirthData = new UDSCharacteristicData(DATE_OF_BIRTH_CHARACTERISTIC
                    , BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE
                    , BluetoothGattCharacteristic.PERMISSION_READ | BluetoothGattCharacteristic.PERMISSION_WRITE
                    , Collections.emptyList()
                    , responseCode
                    , delay
                    , value
                    , 0);
            return this;
        }

        /**
         * remove Date of Birth characteristic
         *
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> removeDateOfBirth() {
            mDateOfBirthData = null;
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
         * add Gender characteristic
         *
         * @param responseCode response code for {@link BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 3rd parameter
         * @param delay        response delay(millis)
         * @param value        data array for {@link BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> addGender(int responseCode, long delay, @NonNull byte[] value) {
            mGenderData = new UDSCharacteristicData(GENDER_CHARACTERISTIC
                    , BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE
                    , BluetoothGattCharacteristic.PERMISSION_READ | BluetoothGattCharacteristic.PERMISSION_WRITE
                    , Collections.emptyList()
                    , responseCode
                    , delay
                    , value
                    , 0);
            return this;
        }

        /**
         * remove Gender characteristic
         *
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> removeGender() {
            mGenderData = null;
            return this;
        }

        /**
         * @see #addWeight(Weight)
         */
        @NonNull
        public Builder<T> addWeight(int weight) {
            return addWeight(new Weight(weight));
        }

        /**
         * @see #addWeight(byte[])
         */
        @NonNull
        public Builder<T> addWeight(@NonNull Weight weight) {
            return addWeight(weight.getBytes());
        }

        /**
         * @see #addWeight(int, long, byte[])
         */
        @NonNull
        public Builder<T> addWeight(@NonNull byte[] value) {
            return addWeight(BluetoothGatt.GATT_SUCCESS
                    , 0
                    , value);
        }

        /**
         * add Weight characteristic
         *
         * @param responseCode response code for {@link BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 3rd parameter
         * @param delay        response delay(millis)
         * @param value        data array for {@link BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> addWeight(int responseCode, long delay, @NonNull byte[] value) {
            mWeightData = new UDSCharacteristicData(WEIGHT_CHARACTERISTIC
                    , BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE
                    , BluetoothGattCharacteristic.PERMISSION_READ | BluetoothGattCharacteristic.PERMISSION_WRITE
                    , Collections.emptyList()
                    , responseCode
                    , delay
                    , value
                    , 0);
            return this;
        }

        /**
         * remove Weight characteristic
         *
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> removeWeight() {
            mWeightData = null;
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
         * add Height characteristic
         *
         * @param responseCode response code for {@link BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 3rd parameter
         * @param delay        response delay(millis)
         * @param value        data array for {@link BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> addHeight(int responseCode, long delay, @NonNull byte[] value) {
            mHeightData = new UDSCharacteristicData(HEIGHT_CHARACTERISTIC
                    , BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE
                    , BluetoothGattCharacteristic.PERMISSION_READ | BluetoothGattCharacteristic.PERMISSION_WRITE
                    , Collections.emptyList()
                    , responseCode
                    , delay
                    , value
                    , 0);
            return this;
        }

        /**
         * remove Height characteristic
         *
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> removeHeight() {
            mHeightData = null;
            return this;
        }

        /**
         * @see #addVO2Max(VO2Max)
         */
        @NonNull
        public Builder<T> addVO2Max(int vo2Max) {
            return addVO2Max(new VO2Max(vo2Max));
        }

        /**
         * @see #addVO2Max(byte[])
         */
        @NonNull
        public Builder<T> addVO2Max(@NonNull VO2Max vo2Max) {
            return addVO2Max(vo2Max.getBytes());
        }

        /**
         * @see #addVO2Max(int, long, byte[])
         */
        @NonNull
        public Builder<T> addVO2Max(@NonNull byte[] value) {
            return addVO2Max(BluetoothGatt.GATT_SUCCESS
                    , 0
                    , value);
        }

        /**
         * add VO2 Max characteristic
         *
         * @param responseCode response code for {@link BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 3rd parameter
         * @param delay        response delay(millis)
         * @param value        data array for {@link BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> addVO2Max(int responseCode, long delay, @NonNull byte[] value) {
            mVO2MaxData = new UDSCharacteristicData(VO2_MAX_CHARACTERISTIC
                    , BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE
                    , BluetoothGattCharacteristic.PERMISSION_READ | BluetoothGattCharacteristic.PERMISSION_WRITE
                    , Collections.emptyList()
                    , responseCode
                    , delay
                    , value
                    , 0);
            return this;
        }

        /**
         * remove VO2 Max characteristic
         *
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> removeVO2Max() {
            mVO2MaxData = null;
            return this;
        }

        /**
         * @see #addHeartRateMax(HeartRateMax)
         */
        @NonNull
        public Builder<T> addHeartRateMax(int heartRateMax) {
            return addHeartRateMax(new HeartRateMax(heartRateMax));
        }

        /**
         * @see #addHeartRateMax(byte[])
         */
        @NonNull
        public Builder<T> addHeartRateMax(@NonNull HeartRateMax heartRateMax) {
            return addHeartRateMax(heartRateMax.getBytes());
        }

        /**
         * @see #addHeartRateMax(int, long, byte[])
         */
        @NonNull
        public Builder<T> addHeartRateMax(@NonNull byte[] value) {
            return addHeartRateMax(BluetoothGatt.GATT_SUCCESS
                    , 0
                    , value);
        }

        /**
         * add Heart Rate Max characteristic
         *
         * @param responseCode response code for {@link BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 3rd parameter
         * @param delay        response delay(millis)
         * @param value        data array for {@link BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> addHeartRateMax(int responseCode, long delay, @NonNull byte[] value) {
            mHeartRateMaxData = new UDSCharacteristicData(HEART_RATE_MAX_CHARACTERISTIC
                    , BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE
                    , BluetoothGattCharacteristic.PERMISSION_READ | BluetoothGattCharacteristic.PERMISSION_WRITE
                    , Collections.emptyList()
                    , responseCode
                    , delay
                    , value
                    , 0);
            return this;
        }

        /**
         * remove Heart Rate Max characteristic
         *
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> removeHeartRateMax() {
            mHeartRateMaxData = null;
            return this;
        }

        /**
         * @see #addRestingHeartRate(RestingHeartRate)
         */
        @NonNull
        public Builder<T> addRestingHeartRate(int restingHeartRate) {
            return addRestingHeartRate(new RestingHeartRate(restingHeartRate));
        }

        /**
         * @see #addRestingHeartRate(byte[])
         */
        @NonNull
        public Builder<T> addRestingHeartRate(@NonNull RestingHeartRate restingHeartRate) {
            return addRestingHeartRate(restingHeartRate.getBytes());
        }

        /**
         * @see #addRestingHeartRate(int, long, byte[])
         */
        @NonNull
        public Builder<T> addRestingHeartRate(@NonNull byte[] value) {
            return addRestingHeartRate(BluetoothGatt.GATT_SUCCESS
                    , 0
                    , value);
        }

        /**
         * add Resting Heart Rate characteristic
         *
         * @param responseCode response code for {@link BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 3rd parameter
         * @param delay        response delay(millis)
         * @param value        data array for {@link BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> addRestingHeartRate(int responseCode, long delay, @NonNull byte[] value) {
            mRestingHeartRateData = new UDSCharacteristicData(RESTING_HEART_RATE_CHARACTERISTIC
                    , BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE
                    , BluetoothGattCharacteristic.PERMISSION_READ | BluetoothGattCharacteristic.PERMISSION_WRITE
                    , Collections.emptyList()
                    , responseCode
                    , delay
                    , value
                    , 0);
            return this;
        }

        /**
         * remove Resting Heart Rate characteristic
         *
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> removeRestingHeartRate() {
            mRestingHeartRateData = null;
            return this;
        }

        /**
         * @see #addMaximumRecommendedHeartRate(MaximumRecommendedHeartRate)
         */
        @NonNull
        public Builder<T> addMaximumRecommendedHeartRate(int maximumRecommendedHeartRate) {
            return addMaximumRecommendedHeartRate(new MaximumRecommendedHeartRate(maximumRecommendedHeartRate));
        }

        /**
         * @see #addMaximumRecommendedHeartRate(byte[])
         */
        @NonNull
        public Builder<T> addMaximumRecommendedHeartRate(@NonNull MaximumRecommendedHeartRate maximumRecommendedHeartRate) {
            return addMaximumRecommendedHeartRate(maximumRecommendedHeartRate.getBytes());
        }

        /**
         * @see #addMaximumRecommendedHeartRate(int, long, byte[])
         */
        @NonNull
        public Builder<T> addMaximumRecommendedHeartRate(@NonNull byte[] value) {
            return addMaximumRecommendedHeartRate(BluetoothGatt.GATT_SUCCESS
                    , 0
                    , value);
        }

        /**
         * add Maximum Recommended Heart Rate characteristic
         *
         * @param responseCode response code for {@link BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 3rd parameter
         * @param delay        response delay(millis)
         * @param value        data array for {@link BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> addMaximumRecommendedHeartRate(int responseCode, long delay, @NonNull byte[] value) {
            mMaximumRecommendedHeartRateData = new UDSCharacteristicData(MAXIMUM_RECOMMENDED_HEART_RATE_CHARACTERISTIC
                    , BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE
                    , BluetoothGattCharacteristic.PERMISSION_READ | BluetoothGattCharacteristic.PERMISSION_WRITE
                    , Collections.emptyList()
                    , responseCode
                    , delay
                    , value
                    , 0);
            return this;
        }

        /**
         * remove Maximum Recommended Heart Rate characteristic
         *
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> removeMaximumRecommendedHeartRate() {
            mMaximumRecommendedHeartRateData = null;
            return this;
        }

        /**
         * @see #addAerobicThreshold(AerobicThreshold)
         */
        @NonNull
        public Builder<T> addAerobicThreshold(int aerobicThreshold) {
            return addAerobicThreshold(new AerobicThreshold(aerobicThreshold));
        }

        /**
         * @see #addAerobicThreshold(byte[])
         */
        @NonNull
        public Builder<T> addAerobicThreshold(@NonNull AerobicThreshold aerobicThreshold) {
            return addAerobicThreshold(aerobicThreshold.getBytes());
        }

        /**
         * @see #addAerobicThreshold(int, long, byte[])
         */
        @NonNull
        public Builder<T> addAerobicThreshold(@NonNull byte[] value) {
            return addAerobicThreshold(BluetoothGatt.GATT_SUCCESS
                    , 0
                    , value);
        }

        /**
         * add Aerobic Threshold characteristic
         *
         * @param responseCode response code for {@link BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 3rd parameter
         * @param delay        response delay(millis)
         * @param value        data array for {@link BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> addAerobicThreshold(int responseCode, long delay, @NonNull byte[] value) {
            mAerobicThresholdData = new UDSCharacteristicData(AEROBIC_THRESHOLD_CHARACTERISTIC
                    , BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE
                    , BluetoothGattCharacteristic.PERMISSION_READ | BluetoothGattCharacteristic.PERMISSION_WRITE
                    , Collections.emptyList()
                    , responseCode
                    , delay
                    , value
                    , 0);
            return this;
        }

        /**
         * remove Aerobic Threshold characteristic
         *
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> removeAerobicThreshold() {
            mAerobicThresholdData = null;
            return this;
        }

        /**
         * @see #addAnaerobicThreshold(AnaerobicThreshold)
         */
        @NonNull
        public Builder<T> addAnaerobicThreshold(int anaerobicThreshold) {
            return addAnaerobicThreshold(new AnaerobicThreshold(anaerobicThreshold));
        }

        /**
         * @see #addAnaerobicThreshold(byte[])
         */
        @NonNull
        public Builder<T> addAnaerobicThreshold(@NonNull AnaerobicThreshold anaerobicThreshold) {
            return addAnaerobicThreshold(anaerobicThreshold.getBytes());
        }

        /**
         * @see #addAnaerobicThreshold(int, long, byte[])
         */
        @NonNull
        public Builder<T> addAnaerobicThreshold(@NonNull byte[] value) {
            return addAnaerobicThreshold(BluetoothGatt.GATT_SUCCESS
                    , 0
                    , value);
        }

        /**
         * add Anaerobic Threshold characteristic
         *
         * @param responseCode response code for {@link BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 3rd parameter
         * @param delay        response delay(millis)
         * @param value        data array for {@link BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> addAnaerobicThreshold(int responseCode, long delay, @NonNull byte[] value) {
            mAnaerobicThresholdData = new UDSCharacteristicData(ANAEROBIC_THRESHOLD_CHARACTERISTIC
                    , BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE
                    , BluetoothGattCharacteristic.PERMISSION_READ | BluetoothGattCharacteristic.PERMISSION_WRITE
                    , Collections.emptyList()
                    , responseCode
                    , delay
                    , value
                    , 0);
            return this;
        }

        /**
         * remove Anaerobic Threshold characteristic
         *
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> removeAnaerobicThreshold() {
            mAnaerobicThresholdData = null;
            return this;
        }

        /**
         * @see #addSportTypeForAerobicAndAnaerobicThresholds(SportTypeForAerobicAndAnaerobicThresholds)
         */
        @NonNull
        public Builder<T> addSportTypeForAerobicAndAnaerobicThresholds(int sportTypeForAerobicAndAnaerobicThresholds) {
            return addSportTypeForAerobicAndAnaerobicThresholds(new SportTypeForAerobicAndAnaerobicThresholds(sportTypeForAerobicAndAnaerobicThresholds));
        }

        /**
         * @see #addSportTypeForAerobicAndAnaerobicThresholds(byte[])
         */
        @NonNull
        public Builder<T> addSportTypeForAerobicAndAnaerobicThresholds(@NonNull SportTypeForAerobicAndAnaerobicThresholds sportTypeForAerobicAndAnaerobicThresholds) {
            return addSportTypeForAerobicAndAnaerobicThresholds(sportTypeForAerobicAndAnaerobicThresholds.getBytes());
        }

        /**
         * @see #addSportTypeForAerobicAndAnaerobicThresholds(int, long, byte[])
         */
        @NonNull
        public Builder<T> addSportTypeForAerobicAndAnaerobicThresholds(@NonNull byte[] value) {
            return addSportTypeForAerobicAndAnaerobicThresholds(BluetoothGatt.GATT_SUCCESS
                    , 0
                    , value);
        }

        /**
         * add Sport Type for Aerobic and Anaerobic Thresholds characteristic
         *
         * @param responseCode response code for {@link BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 3rd parameter
         * @param delay        response delay(millis)
         * @param value        data array for {@link BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> addSportTypeForAerobicAndAnaerobicThresholds(int responseCode, long delay, @NonNull byte[] value) {
            mSportTypeForAerobicAndAnaerobicThresholdsData = new UDSCharacteristicData(SPORT_TYPE_FOR_AEROBIC_AND_ANAEROBIC_THRESHOLDS_CHARACTERISTIC
                    , BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE
                    , BluetoothGattCharacteristic.PERMISSION_READ | BluetoothGattCharacteristic.PERMISSION_WRITE
                    , Collections.emptyList()
                    , responseCode
                    , delay
                    , value
                    , 0);
            return this;
        }

        /**
         * remove Sport Type for Aerobic and Anaerobic Thresholds characteristic
         *
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> removeSportTypeForAerobicAndAnaerobicThresholds() {
            mSportTypeForAerobicAndAnaerobicThresholdsData = null;
            return this;
        }

        /**
         * @see #addDateOfThresholdAssessment(DateOfThresholdAssessment)
         */
        @NonNull
        public Builder<T> addDateOfThresholdAssessment(int year, int month, int day) {
            return addDateOfThresholdAssessment(new DateOfThresholdAssessment(year, month, day));
        }

        /**
         * @see #addDateOfThresholdAssessment(byte[])
         */
        @NonNull
        public Builder<T> addDateOfThresholdAssessment(@NonNull DateOfThresholdAssessment dateOfThresholdAssessment) {
            return addDateOfThresholdAssessment(dateOfThresholdAssessment.getBytes());
        }

        /**
         * @see #addDateOfThresholdAssessment(int, long, byte[])
         */
        @NonNull
        public Builder<T> addDateOfThresholdAssessment(@NonNull byte[] value) {
            return addDateOfThresholdAssessment(BluetoothGatt.GATT_SUCCESS
                    , 0
                    , value);
        }

        /**
         * add Date of Threshold Assessment characteristic
         *
         * @param responseCode response code for {@link BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 3rd parameter
         * @param delay        response delay(millis)
         * @param value        data array for {@link BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> addDateOfThresholdAssessment(int responseCode, long delay, @NonNull byte[] value) {
            mDateOfThresholdAssessmentData = new UDSCharacteristicData(DATE_OF_THRESHOLD_ASSESSMENT_CHARACTERISTIC
                    , BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE
                    , BluetoothGattCharacteristic.PERMISSION_READ | BluetoothGattCharacteristic.PERMISSION_WRITE
                    , Collections.emptyList()
                    , responseCode
                    , delay
                    , value
                    , 0);
            return this;
        }

        /**
         * remove Date of Threshold Assessment characteristic
         *
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> removeDateOfThresholdAssessment() {
            mDateOfThresholdAssessmentData = null;
            return this;
        }

        /**
         * @see #addWaistCircumference(WaistCircumference)
         */
        @NonNull
        public Builder<T> addWaistCircumference(int waistCircumference) {
            return addWaistCircumference(new WaistCircumference(waistCircumference));
        }

        /**
         * @see #addWaistCircumference(byte[])
         */
        @NonNull
        public Builder<T> addWaistCircumference(@NonNull WaistCircumference waistCircumference) {
            return addWaistCircumference(waistCircumference.getBytes());
        }

        /**
         * @see #addWaistCircumference(int, long, byte[])
         */
        @NonNull
        public Builder<T> addWaistCircumference(@NonNull byte[] value) {
            return addWaistCircumference(BluetoothGatt.GATT_SUCCESS
                    , 0
                    , value);
        }

        /**
         * add Waist Circumference characteristic
         *
         * @param responseCode response code for {@link BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 3rd parameter
         * @param delay        response delay(millis)
         * @param value        data array for {@link BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> addWaistCircumference(int responseCode, long delay, @NonNull byte[] value) {
            mWaistCircumferenceData = new UDSCharacteristicData(WAIST_CIRCUMFERENCE_CHARACTERISTIC
                    , BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE
                    , BluetoothGattCharacteristic.PERMISSION_READ | BluetoothGattCharacteristic.PERMISSION_WRITE
                    , Collections.emptyList()
                    , responseCode
                    , delay
                    , value
                    , 0);
            return this;
        }

        /**
         * remove Waist Circumference characteristic
         *
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> removeWaistCircumference() {
            mWaistCircumferenceData = null;
            return this;
        }

        /**
         * @see #addHipCircumference(HipCircumference)
         */
        @NonNull
        public Builder<T> addHipCircumference(int hipCircumference) {
            return addHipCircumference(new HipCircumference(hipCircumference));
        }

        /**
         * @see #addHipCircumference(byte[])
         */
        @NonNull
        public Builder<T> addHipCircumference(@NonNull HipCircumference hipCircumference) {
            return addHipCircumference(hipCircumference.getBytes());
        }

        /**
         * @see #addHipCircumference(int, long, byte[])
         */
        @NonNull
        public Builder<T> addHipCircumference(@NonNull byte[] value) {
            return addHipCircumference(BluetoothGatt.GATT_SUCCESS
                    , 0
                    , value);
        }

        /**
         * add Hip Circumference characteristic
         *
         * @param responseCode response code for {@link BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 3rd parameter
         * @param delay        response delay(millis)
         * @param value        data array for {@link BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> addHipCircumference(int responseCode, long delay, @NonNull byte[] value) {
            mHipCircumferenceData = new UDSCharacteristicData(HIP_CIRCUMFERENCE_CHARACTERISTIC
                    , BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE
                    , BluetoothGattCharacteristic.PERMISSION_READ | BluetoothGattCharacteristic.PERMISSION_WRITE
                    , Collections.emptyList()
                    , responseCode
                    , delay
                    , value
                    , 0);
            return this;
        }

        /**
         * remove Hip Circumference characteristic
         *
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> removeHipCircumference() {
            mHipCircumferenceData = null;
            return this;
        }

        /**
         * @see #addFatBurnHeartRateLowerLimit(FatBurnHeartRateLowerLimit)
         */
        @NonNull
        public Builder<T> addFatBurnHeartRateLowerLimit(int fatBurnHeartRateLowerLimit) {
            return addFatBurnHeartRateLowerLimit(new FatBurnHeartRateLowerLimit(fatBurnHeartRateLowerLimit));
        }

        /**
         * @see #addFatBurnHeartRateLowerLimit(byte[])
         */
        @NonNull
        public Builder<T> addFatBurnHeartRateLowerLimit(@NonNull FatBurnHeartRateLowerLimit fatBurnHeartRateLowerLimit) {
            return addFatBurnHeartRateLowerLimit(fatBurnHeartRateLowerLimit.getBytes());
        }

        /**
         * @see #addFatBurnHeartRateLowerLimit(int, long, byte[])
         */
        @NonNull
        public Builder<T> addFatBurnHeartRateLowerLimit(@NonNull byte[] value) {
            return addFatBurnHeartRateLowerLimit(BluetoothGatt.GATT_SUCCESS
                    , 0
                    , value);
        }

        /**
         * add Fat Burn Heart Rate Lower Limit characteristic
         *
         * @param responseCode response code for {@link BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 3rd parameter
         * @param delay        response delay(millis)
         * @param value        data array for {@link BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> addFatBurnHeartRateLowerLimit(int responseCode, long delay, @NonNull byte[] value) {
            mFatBurnHeartRateLowerLimitData = new UDSCharacteristicData(FAT_BURN_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC
                    , BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE
                    , BluetoothGattCharacteristic.PERMISSION_READ | BluetoothGattCharacteristic.PERMISSION_WRITE
                    , Collections.emptyList()
                    , responseCode
                    , delay
                    , value
                    , 0);
            return this;
        }

        /**
         * remove Fat Burn Heart Rate Lower Limit characteristic
         *
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> removeFatBurnHeartRateLowerLimit() {
            mFatBurnHeartRateLowerLimitData = null;
            return this;
        }

        /**
         * @see #addFatBurnHeartRateUpperLimit(FatBurnHeartRateUpperLimit)
         */
        @NonNull
        public Builder<T> addFatBurnHeartRateUpperLimit(int fatBurnHeartRateUpperLimit) {
            return addFatBurnHeartRateUpperLimit(new FatBurnHeartRateUpperLimit(fatBurnHeartRateUpperLimit));
        }

        /**
         * @see #addFatBurnHeartRateUpperLimit(byte[])
         */
        @NonNull
        public Builder<T> addFatBurnHeartRateUpperLimit(@NonNull FatBurnHeartRateUpperLimit fatBurnHeartRateUpperLimit) {
            return addFatBurnHeartRateUpperLimit(fatBurnHeartRateUpperLimit.getBytes());
        }

        /**
         * @see #addFatBurnHeartRateUpperLimit(int, long, byte[])
         */
        @NonNull
        public Builder<T> addFatBurnHeartRateUpperLimit(@NonNull byte[] value) {
            return addFatBurnHeartRateUpperLimit(BluetoothGatt.GATT_SUCCESS
                    , 0
                    , value);
        }

        /**
         * add Fat Burn Heart Rate Upper Limit characteristic
         *
         * @param responseCode response code for {@link BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 3rd parameter
         * @param delay        response delay(millis)
         * @param value        data array for {@link BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> addFatBurnHeartRateUpperLimit(int responseCode, long delay, @NonNull byte[] value) {
            mFatBurnHeartRateUpperLimitData = new UDSCharacteristicData(FAT_BURN_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC
                    , BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE
                    , BluetoothGattCharacteristic.PERMISSION_READ | BluetoothGattCharacteristic.PERMISSION_WRITE
                    , Collections.emptyList()
                    , responseCode
                    , delay
                    , value
                    , 0);
            return this;
        }

        /**
         * remove Fat Burn Heart Rate Lower Limit characteristic
         *
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> removeFatBurnHeartRateUpperLimit() {
            mFatBurnHeartRateUpperLimitData = null;
            return this;
        }

        /**
         * @see #addAerobicHeartRateLowerLimit(AerobicHeartRateLowerLimit)
         */
        @NonNull
        public Builder<T> addAerobicHeartRateLowerLimit(int aerobicHeartRateLowerLimit) {
            return addAerobicHeartRateLowerLimit(new AerobicHeartRateLowerLimit(aerobicHeartRateLowerLimit));
        }

        /**
         * @see #addAerobicHeartRateLowerLimit(byte[])
         */
        @NonNull
        public Builder<T> addAerobicHeartRateLowerLimit(@NonNull AerobicHeartRateLowerLimit aerobicHeartRateLowerLimit) {
            return addAerobicHeartRateLowerLimit(aerobicHeartRateLowerLimit.getBytes());
        }

        /**
         * @see #addAerobicHeartRateLowerLimit(int, long, byte[])
         */
        @NonNull
        public Builder<T> addAerobicHeartRateLowerLimit(@NonNull byte[] value) {
            return addAerobicHeartRateLowerLimit(BluetoothGatt.GATT_SUCCESS
                    , 0
                    , value);
        }

        /**
         * add Aerobic Heart Rate Lower Limit characteristic
         *
         * @param responseCode response code for {@link BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 3rd parameter
         * @param delay        response delay(millis)
         * @param value        data array for {@link BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> addAerobicHeartRateLowerLimit(int responseCode, long delay, @NonNull byte[] value) {
            mAerobicHeartRateLowerLimitData = new UDSCharacteristicData(AEROBIC_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC
                    , BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE
                    , BluetoothGattCharacteristic.PERMISSION_READ | BluetoothGattCharacteristic.PERMISSION_WRITE
                    , Collections.emptyList()
                    , responseCode
                    , delay
                    , value
                    , 0);
            return this;
        }

        /**
         * remove Aerobic Heart Rate Lower Limit characteristic
         *
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> removeAerobicHeartRateLowerLimit() {
            mAerobicHeartRateLowerLimitData = null;
            return this;
        }

        /**
         * @see #addAerobicHeartRateUpperLimit(AerobicHeartRateUpperLimit)
         */
        @NonNull
        public Builder<T> addAerobicHeartRateUpperLimit(int aerobicHeartRateUpperLimit) {
            return addAerobicHeartRateUpperLimit(new AerobicHeartRateUpperLimit(aerobicHeartRateUpperLimit));
        }

        /**
         * @see #addAerobicHeartRateUpperLimit(byte[])
         */
        @NonNull
        public Builder<T> addAerobicHeartRateUpperLimit(@NonNull AerobicHeartRateUpperLimit aerobicHeartRateUpperLimit) {
            return addAerobicHeartRateUpperLimit(aerobicHeartRateUpperLimit.getBytes());
        }

        /**
         * @see #addAerobicHeartRateUpperLimit(int, long, byte[])
         */
        @NonNull
        public Builder<T> addAerobicHeartRateUpperLimit(@NonNull byte[] value) {
            return addAerobicHeartRateUpperLimit(BluetoothGatt.GATT_SUCCESS
                    , 0
                    , value);
        }

        /**
         * add Aerobic Heart Rate Upper Limit characteristic
         *
         * @param responseCode response code for {@link BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 3rd parameter
         * @param delay        response delay(millis)
         * @param value        data array for {@link BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> addAerobicHeartRateUpperLimit(int responseCode, long delay, @NonNull byte[] value) {
            mAerobicHeartRateUpperLimitData = new UDSCharacteristicData(AEROBIC_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC
                    , BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE
                    , BluetoothGattCharacteristic.PERMISSION_READ | BluetoothGattCharacteristic.PERMISSION_WRITE
                    , Collections.emptyList()
                    , responseCode
                    , delay
                    , value
                    , 0);
            return this;
        }

        /**
         * remove Aerobic Heart Rate Upper Limit characteristic
         *
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> removeAerobicHeartRateUpperLimit() {
            mAerobicHeartRateUpperLimitData = null;
            return this;
        }

        /**
         * @see #addAnaerobicHeartRateLowerLimit(AnaerobicHeartRateLowerLimit)
         */
        @NonNull
        public Builder<T> addAnaerobicHeartRateLowerLimit(int anaerobicHeartRateLowerLimit) {
            return addAnaerobicHeartRateLowerLimit(new AnaerobicHeartRateLowerLimit(anaerobicHeartRateLowerLimit));
        }

        /**
         * @see #addAnaerobicHeartRateLowerLimit(byte[])
         */
        @NonNull
        public Builder<T> addAnaerobicHeartRateLowerLimit(@NonNull AnaerobicHeartRateLowerLimit anaerobicHeartRateLowerLimit) {
            return addAnaerobicHeartRateLowerLimit(anaerobicHeartRateLowerLimit.getBytes());
        }

        /**
         * @see #addAnaerobicHeartRateLowerLimit(int, long, byte[])
         */
        @NonNull
        public Builder<T> addAnaerobicHeartRateLowerLimit(@NonNull byte[] value) {
            return addAnaerobicHeartRateLowerLimit(BluetoothGatt.GATT_SUCCESS
                    , 0
                    , value);
        }

        /**
         * add Anaerobic Heart Rate Lower Limit characteristic
         *
         * @param responseCode response code for {@link BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 3rd parameter
         * @param delay        response delay(millis)
         * @param value        data array for {@link BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> addAnaerobicHeartRateLowerLimit(int responseCode, long delay, @NonNull byte[] value) {
            mAnaerobicHeartRateLowerLimitData = new UDSCharacteristicData(ANAEROBIC_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC
                    , BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE
                    , BluetoothGattCharacteristic.PERMISSION_READ | BluetoothGattCharacteristic.PERMISSION_WRITE
                    , Collections.emptyList()
                    , responseCode
                    , delay
                    , value
                    , 0);
            return this;
        }

        /**
         * remove Anaerobic Heart Rate Lower Limit characteristic
         *
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> removeAnaerobicHeartRateLowerLimit() {
            mAnaerobicHeartRateLowerLimitData = null;
            return this;
        }

        /**
         * @see #addAnaerobicHeartRateUpperLimit(AnaerobicHeartRateUpperLimit)
         */
        @NonNull
        public Builder<T> addAnaerobicHeartRateUpperLimit(int anaerobicHeartRateUpperLimit) {
            return addAnaerobicHeartRateUpperLimit(new AnaerobicHeartRateUpperLimit(anaerobicHeartRateUpperLimit));
        }

        /**
         * @see #addAnaerobicHeartRateUpperLimit(byte[])
         */
        @NonNull
        public Builder<T> addAnaerobicHeartRateUpperLimit(@NonNull AnaerobicHeartRateUpperLimit anaerobicHeartRateUpperLimit) {
            return addAnaerobicHeartRateUpperLimit(anaerobicHeartRateUpperLimit.getBytes());
        }

        /**
         * @see #addAnaerobicHeartRateUpperLimit(int, long, byte[])
         */
        @NonNull
        public Builder<T> addAnaerobicHeartRateUpperLimit(@NonNull byte[] value) {
            return addAnaerobicHeartRateUpperLimit(BluetoothGatt.GATT_SUCCESS
                    , 0
                    , value);
        }

        /**
         * add Anaerobic Heart Rate Lower Limit characteristic
         *
         * @param responseCode response code for {@link BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 3rd parameter
         * @param delay        response delay(millis)
         * @param value        data array for {@link BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> addAnaerobicHeartRateUpperLimit(int responseCode, long delay, @NonNull byte[] value) {
            mAnaerobicHeartRateUpperLimitData = new UDSCharacteristicData(ANAEROBIC_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC
                    , BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE
                    , BluetoothGattCharacteristic.PERMISSION_READ | BluetoothGattCharacteristic.PERMISSION_WRITE
                    , Collections.emptyList()
                    , responseCode
                    , delay
                    , value
                    , 0);
            return this;
        }

        /**
         * remove Anaerobic Heart Rate Lower Limit characteristic
         *
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> removeAnaerobicHeartRateUpperLimit() {
            mAnaerobicHeartRateUpperLimitData = null;
            return this;
        }

        /**
         * @see #addFiveZoneHeartRateLimits(FiveZoneHeartRateLimits)
         */
        @NonNull
        public Builder<T> addFiveZoneHeartRateLimits(int fiveZoneHeartRateLimitsVeryLightLightLimit, int fiveZoneHeartRateLimitsLightModerateLimit, int fiveZoneHeartRateLimitsModerateHardLimit, int fiveZoneHeartRateLimitsHardMaximumLimit) {
            return addFiveZoneHeartRateLimits(new FiveZoneHeartRateLimits(fiveZoneHeartRateLimitsVeryLightLightLimit, fiveZoneHeartRateLimitsLightModerateLimit, fiveZoneHeartRateLimitsModerateHardLimit, fiveZoneHeartRateLimitsHardMaximumLimit));
        }

        /**
         * @see #addFiveZoneHeartRateLimits(byte[])
         */
        @NonNull
        public Builder<T> addFiveZoneHeartRateLimits(@NonNull FiveZoneHeartRateLimits fiveZoneHeartRateLimits) {
            return addFiveZoneHeartRateLimits(fiveZoneHeartRateLimits.getBytes());
        }

        /**
         * @see #addFiveZoneHeartRateLimits(int, long, byte[])
         */
        @NonNull
        public Builder<T> addFiveZoneHeartRateLimits(@NonNull byte[] value) {
            return addFiveZoneHeartRateLimits(BluetoothGatt.GATT_SUCCESS
                    , 0
                    , value);
        }

        /**
         * add Five Zone Heart Rate Limits characteristic
         *
         * @param responseCode response code for {@link BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 3rd parameter
         * @param delay        response delay(millis)
         * @param value        data array for {@link BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> addFiveZoneHeartRateLimits(int responseCode, long delay, @NonNull byte[] value) {
            mFiveZoneHeartRateLimitsData = new UDSCharacteristicData(FIVE_ZONE_HEART_RATE_LIMITS_CHARACTERISTIC
                    , BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE
                    , BluetoothGattCharacteristic.PERMISSION_READ | BluetoothGattCharacteristic.PERMISSION_WRITE
                    , Collections.emptyList()
                    , responseCode
                    , delay
                    , value
                    , 0);
            return this;
        }

        /**
         * remove Five Zone Heart Rate Limits characteristic
         *
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> removeFiveZoneHeartRateLimits() {
            mFiveZoneHeartRateLimitsData = null;
            return this;
        }

        /**
         * @see #addThreeZoneHeartRateLimits(ThreeZoneHeartRateLimits)
         */
        @NonNull
        public Builder<T> addThreeZoneHeartRateLimits(int threeZoneHeartRateLimitsLightFatBurnModerateAerobicLimit, int threeZoneHeartRateLimitsModerateAerobicHardAnaerobicLimit) {
            return addThreeZoneHeartRateLimits(new ThreeZoneHeartRateLimits(threeZoneHeartRateLimitsLightFatBurnModerateAerobicLimit, threeZoneHeartRateLimitsModerateAerobicHardAnaerobicLimit));
        }

        /**
         * @see #addThreeZoneHeartRateLimits(byte[])
         */
        @NonNull
        public Builder<T> addThreeZoneHeartRateLimits(@NonNull ThreeZoneHeartRateLimits threeZoneHeartRateLimits) {
            return addThreeZoneHeartRateLimits(threeZoneHeartRateLimits.getBytes());
        }

        /**
         * @see #addFiveZoneHeartRateLimits(int, long, byte[])
         */
        @NonNull
        public Builder<T> addThreeZoneHeartRateLimits(@NonNull byte[] value) {
            return addThreeZoneHeartRateLimits(BluetoothGatt.GATT_SUCCESS
                    , 0
                    , value);
        }

        /**
         * add Three Zone Heart Rate Limits characteristic
         *
         * @param responseCode response code for {@link BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 3rd parameter
         * @param delay        response delay(millis)
         * @param value        data array for {@link BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> addThreeZoneHeartRateLimits(int responseCode, long delay, @NonNull byte[] value) {
            mThreeZoneHeartRateLimitsData = new UDSCharacteristicData(THREE_ZONE_HEART_RATE_LIMITS_CHARACTERISTIC
                    , BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE
                    , BluetoothGattCharacteristic.PERMISSION_READ | BluetoothGattCharacteristic.PERMISSION_WRITE
                    , Collections.emptyList()
                    , responseCode
                    , delay
                    , value
                    , 0);
            return this;
        }

        /**
         * remove Three Zone Heart Rate Limits characteristic
         *
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> removeThreeZoneHeartRateLimits() {
            mThreeZoneHeartRateLimitsData = null;
            return this;
        }

        /**
         * @see #addTwoZoneHeartRateLimit(TwoZoneHeartRateLimit)
         */
        @NonNull
        public Builder<T> addTwoZoneHeartRateLimit(int twoZoneHeartRateLimitFatBurnFitnessLimit) {
            return addTwoZoneHeartRateLimit(new TwoZoneHeartRateLimit(twoZoneHeartRateLimitFatBurnFitnessLimit));
        }

        /**
         * @see #addTwoZoneHeartRateLimit(byte[])
         */
        @NonNull
        public Builder<T> addTwoZoneHeartRateLimit(@NonNull TwoZoneHeartRateLimit twoZoneHeartRateLimit) {
            return addTwoZoneHeartRateLimit(twoZoneHeartRateLimit.getBytes());
        }

        /**
         * @see #addTwoZoneHeartRateLimit(int, long, byte[])
         */
        @NonNull
        public Builder<T> addTwoZoneHeartRateLimit(@NonNull byte[] value) {
            return addTwoZoneHeartRateLimit(BluetoothGatt.GATT_SUCCESS
                    , 0
                    , value);
        }

        /**
         * add Two Zone Heart Rate Limit characteristic
         *
         * @param responseCode response code for {@link BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 3rd parameter
         * @param delay        response delay(millis)
         * @param value        data array for {@link BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> addTwoZoneHeartRateLimit(int responseCode, long delay, @NonNull byte[] value) {
            mTwoZoneHeartRateLimitData = new UDSCharacteristicData(TWO_ZONE_HEART_RATE_LIMITS_CHARACTERISTIC
                    , BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE
                    , BluetoothGattCharacteristic.PERMISSION_READ | BluetoothGattCharacteristic.PERMISSION_WRITE
                    , Collections.emptyList()
                    , responseCode
                    , delay
                    , value
                    , 0);
            return this;
        }

        /**
         * remove Two Zone Heart Rate Limit characteristic
         *
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> removeTwoZoneHeartRateLimit() {
            mTwoZoneHeartRateLimitData = null;
            return this;
        }

        /**
         * @see #addLanguage(Language)
         */
        @NonNull
        public Builder<T> addLanguage(@NonNull String language) {
            return addLanguage(new Language(language));
        }

        /**
         * @see #addLanguage(byte[])
         */
        @NonNull
        public Builder<T> addLanguage(@NonNull Language language) {
            return addLanguage(language.getBytes());
        }

        /**
         * @see #addLanguage(int, long, byte[])
         */
        @NonNull
        public Builder<T> addLanguage(@NonNull byte[] value) {
            return addLanguage(BluetoothGatt.GATT_SUCCESS
                    , 0
                    , value);
        }

        /**
         * add Language characteristic
         *
         * @param responseCode response code for {@link BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 3rd parameter
         * @param delay        response delay(millis)
         * @param value        data array for {@link BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> addLanguage(int responseCode, long delay, @NonNull byte[] value) {
            mLanguageData = new UDSCharacteristicData(LANGUAGE_CHARACTERISTIC
                    , BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE
                    , BluetoothGattCharacteristic.PERMISSION_READ | BluetoothGattCharacteristic.PERMISSION_WRITE
                    , Collections.emptyList()
                    , responseCode
                    , delay
                    , value
                    , 0);
            return this;
        }

        /**
         * remove Language characteristic
         *
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> removeLanguage() {
            mLanguageData = null;
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
         * add Database Change Increment characteristic
         *
         * @param characteristicResponseCode characteristic response code for {@link BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 3rd parameter
         * @param characteristicDelay        characteristic response delay(millis)
         * @param isNotificatable            notificatable flag for Database Change Increment characteristic
         * @param descriptorResponseCode     descriptor response code for {@link BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 3rd parameter
         * @param descriptorDelay            descriptor response delay(millis)
         * @param descriptorValue            descriptor data array for {@link BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> addDatabaseChangeIncrement(int characteristicResponseCode, long characteristicDelay, boolean isNotificatable, int descriptorResponseCode, long descriptorDelay, @NonNull byte[] descriptorValue) {
            int property = BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE;
            int permission = BluetoothGattCharacteristic.PERMISSION_READ | BluetoothGattCharacteristic.PERMISSION_WRITE;
            List<DescriptorData> descriptorDataList = new ArrayList<>();
            if (isNotificatable) {
                property |= BluetoothGattCharacteristic.PROPERTY_NOTIFY;
                descriptorDataList.add(new DescriptorData(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, descriptorResponseCode, descriptorDelay, descriptorValue));
            }
            mDatabaseChangeIncrementData = new CharacteristicData(DATABASE_CHANGE_INCREMENT_CHARACTERISTIC
                    , property
                    , permission
                    , descriptorDataList
                    , characteristicResponseCode
                    , characteristicDelay
                    , new byte[0] // variable
                    , 0);

            return this;
        }

        /**
         * remove Database Change Increment characteristic
         *
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> removeDatabaseChangeIncrement() {
            mDatabaseChangeIncrementData = null;
            return this;
        }

        /**
         * @see #addUserIndex(int, long)
         */
        @NonNull
        public Builder<T> addUserIndex() {
            return addUserIndex(BluetoothGatt.GATT_SUCCESS, 0);
        }

        /**
         * add User Index characteristic
         *
         * @param responseCode response code for {@link BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 3rd parameter
         * @param delay        response delay(millis)
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> addUserIndex(int responseCode, long delay) {
            mUserIndexData = new CharacteristicData(USER_INDEX_CHARACTERISTIC
                    , BluetoothGattCharacteristic.PROPERTY_READ
                    , BluetoothGattCharacteristic.PERMISSION_READ
                    , Collections.emptyList()
                    , responseCode
                    , delay
                    , new byte[0] // variable
                    , 0);
            return this;
        }

        /**
         * remove User Index characteristic
         *
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> removeUserIndex() {
            mUserIndexData = null;
            return this;
        }

        /**
         * add Registered User characteristic
         *
         * @param characteristicDelay          characteristic response delay(millis)
         * @param registerNewUserResponseValue characteristic response code for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter(Register New User response)
         * @param consentResponseValue         characteristic response code for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter(Consent Response response)
         * @param deleteUserDataResponseValue  characteristic response code for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter(Delete User Data response)
         * @param listAllUsersResponseValue    characteristic response code for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter(List All Users response)
         * @param deleteUsersResponseValue     characteristic response code for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter(Delete Users response)
         * @param descriptorResponseCode       descriptor response code for {@link BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 3rd parameter
         * @param descriptorDelay              descriptor response delay(millis)
         * @param descriptorValue              descriptor data array for {@link BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @return {@link Builder} instance
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
            mUserControlPointData = new UserControlPointCharacteristicData(BluetoothGattCharacteristic.PROPERTY_WRITE | BluetoothGattCharacteristic.PROPERTY_INDICATE
                    , BluetoothGattCharacteristic.PERMISSION_WRITE
                    , Collections.singletonList(new DescriptorData(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR
                    , BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE
                    , descriptorResponseCode
                    , descriptorDelay
                    , descriptorValue))
                    , characteristicDelay
                    , registerNewUserResponseValue
                    , consentResponseValue
                    , deleteUserDataResponseValue
                    , listAllUsersResponseValue
                    , deleteUsersResponseValue);
            return this;
        }

        /**
         * remove Registered User characteristic
         *
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> removeUserControlPoint() {
            mUserControlPointData = null;
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
         * add Registered User characteristic
         *
         * @param characteristicResponseCode characteristic response code for {@link BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 3rd parameter
         * @param characteristicDelay        characteristic response delay(millis)
         * @param descriptorResponseCode     descriptor response code for {@link BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 3rd parameter
         * @param descriptorDelay            descriptor response delay(millis)
         * @param descriptorValue            descriptor data array for {@link BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> addRegisteredUser(int characteristicResponseCode, long characteristicDelay, int descriptorResponseCode, long descriptorDelay, @NonNull byte[] descriptorValue) {
            mRegisteredUserData = new CharacteristicData(REGISTERED_USER_CHARACTERISTIC
                    , BluetoothGattCharacteristic.PROPERTY_INDICATE
                    , 0
                    , Collections.singletonList(new DescriptorData(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR
                    , BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE
                    , descriptorResponseCode
                    , descriptorDelay
                    , descriptorValue))
                    , characteristicResponseCode
                    , characteristicDelay
                    , new byte[0] // variable
                    , 0);
            return this;
        }

        /**
         * remove Registered User characteristic
         *
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> removeRegisteredUser() {
            mRegisteredUserData = null;
            return this;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public ServiceData createData() {
            if (mFirstNameData == null
                    && mLastNameData == null
                    && mEmailAddressData == null
                    && mAgeData == null
                    && mDateOfBirthData == null
                    && mGenderData == null
                    && mWeightData == null
                    && mHeightData == null
                    && mVO2MaxData == null
                    && mHeartRateMaxData == null
                    && mRestingHeartRateData == null
                    && mMaximumRecommendedHeartRateData == null
                    && mAerobicThresholdData == null
                    && mAnaerobicThresholdData == null
                    && mSportTypeForAerobicAndAnaerobicThresholdsData == null
                    && mDateOfThresholdAssessmentData == null
                    && mWaistCircumferenceData == null
                    && mHipCircumferenceData == null
                    && mFatBurnHeartRateLowerLimitData == null
                    && mFatBurnHeartRateUpperLimitData == null
                    && mAerobicHeartRateLowerLimitData == null
                    && mAerobicHeartRateUpperLimitData == null
                    && mAnaerobicHeartRateLowerLimitData == null
                    && mAnaerobicHeartRateUpperLimitData == null
                    && mFiveZoneHeartRateLimitsData == null
                    && mThreeZoneHeartRateLimitsData == null
                    && mTwoZoneHeartRateLimitData == null
                    && mLanguageData == null) {
                throw new RuntimeException("At least one UDS Characteristic shall be exposed");
            }

            if (mDatabaseChangeIncrementData == null) {
                throw new RuntimeException("no Database Change Increment data");
            }

            if (mUserIndexData == null) {
                throw new RuntimeException("no User Index data");
            }

            if (mUserControlPointData == null) {
                throw new RuntimeException("no User Control Point data");
            }

            if (UserControlPoint.RESPONSE_VALUE_SUCCESS == mUserControlPointData.listAllUsersResponseValue) {
                if (mRegisteredUserData == null) {
                    throw new RuntimeException("no Registered User data");
                }
            }

            return new UserDataServiceData(mFirstNameData
                    , mLastNameData
                    , mEmailAddressData
                    , mAgeData
                    , mDateOfBirthData
                    , mGenderData
                    , mWeightData
                    , mHeightData
                    , mVO2MaxData
                    , mHeartRateMaxData
                    , mRestingHeartRateData
                    , mMaximumRecommendedHeartRateData
                    , mAerobicThresholdData
                    , mAnaerobicThresholdData
                    , mSportTypeForAerobicAndAnaerobicThresholdsData
                    , mDateOfThresholdAssessmentData
                    , mWaistCircumferenceData
                    , mHipCircumferenceData
                    , mFatBurnHeartRateLowerLimitData
                    , mFatBurnHeartRateUpperLimitData
                    , mAerobicHeartRateLowerLimitData
                    , mAerobicHeartRateUpperLimitData
                    , mAnaerobicHeartRateLowerLimitData
                    , mAnaerobicHeartRateUpperLimitData
                    , mFiveZoneHeartRateLimitsData
                    , mThreeZoneHeartRateLimitsData
                    , mTwoZoneHeartRateLimitData
                    , mLanguageData
                    , mDatabaseChangeIncrementData
                    , mUserIndexData
                    , mUserControlPointData
                    , mRegisteredUserData
            );
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public UserDataServiceMockCallback build() {
            return new UserDataServiceMockCallback(createData(), false);
        }

    }

    /**
     * next new user's user index
     */
    protected final AtomicInteger mNextUserIndex = new AtomicInteger(0);

    /**
     * key:user index, value:consent
     */
    protected final Map<Integer, Integer> mUserMap = Collections.synchronizedMap(new HashMap<>());

    /**
     * key:bluetooth device, value:user index
     */
    protected final Map<BluetoothDevice, Integer> mCurrentUserMap = Collections.synchronizedMap(new HashMap<>());

    /**
     * key:user index, value:database change increment
     */
    protected final Map<Integer, Long> mCurrentDatabaseChangeIncrementMap = Collections.synchronizedMap(new HashMap<>());

    /**
     * current registered user(list all users) indication data
     */
    protected RegisteredUserIndicationData mRegisteredUserIndicationData;

    /**
     * @param serviceData {@link ServiceData} instance
     * @param isFallback  fallback flag
     */
    public UserDataServiceMockCallback(@NonNull ServiceData serviceData, boolean isFallback) {
        super(serviceData, isFallback);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onServerStopped() {
        mNextUserIndex.set(0);
        mUserMap.clear();
        mCurrentUserMap.clear();
        mCurrentDatabaseChangeIncrementMap.clear();
        mRegisteredUserIndicationData = null;
        super.onServerStopped();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onDeviceDisconnected(@NonNull BLEServerConnection bleServerConnection, @NonNull BluetoothDevice device) {
        mCurrentUserMap.remove(device);
        super.onDeviceDisconnected(bleServerConnection, device);
    }

    /**
     * @param device                      {@link #onCharacteristicReadRequest(BLEServerConnection, BluetoothDevice, int, int, BluetoothGattCharacteristic, boolean)} 2nd parameter
     * @param requestId                   {@link #onCharacteristicReadRequest(BLEServerConnection, BluetoothDevice, int, int, BluetoothGattCharacteristic, boolean)} 3rd parameter
     * @param offset                      {@link #onCharacteristicReadRequest(BLEServerConnection, BluetoothDevice, int, int, BluetoothGattCharacteristic, boolean)} 4th parameter
     * @param bluetoothGattCharacteristic {@link #onCharacteristicReadRequest(BLEServerConnection, BluetoothDevice, int, int, BluetoothGattCharacteristic, boolean)} 5th parameter
     * @param force                       {@link #onCharacteristicReadRequest(BLEServerConnection, BluetoothDevice, int, int, BluetoothGattCharacteristic, boolean)} 6th parameter
     * @param bluetoothGattServer         {@link BluetoothGattServer} instance
     * @return {@code true}:handled, {@code false}:not handled
     */
    @SuppressLint("MissingPermission")
    protected boolean onDatabaseChangeIncrementReadRequest(@NonNull BluetoothDevice device, int requestId, int offset, @NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic, boolean force, @NonNull BluetoothGattServer bluetoothGattServer) {
        boolean result = false;

        long now = SystemClock.elapsedRealtime();
        BluetoothGattService bluetoothGattService = bluetoothGattCharacteristic.getService();
        UUID serviceUUID = bluetoothGattService.getUuid();
        int serviceInstanceId = bluetoothGattService.getInstanceId();
        Map<Pair<UUID, Integer>, CharacteristicData> characteristicMap = mRemappedServiceCharacteristicMap.get(Pair.create(serviceUUID, serviceInstanceId));
        if (characteristicMap == null) {
            if (force) {
                result = bluetoothGattServer.sendResponse(device, requestId, APPLICATION_ERROR_9F, offset, null);
            }
        } else {
            int characteristicInstanceId = bluetoothGattCharacteristic.getInstanceId();
            CharacteristicData characteristicData = characteristicMap.get(Pair.create(DATABASE_CHANGE_INCREMENT_CHARACTERISTIC, characteristicInstanceId));
            if (characteristicData != null) {
                delay(now, characteristicData.delay);

                Integer currentUserIndex = mCurrentUserMap.get(device);
                int responseCode;
                if (currentUserIndex == null) {
                    responseCode = APPLICATION_ERROR_80;
                } else {
                    responseCode = characteristicData.responseCode;
                }

                if (responseCode == BluetoothGatt.GATT_SUCCESS) {
                    Long currentDci = mCurrentDatabaseChangeIncrementMap.get(currentUserIndex);
                    if (currentDci == null) {
                        currentDci = 0L;
                        mCurrentDatabaseChangeIncrementMap.put(currentUserIndex, currentDci);
                    }

                    result = bluetoothGattServer.sendResponse(device, requestId, responseCode, offset, new DatabaseChangeIncrement(currentDci).getBytes());
                } else {
                    result = bluetoothGattServer.sendResponse(device, requestId, responseCode, offset, null);
                }
            }
            if (force && !result) {
                result = bluetoothGattServer.sendResponse(device, requestId, APPLICATION_ERROR_9F, offset, null);
            }
        }
        return result;
    }

    /**
     * @param device                      {@link #onCharacteristicReadRequest(BLEServerConnection, BluetoothDevice, int, int, BluetoothGattCharacteristic, boolean)} 2nd parameter
     * @param requestId                   {@link #onCharacteristicReadRequest(BLEServerConnection, BluetoothDevice, int, int, BluetoothGattCharacteristic, boolean)} 3rd parameter
     * @param offset                      {@link #onCharacteristicReadRequest(BLEServerConnection, BluetoothDevice, int, int, BluetoothGattCharacteristic, boolean)} 4th parameter
     * @param bluetoothGattCharacteristic {@link #onCharacteristicReadRequest(BLEServerConnection, BluetoothDevice, int, int, BluetoothGattCharacteristic, boolean)} 5th parameter
     * @param force                       {@link #onCharacteristicReadRequest(BLEServerConnection, BluetoothDevice, int, int, BluetoothGattCharacteristic, boolean)} 6th parameter
     * @param bluetoothGattServer         {@link BluetoothGattServer} instance
     * @return {@code true}:handled, {@code false}:not handled
     */
    @SuppressLint("MissingPermission")
    protected boolean onUserIndexReadRequest(@NonNull BluetoothDevice device, int requestId, int offset, @NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic, boolean force, @NonNull BluetoothGattServer bluetoothGattServer) {
        boolean result = false;

        long now = SystemClock.elapsedRealtime();
        BluetoothGattService bluetoothGattService = bluetoothGattCharacteristic.getService();
        UUID serviceUUID = bluetoothGattService.getUuid();
        int serviceInstanceId = bluetoothGattService.getInstanceId();
        Map<Pair<UUID, Integer>, CharacteristicData> characteristicMap = mRemappedServiceCharacteristicMap.get(Pair.create(serviceUUID, serviceInstanceId));
        if (characteristicMap == null) {
            if (force) {
                result = bluetoothGattServer.sendResponse(device, requestId, APPLICATION_ERROR_9F, offset, null);
            }
        } else {
            int characteristicInstanceId = bluetoothGattCharacteristic.getInstanceId();
            CharacteristicData characteristicData = characteristicMap.get(Pair.create(USER_INDEX_CHARACTERISTIC, characteristicInstanceId));
            if (characteristicData != null) {
                delay(now, characteristicData.delay);

                Integer currentUserIndex = mCurrentUserMap.get(device);
                int responseCode;
                if (currentUserIndex == null) {
                    currentUserIndex = UserIndexUtils.USER_ID_UNKNOWN_USER;
                    responseCode = APPLICATION_ERROR_80;
                } else {
                    responseCode = characteristicData.responseCode;
                }

                if (responseCode == BluetoothGatt.GATT_SUCCESS) {
                    result = bluetoothGattServer.sendResponse(device, requestId, responseCode, offset, new UserIndex(currentUserIndex).getBytes());
                } else {
                    result = bluetoothGattServer.sendResponse(device, requestId, responseCode, offset, null);
                }
            }
            if (force && !result) {
                result = bluetoothGattServer.sendResponse(device, requestId, APPLICATION_ERROR_9F, offset, null);
            }
        }
        return result;
    }

    /**
     * @param device                      {@link #onCharacteristicReadRequest(BLEServerConnection, BluetoothDevice, int, int, BluetoothGattCharacteristic, boolean)} 2nd parameter
     * @param requestId                   {@link #onCharacteristicReadRequest(BLEServerConnection, BluetoothDevice, int, int, BluetoothGattCharacteristic, boolean)} 3rd parameter
     * @param offset                      {@link #onCharacteristicReadRequest(BLEServerConnection, BluetoothDevice, int, int, BluetoothGattCharacteristic, boolean)} 4th parameter
     * @param bluetoothGattCharacteristic {@link #onCharacteristicReadRequest(BLEServerConnection, BluetoothDevice, int, int, BluetoothGattCharacteristic, boolean)} 5th parameter
     * @param force                       {@link #onCharacteristicReadRequest(BLEServerConnection, BluetoothDevice, int, int, BluetoothGattCharacteristic, boolean)} 6th parameter
     * @param bluetoothGattServer         {@link BluetoothGattServer} instance
     * @return {@code true}:handled, {@code false}:not handled
     */
    @SuppressLint("MissingPermission")
    protected boolean onUserDataReadRequest(@NonNull BluetoothDevice device, int requestId, int offset, @NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic, boolean force, @NonNull BluetoothGattServer bluetoothGattServer) {
        boolean result = false;

        long now = SystemClock.elapsedRealtime();
        BluetoothGattService bluetoothGattService = bluetoothGattCharacteristic.getService();
        UUID serviceUUID = bluetoothGattService.getUuid();
        int serviceInstanceId = bluetoothGattService.getInstanceId();
        Map<Pair<UUID, Integer>, CharacteristicData> characteristicMap = mRemappedServiceCharacteristicMap.get(Pair.create(serviceUUID, serviceInstanceId));
        if (characteristicMap == null) {
            if (force) {
                result = bluetoothGattServer.sendResponse(device, requestId, APPLICATION_ERROR_9F, offset, null);
            }
        } else {
            int characteristicInstanceId = bluetoothGattCharacteristic.getInstanceId();
            UDSCharacteristicData udsCharacteristicData = (UDSCharacteristicData) characteristicMap.get(Pair.create(bluetoothGattCharacteristic.getUuid(), characteristicInstanceId));
            if (udsCharacteristicData != null) {
                delay(now, udsCharacteristicData.delay);

                Integer currentUserIndex = mCurrentUserMap.get(device);
                int responseCode;
                if (currentUserIndex == null) {
                    responseCode = APPLICATION_ERROR_80;
                } else {
                    responseCode = udsCharacteristicData.responseCode;
                }

                if (responseCode == BluetoothGatt.GATT_SUCCESS) {
                    CharacteristicData characteristicData = udsCharacteristicData.getUserData(currentUserIndex);

                    if (characteristicData != null) {
                        byte[] data = characteristicData.getBytes();
                        result = bluetoothGattServer.sendResponse(device, requestId, responseCode, offset, Arrays.copyOfRange(data, offset, data.length));
                    }
                } else {
                    result = bluetoothGattServer.sendResponse(device, requestId, responseCode, offset, null);
                }
            }
            if (force && !result) {
                result = bluetoothGattServer.sendResponse(device, requestId, APPLICATION_ERROR_9F, offset, null);
            }
        }
        return result;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized boolean onCharacteristicReadRequest(@NonNull BLEServerConnection bleServerConnection
            , @NonNull BluetoothDevice device
            , int requestId
            , int offset
            , @NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic
            , boolean force) {
        boolean result = false;
        BluetoothGattServer bluetoothGattServer = bleServerConnection.getBluetoothGattServer();

        if (bluetoothGattServer != null) {
            UUID characteristicUUID = bluetoothGattCharacteristic.getUuid();
            if (DATABASE_CHANGE_INCREMENT_CHARACTERISTIC.equals(characteristicUUID)) {
                result = onDatabaseChangeIncrementReadRequest(device, requestId, offset, bluetoothGattCharacteristic, force, bluetoothGattServer);
            } else if (USER_INDEX_CHARACTERISTIC.equals(characteristicUUID)) {
                result = onUserIndexReadRequest(device, requestId, offset, bluetoothGattCharacteristic, force, bluetoothGattServer);
            } else if (UDS_CHARACTERISTIC_SET.contains(characteristicUUID)) {
                result = onUserDataReadRequest(device, requestId, offset, bluetoothGattCharacteristic, force, bluetoothGattServer);
            } else {
                result = super.onCharacteristicReadRequest(bleServerConnection, device, requestId, offset, bluetoothGattCharacteristic, force);
            }
        }
        return result;
    }

    /**
     * @param bleServerConnection         {@link BLEServerConnection} instance
     * @param device                      {@link #onCharacteristicWriteRequest(BLEServerConnection, BluetoothDevice, int, BluetoothGattCharacteristic, boolean, boolean, int, byte[], boolean)} 2nd parameter
     * @param requestId                   {@link #onCharacteristicWriteRequest(BLEServerConnection, BluetoothDevice, int, BluetoothGattCharacteristic, boolean, boolean, int, byte[], boolean)} 3rd parameter
     * @param bluetoothGattCharacteristic {@link #onCharacteristicWriteRequest(BLEServerConnection, BluetoothDevice, int, BluetoothGattCharacteristic, boolean, boolean, int, byte[], boolean)} 4th parameter
     * @param preparedWrite               {@link #onCharacteristicWriteRequest(BLEServerConnection, BluetoothDevice, int, BluetoothGattCharacteristic, boolean, boolean, int, byte[], boolean)} 5th parameter
     * @param offset                      {@link #onCharacteristicWriteRequest(BLEServerConnection, BluetoothDevice, int, BluetoothGattCharacteristic, boolean, boolean, int, byte[], boolean)} 7th parameter
     * @param value                       {@link #onCharacteristicWriteRequest(BLEServerConnection, BluetoothDevice, int, BluetoothGattCharacteristic, boolean, boolean, int, byte[], boolean)} 8th parameter
     * @param force                       {@link #onCharacteristicWriteRequest(BLEServerConnection, BluetoothDevice, int, BluetoothGattCharacteristic, boolean, boolean, int, byte[], boolean)} 9th parameter
     * @param bluetoothGattServer         {@link BluetoothGattServer} instance
     * @return {@code true}:handled, {@code false}:not handled
     */
    @SuppressLint("MissingPermission")
    protected boolean onDatabaseChangeIncrementWriteRequest(@NonNull BLEServerConnection bleServerConnection
            , @NonNull BluetoothDevice device
            , int requestId
            , @NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic
            , int offset
            , boolean preparedWrite
            , @NonNull byte[] value
            , boolean force
            , @NonNull BluetoothGattServer bluetoothGattServer) {
        boolean result = false;

        long now = SystemClock.elapsedRealtime();
        BluetoothGattService bluetoothGattService = bluetoothGattCharacteristic.getService();
        UUID serviceUUID = bluetoothGattService.getUuid();
        int serviceInstanceId = bluetoothGattService.getInstanceId();
        Map<Pair<UUID, Integer>, CharacteristicData> characteristicMap = mRemappedServiceCharacteristicMap.get(Pair.create(serviceUUID, serviceInstanceId));
        if (characteristicMap == null) {
            if (force) {
                result = bluetoothGattServer.sendResponse(device, requestId, APPLICATION_ERROR_9F, offset, null);
            }
        } else {
            int characteristicInstanceId = bluetoothGattCharacteristic.getInstanceId();
            CharacteristicData characteristicData = characteristicMap.get(Pair.create(DATABASE_CHANGE_INCREMENT_CHARACTERISTIC, characteristicInstanceId));
            if (characteristicData != null) {
                delay(now, characteristicData.delay);

                Integer currentUserIndex = mCurrentUserMap.get(device);
                int responseCode;
                if (currentUserIndex == null) {
                    responseCode = APPLICATION_ERROR_80;
                } else {
                    responseCode = characteristicData.responseCode;
                }

                result = bluetoothGattServer.sendResponse(device, requestId, responseCode, offset, preparedWrite ? value : null);

                if (result && responseCode == BluetoothGatt.GATT_SUCCESS) {
                    mCurrentDatabaseChangeIncrementMap.put(currentUserIndex, new DatabaseChangeIncrement(value).getDatabaseChangeIncrement());

                    Map<Pair<UUID, Integer>, DescriptorData> descriptorDataMap = mRemappedCharacteristicDescriptorMap.get(Pair.create(DATABASE_CHANGE_INCREMENT_CHARACTERISTIC, characteristicInstanceId));
                    if (descriptorDataMap != null) {
                        for (Map.Entry<Pair<UUID, Integer>, DescriptorData> descriptorEntry : descriptorDataMap.entrySet()) {
                            DescriptorData descriptorData = descriptorEntry.getValue();
                            if (CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR.equals(descriptorData.uuid) && Arrays.equals(BluetoothGattDescriptor.ENABLE_INDICATION_VALUE, descriptorData.getBytes())) {
                                for (BluetoothDevice connectedDevice : mConnectedDeviceMap.keySet()) {
                                    if (!device.equals(connectedDevice)) {
                                        startNotification(null
                                                , bleServerConnection
                                                , connectedDevice
                                                , USER_DATA_SERVICE
                                                , serviceInstanceId
                                                , DATABASE_CHANGE_INCREMENT_CHARACTERISTIC
                                                , characteristicInstanceId
                                                , descriptorEntry.getKey().second
                                                , characteristicData.delay
                                                , 1
                                                , null);
                                    }
                                }
                            }
                        }
                    }
                }
            }
            if (force && !result) {
                result = bluetoothGattServer.sendResponse(device, requestId, APPLICATION_ERROR_9F, offset, null);
            }
        }
        return result;
    }

    /**
     * Delete User Data process
     *
     * @param userIndex user index
     */
    protected void deleteUserData(int userIndex) {
        for (Map.Entry<Pair<UUID, Integer>, Map<Pair<UUID, Integer>, CharacteristicData>> serviceEntry : mRemappedServiceCharacteristicMap.entrySet()) {
            Pair<UUID, Integer> serviceKey = serviceEntry.getKey();
            if (USER_DATA_SERVICE.equals(serviceKey.first)) {
                for (Map.Entry<Pair<UUID, Integer>, CharacteristicData> characteristicEntry : serviceEntry.getValue().entrySet()) {
                    Pair<UUID, Integer> characteristicKey = characteristicEntry.getKey();
                    if (UDS_CHARACTERISTIC_SET.contains(characteristicKey.first)) {
                        CharacteristicData targetCharacteristicData = characteristicEntry.getValue();
                        if (targetCharacteristicData instanceof UDSCharacteristicData) {
                            UDSCharacteristicData udsCharacteristicData = (UDSCharacteristicData) targetCharacteristicData;
                            udsCharacteristicData.removeUserData(userIndex);
                        }
                    }
                }
                break;
            }
        }
    }

    /**
     * Delete Users process
     *
     * @param userIndex user index
     */
    protected void deleteUsers(int userIndex) {
        deleteUserData(userIndex);
        if (UserIndexUtils.isUserIdUnknownUser(userIndex)) {
            mUserMap.clear();
            mCurrentDatabaseChangeIncrementMap.clear();
            mCurrentUserMap.clear();
        } else {
            mUserMap.remove(userIndex);
            mCurrentDatabaseChangeIncrementMap.remove(userIndex);
            Iterator<Map.Entry<BluetoothDevice, Integer>> it = mCurrentUserMap.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<BluetoothDevice, Integer> entry = it.next();
                Integer consentUserIndex = entry.getValue();
                if (consentUserIndex != null && consentUserIndex == userIndex) {
                    it.remove();
                }
            }
        }
    }

    /**
     * @param bleServerConnection         {@link BLEServerConnection} instance
     * @param device                      {@link #onCharacteristicWriteRequest(BLEServerConnection, BluetoothDevice, int, BluetoothGattCharacteristic, boolean, boolean, int, byte[], boolean)} 2nd parameter
     * @param requestId                   {@link #onCharacteristicWriteRequest(BLEServerConnection, BluetoothDevice, int, BluetoothGattCharacteristic, boolean, boolean, int, byte[], boolean)} 3rd parameter
     * @param bluetoothGattCharacteristic {@link #onCharacteristicWriteRequest(BLEServerConnection, BluetoothDevice, int, BluetoothGattCharacteristic, boolean, boolean, int, byte[], boolean)} 4th parameter
     * @param preparedWrite               {@link #onCharacteristicWriteRequest(BLEServerConnection, BluetoothDevice, int, BluetoothGattCharacteristic, boolean, boolean, int, byte[], boolean)} 5th parameter
     * @param offset                      {@link #onCharacteristicWriteRequest(BLEServerConnection, BluetoothDevice, int, BluetoothGattCharacteristic, boolean, boolean, int, byte[], boolean)} 7th parameter
     * @param value                       {@link #onCharacteristicWriteRequest(BLEServerConnection, BluetoothDevice, int, BluetoothGattCharacteristic, boolean, boolean, int, byte[], boolean)} 8th parameter
     * @param force                       {@link #onCharacteristicWriteRequest(BLEServerConnection, BluetoothDevice, int, BluetoothGattCharacteristic, boolean, boolean, int, byte[], boolean)} 9th parameter
     * @param bluetoothGattServer         {@link BluetoothGattServer} instance
     * @return {@code true}:handled, {@code false}:not handled
     */
    @SuppressLint("MissingPermission")
    protected boolean onUserControlPointWriteRequest(@NonNull BLEServerConnection bleServerConnection
            , @NonNull BluetoothDevice device
            , int requestId
            , @NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic
            , boolean preparedWrite
            , int offset
            , @NonNull byte[] value
            , boolean force
            , @NonNull BluetoothGattServer bluetoothGattServer) {
        boolean result = false;

        long now = SystemClock.elapsedRealtime();
        BluetoothGattService bluetoothGattService = bluetoothGattCharacteristic.getService();
        UUID serviceUUID = bluetoothGattService.getUuid();
        int serviceInstanceId = bluetoothGattService.getInstanceId();
        Map<Pair<UUID, Integer>, CharacteristicData> characteristicMap = mRemappedServiceCharacteristicMap.get(Pair.create(serviceUUID, serviceInstanceId));
        if (characteristicMap == null) {
            if (force) {
                result = bluetoothGattServer.sendResponse(device, requestId, APPLICATION_ERROR_9F, offset, null);
            }
        } else {
            int characteristicInstanceId = bluetoothGattCharacteristic.getInstanceId();
            CharacteristicData characteristicData = characteristicMap.get(Pair.create(USER_CONTROL_POINT_CHARACTERISTIC, characteristicInstanceId));
            if (characteristicData != null) {
                delay(now, characteristicData.delay);

                if (BluetoothGatt.GATT_SUCCESS == characteristicData.responseCode) {
                    int responseCode = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR_IMPROPERLY_CONFIGURED;

                    Map<Pair<UUID, Integer>, DescriptorData> descriptorDataMap = mRemappedCharacteristicDescriptorMap.get(Pair.create(USER_CONTROL_POINT_CHARACTERISTIC, characteristicInstanceId));
                    if (characteristicData instanceof UserControlPointCharacteristicData && descriptorDataMap != null) {
                        for (Map.Entry<Pair<UUID, Integer>, DescriptorData> descriptorDataEntry : descriptorDataMap.entrySet()) {
                            Pair<UUID, Integer> key = descriptorDataEntry.getKey();
                            if (CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR.equals(key.first)) {

                                DescriptorData descriptorData = descriptorDataEntry.getValue();

                                if (Arrays.equals(BluetoothGattDescriptor.ENABLE_INDICATION_VALUE, descriptorData.getBytes())) {

                                    UserControlPoint userControlPoint = new UserControlPoint(value);
                                    UserControlPointCharacteristicData userControlPointCharacteristicData = (UserControlPointCharacteristicData) characteristicData;

                                    if (userControlPoint.isOpCodeRegisterNewUser(userControlPoint.getOpCode())) {
                                        if (userControlPoint.isResponseValueSuccess(userControlPointCharacteristicData.registerNewUserResponseValue)) {
                                            int userIndex = mNextUserIndex.getAndIncrement() % UserIndexUtils.USER_ID_UNKNOWN_USER;
                                            mUserMap.put(userIndex, userControlPoint.getConsentCode());
                                            userControlPointCharacteristicData.currentData = new UserControlPoint(UserControlPoint.OP_CODE_RESPONSE_CODE, userIndex, 0, UserControlPoint.OP_CODE_REGISTER_NEW_USER, userControlPointCharacteristicData.registerNewUserResponseValue, 0).getBytes();
                                        } else {
                                            userControlPointCharacteristicData.currentData = new UserControlPoint(UserControlPoint.OP_CODE_RESPONSE_CODE, 0, 0, UserControlPoint.OP_CODE_REGISTER_NEW_USER, userControlPointCharacteristicData.registerNewUserResponseValue, 0).getBytes();
                                        }

                                        responseCode = BluetoothGatt.GATT_SUCCESS;
                                    } else if (userControlPoint.isOpCodeConsent(userControlPoint.getOpCode())) {
                                        if (userControlPoint.isResponseValueSuccess(userControlPointCharacteristicData.consentResponseValue)) {
                                            int userIndex = userControlPoint.getUserIndex();
                                            Integer consent = mUserMap.get(userIndex);
                                            if (consent != null && consent == userControlPoint.getConsentCode()) {
                                                mCurrentUserMap.put(device, userIndex);

                                                userControlPointCharacteristicData.currentData = new UserControlPoint(UserControlPoint.OP_CODE_RESPONSE_CODE, 0, 0, UserControlPoint.OP_CODE_CONSENT, UserControlPoint.RESPONSE_VALUE_SUCCESS, 0).getBytes();
                                            } else {
                                                userControlPointCharacteristicData.currentData = new UserControlPoint(UserControlPoint.OP_CODE_RESPONSE_CODE, userIndex, 0, UserControlPoint.OP_CODE_CONSENT, UserControlPoint.RESPONSE_VALUE_USER_NOT_AUTHORIZED, 0).getBytes();
                                            }
                                        } else {
                                            userControlPointCharacteristicData.currentData = new UserControlPoint(UserControlPoint.OP_CODE_RESPONSE_CODE, 0, 0, UserControlPoint.OP_CODE_REGISTER_NEW_USER, userControlPointCharacteristicData.registerNewUserResponseValue, 0).getBytes();
                                        }

                                        responseCode = BluetoothGatt.GATT_SUCCESS;
                                    } else if (userControlPoint.isOpCodeDeleteUserData(userControlPoint.getOpCode())) {
                                        if (mCurrentUserMap.containsKey(device)) {
                                            if (userControlPoint.isResponseValueSuccess(userControlPointCharacteristicData.deleteUserDataResponseValue)) {
                                                deleteUserData(userControlPoint.getUserIndex());
                                                userControlPointCharacteristicData.currentData = new UserControlPoint(UserControlPoint.OP_CODE_RESPONSE_CODE, 0, 0, UserControlPoint.OP_CODE_DELETE_USER_DATA, UserControlPoint.RESPONSE_VALUE_SUCCESS, 0).getBytes();
                                                mCurrentUserMap.remove(device);
                                            } else {
                                                userControlPointCharacteristicData.currentData = new UserControlPoint(UserControlPoint.OP_CODE_RESPONSE_CODE, 0, 0, UserControlPoint.OP_CODE_DELETE_USER_DATA, userControlPointCharacteristicData.deleteUserDataResponseValue, 0).getBytes();
                                            }
                                        } else {
                                            userControlPointCharacteristicData.currentData = new UserControlPoint(UserControlPoint.OP_CODE_RESPONSE_CODE, 0, 0, UserControlPoint.OP_CODE_DELETE_USER_DATA, UserControlPoint.RESPONSE_VALUE_USER_NOT_AUTHORIZED, 0).getBytes();
                                        }

                                        responseCode = BluetoothGatt.GATT_SUCCESS;
                                    } else if (userControlPoint.isOpCodeListAllUsers(userControlPoint.getOpCode())) {
                                        if (mRegisteredUserIndicationData == null || mRegisteredUserIndicationData.timeout < SystemClock.elapsedRealtime()) {
                                            mRegisteredUserIndicationData = null;
                                            if (userControlPoint.isResponseValueSuccess(userControlPointCharacteristicData.listAllUsersResponseValue)) {
                                                int registeredUserClientCharacteristicConfigurationInstanceId = 0;
                                                for (Map.Entry<Pair<UUID, Integer>, Map<Pair<UUID, Integer>, DescriptorData>> a : mRemappedCharacteristicDescriptorMap.entrySet()) {
                                                    if (REGISTERED_USER_CHARACTERISTIC.equals(a.getKey().first)) {
                                                        for (Map.Entry<Pair<UUID, Integer>, DescriptorData> b : a.getValue().entrySet()) {
                                                            if (CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR.equals(b.getKey().first)) {
                                                                registeredUserClientCharacteristicConfigurationInstanceId = b.getKey().second;
                                                                if (Arrays.equals(BluetoothGattDescriptor.ENABLE_INDICATION_VALUE, b.getValue().getBytes())) {
                                                                    responseCode = BluetoothGatt.GATT_SUCCESS;
                                                                }
                                                                break;
                                                            }
                                                        }
                                                    }
                                                }

                                                if (BluetoothGatt.GATT_SUCCESS == responseCode) {
                                                    CharacteristicData registeredUserData = null;
                                                    int registeredUserInstanceId = 0;
                                                    UDSCharacteristicData firstNameData = null;
                                                    UDSCharacteristicData lastNameData = null;

                                                    for (Map.Entry<Pair<UUID, Integer>, Map<Pair<UUID, Integer>, CharacteristicData>> serviceEntry : mRemappedServiceCharacteristicMap.entrySet()) {
                                                        Pair<UUID, Integer> serviceKey = serviceEntry.getKey();
                                                        if (USER_DATA_SERVICE.equals(serviceKey.first)) {
                                                            for (Map.Entry<Pair<UUID, Integer>, CharacteristicData> characteristicEntry : serviceEntry.getValue().entrySet()) {
                                                                Pair<UUID, Integer> characteristicKey = characteristicEntry.getKey();
                                                                if (REGISTERED_USER_CHARACTERISTIC.equals(characteristicKey.first)) {
                                                                    registeredUserData = characteristicEntry.getValue();
                                                                    registeredUserInstanceId = characteristicKey.second;
                                                                } else if (FIRST_NAME_CHARACTERISTIC.equals(characteristicKey.first)) {
                                                                    firstNameData = (UDSCharacteristicData) characteristicEntry.getValue();
                                                                } else if (LAST_NAME_CHARACTERISTIC.equals(characteristicKey.first)) {
                                                                    lastNameData = (UDSCharacteristicData) characteristicEntry.getValue();
                                                                }
                                                            }
                                                            break;
                                                        }
                                                    }

                                                    if (registeredUserData == null) {
                                                        responseCode = APPLICATION_ERROR_9F;
                                                    } else {
                                                        mRegisteredUserIndicationData = new RegisteredUserIndicationData(requestId
                                                                , offset
                                                                , new UserControlPoint(UserControlPoint.OP_CODE_RESPONSE_CODE, 0, 0, UserControlPoint.OP_CODE_LIST_ALL_USERS, UserControlPoint.RESPONSE_VALUE_SUCCESS, mUserMap.size()).getBytes()
                                                                , now + LIST_ALL_USERS_INDICATION_TIMEOUT
                                                                , mUserMap.size() * mConnectedDeviceMap.size());

                                                        StringBuilder registeredUserName = new StringBuilder();
                                                        for (int userIndex : mUserMap.keySet()) {
                                                            registeredUserName.setLength(0);
                                                            if (firstNameData != null) {
                                                                CharacteristicData userFirstNameData = firstNameData.getUserData(userIndex);
                                                                if (userFirstNameData != null) {
                                                                    registeredUserName.append(new FirstName(new RegisteredUser(userFirstNameData.getBytes())).getFirstName());
                                                                }
                                                            }
                                                            if (lastNameData != null) {
                                                                if (registeredUserName.length() != 0) {
                                                                    registeredUserName.append(' ');
                                                                }
                                                                CharacteristicData userLastNameData = lastNameData.getUserData(userIndex);
                                                                if (userLastNameData != null) {
                                                                    registeredUserName.append(new FirstName(new RegisteredUser(userLastNameData.getBytes())).getFirstName());
                                                                }
                                                            }
                                                            byte[] nameData = registeredUserName.toString().getBytes();
                                                            if (nameData.length == 0) {
                                                                registeredUserData.currentData = new RegisteredUser(RegisteredUser.SEGMENTATION_HEADER_FIRST_SEGMENT_TRUE | RegisteredUser.SEGMENTATION_HEADER_LAST_SEGMENT_TRUE
                                                                        , RegisteredUser.FLAGS_REGISTERED_USER_NAME_PRESENT_FALSE | RegisteredUser.FLAGS_USER_NAME_TRUNCATED_FALSE
                                                                        , userIndex
                                                                        , new byte[0]).getBytes();
                                                            } else if (nameData.length < 27) {
                                                                registeredUserData.currentData = new RegisteredUser(RegisteredUser.SEGMENTATION_HEADER_FIRST_SEGMENT_TRUE | RegisteredUser.SEGMENTATION_HEADER_LAST_SEGMENT_TRUE
                                                                        , RegisteredUser.FLAGS_REGISTERED_USER_NAME_PRESENT_TRUE | RegisteredUser.FLAGS_USER_NAME_TRUNCATED_FALSE
                                                                        , userIndex
                                                                        , nameData).getBytes();
                                                            } else {
                                                                // truncate user name
                                                                // no multi message implementation

                                                                registeredUserData.currentData = new RegisteredUser(RegisteredUser.SEGMENTATION_HEADER_FIRST_SEGMENT_TRUE | RegisteredUser.SEGMENTATION_HEADER_LAST_SEGMENT_TRUE
                                                                        , RegisteredUser.FLAGS_REGISTERED_USER_NAME_PRESENT_TRUE | RegisteredUser.FLAGS_USER_NAME_TRUNCATED_TRUE
                                                                        , userIndex
                                                                        , Arrays.copyOfRange(nameData, 0, 27)).getBytes();
                                                            }
                                                            Bundle bundle = new Bundle();
                                                            bundle.putInt(KEY_REQUEST_ID, requestId);
                                                            for (BluetoothDevice connectedDevice : mConnectedDeviceMap.keySet()) {
                                                                startNotification(null
                                                                        , bleServerConnection
                                                                        , connectedDevice
                                                                        , USER_DATA_SERVICE
                                                                        , serviceInstanceId
                                                                        , REGISTERED_USER_CHARACTERISTIC
                                                                        , registeredUserInstanceId
                                                                        , registeredUserClientCharacteristicConfigurationInstanceId
                                                                        , registeredUserData.delay
                                                                        , 1
                                                                        , bundle);
                                                            }
                                                        }
                                                    }
                                                }

                                                userControlPointCharacteristicData.currentData = mRegisteredUserIndicationData.returnValue;
                                            } else {
                                                userControlPointCharacteristicData.currentData = new UserControlPoint(UserControlPoint.OP_CODE_RESPONSE_CODE, 0, 0, UserControlPoint.OP_CODE_LIST_ALL_USERS, userControlPointCharacteristicData.listAllUsersResponseValue, 0).getBytes();

                                                responseCode = BluetoothGatt.GATT_SUCCESS;
                                            }
                                        } else {
                                            responseCode = PROCEDURE_ALREADY_IN_PROGRESS;
                                        }

                                    } else if (userControlPoint.isOpCodeDeleteUsers(userControlPoint.getOpCode())) {
                                        if (userControlPoint.isResponseValueSuccess(userControlPointCharacteristicData.deleteUsersResponseValue)) {
                                            int userIndex = userControlPoint.getUserIndex();
                                            deleteUsers(userIndex);
                                            userControlPointCharacteristicData.currentData = new UserControlPoint(UserControlPoint.OP_CODE_RESPONSE_CODE, userIndex, 0, UserControlPoint.OP_CODE_DELETE_USERS, UserControlPoint.RESPONSE_VALUE_SUCCESS, 0).getBytes();
                                        } else {
                                            userControlPointCharacteristicData.currentData = new UserControlPoint(UserControlPoint.OP_CODE_RESPONSE_CODE, 0, 0, UserControlPoint.OP_CODE_DELETE_USERS, userControlPointCharacteristicData.deleteUsersResponseValue, 0).getBytes();
                                        }

                                        responseCode = BluetoothGatt.GATT_SUCCESS;
                                    }

                                    for (BluetoothDevice connectedDevice : mConnectedDeviceMap.keySet()) {
                                        startNotification(null
                                                , bleServerConnection
                                                , connectedDevice
                                                , USER_DATA_SERVICE
                                                , serviceInstanceId
                                                , USER_CONTROL_POINT_CHARACTERISTIC
                                                , characteristicInstanceId
                                                , key.second
                                                , characteristicData.delay
                                                , 1
                                                , null);
                                    }
                                }
                                break;
                            }
                        }
                    }

                    result = bluetoothGattServer.sendResponse(device, requestId, responseCode, offset, preparedWrite ? value : null);
                }
            }
            if (force && !result) {
                result = bluetoothGattServer.sendResponse(device, requestId, APPLICATION_ERROR_9F, offset, null);
            }
        }
        return result;
    }

    /**
     * @param device                      {@link #onCharacteristicWriteRequest(BLEServerConnection, BluetoothDevice, int, BluetoothGattCharacteristic, boolean, boolean, int, byte[], boolean)} 2nd parameter
     * @param requestId                   {@link #onCharacteristicWriteRequest(BLEServerConnection, BluetoothDevice, int, BluetoothGattCharacteristic, boolean, boolean, int, byte[], boolean)} 3rd parameter
     * @param bluetoothGattCharacteristic {@link #onCharacteristicWriteRequest(BLEServerConnection, BluetoothDevice, int, BluetoothGattCharacteristic, boolean, boolean, int, byte[], boolean)} 4th parameter
     * @param preparedWrite               {@link #onCharacteristicWriteRequest(BLEServerConnection, BluetoothDevice, int, BluetoothGattCharacteristic, boolean, boolean, int, byte[], boolean)} 5th parameter
     * @param offset                      {@link #onCharacteristicWriteRequest(BLEServerConnection, BluetoothDevice, int, BluetoothGattCharacteristic, boolean, boolean, int, byte[], boolean)} 7th parameter
     * @param value                       {@link #onCharacteristicWriteRequest(BLEServerConnection, BluetoothDevice, int, BluetoothGattCharacteristic, boolean, boolean, int, byte[], boolean)} 8th parameter
     * @param force                       {@link #onCharacteristicWriteRequest(BLEServerConnection, BluetoothDevice, int, BluetoothGattCharacteristic, boolean, boolean, int, byte[], boolean)} 9th parameter
     * @param bluetoothGattServer         {@link BluetoothGattServer} instance
     * @return {@code true}:handled, {@code false}:not handled
     */
    @SuppressLint("MissingPermission")
    protected boolean onUserDataWriteRequest(@NonNull BluetoothDevice device
            , int requestId
            , @NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic
            , boolean preparedWrite
            , int offset
            , @NonNull byte[] value
            , boolean force
            , @NonNull BluetoothGattServer bluetoothGattServer) {
        boolean result = false;

        long now = SystemClock.elapsedRealtime();
        BluetoothGattService bluetoothGattService = bluetoothGattCharacteristic.getService();
        UUID serviceUUID = bluetoothGattService.getUuid();
        int serviceInstanceId = bluetoothGattService.getInstanceId();
        Map<Pair<UUID, Integer>, CharacteristicData> characteristicMap = mRemappedServiceCharacteristicMap.get(Pair.create(serviceUUID, serviceInstanceId));
        if (characteristicMap == null) {
            if (force) {
                result = bluetoothGattServer.sendResponse(device, requestId, APPLICATION_ERROR_9F, offset, null);
            }
        } else {
            int characteristicInstanceId = bluetoothGattCharacteristic.getInstanceId();
            UDSCharacteristicData udsCharacteristicData = (UDSCharacteristicData) characteristicMap.get(Pair.create(bluetoothGattCharacteristic.getUuid(), characteristicInstanceId));
            if (udsCharacteristicData != null) {
                delay(now, udsCharacteristicData.delay);

                Integer currentUserIndex = mCurrentUserMap.get(device);
                int responseCode;
                if (currentUserIndex == null) {
                    responseCode = APPLICATION_ERROR_80;
                } else {
                    responseCode = udsCharacteristicData.responseCode;
                }
                result = bluetoothGattServer.sendResponse(device, requestId, responseCode, offset, preparedWrite ? value : null);

                if (result && BluetoothGatt.GATT_SUCCESS == responseCode) {
                    CharacteristicData characteristicData = udsCharacteristicData.getUserData(currentUserIndex);
                    if (characteristicData != null) {
                        characteristicData.currentData = value;
                        udsCharacteristicData.setUserData(currentUserIndex, characteristicData);
                    }
                }
            }
            if (force && !result) {
                result = bluetoothGattServer.sendResponse(device, requestId, APPLICATION_ERROR_9F, offset, null);
            }
        }
        return result;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized boolean onCharacteristicWriteRequest(@NonNull BLEServerConnection bleServerConnection
            , @NonNull BluetoothDevice device
            , int requestId
            , @NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic
            , boolean preparedWrite
            , boolean responseNeeded
            , int offset
            , @NonNull byte[] value
            , boolean force) {
        boolean result = false;
        BluetoothGattServer bluetoothGattServer = bleServerConnection.getBluetoothGattServer();

        if (bluetoothGattServer != null) {
            UUID characteristicUUID = bluetoothGattCharacteristic.getUuid();
            if (DATABASE_CHANGE_INCREMENT_CHARACTERISTIC.equals(characteristicUUID)) {
                result = onDatabaseChangeIncrementWriteRequest(bleServerConnection, device, requestId, bluetoothGattCharacteristic, offset, preparedWrite, value, force, bluetoothGattServer);
            } else if (USER_CONTROL_POINT_CHARACTERISTIC.equals(characteristicUUID)) {
                result = onUserControlPointWriteRequest(bleServerConnection, device, requestId, bluetoothGattCharacteristic, preparedWrite, offset, value, force, bluetoothGattServer);
            } else if (UDS_CHARACTERISTIC_SET.contains(characteristicUUID)) {
                result = onUserDataWriteRequest(device, requestId, bluetoothGattCharacteristic, preparedWrite, offset, value, force, bluetoothGattServer);
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
    @SuppressLint("MissingPermission")
    @Override
    public synchronized void onNotificationSuccess(@NonNull Integer taskId
            , @NonNull BLEServerConnection bleServerConnection
            , @NonNull BluetoothDevice device
            , @NonNull UUID serviceUUID
            , int serviceInstanceId
            , @NonNull UUID characteristicUUID
            , int characteristicInstanceId
            , @NonNull byte[] value
            , @Nullable Bundle argument) {
        if (USER_DATA_SERVICE.equals(serviceUUID) && REGISTERED_USER_CHARACTERISTIC.equals(characteristicUUID) && argument != null && mRegisteredUserIndicationData != null) {
            BluetoothGattServer bluetoothGattServer = bleServerConnection.getBluetoothGattServer();
            if (bluetoothGattServer != null) {
                if (mRegisteredUserIndicationData.timeout < SystemClock.elapsedRealtime()) {
                    bluetoothGattServer.sendResponse(null, mRegisteredUserIndicationData.requestId, CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR_IMPROPERLY_CONFIGURED, mRegisteredUserIndicationData.offset, null);
                    mRegisteredUserIndicationData = null;
                } else {
                    Bundle originalArgument = argument.getBundle(KEY_ORIGINAL_ARGUMENT);
                    if (originalArgument != null) {
                        int requestId = originalArgument.getInt(KEY_REQUEST_ID);
                        if (mRegisteredUserIndicationData.requestId == requestId) {
                            mRegisteredUserIndicationData.indicatedCount++;
                        }
                        if (mRegisteredUserIndicationData.count == mRegisteredUserIndicationData.indicatedCount) {
                            bluetoothGattServer.sendResponse(null, requestId, BluetoothGatt.GATT_SUCCESS, mRegisteredUserIndicationData.offset, mRegisteredUserIndicationData.returnValue);
                            mRegisteredUserIndicationData = null;
                        }
                    }
                }
            }
        } else {
            super.onNotificationSuccess(taskId, bleServerConnection, device, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, value, argument);
        }
    }

    /**
     * {@inheritDoc}
     */
    @SuppressLint("MissingPermission")
    @Override
    public synchronized void onNotificationFailed(@NonNull Integer taskId
            , @NonNull BLEServerConnection bleServerConnection
            , @NonNull BluetoothDevice device
            , @NonNull UUID serviceUUID
            , int serviceInstanceId
            , @NonNull UUID characteristicUUID
            , int characteristicInstanceId
            , int status
            , @Nullable Bundle argument) {
        if (USER_DATA_SERVICE.equals(serviceUUID) && REGISTERED_USER_CHARACTERISTIC.equals(characteristicUUID) && argument != null && mRegisteredUserIndicationData != null) {
            BluetoothGattServer bluetoothGattServer = bleServerConnection.getBluetoothGattServer();
            if (bluetoothGattServer != null) {
                if (mRegisteredUserIndicationData.timeout < SystemClock.elapsedRealtime()) {
                    bluetoothGattServer.sendResponse(null, mRegisteredUserIndicationData.requestId, CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR_IMPROPERLY_CONFIGURED, mRegisteredUserIndicationData.offset, null);
                    mRegisteredUserIndicationData = null;
                } else {
                    Bundle originalArgument = argument.getBundle(KEY_ORIGINAL_ARGUMENT);
                    if (originalArgument != null) {
                        int requestId = originalArgument.getInt(KEY_REQUEST_ID);
                        if (mRegisteredUserIndicationData.requestId == requestId) {
                            mRegisteredUserIndicationData.indicatedCount++;
                        }
                        if (mRegisteredUserIndicationData.count == mRegisteredUserIndicationData.indicatedCount) {
                            bluetoothGattServer.sendResponse(null, requestId, BluetoothGatt.GATT_SUCCESS, mRegisteredUserIndicationData.offset, mRegisteredUserIndicationData.returnValue);
                            mRegisteredUserIndicationData = null;
                        }
                    }
                }
            }
        } else {
            super.onNotificationFailed(taskId, bleServerConnection, device, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, status, argument);
        }
    }

    /**
     * {@inheritDoc}
     */
    @SuppressLint("MissingPermission")
    @Override
    public synchronized void onNotificationTimeout(@NonNull Integer taskId
            , @NonNull BLEServerConnection bleServerConnection
            , @NonNull BluetoothDevice device
            , @NonNull UUID serviceUUID
            , int serviceInstanceId
            , @NonNull UUID characteristicUUID
            , int characteristicInstanceId
            , long timeout
            , @Nullable Bundle argument) {
        if (USER_DATA_SERVICE.equals(serviceUUID) && REGISTERED_USER_CHARACTERISTIC.equals(characteristicUUID) && argument != null && mRegisteredUserIndicationData != null) {
            BluetoothGattServer bluetoothGattServer = bleServerConnection.getBluetoothGattServer();
            if (bluetoothGattServer != null) {
                if (mRegisteredUserIndicationData.timeout < SystemClock.elapsedRealtime()) {
                    bluetoothGattServer.sendResponse(null, mRegisteredUserIndicationData.requestId, CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR_IMPROPERLY_CONFIGURED, mRegisteredUserIndicationData.offset, null);
                    mRegisteredUserIndicationData = null;
                } else {
                    Bundle originalArgument = argument.getBundle(KEY_ORIGINAL_ARGUMENT);
                    if (originalArgument != null) {
                        int requestId = originalArgument.getInt(KEY_REQUEST_ID);
                        if (mRegisteredUserIndicationData.requestId == requestId) {
                            mRegisteredUserIndicationData.indicatedCount++;
                        }
                        if (mRegisteredUserIndicationData.count == mRegisteredUserIndicationData.indicatedCount) {
                            bluetoothGattServer.sendResponse(null, requestId, BluetoothGatt.GATT_SUCCESS, mRegisteredUserIndicationData.offset, mRegisteredUserIndicationData.returnValue);
                            mRegisteredUserIndicationData = null;
                        }
                    }
                }
            }
        } else {
            super.onNotificationTimeout(taskId, bleServerConnection, device, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, timeout, argument);
        }
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

    /**
     * check consent status
     *
     * @param device    target device
     * @param userIndex target user index
     * @return {@code true}:no consent, {@code false}:has consent
     */
    public boolean hasNoConsent(@NonNull BluetoothDevice device, @Nullable Integer userIndex) {
        boolean result;
        if (userIndex == null) {
            result = true;
        } else {
            result = !userIndex.equals(mCurrentUserMap.get(device));
        }
        return result;
    }

}
