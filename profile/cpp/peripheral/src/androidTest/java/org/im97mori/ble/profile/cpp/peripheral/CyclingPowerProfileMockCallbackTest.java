package org.im97mori.ble.profile.cpp.peripheral;

import androidx.test.core.app.ApplicationProvider;

import org.im97mori.ble.test.TestBase;
import org.junit.Test;

import static org.im97mori.ble.constants.ServiceUUID.CYCLING_POWER_SERVICE;
import static org.junit.Assert.assertEquals;

public class CyclingPowerProfileMockCallbackTest extends TestBase {

    /** @noinspection DataFlowIssue*/
    @Test
    public void test_getServiceUUID_00001() {
        assertEquals(CYCLING_POWER_SERVICE, new CyclingPowerProfileMockCallback(ApplicationProvider.getApplicationContext(), null, null, null).getServiceUUID());
    }

}
