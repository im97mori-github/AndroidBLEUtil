package org.im97mori.ble.profile.rscp.central.db;

import androidx.test.core.app.ApplicationProvider;

import org.im97mori.ble.test.TestBase;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class RunningSpeedAndCadenceProfileBondedDatabaseHelperTest extends TestBase {

    @Test
    public void test_constructor_00001() {
        assertNotNull(RunningSpeedAndCadenceProfileBondedDatabaseHelper.getInstance(ApplicationProvider.getApplicationContext()));
    }

    @Test
    public void test_constructor_00002() {
        assertEquals(RunningSpeedAndCadenceProfileBondedDatabaseHelper.getInstance(ApplicationProvider.getApplicationContext()), RunningSpeedAndCadenceProfileBondedDatabaseHelper.getInstance(ApplicationProvider.getApplicationContext()));
    }

    @Test
    public void test_getProfileName_00001() {
        assertEquals(RunningSpeedAndCadenceProfileBondedDatabaseHelper.PROFILE_NAME, RunningSpeedAndCadenceProfileBondedDatabaseHelper.getInstance(ApplicationProvider.getApplicationContext()).getProfileName());
    }
}
