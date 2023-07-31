package org.im97mori.ble.profile.htp.peripheral;

import androidx.test.core.app.ApplicationProvider;

import org.junit.Test;

import static org.im97mori.ble.constants.ServiceUUID.HEALTH_THERMOMETER_SERVICE;
import static org.junit.Assert.assertEquals;

public class HealthThermometerProfileMockCallbackTest {

    /** @noinspection DataFlowIssue*/
    @Test
    public void test_getServiceUUID_00001() {
        assertEquals(HEALTH_THERMOMETER_SERVICE, new HealthThermometerProfileMockCallback(ApplicationProvider.getApplicationContext(), null, null).getServiceUUID());
    }

}
