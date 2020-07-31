package org.im97mori.ble.profile.lnp.peripheral;

import androidx.test.core.app.ApplicationProvider;

import org.junit.Test;

import static org.im97mori.ble.BLEConstants.ServiceUUID.LOCATION_AND_NAVIGATION_SERVICE;
import static org.junit.Assert.assertEquals;

public class LocationAndNavigationProfileMockCallbackTest {

    @Test
    public void test_getServiceUUID_00001() {
        assertEquals(LOCATION_AND_NAVIGATION_SERVICE, new LocationAndNavigationProfileMockCallback(ApplicationProvider.getApplicationContext(), null, null, null).getServiceUUID());
    }

}
