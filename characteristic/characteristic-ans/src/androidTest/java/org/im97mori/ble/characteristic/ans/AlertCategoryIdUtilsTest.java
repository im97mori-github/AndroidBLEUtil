package org.im97mori.ble.characteristic.ans;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class AlertCategoryIdUtilsTest {

    @Test
    public void test_isCategoryIdSimpleAlert001() {
        assertTrue(AlertCategoryIdUtils.isCategoryIdSimpleAlert(AlertCategoryIdUtils.CATEGORY_ID_SIMPLE_ALERT));
        assertFalse(AlertCategoryIdUtils.isCategoryIdSimpleAlert(AlertCategoryIdUtils.CATEGORY_ID_EMAIL));
        assertFalse(AlertCategoryIdUtils.isCategoryIdSimpleAlert(AlertCategoryIdUtils.CATEGORY_ID_NEWS));
        assertFalse(AlertCategoryIdUtils.isCategoryIdSimpleAlert(AlertCategoryIdUtils.CATEGORY_ID_CALL));
        assertFalse(AlertCategoryIdUtils.isCategoryIdSimpleAlert(AlertCategoryIdUtils.CATEGORY_ID_MISSED_CALL));
        assertFalse(AlertCategoryIdUtils.isCategoryIdSimpleAlert(AlertCategoryIdUtils.CATEGORY_ID_SMS_MMS));
        assertFalse(AlertCategoryIdUtils.isCategoryIdSimpleAlert(AlertCategoryIdUtils.CATEGORY_ID_VOICE_MAIL));
        assertFalse(AlertCategoryIdUtils.isCategoryIdSimpleAlert(AlertCategoryIdUtils.CATEGORY_ID_SCHEDULE));
        assertFalse(AlertCategoryIdUtils.isCategoryIdSimpleAlert(AlertCategoryIdUtils.CATEGORY_ID_HIGH_PRIORITIZED_ALERT));
        assertFalse(AlertCategoryIdUtils.isCategoryIdSimpleAlert(AlertCategoryIdUtils.CATEGORY_ID_INSTANT_MESSAGE));
    }

    @Test
    public void test_isCategoryIdEmail001() {
        assertFalse(AlertCategoryIdUtils.isCategoryIdEmail(AlertCategoryIdUtils.CATEGORY_ID_SIMPLE_ALERT));
        assertTrue(AlertCategoryIdUtils.isCategoryIdEmail(AlertCategoryIdUtils.CATEGORY_ID_EMAIL));
        assertFalse(AlertCategoryIdUtils.isCategoryIdEmail(AlertCategoryIdUtils.CATEGORY_ID_NEWS));
        assertFalse(AlertCategoryIdUtils.isCategoryIdEmail(AlertCategoryIdUtils.CATEGORY_ID_CALL));
        assertFalse(AlertCategoryIdUtils.isCategoryIdEmail(AlertCategoryIdUtils.CATEGORY_ID_MISSED_CALL));
        assertFalse(AlertCategoryIdUtils.isCategoryIdEmail(AlertCategoryIdUtils.CATEGORY_ID_SMS_MMS));
        assertFalse(AlertCategoryIdUtils.isCategoryIdEmail(AlertCategoryIdUtils.CATEGORY_ID_VOICE_MAIL));
        assertFalse(AlertCategoryIdUtils.isCategoryIdEmail(AlertCategoryIdUtils.CATEGORY_ID_SCHEDULE));
        assertFalse(AlertCategoryIdUtils.isCategoryIdEmail(AlertCategoryIdUtils.CATEGORY_ID_HIGH_PRIORITIZED_ALERT));
        assertFalse(AlertCategoryIdUtils.isCategoryIdEmail(AlertCategoryIdUtils.CATEGORY_ID_INSTANT_MESSAGE));
    }

    @Test
    public void test_isCategoryIdNews001() {
        assertFalse(AlertCategoryIdUtils.isCategoryIdNews(AlertCategoryIdUtils.CATEGORY_ID_SIMPLE_ALERT));
        assertFalse(AlertCategoryIdUtils.isCategoryIdNews(AlertCategoryIdUtils.CATEGORY_ID_EMAIL));
        assertTrue(AlertCategoryIdUtils.isCategoryIdNews(AlertCategoryIdUtils.CATEGORY_ID_NEWS));
        assertFalse(AlertCategoryIdUtils.isCategoryIdNews(AlertCategoryIdUtils.CATEGORY_ID_CALL));
        assertFalse(AlertCategoryIdUtils.isCategoryIdNews(AlertCategoryIdUtils.CATEGORY_ID_MISSED_CALL));
        assertFalse(AlertCategoryIdUtils.isCategoryIdNews(AlertCategoryIdUtils.CATEGORY_ID_SMS_MMS));
        assertFalse(AlertCategoryIdUtils.isCategoryIdNews(AlertCategoryIdUtils.CATEGORY_ID_VOICE_MAIL));
        assertFalse(AlertCategoryIdUtils.isCategoryIdNews(AlertCategoryIdUtils.CATEGORY_ID_SCHEDULE));
        assertFalse(AlertCategoryIdUtils.isCategoryIdNews(AlertCategoryIdUtils.CATEGORY_ID_HIGH_PRIORITIZED_ALERT));
        assertFalse(AlertCategoryIdUtils.isCategoryIdNews(AlertCategoryIdUtils.CATEGORY_ID_INSTANT_MESSAGE));
    }

    @Test
    public void test_isCategoryIdCall001() {
        assertFalse(AlertCategoryIdUtils.isCategoryIdCall(AlertCategoryIdUtils.CATEGORY_ID_SIMPLE_ALERT));
        assertFalse(AlertCategoryIdUtils.isCategoryIdCall(AlertCategoryIdUtils.CATEGORY_ID_EMAIL));
        assertFalse(AlertCategoryIdUtils.isCategoryIdCall(AlertCategoryIdUtils.CATEGORY_ID_NEWS));
        assertTrue(AlertCategoryIdUtils.isCategoryIdCall(AlertCategoryIdUtils.CATEGORY_ID_CALL));
        assertFalse(AlertCategoryIdUtils.isCategoryIdCall(AlertCategoryIdUtils.CATEGORY_ID_MISSED_CALL));
        assertFalse(AlertCategoryIdUtils.isCategoryIdCall(AlertCategoryIdUtils.CATEGORY_ID_SMS_MMS));
        assertFalse(AlertCategoryIdUtils.isCategoryIdCall(AlertCategoryIdUtils.CATEGORY_ID_VOICE_MAIL));
        assertFalse(AlertCategoryIdUtils.isCategoryIdCall(AlertCategoryIdUtils.CATEGORY_ID_SCHEDULE));
        assertFalse(AlertCategoryIdUtils.isCategoryIdCall(AlertCategoryIdUtils.CATEGORY_ID_HIGH_PRIORITIZED_ALERT));
        assertFalse(AlertCategoryIdUtils.isCategoryIdCall(AlertCategoryIdUtils.CATEGORY_ID_INSTANT_MESSAGE));
    }

    @Test
    public void test_isCategoryIdMissedCall001() {
        assertFalse(AlertCategoryIdUtils.isCategoryIdMissedCall(AlertCategoryIdUtils.CATEGORY_ID_SIMPLE_ALERT));
        assertFalse(AlertCategoryIdUtils.isCategoryIdMissedCall(AlertCategoryIdUtils.CATEGORY_ID_EMAIL));
        assertFalse(AlertCategoryIdUtils.isCategoryIdMissedCall(AlertCategoryIdUtils.CATEGORY_ID_NEWS));
        assertFalse(AlertCategoryIdUtils.isCategoryIdMissedCall(AlertCategoryIdUtils.CATEGORY_ID_CALL));
        assertTrue(AlertCategoryIdUtils.isCategoryIdMissedCall(AlertCategoryIdUtils.CATEGORY_ID_MISSED_CALL));
        assertFalse(AlertCategoryIdUtils.isCategoryIdMissedCall(AlertCategoryIdUtils.CATEGORY_ID_SMS_MMS));
        assertFalse(AlertCategoryIdUtils.isCategoryIdMissedCall(AlertCategoryIdUtils.CATEGORY_ID_VOICE_MAIL));
        assertFalse(AlertCategoryIdUtils.isCategoryIdMissedCall(AlertCategoryIdUtils.CATEGORY_ID_SCHEDULE));
        assertFalse(AlertCategoryIdUtils.isCategoryIdMissedCall(AlertCategoryIdUtils.CATEGORY_ID_HIGH_PRIORITIZED_ALERT));
        assertFalse(AlertCategoryIdUtils.isCategoryIdMissedCall(AlertCategoryIdUtils.CATEGORY_ID_INSTANT_MESSAGE));
    }

    @Test
    public void test_isCategoryIdSmsMms001() {
        assertFalse(AlertCategoryIdUtils.isCategoryIdSmsMms(AlertCategoryIdUtils.CATEGORY_ID_SIMPLE_ALERT));
        assertFalse(AlertCategoryIdUtils.isCategoryIdSmsMms(AlertCategoryIdUtils.CATEGORY_ID_EMAIL));
        assertFalse(AlertCategoryIdUtils.isCategoryIdSmsMms(AlertCategoryIdUtils.CATEGORY_ID_NEWS));
        assertFalse(AlertCategoryIdUtils.isCategoryIdSmsMms(AlertCategoryIdUtils.CATEGORY_ID_CALL));
        assertFalse(AlertCategoryIdUtils.isCategoryIdSmsMms(AlertCategoryIdUtils.CATEGORY_ID_MISSED_CALL));
        assertTrue(AlertCategoryIdUtils.isCategoryIdSmsMms(AlertCategoryIdUtils.CATEGORY_ID_SMS_MMS));
        assertFalse(AlertCategoryIdUtils.isCategoryIdSmsMms(AlertCategoryIdUtils.CATEGORY_ID_VOICE_MAIL));
        assertFalse(AlertCategoryIdUtils.isCategoryIdSmsMms(AlertCategoryIdUtils.CATEGORY_ID_SCHEDULE));
        assertFalse(AlertCategoryIdUtils.isCategoryIdSmsMms(AlertCategoryIdUtils.CATEGORY_ID_HIGH_PRIORITIZED_ALERT));
        assertFalse(AlertCategoryIdUtils.isCategoryIdSmsMms(AlertCategoryIdUtils.CATEGORY_ID_INSTANT_MESSAGE));
    }

    @Test
    public void test_isCategoryIdVoiceMail001() {
        assertFalse(AlertCategoryIdUtils.isCategoryIdVoiceMail(AlertCategoryIdUtils.CATEGORY_ID_SIMPLE_ALERT));
        assertFalse(AlertCategoryIdUtils.isCategoryIdVoiceMail(AlertCategoryIdUtils.CATEGORY_ID_EMAIL));
        assertFalse(AlertCategoryIdUtils.isCategoryIdVoiceMail(AlertCategoryIdUtils.CATEGORY_ID_NEWS));
        assertFalse(AlertCategoryIdUtils.isCategoryIdVoiceMail(AlertCategoryIdUtils.CATEGORY_ID_CALL));
        assertFalse(AlertCategoryIdUtils.isCategoryIdVoiceMail(AlertCategoryIdUtils.CATEGORY_ID_MISSED_CALL));
        assertFalse(AlertCategoryIdUtils.isCategoryIdVoiceMail(AlertCategoryIdUtils.CATEGORY_ID_SMS_MMS));
        assertTrue(AlertCategoryIdUtils.isCategoryIdVoiceMail(AlertCategoryIdUtils.CATEGORY_ID_VOICE_MAIL));
        assertFalse(AlertCategoryIdUtils.isCategoryIdVoiceMail(AlertCategoryIdUtils.CATEGORY_ID_SCHEDULE));
        assertFalse(AlertCategoryIdUtils.isCategoryIdVoiceMail(AlertCategoryIdUtils.CATEGORY_ID_HIGH_PRIORITIZED_ALERT));
        assertFalse(AlertCategoryIdUtils.isCategoryIdVoiceMail(AlertCategoryIdUtils.CATEGORY_ID_INSTANT_MESSAGE));
    }

    @Test
    public void test_isCategoryIdSchedule001() {
        assertFalse(AlertCategoryIdUtils.isCategoryIdSchedule(AlertCategoryIdUtils.CATEGORY_ID_SIMPLE_ALERT));
        assertFalse(AlertCategoryIdUtils.isCategoryIdSchedule(AlertCategoryIdUtils.CATEGORY_ID_EMAIL));
        assertFalse(AlertCategoryIdUtils.isCategoryIdSchedule(AlertCategoryIdUtils.CATEGORY_ID_NEWS));
        assertFalse(AlertCategoryIdUtils.isCategoryIdSchedule(AlertCategoryIdUtils.CATEGORY_ID_CALL));
        assertFalse(AlertCategoryIdUtils.isCategoryIdSchedule(AlertCategoryIdUtils.CATEGORY_ID_MISSED_CALL));
        assertFalse(AlertCategoryIdUtils.isCategoryIdSchedule(AlertCategoryIdUtils.CATEGORY_ID_SMS_MMS));
        assertFalse(AlertCategoryIdUtils.isCategoryIdSchedule(AlertCategoryIdUtils.CATEGORY_ID_VOICE_MAIL));
        assertTrue(AlertCategoryIdUtils.isCategoryIdSchedule(AlertCategoryIdUtils.CATEGORY_ID_SCHEDULE));
        assertFalse(AlertCategoryIdUtils.isCategoryIdSchedule(AlertCategoryIdUtils.CATEGORY_ID_HIGH_PRIORITIZED_ALERT));
        assertFalse(AlertCategoryIdUtils.isCategoryIdSchedule(AlertCategoryIdUtils.CATEGORY_ID_INSTANT_MESSAGE));
    }

    @Test
    public void test_isCategoryIdHighPrioritizedAlert001() {
        assertFalse(AlertCategoryIdUtils.isCategoryIdHighPrioritizedAlert(AlertCategoryIdUtils.CATEGORY_ID_SIMPLE_ALERT));
        assertFalse(AlertCategoryIdUtils.isCategoryIdHighPrioritizedAlert(AlertCategoryIdUtils.CATEGORY_ID_EMAIL));
        assertFalse(AlertCategoryIdUtils.isCategoryIdHighPrioritizedAlert(AlertCategoryIdUtils.CATEGORY_ID_NEWS));
        assertFalse(AlertCategoryIdUtils.isCategoryIdHighPrioritizedAlert(AlertCategoryIdUtils.CATEGORY_ID_CALL));
        assertFalse(AlertCategoryIdUtils.isCategoryIdHighPrioritizedAlert(AlertCategoryIdUtils.CATEGORY_ID_MISSED_CALL));
        assertFalse(AlertCategoryIdUtils.isCategoryIdHighPrioritizedAlert(AlertCategoryIdUtils.CATEGORY_ID_SMS_MMS));
        assertFalse(AlertCategoryIdUtils.isCategoryIdHighPrioritizedAlert(AlertCategoryIdUtils.CATEGORY_ID_VOICE_MAIL));
        assertFalse(AlertCategoryIdUtils.isCategoryIdHighPrioritizedAlert(AlertCategoryIdUtils.CATEGORY_ID_SCHEDULE));
        assertTrue(AlertCategoryIdUtils.isCategoryIdHighPrioritizedAlert(AlertCategoryIdUtils.CATEGORY_ID_HIGH_PRIORITIZED_ALERT));
        assertFalse(AlertCategoryIdUtils.isCategoryIdHighPrioritizedAlert(AlertCategoryIdUtils.CATEGORY_ID_INSTANT_MESSAGE));
    }

    @Test
    public void test_isCategoryIdInstantMessage01() {
        assertFalse(AlertCategoryIdUtils.isCategoryIdInstantMessage(AlertCategoryIdUtils.CATEGORY_ID_SIMPLE_ALERT));
        assertFalse(AlertCategoryIdUtils.isCategoryIdInstantMessage(AlertCategoryIdUtils.CATEGORY_ID_EMAIL));
        assertFalse(AlertCategoryIdUtils.isCategoryIdInstantMessage(AlertCategoryIdUtils.CATEGORY_ID_NEWS));
        assertFalse(AlertCategoryIdUtils.isCategoryIdInstantMessage(AlertCategoryIdUtils.CATEGORY_ID_CALL));
        assertFalse(AlertCategoryIdUtils.isCategoryIdInstantMessage(AlertCategoryIdUtils.CATEGORY_ID_MISSED_CALL));
        assertFalse(AlertCategoryIdUtils.isCategoryIdInstantMessage(AlertCategoryIdUtils.CATEGORY_ID_SMS_MMS));
        assertFalse(AlertCategoryIdUtils.isCategoryIdInstantMessage(AlertCategoryIdUtils.CATEGORY_ID_VOICE_MAIL));
        assertFalse(AlertCategoryIdUtils.isCategoryIdInstantMessage(AlertCategoryIdUtils.CATEGORY_ID_SCHEDULE));
        assertFalse(AlertCategoryIdUtils.isCategoryIdInstantMessage(AlertCategoryIdUtils.CATEGORY_ID_HIGH_PRIORITIZED_ALERT));
        assertTrue(AlertCategoryIdUtils.isCategoryIdInstantMessage(AlertCategoryIdUtils.CATEGORY_ID_INSTANT_MESSAGE));
    }

}
