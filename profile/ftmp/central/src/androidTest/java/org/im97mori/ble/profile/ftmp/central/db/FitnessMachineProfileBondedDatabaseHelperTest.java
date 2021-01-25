package org.im97mori.ble.profile.ftmp.central.db;

import androidx.test.core.app.ApplicationProvider;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class FitnessMachineProfileBondedDatabaseHelperTest {

    @Test
    public void test_constructor_00001() {
        assertNotNull(FitnessMachineProfileBondedDatabaseHelper.getInstance(ApplicationProvider.getApplicationContext()));
    }

    @Test
    public void test_constructor_00002() {
        assertEquals(FitnessMachineProfileBondedDatabaseHelper.getInstance(ApplicationProvider.getApplicationContext()), FitnessMachineProfileBondedDatabaseHelper.getInstance(ApplicationProvider.getApplicationContext()));
    }

    @Test
    public void test_getProfileName_00001() {
        assertEquals(FitnessMachineProfileBondedDatabaseHelper.PROFILE_NAME, FitnessMachineProfileBondedDatabaseHelper.getInstance(ApplicationProvider.getApplicationContext()).getProfileName());
    }
}
