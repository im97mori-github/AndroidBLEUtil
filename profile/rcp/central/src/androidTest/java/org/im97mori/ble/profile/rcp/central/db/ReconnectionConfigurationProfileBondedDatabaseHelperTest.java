package org.im97mori.ble.profile.rcp.central.db;

import androidx.test.core.app.ApplicationProvider;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ReconnectionConfigurationProfileBondedDatabaseHelperTest {

    @Test
    public void test_constructor_00001() {
        assertNotNull(ReconnectionConfigurationProfileBondedDatabaseHelper.getInstance(ApplicationProvider.getApplicationContext()));
    }

    @Test
    public void test_constructor_00002() {
        assertEquals(ReconnectionConfigurationProfileBondedDatabaseHelper.getInstance(ApplicationProvider.getApplicationContext()), ReconnectionConfigurationProfileBondedDatabaseHelper.getInstance(ApplicationProvider.getApplicationContext()));
    }

    @Test
    public void test_getProfileName_00001() {
        assertEquals(ReconnectionConfigurationProfileBondedDatabaseHelper.PROFILE_NAME, ReconnectionConfigurationProfileBondedDatabaseHelper.getInstance(ApplicationProvider.getApplicationContext()).getProfileName());
    }
}
