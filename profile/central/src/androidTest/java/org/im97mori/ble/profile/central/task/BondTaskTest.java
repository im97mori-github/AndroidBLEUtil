package org.im97mori.ble.profile.central.task;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import android.os.Bundle;
import android.os.Message;

import androidx.test.filters.RequiresDevice;

import org.im97mori.ble.test.BLETestUtilsAndroid;
import org.junit.Test;

public class BondTaskTest {

    @SuppressWarnings("ConstantConditions")
    @Test
    public void test_createInitialMessage_00001() {
        BondTask task = new BondTask(null, null, null, null, null, 0, null);
        Message message = task.createInitialMessage();

        assertNotNull(message);
        Bundle bundle = message.getData();
        assertNotNull(bundle);
        assertTrue(bundle.containsKey(BondTask.KEY_NEXT_PROGRESS));
        assertEquals(BondTask.PROGRESS_BOND_START, bundle.getString(BondTask.KEY_NEXT_PROGRESS));
        assertEquals(task, message.obj);
    }

    @Test
    @RequiresDevice
    public void test_createBondSuccessMessage_00001() {
        Message message = BondTask.createBondSuccessMessage(BLETestUtilsAndroid.MOCK_DEVICE_0);

        assertNotNull(message);
        Bundle bundle = message.getData();
        assertNotNull(bundle);
        assertEquals(BondTask.PROGRESS_BOND_SUCCESS, bundle.getString(BondTask.KEY_NEXT_PROGRESS));
        assertEquals(BLETestUtilsAndroid.MOCK_DEVICE_0, bundle.getParcelable(BondTask.KEY_BLUETOOTH_DEVICE));
    }

    @Test
    @RequiresDevice
    public void test_createBondErrorMessage_00001() {
        Message message = BondTask.createBondErrorMessage(BLETestUtilsAndroid.MOCK_DEVICE_0);

        assertNotNull(message);
        Bundle bundle = message.getData();
        assertNotNull(bundle);
        assertEquals(BondTask.PROGRESS_BOND_ERROR, bundle.getString(BondTask.KEY_NEXT_PROGRESS));
        assertEquals(BLETestUtilsAndroid.MOCK_DEVICE_0, bundle.getParcelable(BondTask.KEY_BLUETOOTH_DEVICE));
    }

}
