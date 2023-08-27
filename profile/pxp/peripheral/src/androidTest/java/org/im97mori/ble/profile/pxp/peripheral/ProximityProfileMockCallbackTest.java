package org.im97mori.ble.profile.pxp.peripheral;

import androidx.test.core.app.ApplicationProvider;

import org.im97mori.ble.test.TestBase;
import org.junit.Test;

import static org.im97mori.ble.constants.ServiceUUID.LINK_LOSS_SERVICE;
import static org.junit.Assert.assertEquals;

public class ProximityProfileMockCallbackTest extends TestBase {

    /** @noinspection DataFlowIssue*/
    @Test
    public void test_getServiceUUID_00001() {
        assertEquals(LINK_LOSS_SERVICE, new ProximityProfileMockCallback(ApplicationProvider.getApplicationContext(), null, null, null).getServiceUUID());
    }

}
