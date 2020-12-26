package org.im97mori.ble.profile.pasp.central.db;

import androidx.test.core.app.ApplicationProvider;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class PhoneAlertStatusProfileBondedDatabaseHelperTest {

    @Test
    public void test_constructor_00001() {
        assertNotNull(PhoneAlertStatusProfileBondedDatabaseHelper.getInstance(ApplicationProvider.getApplicationContext()));
    }

    @Test
    public void test_constructor_00002() {
        assertEquals(PhoneAlertStatusProfileBondedDatabaseHelper.getInstance(ApplicationProvider.getApplicationContext()), PhoneAlertStatusProfileBondedDatabaseHelper.getInstance(ApplicationProvider.getApplicationContext()));
    }

    @Test
    public void test_getProfileName_00001() {
        assertEquals(PhoneAlertStatusProfileBondedDatabaseHelper.PROFILE_NAME, PhoneAlertStatusProfileBondedDatabaseHelper.getInstance(ApplicationProvider.getApplicationContext()).getProfileName());
    }
}
