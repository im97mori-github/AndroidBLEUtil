package org.im97mori.ble.profile.hrp.peripheral;

import androidx.test.core.app.ApplicationProvider;

import org.im97mori.ble.test.TestBase;
import org.junit.Test;

import static org.im97mori.ble.constants.ServiceUUID.HEART_RATE_SERVICE;
import static org.junit.Assert.assertEquals;

public class HeartRateProfileMockCallbackTest extends TestBase {

    /** @noinspection DataFlowIssue*/
    @Test
    public void test_getServiceUUID_00001() {
        assertEquals(HEART_RATE_SERVICE, new HeartRateProfileMockCallback(ApplicationProvider.getApplicationContext(), null, null).getServiceUUID());
    }

}
