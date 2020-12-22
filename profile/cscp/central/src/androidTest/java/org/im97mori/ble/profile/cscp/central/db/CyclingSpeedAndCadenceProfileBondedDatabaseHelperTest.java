package org.im97mori.ble.profile.cscp.central.db;

import androidx.test.core.app.ApplicationProvider;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class CyclingSpeedAndCadenceProfileBondedDatabaseHelperTest {

    @Test
    public void test_constructor_00001() {
        assertNotNull(CyclingSpeedAndCadenceProfileBondedDatabaseHelper.getInstance(ApplicationProvider.getApplicationContext()));
    }

    @Test
    public void test_constructor_00002() {
        assertEquals(CyclingSpeedAndCadenceProfileBondedDatabaseHelper.getInstance(ApplicationProvider.getApplicationContext()), CyclingSpeedAndCadenceProfileBondedDatabaseHelper.getInstance(ApplicationProvider.getApplicationContext()));
    }

    @Test
    public void test_getProfileName_00001() {
        assertEquals(CyclingSpeedAndCadenceProfileBondedDatabaseHelper.PROFILE_NAME, CyclingSpeedAndCadenceProfileBondedDatabaseHelper.getInstance(ApplicationProvider.getApplicationContext()).getProfileName());
    }
}
