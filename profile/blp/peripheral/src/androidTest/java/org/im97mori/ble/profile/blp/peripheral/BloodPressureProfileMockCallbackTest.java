package org.im97mori.ble.profile.blp.peripheral;

import androidx.test.core.app.ApplicationProvider;

import org.junit.Test;

import static org.im97mori.ble.BLEConstants.ServiceUUID.BLOOD_PRESSURE_SERVICE;
import static org.junit.Assert.assertEquals;

public class BloodPressureProfileMockCallbackTest {

    @Test
    public void test_getServiceUUID_00001() {
        assertEquals(BLOOD_PRESSURE_SERVICE, new BloodPressureProfileMockCallback(ApplicationProvider.getApplicationContext(), null, null).getServiceUUID());
    }
}
