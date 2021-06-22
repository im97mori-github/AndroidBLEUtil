package org.im97mori.ble.service.ans.peripheral;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.gson.annotations.SerializedName;

import org.im97mori.ble.CharacteristicData;
import org.im97mori.ble.DescriptorData;

import java.util.Arrays;
import java.util.List;

import static org.im97mori.ble.constants.CharacteristicUUID.UNREAD_ALERT_STATUS_CHARACTERISTIC;

/**
 * Unread Alert Status Characteristic data class
 */
@SuppressWarnings("CanBeFinal")
public class UnreadAlertStatusCharacteristicData extends CharacteristicData {

    /**
     * @see android.os.Parcelable.Creator
     */
    public static final Creator<UnreadAlertStatusCharacteristicData> CREATOR = new Creator<UnreadAlertStatusCharacteristicData>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public UnreadAlertStatusCharacteristicData createFromParcel(@NonNull Parcel in) {
            return new UnreadAlertStatusCharacteristicData(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public UnreadAlertStatusCharacteristicData[] newArray(int size) {
            return new UnreadAlertStatusCharacteristicData[size];
        }

    };

    /**
     * Unread Count:Simple Alert
     */
    @SerializedName("simple_alert_unread_count")
    public int simpleAlertUnreadCount;

    /**
     * Unread Count:Email
     */
    @SerializedName("email_unread_count")
    public int emailUnreadCount;

    /**
     * Unread Count:News
     */
    @SerializedName("news_unread_count")
    public int newsUnreadCount;

    /**
     * Unread Count:Call
     */
    @SerializedName("call_unread_count")
    public int callUnreadCount;

    /**
     * Unread Count:Missed call
     */
    @SerializedName("missed_call_unread_count")
    public int missedCallUnreadCount;

    /**
     * Unread Count:SMS/MMS
     */
    @SerializedName("sms_mms_unread_count")
    public int smsMmsUnreadCount;

    /**
     * Unread Count:Voice mail
     */
    @SerializedName("voice_mail_unread_count")
    public int voiceMailUnreadCount;

    /**
     * Unread Count:Schedule
     */
    @SerializedName("schedule_unread_count")
    public int scheduleUnreadCount;

    /**
     * Unread Count:High Prioritized Alert
     */
    @SerializedName("high_prioritized_unread_count")
    public int highPrioritizedAlertUnreadCount;

    /**
     * Unread Count:Instant Message
     */
    @SerializedName("instant_message_unread_count")
    public int instantMessageAlertUnreadCount;

    /**
     * @param simpleAlertUnreadCount          Unread Count:Simple Alert
     * @param emailUnreadCount                Unread Count:Email
     * @param newsUnreadCount                 Unread Count:News
     * @param callUnreadCount                 Unread Count:Call
     * @param missedCallUnreadCount           Unread Count:Missed call
     * @param smsMmsUnreadCount               Unread Count:SMS/MMS
     * @param voiceMailUnreadCount            Unread Count:Voice mail
     * @param scheduleUnreadCount             Unread Count:Schedule
     * @param highPrioritizedAlertUnreadCount Unread Count:High Prioritized Alert
     * @param instantMessageAlertUnreadCount  Unread Count:Instant Message
     * @param descriptorDataList              {@link DescriptorData} list
     */
    public UnreadAlertStatusCharacteristicData(int simpleAlertUnreadCount
            , int emailUnreadCount
            , int newsUnreadCount
            , int callUnreadCount
            , int missedCallUnreadCount
            , int smsMmsUnreadCount
            , int voiceMailUnreadCount
            , int scheduleUnreadCount
            , int highPrioritizedAlertUnreadCount
            , int instantMessageAlertUnreadCount
            , @NonNull List<DescriptorData> descriptorDataList) {
        super(UNREAD_ALERT_STATUS_CHARACTERISTIC
                , BluetoothGattCharacteristic.PROPERTY_NOTIFY
                , 0
                , descriptorDataList
                , BluetoothGatt.GATT_SUCCESS
                , 0
                , null
                , 0);
        this.simpleAlertUnreadCount = simpleAlertUnreadCount;
        this.emailUnreadCount = emailUnreadCount;
        this.newsUnreadCount = newsUnreadCount;
        this.callUnreadCount = callUnreadCount;
        this.missedCallUnreadCount = missedCallUnreadCount;
        this.smsMmsUnreadCount = smsMmsUnreadCount;
        this.voiceMailUnreadCount = voiceMailUnreadCount;
        this.scheduleUnreadCount = scheduleUnreadCount;
        this.highPrioritizedAlertUnreadCount = highPrioritizedAlertUnreadCount;
        this.instantMessageAlertUnreadCount = instantMessageAlertUnreadCount;
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    public UnreadAlertStatusCharacteristicData(@NonNull Parcel in) {
        super(in);
        simpleAlertUnreadCount = in.readInt();
        emailUnreadCount = in.readInt();
        newsUnreadCount = in.readInt();
        callUnreadCount = in.readInt();
        missedCallUnreadCount = in.readInt();
        smsMmsUnreadCount = in.readInt();
        voiceMailUnreadCount = in.readInt();
        scheduleUnreadCount = in.readInt();
        highPrioritizedAlertUnreadCount = in.readInt();
        instantMessageAlertUnreadCount = in.readInt();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        super.writeToParcel(dest, flags);
        dest.writeInt(simpleAlertUnreadCount);
        dest.writeInt(emailUnreadCount);
        dest.writeInt(newsUnreadCount);
        dest.writeInt(callUnreadCount);
        dest.writeInt(missedCallUnreadCount);
        dest.writeInt(smsMmsUnreadCount);
        dest.writeInt(voiceMailUnreadCount);
        dest.writeInt(scheduleUnreadCount);
        dest.writeInt(highPrioritizedAlertUnreadCount);
        dest.writeInt(instantMessageAlertUnreadCount);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        return super.hashCode()
                ^ Integer.valueOf(simpleAlertUnreadCount).hashCode()
                ^ Integer.valueOf(emailUnreadCount).hashCode()
                ^ Integer.valueOf(newsUnreadCount).hashCode()
                ^ Integer.valueOf(callUnreadCount).hashCode()
                ^ Integer.valueOf(missedCallUnreadCount).hashCode()
                ^ Integer.valueOf(smsMmsUnreadCount).hashCode()
                ^ Integer.valueOf(voiceMailUnreadCount).hashCode()
                ^ Integer.valueOf(scheduleUnreadCount).hashCode()
                ^ Integer.valueOf(highPrioritizedAlertUnreadCount).hashCode()
                ^ Integer.valueOf(instantMessageAlertUnreadCount).hashCode();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(@Nullable Object obj) {
        boolean result = false;
        if (obj instanceof UnreadAlertStatusCharacteristicData) {
            UnreadAlertStatusCharacteristicData target = (UnreadAlertStatusCharacteristicData) obj;
            result = uuid.equals(target.uuid)
                    && property == target.property
                    && permission == target.permission
                    && Arrays.equals(descriptorDataList.toArray(), target.descriptorDataList.toArray())
                    && responseCode == target.responseCode
                    && delay == target.delay
                    && Arrays.equals(data, target.data)
                    && Arrays.equals(currentData, target.currentData)
                    && Arrays.equals(temporaryData, target.temporaryData)
                    && notificationCount == target.notificationCount
                    && simpleAlertUnreadCount == target.simpleAlertUnreadCount
                    && emailUnreadCount == target.emailUnreadCount
                    && newsUnreadCount == target.newsUnreadCount
                    && callUnreadCount == target.callUnreadCount
                    && missedCallUnreadCount == target.missedCallUnreadCount
                    && smsMmsUnreadCount == target.smsMmsUnreadCount
                    && voiceMailUnreadCount == target.voiceMailUnreadCount
                    && scheduleUnreadCount == target.scheduleUnreadCount
                    && highPrioritizedAlertUnreadCount == target.highPrioritizedAlertUnreadCount
                    && instantMessageAlertUnreadCount == target.instantMessageAlertUnreadCount;
        }
        return result;
    }

}
