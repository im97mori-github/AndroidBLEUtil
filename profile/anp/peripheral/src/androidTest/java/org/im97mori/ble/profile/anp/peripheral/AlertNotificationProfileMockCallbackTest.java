package org.im97mori.ble.profile.anp.peripheral;

import androidx.test.core.app.ApplicationProvider;

import org.junit.Test;

import static org.im97mori.ble.BLEConstants.ServiceUUID.ALERT_NOTIFICATION_SERVICE;
import static org.junit.Assert.assertEquals;

@SuppressWarnings("ConstantConditions")
public class AlertNotificationProfileMockCallbackTest {

    @Test
    public void test_getServiceUUID_00001() {
        assertEquals(ALERT_NOTIFICATION_SERVICE, new AlertNotificationProfileMockCallback(ApplicationProvider.getApplicationContext(), null).getServiceUUID());
    }

}
