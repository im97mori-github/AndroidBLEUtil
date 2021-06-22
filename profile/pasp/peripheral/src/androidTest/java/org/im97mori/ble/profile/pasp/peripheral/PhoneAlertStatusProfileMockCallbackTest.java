package org.im97mori.ble.profile.pasp.peripheral;

import androidx.test.core.app.ApplicationProvider;

import org.junit.Test;

import static org.im97mori.ble.constants.ServiceUUID.PHONE_ALERT_STATUS_SERVICE;
import static org.junit.Assert.assertEquals;

@SuppressWarnings("ConstantConditions")
public class PhoneAlertStatusProfileMockCallbackTest {

    @Test
    public void test_getServiceUUID_00001() {
        assertEquals(PHONE_ALERT_STATUS_SERVICE, new PhoneAlertStatusProfileMockCallback(ApplicationProvider.getApplicationContext(), null).getServiceUUID());
    }

}
