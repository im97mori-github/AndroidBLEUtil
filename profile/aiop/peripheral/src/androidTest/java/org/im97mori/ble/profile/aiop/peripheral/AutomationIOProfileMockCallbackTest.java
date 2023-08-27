package org.im97mori.ble.profile.aiop.peripheral;

import androidx.test.core.app.ApplicationProvider;

import org.im97mori.ble.test.TestBase;
import org.junit.Test;

import static org.im97mori.ble.constants.ServiceUUID.AUTOMATION_IO_SERVICE;
import static org.junit.Assert.assertEquals;

public class AutomationIOProfileMockCallbackTest extends TestBase {

    /** @noinspection DataFlowIssue*/
    @Test
    public void test_getServiceUUID_00001() {
        assertEquals(AUTOMATION_IO_SERVICE, new AutomationIOProfileMockCallback(ApplicationProvider.getApplicationContext(), null).getServiceUUID());
    }

}
