package org.im97mori.ble.service.uds.peripheral;

import static org.im97mori.ble.constants.ServiceUUID.USER_DATA_SERVICE;

import android.bluetooth.BluetoothGattService;
import android.os.Build;
import android.os.Parcel;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.gson.annotations.SerializedName;

import org.im97mori.ble.CharacteristicData;
import org.im97mori.ble.ServiceData;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * User Data Service data class
 */
public class UserDataServiceData extends ServiceData {

    /**
     * @see Creator
     */
    public static final Creator<UserDataServiceData> CREATOR = new Creator<UserDataServiceData>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        @Deprecated
        public UserDataServiceData createFromParcel(@NonNull Parcel in) {
            //noinspection deprecation
            return new UserDataServiceData(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public UserDataServiceData[] newArray(int size) {
            return new UserDataServiceData[size];
        }

    };

    /**
     * First Name data
     */
    @SerializedName("first_name")
    public UDSCharacteristicData firstName;

    /**
     * Last Name data
     */
    @SerializedName("last_name")
    public UDSCharacteristicData lastName;

    /**
     * Email Address data
     */
    @SerializedName("email_address")
    public UDSCharacteristicData emailAddress;

    /**
     * Age data
     */
    @SerializedName("age")
    public UDSCharacteristicData age;

    /**
     * Date of Birth data
     */
    @SerializedName("date_of_birth")
    public UDSCharacteristicData dateOfBirth;

    /**
     * Gender data
     */
    @SerializedName("gender")
    public UDSCharacteristicData gender;

    /**
     * Weight data
     */
    @SerializedName("weight")
    public UDSCharacteristicData weight;

    /**
     * Height data
     */
    @SerializedName("height")
    public UDSCharacteristicData height;

    /**
     * VO2 Max data
     */
    @SerializedName("vo2_max")
    public UDSCharacteristicData vo2Max;

    /**
     * Heart Rate Max data
     */
    @SerializedName("heart_rate_max")
    public UDSCharacteristicData heartRateMax;

    /**
     * Resting Heart Rate data
     */
    @SerializedName("resting_heart_rate")
    public UDSCharacteristicData restingHeartRate;

    /**
     * Maximum Recommended Heart Rate data
     */
    @SerializedName("maximum_recommended_heart_rate")
    public UDSCharacteristicData maximumRecommendedHeartRate;

    /**
     * Aerobic Threshold data
     */
    @SerializedName("aerobic_threshold")
    public UDSCharacteristicData aerobicThreshold;

    /**
     * Anaerobic Threshold data
     */
    @SerializedName("anaerobic_threshold")
    public UDSCharacteristicData anaerobicThreshold;

    /**
     * Sport Type for Aerobic and Anaerobic Thresholds data
     */
    @SerializedName("sport_type_for_aerobic_and_anaerobic_thresholds")
    public UDSCharacteristicData sportTypeForAerobicAndAnaerobicThresholds;

    /**
     * Date of Threshold Assessment data
     */
    @SerializedName("date_of_threshold_assessment")
    public UDSCharacteristicData dateOfThresholdAssessment;

    /**
     * Waist Circumference data
     */
    @SerializedName("waist_circumference")
    public UDSCharacteristicData waistCircumference;

    /**
     * Hip Circumference data
     */
    @SerializedName("hip_circumference")
    public UDSCharacteristicData hipCircumference;

    /**
     * Fat Burn Heart Rate Lower Limit data
     */
    @SerializedName("fat_burn_heart_rate_lower_limit")
    public UDSCharacteristicData fatBurnHeartRateLowerLimit;

    /**
     * Fat Burn Heart Rate Upper Limit data
     */
    @SerializedName("fat_burn_heart_rate_upper_limit")
    public UDSCharacteristicData fatBurnHeartRateUpperLimit;

    /**
     * Aerobic Heart Rate Lower Limit data
     */
    @SerializedName("aerobic_heart_rate_lower_limit")
    public UDSCharacteristicData aerobicHeartRateLowerLimit;

    /**
     * Aerobic Heart Rate Upper Limit data
     */
    @SerializedName("aerobic_heart_rate_upper_limit")
    public UDSCharacteristicData aerobicHeartRateUpperLimit;

    /**
     * Anaerobic Heart Rate Lower Limit data
     */
    @SerializedName("anaerobic_heart_rate_lower_limit")
    public UDSCharacteristicData anaerobicHeartRateLowerLimit;

    /**
     * Anaerobic Heart Rate Upper Limit data
     */
    @SerializedName("anaerobic_heart_rate_upper_limit")
    public UDSCharacteristicData anaerobicHeartRateUpperLimit;

    /**
     * Five Zone Heart Rate Limits data
     */
    @SerializedName("five_zone_heart_rate_limits")
    public UDSCharacteristicData fiveZoneHeartRateLimits;

    /**
     * Three Zone Heart Rate Limits data
     */
    @SerializedName("three_zone_heart_rate_limits")
    public UDSCharacteristicData threeZoneHeartRateLimits;

    /**
     * Two Zone Heart Rate Limit data
     */
    @SerializedName("two_zone_heart_rate_limit")
    public UDSCharacteristicData twoZoneHeartRateLimit;

    /**
     * Language data
     */
    @SerializedName("language")
    public UDSCharacteristicData language;

    /**
     * Database Change Increment data
     */
    @SerializedName("database_change_increment")
    public CharacteristicData databaseChangeIncrement;

    /**
     * User Index data
     */
    @SerializedName("user_index_data")
    public CharacteristicData userIndex;

    /**
     * User Control Point data
     */
    @SerializedName("user_control_point")
    public UserControlPointCharacteristicData userControlPoint;

    /**
     * Registered User data
     */
    @SerializedName("registered_user")
    public CharacteristicData registeredUser;

    /**
     * Constructor
     */
    public UserDataServiceData() {
    }

    /**
     * @param firstName                                 First Name data
     * @param lastName                                  Last Name data
     * @param emailAddress                              Email Address data
     * @param age                                       Age data
     * @param dateOfBirth                               Date of Birth data
     * @param gender                                    Gender data
     * @param weight                                    Weight data
     * @param height                                    Height data
     * @param vo2Max                                    VO2 Max data
     * @param heartRateMax                              Heart Rate Max data
     * @param restingHeartRate                          Resting Heart Rate data
     * @param maximumRecommendedHeartRate               Maximum Recommended Heart Rate data
     * @param aerobicThreshold                          Aerobic Threshold data
     * @param anaerobicThreshold                        Anaerobic Threshold data
     * @param sportTypeForAerobicAndAnaerobicThresholds Sport Type for Aerobic and Anaerobic Thresholds data
     * @param dateOfThresholdAssessment                 Date of Threshold Assessment data
     * @param waistCircumference                        Waist Circumference data
     * @param hipCircumference                          Hip Circumference data
     * @param fatBurnHeartRateLowerLimit                Fat Burn Heart Rate Lower Limit data
     * @param fatBurnHeartRateUpperLimit                Fat Burn Heart Rate Upper Limit data
     * @param aerobicHeartRateLowerLimit                Aerobic Heart Rate Lower Limit data
     * @param aerobicHeartRateUpperLimit                Aerobic Heart Rate Upper Limit data
     * @param anaerobicHeartRateLowerLimit              Anaerobic Heart Rate Lower Limit data
     * @param anaerobicHeartRateUpperLimit              Anaerobic Heart Rate Upper Limit data
     * @param fiveZoneHeartRateLimits                   Five Zone Heart Rate Limits data
     * @param threeZoneHeartRateLimits                  Three Zone Heart Rate Limits data
     * @param twoZoneHeartRateLimit                     Two Zone Heart Rate Limit data
     * @param language                                  Language data
     * @param databaseChangeIncrement                   Database Change Increment data
     * @param userIndex                                 User Index data
     * @param userControlPoint                          User Control Point data
     * @param registeredUser                            Registered User data
     */
    public UserDataServiceData(@Nullable UDSCharacteristicData firstName
            , @Nullable UDSCharacteristicData lastName
            , @Nullable UDSCharacteristicData emailAddress
            , @Nullable UDSCharacteristicData age
            , @Nullable UDSCharacteristicData dateOfBirth
            , @Nullable UDSCharacteristicData gender
            , @Nullable UDSCharacteristicData weight
            , @Nullable UDSCharacteristicData height
            , @Nullable UDSCharacteristicData vo2Max
            , @Nullable UDSCharacteristicData heartRateMax
            , @Nullable UDSCharacteristicData restingHeartRate
            , @Nullable UDSCharacteristicData maximumRecommendedHeartRate
            , @Nullable UDSCharacteristicData aerobicThreshold
            , @Nullable UDSCharacteristicData anaerobicThreshold
            , @Nullable UDSCharacteristicData sportTypeForAerobicAndAnaerobicThresholds
            , @Nullable UDSCharacteristicData dateOfThresholdAssessment
            , @Nullable UDSCharacteristicData waistCircumference
            , @Nullable UDSCharacteristicData hipCircumference
            , @Nullable UDSCharacteristicData fatBurnHeartRateLowerLimit
            , @Nullable UDSCharacteristicData fatBurnHeartRateUpperLimit
            , @Nullable UDSCharacteristicData aerobicHeartRateLowerLimit
            , @Nullable UDSCharacteristicData aerobicHeartRateUpperLimit
            , @Nullable UDSCharacteristicData anaerobicHeartRateLowerLimit
            , @Nullable UDSCharacteristicData anaerobicHeartRateUpperLimit
            , @Nullable UDSCharacteristicData fiveZoneHeartRateLimits
            , @Nullable UDSCharacteristicData threeZoneHeartRateLimits
            , @Nullable UDSCharacteristicData twoZoneHeartRateLimit
            , @Nullable UDSCharacteristicData language
            , @NonNull CharacteristicData databaseChangeIncrement
            , @NonNull CharacteristicData userIndex
            , @NonNull UserControlPointCharacteristicData userControlPoint
            , @Nullable CharacteristicData registeredUser) {
        super(USER_DATA_SERVICE
                , BluetoothGattService.SERVICE_TYPE_PRIMARY
                , Collections.emptyList());
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
        this.age = age;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.weight = weight;
        this.height = height;
        this.vo2Max = vo2Max;
        this.heartRateMax = heartRateMax;
        this.restingHeartRate = restingHeartRate;
        this.maximumRecommendedHeartRate = maximumRecommendedHeartRate;
        this.aerobicThreshold = aerobicThreshold;
        this.anaerobicThreshold = anaerobicThreshold;
        this.sportTypeForAerobicAndAnaerobicThresholds = sportTypeForAerobicAndAnaerobicThresholds;
        this.dateOfThresholdAssessment = dateOfThresholdAssessment;
        this.waistCircumference = waistCircumference;
        this.hipCircumference = hipCircumference;
        this.fatBurnHeartRateLowerLimit = fatBurnHeartRateLowerLimit;
        this.fatBurnHeartRateUpperLimit = fatBurnHeartRateUpperLimit;
        this.aerobicHeartRateLowerLimit = aerobicHeartRateLowerLimit;
        this.aerobicHeartRateUpperLimit = aerobicHeartRateUpperLimit;
        this.anaerobicHeartRateLowerLimit = anaerobicHeartRateLowerLimit;
        this.anaerobicHeartRateUpperLimit = anaerobicHeartRateUpperLimit;
        this.fiveZoneHeartRateLimits = fiveZoneHeartRateLimits;
        this.threeZoneHeartRateLimits = threeZoneHeartRateLimits;
        this.twoZoneHeartRateLimit = twoZoneHeartRateLimit;
        this.language = language;
        this.databaseChangeIncrement = databaseChangeIncrement;
        this.userIndex = userIndex;
        this.userControlPoint = userControlPoint;
        this.registeredUser = registeredUser;
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    @Deprecated
    public UserDataServiceData(@NonNull Parcel in) {
        super(in);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            firstName = in.readParcelable(this.getClass().getClassLoader(), UDSCharacteristicData.class);
            lastName = in.readParcelable(this.getClass().getClassLoader(), UDSCharacteristicData.class);
            emailAddress = in.readParcelable(this.getClass().getClassLoader(), UDSCharacteristicData.class);
            age = in.readParcelable(this.getClass().getClassLoader(), UDSCharacteristicData.class);
            dateOfBirth = in.readParcelable(this.getClass().getClassLoader(), UDSCharacteristicData.class);
            gender = in.readParcelable(this.getClass().getClassLoader(), UDSCharacteristicData.class);
            weight = in.readParcelable(this.getClass().getClassLoader(), UDSCharacteristicData.class);
            height = in.readParcelable(this.getClass().getClassLoader(), UDSCharacteristicData.class);
            vo2Max = in.readParcelable(this.getClass().getClassLoader(), UDSCharacteristicData.class);
            heartRateMax = in.readParcelable(this.getClass().getClassLoader(), UDSCharacteristicData.class);
            restingHeartRate = in.readParcelable(this.getClass().getClassLoader(), UDSCharacteristicData.class);
            maximumRecommendedHeartRate = in.readParcelable(this.getClass().getClassLoader(), UDSCharacteristicData.class);
            aerobicThreshold = in.readParcelable(this.getClass().getClassLoader(), UDSCharacteristicData.class);
            anaerobicThreshold = in.readParcelable(this.getClass().getClassLoader(), UDSCharacteristicData.class);
            sportTypeForAerobicAndAnaerobicThresholds = in.readParcelable(this.getClass().getClassLoader(), UDSCharacteristicData.class);
            dateOfThresholdAssessment = in.readParcelable(this.getClass().getClassLoader(), UDSCharacteristicData.class);
            waistCircumference = in.readParcelable(this.getClass().getClassLoader(), UDSCharacteristicData.class);
            hipCircumference = in.readParcelable(this.getClass().getClassLoader(), UDSCharacteristicData.class);
            fatBurnHeartRateLowerLimit = in.readParcelable(this.getClass().getClassLoader(), UDSCharacteristicData.class);
            fatBurnHeartRateUpperLimit = in.readParcelable(this.getClass().getClassLoader(), UDSCharacteristicData.class);
            aerobicHeartRateLowerLimit = in.readParcelable(this.getClass().getClassLoader(), UDSCharacteristicData.class);
            aerobicHeartRateUpperLimit = in.readParcelable(this.getClass().getClassLoader(), UDSCharacteristicData.class);
            anaerobicHeartRateLowerLimit = in.readParcelable(this.getClass().getClassLoader(), UDSCharacteristicData.class);
            anaerobicHeartRateUpperLimit = in.readParcelable(this.getClass().getClassLoader(), UDSCharacteristicData.class);
            fiveZoneHeartRateLimits = in.readParcelable(this.getClass().getClassLoader(), UDSCharacteristicData.class);
            threeZoneHeartRateLimits = in.readParcelable(this.getClass().getClassLoader(), UDSCharacteristicData.class);
            twoZoneHeartRateLimit = in.readParcelable(this.getClass().getClassLoader(), UDSCharacteristicData.class);
            language = in.readParcelable(this.getClass().getClassLoader(), UDSCharacteristicData.class);
            databaseChangeIncrement = in.readParcelable(this.getClass().getClassLoader(), CharacteristicData.class);
            userIndex = in.readParcelable(this.getClass().getClassLoader(), CharacteristicData.class);
            userControlPoint = in.readParcelable(this.getClass().getClassLoader(), UserControlPointCharacteristicData.class);
            registeredUser = in.readParcelable(this.getClass().getClassLoader(), CharacteristicData.class);
        } else {
            firstName = in.readParcelable(this.getClass().getClassLoader());
            lastName = in.readParcelable(this.getClass().getClassLoader());
            emailAddress = in.readParcelable(this.getClass().getClassLoader());
            age = in.readParcelable(this.getClass().getClassLoader());
            dateOfBirth = in.readParcelable(this.getClass().getClassLoader());
            gender = in.readParcelable(this.getClass().getClassLoader());
            weight = in.readParcelable(this.getClass().getClassLoader());
            height = in.readParcelable(this.getClass().getClassLoader());
            vo2Max = in.readParcelable(this.getClass().getClassLoader());
            heartRateMax = in.readParcelable(this.getClass().getClassLoader());
            restingHeartRate = in.readParcelable(this.getClass().getClassLoader());
            maximumRecommendedHeartRate = in.readParcelable(this.getClass().getClassLoader());
            aerobicThreshold = in.readParcelable(this.getClass().getClassLoader());
            anaerobicThreshold = in.readParcelable(this.getClass().getClassLoader());
            sportTypeForAerobicAndAnaerobicThresholds = in.readParcelable(this.getClass().getClassLoader());
            dateOfThresholdAssessment = in.readParcelable(this.getClass().getClassLoader());
            waistCircumference = in.readParcelable(this.getClass().getClassLoader());
            hipCircumference = in.readParcelable(this.getClass().getClassLoader());
            fatBurnHeartRateLowerLimit = in.readParcelable(this.getClass().getClassLoader());
            fatBurnHeartRateUpperLimit = in.readParcelable(this.getClass().getClassLoader());
            aerobicHeartRateLowerLimit = in.readParcelable(this.getClass().getClassLoader());
            aerobicHeartRateUpperLimit = in.readParcelable(this.getClass().getClassLoader());
            anaerobicHeartRateLowerLimit = in.readParcelable(this.getClass().getClassLoader());
            anaerobicHeartRateUpperLimit = in.readParcelable(this.getClass().getClassLoader());
            fiveZoneHeartRateLimits = in.readParcelable(this.getClass().getClassLoader());
            threeZoneHeartRateLimits = in.readParcelable(this.getClass().getClassLoader());
            twoZoneHeartRateLimit = in.readParcelable(this.getClass().getClassLoader());
            language = in.readParcelable(this.getClass().getClassLoader());
            databaseChangeIncrement = in.readParcelable(this.getClass().getClassLoader());
            userIndex = in.readParcelable(this.getClass().getClassLoader());
            userControlPoint = in.readParcelable(this.getClass().getClassLoader());
            registeredUser = in.readParcelable(this.getClass().getClassLoader());
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<CharacteristicData> getCharacteristicDataList() {
        List<CharacteristicData> characteristicDataList = new ArrayList<>();
        if (firstName != null) {
            characteristicDataList.add(firstName);
        }
        if (lastName != null) {
            characteristicDataList.add(lastName);
        }
        if (emailAddress != null) {
            characteristicDataList.add(emailAddress);
        }
        if (age != null) {
            characteristicDataList.add(age);
        }
        if (dateOfBirth != null) {
            characteristicDataList.add(dateOfBirth);
        }
        if (gender != null) {
            characteristicDataList.add(gender);
        }
        if (weight != null) {
            characteristicDataList.add(weight);
        }
        if (height != null) {
            characteristicDataList.add(height);
        }
        if (vo2Max != null) {
            characteristicDataList.add(vo2Max);
        }
        if (heartRateMax != null) {
            characteristicDataList.add(heartRateMax);
        }
        if (restingHeartRate != null) {
            characteristicDataList.add(restingHeartRate);
        }
        if (maximumRecommendedHeartRate != null) {
            characteristicDataList.add(maximumRecommendedHeartRate);
        }
        if (aerobicThreshold != null) {
            characteristicDataList.add(aerobicThreshold);
        }
        if (anaerobicThreshold != null) {
            characteristicDataList.add(anaerobicThreshold);
        }
        if (sportTypeForAerobicAndAnaerobicThresholds != null) {
            characteristicDataList.add(sportTypeForAerobicAndAnaerobicThresholds);
        }
        if (dateOfThresholdAssessment != null) {
            characteristicDataList.add(dateOfThresholdAssessment);
        }
        if (waistCircumference != null) {
            characteristicDataList.add(waistCircumference);
        }
        if (hipCircumference != null) {
            characteristicDataList.add(hipCircumference);
        }
        if (fatBurnHeartRateLowerLimit != null) {
            characteristicDataList.add(fatBurnHeartRateLowerLimit);
        }
        if (fatBurnHeartRateUpperLimit != null) {
            characteristicDataList.add(fatBurnHeartRateUpperLimit);
        }
        if (aerobicHeartRateLowerLimit != null) {
            characteristicDataList.add(aerobicHeartRateLowerLimit);
        }
        if (aerobicHeartRateUpperLimit != null) {
            characteristicDataList.add(aerobicHeartRateUpperLimit);
        }
        if (anaerobicHeartRateLowerLimit != null) {
            characteristicDataList.add(anaerobicHeartRateLowerLimit);
        }
        if (anaerobicHeartRateUpperLimit != null) {
            characteristicDataList.add(anaerobicHeartRateUpperLimit);
        }
        if (fiveZoneHeartRateLimits != null) {
            characteristicDataList.add(fiveZoneHeartRateLimits);
        }
        if (threeZoneHeartRateLimits != null) {
            characteristicDataList.add(threeZoneHeartRateLimits);
        }
        if (twoZoneHeartRateLimit != null) {
            characteristicDataList.add(twoZoneHeartRateLimit);
        }
        if (language != null) {
            characteristicDataList.add(language);
        }
        characteristicDataList.add(databaseChangeIncrement);
        characteristicDataList.add(userIndex);
        characteristicDataList.add(userControlPoint);
        if (registeredUser != null) {
            characteristicDataList.add(registeredUser);
        }
        return characteristicDataList;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
        dest.writeParcelable(firstName, flags);
        dest.writeParcelable(lastName, flags);
        dest.writeParcelable(emailAddress, flags);
        dest.writeParcelable(age, flags);
        dest.writeParcelable(dateOfBirth, flags);
        dest.writeParcelable(gender, flags);
        dest.writeParcelable(weight, flags);
        dest.writeParcelable(height, flags);
        dest.writeParcelable(vo2Max, flags);
        dest.writeParcelable(heartRateMax, flags);
        dest.writeParcelable(restingHeartRate, flags);
        dest.writeParcelable(maximumRecommendedHeartRate, flags);
        dest.writeParcelable(aerobicThreshold, flags);
        dest.writeParcelable(anaerobicThreshold, flags);
        dest.writeParcelable(sportTypeForAerobicAndAnaerobicThresholds, flags);
        dest.writeParcelable(dateOfThresholdAssessment, flags);
        dest.writeParcelable(waistCircumference, flags);
        dest.writeParcelable(hipCircumference, flags);
        dest.writeParcelable(fatBurnHeartRateLowerLimit, flags);
        dest.writeParcelable(fatBurnHeartRateUpperLimit, flags);
        dest.writeParcelable(aerobicHeartRateLowerLimit, flags);
        dest.writeParcelable(aerobicHeartRateUpperLimit, flags);
        dest.writeParcelable(anaerobicHeartRateLowerLimit, flags);
        dest.writeParcelable(anaerobicHeartRateUpperLimit, flags);
        dest.writeParcelable(fiveZoneHeartRateLimits, flags);
        dest.writeParcelable(threeZoneHeartRateLimits, flags);
        dest.writeParcelable(twoZoneHeartRateLimit, flags);
        dest.writeParcelable(language, flags);
        dest.writeParcelable(databaseChangeIncrement, flags);
        dest.writeParcelable(userIndex, flags);
        dest.writeParcelable(userControlPoint, flags);
        dest.writeParcelable(registeredUser, flags);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        return super.hashCode()
                ^ Objects.hashCode(firstName)
                ^ Objects.hashCode(lastName)
                ^ Objects.hashCode(emailAddress)
                ^ Objects.hashCode(age)
                ^ Objects.hashCode(dateOfBirth)
                ^ Objects.hashCode(gender)
                ^ Objects.hashCode(weight)
                ^ Objects.hashCode(height)
                ^ Objects.hashCode(vo2Max)
                ^ Objects.hashCode(heartRateMax)
                ^ Objects.hashCode(restingHeartRate)
                ^ Objects.hashCode(maximumRecommendedHeartRate)
                ^ Objects.hashCode(aerobicThreshold)
                ^ Objects.hashCode(anaerobicThreshold)
                ^ Objects.hashCode(sportTypeForAerobicAndAnaerobicThresholds)
                ^ Objects.hashCode(dateOfThresholdAssessment)
                ^ Objects.hashCode(waistCircumference)
                ^ Objects.hashCode(hipCircumference)
                ^ Objects.hashCode(fatBurnHeartRateLowerLimit)
                ^ Objects.hashCode(fatBurnHeartRateUpperLimit)
                ^ Objects.hashCode(aerobicHeartRateLowerLimit)
                ^ Objects.hashCode(aerobicHeartRateUpperLimit)
                ^ Objects.hashCode(anaerobicHeartRateLowerLimit)
                ^ Objects.hashCode(anaerobicHeartRateUpperLimit)
                ^ Objects.hashCode(fiveZoneHeartRateLimits)
                ^ Objects.hashCode(threeZoneHeartRateLimits)
                ^ Objects.hashCode(twoZoneHeartRateLimit)
                ^ Objects.hashCode(language)
                ^ Objects.hashCode(databaseChangeIncrement)
                ^ Objects.hashCode(userIndex)
                ^ Objects.hashCode(userControlPoint)
                ^ Objects.hashCode(registeredUser);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(@Nullable Object obj) {
        boolean result = false;
        if (obj instanceof ServiceData) {
            UserDataServiceData target = (UserDataServiceData) obj;
            result = super.equals(target)
                    && Objects.equals(firstName, target.firstName)
                    && Objects.equals(lastName, target.lastName)
                    && Objects.equals(emailAddress, target.emailAddress)
                    && Objects.equals(age, target.age)
                    && Objects.equals(dateOfBirth, target.dateOfBirth)
                    && Objects.equals(gender, target.gender)
                    && Objects.equals(weight, target.weight)
                    && Objects.equals(height, target.height)
                    && Objects.equals(vo2Max, target.vo2Max)
                    && Objects.equals(heartRateMax, target.heartRateMax)
                    && Objects.equals(restingHeartRate, target.restingHeartRate)
                    && Objects.equals(maximumRecommendedHeartRate, target.maximumRecommendedHeartRate)
                    && Objects.equals(aerobicThreshold, target.aerobicThreshold)
                    && Objects.equals(anaerobicThreshold, target.anaerobicThreshold)
                    && Objects.equals(sportTypeForAerobicAndAnaerobicThresholds, target.sportTypeForAerobicAndAnaerobicThresholds)
                    && Objects.equals(dateOfThresholdAssessment, target.dateOfThresholdAssessment)
                    && Objects.equals(waistCircumference, target.waistCircumference)
                    && Objects.equals(hipCircumference, target.hipCircumference)
                    && Objects.equals(fatBurnHeartRateLowerLimit, target.fatBurnHeartRateLowerLimit)
                    && Objects.equals(fatBurnHeartRateUpperLimit, target.fatBurnHeartRateUpperLimit)
                    && Objects.equals(aerobicHeartRateLowerLimit, target.aerobicHeartRateLowerLimit)
                    && Objects.equals(aerobicHeartRateUpperLimit, target.aerobicHeartRateUpperLimit)
                    && Objects.equals(anaerobicHeartRateLowerLimit, target.anaerobicHeartRateLowerLimit)
                    && Objects.equals(anaerobicHeartRateUpperLimit, target.anaerobicHeartRateUpperLimit)
                    && Objects.equals(fiveZoneHeartRateLimits, target.fiveZoneHeartRateLimits)
                    && Objects.equals(threeZoneHeartRateLimits, target.threeZoneHeartRateLimits)
                    && Objects.equals(twoZoneHeartRateLimit, target.twoZoneHeartRateLimit)
                    && Objects.equals(language, target.language)
                    && Objects.equals(databaseChangeIncrement, target.databaseChangeIncrement)
                    && Objects.equals(userIndex, target.userIndex)
                    && Objects.equals(userControlPoint, target.userControlPoint)
                    && Objects.equals(registeredUser, target.registeredUser);
        }
        return result;
    }
}