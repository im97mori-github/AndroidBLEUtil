package org.im97mori.ble.profile.rcp.peripheral;

import androidx.test.core.app.ApplicationProvider;

import org.junit.Test;

import static org.im97mori.ble.BLEConstants.ServiceUUID.RECONNECTION_CONFIGURATION_SERVICE;
import static org.junit.Assert.assertEquals;

@SuppressWarnings("ConstantConditions")
public class ReconnectionConfigurationProfileMockCallbackTest {

    @Test
    public void test_getServiceUUID_00001() {
        assertEquals(RECONNECTION_CONFIGURATION_SERVICE, new ReconnectionConfigurationProfileMockCallback(ApplicationProvider.getApplicationContext(), null, null).getServiceUUID());
    }

}
