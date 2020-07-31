package org.im97mori.ble.profile.lnp.central.db;

import androidx.test.core.app.ApplicationProvider;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class LocationAndNavigationProfileBondedDatabaseHelperTest {

    @Test
    public void test_constructor_00001() {
        assertNotNull(LocationAndNavigationProfileBondedDatabaseHelper.getInstance(ApplicationProvider.getApplicationContext()));
    }

    @Test
    public void test_constructor_00002() {
        assertEquals(LocationAndNavigationProfileBondedDatabaseHelper.getInstance(ApplicationProvider.getApplicationContext()), LocationAndNavigationProfileBondedDatabaseHelper.getInstance(ApplicationProvider.getApplicationContext()));
    }

    @Test
    public void test_getProfileName_00001() {
        assertEquals(LocationAndNavigationProfileBondedDatabaseHelper.PROFILE_NAME, LocationAndNavigationProfileBondedDatabaseHelper.getInstance(ApplicationProvider.getApplicationContext()).getProfileName());
    }

}
