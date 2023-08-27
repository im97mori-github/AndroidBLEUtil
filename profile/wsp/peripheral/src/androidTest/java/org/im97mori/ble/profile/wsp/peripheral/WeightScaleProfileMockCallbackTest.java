package org.im97mori.ble.profile.wsp.peripheral;

import androidx.test.core.app.ApplicationProvider;

import org.im97mori.ble.test.TestBase;
import org.junit.Test;

import static org.im97mori.ble.constants.ServiceUUID.WEIGHT_SCALE_SERVICE;
import static org.junit.Assert.assertEquals;

public class WeightScaleProfileMockCallbackTest extends TestBase {

    /** @noinspection DataFlowIssue*/
    @Test
    public void test_getServiceUUID_00001() {
        assertEquals(WEIGHT_SCALE_SERVICE, new WeightScaleProfileMockCallback(ApplicationProvider.getApplicationContext(), null, null, null, null, null).getServiceUUID());
    }

}
