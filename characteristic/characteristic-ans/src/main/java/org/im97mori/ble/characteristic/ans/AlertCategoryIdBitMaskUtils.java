package org.im97mori.ble.characteristic.ans;

/**
 * Utility for org.bluetooth.characteristic.alert_category_id_bit_mask(0x2A42) characteristic
 */
@SuppressWarnings("WeakerAccess")
public class AlertCategoryIdBitMaskUtils {

    /**
     * @see #CATEGORY_ID_BIT_MASK_0_SIMPLE_ALERT_NOT_SUPPORTED
     * @see #CATEGORY_ID_BIT_MASK_0_SIMPLE_ALERT_SUPPORTED
     */
    public static final int CATEGORY_ID_BIT_MASK_0_SIMPLE_ALERT_MASK = 0b00000001;

    /**
     * 0: Simple Alert Not Supported
     */
    public static final int CATEGORY_ID_BIT_MASK_0_SIMPLE_ALERT_NOT_SUPPORTED = 0b00000000;

    /**
     * 1: Simple Alert Supported
     */
    public static final int CATEGORY_ID_BIT_MASK_0_SIMPLE_ALERT_SUPPORTED = 0b00000001;

    /**
     * @see #CATEGORY_ID_BIT_MASK_0_EMAIL_NOT_SUPPORTED
     * @see #CATEGORY_ID_BIT_MASK_0_EMAIL_SUPPORTED
     */
    public static final int CATEGORY_ID_BIT_MASK_0_EMAIL_MASK = 0b00000010;

    /**
     * 0: Email Not Supported
     */
    public static final int CATEGORY_ID_BIT_MASK_0_EMAIL_NOT_SUPPORTED = 0b00000000;

    /**
     * 1: Email Supported
     */
    public static final int CATEGORY_ID_BIT_MASK_0_EMAIL_SUPPORTED = 0b00000010;

    /**
     * @see #CATEGORY_ID_BIT_MASK_0_NEWS_NOT_SUPPORTED
     * @see #CATEGORY_ID_BIT_MASK_0_NEWS_SUPPORTED
     */
    public static final int CATEGORY_ID_BIT_MASK_0_NEWS_MASK = 0b00000100;

    /**
     * 0: News Not Supported
     */
    public static final int CATEGORY_ID_BIT_MASK_0_NEWS_NOT_SUPPORTED = 0b00000000;

    /**
     * 1: News Supported
     */
    public static final int CATEGORY_ID_BIT_MASK_0_NEWS_SUPPORTED = 0b00000100;

    /**
     * @see #CATEGORY_ID_BIT_MASK_0_CALL_NOT_SUPPORTED
     * @see #CATEGORY_ID_BIT_MASK_0_CALL_SUPPORTED
     */
    public static final int CATEGORY_ID_BIT_MASK_0_CALL_MASK = 0b00001000;

    /**
     * 0: Call Not Supported
     */
    public static final int CATEGORY_ID_BIT_MASK_0_CALL_NOT_SUPPORTED = 0b00000000;

    /**
     * 1: Call Supported
     */
    public static final int CATEGORY_ID_BIT_MASK_0_CALL_SUPPORTED = 0b00001000;

    /**
     * @see #CATEGORY_ID_BIT_MASK_0_MISSED_CALL_NOT_SUPPORTED
     * @see #CATEGORY_ID_BIT_MASK_0_MISSED_CALL_SUPPORTED
     */
    public static final int CATEGORY_ID_BIT_MASK_0_MISSED_CALL_MASK = 0b00010000;

    /**
     * 0: Missed Call Not Supported
     */
    public static final int CATEGORY_ID_BIT_MASK_0_MISSED_CALL_NOT_SUPPORTED = 0b00000000;

    /**
     * 1: Missed Call Supported
     */
    public static final int CATEGORY_ID_BIT_MASK_0_MISSED_CALL_SUPPORTED = 0b00010000;

    /**
     * @see #CATEGORY_ID_BIT_MASK_0_SMS_MMS_NOT_SUPPORTED
     * @see #CATEGORY_ID_BIT_MASK_0_SMS_MMS_SUPPORTED
     */
    public static final int CATEGORY_ID_BIT_MASK_0_SMS_MMS_MASK = 0b00010000;

    /**
     * 0: SMS/MMS Not Supported
     */
    public static final int CATEGORY_ID_BIT_MASK_0_SMS_MMS_NOT_SUPPORTED = 0b00000000;

    /**
     * 1: SMS/MMS Supported
     */
    public static final int CATEGORY_ID_BIT_MASK_0_SMS_MMS_SUPPORTED = 0b00010000;

    /**
     * @see #CATEGORY_ID_BIT_MASK_0_VOICE_MAIL_NOT_SUPPORTED
     * @see #CATEGORY_ID_BIT_MASK_0_VOICE_MAIL_SUPPORTED
     */
    public static final int CATEGORY_ID_BIT_MASK_0_VOICE_MAIL_MASK = 0b00100000;

    /**
     * 0: Voice Mail Not Supported
     */
    public static final int CATEGORY_ID_BIT_MASK_0_VOICE_MAIL_NOT_SUPPORTED = 0b00000000;

    /**
     * 1: Voice Mail Supported
     */
    public static final int CATEGORY_ID_BIT_MASK_0_VOICE_MAIL_SUPPORTED = 0b00100000;

    /**
     * @see #CATEGORY_ID_BIT_MASK_0_SCHEDULE_NOT_SUPPORTED
     * @see #CATEGORY_ID_BIT_MASK_0_SCHEDULE_SUPPORTED
     */
    public static final int CATEGORY_ID_BIT_MASK_0_SCHEDULE_MASK = 0b01000000;

    /**
     * 0: Schedule Not Supported
     */
    public static final int CATEGORY_ID_BIT_MASK_0_SCHEDULE_NOT_SUPPORTED = 0b00000000;

    /**
     * 1: Schedule Supported
     */
    public static final int CATEGORY_ID_BIT_MASK_0_SCHEDULE_SUPPORTED = 0b01000000;

    /**
     * @see #CATEGORY_ID_BIT_MASK_1_HIGH_PRIORITIZED_NOT_SUPPORTED
     * @see #CATEGORY_ID_BIT_MASK_1_HIGH_PRIORITIZED_SUPPORTED
     */
    public static final int CATEGORY_ID_BIT_MASK_1_HIGH_PRIORITIZED_MASK = 0b00000001;

    /**
     * 0: High Prioritized Alert Not Supported
     */
    public static final int CATEGORY_ID_BIT_MASK_1_HIGH_PRIORITIZED_NOT_SUPPORTED = 0b00000000;

    /**
     * 1: High Prioritized Alert Supported
     */
    public static final int CATEGORY_ID_BIT_MASK_1_HIGH_PRIORITIZED_SUPPORTED = 0b00000001;

    /**
     * @see #CATEGORY_ID_BIT_MASK_1_INSTANT_MESSAGE_NOT_SUPPORTED
     * @see #CATEGORY_ID_BIT_MASK_1_INSTANT_MESSAGE_SUPPORTED
     */
    public static final int CATEGORY_ID_BIT_MASK_1_INSTANT_MESSAGE_MASK = 0b00000001;

    /**
     * 0: Instant Message Not Supported
     */
    public static final int CATEGORY_ID_BIT_MASK_1_INSTANT_MESSAGE_NOT_SUPPORTED = 0b00000000;

    /**
     * 1: Instant Message Supported
     */
    public static final int CATEGORY_ID_BIT_MASK_1_INSTANT_MESSAGE_SUPPORTED = 0b00000001;

    /**
     * @param categoryIdBitMask0 Category ID Bit Mask 0
     * @return {@code true}:Simple Alert Not Supported, {@code false}:Simple Alert Supported
     */
    public static boolean isCategoryIdBitMask0SimpleAlertNotSupported(int categoryIdBitMask0) {
        return isCategoryIdBitMask0Matched(CATEGORY_ID_BIT_MASK_0_SIMPLE_ALERT_MASK, CATEGORY_ID_BIT_MASK_0_SIMPLE_ALERT_NOT_SUPPORTED, categoryIdBitMask0);
    }

    /**
     * @param categoryIdBitMask0 Category ID Bit Mask 0
     * @return {@code true}:Simple Alert Supported, {@code false}:Simple Alert Not Supported
     */
    public static boolean isCategoryIdBitMask0SimpleAlertSupported(int categoryIdBitMask0) {
        return isCategoryIdBitMask0Matched(CATEGORY_ID_BIT_MASK_0_SIMPLE_ALERT_MASK, CATEGORY_ID_BIT_MASK_0_SIMPLE_ALERT_SUPPORTED, categoryIdBitMask0);
    }

    /**
     * @param categoryIdBitMask0 Category ID Bit Mask 0
     * @return {@code true}:Email Not Supported, {@code false}:Email Supported
     */
    public static boolean isCategoryIdBitMask0EmailNotSupported(int categoryIdBitMask0) {
        return isCategoryIdBitMask0Matched(CATEGORY_ID_BIT_MASK_0_EMAIL_MASK, CATEGORY_ID_BIT_MASK_0_EMAIL_NOT_SUPPORTED, categoryIdBitMask0);
    }

    /**
     * @param categoryIdBitMask0 Category ID Bit Mask 0
     * @return {@code true}:Email Supported, {@code false}:Email Not Supported
     */
    public static boolean isCategoryIdBitMask0EmailSupported(int categoryIdBitMask0) {
        return isCategoryIdBitMask0Matched(CATEGORY_ID_BIT_MASK_0_EMAIL_MASK, CATEGORY_ID_BIT_MASK_0_EMAIL_SUPPORTED, categoryIdBitMask0);
    }

    /**
     * @param categoryIdBitMask0 Category ID Bit Mask 0
     * @return {@code true}:News Not Supported, {@code false}:News Supported
     */
    public static boolean isCategoryIdBitMask0NewsNotSupported(int categoryIdBitMask0) {
        return isCategoryIdBitMask0Matched(CATEGORY_ID_BIT_MASK_0_NEWS_MASK, CATEGORY_ID_BIT_MASK_0_NEWS_NOT_SUPPORTED, categoryIdBitMask0);
    }

    /**
     * @param categoryIdBitMask0 Category ID Bit Mask 0
     * @return {@code true}:News Supported, {@code false}:News Not Supported
     */
    public static boolean isCategoryIdBitMask0NewsSupported(int categoryIdBitMask0) {
        return isCategoryIdBitMask0Matched(CATEGORY_ID_BIT_MASK_0_NEWS_MASK, CATEGORY_ID_BIT_MASK_0_NEWS_SUPPORTED, categoryIdBitMask0);
    }

    /**
     * @param categoryIdBitMask0 Category ID Bit Mask 0
     * @return {@code true}:Call Not Supported, {@code false}:Call Supported
     */
    public static boolean isCategoryIdBitMask0CallNotSupported(int categoryIdBitMask0) {
        return isCategoryIdBitMask0Matched(CATEGORY_ID_BIT_MASK_0_CALL_MASK, CATEGORY_ID_BIT_MASK_0_CALL_NOT_SUPPORTED, categoryIdBitMask0);
    }

    /**
     * @param categoryIdBitMask0 Category ID Bit Mask 0
     * @return {@code true}:Call Supported, {@code false}:Call Not Supported
     */
    public static boolean isCategoryIdBitMask0CallSupported(int categoryIdBitMask0) {
        return isCategoryIdBitMask0Matched(CATEGORY_ID_BIT_MASK_0_CALL_MASK, CATEGORY_ID_BIT_MASK_0_CALL_SUPPORTED, categoryIdBitMask0);
    }

    /**
     * @param categoryIdBitMask0 Category ID Bit Mask 0
     * @return {@code true}:Missed Call Not Supported, {@code false}:Missed Call Supported
     */
    public static boolean isCategoryIdBitMask0MissedCallNotSupported(int categoryIdBitMask0) {
        return isCategoryIdBitMask0Matched(CATEGORY_ID_BIT_MASK_0_MISSED_CALL_MASK, CATEGORY_ID_BIT_MASK_0_MISSED_CALL_NOT_SUPPORTED, categoryIdBitMask0);
    }

    /**
     * @param categoryIdBitMask0 Category ID Bit Mask 0
     * @return {@code true}:Missed Call Supported, {@code false}:Missed Call Not Supported
     */
    public static boolean isCategoryIdBitMask0MissedCallSupported(int categoryIdBitMask0) {
        return isCategoryIdBitMask0Matched(CATEGORY_ID_BIT_MASK_0_MISSED_CALL_MASK, CATEGORY_ID_BIT_MASK_0_MISSED_CALL_SUPPORTED, categoryIdBitMask0);
    }

    /**
     * @param categoryIdBitMask0 Category ID Bit Mask 0
     * @return {@code true}:SMS/MMS Not Supported, {@code false}:SMS/MMS Supported
     */
    public static boolean isCategoryIdBitMask0SmsMmsNotSupported(int categoryIdBitMask0) {
        return isCategoryIdBitMask0Matched(CATEGORY_ID_BIT_MASK_0_SMS_MMS_MASK, CATEGORY_ID_BIT_MASK_0_SMS_MMS_NOT_SUPPORTED, categoryIdBitMask0);
    }

    /**
     * @param categoryIdBitMask0 Category ID Bit Mask 0
     * @return {@code true}:SMS/MMS Supported, {@code false}:SMS/MMS Not Supported
     */
    public static boolean isCategoryIdBitMask0SmsMmsSupported(int categoryIdBitMask0) {
        return isCategoryIdBitMask0Matched(CATEGORY_ID_BIT_MASK_0_SMS_MMS_MASK, CATEGORY_ID_BIT_MASK_0_SMS_MMS_SUPPORTED, categoryIdBitMask0);
    }

    /**
     * @param categoryIdBitMask0 Category ID Bit Mask 0
     * @return {@code true}:Voice Mail Not Supported, {@code false}:Voice Mail Supported
     */
    public static boolean isCategoryIdBitMask0VoiceMailNotSupported(int categoryIdBitMask0) {
        return isCategoryIdBitMask0Matched(CATEGORY_ID_BIT_MASK_0_VOICE_MAIL_MASK, CATEGORY_ID_BIT_MASK_0_VOICE_MAIL_NOT_SUPPORTED, categoryIdBitMask0);
    }

    /**
     * @param categoryIdBitMask0 Category ID Bit Mask 0
     * @return {@code true}:Voice Mail Supported, {@code false}:Voice Mail Not Supported
     */
    public static boolean isCategoryIdBitMask0VoiceMailSupported(int categoryIdBitMask0) {
        return isCategoryIdBitMask0Matched(CATEGORY_ID_BIT_MASK_0_VOICE_MAIL_MASK, CATEGORY_ID_BIT_MASK_0_VOICE_MAIL_SUPPORTED, categoryIdBitMask0);
    }

    /**
     * @param categoryIdBitMask0 Category ID Bit Mask 0
     * @return {@code true}:Schedule Supported, {@code false}:Schedule Not Supported
     */
    public static boolean isCategoryIdBitMask0ScheduleNotSupported(int categoryIdBitMask0) {
        return isCategoryIdBitMask0Matched(CATEGORY_ID_BIT_MASK_0_SCHEDULE_MASK, CATEGORY_ID_BIT_MASK_0_SCHEDULE_NOT_SUPPORTED, categoryIdBitMask0);
    }

    /**
     * @param categoryIdBitMask0 Category ID Bit Mask 0
     * @return {@code true}:Schedule Not Supported, {@code false}:Schedule Supported
     */
    public static boolean isCategoryIdBitMask0ScheduleSupported(int categoryIdBitMask0) {
        return isCategoryIdBitMask0Matched(CATEGORY_ID_BIT_MASK_0_SCHEDULE_MASK, CATEGORY_ID_BIT_MASK_0_SCHEDULE_SUPPORTED, categoryIdBitMask0);
    }

    /**
     * @param categoryIdBitMask1 Category ID Bit Mask 1
     * @return {@code true}:High Prioritized Alert Not Supported, {@code false}:High Prioritized Alert Not Supported
     */
    public static boolean isCategoryIdBitMask1HighPrioritizedAlertNotSupported(int categoryIdBitMask1) {
        return isCategoryIdBitMask1Matched(CATEGORY_ID_BIT_MASK_1_HIGH_PRIORITIZED_MASK, CATEGORY_ID_BIT_MASK_1_HIGH_PRIORITIZED_NOT_SUPPORTED, categoryIdBitMask1);
    }

    /**
     * @param categoryIdBitMask1 Category ID Bit Mask 1
     * @return {@code true}:High Prioritized Alert Not Supported, {@code false}:High Prioritized Alert Not Supported
     */
    public static boolean isCategoryIdBitMask1HighPrioritizedAlertSupported(int categoryIdBitMask1) {
        return isCategoryIdBitMask1Matched(CATEGORY_ID_BIT_MASK_1_HIGH_PRIORITIZED_MASK, CATEGORY_ID_BIT_MASK_1_HIGH_PRIORITIZED_SUPPORTED, categoryIdBitMask1);
    }

    /**
     * @param categoryIdBitMask1 Category ID Bit Mask 1
     * @return {@code true}:Instant Message Not Supported, {@code false}:Instant Message Supported
     */
    public static boolean isCategoryIdBitMask1InstantMessageNotSupported(int categoryIdBitMask1) {
        return isCategoryIdBitMask1Matched(CATEGORY_ID_BIT_MASK_1_INSTANT_MESSAGE_MASK, CATEGORY_ID_BIT_MASK_1_INSTANT_MESSAGE_NOT_SUPPORTED, categoryIdBitMask1);
    }

    /**
     * @param categoryIdBitMask1 Category ID Bit Mask 1
     * @return {@code true}:Instant Message Supported, {@code false}:Instant Message Not Supported
     */
    public static boolean isCategoryIdBitMask1InstantMessageAlertSupported(int categoryIdBitMask1) {
        return isCategoryIdBitMask1Matched(CATEGORY_ID_BIT_MASK_1_INSTANT_MESSAGE_MASK, CATEGORY_ID_BIT_MASK_1_INSTANT_MESSAGE_SUPPORTED, categoryIdBitMask1);
    }

    /**
     * check Category ID Bit Mask 0
     *
     * @param mask   bitmask for expect
     * @param expect one of {@link #CATEGORY_ID_BIT_MASK_0_SIMPLE_ALERT_NOT_SUPPORTED}
     *               , {@link #CATEGORY_ID_BIT_MASK_0_SIMPLE_ALERT_SUPPORTED}
     *               , {@link #CATEGORY_ID_BIT_MASK_0_EMAIL_NOT_SUPPORTED}
     *               , {@link #CATEGORY_ID_BIT_MASK_0_EMAIL_SUPPORTED}
     *               , {@link #CATEGORY_ID_BIT_MASK_0_NEWS_NOT_SUPPORTED}
     *               , {@link #CATEGORY_ID_BIT_MASK_0_NEWS_SUPPORTED}
     *               , {@link #CATEGORY_ID_BIT_MASK_0_CALL_NOT_SUPPORTED}
     *               , {@link #CATEGORY_ID_BIT_MASK_0_CALL_SUPPORTED}
     *               , {@link #CATEGORY_ID_BIT_MASK_0_MISSED_CALL_NOT_SUPPORTED}
     *               , {@link #CATEGORY_ID_BIT_MASK_0_MISSED_CALL_SUPPORTED}
     *               , {@link #CATEGORY_ID_BIT_MASK_0_SMS_MMS_NOT_SUPPORTED}
     *               , {@link #CATEGORY_ID_BIT_MASK_0_SMS_MMS_SUPPORTED}
     *               , {@link #CATEGORY_ID_BIT_MASK_0_VOICE_MAIL_NOT_SUPPORTED}
     *               , {@link #CATEGORY_ID_BIT_MASK_0_VOICE_MAIL_SUPPORTED}
     *               , {@link #CATEGORY_ID_BIT_MASK_0_SCHEDULE_NOT_SUPPORTED}
     *               , {@link #CATEGORY_ID_BIT_MASK_0_SCHEDULE_SUPPORTED}
     * @return {@code true}:same as expect, {@code false}:not match
     */
    private static boolean isCategoryIdBitMask0Matched(int mask, int expect, int categoryIdBitMask0) {
        return (mask & categoryIdBitMask0) == expect;
    }

    /**
     * check Category ID Bit Mask 1
     *
     * @param mask   bitmask for expect
     * @param expect one of {@link #CATEGORY_ID_BIT_MASK_1_HIGH_PRIORITIZED_NOT_SUPPORTED}
     *               , {@link #CATEGORY_ID_BIT_MASK_1_HIGH_PRIORITIZED_SUPPORTED}
     *               , {@link #CATEGORY_ID_BIT_MASK_1_INSTANT_MESSAGE_NOT_SUPPORTED}
     *               , {@link #CATEGORY_ID_BIT_MASK_1_INSTANT_MESSAGE_SUPPORTED}
     * @return {@code true}:same as expect, {@code false}:not match
     */
    private static boolean isCategoryIdBitMask1Matched(int mask, int expect, int categoryIdBitMask1) {
        return (mask & categoryIdBitMask1) == expect;
    }

}
