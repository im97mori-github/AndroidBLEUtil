package org.im97mori.ble.profile.anp.peripheral;

import androidx.test.core.app.ApplicationProvider;

import org.junit.Test;

import static org.im97mori.ble.constants.ServiceUUID.ALERT_NOTIFICATION_SERVICE;
import static org.junit.Assert.assertEquals;

public class AlertNotificationProfileMockCallbackTest {

    /** @noinspection DataFlowIssue*/
    @Test
    public void test_getServiceUUID_00001() {
        assertEquals(ALERT_NOTIFICATION_SERVICE, new AlertNotificationProfileMockCallback(ApplicationProvider.getApplicationContext(), null).getServiceUUID());
    }

}
