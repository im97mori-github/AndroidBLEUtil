package org.im97mori.ble.profile.pxp.central.db;

import androidx.test.core.app.ApplicationProvider;

import org.im97mori.ble.test.TestBase;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ProximityProfileBondedDatabaseHelperTest extends TestBase {

    @Test
    public void test_constructor_00001() {
        assertNotNull(ProximityProfileBondedDatabaseHelper.getInstance(ApplicationProvider.getApplicationContext()));
    }

    @Test
    public void test_constructor_00002() {
        assertEquals(ProximityProfileBondedDatabaseHelper.getInstance(ApplicationProvider.getApplicationContext()), ProximityProfileBondedDatabaseHelper.getInstance(ApplicationProvider.getApplicationContext()));
    }

    @Test
    public void test_getProfileName_00001() {
        assertEquals(ProximityProfileBondedDatabaseHelper.PROFILE_NAME, ProximityProfileBondedDatabaseHelper.getInstance(ApplicationProvider.getApplicationContext()).getProfileName());
    }
}
