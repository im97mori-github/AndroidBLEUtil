package org.im97mori.ble.characteristic.ans;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class AlertCategoryIdBitMaskUtilsTest {

    @Test
    public void test_isCategoryIdBitMask0SimpleAlertNotSupported001() {
        assertTrue(AlertCategoryIdBitMaskUtils.isCategoryIdBitMask0SimpleAlertNotSupported(AlertCategoryIdBitMaskUtils.CATEGORY_ID_BIT_MASK_0_SIMPLE_ALERT_NOT_SUPPORTED));
    }

    @Test
    public void test_isCategoryIdBitMask0SimpleAlertNotSupported002() {
        assertFalse(AlertCategoryIdBitMaskUtils.isCategoryIdBitMask0SimpleAlertNotSupported(AlertCategoryIdBitMaskUtils.CATEGORY_ID_BIT_MASK_0_SIMPLE_ALERT_SUPPORTED));
    }

    @Test
    public void test_isCategoryIdBitMask0SimpleAlertSupported001() {
        assertFalse(AlertCategoryIdBitMaskUtils.isCategoryIdBitMask0SimpleAlertSupported(AlertCategoryIdBitMaskUtils.CATEGORY_ID_BIT_MASK_0_SIMPLE_ALERT_NOT_SUPPORTED));
    }

    @Test
    public void test_isCategoryIdBitMask0SimpleAlertSupported002() {
        assertTrue(AlertCategoryIdBitMaskUtils.isCategoryIdBitMask0SimpleAlertSupported(AlertCategoryIdBitMaskUtils.CATEGORY_ID_BIT_MASK_0_SIMPLE_ALERT_SUPPORTED));
    }

    @Test
    public void test_isCategoryIdBitMask0EmailNotSupported001() {
        assertTrue(AlertCategoryIdBitMaskUtils.isCategoryIdBitMask0EmailNotSupported(AlertCategoryIdBitMaskUtils.CATEGORY_ID_BIT_MASK_0_EMAIL_NOT_SUPPORTED));
    }

    @Test
    public void test_isCategoryIdBitMask0EmailNotSupported002() {
        assertFalse(AlertCategoryIdBitMaskUtils.isCategoryIdBitMask0EmailNotSupported(AlertCategoryIdBitMaskUtils.CATEGORY_ID_BIT_MASK_0_EMAIL_SUPPORTED));
    }

    @Test
    public void test_isCategoryIdBitMask0EmailSupported001() {
        assertFalse(AlertCategoryIdBitMaskUtils.isCategoryIdBitMask0EmailSupported(AlertCategoryIdBitMaskUtils.CATEGORY_ID_BIT_MASK_0_EMAIL_NOT_SUPPORTED));
    }

    @Test
    public void test_isCategoryIdBitMask0EmailSupported002() {
        assertTrue(AlertCategoryIdBitMaskUtils.isCategoryIdBitMask0EmailSupported(AlertCategoryIdBitMaskUtils.CATEGORY_ID_BIT_MASK_0_EMAIL_SUPPORTED));
    }

    @Test
    public void test_isCategoryIdBitMask0NewsNotSupported001() {
        assertTrue(AlertCategoryIdBitMaskUtils.isCategoryIdBitMask0NewsNotSupported(AlertCategoryIdBitMaskUtils.CATEGORY_ID_BIT_MASK_0_NEWS_NOT_SUPPORTED));
    }

    @Test
    public void test_isCategoryIdBitMask0NewsNotSupported002() {
        assertFalse(AlertCategoryIdBitMaskUtils.isCategoryIdBitMask0NewsNotSupported(AlertCategoryIdBitMaskUtils.CATEGORY_ID_BIT_MASK_0_NEWS_SUPPORTED));
    }

    @Test
    public void test_isCategoryIdBitMask0NewsSupported001() {
        assertFalse(AlertCategoryIdBitMaskUtils.isCategoryIdBitMask0NewsSupported(AlertCategoryIdBitMaskUtils.CATEGORY_ID_BIT_MASK_0_NEWS_NOT_SUPPORTED));
    }

    @Test
    public void test_isCategoryIdBitMask0NewsSupported002() {
        assertTrue(AlertCategoryIdBitMaskUtils.isCategoryIdBitMask0NewsSupported(AlertCategoryIdBitMaskUtils.CATEGORY_ID_BIT_MASK_0_NEWS_SUPPORTED));
    }

    @Test
    public void test_isCategoryIdBitMask0CallNotSupported001() {
        assertTrue(AlertCategoryIdBitMaskUtils.isCategoryIdBitMask0CallNotSupported(AlertCategoryIdBitMaskUtils.CATEGORY_ID_BIT_MASK_0_CALL_NOT_SUPPORTED));
    }

    @Test
    public void test_isCategoryIdBitMask0CallNotSupported002() {
        assertFalse(AlertCategoryIdBitMaskUtils.isCategoryIdBitMask0CallNotSupported(AlertCategoryIdBitMaskUtils.CATEGORY_ID_BIT_MASK_0_CALL_SUPPORTED));
    }

    @Test
    public void test_isCategoryIdBitMask0CallSupported001() {
        assertFalse(AlertCategoryIdBitMaskUtils.isCategoryIdBitMask0CallSupported(AlertCategoryIdBitMaskUtils.CATEGORY_ID_BIT_MASK_0_CALL_NOT_SUPPORTED));
    }

    @Test
    public void test_isCategoryIdBitMask0CallSupported002() {
        assertTrue(AlertCategoryIdBitMaskUtils.isCategoryIdBitMask0CallSupported(AlertCategoryIdBitMaskUtils.CATEGORY_ID_BIT_MASK_0_CALL_SUPPORTED));
    }

    @Test
    public void test_isCategoryIdBitMask0MissedCallNotSupported001() {
        assertTrue(AlertCategoryIdBitMaskUtils.isCategoryIdBitMask0MissedCallNotSupported(AlertCategoryIdBitMaskUtils.CATEGORY_ID_BIT_MASK_0_MISSED_CALL_NOT_SUPPORTED));
    }

    @Test
    public void test_isCategoryIdBitMask0MissedCallNotSupported002() {
        assertFalse(AlertCategoryIdBitMaskUtils.isCategoryIdBitMask0MissedCallNotSupported(AlertCategoryIdBitMaskUtils.CATEGORY_ID_BIT_MASK_0_MISSED_CALL_SUPPORTED));
    }

    @Test
    public void test_isCategoryIdBitMask0MissedCallSupported001() {
        assertFalse(AlertCategoryIdBitMaskUtils.isCategoryIdBitMask0MissedCallSupported(AlertCategoryIdBitMaskUtils.CATEGORY_ID_BIT_MASK_0_MISSED_CALL_NOT_SUPPORTED));
    }

    @Test
    public void test_isCategoryIdBitMask0MissedCallSupported002() {
        assertTrue(AlertCategoryIdBitMaskUtils.isCategoryIdBitMask0MissedCallSupported(AlertCategoryIdBitMaskUtils.CATEGORY_ID_BIT_MASK_0_MISSED_CALL_SUPPORTED));
    }

    @Test
    public void test_isCategoryIdBitMask0SmsMmsNotSupported001() {
        assertTrue(AlertCategoryIdBitMaskUtils.isCategoryIdBitMask0SmsMmsNotSupported(AlertCategoryIdBitMaskUtils.CATEGORY_ID_BIT_MASK_0_SMS_MMS_NOT_SUPPORTED));
    }

    @Test
    public void test_isCategoryIdBitMask0SmsMmsNotSupported002() {
        assertFalse(AlertCategoryIdBitMaskUtils.isCategoryIdBitMask0SmsMmsNotSupported(AlertCategoryIdBitMaskUtils.CATEGORY_ID_BIT_MASK_0_SMS_MMS_SUPPORTED));
    }

    @Test
    public void test_isCategoryIdBitMask0SmsMmsSupported001() {
        assertFalse(AlertCategoryIdBitMaskUtils.isCategoryIdBitMask0SmsMmsSupported(AlertCategoryIdBitMaskUtils.CATEGORY_ID_BIT_MASK_0_SMS_MMS_NOT_SUPPORTED));
    }

    @Test
    public void test_isCategoryIdBitMask0SmsMmsSupported002() {
        assertTrue(AlertCategoryIdBitMaskUtils.isCategoryIdBitMask0SmsMmsSupported(AlertCategoryIdBitMaskUtils.CATEGORY_ID_BIT_MASK_0_SMS_MMS_SUPPORTED));
    }

    @Test
    public void test_isCategoryIdBitMask0VoiceMailNotSupported001() {
        assertTrue(AlertCategoryIdBitMaskUtils.isCategoryIdBitMask0VoiceMailNotSupported(AlertCategoryIdBitMaskUtils.CATEGORY_ID_BIT_MASK_0_VOICE_MAIL_NOT_SUPPORTED));
    }

    @Test
    public void test_isCategoryIdBitMask0VoiceMailNotSupported002() {
        assertFalse(AlertCategoryIdBitMaskUtils.isCategoryIdBitMask0VoiceMailNotSupported(AlertCategoryIdBitMaskUtils.CATEGORY_ID_BIT_MASK_0_VOICE_MAIL_SUPPORTED));
    }

    @Test
    public void test_isCategoryIdBitMask0VoiceMailSupported001() {
        assertFalse(AlertCategoryIdBitMaskUtils.isCategoryIdBitMask0VoiceMailSupported(AlertCategoryIdBitMaskUtils.CATEGORY_ID_BIT_MASK_0_VOICE_MAIL_NOT_SUPPORTED));
    }

    @Test
    public void test_isCategoryIdBitMask0VoiceMailSupported002() {
        assertTrue(AlertCategoryIdBitMaskUtils.isCategoryIdBitMask0VoiceMailSupported(AlertCategoryIdBitMaskUtils.CATEGORY_ID_BIT_MASK_0_VOICE_MAIL_SUPPORTED));
    }

    @Test
    public void test_isCategoryIdBitMask0ScheduleNotSupported001() {
        assertTrue(AlertCategoryIdBitMaskUtils.isCategoryIdBitMask0ScheduleNotSupported(AlertCategoryIdBitMaskUtils.CATEGORY_ID_BIT_MASK_0_SCHEDULE_NOT_SUPPORTED));
    }

    @Test
    public void test_isCategoryIdBitMask0ScheduleNotSupported002() {
        assertFalse(AlertCategoryIdBitMaskUtils.isCategoryIdBitMask0ScheduleNotSupported(AlertCategoryIdBitMaskUtils.CATEGORY_ID_BIT_MASK_0_SCHEDULE_SUPPORTED));
    }

    @Test
    public void test_isCategoryIdBitMask0ScheduleSupported001() {
        assertFalse(AlertCategoryIdBitMaskUtils.isCategoryIdBitMask0ScheduleSupported(AlertCategoryIdBitMaskUtils.CATEGORY_ID_BIT_MASK_0_SCHEDULE_NOT_SUPPORTED));
    }

    @Test
    public void test_isCategoryIdBitMask0ScheduleSupported002() {
        assertTrue(AlertCategoryIdBitMaskUtils.isCategoryIdBitMask0ScheduleSupported(AlertCategoryIdBitMaskUtils.CATEGORY_ID_BIT_MASK_0_SCHEDULE_SUPPORTED));
    }

    @Test
    public void test_isCategoryIdBitMask1HighPrioritizedAlertNotSupported001() {
        assertTrue(AlertCategoryIdBitMaskUtils.isCategoryIdBitMask1HighPrioritizedAlertNotSupported(AlertCategoryIdBitMaskUtils.CATEGORY_ID_BIT_MASK_1_HIGH_PRIORITIZED_NOT_SUPPORTED));
    }

    @Test
    public void test_isCategoryIdBitMask1HighPrioritizedAlertNotSupported002() {
        assertFalse(AlertCategoryIdBitMaskUtils.isCategoryIdBitMask1HighPrioritizedAlertNotSupported(AlertCategoryIdBitMaskUtils.CATEGORY_ID_BIT_MASK_1_HIGH_PRIORITIZED_SUPPORTED));
    }

    @Test
    public void test_isCategoryIdBitMask1HighPrioritizedAlertSupported001() {
        assertFalse(AlertCategoryIdBitMaskUtils.isCategoryIdBitMask1HighPrioritizedAlertSupported(AlertCategoryIdBitMaskUtils.CATEGORY_ID_BIT_MASK_1_HIGH_PRIORITIZED_NOT_SUPPORTED));
    }

    @Test
    public void test_isCategoryIdBitMask1HighPrioritizedAlertSupported002() {
        assertTrue(AlertCategoryIdBitMaskUtils.isCategoryIdBitMask1HighPrioritizedAlertSupported(AlertCategoryIdBitMaskUtils.CATEGORY_ID_BIT_MASK_1_HIGH_PRIORITIZED_SUPPORTED));
    }

    @Test
    public void test_isCategoryIdBitMask1InstantMessageNotSupported001() {
        assertTrue(AlertCategoryIdBitMaskUtils.isCategoryIdBitMask1InstantMessageNotSupported(AlertCategoryIdBitMaskUtils.CATEGORY_ID_BIT_MASK_1_INSTANT_MESSAGE_NOT_SUPPORTED));
    }

    @Test
    public void test_isCategoryIdBitMask1InstantMessageNotSupported002() {
        assertFalse(AlertCategoryIdBitMaskUtils.isCategoryIdBitMask1InstantMessageNotSupported(AlertCategoryIdBitMaskUtils.CATEGORY_ID_BIT_MASK_1_INSTANT_MESSAGE_SUPPORTED));
    }

    @Test
    public void test_isCategoryIdBitMask1InstantMessageAlertSupported001() {
        assertFalse(AlertCategoryIdBitMaskUtils.isCategoryIdBitMask1InstantMessageAlertSupported(AlertCategoryIdBitMaskUtils.CATEGORY_ID_BIT_MASK_1_INSTANT_MESSAGE_NOT_SUPPORTED));
    }

    @Test
    public void test_isCategoryIdBitMask1InstantMessageAlertSupported002() {
        assertTrue(AlertCategoryIdBitMaskUtils.isCategoryIdBitMask1InstantMessageAlertSupported(AlertCategoryIdBitMaskUtils.CATEGORY_ID_BIT_MASK_1_INSTANT_MESSAGE_SUPPORTED));
    }

}
