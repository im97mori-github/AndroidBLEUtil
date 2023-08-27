package org.im97mori.ble.profile.htp.central.db;

import androidx.test.core.app.ApplicationProvider;

import org.im97mori.ble.test.TestBase;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class HealthThermometerProfileBondedDatabaseHelperTest extends TestBase {

    @Test
    public void test_constructor_00001() {
        assertNotNull(HealthThermometerProfileBondedDatabaseHelper.getInstance(ApplicationProvider.getApplicationContext()));
    }

    @Test
    public void test_constructor_00002() {
        assertEquals(HealthThermometerProfileBondedDatabaseHelper.getInstance(ApplicationProvider.getApplicationContext()), HealthThermometerProfileBondedDatabaseHelper.getInstance(ApplicationProvider.getApplicationContext()));
    }

    @Test
    public void test_getProfileName_00001() {
        assertEquals(HealthThermometerProfileBondedDatabaseHelper.PROFILE_NAME, HealthThermometerProfileBondedDatabaseHelper.getInstance(ApplicationProvider.getApplicationContext()).getProfileName());
    }
}
