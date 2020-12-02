package org.im97mori.ble.service.ans;

import org.im97mori.ble.characteristic.core.AlertCategoryIdUtils;

/**
 * Utility for Alert Notification Service (0x1811)
 */
public class AlertNotificationCategoryIdUtils extends AlertCategoryIdUtils {

    /**
     * 0xff: ALL
     */
    public static final int CATEGORY_ID_ALL = 0xff;

    /**
     * @param categoryId Category ID
     * @return {@code true}:All, {@code false}:not All
     */
    public static boolean isCategoryIdAll(int categoryId) {
        return CATEGORY_ID_ALL == categoryId;
    }

}
