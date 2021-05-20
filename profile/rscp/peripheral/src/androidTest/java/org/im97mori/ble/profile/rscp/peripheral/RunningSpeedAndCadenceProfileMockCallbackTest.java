package org.im97mori.ble.profile.rscp.peripheral;

import androidx.test.core.app.ApplicationProvider;

import org.junit.Test;

import static org.im97mori.ble.BLEConstants.ServiceUUID.RUNNING_SPEED_AND_CADENCE_SERVICE;
import static org.junit.Assert.assertEquals;

@SuppressWarnings("ConstantConditions")
public class RunningSpeedAndCadenceProfileMockCallbackTest {

    @Test
    public void test_getServiceUUID_00001() {
        assertEquals(RUNNING_SPEED_AND_CADENCE_SERVICE, new RunningSpeedAndCadenceProfileMockCallback(ApplicationProvider.getApplicationContext(), null, null).getServiceUUID());
    }

}
