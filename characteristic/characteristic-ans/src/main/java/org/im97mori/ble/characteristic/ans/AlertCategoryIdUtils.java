package org.im97mori.ble.characteristic.ans;

/**
 * Utility for org.bluetooth.characteristic.alert_category_id(0x2A43) characteristic
 */
@SuppressWarnings("WeakerAccess")
public class AlertCategoryIdUtils {

    /**
     * 0: Simple Alert: General text alert or non-text alert
     */
    public static final int CATEGORY_ID_SIMPLE_ALERT = 0;

    /**
     * 1: Email: Alert when Email messages arrives
     */
    public static final int CATEGORY_ID_EMAIL = 1;

    /**
     * 2: News: News feeds such as RSS, Atom
     */
    public static final int CATEGORY_ID_NEWS = 2;

    /**
     * 3: Call: Incoming call
     */
    public static final int CATEGORY_ID_CALL = 3;

    /**
     * 4: Missed call: Missed Call
     */
    public static final int CATEGORY_ID_MISSED_CALL = 4;

    /**
     * 5: SMS/MMS: SMS/MMS message arrives
     */
    public static final int CATEGORY_ID_SMS_MMS = 5;

    /**
     * 6: Voice mail: Voice mail
     */
    public static final int CATEGORY_ID_VOICE_MAIL = 6;

    /**
     * 7: Schedule: Alert occurred on calendar, planner
     */
    public static final int CATEGORY_ID_SCHEDULE = 7;

    /**
     * 8: High Prioritized Alert: Alert that should be handled as high priority
     */
    public static final int CATEGORY_ID_HIGH_PRIORITIZED_ALERT = 8;

    /**
     * 9: Instant Message: Alert for incoming instant messages
     */
    public static final int CATEGORY_ID_INSTANT_MESSAGE = 9;


    /**
     * @param categoryId Category ID
     * @return {@code true}:Simple Alert, {@code false}:not Simple Alert
     */
    public static boolean isCategoryIdSimpleAlert(int categoryId) {
        return CATEGORY_ID_SIMPLE_ALERT == categoryId;
    }

    /**
     * @param categoryId Category ID
     * @return {@code true}:Email, {@code false}:not Email
     */
    public static boolean isCategoryIdEmail(int categoryId) {
        return CATEGORY_ID_EMAIL == categoryId;
    }

    /**
     * @param categoryId Category ID
     * @return {@code true}:News, {@code false}:not News
     */
    public static boolean isCategoryIdNews(int categoryId) {
        return CATEGORY_ID_NEWS == categoryId;
    }

    /**
     * @param categoryId Category ID
     * @return {@code true}:Call, {@code false}:not Call
     */
    public static boolean isCategoryIdCall(int categoryId) {
        return CATEGORY_ID_CALL == categoryId;
    }

    /**
     * @param categoryId Category ID
     * @return {@code true}:Missed call, {@code false}:not Missed call
     */
    public static boolean isCategoryIdMissedCall(int categoryId) {
        return CATEGORY_ID_MISSED_CALL == categoryId;
    }

    /**
     * @param categoryId Category ID
     * @return {@code true}:SMS/MMS, {@code false}:not SMS/MMS
     */
    public static boolean isCategoryIdSmsMms(int categoryId) {
        return CATEGORY_ID_SMS_MMS == categoryId;
    }

    /**
     * @param categoryId Category ID
     * @return {@code true}:Simple Alert, {@code false}:not Simple Alert
     */
    public static boolean isCategoryIdVoiceMail(int categoryId) {
        return CATEGORY_ID_VOICE_MAIL == categoryId;
    }

    /**
     * @param categoryId Category ID
     * @return {@code true}:Schedule, {@code false}:not Schedule
     */
    public static boolean isCategoryIdSchedule(int categoryId) {
        return CATEGORY_ID_SCHEDULE == categoryId;
    }

    /**
     * @param categoryId Category ID
     * @return {@code true}:High Prioritized Alert, {@code false}:not High Prioritized Alert
     */
    public static boolean isCategoryIdHighPrioritizedAlert(int categoryId) {
        return CATEGORY_ID_HIGH_PRIORITIZED_ALERT == categoryId;
    }

    /**
     * @param categoryId Category ID
     * @return {@code true}:Instant Message, {@code false}:not Instant Message
     */
    public static boolean isCategoryIdInstantMessage(int categoryId) {
        return CATEGORY_ID_INSTANT_MESSAGE == categoryId;
    }

}
