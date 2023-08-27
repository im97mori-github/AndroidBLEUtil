package org.im97mori.ble.profile.wsp.central.db;

import androidx.test.core.app.ApplicationProvider;

import org.im97mori.ble.test.TestBase;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class WeightScaleProfileBondedDatabaseHelperTest extends TestBase {

    @Test
    public void test_constructor_00001() {
        assertNotNull(WeightScaleProfileBondedDatabaseHelper.getInstance(ApplicationProvider.getApplicationContext()));
    }

    @Test
    public void test_constructor_00002() {
        assertEquals(WeightScaleProfileBondedDatabaseHelper.getInstance(ApplicationProvider.getApplicationContext()), WeightScaleProfileBondedDatabaseHelper.getInstance(ApplicationProvider.getApplicationContext()));
    }

    @Test
    public void test_getProfileName_00001() {
        assertEquals(WeightScaleProfileBondedDatabaseHelper.PROFILE_NAME, WeightScaleProfileBondedDatabaseHelper.getInstance(ApplicationProvider.getApplicationContext()).getProfileName());
    }
}
