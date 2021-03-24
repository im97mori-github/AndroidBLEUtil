package org.im97mori.ble.profile.scpp.central.db;

import androidx.test.core.app.ApplicationProvider;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ScanParametersProfileBondedDatabaseHelperTest {

    @Test
    public void test_constructor_00001() {
        assertNotNull(ScanParametersProfileBondedDatabaseHelper.getInstance(ApplicationProvider.getApplicationContext()));
    }

    @Test
    public void test_constructor_00002() {
        assertEquals(ScanParametersProfileBondedDatabaseHelper.getInstance(ApplicationProvider.getApplicationContext()), ScanParametersProfileBondedDatabaseHelper.getInstance(ApplicationProvider.getApplicationContext()));
    }

    @Test
    public void test_getProfileName_00001() {
        assertEquals(ScanParametersProfileBondedDatabaseHelper.PROFILE_NAME, ScanParametersProfileBondedDatabaseHelper.getInstance(ApplicationProvider.getApplicationContext()).getProfileName());
    }
}
