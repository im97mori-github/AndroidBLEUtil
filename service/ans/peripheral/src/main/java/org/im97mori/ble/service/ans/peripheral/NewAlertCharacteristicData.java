package org.im97mori.ble.service.ans.peripheral;

import static org.im97mori.ble.constants.CharacteristicUUID.NEW_ALERT_CHARACTERISTIC;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.gson.annotations.SerializedName;

import org.im97mori.ble.CharacteristicData;
import org.im97mori.ble.DescriptorData;

import java.util.List;
import java.util.Objects;

/**
 * New Alert Characteristic data class
 */
@SuppressWarnings("CanBeFinal")
public class NewAlertCharacteristicData extends CharacteristicData {

    /**
     * @see android.os.Parcelable.Creator
     */
    public static final Creator<NewAlertCharacteristicData> CREATOR = new Creator<NewAlertCharacteristicData>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public NewAlertCharacteristicData createFromParcel(@NonNull Parcel in) {
            return new NewAlertCharacteristicData(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public NewAlertCharacteristicData[] newArray(int size) {
            return new NewAlertCharacteristicData[size];
        }

    };

    /**
     * Number of New Alert:Simple Alert
     */
    @SerializedName("simple_alert_number_of_new_alert")
    public int simpleAlertNumberOfNewAlert;

    /**
     * Text String Information:Alert
     */
    @SerializedName("simple_alert_text_string_information")
    public String simpleAlertTextStringInformation;

    /**
     * Number of New Alert:Email
     */
    @SerializedName("email_number_of_new_alert")
    public int emailNumberOfNewAlert;

    /**
     * Text String Information:Email
     */
    @SerializedName("email_text_string_information")
    public String emailTextStringInformation;

    /**
     * Number of New Alert:News
     */
    @SerializedName("news_number_of_new_alert")
    public int newsNumberOfNewAlert;

    /**
     * Text String Information:News
     */
    @SerializedName("news_text_string_information")
    public String newsTextStringInformation;

    /**
     * Number of New Alert:Call
     */
    @SerializedName("call_number_of_new_alert")
    public int callNumberOfNewAlert;

    /**
     * Text String Information:Call
     */
    @SerializedName("call_text_string_information")
    public String callTextStringInformation;

    /**
     * Number of New Alert:Missed call
     */
    @SerializedName("missed_call_number_of_new_alert")
    public int missedCallNumberOfNewAlert;

    /**
     * Text String Information:Missed call
     */
    @SerializedName("missed_call_text_string_information")
    public String missedCallTextStringInformation;

    /**
     * Number of New Alert:SMS/MMS
     */
    @SerializedName("sms_mms_number_of_new_alert")
    public int smsMmsNumberOfNewAlert;

    /**
     * Text String Information:SMS/MMS
     */
    @SerializedName("sms_mms_text_string_information")
    public String smsMmsTextStringInformation;

    /**
     * Number of New Alert:Voice mail
     */
    @SerializedName("voice_mail_number_of_new_alert")
    public int voiceMailNumberOfNewAlert;

    /**
     * Text String Information:Voice mail
     */
    @SerializedName("voice_mail_text_string_information")
    public String voiceMailTextStringInformation;

    /**
     * Number of New Alert:Schedule
     */
    @SerializedName("schedule_number_of_new_alert")
    public int scheduleNumberOfNewAlert;

    /**
     * Text String Information:Schedule
     */
    @SerializedName("schedule_text_string_information")
    public String scheduleTextStringInformation;

    /**
     * Number of New Alert:High Prioritized Alert
     */
    @SerializedName("high_prioritized_number_of_new_alert")
    public int highPrioritizedAlertNumberOfNewAlert;

    /**
     * Text String Information:High Prioritized Alert
     */
    @SerializedName("high_prioritized_text_string_information")
    public String highPrioritizedAlertTextStringInformation;

    /**
     * Number of New Alert:Instant Message
     */
    @SerializedName("instant_message_number_of_new_alert")
    public int instantMessageAlertNumberOfNewAlert;

    /**
     * Text String Information:Instant Message
     */
    @SerializedName("instant_message_text_string_information")
    public String instantMessageTextStringInformation;

    /**
     * @param simpleAlertNumberOfNewAlert               Number of New Alert:Simple Alert
     * @param simpleAlertTextStringInformation          Text String Information:Alert
     * @param emailNumberOfNewAlert                     Number of New Alert:Email
     * @param emailTextStringInformation                Text String Information:Email
     * @param newsNumberOfNewAlert                      Number of New Alert:News
     * @param newsTextStringInformation                 Text String Information:News
     * @param callNumberOfNewAlert                      Number of New Alert:Call
     * @param callTextStringInformation                 Text String Information:Call
     * @param missedCallNumberOfNewAlert                Number of New Alert:Missed call
     * @param missedCallTextStringInformation           Text String Information:Missed call
     * @param smsMmsNumberOfNewAlert                    Number of New Alert:SMS/MMS
     * @param smsMmsTextStringInformation               Text String Information:SMS/MMS
     * @param voiceMailNumberOfNewAlert                 Number of New Alert:Voice mail
     * @param voiceMailTextStringInformation            Text String Information:Voice mail
     * @param scheduleNumberOfNewAlert                  Number of New Alert:Schedule
     * @param scheduleTextStringInformation             Text String Information:Schedule
     * @param highPrioritizedAlertNumberOfNewAlert      Number of New Alert:High Prioritized Alert
     * @param highPrioritizedAlertTextStringInformation Text String Information:High Prioritized Alert
     * @param instantMessageAlertNumberOfNewAlert       Number of New Alert:Instant Message
     * @param instantMessageTextStringInformation       Text String Information:Instant Message
     * @param descriptorDataList                        {@link DescriptorData} list
     */
    public NewAlertCharacteristicData(
            int simpleAlertNumberOfNewAlert
            , @Nullable String simpleAlertTextStringInformation
            , int emailNumberOfNewAlert
            , @Nullable String emailTextStringInformation
            , int newsNumberOfNewAlert
            , @Nullable String newsTextStringInformation
            , int callNumberOfNewAlert
            , @Nullable String callTextStringInformation
            , int missedCallNumberOfNewAlert
            , @Nullable String missedCallTextStringInformation
            , int smsMmsNumberOfNewAlert
            , @Nullable String smsMmsTextStringInformation
            , int voiceMailNumberOfNewAlert
            , @Nullable String voiceMailTextStringInformation
            , int scheduleNumberOfNewAlert
            , @Nullable String scheduleTextStringInformation
            , int highPrioritizedAlertNumberOfNewAlert
            , @Nullable String highPrioritizedAlertTextStringInformation
            , int instantMessageAlertNumberOfNewAlert
            , @Nullable String instantMessageTextStringInformation
            , @NonNull List<DescriptorData> descriptorDataList) {
        super(NEW_ALERT_CHARACTERISTIC
                , BluetoothGattCharacteristic.PROPERTY_NOTIFY
                , 0
                , descriptorDataList
                , BluetoothGatt.GATT_SUCCESS
                , 0
                , null
                , 0);
        this.simpleAlertNumberOfNewAlert = simpleAlertNumberOfNewAlert;
        this.simpleAlertTextStringInformation = simpleAlertTextStringInformation;
        this.emailNumberOfNewAlert = emailNumberOfNewAlert;
        this.emailTextStringInformation = emailTextStringInformation;
        this.newsNumberOfNewAlert = newsNumberOfNewAlert;
        this.newsTextStringInformation = newsTextStringInformation;
        this.callNumberOfNewAlert = callNumberOfNewAlert;
        this.callTextStringInformation = callTextStringInformation;
        this.missedCallNumberOfNewAlert = missedCallNumberOfNewAlert;
        this.missedCallTextStringInformation = missedCallTextStringInformation;
        this.smsMmsNumberOfNewAlert = smsMmsNumberOfNewAlert;
        this.smsMmsTextStringInformation = smsMmsTextStringInformation;
        this.voiceMailNumberOfNewAlert = voiceMailNumberOfNewAlert;
        this.voiceMailTextStringInformation = voiceMailTextStringInformation;
        this.scheduleNumberOfNewAlert = scheduleNumberOfNewAlert;
        this.scheduleTextStringInformation = scheduleTextStringInformation;
        this.highPrioritizedAlertNumberOfNewAlert = highPrioritizedAlertNumberOfNewAlert;
        this.highPrioritizedAlertTextStringInformation = highPrioritizedAlertTextStringInformation;
        this.instantMessageAlertNumberOfNewAlert = instantMessageAlertNumberOfNewAlert;
        this.instantMessageTextStringInformation = instantMessageTextStringInformation;
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    public NewAlertCharacteristicData(@NonNull Parcel in) {
        super(in);
        simpleAlertNumberOfNewAlert = in.readInt();
        simpleAlertTextStringInformation = in.readString();
        emailNumberOfNewAlert = in.readInt();
        emailTextStringInformation = in.readString();
        newsNumberOfNewAlert = in.readInt();
        newsTextStringInformation = in.readString();
        callNumberOfNewAlert = in.readInt();
        callTextStringInformation = in.readString();
        missedCallNumberOfNewAlert = in.readInt();
        missedCallTextStringInformation = in.readString();
        smsMmsNumberOfNewAlert = in.readInt();
        smsMmsTextStringInformation = in.readString();
        voiceMailNumberOfNewAlert = in.readInt();
        voiceMailTextStringInformation = in.readString();
        scheduleNumberOfNewAlert = in.readInt();
        scheduleTextStringInformation = in.readString();
        highPrioritizedAlertNumberOfNewAlert = in.readInt();
        highPrioritizedAlertTextStringInformation = in.readString();
        instantMessageAlertNumberOfNewAlert = in.readInt();
        instantMessageTextStringInformation = in.readString();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
        dest.writeInt(simpleAlertNumberOfNewAlert);
        dest.writeString(simpleAlertTextStringInformation);
        dest.writeInt(emailNumberOfNewAlert);
        dest.writeString(emailTextStringInformation);
        dest.writeInt(newsNumberOfNewAlert);
        dest.writeString(newsTextStringInformation);
        dest.writeInt(callNumberOfNewAlert);
        dest.writeString(callTextStringInformation);
        dest.writeInt(missedCallNumberOfNewAlert);
        dest.writeString(missedCallTextStringInformation);
        dest.writeInt(smsMmsNumberOfNewAlert);
        dest.writeString(smsMmsTextStringInformation);
        dest.writeInt(voiceMailNumberOfNewAlert);
        dest.writeString(voiceMailTextStringInformation);
        dest.writeInt(scheduleNumberOfNewAlert);
        dest.writeString(scheduleTextStringInformation);
        dest.writeInt(highPrioritizedAlertNumberOfNewAlert);
        dest.writeString(highPrioritizedAlertTextStringInformation);
        dest.writeInt(instantMessageAlertNumberOfNewAlert);
        dest.writeString(instantMessageTextStringInformation);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        return super.hashCode()
                ^ Integer.valueOf(simpleAlertNumberOfNewAlert).hashCode()
                ^ Objects.hashCode(simpleAlertTextStringInformation)
                ^ Integer.valueOf(emailNumberOfNewAlert).hashCode()
                ^ Objects.hashCode(emailTextStringInformation)
                ^ Integer.valueOf(newsNumberOfNewAlert).hashCode()
                ^ Objects.hashCode(newsTextStringInformation)
                ^ Integer.valueOf(callNumberOfNewAlert).hashCode()
                ^ Objects.hashCode(callTextStringInformation)
                ^ Integer.valueOf(missedCallNumberOfNewAlert).hashCode()
                ^ Objects.hashCode(missedCallTextStringInformation)
                ^ Integer.valueOf(smsMmsNumberOfNewAlert).hashCode()
                ^ Objects.hashCode(smsMmsTextStringInformation)
                ^ Integer.valueOf(voiceMailNumberOfNewAlert).hashCode()
                ^ Objects.hashCode(voiceMailTextStringInformation)
                ^ Integer.valueOf(scheduleNumberOfNewAlert).hashCode()
                ^ Objects.hashCode(scheduleTextStringInformation)
                ^ Integer.valueOf(highPrioritizedAlertNumberOfNewAlert).hashCode()
                ^ Objects.hashCode(highPrioritizedAlertTextStringInformation)
                ^ Integer.valueOf(instantMessageAlertNumberOfNewAlert).hashCode()
                ^ Objects.hashCode(instantMessageTextStringInformation);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(@Nullable Object obj) {
        boolean result = false;
        if (obj instanceof NewAlertCharacteristicData) {
            NewAlertCharacteristicData target = (NewAlertCharacteristicData) obj;
            result = super.equals(target)
                    && simpleAlertNumberOfNewAlert == target.simpleAlertNumberOfNewAlert
                    && simpleAlertTextStringInformation.equals(target.simpleAlertTextStringInformation)
                    && emailNumberOfNewAlert == target.emailNumberOfNewAlert
                    && emailTextStringInformation.equals(target.emailTextStringInformation)
                    && newsNumberOfNewAlert == target.newsNumberOfNewAlert
                    && newsTextStringInformation.equals(target.newsTextStringInformation)
                    && callNumberOfNewAlert == target.callNumberOfNewAlert
                    && callTextStringInformation.equals(target.callTextStringInformation)
                    && missedCallNumberOfNewAlert == target.missedCallNumberOfNewAlert
                    && missedCallTextStringInformation.equals(target.missedCallTextStringInformation)
                    && smsMmsNumberOfNewAlert == target.smsMmsNumberOfNewAlert
                    && smsMmsTextStringInformation.equals(target.smsMmsTextStringInformation)
                    && voiceMailNumberOfNewAlert == target.voiceMailNumberOfNewAlert
                    && voiceMailTextStringInformation.equals(target.voiceMailTextStringInformation)
                    && scheduleNumberOfNewAlert == target.scheduleNumberOfNewAlert
                    && scheduleTextStringInformation.equals(target.scheduleTextStringInformation)
                    && highPrioritizedAlertNumberOfNewAlert == target.highPrioritizedAlertNumberOfNewAlert
                    && highPrioritizedAlertTextStringInformation.equals(target.highPrioritizedAlertTextStringInformation)
                    && instantMessageAlertNumberOfNewAlert == target.instantMessageAlertNumberOfNewAlert
                    && instantMessageTextStringInformation.equals(target.instantMessageTextStringInformation);
        }
        return result;
    }

}
