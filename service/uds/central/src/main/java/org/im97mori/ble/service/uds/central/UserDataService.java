package org.im97mori.ble.service.uds.central;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.im97mori.ble.BLECallback;
import org.im97mori.ble.BLEConnection;
import org.im97mori.ble.characteristic.u2a7e.AerobicHeartRateLowerLimit;
import org.im97mori.ble.characteristic.u2a7e.AerobicHeartRateLowerLimitAndroid;
import org.im97mori.ble.characteristic.u2a7f.AerobicThreshold;
import org.im97mori.ble.characteristic.u2a7f.AerobicThresholdAndroid;
import org.im97mori.ble.characteristic.u2a80.Age;
import org.im97mori.ble.characteristic.u2a80.AgeAndroid;
import org.im97mori.ble.characteristic.u2a81.AnaerobicHeartRateLowerLimit;
import org.im97mori.ble.characteristic.u2a81.AnaerobicHeartRateLowerLimitAndroid;
import org.im97mori.ble.characteristic.u2a82.AnaerobicHeartRateUpperLimit;
import org.im97mori.ble.characteristic.u2a82.AnaerobicHeartRateUpperLimitAndroid;
import org.im97mori.ble.characteristic.u2a83.AnaerobicThreshold;
import org.im97mori.ble.characteristic.u2a83.AnaerobicThresholdAndroid;
import org.im97mori.ble.characteristic.u2a84.AerobicHeartRateUpperLimit;
import org.im97mori.ble.characteristic.u2a84.AerobicHeartRateUpperLimitAndroid;
import org.im97mori.ble.characteristic.u2a85.DateOfBirth;
import org.im97mori.ble.characteristic.u2a85.DateOfBirthAndroid;
import org.im97mori.ble.characteristic.u2a86.DateOfThresholdAssessment;
import org.im97mori.ble.characteristic.u2a86.DateOfThresholdAssessmentAndroid;
import org.im97mori.ble.characteristic.u2a87.EmailAddress;
import org.im97mori.ble.characteristic.u2a87.EmailAddressAndroid;
import org.im97mori.ble.characteristic.u2a88.FatBurnHeartRateLowerLimit;
import org.im97mori.ble.characteristic.u2a88.FatBurnHeartRateLowerLimitAndroid;
import org.im97mori.ble.characteristic.u2a89.FatBurnHeartRateUpperLimit;
import org.im97mori.ble.characteristic.u2a89.FatBurnHeartRateUpperLimitAndroid;
import org.im97mori.ble.characteristic.u2a8a.FirstName;
import org.im97mori.ble.characteristic.u2a8a.FirstNameAndroid;
import org.im97mori.ble.characteristic.u2a8b.FiveZoneHeartRateLimits;
import org.im97mori.ble.characteristic.u2a8b.FiveZoneHeartRateLimitsAndroid;
import org.im97mori.ble.characteristic.u2a8c.Gender;
import org.im97mori.ble.characteristic.u2a8c.GenderAndroid;
import org.im97mori.ble.characteristic.u2a8d.HeartRateMax;
import org.im97mori.ble.characteristic.u2a8d.HeartRateMaxAndroid;
import org.im97mori.ble.characteristic.u2a8e.Height;
import org.im97mori.ble.characteristic.u2a8e.HeightAndroid;
import org.im97mori.ble.characteristic.u2a8f.HipCircumference;
import org.im97mori.ble.characteristic.u2a8f.HipCircumferenceAndroid;
import org.im97mori.ble.characteristic.u2a90.LastName;
import org.im97mori.ble.characteristic.u2a90.LastNameAndroid;
import org.im97mori.ble.characteristic.u2a91.MaximumRecommendedHeartRate;
import org.im97mori.ble.characteristic.u2a91.MaximumRecommendedHeartRateAndroid;
import org.im97mori.ble.characteristic.u2a92.RestingHeartRate;
import org.im97mori.ble.characteristic.u2a92.RestingHeartRateAndroid;
import org.im97mori.ble.characteristic.u2a93.SportTypeForAerobicAndAnaerobicThresholds;
import org.im97mori.ble.characteristic.u2a93.SportTypeForAerobicAndAnaerobicThresholdsAndroid;
import org.im97mori.ble.characteristic.u2a94.ThreeZoneHeartRateLimits;
import org.im97mori.ble.characteristic.u2a94.ThreeZoneHeartRateLimitsAndroid;
import org.im97mori.ble.characteristic.u2a95.TwoZoneHeartRateLimit;
import org.im97mori.ble.characteristic.u2a95.TwoZoneHeartRateLimitAndroid;
import org.im97mori.ble.characteristic.u2a96.VO2Max;
import org.im97mori.ble.characteristic.u2a96.VO2MaxAndroid;
import org.im97mori.ble.characteristic.u2a97.WaistCircumference;
import org.im97mori.ble.characteristic.u2a97.WaistCircumferenceAndroid;
import org.im97mori.ble.characteristic.u2a98.Weight;
import org.im97mori.ble.characteristic.u2a98.WeightAndroid;
import org.im97mori.ble.characteristic.u2a99.DatabaseChangeIncrement;
import org.im97mori.ble.characteristic.u2a99.DatabaseChangeIncrementAndroid;
import org.im97mori.ble.characteristic.u2a9a.UserIndexAndroid;
import org.im97mori.ble.characteristic.u2a9f.UserControlPoint;
import org.im97mori.ble.characteristic.u2a9f.UserControlPointAndroid;
import org.im97mori.ble.characteristic.u2aa2.Language;
import org.im97mori.ble.characteristic.u2aa2.LanguageAndroid;
import org.im97mori.ble.characteristic.u2b37.RegisteredUserAndroid;
import org.im97mori.ble.descriptor.u2902.ClientCharacteristicConfiguration;
import org.im97mori.ble.descriptor.u2902.ClientCharacteristicConfigurationAndroid;
import org.im97mori.ble.service.central.AbstractCentralService;
import org.im97mori.ble.task.ReadCharacteristicTask;
import org.im97mori.ble.task.ReadDescriptorTask;
import org.im97mori.ble.task.WriteCharacteristicTask;
import org.im97mori.ble.task.WriteDescriptorTask;

import java.util.List;
import java.util.UUID;

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.AEROBIC_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.CharacteristicUUID.AEROBIC_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.CharacteristicUUID.AEROBIC_THRESHOLD_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.CharacteristicUUID.AGE_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.CharacteristicUUID.ANAEROBIC_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.CharacteristicUUID.ANAEROBIC_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.CharacteristicUUID.ANAEROBIC_THRESHOLD_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.CharacteristicUUID.DATABASE_CHANGE_INCREMENT_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.CharacteristicUUID.DATE_OF_BIRTH_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.CharacteristicUUID.DATE_OF_THRESHOLD_ASSESSMENT_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.CharacteristicUUID.EMAIL_ADDRESS_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.CharacteristicUUID.FAT_BURN_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.CharacteristicUUID.FAT_BURN_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.CharacteristicUUID.FIRST_NAME_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.CharacteristicUUID.FIVE_ZONE_HEART_RATE_LIMITS_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.CharacteristicUUID.GENDER_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.CharacteristicUUID.HEART_RATE_MAX_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.CharacteristicUUID.HEIGHT_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.CharacteristicUUID.HIP_CIRCUMFERENCE_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.CharacteristicUUID.LANGUAGE_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.CharacteristicUUID.LAST_NAME_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.CharacteristicUUID.MAXIMUM_RECOMMENDED_HEART_RATE_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.CharacteristicUUID.REGISTERED_USER_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.CharacteristicUUID.RESTING_HEART_RATE_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.CharacteristicUUID.SPORT_TYPE_FOR_AEROBIC_AND_ANAEROBIC_THRESHOLDS_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.CharacteristicUUID.THREE_ZONE_HEART_RATE_LIMITS_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.CharacteristicUUID.TWO_ZONE_HEART_RATE_LIMIT_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.CharacteristicUUID.USER_CONTROL_POINT_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.CharacteristicUUID.USER_INDEX_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.CharacteristicUUID.VO2_MAX_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.CharacteristicUUID.WAIST_CIRCUMFERENCE_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.CharacteristicUUID.WEIGHT_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.DescriptorUUID.CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
import static org.im97mori.ble.BLEConstants.ServiceUUID.USER_DATA_SERVICE;

/**
 * User Data Service (Service UUID: 0x181C) for Central
 */
public class UserDataService extends AbstractCentralService {

    /**
     * {@link UserDataServiceCallback} instance
     */
    private final UserDataServiceCallback mUserDataServiceCallback;

    /**
     * First Name characteristic flag
     * {@code true}:First Name characteristic is exist, {@code false}:First Name characteristic is not exist or service not ready
     */
    private boolean mIsFirstNameCharacteristicSupported;

    /**
     * Last Name characteristic flag
     * {@code true}:Last Name characteristic is exist, {@code false}:Last Name characteristic is not exist or service not ready
     */
    private boolean mIsLastNameCharacteristicSupported;

    /**
     * Email Address characteristic flag
     * {@code true}:Email Address characteristic is exist, {@code false}:Email Address characteristic is not exist or service not ready
     */
    private boolean mIsEmailAddressCharacteristicSupported;

    /**
     * Age characteristic flag
     * {@code true}:Age characteristic is exist, {@code false}:Age characteristic is not exist or service not ready
     */
    private boolean mIsAgeCharacteristicSupported;

    /**
     * Date of Birth characteristic flag
     * {@code true}:Date of Birth characteristic is exist, {@code false}:Date of Birth characteristic is not exist or service not ready
     */
    private boolean mIsDateOfBirthCharacteristicSupported;

    /**
     * Gender characteristic flag
     * {@code true}:Gender characteristic is exist, {@code false}:Gender characteristic is not exist or service not ready
     */
    private boolean mIsGenderCharacteristicSupported;

    /**
     * Weight characteristic flag
     * {@code true}:Weight characteristic is exist, {@code false}:Weight characteristic is not exist or service not ready
     */
    private boolean mIsWeightCharacteristicSupported;

    /**
     * Height characteristic flag
     * {@code true}:Height characteristic is exist, {@code false}:Height characteristic is not exist or service not ready
     */
    private boolean mIsHeightCharacteristicSupported;

    /**
     * VO2 Max characteristic flag
     * {@code true}:VO2 Max characteristic is exist, {@code false}:VO2 Max characteristic is not exist or service not ready
     */
    private boolean mIsVO2MaxCharacteristicSupported;

    /**
     * Heart Rate Max characteristic flag
     * {@code true}:Heart Rate Max characteristic is exist, {@code false}:Heart Rate Max characteristic is not exist or service not ready
     */
    private boolean mIsHeartRateMaxCharacteristicSupported;

    /**
     * Resting Heart Rate characteristic flag
     * {@code true}:Resting Heart Rate characteristic is exist, {@code false}:Resting Heart Rate characteristic is not exist or service not ready
     */
    private boolean mIsRestingHeartRateCharacteristicSupported;

    /**
     * Maximum Recommended Heart Rate characteristic flag
     * {@code true}:Maximum Recommended Heart Rate characteristic is exist, {@code false}:Maximum Recommended Heart Rate characteristic is not exist or service not ready
     */
    private boolean mIsMaximumRecommendedHeartRateCharacteristicSupported;

    /**
     * Aerobic Threshold characteristic flag
     * {@code true}:Aerobic Threshold characteristic is exist, {@code false}:Aerobic Threshold characteristic is not exist or service not ready
     */
    private boolean mIsAerobicThresholdCharacteristicSupported;

    /**
     * Anaerobic Threshold characteristic flag
     * {@code true}:Anaerobic Threshold characteristic is exist, {@code false}:Anaerobic Threshold characteristic is not exist or service not ready
     */
    private boolean mIsAnaerobicThresholdCharacteristicSupported;

    /**
     * Sport Type for Aerobic and Anaerobic Thresholds characteristic flag
     * {@code true}:Sport Type for Aerobic and Anaerobic Thresholds characteristic is exist, {@code false}:Sport Type for Aerobic and Anaerobic Thresholds characteristic is not exist or service not ready
     */
    private boolean mIsSportTypeForAerobicAndAnaerobicThresholdsCharacteristicSupported;

    /**
     * Date of Threshold Assessment characteristic flag
     * {@code true}:Date of Threshold Assessment characteristic is exist, {@code false}:Date of Threshold Assessment characteristic is not exist or service not ready
     */
    private boolean mIsDateOfThresholdAssessmentCharacteristicSupported;

    /**
     * Waist Circumference characteristic flag
     * {@code true}:Waist Circumference characteristic is exist, {@code false}:Waist Circumference Assessment characteristic is not exist or service not ready
     */
    private boolean mIsWaistCircumferenceCharacteristicSupported;

    /**
     * Hip Circumference characteristic flag
     * {@code true}:Hip Circumference characteristic is exist, {@code false}:Hip Circumference Assessment characteristic is not exist or service not ready
     */
    private boolean mIsHipCircumferenceCharacteristicSupported;

    /**
     * Fat Burn Heart Rate Lower Limit characteristic flag
     * {@code true}:Fat Burn Heart Rate Lower Limit characteristic is exist, {@code false}:Fat Burn Heart Rate Lower Limit characteristic is not exist or service not ready
     */
    private boolean mIsFatBurnHeartRateLowerLimitCharacteristicSupported;

    /**
     * Fat Burn Heart Rate Upper Limit characteristic flag
     * {@code true}:Fat Burn Heart Rate Upper Limit characteristic is exist, {@code false}:Fat Burn Heart Rate Upper Limit characteristic is not exist or service not ready
     */
    private boolean mIsFatBurnHeartRateUpperLimitCharacteristicSupported;

    /**
     * Aerobic Heart Rate Lower Limit characteristic flag
     * {@code true}:Aerobic Heart Rate Lower Limit characteristic is exist, {@code false}:Aerobic Heart Rate Lower Limit characteristic is not exist or service not ready
     */
    private boolean mIsAerobicHeartRateLowerLimitCharacteristicSupported;

    /**
     * Aerobic Heart Rate Upper Limit characteristic flag
     * {@code true}:Aerobic Heart Rate Upper Limit characteristic is exist, {@code false}:Aerobic Heart Rate Upper Limit characteristic is not exist or service not ready
     */
    private boolean mIsAerobicHeartRateUpperLimitCharacteristicSupported;

    /**
     * Anaerobic Heart Rate Lower Limit characteristic flag
     * {@code true}:Anaerobic Heart Rate Lower Limit characteristic is exist, {@code false}:Anaerobic Heart Rate Lower Limit characteristic is not exist or service not ready
     */
    private boolean mIsAnaerobicHeartRateLowerLimitCharacteristicSupported;

    /**
     * Anaerobic Heart Rate Upper Limit characteristic flag
     * {@code true}:Anaerobic Heart Rate Upper Limit characteristic is exist, {@code false}:Anaerobic Heart Rate Upper Limit characteristic is not exist or service not ready
     */
    private boolean mIsAnaerobicHeartRateUpperLimitCharacteristicSupported;

    /**
     * Five Zone Heart Rate Limits characteristic flag
     * {@code true}:Five Zone Heart Rate Limits characteristic is exist, {@code false}:Five Zone Heart Rate Limits characteristic is not exist or service not ready
     */
    private boolean mIsFiveZoneHeartRateLimitsCharacteristicSupported;

    /**
     * Three Zone Heart Rate Limits characteristic flag
     * {@code true}:Three Zone Heart Rate Limits characteristic is exist, {@code false}:Three Zone Heart Rate Limits characteristic is not exist or service not ready
     */
    private boolean mIsThreeZoneHeartRateLimitsCharacteristicSupported;

    /**
     * Two Zone Heart Rate Limit characteristic flag
     * {@code true}:Two Zone Heart Rate Limit characteristic is exist, {@code false}:Two Zone Heart Rate Limit characteristic is not exist or service not ready
     */
    private boolean mIsTwoZoneHeartRateLimitCharacteristicSupported;

    /**
     * Language Limit characteristic flag
     * {@code true}:Language characteristic is exist, {@code false}:Language characteristic is not exist or service not ready
     */
    private boolean mIsLanguageCharacteristicSupported;

    /**
     * Database Change Increment characteristic notificatable flag
     * {@code true}:Database Change Increment characteristic is notificatable, {@code false}:Database Change Increment characteristic is not notificatable or service not ready
     */
    private boolean mIsDatabaseChangeIncrementCharacteristicNotifySupported;

    /**
     * @param bleConnection           {@link BLEConnection} instance
     * @param userDataServiceCallback {@link UserDataServiceCallback} instance
     * @param bleCallback             {@link BLECallback} instance(optional)
     */
    public UserDataService(@NonNull BLEConnection bleConnection, @NonNull UserDataServiceCallback userDataServiceCallback, @Nullable BLECallback bleCallback) {
        super(bleConnection, bleCallback);
        mUserDataServiceCallback = userDataServiceCallback;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onBLEDisconnected(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, int status, @Nullable Bundle argument) {
        if (mBLEConnection.getBluetoothDevice().equals(bluetoothDevice)) {
            mIsFirstNameCharacteristicSupported = false;
            mIsLastNameCharacteristicSupported = false;
            mIsEmailAddressCharacteristicSupported = false;
            mIsAgeCharacteristicSupported = false;
            mIsDateOfBirthCharacteristicSupported = false;
            mIsGenderCharacteristicSupported = false;
            mIsWeightCharacteristicSupported = false;
            mIsHeightCharacteristicSupported = false;
            mIsVO2MaxCharacteristicSupported = false;
            mIsHeartRateMaxCharacteristicSupported = false;
            mIsRestingHeartRateCharacteristicSupported = false;
            mIsMaximumRecommendedHeartRateCharacteristicSupported = false;
            mIsAerobicThresholdCharacteristicSupported = false;
            mIsAnaerobicThresholdCharacteristicSupported = false;
            mIsSportTypeForAerobicAndAnaerobicThresholdsCharacteristicSupported = false;
            mIsDateOfThresholdAssessmentCharacteristicSupported = false;
            mIsWaistCircumferenceCharacteristicSupported = false;
            mIsHipCircumferenceCharacteristicSupported = false;
            mIsFatBurnHeartRateLowerLimitCharacteristicSupported = false;
            mIsFatBurnHeartRateUpperLimitCharacteristicSupported = false;
            mIsAerobicHeartRateLowerLimitCharacteristicSupported = false;
            mIsAerobicHeartRateUpperLimitCharacteristicSupported = false;
            mIsAnaerobicHeartRateLowerLimitCharacteristicSupported = false;
            mIsAnaerobicHeartRateUpperLimitCharacteristicSupported = false;
            mIsFiveZoneHeartRateLimitsCharacteristicSupported = false;
            mIsThreeZoneHeartRateLimitsCharacteristicSupported = false;
            mIsTwoZoneHeartRateLimitCharacteristicSupported = false;
            mIsLanguageCharacteristicSupported = false;
            mIsDatabaseChangeIncrementCharacteristicNotifySupported = false;
        }
        super.onBLEDisconnected(taskId, bluetoothDevice, status, argument);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onDiscoverServiceSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull List<BluetoothGattService> serviceList, @Nullable Bundle argument) {
        if (mBLEConnection.getBluetoothDevice().equals(bluetoothDevice)) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic;
            for (BluetoothGattService bluetoothGattService : serviceList) {
                if (USER_DATA_SERVICE.equals(bluetoothGattService.getUuid())) {
                    bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(FIRST_NAME_CHARACTERISTIC);
                    if (bluetoothGattCharacteristic != null && ((BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE) == bluetoothGattCharacteristic.getProperties())) {
                        mIsFirstNameCharacteristicSupported = true;
                    }
                    bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(LAST_NAME_CHARACTERISTIC);
                    if (bluetoothGattCharacteristic != null && ((BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE) == bluetoothGattCharacteristic.getProperties())) {
                        mIsLastNameCharacteristicSupported = true;
                    }
                    bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(EMAIL_ADDRESS_CHARACTERISTIC);
                    if (bluetoothGattCharacteristic != null && ((BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE) == bluetoothGattCharacteristic.getProperties())) {
                        mIsEmailAddressCharacteristicSupported = true;
                    }
                    bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(AGE_CHARACTERISTIC);
                    if (bluetoothGattCharacteristic != null && ((BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE) == bluetoothGattCharacteristic.getProperties())) {
                        mIsAgeCharacteristicSupported = true;
                    }
                    bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(DATE_OF_BIRTH_CHARACTERISTIC);
                    if (bluetoothGattCharacteristic != null && ((BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE) == bluetoothGattCharacteristic.getProperties())) {
                        mIsDateOfBirthCharacteristicSupported = true;
                    }
                    bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(GENDER_CHARACTERISTIC);
                    if (bluetoothGattCharacteristic != null && ((BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE) == bluetoothGattCharacteristic.getProperties())) {
                        mIsGenderCharacteristicSupported = true;
                    }
                    bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(WEIGHT_CHARACTERISTIC);
                    if (bluetoothGattCharacteristic != null && ((BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE) == bluetoothGattCharacteristic.getProperties())) {
                        mIsWeightCharacteristicSupported = true;
                    }
                    bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(HEIGHT_CHARACTERISTIC);
                    if (bluetoothGattCharacteristic != null && ((BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE) == bluetoothGattCharacteristic.getProperties())) {
                        mIsHeightCharacteristicSupported = true;
                    }
                    bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(VO2_MAX_CHARACTERISTIC);
                    if (bluetoothGattCharacteristic != null && ((BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE) == bluetoothGattCharacteristic.getProperties())) {
                        mIsVO2MaxCharacteristicSupported = true;
                    }
                    bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(HEART_RATE_MAX_CHARACTERISTIC);
                    if (bluetoothGattCharacteristic != null && ((BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE) == bluetoothGattCharacteristic.getProperties())) {
                        mIsHeartRateMaxCharacteristicSupported = true;
                    }
                    bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(RESTING_HEART_RATE_CHARACTERISTIC);
                    if (bluetoothGattCharacteristic != null && ((BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE) == bluetoothGattCharacteristic.getProperties())) {
                        mIsRestingHeartRateCharacteristicSupported = true;
                    }
                    bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(MAXIMUM_RECOMMENDED_HEART_RATE_CHARACTERISTIC);
                    if (bluetoothGattCharacteristic != null && ((BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE) == bluetoothGattCharacteristic.getProperties())) {
                        mIsMaximumRecommendedHeartRateCharacteristicSupported = true;
                    }
                    bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(AEROBIC_THRESHOLD_CHARACTERISTIC);
                    if (bluetoothGattCharacteristic != null && ((BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE) == bluetoothGattCharacteristic.getProperties())) {
                        mIsAerobicThresholdCharacteristicSupported = true;
                    }
                    bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(ANAEROBIC_THRESHOLD_CHARACTERISTIC);
                    if (bluetoothGattCharacteristic != null && ((BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE) == bluetoothGattCharacteristic.getProperties())) {
                        mIsAnaerobicThresholdCharacteristicSupported = true;
                    }
                    bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(SPORT_TYPE_FOR_AEROBIC_AND_ANAEROBIC_THRESHOLDS_CHARACTERISTIC);
                    if (bluetoothGattCharacteristic != null && ((BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE) == bluetoothGattCharacteristic.getProperties())) {
                        mIsSportTypeForAerobicAndAnaerobicThresholdsCharacteristicSupported = true;
                    }
                    bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(DATE_OF_THRESHOLD_ASSESSMENT_CHARACTERISTIC);
                    if (bluetoothGattCharacteristic != null && ((BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE) == bluetoothGattCharacteristic.getProperties())) {
                        mIsDateOfThresholdAssessmentCharacteristicSupported = true;
                    }
                    bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(WAIST_CIRCUMFERENCE_CHARACTERISTIC);
                    if (bluetoothGattCharacteristic != null && ((BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE) == bluetoothGattCharacteristic.getProperties())) {
                        mIsWaistCircumferenceCharacteristicSupported = true;
                    }
                    bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(HIP_CIRCUMFERENCE_CHARACTERISTIC);
                    if (bluetoothGattCharacteristic != null && ((BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE) == bluetoothGattCharacteristic.getProperties())) {
                        mIsHipCircumferenceCharacteristicSupported = true;
                    }
                    bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(FAT_BURN_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC);
                    if (bluetoothGattCharacteristic != null && ((BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE) == bluetoothGattCharacteristic.getProperties())) {
                        mIsFatBurnHeartRateLowerLimitCharacteristicSupported = true;
                    }
                    bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(FAT_BURN_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC);
                    if (bluetoothGattCharacteristic != null && ((BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE) == bluetoothGattCharacteristic.getProperties())) {
                        mIsFatBurnHeartRateUpperLimitCharacteristicSupported = true;
                    }
                    bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(AEROBIC_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC);
                    if (bluetoothGattCharacteristic != null && ((BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE) == bluetoothGattCharacteristic.getProperties())) {
                        mIsAerobicHeartRateLowerLimitCharacteristicSupported = true;
                    }
                    bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(AEROBIC_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC);
                    if (bluetoothGattCharacteristic != null && ((BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE) == bluetoothGattCharacteristic.getProperties())) {
                        mIsAerobicHeartRateUpperLimitCharacteristicSupported = true;
                    }
                    bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(ANAEROBIC_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC);
                    if (bluetoothGattCharacteristic != null && ((BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE) == bluetoothGattCharacteristic.getProperties())) {
                        mIsAnaerobicHeartRateLowerLimitCharacteristicSupported = true;
                    }
                    bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(ANAEROBIC_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC);
                    if (bluetoothGattCharacteristic != null && ((BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE) == bluetoothGattCharacteristic.getProperties())) {
                        mIsAnaerobicHeartRateUpperLimitCharacteristicSupported = true;
                    }
                    bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(FIVE_ZONE_HEART_RATE_LIMITS_CHARACTERISTIC);
                    if (bluetoothGattCharacteristic != null && ((BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE) == bluetoothGattCharacteristic.getProperties())) {
                        mIsFiveZoneHeartRateLimitsCharacteristicSupported = true;
                    }
                    bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(THREE_ZONE_HEART_RATE_LIMITS_CHARACTERISTIC);
                    if (bluetoothGattCharacteristic != null && ((BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE) == bluetoothGattCharacteristic.getProperties())) {
                        mIsThreeZoneHeartRateLimitsCharacteristicSupported = true;
                    }
                    bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(TWO_ZONE_HEART_RATE_LIMIT_CHARACTERISTIC);
                    if (bluetoothGattCharacteristic != null && ((BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE) == bluetoothGattCharacteristic.getProperties())) {
                        mIsTwoZoneHeartRateLimitCharacteristicSupported = true;
                    }
                    bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(LANGUAGE_CHARACTERISTIC);
                    if (bluetoothGattCharacteristic != null && ((BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_WRITE) == bluetoothGattCharacteristic.getProperties())) {
                        mIsLanguageCharacteristicSupported = true;
                    }
                    bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(DATABASE_CHANGE_INCREMENT_CHARACTERISTIC);
                    if (bluetoothGattCharacteristic != null) {
                        if ((BluetoothGattCharacteristic.PROPERTY_NOTIFY & bluetoothGattCharacteristic.getProperties()) != 0 && bluetoothGattCharacteristic.getDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR) != null) {
                            mIsDatabaseChangeIncrementCharacteristicNotifySupported = true;
                        }
                    }
                }
            }
        }
        super.onDiscoverServiceSuccess(taskId, bluetoothDevice, serviceList, argument);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onCharacteristicReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull byte[] values, @Nullable Bundle argument) {
        if (mBLEConnection.getBluetoothDevice().equals(bluetoothDevice) && USER_DATA_SERVICE.equals(serviceUUID)) {
            if (FIRST_NAME_CHARACTERISTIC.equals(characteristicUUID)) {
                mUserDataServiceCallback.onFirstNameReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, FirstNameAndroid.CREATOR.createFromMultiplePacketArray(new RegisteredUserAndroid[]{RegisteredUserAndroid.CREATOR.createFromByteArray(values)}), argument);
            } else if (LAST_NAME_CHARACTERISTIC.equals(characteristicUUID)) {
                mUserDataServiceCallback.onLastNameReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, LastNameAndroid.CREATOR.createFromMultiplePacketArray(new RegisteredUserAndroid[]{RegisteredUserAndroid.CREATOR.createFromByteArray(values)}), argument);
            } else if (EMAIL_ADDRESS_CHARACTERISTIC.equals(characteristicUUID)) {
                mUserDataServiceCallback.onEmailAddressReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, EmailAddressAndroid.CREATOR.createFromMultiplePacketArray(new RegisteredUserAndroid[]{RegisteredUserAndroid.CREATOR.createFromByteArray(values)}), argument);
            } else if (AGE_CHARACTERISTIC.equals(characteristicUUID)) {
                mUserDataServiceCallback.onAgeReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, AgeAndroid.CREATOR.createFromByteArray(values), argument);
            } else if (DATE_OF_BIRTH_CHARACTERISTIC.equals(characteristicUUID)) {
                mUserDataServiceCallback.onDateOfBirthReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, DateOfBirthAndroid.CREATOR.createFromByteArray(values), argument);
            } else if (GENDER_CHARACTERISTIC.equals(characteristicUUID)) {
                mUserDataServiceCallback.onGenderReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, GenderAndroid.CREATOR.createFromByteArray(values), argument);
            } else if (WEIGHT_CHARACTERISTIC.equals(characteristicUUID)) {
                mUserDataServiceCallback.onWeightReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, WeightAndroid.CREATOR.createFromByteArray(values), argument);
            } else if (HEIGHT_CHARACTERISTIC.equals(characteristicUUID)) {
                mUserDataServiceCallback.onHeightReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, HeightAndroid.CREATOR.createFromByteArray(values), argument);
            } else if (VO2_MAX_CHARACTERISTIC.equals(characteristicUUID)) {
                mUserDataServiceCallback.onVO2MaxReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, VO2MaxAndroid.CREATOR.createFromByteArray(values), argument);
            } else if (HEART_RATE_MAX_CHARACTERISTIC.equals(characteristicUUID)) {
                mUserDataServiceCallback.onHeartRateMaxReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, HeartRateMaxAndroid.CREATOR.createFromByteArray(values), argument);
            } else if (RESTING_HEART_RATE_CHARACTERISTIC.equals(characteristicUUID)) {
                mUserDataServiceCallback.onRestingHeartRateReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, RestingHeartRateAndroid.CREATOR.createFromByteArray(values), argument);
            } else if (MAXIMUM_RECOMMENDED_HEART_RATE_CHARACTERISTIC.equals(characteristicUUID)) {
                mUserDataServiceCallback.onMaximumRecommendedHeartRateReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, MaximumRecommendedHeartRateAndroid.CREATOR.createFromByteArray(values), argument);
            } else if (AEROBIC_THRESHOLD_CHARACTERISTIC.equals(characteristicUUID)) {
                mUserDataServiceCallback.onAerobicThresholdReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, AerobicThresholdAndroid.CREATOR.createFromByteArray(values), argument);
            } else if (ANAEROBIC_THRESHOLD_CHARACTERISTIC.equals(characteristicUUID)) {
                mUserDataServiceCallback.onAnaerobicThresholdReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, AnaerobicThresholdAndroid.CREATOR.createFromByteArray(values), argument);
            } else if (SPORT_TYPE_FOR_AEROBIC_AND_ANAEROBIC_THRESHOLDS_CHARACTERISTIC.equals(characteristicUUID)) {
                mUserDataServiceCallback.onSportTypeForAerobicAndAnaerobicThresholdsReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, SportTypeForAerobicAndAnaerobicThresholdsAndroid.CREATOR.createFromByteArray(values), argument);
            } else if (DATE_OF_THRESHOLD_ASSESSMENT_CHARACTERISTIC.equals(characteristicUUID)) {
                mUserDataServiceCallback.onDateOfThresholdAssessmentReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, DateOfThresholdAssessmentAndroid.CREATOR.createFromByteArray(values), argument);
            } else if (WAIST_CIRCUMFERENCE_CHARACTERISTIC.equals(characteristicUUID)) {
                mUserDataServiceCallback.onWaistCircumferenceReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, WaistCircumferenceAndroid.CREATOR.createFromByteArray(values), argument);
            } else if (HIP_CIRCUMFERENCE_CHARACTERISTIC.equals(characteristicUUID)) {
                mUserDataServiceCallback.onHipCircumferenceReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, HipCircumferenceAndroid.CREATOR.createFromByteArray(values), argument);
            } else if (FAT_BURN_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC.equals(characteristicUUID)) {
                mUserDataServiceCallback.onFatBurnHeartRateLowerLimitReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, FatBurnHeartRateLowerLimitAndroid.CREATOR.createFromByteArray(values), argument);
            } else if (FAT_BURN_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC.equals(characteristicUUID)) {
                mUserDataServiceCallback.onFatBurnHeartRateUpperLimitReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, FatBurnHeartRateUpperLimitAndroid.CREATOR.createFromByteArray(values), argument);
            } else if (AEROBIC_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC.equals(characteristicUUID)) {
                mUserDataServiceCallback.onAerobicHeartRateLowerLimitReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, AerobicHeartRateLowerLimitAndroid.CREATOR.createFromByteArray(values), argument);
            } else if (AEROBIC_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC.equals(characteristicUUID)) {
                mUserDataServiceCallback.onAerobicHeartRateUpperLimitReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, AerobicHeartRateUpperLimitAndroid.CREATOR.createFromByteArray(values), argument);
            } else if (ANAEROBIC_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC.equals(characteristicUUID)) {
                mUserDataServiceCallback.onAnaerobicHeartRateLowerLimitReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, AnaerobicHeartRateLowerLimitAndroid.CREATOR.createFromByteArray(values), argument);
            } else if (ANAEROBIC_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC.equals(characteristicUUID)) {
                mUserDataServiceCallback.onAnaerobicHeartRateUpperLimitReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, AnaerobicHeartRateUpperLimitAndroid.CREATOR.createFromByteArray(values), argument);
            } else if (FIVE_ZONE_HEART_RATE_LIMITS_CHARACTERISTIC.equals(characteristicUUID)) {
                mUserDataServiceCallback.onFiveZoneHeartRateLimitsReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, FiveZoneHeartRateLimitsAndroid.CREATOR.createFromByteArray(values), argument);
            } else if (THREE_ZONE_HEART_RATE_LIMITS_CHARACTERISTIC.equals(characteristicUUID)) {
                mUserDataServiceCallback.onThreeZoneHeartRateLimitsReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, ThreeZoneHeartRateLimitsAndroid.CREATOR.createFromByteArray(values), argument);
            } else if (TWO_ZONE_HEART_RATE_LIMIT_CHARACTERISTIC.equals(characteristicUUID)) {
                mUserDataServiceCallback.onTwoZoneHeartRateLimitReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, TwoZoneHeartRateLimitAndroid.CREATOR.createFromByteArray(values), argument);
            } else if (LANGUAGE_CHARACTERISTIC.equals(characteristicUUID)) {
                mUserDataServiceCallback.onLanguageReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, LanguageAndroid.CREATOR.createFromByteArray(values), argument);
            } else if (DATABASE_CHANGE_INCREMENT_CHARACTERISTIC.equals(characteristicUUID)) {
                mUserDataServiceCallback.onDatabaseChangeIncrementReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, DatabaseChangeIncrementAndroid.CREATOR.createFromByteArray(values), argument);
            } else if (USER_INDEX_CHARACTERISTIC.equals(characteristicUUID)) {
                mUserDataServiceCallback.onUserIndexReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, UserIndexAndroid.CREATOR.createFromByteArray(values), argument);
            }
        }
        super.onCharacteristicReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, values, argument);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onCharacteristicReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
        if (mBLEConnection.getBluetoothDevice().equals(bluetoothDevice) && USER_DATA_SERVICE.equals(serviceUUID)) {
            if (FIRST_NAME_CHARACTERISTIC.equals(characteristicUUID)) {
                mUserDataServiceCallback.onFirstNameReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, status, argument);
            } else if (LAST_NAME_CHARACTERISTIC.equals(characteristicUUID)) {
                mUserDataServiceCallback.onLastNameReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, status, argument);
            } else if (EMAIL_ADDRESS_CHARACTERISTIC.equals(characteristicUUID)) {
                mUserDataServiceCallback.onEmailAddressReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, status, argument);
            } else if (AGE_CHARACTERISTIC.equals(characteristicUUID)) {
                mUserDataServiceCallback.onAgeReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, status, argument);
            } else if (DATE_OF_BIRTH_CHARACTERISTIC.equals(characteristicUUID)) {
                mUserDataServiceCallback.onDateOfBirthReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, status, argument);
            } else if (GENDER_CHARACTERISTIC.equals(characteristicUUID)) {
                mUserDataServiceCallback.onGenderReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, status, argument);
            } else if (WEIGHT_CHARACTERISTIC.equals(characteristicUUID)) {
                mUserDataServiceCallback.onWeightReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, status, argument);
            } else if (HEIGHT_CHARACTERISTIC.equals(characteristicUUID)) {
                mUserDataServiceCallback.onHeightReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, status, argument);
            } else if (VO2_MAX_CHARACTERISTIC.equals(characteristicUUID)) {
                mUserDataServiceCallback.onVO2MaxReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, status, argument);
            } else if (HEART_RATE_MAX_CHARACTERISTIC.equals(characteristicUUID)) {
                mUserDataServiceCallback.onHeartRateMaxReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, status, argument);
            } else if (RESTING_HEART_RATE_CHARACTERISTIC.equals(characteristicUUID)) {
                mUserDataServiceCallback.onRestingHeartRateReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, status, argument);
            } else if (MAXIMUM_RECOMMENDED_HEART_RATE_CHARACTERISTIC.equals(characteristicUUID)) {
                mUserDataServiceCallback.onMaximumRecommendedHeartRateReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, status, argument);
            } else if (AEROBIC_THRESHOLD_CHARACTERISTIC.equals(characteristicUUID)) {
                mUserDataServiceCallback.onAerobicThresholdReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, status, argument);
            } else if (ANAEROBIC_THRESHOLD_CHARACTERISTIC.equals(characteristicUUID)) {
                mUserDataServiceCallback.onAnaerobicThresholdReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, status, argument);
            } else if (SPORT_TYPE_FOR_AEROBIC_AND_ANAEROBIC_THRESHOLDS_CHARACTERISTIC.equals(characteristicUUID)) {
                mUserDataServiceCallback.onSportTypeForAerobicAndAnaerobicThresholdsReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, status, argument);
            } else if (DATE_OF_THRESHOLD_ASSESSMENT_CHARACTERISTIC.equals(characteristicUUID)) {
                mUserDataServiceCallback.onDateOfThresholdAssessmentReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, status, argument);
            } else if (WAIST_CIRCUMFERENCE_CHARACTERISTIC.equals(characteristicUUID)) {
                mUserDataServiceCallback.onWaistCircumferenceReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, status, argument);
            } else if (HIP_CIRCUMFERENCE_CHARACTERISTIC.equals(characteristicUUID)) {
                mUserDataServiceCallback.onHipCircumferenceReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, status, argument);
            } else if (FAT_BURN_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC.equals(characteristicUUID)) {
                mUserDataServiceCallback.onFatBurnHeartRateLowerLimitReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, status, argument);
            } else if (FAT_BURN_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC.equals(characteristicUUID)) {
                mUserDataServiceCallback.onFatBurnHeartRateUpperLimitReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, status, argument);
            } else if (AEROBIC_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC.equals(characteristicUUID)) {
                mUserDataServiceCallback.onAerobicHeartRateLowerLimitReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, status, argument);
            } else if (AEROBIC_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC.equals(characteristicUUID)) {
                mUserDataServiceCallback.onAerobicHeartRateUpperLimitReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, status, argument);
            } else if (ANAEROBIC_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC.equals(characteristicUUID)) {
                mUserDataServiceCallback.onAnaerobicHeartRateLowerLimitReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, status, argument);
            } else if (ANAEROBIC_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC.equals(characteristicUUID)) {
                mUserDataServiceCallback.onAnaerobicHeartRateUpperLimitReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, status, argument);
            } else if (FIVE_ZONE_HEART_RATE_LIMITS_CHARACTERISTIC.equals(characteristicUUID)) {
                mUserDataServiceCallback.onFiveZoneHeartRateLimitsReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, status, argument);
            } else if (THREE_ZONE_HEART_RATE_LIMITS_CHARACTERISTIC.equals(characteristicUUID)) {
                mUserDataServiceCallback.onThreeZoneHeartRateLimitsReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, status, argument);
            } else if (TWO_ZONE_HEART_RATE_LIMIT_CHARACTERISTIC.equals(characteristicUUID)) {
                mUserDataServiceCallback.onTwoZoneHeartRateLimitReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, status, argument);
            } else if (LANGUAGE_CHARACTERISTIC.equals(characteristicUUID)) {
                mUserDataServiceCallback.onLanguageReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, status, argument);
            } else if (DATABASE_CHANGE_INCREMENT_CHARACTERISTIC.equals(characteristicUUID)) {
                mUserDataServiceCallback.onDatabaseChangeIncrementReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, status, argument);
            } else if (USER_INDEX_CHARACTERISTIC.equals(characteristicUUID)) {
                mUserDataServiceCallback.onUserIndexReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, status, argument);
            }
        }
        super.onCharacteristicReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, status, argument);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onCharacteristicReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
        if (mBLEConnection.getBluetoothDevice().equals(bluetoothDevice) && USER_DATA_SERVICE.equals(serviceUUID)) {
            if (FIRST_NAME_CHARACTERISTIC.equals(characteristicUUID)) {
                mUserDataServiceCallback.onFirstNameReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, timeout, argument);
            } else if (LAST_NAME_CHARACTERISTIC.equals(characteristicUUID)) {
                mUserDataServiceCallback.onLastNameReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, timeout, argument);
            } else if (EMAIL_ADDRESS_CHARACTERISTIC.equals(characteristicUUID)) {
                mUserDataServiceCallback.onEmailAddressReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, timeout, argument);
            } else if (AGE_CHARACTERISTIC.equals(characteristicUUID)) {
                mUserDataServiceCallback.onAgeReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, timeout, argument);
            } else if (DATE_OF_BIRTH_CHARACTERISTIC.equals(characteristicUUID)) {
                mUserDataServiceCallback.onDateOfBirthReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, timeout, argument);
            } else if (GENDER_CHARACTERISTIC.equals(characteristicUUID)) {
                mUserDataServiceCallback.onGenderReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, timeout, argument);
            } else if (WEIGHT_CHARACTERISTIC.equals(characteristicUUID)) {
                mUserDataServiceCallback.onWeightReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, timeout, argument);
            } else if (HEIGHT_CHARACTERISTIC.equals(characteristicUUID)) {
                mUserDataServiceCallback.onHeightReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, timeout, argument);
            } else if (VO2_MAX_CHARACTERISTIC.equals(characteristicUUID)) {
                mUserDataServiceCallback.onVO2MaxReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, timeout, argument);
            } else if (HEART_RATE_MAX_CHARACTERISTIC.equals(characteristicUUID)) {
                mUserDataServiceCallback.onHeartRateMaxReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, timeout, argument);
            } else if (RESTING_HEART_RATE_CHARACTERISTIC.equals(characteristicUUID)) {
                mUserDataServiceCallback.onRestingHeartRateReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, timeout, argument);
            } else if (MAXIMUM_RECOMMENDED_HEART_RATE_CHARACTERISTIC.equals(characteristicUUID)) {
                mUserDataServiceCallback.onMaximumRecommendedHeartRateReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, timeout, argument);
            } else if (AEROBIC_THRESHOLD_CHARACTERISTIC.equals(characteristicUUID)) {
                mUserDataServiceCallback.onAerobicThresholdReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, timeout, argument);
            } else if (ANAEROBIC_THRESHOLD_CHARACTERISTIC.equals(characteristicUUID)) {
                mUserDataServiceCallback.onAnaerobicThresholdReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, timeout, argument);
            } else if (SPORT_TYPE_FOR_AEROBIC_AND_ANAEROBIC_THRESHOLDS_CHARACTERISTIC.equals(characteristicUUID)) {
                mUserDataServiceCallback.onSportTypeForAerobicAndAnaerobicThresholdsReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, timeout, argument);
            } else if (DATE_OF_THRESHOLD_ASSESSMENT_CHARACTERISTIC.equals(characteristicUUID)) {
                mUserDataServiceCallback.onDateOfThresholdAssessmentReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, timeout, argument);
            } else if (WAIST_CIRCUMFERENCE_CHARACTERISTIC.equals(characteristicUUID)) {
                mUserDataServiceCallback.onWaistCircumferenceReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, timeout, argument);
            } else if (HIP_CIRCUMFERENCE_CHARACTERISTIC.equals(characteristicUUID)) {
                mUserDataServiceCallback.onHipCircumferenceReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, timeout, argument);
            } else if (FAT_BURN_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC.equals(characteristicUUID)) {
                mUserDataServiceCallback.onFatBurnHeartRateLowerLimitReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, timeout, argument);
            } else if (FAT_BURN_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC.equals(characteristicUUID)) {
                mUserDataServiceCallback.onFatBurnHeartRateUpperLimitReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, timeout, argument);
            } else if (AEROBIC_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC.equals(characteristicUUID)) {
                mUserDataServiceCallback.onAerobicHeartRateLowerLimitReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, timeout, argument);
            } else if (AEROBIC_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC.equals(characteristicUUID)) {
                mUserDataServiceCallback.onAerobicHeartRateUpperLimitReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, timeout, argument);
            } else if (ANAEROBIC_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC.equals(characteristicUUID)) {
                mUserDataServiceCallback.onAnaerobicHeartRateLowerLimitReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, timeout, argument);
            } else if (ANAEROBIC_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC.equals(characteristicUUID)) {
                mUserDataServiceCallback.onAnaerobicHeartRateUpperLimitReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, timeout, argument);
            } else if (FIVE_ZONE_HEART_RATE_LIMITS_CHARACTERISTIC.equals(characteristicUUID)) {
                mUserDataServiceCallback.onFiveZoneHeartRateLimitsReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, timeout, argument);
            } else if (THREE_ZONE_HEART_RATE_LIMITS_CHARACTERISTIC.equals(characteristicUUID)) {
                mUserDataServiceCallback.onThreeZoneHeartRateLimitsReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, timeout, argument);
            } else if (TWO_ZONE_HEART_RATE_LIMIT_CHARACTERISTIC.equals(characteristicUUID)) {
                mUserDataServiceCallback.onTwoZoneHeartRateLimitReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, timeout, argument);
            } else if (LANGUAGE_CHARACTERISTIC.equals(characteristicUUID)) {
                mUserDataServiceCallback.onLanguageReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, timeout, argument);
            } else if (DATABASE_CHANGE_INCREMENT_CHARACTERISTIC.equals(characteristicUUID)) {
                mUserDataServiceCallback.onDatabaseChangeIncrementReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, timeout, argument);
            } else if (USER_INDEX_CHARACTERISTIC.equals(characteristicUUID)) {
                mUserDataServiceCallback.onUserIndexReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, timeout, argument);
            }
        }
        super.onCharacteristicReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, timeout, argument);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onCharacteristicWriteSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull byte[] values, @Nullable Bundle argument) {
        if (mBLEConnection.getBluetoothDevice().equals(bluetoothDevice) && USER_DATA_SERVICE.equals(serviceUUID)) {
            if (FIRST_NAME_CHARACTERISTIC.equals(characteristicUUID)) {
                mUserDataServiceCallback.onFirstNameWriteSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, FirstNameAndroid.CREATOR.createFromMultiplePacketArray(new RegisteredUserAndroid[]{RegisteredUserAndroid.CREATOR.createFromByteArray(values)}), argument);
            } else if (LAST_NAME_CHARACTERISTIC.equals(characteristicUUID)) {
                mUserDataServiceCallback.onLastNameWriteSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, LastNameAndroid.CREATOR.createFromMultiplePacketArray(new RegisteredUserAndroid[]{RegisteredUserAndroid.CREATOR.createFromByteArray(values)}), argument);
            } else if (EMAIL_ADDRESS_CHARACTERISTIC.equals(characteristicUUID)) {
                mUserDataServiceCallback.onEmailAddressWriteSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, EmailAddressAndroid.CREATOR.createFromMultiplePacketArray(new RegisteredUserAndroid[]{RegisteredUserAndroid.CREATOR.createFromByteArray(values)}), argument);
            } else if (AGE_CHARACTERISTIC.equals(characteristicUUID)) {
                mUserDataServiceCallback.onAgeWriteSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, AgeAndroid.CREATOR.createFromByteArray(values), argument);
            } else if (DATE_OF_BIRTH_CHARACTERISTIC.equals(characteristicUUID)) {
                mUserDataServiceCallback.onDateOfBirthWriteSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, DateOfBirthAndroid.CREATOR.createFromByteArray(values), argument);
            } else if (GENDER_CHARACTERISTIC.equals(characteristicUUID)) {
                mUserDataServiceCallback.onGenderWriteSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, GenderAndroid.CREATOR.createFromByteArray(values), argument);
            } else if (WEIGHT_CHARACTERISTIC.equals(characteristicUUID)) {
                mUserDataServiceCallback.onWeightWriteSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, WeightAndroid.CREATOR.createFromByteArray(values), argument);
            } else if (HEIGHT_CHARACTERISTIC.equals(characteristicUUID)) {
                mUserDataServiceCallback.onHeightWriteSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, HeightAndroid.CREATOR.createFromByteArray(values), argument);
            } else if (VO2_MAX_CHARACTERISTIC.equals(characteristicUUID)) {
                mUserDataServiceCallback.onVO2MaxWriteSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, VO2MaxAndroid.CREATOR.createFromByteArray(values), argument);
            } else if (HEART_RATE_MAX_CHARACTERISTIC.equals(characteristicUUID)) {
                mUserDataServiceCallback.onHeartRateMaxWriteSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, HeartRateMaxAndroid.CREATOR.createFromByteArray(values), argument);
            } else if (RESTING_HEART_RATE_CHARACTERISTIC.equals(characteristicUUID)) {
                mUserDataServiceCallback.onRestingHeartRateWriteSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, RestingHeartRateAndroid.CREATOR.createFromByteArray(values), argument);
            } else if (MAXIMUM_RECOMMENDED_HEART_RATE_CHARACTERISTIC.equals(characteristicUUID)) {
                mUserDataServiceCallback.onMaximumRecommendedHeartRateWriteSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, MaximumRecommendedHeartRateAndroid.CREATOR.createFromByteArray(values), argument);
            } else if (AEROBIC_THRESHOLD_CHARACTERISTIC.equals(characteristicUUID)) {
                mUserDataServiceCallback.onAerobicThresholdWriteSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, AerobicThresholdAndroid.CREATOR.createFromByteArray(values), argument);
            } else if (ANAEROBIC_THRESHOLD_CHARACTERISTIC.equals(characteristicUUID)) {
                mUserDataServiceCallback.onAnaerobicThresholdWriteSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, AnaerobicThresholdAndroid.CREATOR.createFromByteArray(values), argument);
            } else if (SPORT_TYPE_FOR_AEROBIC_AND_ANAEROBIC_THRESHOLDS_CHARACTERISTIC.equals(characteristicUUID)) {
                mUserDataServiceCallback.onSportTypeForAerobicAndAnaerobicThresholdsWriteSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, SportTypeForAerobicAndAnaerobicThresholdsAndroid.CREATOR.createFromByteArray(values), argument);
            } else if (DATE_OF_THRESHOLD_ASSESSMENT_CHARACTERISTIC.equals(characteristicUUID)) {
                mUserDataServiceCallback.onDateOfThresholdAssessmentWriteSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, DateOfThresholdAssessmentAndroid.CREATOR.createFromByteArray(values), argument);
            } else if (WAIST_CIRCUMFERENCE_CHARACTERISTIC.equals(characteristicUUID)) {
                mUserDataServiceCallback.onWaistCircumferenceWriteSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, WaistCircumferenceAndroid.CREATOR.createFromByteArray(values), argument);
            } else if (HIP_CIRCUMFERENCE_CHARACTERISTIC.equals(characteristicUUID)) {
                mUserDataServiceCallback.onHipCircumferenceWriteSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, HipCircumferenceAndroid.CREATOR.createFromByteArray(values), argument);
            } else if (FAT_BURN_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC.equals(characteristicUUID)) {
                mUserDataServiceCallback.onFatBurnHeartRateLowerLimitWriteSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, FatBurnHeartRateLowerLimitAndroid.CREATOR.createFromByteArray(values), argument);
            } else if (FAT_BURN_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC.equals(characteristicUUID)) {
                mUserDataServiceCallback.onFatBurnHeartRateUpperLimitWriteSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, FatBurnHeartRateUpperLimitAndroid.CREATOR.createFromByteArray(values), argument);
            } else if (AEROBIC_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC.equals(characteristicUUID)) {
                mUserDataServiceCallback.onAerobicHeartRateLowerLimitWriteSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, AerobicHeartRateLowerLimitAndroid.CREATOR.createFromByteArray(values), argument);
            } else if (AEROBIC_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC.equals(characteristicUUID)) {
                mUserDataServiceCallback.onAerobicHeartRateUpperLimitWriteSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, AerobicHeartRateUpperLimitAndroid.CREATOR.createFromByteArray(values), argument);
            } else if (ANAEROBIC_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC.equals(characteristicUUID)) {
                mUserDataServiceCallback.onAnaerobicHeartRateLowerLimitWriteSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, AnaerobicHeartRateLowerLimitAndroid.CREATOR.createFromByteArray(values), argument);
            } else if (ANAEROBIC_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC.equals(characteristicUUID)) {
                mUserDataServiceCallback.onAnaerobicHeartRateUpperLimitWriteSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, AnaerobicHeartRateUpperLimitAndroid.CREATOR.createFromByteArray(values), argument);
            } else if (FIVE_ZONE_HEART_RATE_LIMITS_CHARACTERISTIC.equals(characteristicUUID)) {
                mUserDataServiceCallback.onFiveZoneHeartRateLimitsWriteSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, FiveZoneHeartRateLimitsAndroid.CREATOR.createFromByteArray(values), argument);
            } else if (THREE_ZONE_HEART_RATE_LIMITS_CHARACTERISTIC.equals(characteristicUUID)) {
                mUserDataServiceCallback.onThreeZoneHeartRateLimitsWriteSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, ThreeZoneHeartRateLimitsAndroid.CREATOR.createFromByteArray(values), argument);
            } else if (TWO_ZONE_HEART_RATE_LIMIT_CHARACTERISTIC.equals(characteristicUUID)) {
                mUserDataServiceCallback.onTwoZoneHeartRateLimitWriteSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, TwoZoneHeartRateLimitAndroid.CREATOR.createFromByteArray(values), argument);
            } else if (LANGUAGE_CHARACTERISTIC.equals(characteristicUUID)) {
                mUserDataServiceCallback.onLanguageWriteSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, LanguageAndroid.CREATOR.createFromByteArray(values), argument);
            } else if (DATABASE_CHANGE_INCREMENT_CHARACTERISTIC.equals(characteristicUUID)) {
                mUserDataServiceCallback.onDatabaseChangeIncrementWriteSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, DatabaseChangeIncrementAndroid.CREATOR.createFromByteArray(values), argument);
            } else if (USER_CONTROL_POINT_CHARACTERISTIC.equals(characteristicUUID)) {
                mUserDataServiceCallback.onUserControlPointWriteSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, UserControlPointAndroid.CREATOR.createFromByteArray(values), argument);
            }
        }
        super.onCharacteristicWriteSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, values, argument);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onCharacteristicWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
        if (mBLEConnection.getBluetoothDevice().equals(bluetoothDevice) && USER_DATA_SERVICE.equals(serviceUUID)) {
            if (FIRST_NAME_CHARACTERISTIC.equals(characteristicUUID)) {
                mUserDataServiceCallback.onFirstNameWriteFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, status, argument);
            } else if (LAST_NAME_CHARACTERISTIC.equals(characteristicUUID)) {
                mUserDataServiceCallback.onLastNameWriteFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, status, argument);
            } else if (EMAIL_ADDRESS_CHARACTERISTIC.equals(characteristicUUID)) {
                mUserDataServiceCallback.onEmailAddressWriteFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, status, argument);
            } else if (AGE_CHARACTERISTIC.equals(characteristicUUID)) {
                mUserDataServiceCallback.onAgeWriteFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, status, argument);
            } else if (DATE_OF_BIRTH_CHARACTERISTIC.equals(characteristicUUID)) {
                mUserDataServiceCallback.onDateOfBirthWriteFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, status, argument);
            } else if (GENDER_CHARACTERISTIC.equals(characteristicUUID)) {
                mUserDataServiceCallback.onGenderWriteFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, status, argument);
            } else if (WEIGHT_CHARACTERISTIC.equals(characteristicUUID)) {
                mUserDataServiceCallback.onWeightWriteFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, status, argument);
            } else if (HEIGHT_CHARACTERISTIC.equals(characteristicUUID)) {
                mUserDataServiceCallback.onHeightWriteFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, status, argument);
            } else if (VO2_MAX_CHARACTERISTIC.equals(characteristicUUID)) {
                mUserDataServiceCallback.onVO2MaxWriteFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, status, argument);
            } else if (HEART_RATE_MAX_CHARACTERISTIC.equals(characteristicUUID)) {
                mUserDataServiceCallback.onHeartRateMaxWriteFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, status, argument);
            } else if (RESTING_HEART_RATE_CHARACTERISTIC.equals(characteristicUUID)) {
                mUserDataServiceCallback.onRestingHeartRateWriteFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, status, argument);
            } else if (MAXIMUM_RECOMMENDED_HEART_RATE_CHARACTERISTIC.equals(characteristicUUID)) {
                mUserDataServiceCallback.onMaximumRecommendedHeartRateWriteFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, status, argument);
            } else if (AEROBIC_THRESHOLD_CHARACTERISTIC.equals(characteristicUUID)) {
                mUserDataServiceCallback.onAerobicThresholdWriteFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, status, argument);
            } else if (ANAEROBIC_THRESHOLD_CHARACTERISTIC.equals(characteristicUUID)) {
                mUserDataServiceCallback.onAnaerobicThresholdWriteFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, status, argument);
            } else if (SPORT_TYPE_FOR_AEROBIC_AND_ANAEROBIC_THRESHOLDS_CHARACTERISTIC.equals(characteristicUUID)) {
                mUserDataServiceCallback.onSportTypeForAerobicAndAnaerobicThresholdsWriteFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, status, argument);
            } else if (DATE_OF_THRESHOLD_ASSESSMENT_CHARACTERISTIC.equals(characteristicUUID)) {
                mUserDataServiceCallback.onDateOfThresholdAssessmentWriteFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, status, argument);
            } else if (WAIST_CIRCUMFERENCE_CHARACTERISTIC.equals(characteristicUUID)) {
                mUserDataServiceCallback.onWaistCircumferenceWriteFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, status, argument);
            } else if (HIP_CIRCUMFERENCE_CHARACTERISTIC.equals(characteristicUUID)) {
                mUserDataServiceCallback.onHipCircumferenceWriteFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, status, argument);
            } else if (FAT_BURN_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC.equals(characteristicUUID)) {
                mUserDataServiceCallback.onFatBurnHeartRateLowerLimitWriteFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, status, argument);
            } else if (FAT_BURN_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC.equals(characteristicUUID)) {
                mUserDataServiceCallback.onFatBurnHeartRateUpperLimitWriteFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, status, argument);
            } else if (AEROBIC_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC.equals(characteristicUUID)) {
                mUserDataServiceCallback.onAerobicHeartRateLowerLimitWriteFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, status, argument);
            } else if (AEROBIC_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC.equals(characteristicUUID)) {
                mUserDataServiceCallback.onAerobicHeartRateUpperLimitWriteFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, status, argument);
            } else if (ANAEROBIC_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC.equals(characteristicUUID)) {
                mUserDataServiceCallback.onAnaerobicHeartRateLowerLimitWriteFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, status, argument);
            } else if (ANAEROBIC_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC.equals(characteristicUUID)) {
                mUserDataServiceCallback.onAnaerobicHeartRateUpperLimitWriteFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, status, argument);
            } else if (FIVE_ZONE_HEART_RATE_LIMITS_CHARACTERISTIC.equals(characteristicUUID)) {
                mUserDataServiceCallback.onFiveZoneHeartRateLimitsWriteFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, status, argument);
            } else if (THREE_ZONE_HEART_RATE_LIMITS_CHARACTERISTIC.equals(characteristicUUID)) {
                mUserDataServiceCallback.onThreeZoneHeartRateLimitsWriteFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, status, argument);
            } else if (TWO_ZONE_HEART_RATE_LIMIT_CHARACTERISTIC.equals(characteristicUUID)) {
                mUserDataServiceCallback.onTwoZoneHeartRateLimitWriteFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, status, argument);
            } else if (LANGUAGE_CHARACTERISTIC.equals(characteristicUUID)) {
                mUserDataServiceCallback.onLanguageWriteFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, status, argument);
            } else if (DATABASE_CHANGE_INCREMENT_CHARACTERISTIC.equals(characteristicUUID)) {
                mUserDataServiceCallback.onDatabaseChangeIncrementWriteFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, status, argument);
            } else if (USER_CONTROL_POINT_CHARACTERISTIC.equals(characteristicUUID)) {
                mUserDataServiceCallback.onUserControlPointWriteFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, status, argument);
            }
        }
        super.onCharacteristicWriteFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, status, argument);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onCharacteristicWriteTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
        if (mBLEConnection.getBluetoothDevice().equals(bluetoothDevice) && USER_DATA_SERVICE.equals(serviceUUID)) {
            if (FIRST_NAME_CHARACTERISTIC.equals(characteristicUUID)) {
                mUserDataServiceCallback.onFirstNameWriteTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, timeout, argument);
            } else if (LAST_NAME_CHARACTERISTIC.equals(characteristicUUID)) {
                mUserDataServiceCallback.onLastNameWriteTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, timeout, argument);
            } else if (EMAIL_ADDRESS_CHARACTERISTIC.equals(characteristicUUID)) {
                mUserDataServiceCallback.onEmailAddressWriteTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, timeout, argument);
            } else if (AGE_CHARACTERISTIC.equals(characteristicUUID)) {
                mUserDataServiceCallback.onAgeWriteTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, timeout, argument);
            } else if (DATE_OF_BIRTH_CHARACTERISTIC.equals(characteristicUUID)) {
                mUserDataServiceCallback.onDateOfBirthWriteTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, timeout, argument);
            } else if (GENDER_CHARACTERISTIC.equals(characteristicUUID)) {
                mUserDataServiceCallback.onGenderWriteTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, timeout, argument);
            } else if (WEIGHT_CHARACTERISTIC.equals(characteristicUUID)) {
                mUserDataServiceCallback.onWeightWriteTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, timeout, argument);
            } else if (HEIGHT_CHARACTERISTIC.equals(characteristicUUID)) {
                mUserDataServiceCallback.onHeightWriteTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, timeout, argument);
            } else if (VO2_MAX_CHARACTERISTIC.equals(characteristicUUID)) {
                mUserDataServiceCallback.onVO2MaxWriteTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, timeout, argument);
            } else if (HEART_RATE_MAX_CHARACTERISTIC.equals(characteristicUUID)) {
                mUserDataServiceCallback.onHeartRateMaxWriteTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, timeout, argument);
            } else if (RESTING_HEART_RATE_CHARACTERISTIC.equals(characteristicUUID)) {
                mUserDataServiceCallback.onRestingHeartRateWriteTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, timeout, argument);
            } else if (MAXIMUM_RECOMMENDED_HEART_RATE_CHARACTERISTIC.equals(characteristicUUID)) {
                mUserDataServiceCallback.onMaximumRecommendedHeartRateWriteTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, timeout, argument);
            } else if (AEROBIC_THRESHOLD_CHARACTERISTIC.equals(characteristicUUID)) {
                mUserDataServiceCallback.onAerobicThresholdWriteTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, timeout, argument);
            } else if (ANAEROBIC_THRESHOLD_CHARACTERISTIC.equals(characteristicUUID)) {
                mUserDataServiceCallback.onAnaerobicThresholdWriteTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, timeout, argument);
            } else if (SPORT_TYPE_FOR_AEROBIC_AND_ANAEROBIC_THRESHOLDS_CHARACTERISTIC.equals(characteristicUUID)) {
                mUserDataServiceCallback.onSportTypeForAerobicAndAnaerobicThresholdsWriteTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, timeout, argument);
            } else if (DATE_OF_THRESHOLD_ASSESSMENT_CHARACTERISTIC.equals(characteristicUUID)) {
                mUserDataServiceCallback.onDateOfThresholdAssessmentWriteTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, timeout, argument);
            } else if (WAIST_CIRCUMFERENCE_CHARACTERISTIC.equals(characteristicUUID)) {
                mUserDataServiceCallback.onWaistCircumferenceWriteTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, timeout, argument);
            } else if (HIP_CIRCUMFERENCE_CHARACTERISTIC.equals(characteristicUUID)) {
                mUserDataServiceCallback.onHipCircumferenceWriteTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, timeout, argument);
            } else if (FAT_BURN_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC.equals(characteristicUUID)) {
                mUserDataServiceCallback.onFatBurnHeartRateLowerLimitWriteTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, timeout, argument);
            } else if (FAT_BURN_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC.equals(characteristicUUID)) {
                mUserDataServiceCallback.onFatBurnHeartRateUpperLimitWriteTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, timeout, argument);
            } else if (AEROBIC_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC.equals(characteristicUUID)) {
                mUserDataServiceCallback.onAerobicHeartRateLowerLimitWriteTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, timeout, argument);
            } else if (AEROBIC_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC.equals(characteristicUUID)) {
                mUserDataServiceCallback.onAerobicHeartRateUpperLimitWriteTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, timeout, argument);
            } else if (ANAEROBIC_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC.equals(characteristicUUID)) {
                mUserDataServiceCallback.onAnaerobicHeartRateLowerLimitWriteTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, timeout, argument);
            } else if (ANAEROBIC_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC.equals(characteristicUUID)) {
                mUserDataServiceCallback.onAnaerobicHeartRateUpperLimitWriteTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, timeout, argument);
            } else if (FIVE_ZONE_HEART_RATE_LIMITS_CHARACTERISTIC.equals(characteristicUUID)) {
                mUserDataServiceCallback.onFiveZoneHeartRateLimitsWriteTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, timeout, argument);
            } else if (THREE_ZONE_HEART_RATE_LIMITS_CHARACTERISTIC.equals(characteristicUUID)) {
                mUserDataServiceCallback.onThreeZoneHeartRateLimitsWriteTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, timeout, argument);
            } else if (TWO_ZONE_HEART_RATE_LIMIT_CHARACTERISTIC.equals(characteristicUUID)) {
                mUserDataServiceCallback.onTwoZoneHeartRateLimitWriteTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, timeout, argument);
            } else if (LANGUAGE_CHARACTERISTIC.equals(characteristicUUID)) {
                mUserDataServiceCallback.onLanguageWriteTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, timeout, argument);
            } else if (DATABASE_CHANGE_INCREMENT_CHARACTERISTIC.equals(characteristicUUID)) {
                mUserDataServiceCallback.onDatabaseChangeIncrementWriteTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, timeout, argument);
            } else if (USER_CONTROL_POINT_CHARACTERISTIC.equals(characteristicUUID)) {
                mUserDataServiceCallback.onUserControlPointWriteTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, timeout, argument);
            }
        }
        super.onCharacteristicWriteTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, timeout, argument);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onDescriptorReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @NonNull Integer descriptorInstanceId, @NonNull byte[] values, @Nullable Bundle argument) {
        if (mBLEConnection.getBluetoothDevice().equals(bluetoothDevice) && USER_DATA_SERVICE.equals(serviceUUID) && CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR.equals(descriptorUUID)) {
            if (DATABASE_CHANGE_INCREMENT_CHARACTERISTIC.equals(characteristicUUID)) {
                mUserDataServiceCallback.onDatabaseChangeIncrementClientCharacteristicConfigurationReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorInstanceId, ClientCharacteristicConfigurationAndroid.CREATOR.createFromByteArray(values), argument);
            } else if (REGISTERED_USER_CHARACTERISTIC.equals(characteristicUUID)) {
                mUserDataServiceCallback.onRegisteredUserClientCharacteristicConfigurationReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorInstanceId, ClientCharacteristicConfigurationAndroid.CREATOR.createFromByteArray(values), argument);
            } else if (USER_CONTROL_POINT_CHARACTERISTIC.equals(characteristicUUID)) {
                mUserDataServiceCallback.onUserControlPointClientCharacteristicConfigurationReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorInstanceId, ClientCharacteristicConfigurationAndroid.CREATOR.createFromByteArray(values), argument);
            }
        }
        super.onDescriptorReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorUUID, descriptorInstanceId, values, argument);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onDescriptorReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
        if (mBLEConnection.getBluetoothDevice().equals(bluetoothDevice) && USER_DATA_SERVICE.equals(serviceUUID) && CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR.equals(descriptorUUID)) {
            if (DATABASE_CHANGE_INCREMENT_CHARACTERISTIC.equals(characteristicUUID)) {
                mUserDataServiceCallback.onDatabaseChangeIncrementClientCharacteristicConfigurationReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorInstanceId, status, argument);
            } else if (REGISTERED_USER_CHARACTERISTIC.equals(characteristicUUID)) {
                mUserDataServiceCallback.onRegisteredUserClientCharacteristicConfigurationReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorInstanceId, status, argument);
            } else if (USER_CONTROL_POINT_CHARACTERISTIC.equals(characteristicUUID)) {
                mUserDataServiceCallback.onUserControlPointClientCharacteristicConfigurationReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorInstanceId, status, argument);
            }
        }
        super.onDescriptorReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorUUID, descriptorInstanceId, status, argument);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onDescriptorReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
        if (mBLEConnection.getBluetoothDevice().equals(bluetoothDevice) && USER_DATA_SERVICE.equals(serviceUUID) && CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR.equals(descriptorUUID)) {
            if (DATABASE_CHANGE_INCREMENT_CHARACTERISTIC.equals(characteristicUUID)) {
                mUserDataServiceCallback.onDatabaseChangeIncrementClientCharacteristicConfigurationReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorInstanceId, timeout, argument);
            } else if (REGISTERED_USER_CHARACTERISTIC.equals(characteristicUUID)) {
                mUserDataServiceCallback.onRegisteredUserClientCharacteristicConfigurationReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorInstanceId, timeout, argument);
            } else if (USER_CONTROL_POINT_CHARACTERISTIC.equals(characteristicUUID)) {
                mUserDataServiceCallback.onUserControlPointClientCharacteristicConfigurationReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorInstanceId, timeout, argument);
            }
        }
        super.onDescriptorReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorUUID, descriptorInstanceId, timeout, argument);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onDescriptorWriteSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @NonNull Integer descriptorInstanceId, @NonNull byte[] values, @Nullable Bundle argument) {
        if (mBLEConnection.getBluetoothDevice().equals(bluetoothDevice) && USER_DATA_SERVICE.equals(serviceUUID) && CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR.equals(descriptorUUID) && argument != null && argument.containsKey(KEY_STATUS)) {
            if (DATABASE_CHANGE_INCREMENT_CHARACTERISTIC.equals(characteristicUUID)) {
                if (argument.getInt(KEY_STATUS, STATUS_START) == STATUS_START) {
                    mUserDataServiceCallback.onDatabaseChangeIncrementNotifyStartSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorInstanceId, argument);
                } else {
                    mUserDataServiceCallback.onDatabaseChangeIncrementNotifyStopSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorInstanceId, argument);
                }
            } else if (REGISTERED_USER_CHARACTERISTIC.equals(characteristicUUID)) {
                if (argument.getInt(KEY_STATUS, STATUS_START) == STATUS_START) {
                    mUserDataServiceCallback.onRegisteredUserIndicateStartSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorInstanceId, argument);
                } else {
                    mUserDataServiceCallback.onRegisteredUserIndicateStopSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorInstanceId, argument);
                }
            } else if (USER_CONTROL_POINT_CHARACTERISTIC.equals(characteristicUUID)) {
                if (argument.getInt(KEY_STATUS, STATUS_START) == STATUS_START) {
                    mUserDataServiceCallback.onUserControlPointIndicateStartSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorInstanceId, argument);
                } else {
                    mUserDataServiceCallback.onUserControlPointIndicateStopSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorInstanceId, argument);
                }
            }
        }
        super.onDescriptorWriteSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorUUID, descriptorInstanceId, values, argument);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onDescriptorWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
        if (mBLEConnection.getBluetoothDevice().equals(bluetoothDevice) && USER_DATA_SERVICE.equals(serviceUUID) && CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR.equals(descriptorUUID) && argument != null && argument.containsKey(KEY_STATUS)) {
            if (DATABASE_CHANGE_INCREMENT_CHARACTERISTIC.equals(characteristicUUID)) {
                if (argument.getInt(KEY_STATUS, STATUS_START) == STATUS_START) {
                    mUserDataServiceCallback.onDatabaseChangeIncrementNotifyStartFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorInstanceId, status, argument);
                } else {
                    mUserDataServiceCallback.onDatabaseChangeIncrementNotifyStopFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorInstanceId, status, argument);
                }
            } else if (REGISTERED_USER_CHARACTERISTIC.equals(characteristicUUID)) {
                if (argument.getInt(KEY_STATUS, STATUS_START) == STATUS_START) {
                    mUserDataServiceCallback.onRegisteredUserIndicateStartFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorInstanceId, status, argument);
                } else {
                    mUserDataServiceCallback.onRegisteredUserIndicateStopFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorInstanceId, status, argument);
                }
            } else if (USER_CONTROL_POINT_CHARACTERISTIC.equals(characteristicUUID)) {
                if (argument.getInt(KEY_STATUS, STATUS_START) == STATUS_START) {
                    mUserDataServiceCallback.onUserControlPointIndicateStartFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorInstanceId, status, argument);
                } else {
                    mUserDataServiceCallback.onUserControlPointIndicateStopFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorInstanceId, status, argument);
                }
            }
        }
        super.onDescriptorWriteFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorUUID, descriptorInstanceId, status, argument);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onDescriptorWriteTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
        if (mBLEConnection.getBluetoothDevice().equals(bluetoothDevice) && USER_DATA_SERVICE.equals(serviceUUID) && CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR.equals(descriptorUUID) && argument != null && argument.containsKey(KEY_STATUS)) {
            if (DATABASE_CHANGE_INCREMENT_CHARACTERISTIC.equals(characteristicUUID)) {
                if (argument.getInt(KEY_STATUS, STATUS_START) == STATUS_START) {
                    mUserDataServiceCallback.onDatabaseChangeIncrementNotifyStartTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorInstanceId, timeout, argument);
                } else {
                    mUserDataServiceCallback.onDatabaseChangeIncrementNotifyStopTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorInstanceId, timeout, argument);
                }
            } else if (REGISTERED_USER_CHARACTERISTIC.equals(characteristicUUID)) {
                if (argument.getInt(KEY_STATUS, STATUS_START) == STATUS_START) {
                    mUserDataServiceCallback.onRegisteredUserIndicateStartTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorInstanceId, timeout, argument);
                } else {
                    mUserDataServiceCallback.onRegisteredUserIndicateStopTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorInstanceId, timeout, argument);
                }
            } else if (USER_CONTROL_POINT_CHARACTERISTIC.equals(characteristicUUID)) {
                if (argument.getInt(KEY_STATUS, STATUS_START) == STATUS_START) {
                    mUserDataServiceCallback.onUserControlPointIndicateStartTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorInstanceId, timeout, argument);
                } else {
                    mUserDataServiceCallback.onUserControlPointIndicateStopTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorInstanceId, timeout, argument);
                }
            }
        }
        super.onDescriptorWriteTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorUUID, descriptorInstanceId, timeout, argument);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onCharacteristicNotified(@NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull byte[] values) {
        if (mBLEConnection.getBluetoothDevice().equals(bluetoothDevice) && USER_DATA_SERVICE.equals(serviceUUID)) {
            if (DATABASE_CHANGE_INCREMENT_CHARACTERISTIC.equals(characteristicUUID)) {
                mUserDataServiceCallback.onDatabaseChangeIncrementNotified(bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, DatabaseChangeIncrementAndroid.CREATOR.createFromByteArray(values));
            } else if (REGISTERED_USER_CHARACTERISTIC.equals(characteristicUUID)) {
                mUserDataServiceCallback.onRegisteredUserIndicated(bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, RegisteredUserAndroid.CREATOR.createFromByteArray(values));
            } else if (USER_CONTROL_POINT_CHARACTERISTIC.equals(characteristicUUID)) {
                mUserDataServiceCallback.onUserControlPointIndicated(bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, UserControlPointAndroid.CREATOR.createFromByteArray(values));
            }
        }
        super.onCharacteristicNotified(bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, values);
    }

    /**
     * check First Name characteristic
     *
     * @return {@code true}:First Name characteristic is exist, {@code false}:First Name characteristic is not exist or service not ready
     */
    public boolean isFirstNameCharacteristicSupported() {
        return mIsFirstNameCharacteristicSupported;
    }

    /**
     * check Last Name characteristic
     *
     * @return {@code true}:Last Name characteristic is exist, {@code false}:Last Name characteristic is not exist or service not ready
     */
    public boolean isLastNameCharacteristicSupported() {
        return mIsLastNameCharacteristicSupported;
    }

    /**
     * check Email Address characteristic
     *
     * @return {@code true}:Email Address characteristic is exist, {@code false}:Email Address characteristic is not exist or service not ready
     */
    public boolean isEmailAddressCharacteristicSupported() {
        return mIsEmailAddressCharacteristicSupported;
    }

    /**
     * check Age characteristic
     *
     * @return {@code true}:Age characteristic is exist, {@code false}:Age characteristic is not exist or service not ready
     */
    public boolean isAgeCharacteristicSupported() {
        return mIsAgeCharacteristicSupported;
    }

    /**
     * check Date of Birth characteristic
     *
     * @return {@code true}:Date of Birth characteristic is exist, {@code false}:Date of Birth characteristic is not exist or service not ready
     */
    public boolean isDateOfBirthCharacteristicSupported() {
        return mIsDateOfBirthCharacteristicSupported;
    }

    /**
     * check Gender characteristic
     *
     * @return {@code true}:Gender characteristic is exist, {@code false}:Gender characteristic is not exist or service not ready
     */
    public boolean isGenderCharacteristicSupported() {
        return mIsGenderCharacteristicSupported;
    }

    /**
     * check Weight characteristic
     *
     * @return {@code true}:Weight characteristic is exist, {@code false}:Weight characteristic is not exist or service not ready
     */
    public boolean isWeightCharacteristicSupported() {
        return mIsWeightCharacteristicSupported;
    }

    /**
     * check Height characteristic
     *
     * @return {@code true}:Height characteristic is exist, {@code false}:Height characteristic is not exist or service not ready
     */
    public boolean isHeightCharacteristicSupported() {
        return mIsHeightCharacteristicSupported;
    }

    /**
     * check VO2 Max characteristic
     *
     * @return {@code true}:VO2 Max characteristic is exist, {@code false}:VO2 Max characteristic is not exist or service not ready
     */
    public boolean isVO2MaxCharacteristicSupported() {
        return mIsVO2MaxCharacteristicSupported;
    }

    /**
     * check Heart Rate Max characteristic
     *
     * @return {@code true}:Heart Rate Max characteristic is exist, {@code false}:Heart Rate Max characteristic is not exist or service not ready
     */
    public boolean isHeartRateMaxCharacteristicSupported() {
        return mIsHeartRateMaxCharacteristicSupported;
    }

    /**
     * check Resting Heart Rate characteristic
     *
     * @return {@code true}:Resting Heart Rate characteristic is exist, {@code false}:Resting Heart Rate characteristic is not exist or service not ready
     */
    public boolean isRestingHeartRateCharacteristicSupported() {
        return mIsRestingHeartRateCharacteristicSupported;
    }

    /**
     * check Maximum Recommended Heart Rate characteristic
     *
     * @return {@code true}:Maximum Recommended Heart Rate characteristic is exist, {@code false}:Maximum Recommended Heart Rate characteristic is not exist or service not ready
     */
    public boolean isMaximumRecommendedHeartRateCharacteristicSupported() {
        return mIsMaximumRecommendedHeartRateCharacteristicSupported;
    }

    /**
     * check Aerobic Threshold characteristic
     *
     * @return {@code true}:Aerobic Threshold characteristic is exist, {@code false}:Aerobic Threshold characteristic is not exist or service not ready
     */
    public boolean isAerobicThresholdCharacteristicSupported() {
        return mIsAerobicThresholdCharacteristicSupported;
    }

    /**
     * check Anaerobic Threshold characteristic
     *
     * @return {@code true}:Anaerobic Threshold characteristic is exist, {@code false}:Anaerobic Threshold characteristic is not exist or service not ready
     */
    public boolean isAnaerobicThresholdCharacteristicSupported() {
        return mIsAnaerobicThresholdCharacteristicSupported;
    }

    /**
     * check Sport Type for Aerobic and Anaerobic Thresholds characteristic
     *
     * @return {@code true}:Sport Type for Aerobic and Anaerobic Thresholds characteristic is exist, {@code false}:Sport Type for Aerobic and Anaerobic Thresholds characteristic is not exist or service not ready
     */
    public boolean isSportTypeForAerobicAndAnaerobicThresholdsCharacteristicSupported() {
        return mIsSportTypeForAerobicAndAnaerobicThresholdsCharacteristicSupported;
    }

    /**
     * check Date of Threshold Assessment characteristic
     *
     * @return {@code true}:Date of Threshold Assessment characteristic is exist, {@code false}:Date of Threshold Assessment characteristic is not exist or service not ready
     */
    public boolean isDateOfThresholdAssessmentCharacteristicSupported() {
        return mIsDateOfThresholdAssessmentCharacteristicSupported;
    }

    /**
     * check Waist Circumference characteristic
     *
     * @return {@code true}:Waist Circumference characteristic is exist, {@code false}:Waist Circumference characteristic is not exist or service not ready
     */
    public boolean isWaistCircumferenceCharacteristicSupported() {
        return mIsWaistCircumferenceCharacteristicSupported;
    }

    /**
     * check Hip Circumference characteristic
     *
     * @return {@code true}:Hip Circumference characteristic is exist, {@code false}:Hip Circumference characteristic is not exist or service not ready
     */
    public boolean isHipCircumferenceCharacteristicSupported() {
        return mIsHipCircumferenceCharacteristicSupported;
    }

    /**
     * check Fat Burn Heart Rate Lower Limit characteristic
     *
     * @return {@code true}:Fat Burn Heart Rate Lower Limit characteristic is exist, {@code false}:Fat Burn Heart Rate Lower Limit characteristic is not exist or service not ready
     */
    public boolean isFatBurnHeartRateLowerLimitCharacteristicSupported() {
        return mIsFatBurnHeartRateLowerLimitCharacteristicSupported;
    }

    /**
     * check Fat Burn Heart Rate Upper Limit characteristic
     *
     * @return {@code true}:Fat Burn Heart Rate Upper Limit characteristic is exist, {@code false}:Fat Burn Heart Rate Upper Limit characteristic is not exist or service not ready
     */
    public boolean isFatBurnHeartRateUpperLimitCharacteristicSupported() {
        return mIsFatBurnHeartRateUpperLimitCharacteristicSupported;
    }

    /**
     * check Aerobic Heart Rate Lower Limit characteristic
     *
     * @return {@code true}:Aerobic Heart Rate Lower Limit characteristic is exist, {@code false}:Aerobic Heart Rate Lower Limit characteristic is not exist or service not ready
     */
    public boolean isAerobicHeartRateLowerLimitCharacteristicSupported() {
        return mIsAerobicHeartRateLowerLimitCharacteristicSupported;
    }

    /**
     * check Aerobic Heart Rate Upper Limit characteristic
     *
     * @return {@code true}:Aerobic Heart Rate Upper Limit characteristic is exist, {@code false}:Aerobic Heart Rate Upper Limit characteristic is not exist or service not ready
     */
    public boolean isAerobicHeartRateUpperLimitCharacteristicSupported() {
        return mIsAerobicHeartRateUpperLimitCharacteristicSupported;
    }

    /**
     * check Anaerobic Heart Rate Lower Limit characteristic
     *
     * @return {@code true}:Anaerobic Heart Rate Lower Limit characteristic is exist, {@code false}:Anaerobic Heart Rate Lower Limit characteristic is not exist or service not ready
     */
    public boolean isAnaerobicHeartRateLowerLimitCharacteristicSupported() {
        return mIsAnaerobicHeartRateLowerLimitCharacteristicSupported;
    }

    /**
     * check Anaerobic Heart Rate Upper Limit characteristic
     *
     * @return {@code true}:Anaerobic Heart Rate Upper Limit characteristic is exist, {@code false}:Anaerobic Heart Rate Upper Limit characteristic is not exist or service not ready
     */
    public boolean isAnaerobicHeartRateUpperLimitCharacteristicSupported() {
        return mIsAnaerobicHeartRateUpperLimitCharacteristicSupported;
    }

    /**
     * check Five Zone Heart Rate Limits characteristic
     *
     * @return {@code true}:Five Zone Heart Rate Limits characteristic is exist, {@code false}:Five Zone Heart Rate Limits characteristic is not exist or service not ready
     */
    public boolean isFiveZoneHeartRateLimitsCharacteristicSupported() {
        return mIsFiveZoneHeartRateLimitsCharacteristicSupported;
    }

    /**
     * check Three Zone Heart Rate Limits characteristic
     *
     * @return {@code true}:Three Zone Heart Rate Limits characteristic is exist, {@code false}:Three Zone Heart Rate Limits characteristic is not exist or service not ready
     */
    public boolean isThreeZoneHeartRateLimitsCharacteristicSupported() {
        return mIsThreeZoneHeartRateLimitsCharacteristicSupported;
    }

    /**
     * check Two Zone Heart Rate Limit characteristic
     *
     * @return {@code true}:Two Zone Heart Rate Limit characteristic is exist, {@code false}:Two Zone Heart Rate Limit characteristic is not exist or service not ready
     */
    public boolean isTwoZoneHeartRateLimitCharacteristicSupported() {
        return mIsTwoZoneHeartRateLimitCharacteristicSupported;
    }

    /**
     * check Language characteristic
     *
     * @return {@code true}:Language characteristic is exist, {@code false}:Language characteristic is not exist or service not ready
     */
    public boolean isLanguageCharacteristicSupported() {
        return mIsLanguageCharacteristicSupported;
    }

    /**
     * Database Change Increment characteristic notificatable flag
     * <p>
     * {@code true}:Database Change Increment is notificatable, {@code false}:Database Change Increment characteristic is not notificatable or service not ready
     */
    public boolean isDatabaseChangeIncrementCharacteristicNotifySupported() {
        return mIsDatabaseChangeIncrementCharacteristicNotifySupported;
    }

    /**
     * get First Name
     *
     * @return task id. if {@code null} returned, service is not ready
     * @see UserDataServiceCallback#onFirstNameReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, FirstNameAndroid, Bundle)
     * @see UserDataServiceCallback#onFirstNameReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, int, Bundle)
     * @see UserDataServiceCallback#onFirstNameReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getFirstName() {
        Integer taskId = null;
        if (isStarted() && isFirstNameCharacteristicSupported()) {
            taskId = mBLEConnection.createReadCharacteristicTask(USER_DATA_SERVICE, null, FIRST_NAME_CHARACTERISTIC, null, ReadCharacteristicTask.TIMEOUT_MILLIS, null, this);
        }
        return taskId;
    }

    /**
     * set First Name
     *
     * @return task id. if {@code null} returned, service is not ready
     * @see UserDataServiceCallback#onFirstNameWriteSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, FirstNameAndroid, Bundle)
     * @see UserDataServiceCallback#onFirstNameWriteFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, int, Bundle)
     * @see UserDataServiceCallback#onFirstNameWriteTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer setFirstName(@NonNull FirstName firstName) {
        Integer taskId = null;
        if (isStarted() && isFirstNameCharacteristicSupported()) {
            taskId = mBLEConnection.createWriteCharacteristicTask(USER_DATA_SERVICE, null, FIRST_NAME_CHARACTERISTIC, null, firstName, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, WriteCharacteristicTask.TIMEOUT_MILLIS, null, this);
        }
        return taskId;
    }

    /**
     * get Last Name
     *
     * @return task id. if {@code null} returned, service is not ready
     * @see UserDataServiceCallback#onLastNameReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, LastNameAndroid, Bundle)
     * @see UserDataServiceCallback#onLastNameReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, int, Bundle)
     * @see UserDataServiceCallback#onLastNameReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getLastName() {
        Integer taskId = null;
        if (isStarted() && isLastNameCharacteristicSupported()) {
            taskId = mBLEConnection.createReadCharacteristicTask(USER_DATA_SERVICE, null, LAST_NAME_CHARACTERISTIC, null, ReadCharacteristicTask.TIMEOUT_MILLIS, null, this);
        }
        return taskId;
    }

    /**
     * set Last Name
     *
     * @return task id. if {@code null} returned, service is not ready
     * @see UserDataServiceCallback#onLastNameWriteSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, LastNameAndroid, Bundle)
     * @see UserDataServiceCallback#onLastNameWriteFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, int, Bundle)
     * @see UserDataServiceCallback#onLastNameWriteTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer setLastName(@NonNull LastName lastName) {
        Integer taskId = null;
        if (isStarted() && isLastNameCharacteristicSupported()) {
            taskId = mBLEConnection.createWriteCharacteristicTask(USER_DATA_SERVICE, null, LAST_NAME_CHARACTERISTIC, null, lastName, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, WriteCharacteristicTask.TIMEOUT_MILLIS, null, this);
        }
        return taskId;
    }

    /**
     * get Email Address
     *
     * @return task id. if {@code null} returned, service is not ready
     * @see UserDataServiceCallback#onEmailAddressReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, EmailAddressAndroid, Bundle)
     * @see UserDataServiceCallback#onEmailAddressReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, int, Bundle)
     * @see UserDataServiceCallback#onEmailAddressReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getEmailAddress() {
        Integer taskId = null;
        if (isStarted() && isEmailAddressCharacteristicSupported()) {
            taskId = mBLEConnection.createReadCharacteristicTask(USER_DATA_SERVICE, null, EMAIL_ADDRESS_CHARACTERISTIC, null, ReadCharacteristicTask.TIMEOUT_MILLIS, null, this);
        }
        return taskId;
    }

    /**
     * set Email Address
     *
     * @return task id. if {@code null} returned, service is not ready
     * @see UserDataServiceCallback#onEmailAddressWriteSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, EmailAddressAndroid, Bundle)
     * @see UserDataServiceCallback#onEmailAddressWriteFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, int, Bundle)
     * @see UserDataServiceCallback#onEmailAddressWriteTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer setEmailAddress(@NonNull EmailAddress emailAddress) {
        Integer taskId = null;
        if (isStarted() && isEmailAddressCharacteristicSupported()) {
            taskId = mBLEConnection.createWriteCharacteristicTask(USER_DATA_SERVICE, null, EMAIL_ADDRESS_CHARACTERISTIC, null, emailAddress, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, WriteCharacteristicTask.TIMEOUT_MILLIS, null, this);
        }
        return taskId;
    }

    /**
     * get Age
     *
     * @return task id. if {@code null} returned, service is not ready
     * @see UserDataServiceCallback#onAgeReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, AgeAndroid, Bundle)
     * @see UserDataServiceCallback#onAgeReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, int, Bundle)
     * @see UserDataServiceCallback#onAgeReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getAge() {
        Integer taskId = null;
        if (isStarted() && isAgeCharacteristicSupported()) {
            taskId = mBLEConnection.createReadCharacteristicTask(USER_DATA_SERVICE, null, AGE_CHARACTERISTIC, null, ReadCharacteristicTask.TIMEOUT_MILLIS, null, this);
        }
        return taskId;
    }

    /**
     * set Age
     *
     * @return task id. if {@code null} returned, service is not ready
     * @see UserDataServiceCallback#onAgeWriteSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, AgeAndroid, Bundle)
     * @see UserDataServiceCallback#onAgeWriteFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, int, Bundle)
     * @see UserDataServiceCallback#onAgeWriteTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer setAge(@NonNull Age age) {
        Integer taskId = null;
        if (isStarted() && isAgeCharacteristicSupported()) {
            taskId = mBLEConnection.createWriteCharacteristicTask(USER_DATA_SERVICE, null, AGE_CHARACTERISTIC, null, age, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, WriteCharacteristicTask.TIMEOUT_MILLIS, null, this);
        }
        return taskId;
    }

    /**
     * get Date of Birth
     *
     * @return task id. if {@code null} returned, service is not ready
     * @see UserDataServiceCallback#onDateOfBirthReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, DateOfBirthAndroid, Bundle)
     * @see UserDataServiceCallback#onDateOfBirthReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, int, Bundle)
     * @see UserDataServiceCallback#onDateOfBirthReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getDateOfBirth() {
        Integer taskId = null;
        if (isStarted() && isDateOfBirthCharacteristicSupported()) {
            taskId = mBLEConnection.createReadCharacteristicTask(USER_DATA_SERVICE, null, DATE_OF_BIRTH_CHARACTERISTIC, null, ReadCharacteristicTask.TIMEOUT_MILLIS, null, this);
        }
        return taskId;
    }

    /**
     * set Date of Birth
     *
     * @return task id. if {@code null} returned, service is not ready
     * @see UserDataServiceCallback#onDateOfBirthWriteSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, DateOfBirthAndroid, Bundle)
     * @see UserDataServiceCallback#onDateOfBirthWriteFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, int, Bundle)
     * @see UserDataServiceCallback#onDateOfBirthWriteTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer setDateOfBirth(@NonNull DateOfBirth dateOfBirth) {
        Integer taskId = null;
        if (isStarted() && isDateOfBirthCharacteristicSupported()) {
            taskId = mBLEConnection.createWriteCharacteristicTask(USER_DATA_SERVICE, null, DATE_OF_BIRTH_CHARACTERISTIC, null, dateOfBirth, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, WriteCharacteristicTask.TIMEOUT_MILLIS, null, this);
        }
        return taskId;
    }

    /**
     * get Gender
     *
     * @return task id. if {@code null} returned, service is not ready
     * @see UserDataServiceCallback#onGenderReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, GenderAndroid, Bundle)
     * @see UserDataServiceCallback#onGenderReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, int, Bundle)
     * @see UserDataServiceCallback#onGenderReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getGender() {
        Integer taskId = null;
        if (isStarted() && isGenderCharacteristicSupported()) {
            taskId = mBLEConnection.createReadCharacteristicTask(USER_DATA_SERVICE, null, GENDER_CHARACTERISTIC, null, ReadCharacteristicTask.TIMEOUT_MILLIS, null, this);
        }
        return taskId;
    }

    /**
     * set Gender
     *
     * @return task id. if {@code null} returned, service is not ready
     * @see UserDataServiceCallback#onGenderWriteSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, GenderAndroid, Bundle)
     * @see UserDataServiceCallback#onGenderWriteFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, int, Bundle)
     * @see UserDataServiceCallback#onGenderWriteTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer setGender(@NonNull Gender gender) {
        Integer taskId = null;
        if (isStarted() && isGenderCharacteristicSupported()) {
            taskId = mBLEConnection.createWriteCharacteristicTask(USER_DATA_SERVICE, null, GENDER_CHARACTERISTIC, null, gender, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, WriteCharacteristicTask.TIMEOUT_MILLIS, null, this);
        }
        return taskId;
    }

    /**
     * get Weight
     *
     * @return task id. if {@code null} returned, service is not ready
     * @see UserDataServiceCallback#onWeightReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, WeightAndroid, Bundle)
     * @see UserDataServiceCallback#onWeightReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, int, Bundle)
     * @see UserDataServiceCallback#onWeightReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getWeight() {
        Integer taskId = null;
        if (isStarted() && isWeightCharacteristicSupported()) {
            taskId = mBLEConnection.createReadCharacteristicTask(USER_DATA_SERVICE, null, WEIGHT_CHARACTERISTIC, null, ReadCharacteristicTask.TIMEOUT_MILLIS, null, this);
        }
        return taskId;
    }

    /**
     * set Weight
     *
     * @return task id. if {@code null} returned, service is not ready
     * @see UserDataServiceCallback#onWeightWriteSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, WeightAndroid, Bundle)
     * @see UserDataServiceCallback#onWeightWriteFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, int, Bundle)
     * @see UserDataServiceCallback#onWeightWriteTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer setWeight(@NonNull Weight weight) {
        Integer taskId = null;
        if (isStarted() && isWeightCharacteristicSupported()) {
            taskId = mBLEConnection.createWriteCharacteristicTask(USER_DATA_SERVICE, null, WEIGHT_CHARACTERISTIC, null, weight, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, WriteCharacteristicTask.TIMEOUT_MILLIS, null, this);
        }
        return taskId;
    }

    /**
     * get Height
     *
     * @return task id. if {@code null} returned, service is not ready
     * @see UserDataServiceCallback#onHeightReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, HeightAndroid, Bundle)
     * @see UserDataServiceCallback#onHeightReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, int, Bundle)
     * @see UserDataServiceCallback#onHeightReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getHeight() {
        Integer taskId = null;
        if (isStarted() && isHeightCharacteristicSupported()) {
            taskId = mBLEConnection.createReadCharacteristicTask(USER_DATA_SERVICE, null, HEIGHT_CHARACTERISTIC, null, ReadCharacteristicTask.TIMEOUT_MILLIS, null, this);
        }
        return taskId;
    }

    /**
     * set Height
     *
     * @return task id. if {@code null} returned, service is not ready
     * @see UserDataServiceCallback#onHeightWriteSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, HeightAndroid, Bundle)
     * @see UserDataServiceCallback#onHeightWriteFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, int, Bundle)
     * @see UserDataServiceCallback#onHeightWriteTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer setHeight(@NonNull Height height) {
        Integer taskId = null;
        if (isStarted() && isHeightCharacteristicSupported()) {
            taskId = mBLEConnection.createWriteCharacteristicTask(USER_DATA_SERVICE, null, HEIGHT_CHARACTERISTIC, null, height, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, WriteCharacteristicTask.TIMEOUT_MILLIS, null, this);
        }
        return taskId;
    }

    /**
     * get VO2 Max
     *
     * @return task id. if {@code null} returned, service is not ready
     * @see UserDataServiceCallback#onVO2MaxReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, VO2MaxAndroid, Bundle)
     * @see UserDataServiceCallback#onVO2MaxReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, int, Bundle)
     * @see UserDataServiceCallback#onVO2MaxReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getVO2Max() {
        Integer taskId = null;
        if (isStarted() && isVO2MaxCharacteristicSupported()) {
            taskId = mBLEConnection.createReadCharacteristicTask(USER_DATA_SERVICE, null, VO2_MAX_CHARACTERISTIC, null, ReadCharacteristicTask.TIMEOUT_MILLIS, null, this);
        }
        return taskId;
    }

    /**
     * set VO2 Max
     *
     * @return task id. if {@code null} returned, service is not ready
     * @see UserDataServiceCallback#onVO2MaxWriteSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, VO2MaxAndroid, Bundle)
     * @see UserDataServiceCallback#onVO2MaxWriteFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, int, Bundle)
     * @see UserDataServiceCallback#onVO2MaxWriteTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer setVO2Max(@NonNull VO2Max vo2Max) {
        Integer taskId = null;
        if (isStarted() && isVO2MaxCharacteristicSupported()) {
            taskId = mBLEConnection.createWriteCharacteristicTask(USER_DATA_SERVICE, null, VO2_MAX_CHARACTERISTIC, null, vo2Max, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, WriteCharacteristicTask.TIMEOUT_MILLIS, null, this);
        }
        return taskId;
    }

    /**
     * get Heart Rate Max
     *
     * @return task id. if {@code null} returned, service is not ready
     * @see UserDataServiceCallback#onHeartRateMaxReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, HeartRateMaxAndroid, Bundle)
     * @see UserDataServiceCallback#onHeartRateMaxReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, int, Bundle)
     * @see UserDataServiceCallback#onHeartRateMaxReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getHeartRateMax() {
        Integer taskId = null;
        if (isStarted() && isHeartRateMaxCharacteristicSupported()) {
            taskId = mBLEConnection.createReadCharacteristicTask(USER_DATA_SERVICE, null, HEART_RATE_MAX_CHARACTERISTIC, null, ReadCharacteristicTask.TIMEOUT_MILLIS, null, this);
        }
        return taskId;
    }

    /**
     * set Heart Rate Max
     *
     * @return task id. if {@code null} returned, service is not ready
     * @see UserDataServiceCallback#onHeartRateMaxWriteSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, HeartRateMaxAndroid, Bundle)
     * @see UserDataServiceCallback#onHeartRateMaxWriteFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, int, Bundle)
     * @see UserDataServiceCallback#onHeartRateMaxWriteTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, long, Bundle)
     */
    @Nullable
    public Integer setHeartRateMax(@NonNull HeartRateMax heartRateMax) {
        Integer taskId = null;
        if (isStarted() && isHeartRateMaxCharacteristicSupported()) {
            taskId = mBLEConnection.createWriteCharacteristicTask(USER_DATA_SERVICE, null, HEART_RATE_MAX_CHARACTERISTIC, null, heartRateMax, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, WriteCharacteristicTask.TIMEOUT_MILLIS, null, this);
        }
        return taskId;
    }

    /**
     * get Resting Heart Rate
     *
     * @return task id. if {@code null} returned, service is not ready
     * @see UserDataServiceCallback#onRestingHeartRateReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, RestingHeartRateAndroid, Bundle)
     * @see UserDataServiceCallback#onRestingHeartRateReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, int, Bundle)
     * @see UserDataServiceCallback#onRestingHeartRateReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getRestingHeartRate() {
        Integer taskId = null;
        if (isStarted() && isRestingHeartRateCharacteristicSupported()) {
            taskId = mBLEConnection.createReadCharacteristicTask(USER_DATA_SERVICE, null, RESTING_HEART_RATE_CHARACTERISTIC, null, ReadCharacteristicTask.TIMEOUT_MILLIS, null, this);
        }
        return taskId;
    }

    /**
     * set Resting Heart Rate
     *
     * @return task id. if {@code null} returned, service is not ready
     * @see UserDataServiceCallback#onRestingHeartRateWriteSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, RestingHeartRateAndroid, Bundle)
     * @see UserDataServiceCallback#onRestingHeartRateWriteFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, int, Bundle)
     * @see UserDataServiceCallback#onRestingHeartRateWriteTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer setRestingHeartRate(@NonNull RestingHeartRate restingHeartRate) {
        Integer taskId = null;
        if (isStarted() && isRestingHeartRateCharacteristicSupported()) {
            taskId = mBLEConnection.createWriteCharacteristicTask(USER_DATA_SERVICE, null, RESTING_HEART_RATE_CHARACTERISTIC, null, restingHeartRate, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, WriteCharacteristicTask.TIMEOUT_MILLIS, null, this);
        }
        return taskId;
    }

    /**
     * get Maximum Recommended Heart Rate
     *
     * @return task id. if {@code null} returned, service is not ready
     * @see UserDataServiceCallback#onMaximumRecommendedHeartRateReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, MaximumRecommendedHeartRateAndroid, Bundle)
     * @see UserDataServiceCallback#onMaximumRecommendedHeartRateReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, int, Bundle)
     * @see UserDataServiceCallback#onMaximumRecommendedHeartRateReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getMaximumRecommendedHeartRate() {
        Integer taskId = null;
        if (isStarted() && isMaximumRecommendedHeartRateCharacteristicSupported()) {
            taskId = mBLEConnection.createReadCharacteristicTask(USER_DATA_SERVICE, null, MAXIMUM_RECOMMENDED_HEART_RATE_CHARACTERISTIC, null, ReadCharacteristicTask.TIMEOUT_MILLIS, null, this);
        }
        return taskId;
    }

    /**
     * set Maximum Recommended Heart Rate
     *
     * @return task id. if {@code null} returned, service is not ready
     * @see UserDataServiceCallback#onMaximumRecommendedHeartRateWriteSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, MaximumRecommendedHeartRateAndroid, Bundle)
     * @see UserDataServiceCallback#onMaximumRecommendedHeartRateWriteFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, int, Bundle)
     * @see UserDataServiceCallback#onMaximumRecommendedHeartRateWriteTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer setMaximumRecommendedHeartRate(@NonNull MaximumRecommendedHeartRate maximumRecommendedHeartRate) {
        Integer taskId = null;
        if (isStarted() && isMaximumRecommendedHeartRateCharacteristicSupported()) {
            taskId = mBLEConnection.createWriteCharacteristicTask(USER_DATA_SERVICE, null, MAXIMUM_RECOMMENDED_HEART_RATE_CHARACTERISTIC, null, maximumRecommendedHeartRate, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, WriteCharacteristicTask.TIMEOUT_MILLIS, null, this);
        }
        return taskId;
    }

    /**
     * get Aerobic Threshold
     *
     * @return task id. if {@code null} returned, service is not ready
     * @see UserDataServiceCallback#onAerobicThresholdReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, AerobicThresholdAndroid, Bundle)
     * @see UserDataServiceCallback#onAerobicThresholdReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, int, Bundle)
     * @see UserDataServiceCallback#onAerobicThresholdReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getAerobicThreshold() {
        Integer taskId = null;
        if (isStarted() && isAerobicThresholdCharacteristicSupported()) {
            taskId = mBLEConnection.createReadCharacteristicTask(USER_DATA_SERVICE, null, AEROBIC_THRESHOLD_CHARACTERISTIC, null, ReadCharacteristicTask.TIMEOUT_MILLIS, null, this);
        }
        return taskId;
    }

    /**
     * set Aerobic Threshold
     *
     * @return task id. if {@code null} returned, service is not ready
     * @see UserDataServiceCallback#onAerobicThresholdWriteSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, AerobicThresholdAndroid, Bundle)
     * @see UserDataServiceCallback#onAerobicThresholdWriteFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, int, Bundle)
     * @see UserDataServiceCallback#onAerobicThresholdWriteTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer setAerobicThreshold(@NonNull AerobicThreshold aerobicThreshold) {
        Integer taskId = null;
        if (isStarted() && isAerobicThresholdCharacteristicSupported()) {
            taskId = mBLEConnection.createWriteCharacteristicTask(USER_DATA_SERVICE, null, AEROBIC_THRESHOLD_CHARACTERISTIC, null, aerobicThreshold, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, WriteCharacteristicTask.TIMEOUT_MILLIS, null, this);
        }
        return taskId;
    }

    /**
     * get Anaerobic Threshold
     *
     * @return task id. if {@code null} returned, service is not ready
     * @see UserDataServiceCallback#onAnaerobicThresholdReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, AnaerobicThresholdAndroid, Bundle)
     * @see UserDataServiceCallback#onAnaerobicThresholdReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, int, Bundle)
     * @see UserDataServiceCallback#onAnaerobicThresholdReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getAnaerobicThreshold() {
        Integer taskId = null;
        if (isStarted() && isAnaerobicThresholdCharacteristicSupported()) {
            taskId = mBLEConnection.createReadCharacteristicTask(USER_DATA_SERVICE, null, ANAEROBIC_THRESHOLD_CHARACTERISTIC, null, ReadCharacteristicTask.TIMEOUT_MILLIS, null, this);
        }
        return taskId;
    }

    /**
     * set Anaerobic Threshold
     *
     * @return task id. if {@code null} returned, service is not ready
     * @see UserDataServiceCallback#onAnaerobicThresholdWriteSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, AnaerobicThresholdAndroid, Bundle)
     * @see UserDataServiceCallback#onAnaerobicThresholdWriteFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, int, Bundle)
     * @see UserDataServiceCallback#onAnaerobicThresholdWriteTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer setAnaerobicThreshold(@NonNull AnaerobicThreshold anaerobicThreshold) {
        Integer taskId = null;
        if (isStarted() && isAnaerobicThresholdCharacteristicSupported()) {
            taskId = mBLEConnection.createWriteCharacteristicTask(USER_DATA_SERVICE, null, ANAEROBIC_THRESHOLD_CHARACTERISTIC, null, anaerobicThreshold, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, WriteCharacteristicTask.TIMEOUT_MILLIS, null, this);
        }
        return taskId;
    }

    /**
     * get Sport Type for Aerobic and Anaerobic Thresholds
     *
     * @return task id. if {@code null} returned, service is not ready
     * @see UserDataServiceCallback#onSportTypeForAerobicAndAnaerobicThresholdsReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, SportTypeForAerobicAndAnaerobicThresholdsAndroid, Bundle)
     * @see UserDataServiceCallback#onSportTypeForAerobicAndAnaerobicThresholdsReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, int, Bundle)
     * @see UserDataServiceCallback#onSportTypeForAerobicAndAnaerobicThresholdsReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getSportTypeForAerobicAndAnaerobicThresholds() {
        Integer taskId = null;
        if (isStarted() && isSportTypeForAerobicAndAnaerobicThresholdsCharacteristicSupported()) {
            taskId = mBLEConnection.createReadCharacteristicTask(USER_DATA_SERVICE, null, SPORT_TYPE_FOR_AEROBIC_AND_ANAEROBIC_THRESHOLDS_CHARACTERISTIC, null, ReadCharacteristicTask.TIMEOUT_MILLIS, null, this);
        }
        return taskId;
    }

    /**
     * set Sport Type for Aerobic and Anaerobic Thresholds
     *
     * @return task id. if {@code null} returned, service is not ready
     * @see UserDataServiceCallback#onSportTypeForAerobicAndAnaerobicThresholdsWriteSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, SportTypeForAerobicAndAnaerobicThresholdsAndroid, Bundle)
     * @see UserDataServiceCallback#onSportTypeForAerobicAndAnaerobicThresholdsWriteFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, int, Bundle)
     * @see UserDataServiceCallback#onSportTypeForAerobicAndAnaerobicThresholdsWriteTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer setSportTypeForAerobicAndAnaerobicThresholds(@NonNull SportTypeForAerobicAndAnaerobicThresholds sportTypeForAerobicAndAnaerobicThresholds) {
        Integer taskId = null;
        if (isStarted() && isSportTypeForAerobicAndAnaerobicThresholdsCharacteristicSupported()) {
            taskId = mBLEConnection.createWriteCharacteristicTask(USER_DATA_SERVICE, null, SPORT_TYPE_FOR_AEROBIC_AND_ANAEROBIC_THRESHOLDS_CHARACTERISTIC, null, sportTypeForAerobicAndAnaerobicThresholds, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, WriteCharacteristicTask.TIMEOUT_MILLIS, null, this);
        }
        return taskId;
    }

    /**
     * get Date of Threshold Assessment
     *
     * @return task id. if {@code null} returned, service is not ready
     * @see UserDataServiceCallback#onDateOfThresholdAssessmentReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, DateOfThresholdAssessmentAndroid, Bundle)
     * @see UserDataServiceCallback#onDateOfThresholdAssessmentReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, int, Bundle)
     * @see UserDataServiceCallback#onDateOfThresholdAssessmentReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getDateOfThresholdAssessment() {
        Integer taskId = null;
        if (isStarted() && isDateOfThresholdAssessmentCharacteristicSupported()) {
            taskId = mBLEConnection.createReadCharacteristicTask(USER_DATA_SERVICE, null, DATE_OF_THRESHOLD_ASSESSMENT_CHARACTERISTIC, null, ReadCharacteristicTask.TIMEOUT_MILLIS, null, this);
        }
        return taskId;
    }

    /**
     * set Date of Threshold Assessment
     *
     * @return task id. if {@code null} returned, service is not ready
     * @see UserDataServiceCallback#onDateOfThresholdAssessmentWriteSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, DateOfThresholdAssessmentAndroid, Bundle)
     * @see UserDataServiceCallback#onDateOfThresholdAssessmentWriteFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, int, Bundle)
     * @see UserDataServiceCallback#onDateOfThresholdAssessmentWriteTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer setDateOfThresholdAssessment(@NonNull DateOfThresholdAssessment dateOfThresholdAssessment) {
        Integer taskId = null;
        if (isStarted() && isDateOfThresholdAssessmentCharacteristicSupported()) {
            taskId = mBLEConnection.createWriteCharacteristicTask(USER_DATA_SERVICE, null, DATE_OF_THRESHOLD_ASSESSMENT_CHARACTERISTIC, null, dateOfThresholdAssessment, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, WriteCharacteristicTask.TIMEOUT_MILLIS, null, this);
        }
        return taskId;
    }

    /**
     * get Waist Circumference
     *
     * @return task id. if {@code null} returned, service is not ready
     * @see UserDataServiceCallback#onWaistCircumferenceReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, WaistCircumferenceAndroid, Bundle)
     * @see UserDataServiceCallback#onWaistCircumferenceReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, int, Bundle)
     * @see UserDataServiceCallback#onWaistCircumferenceReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getWaistCircumference() {
        Integer taskId = null;
        if (isStarted() && isWaistCircumferenceCharacteristicSupported()) {
            taskId = mBLEConnection.createReadCharacteristicTask(USER_DATA_SERVICE, null, WAIST_CIRCUMFERENCE_CHARACTERISTIC, null, ReadCharacteristicTask.TIMEOUT_MILLIS, null, this);
        }
        return taskId;
    }

    /**
     * set Waist Circumference
     *
     * @return task id. if {@code null} returned, service is not ready
     * @see UserDataServiceCallback#onWaistCircumferenceWriteSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, WaistCircumferenceAndroid, Bundle)
     * @see UserDataServiceCallback#onWaistCircumferenceWriteFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, int, Bundle)
     * @see UserDataServiceCallback#onWaistCircumferenceWriteTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer setWaistCircumference(@NonNull WaistCircumference waistCircumference) {
        Integer taskId = null;
        if (isStarted() && isWaistCircumferenceCharacteristicSupported()) {
            taskId = mBLEConnection.createWriteCharacteristicTask(USER_DATA_SERVICE, null, WAIST_CIRCUMFERENCE_CHARACTERISTIC, null, waistCircumference, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, WriteCharacteristicTask.TIMEOUT_MILLIS, null, this);
        }
        return taskId;
    }

    /**
     * get Hip Circumference
     *
     * @return task id. if {@code null} returned, service is not ready
     * @see UserDataServiceCallback#onHipCircumferenceReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, HipCircumferenceAndroid, Bundle)
     * @see UserDataServiceCallback#onHipCircumferenceReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, int, Bundle)
     * @see UserDataServiceCallback#onHipCircumferenceReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getHipCircumference() {
        Integer taskId = null;
        if (isStarted() && isHipCircumferenceCharacteristicSupported()) {
            taskId = mBLEConnection.createReadCharacteristicTask(USER_DATA_SERVICE, null, HIP_CIRCUMFERENCE_CHARACTERISTIC, null, ReadCharacteristicTask.TIMEOUT_MILLIS, null, this);
        }
        return taskId;
    }

    /**
     * set Hip Circumference
     *
     * @return task id. if {@code null} returned, service is not ready
     * @see UserDataServiceCallback#onHipCircumferenceWriteSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, HipCircumferenceAndroid, Bundle)
     * @see UserDataServiceCallback#onHipCircumferenceWriteFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, int, Bundle)
     * @see UserDataServiceCallback#onHipCircumferenceWriteTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer setHipCircumference(@NonNull HipCircumference hipCircumference) {
        Integer taskId = null;
        if (isStarted() && isHipCircumferenceCharacteristicSupported()) {
            taskId = mBLEConnection.createWriteCharacteristicTask(USER_DATA_SERVICE, null, HIP_CIRCUMFERENCE_CHARACTERISTIC, null, hipCircumference, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, WriteCharacteristicTask.TIMEOUT_MILLIS, null, this);
        }
        return taskId;
    }

    /**
     * get Fat Burn Heart Rate Lower Limit
     *
     * @return task id. if {@code null} returned, service is not ready
     * @see UserDataServiceCallback#onFatBurnHeartRateLowerLimitReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, FatBurnHeartRateLowerLimitAndroid, Bundle)
     * @see UserDataServiceCallback#onFatBurnHeartRateLowerLimitReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, int, Bundle)
     * @see UserDataServiceCallback#onFatBurnHeartRateLowerLimitReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getFatBurnHeartRateLowerLimit() {
        Integer taskId = null;
        if (isStarted() && isFatBurnHeartRateLowerLimitCharacteristicSupported()) {
            taskId = mBLEConnection.createReadCharacteristicTask(USER_DATA_SERVICE, null, FAT_BURN_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC, null, ReadCharacteristicTask.TIMEOUT_MILLIS, null, this);
        }
        return taskId;
    }

    /**
     * set Fat Burn Heart Rate Lower Limit
     *
     * @return task id. if {@code null} returned, service is not ready
     * @see UserDataServiceCallback#onFatBurnHeartRateLowerLimitWriteSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, FatBurnHeartRateLowerLimitAndroid, Bundle)
     * @see UserDataServiceCallback#onFatBurnHeartRateLowerLimitWriteFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, int, Bundle)
     * @see UserDataServiceCallback#onFatBurnHeartRateLowerLimitWriteTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer setFatBurnHeartRateLowerLimit(@NonNull FatBurnHeartRateLowerLimit fatBurnHeartRateLowerLimit) {
        Integer taskId = null;
        if (isStarted() && isFatBurnHeartRateLowerLimitCharacteristicSupported()) {
            taskId = mBLEConnection.createWriteCharacteristicTask(USER_DATA_SERVICE, null, FAT_BURN_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC, null, fatBurnHeartRateLowerLimit, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, WriteCharacteristicTask.TIMEOUT_MILLIS, null, this);
        }
        return taskId;
    }

    /**
     * get Fat Burn Heart Rate Upper Limit
     *
     * @return task id. if {@code null} returned, service is not ready
     * @see UserDataServiceCallback#onFatBurnHeartRateLowerLimitReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, FatBurnHeartRateLowerLimitAndroid, Bundle)
     * @see UserDataServiceCallback#onFatBurnHeartRateLowerLimitReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, int, Bundle)
     * @see UserDataServiceCallback#onFatBurnHeartRateLowerLimitReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getFatBurnHeartRateUpperLimit() {
        Integer taskId = null;
        if (isStarted() && isFatBurnHeartRateUpperLimitCharacteristicSupported()) {
            taskId = mBLEConnection.createReadCharacteristicTask(USER_DATA_SERVICE, null, FAT_BURN_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC, null, ReadCharacteristicTask.TIMEOUT_MILLIS, null, this);
        }
        return taskId;
    }

    /**
     * set Fat Burn Heart Rate Upper Limit
     *
     * @return task id. if {@code null} returned, service is not ready
     * @see UserDataServiceCallback#onFatBurnHeartRateLowerLimitWriteSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, FatBurnHeartRateLowerLimitAndroid, Bundle)
     * @see UserDataServiceCallback#onFatBurnHeartRateLowerLimitWriteFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, int, Bundle)
     * @see UserDataServiceCallback#onFatBurnHeartRateLowerLimitWriteTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer setFatBurnHeartRateUpperLimit(@NonNull FatBurnHeartRateUpperLimit fatBurnHeartRateUpperLimit) {
        Integer taskId = null;
        if (isStarted() && isFatBurnHeartRateUpperLimitCharacteristicSupported()) {
            taskId = mBLEConnection.createWriteCharacteristicTask(USER_DATA_SERVICE, null, FAT_BURN_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC, null, fatBurnHeartRateUpperLimit, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, WriteCharacteristicTask.TIMEOUT_MILLIS, null, this);
        }
        return taskId;
    }

    /**
     * get Aerobic Heart Rate Lower Limit
     *
     * @return task id. if {@code null} returned, service is not ready
     * @see UserDataServiceCallback#onAerobicHeartRateLowerLimitReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, AerobicHeartRateLowerLimitAndroid, Bundle)
     * @see UserDataServiceCallback#onAerobicHeartRateLowerLimitReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, int, Bundle)
     * @see UserDataServiceCallback#onAerobicHeartRateLowerLimitReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getAerobicHeartRateLowerLimit() {
        Integer taskId = null;
        if (isStarted() && isAerobicHeartRateLowerLimitCharacteristicSupported()) {
            taskId = mBLEConnection.createReadCharacteristicTask(USER_DATA_SERVICE, null, AEROBIC_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC, null, ReadCharacteristicTask.TIMEOUT_MILLIS, null, this);
        }
        return taskId;
    }

    /**
     * set Aerobic Heart Rate Lower Limit
     *
     * @return task id. if {@code null} returned, service is not ready
     * @see UserDataServiceCallback#onAerobicHeartRateLowerLimitWriteSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, AerobicHeartRateLowerLimitAndroid, Bundle)
     * @see UserDataServiceCallback#onAerobicHeartRateLowerLimitWriteFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, int, Bundle)
     * @see UserDataServiceCallback#onAerobicHeartRateLowerLimitWriteTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer setAerobicHeartRateLowerLimit(@NonNull AerobicHeartRateLowerLimit aerobicHeartRateLowerLimit) {
        Integer taskId = null;
        if (isStarted() && isAerobicHeartRateLowerLimitCharacteristicSupported()) {
            taskId = mBLEConnection.createWriteCharacteristicTask(USER_DATA_SERVICE, null, AEROBIC_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC, null, aerobicHeartRateLowerLimit, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, WriteCharacteristicTask.TIMEOUT_MILLIS, null, this);
        }
        return taskId;
    }

    /**
     * get Aerobic Heart Rate Upper Limit
     *
     * @return task id. if {@code null} returned, service is not ready
     * @see UserDataServiceCallback#onAerobicHeartRateUpperLimitReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, AerobicHeartRateUpperLimitAndroid, Bundle)
     * @see UserDataServiceCallback#onAerobicHeartRateUpperLimitReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, int, Bundle)
     * @see UserDataServiceCallback#onAerobicHeartRateUpperLimitReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getAerobicHeartRateUpperLimit() {
        Integer taskId = null;
        if (isStarted() && isAerobicHeartRateUpperLimitCharacteristicSupported()) {
            taskId = mBLEConnection.createReadCharacteristicTask(USER_DATA_SERVICE, null, AEROBIC_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC, null, ReadCharacteristicTask.TIMEOUT_MILLIS, null, this);
        }
        return taskId;
    }

    /**
     * set Aerobic Heart Rate Upper Limit
     *
     * @return task id. if {@code null} returned, service is not ready
     * @see UserDataServiceCallback#onAerobicHeartRateUpperLimitWriteSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, AerobicHeartRateUpperLimitAndroid, Bundle)
     * @see UserDataServiceCallback#onAerobicHeartRateUpperLimitWriteFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, int, Bundle)
     * @see UserDataServiceCallback#onAerobicHeartRateUpperLimitWriteTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer setAerobicHeartRateUpperLimit(@NonNull AerobicHeartRateUpperLimit aerobicHeartRateUpperLimit) {
        Integer taskId = null;
        if (isStarted() && isAerobicHeartRateUpperLimitCharacteristicSupported()) {
            taskId = mBLEConnection.createWriteCharacteristicTask(USER_DATA_SERVICE, null, AEROBIC_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC, null, aerobicHeartRateUpperLimit, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, WriteCharacteristicTask.TIMEOUT_MILLIS, null, this);
        }
        return taskId;
    }

    /**
     * get Anaerobic Heart Rate Lower Limit
     *
     * @return task id. if {@code null} returned, service is not ready
     * @see UserDataServiceCallback#onAnaerobicHeartRateLowerLimitReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, AnaerobicHeartRateLowerLimitAndroid, Bundle)
     * @see UserDataServiceCallback#onAnaerobicHeartRateLowerLimitReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, int, Bundle)
     * @see UserDataServiceCallback#onAnaerobicHeartRateLowerLimitReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getAnaerobicHeartRateLowerLimit() {
        Integer taskId = null;
        if (isStarted() && isAnaerobicHeartRateLowerLimitCharacteristicSupported()) {
            taskId = mBLEConnection.createReadCharacteristicTask(USER_DATA_SERVICE, null, ANAEROBIC_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC, null, ReadCharacteristicTask.TIMEOUT_MILLIS, null, this);
        }
        return taskId;
    }

    /**
     * set Anaerobic Heart Rate Lower Limit
     *
     * @return task id. if {@code null} returned, service is not ready
     * @see UserDataServiceCallback#onAnaerobicHeartRateLowerLimitWriteSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, AnaerobicHeartRateLowerLimitAndroid, Bundle)
     * @see UserDataServiceCallback#onAnaerobicHeartRateLowerLimitWriteFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, int, Bundle)
     * @see UserDataServiceCallback#onAnaerobicHeartRateLowerLimitWriteTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer setAnaerobicHeartRateLowerLimit(@NonNull AnaerobicHeartRateLowerLimit anaerobicHeartRateLowerLimit) {
        Integer taskId = null;
        if (isStarted() && isAnaerobicHeartRateLowerLimitCharacteristicSupported()) {
            taskId = mBLEConnection.createWriteCharacteristicTask(USER_DATA_SERVICE, null, ANAEROBIC_HEART_RATE_LOWER_LIMIT_CHARACTERISTIC, null, anaerobicHeartRateLowerLimit, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, WriteCharacteristicTask.TIMEOUT_MILLIS, null, this);
        }
        return taskId;
    }

    /**
     * get Anaerobic Heart Rate Upper Limit
     *
     * @return task id. if {@code null} returned, service is not ready
     * @see UserDataServiceCallback#onAnaerobicHeartRateUpperLimitReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, AnaerobicHeartRateUpperLimitAndroid, Bundle)
     * @see UserDataServiceCallback#onAnaerobicHeartRateUpperLimitReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, int, Bundle)
     * @see UserDataServiceCallback#onAnaerobicHeartRateUpperLimitReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getAnaerobicHeartRateUpperLimit() {
        Integer taskId = null;
        if (isStarted() && isAnaerobicHeartRateUpperLimitCharacteristicSupported()) {
            taskId = mBLEConnection.createReadCharacteristicTask(USER_DATA_SERVICE, null, ANAEROBIC_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC, null, ReadCharacteristicTask.TIMEOUT_MILLIS, null, this);
        }
        return taskId;
    }

    /**
     * set Anaerobic Heart Rate Upper Limit
     *
     * @return task id. if {@code null} returned, service is not ready
     * @see UserDataServiceCallback#onAnaerobicHeartRateUpperLimitWriteSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, AnaerobicHeartRateUpperLimitAndroid, Bundle)
     * @see UserDataServiceCallback#onAnaerobicHeartRateUpperLimitWriteFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, int, Bundle)
     * @see UserDataServiceCallback#onAnaerobicHeartRateUpperLimitWriteTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer setAnaerobicHeartRateUpperLimit(@NonNull AnaerobicHeartRateUpperLimit anaerobicHeartRateUpperLimit) {
        Integer taskId = null;
        if (isStarted() && isAnaerobicHeartRateUpperLimitCharacteristicSupported()) {
            taskId = mBLEConnection.createWriteCharacteristicTask(USER_DATA_SERVICE, null, ANAEROBIC_HEART_RATE_UPPER_LIMIT_CHARACTERISTIC, null, anaerobicHeartRateUpperLimit, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, WriteCharacteristicTask.TIMEOUT_MILLIS, null, this);
        }
        return taskId;
    }

    /**
     * get Five Zone Heart Rate Limits
     *
     * @return task id. if {@code null} returned, service is not ready
     * @see UserDataServiceCallback#onFiveZoneHeartRateLimitsReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, FiveZoneHeartRateLimitsAndroid, Bundle)
     * @see UserDataServiceCallback#onFiveZoneHeartRateLimitsReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, int, Bundle)
     * @see UserDataServiceCallback#onFiveZoneHeartRateLimitsReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getFiveZoneHeartRateLimits() {
        Integer taskId = null;
        if (isStarted() && isFiveZoneHeartRateLimitsCharacteristicSupported()) {
            taskId = mBLEConnection.createReadCharacteristicTask(USER_DATA_SERVICE, null, FIVE_ZONE_HEART_RATE_LIMITS_CHARACTERISTIC, null, ReadCharacteristicTask.TIMEOUT_MILLIS, null, this);
        }
        return taskId;
    }

    /**
     * set Five Zone Heart Rate Limits
     *
     * @return task id. if {@code null} returned, service is not ready
     * @see UserDataServiceCallback#onFiveZoneHeartRateLimitsWriteSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, FiveZoneHeartRateLimitsAndroid, Bundle)
     * @see UserDataServiceCallback#onFiveZoneHeartRateLimitsWriteFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, int, Bundle)
     * @see UserDataServiceCallback#onFiveZoneHeartRateLimitsWriteTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer setFiveZoneHeartRateLimits(@NonNull FiveZoneHeartRateLimits fiveZoneHeartRateLimits) {
        Integer taskId = null;
        if (isStarted() && isFiveZoneHeartRateLimitsCharacteristicSupported()) {
            taskId = mBLEConnection.createWriteCharacteristicTask(USER_DATA_SERVICE, null, FIVE_ZONE_HEART_RATE_LIMITS_CHARACTERISTIC, null, fiveZoneHeartRateLimits, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, WriteCharacteristicTask.TIMEOUT_MILLIS, null, this);
        }
        return taskId;
    }

    /**
     * get Three Zone Heart Rate Limits
     *
     * @return task id. if {@code null} returned, service is not ready
     * @see UserDataServiceCallback#onThreeZoneHeartRateLimitsReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, ThreeZoneHeartRateLimitsAndroid, Bundle)
     * @see UserDataServiceCallback#onThreeZoneHeartRateLimitsReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, int, Bundle)
     * @see UserDataServiceCallback#onThreeZoneHeartRateLimitsReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getThreeZoneHeartRateLimits() {
        Integer taskId = null;
        if (isStarted() && isThreeZoneHeartRateLimitsCharacteristicSupported()) {
            taskId = mBLEConnection.createReadCharacteristicTask(USER_DATA_SERVICE, null, THREE_ZONE_HEART_RATE_LIMITS_CHARACTERISTIC, null, ReadCharacteristicTask.TIMEOUT_MILLIS, null, this);
        }
        return taskId;
    }

    /**
     * set Three Zone Heart Rate Limits
     *
     * @return task id. if {@code null} returned, service is not ready
     * @see UserDataServiceCallback#onThreeZoneHeartRateLimitsWriteSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, ThreeZoneHeartRateLimitsAndroid, Bundle)
     * @see UserDataServiceCallback#onThreeZoneHeartRateLimitsWriteFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, int, Bundle)
     * @see UserDataServiceCallback#onThreeZoneHeartRateLimitsWriteTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer setThreeZoneHeartRateLimits(@NonNull ThreeZoneHeartRateLimits threeZoneHeartRateLimits) {
        Integer taskId = null;
        if (isStarted() && isThreeZoneHeartRateLimitsCharacteristicSupported()) {
            taskId = mBLEConnection.createWriteCharacteristicTask(USER_DATA_SERVICE, null, THREE_ZONE_HEART_RATE_LIMITS_CHARACTERISTIC, null, threeZoneHeartRateLimits, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, WriteCharacteristicTask.TIMEOUT_MILLIS, null, this);
        }
        return taskId;
    }

    /**
     * get Two Zone Heart Rate Limit
     *
     * @return task id. if {@code null} returned, service is not ready
     * @see UserDataServiceCallback#onTwoZoneHeartRateLimitReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, TwoZoneHeartRateLimitAndroid, Bundle)
     * @see UserDataServiceCallback#onTwoZoneHeartRateLimitReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, int, Bundle)
     * @see UserDataServiceCallback#onTwoZoneHeartRateLimitReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getTwoZoneHeartRateLimit() {
        Integer taskId = null;
        if (isStarted() && isTwoZoneHeartRateLimitCharacteristicSupported()) {
            taskId = mBLEConnection.createReadCharacteristicTask(USER_DATA_SERVICE, null, TWO_ZONE_HEART_RATE_LIMIT_CHARACTERISTIC, null, ReadCharacteristicTask.TIMEOUT_MILLIS, null, this);
        }
        return taskId;
    }

    /**
     * set Two Zone Heart Rate Limit
     *
     * @return task id. if {@code null} returned, service is not ready
     * @see UserDataServiceCallback#onTwoZoneHeartRateLimitWriteSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, TwoZoneHeartRateLimitAndroid, Bundle)
     * @see UserDataServiceCallback#onTwoZoneHeartRateLimitWriteFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, int, Bundle)
     * @see UserDataServiceCallback#onTwoZoneHeartRateLimitWriteTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer setTwoZoneHeartRateLimit(@NonNull TwoZoneHeartRateLimit twoZoneHeartRateLimit) {
        Integer taskId = null;
        if (isStarted() && isTwoZoneHeartRateLimitCharacteristicSupported()) {
            taskId = mBLEConnection.createWriteCharacteristicTask(USER_DATA_SERVICE, null, TWO_ZONE_HEART_RATE_LIMIT_CHARACTERISTIC, null, twoZoneHeartRateLimit, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, WriteCharacteristicTask.TIMEOUT_MILLIS, null, this);
        }
        return taskId;
    }

    /**
     * get Language
     *
     * @return task id. if {@code null} returned, service is not ready
     * @see UserDataServiceCallback#onLanguageReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, LanguageAndroid, Bundle)
     * @see UserDataServiceCallback#onLanguageReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, int, Bundle)
     * @see UserDataServiceCallback#onLanguageReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getLanguage() {
        Integer taskId = null;
        if (isStarted() && isLanguageCharacteristicSupported()) {
            taskId = mBLEConnection.createReadCharacteristicTask(USER_DATA_SERVICE, null, LANGUAGE_CHARACTERISTIC, null, ReadCharacteristicTask.TIMEOUT_MILLIS, null, this);
        }
        return taskId;
    }

    /**
     * set Language
     *
     * @return task id. if {@code null} returned, service is not ready
     * @see UserDataServiceCallback#onLanguageWriteSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, LanguageAndroid, Bundle)
     * @see UserDataServiceCallback#onLanguageWriteFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, int, Bundle)
     * @see UserDataServiceCallback#onLanguageWriteTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer setLanguage(@NonNull Language language) {
        Integer taskId = null;
        if (isStarted() && isLanguageCharacteristicSupported()) {
            taskId = mBLEConnection.createWriteCharacteristicTask(USER_DATA_SERVICE, null, LANGUAGE_CHARACTERISTIC, null, language, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, WriteCharacteristicTask.TIMEOUT_MILLIS, null, this);
        }
        return taskId;
    }

    /**
     * get Database Change Increment
     *
     * @return task id. if {@code null} returned, service is not ready
     * @see UserDataServiceCallback#onDatabaseChangeIncrementReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, DatabaseChangeIncrementAndroid, Bundle)
     * @see UserDataServiceCallback#onDatabaseChangeIncrementReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, int, Bundle)
     * @see UserDataServiceCallback#onDatabaseChangeIncrementReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getDatabaseChangeIncrement() {
        Integer taskId = null;
        if (isStarted()) {
            taskId = mBLEConnection.createReadCharacteristicTask(USER_DATA_SERVICE, null, DATABASE_CHANGE_INCREMENT_CHARACTERISTIC, null, ReadCharacteristicTask.TIMEOUT_MILLIS, null, this);
        }
        return taskId;
    }

    /**
     * set Database Change Increment
     *
     * @return task id. if {@code null} returned, service is not ready
     * @see UserDataServiceCallback#onDatabaseChangeIncrementWriteSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, DatabaseChangeIncrementAndroid, Bundle)
     * @see UserDataServiceCallback#onDatabaseChangeIncrementWriteFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, int, Bundle)
     * @see UserDataServiceCallback#onDatabaseChangeIncrementWriteTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer setDatabaseChangeIncrement(@NonNull DatabaseChangeIncrement databaseChangeIncrement) {
        Integer taskId = null;
        if (isStarted()) {
            taskId = mBLEConnection.createWriteCharacteristicTask(USER_DATA_SERVICE, null, DATABASE_CHANGE_INCREMENT_CHARACTERISTIC, null, databaseChangeIncrement, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, WriteCharacteristicTask.TIMEOUT_MILLIS, null, this);
        }
        return taskId;
    }

    /**
     * get Database Change Increment's Client Characteristic Configuration
     *
     * @return task id. if {@code null} returned, service is not ready
     * @see UserDataServiceCallback#onDatabaseChangeIncrementClientCharacteristicConfigurationReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, ClientCharacteristicConfigurationAndroid, Bundle)
     * @see UserDataServiceCallback#onDatabaseChangeIncrementClientCharacteristicConfigurationReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, int, Bundle)
     * @see UserDataServiceCallback#onDatabaseChangeIncrementClientCharacteristicConfigurationReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getDatabaseChangeIncrementClientCharacteristicConfiguration() {
        Integer taskId = null;
        if (isStarted() && isDatabaseChangeIncrementCharacteristicNotifySupported()) {
            taskId = mBLEConnection.createReadDescriptorTask(USER_DATA_SERVICE, null, DATABASE_CHANGE_INCREMENT_CHARACTERISTIC, null, CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, null, ReadDescriptorTask.TIMEOUT_MILLIS, null, this);
        }
        return taskId;
    }

    /**
     * start Database Change Increment notification
     *
     * @return task id. if {@code null} returned, service is not ready
     * @see UserDataServiceCallback#onDatabaseChangeIncrementNotifyStartSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Bundle)
     * @see UserDataServiceCallback#onDatabaseChangeIncrementNotifyStartFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, int, Bundle)
     * @see UserDataServiceCallback#onDatabaseChangeIncrementNotifyStartTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer startDatabaseChangeIncrementNotification() {
        Integer taskId = null;
        if (isStarted() && isDatabaseChangeIncrementCharacteristicNotifySupported()) {
            Bundle bundle = new Bundle();
            bundle.putInt(KEY_STATUS, STATUS_START);
            taskId = mBLEConnection.createWriteDescriptorTask(USER_DATA_SERVICE, null, DATABASE_CHANGE_INCREMENT_CHARACTERISTIC, null, CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, null, new ClientCharacteristicConfiguration(BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE), WriteDescriptorTask.TIMEOUT_MILLIS, bundle, this);
        }
        return taskId;
    }

    /**
     * stop Database Change Increment notification
     *
     * @return task id. if {@code null} returned, service is not ready
     * @see UserDataServiceCallback#onDatabaseChangeIncrementNotifyStopSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Bundle)
     * @see UserDataServiceCallback#onDatabaseChangeIncrementNotifyStopFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, int, Bundle)
     * @see UserDataServiceCallback#onDatabaseChangeIncrementNotifyStopTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer stopDatabaseChangeIncrementNotification() {
        Integer taskId = null;
        if (isStarted() && isDatabaseChangeIncrementCharacteristicNotifySupported()) {
            Bundle bundle = new Bundle();
            bundle.putInt(KEY_STATUS, STATUS_STOP);
            taskId = mBLEConnection.createWriteDescriptorTask(USER_DATA_SERVICE, null, DATABASE_CHANGE_INCREMENT_CHARACTERISTIC, null, CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, null, new ClientCharacteristicConfiguration(BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE), WriteDescriptorTask.TIMEOUT_MILLIS, bundle, this);
        }
        return taskId;
    }

    /**
     * get User Index
     *
     * @return task id. if {@code null} returned, service is not ready
     * @see UserDataServiceCallback#onUserIndexReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, UserIndexAndroid, Bundle)
     * @see UserDataServiceCallback#onUserIndexReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, int, Bundle)
     * @see UserDataServiceCallback#onUserIndexReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getUserIndex() {
        Integer taskId = null;
        if (isStarted()) {
            taskId = mBLEConnection.createReadCharacteristicTask(USER_DATA_SERVICE, null, USER_INDEX_CHARACTERISTIC, null, ReadCharacteristicTask.TIMEOUT_MILLIS, null, this);
        }
        return taskId;
    }

    /**
     * get Registered User's Client Characteristic Configuration
     *
     * @return task id. if {@code null} returned, service is not ready
     * @see UserDataServiceCallback#onRegisteredUserClientCharacteristicConfigurationReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, ClientCharacteristicConfigurationAndroid, Bundle)
     * @see UserDataServiceCallback#onRegisteredUserClientCharacteristicConfigurationReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, int, Bundle)
     * @see UserDataServiceCallback#onRegisteredUserClientCharacteristicConfigurationReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getRegisteredUserClientCharacteristicConfiguration() {
        Integer taskId = null;
        if (isStarted()) {
            taskId = mBLEConnection.createReadDescriptorTask(USER_DATA_SERVICE, null, REGISTERED_USER_CHARACTERISTIC, null, CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, null, ReadDescriptorTask.TIMEOUT_MILLIS, null, this);
        }
        return taskId;
    }

    /**
     * start Registered User indication
     *
     * @return task id. if {@code null} returned, service is not ready
     * @see UserDataServiceCallback#onRegisteredUserIndicateStartSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Bundle)
     * @see UserDataServiceCallback#onRegisteredUserIndicateStartFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, int, Bundle)
     * @see UserDataServiceCallback#onRegisteredUserIndicateStartTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer startRegisteredUserIndication() {
        Integer taskId = null;
        if (isStarted()) {
            Bundle bundle = new Bundle();
            bundle.putInt(KEY_STATUS, STATUS_START);
            taskId = mBLEConnection.createWriteDescriptorTask(USER_DATA_SERVICE, null, REGISTERED_USER_CHARACTERISTIC, null, CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, null, new ClientCharacteristicConfiguration(BluetoothGattDescriptor.ENABLE_INDICATION_VALUE), WriteDescriptorTask.TIMEOUT_MILLIS, bundle, this);
        }
        return taskId;
    }

    /**
     * stop Registered User indication
     *
     * @return task id. if {@code null} returned, service is not ready
     * @see UserDataServiceCallback#onRegisteredUserIndicateStopSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Bundle)
     * @see UserDataServiceCallback#onRegisteredUserIndicateStopFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, int, Bundle)
     * @see UserDataServiceCallback#onRegisteredUserIndicateStopTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer stopRegisteredUserIndication() {
        Integer taskId = null;
        if (isStarted()) {
            Bundle bundle = new Bundle();
            bundle.putInt(KEY_STATUS, STATUS_STOP);
            taskId = mBLEConnection.createWriteDescriptorTask(USER_DATA_SERVICE, null, REGISTERED_USER_CHARACTERISTIC, null, CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, null, new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE), WriteDescriptorTask.TIMEOUT_MILLIS, bundle, this);
        }
        return taskId;
    }

    /**
     * set User Control Point
     *
     * @return task id. if {@code null} returned, service is not ready
     * @see UserDataServiceCallback#onUserControlPointWriteSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, UserControlPointAndroid, Bundle)
     * @see UserDataServiceCallback#onUserControlPointWriteFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, int, Bundle)
     * @see UserDataServiceCallback#onUserControlPointWriteTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer setUserControlPoint(@NonNull UserControlPoint userControlPoint) {
        Integer taskId = null;
        if (isStarted()) {
            taskId = mBLEConnection.createWriteCharacteristicTask(USER_DATA_SERVICE, null, USER_CONTROL_POINT_CHARACTERISTIC, null, userControlPoint, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, WriteCharacteristicTask.TIMEOUT_MILLIS, null, this);
        }
        return taskId;
    }

    /**
     * get User Control Point's Client Characteristic Configuration
     *
     * @return task id. if {@code null} returned, service is not ready
     * @see UserDataServiceCallback#onUserControlPointClientCharacteristicConfigurationReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, ClientCharacteristicConfigurationAndroid, Bundle)
     * @see UserDataServiceCallback#onUserControlPointClientCharacteristicConfigurationReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, int, Bundle)
     * @see UserDataServiceCallback#onUserControlPointClientCharacteristicConfigurationReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getUserControlPointClientCharacteristicConfiguration() {
        Integer taskId = null;
        if (isStarted()) {
            taskId = mBLEConnection.createReadDescriptorTask(USER_DATA_SERVICE, null, USER_CONTROL_POINT_CHARACTERISTIC, null, CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, null, ReadDescriptorTask.TIMEOUT_MILLIS, null, this);
        }
        return taskId;
    }

    /**
     * start User Control Point indication
     *
     * @return task id. if {@code null} returned, service is not ready
     * @see UserDataServiceCallback#onUserControlPointIndicateStartSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Bundle)
     * @see UserDataServiceCallback#onUserControlPointIndicateStartFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, int, Bundle)
     * @see UserDataServiceCallback#onUserControlPointIndicateStartTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer startUserControlPointIndication() {
        Integer taskId = null;
        if (isStarted()) {
            Bundle bundle = new Bundle();
            bundle.putInt(KEY_STATUS, STATUS_START);
            taskId = mBLEConnection.createWriteDescriptorTask(USER_DATA_SERVICE, null, USER_CONTROL_POINT_CHARACTERISTIC, null, CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, null, new ClientCharacteristicConfiguration(BluetoothGattDescriptor.ENABLE_INDICATION_VALUE), WriteDescriptorTask.TIMEOUT_MILLIS, bundle, this);
        }
        return taskId;
    }

    /**
     * stop User Control Point indication
     *
     * @return task id. if {@code null} returned, service is not ready
     * @see UserDataServiceCallback#onUserControlPointIndicateStopSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Bundle)
     * @see UserDataServiceCallback#onUserControlPointIndicateStopFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, int, Bundle)
     * @see UserDataServiceCallback#onUserControlPointIndicateStopTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer stopUserControlPointIndication() {
        Integer taskId = null;
        if (isStarted()) {
            Bundle bundle = new Bundle();
            bundle.putInt(KEY_STATUS, STATUS_STOP);
            taskId = mBLEConnection.createWriteDescriptorTask(USER_DATA_SERVICE, null, USER_CONTROL_POINT_CHARACTERISTIC, null, CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, null, new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE), WriteDescriptorTask.TIMEOUT_MILLIS, bundle, this);
        }
        return taskId;
    }

}
