package org.im97mori.ble.profile.ftmp.peripheral;

import androidx.test.core.app.ApplicationProvider;

import org.junit.Test;

import static org.im97mori.ble.constants.ServiceUUID.FITNESS_MACHINE_SERVICE;
import static org.junit.Assert.assertEquals;

@SuppressWarnings("ConstantConditions")
public class FitnessMachineProfileMockCallbackTest {

    @Test
    public void test_getServiceUUID_00001() {
        assertEquals(FITNESS_MACHINE_SERVICE, new FitnessMachineProfileMockCallback(ApplicationProvider.getApplicationContext(), null, null, null).getServiceUUID());
    }

}
