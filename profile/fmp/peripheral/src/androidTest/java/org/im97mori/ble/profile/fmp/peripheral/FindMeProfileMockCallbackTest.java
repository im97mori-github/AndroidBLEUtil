package org.im97mori.ble.profile.fmp.peripheral;

import androidx.test.core.app.ApplicationProvider;

import org.junit.Test;

import static org.im97mori.ble.constants.ServiceUUID.IMMEDIATE_ALERT_SERVICE;
import static org.junit.Assert.assertEquals;

public class FindMeProfileMockCallbackTest {

    /** @noinspection DataFlowIssue*/
    @Test
    public void test_getServiceUUID_00001() {
        assertEquals(IMMEDIATE_ALERT_SERVICE, new FindMeProfileMockCallback(ApplicationProvider.getApplicationContext(), null).getServiceUUID());
    }

}
