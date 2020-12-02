package org.im97mori.ble.profile.anp.central.db;

import androidx.test.core.app.ApplicationProvider;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class AlertNotificationProfileBondedDatabaseHelperTest {

    @Test
    public void test_constructor_00001() {
        assertNotNull(AlertNotificationProfileBondedDatabaseHelper.getInstance(ApplicationProvider.getApplicationContext()));
    }

    @Test
    public void test_constructor_00002() {
        assertEquals(AlertNotificationProfileBondedDatabaseHelper.getInstance(ApplicationProvider.getApplicationContext()), AlertNotificationProfileBondedDatabaseHelper.getInstance(ApplicationProvider.getApplicationContext()));
    }

    @Test
    public void test_getProfileName_00001() {
        assertEquals(AlertNotificationProfileBondedDatabaseHelper.PROFILE_NAME, AlertNotificationProfileBondedDatabaseHelper.getInstance(ApplicationProvider.getApplicationContext()).getProfileName());
    }

}
