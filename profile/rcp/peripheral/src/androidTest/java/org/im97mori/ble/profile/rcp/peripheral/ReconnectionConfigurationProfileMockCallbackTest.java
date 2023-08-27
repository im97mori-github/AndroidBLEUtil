package org.im97mori.ble.profile.rcp.peripheral;

import androidx.test.core.app.ApplicationProvider;

import org.im97mori.ble.test.TestBase;
import org.junit.Test;

import static org.im97mori.ble.constants.ServiceUUID.RECONNECTION_CONFIGURATION_SERVICE;
import static org.junit.Assert.assertEquals;

public class ReconnectionConfigurationProfileMockCallbackTest extends TestBase {

    /** @noinspection DataFlowIssue*/
    @Test
    public void test_getServiceUUID_00001() {
        assertEquals(RECONNECTION_CONFIGURATION_SERVICE, new ReconnectionConfigurationProfileMockCallback(ApplicationProvider.getApplicationContext(), null, null).getServiceUUID());
    }

}
