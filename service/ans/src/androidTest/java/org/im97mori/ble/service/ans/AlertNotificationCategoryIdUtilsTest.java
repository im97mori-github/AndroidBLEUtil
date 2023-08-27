package org.im97mori.ble.service.ans;

import org.im97mori.ble.test.TestBase;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class AlertNotificationCategoryIdUtilsTest extends TestBase {

    @Test
    public void test_isCategoryIdAll_00001() {
        assertFalse(AlertNotificationCategoryIdUtils.isCategoryIdAll(AlertNotificationCategoryIdUtils.CATEGORY_ID_SIMPLE_ALERT));
        assertFalse(AlertNotificationCategoryIdUtils.isCategoryIdAll(AlertNotificationCategoryIdUtils.CATEGORY_ID_EMAIL));
        assertFalse(AlertNotificationCategoryIdUtils.isCategoryIdAll(AlertNotificationCategoryIdUtils.CATEGORY_ID_NEWS));
        assertFalse(AlertNotificationCategoryIdUtils.isCategoryIdAll(AlertNotificationCategoryIdUtils.CATEGORY_ID_CALL));
        assertFalse(AlertNotificationCategoryIdUtils.isCategoryIdAll(AlertNotificationCategoryIdUtils.CATEGORY_ID_MISSED_CALL));
        assertFalse(AlertNotificationCategoryIdUtils.isCategoryIdAll(AlertNotificationCategoryIdUtils.CATEGORY_ID_SMS_MMS));
        assertFalse(AlertNotificationCategoryIdUtils.isCategoryIdAll(AlertNotificationCategoryIdUtils.CATEGORY_ID_VOICE_MAIL));
        assertFalse(AlertNotificationCategoryIdUtils.isCategoryIdAll(AlertNotificationCategoryIdUtils.CATEGORY_ID_SCHEDULE));
        assertFalse(AlertNotificationCategoryIdUtils.isCategoryIdAll(AlertNotificationCategoryIdUtils.CATEGORY_ID_HIGH_PRIORITIZED_ALERT));
        assertFalse(AlertNotificationCategoryIdUtils.isCategoryIdAll(AlertNotificationCategoryIdUtils.CATEGORY_ID_INSTANT_MESSAGE));
        assertTrue(AlertNotificationCategoryIdUtils.isCategoryIdAll(AlertNotificationCategoryIdUtils.CATEGORY_ID_ALL));
    }

}
