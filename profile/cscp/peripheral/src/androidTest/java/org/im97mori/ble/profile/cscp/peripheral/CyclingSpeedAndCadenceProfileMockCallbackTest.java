package org.im97mori.ble.profile.cscp.peripheral;

import androidx.test.core.app.ApplicationProvider;

import org.im97mori.ble.test.TestBase;
import org.junit.Test;

import static org.im97mori.ble.constants.ServiceUUID.CYCLING_SPEED_AND_CADENCE_SERVICE;
import static org.junit.Assert.assertEquals;

public class CyclingSpeedAndCadenceProfileMockCallbackTest extends TestBase {

    /** @noinspection DataFlowIssue*/
    @Test
    public void test_getServiceUUID_00001() {
        assertEquals(CYCLING_SPEED_AND_CADENCE_SERVICE, new CyclingSpeedAndCadenceProfileMockCallback(ApplicationProvider.getApplicationContext(), null, null).getServiceUUID());
    }

}
