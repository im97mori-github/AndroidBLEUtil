package org.im97mori.ble.profile.aiop.peripheral;

import androidx.test.core.app.ApplicationProvider;

import org.junit.Test;

import static org.im97mori.ble.constants.ServiceUUID.AUTOMATION_IO_SERVICE;
import static org.junit.Assert.assertEquals;

@SuppressWarnings("ConstantConditions")
public class AutomationIOProfileMockCallbackTest {

    @Test
    public void test_getServiceUUID_00001() {
        assertEquals(AUTOMATION_IO_SERVICE, new AutomationIOProfileMockCallback(ApplicationProvider.getApplicationContext(), null).getServiceUUID());
    }

}
