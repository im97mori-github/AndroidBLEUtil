package org.im97mori.ble.profile.central.task;

import android.os.Bundle;
import android.os.Message;

import org.im97mori.ble.task.AbstractBLETask;
import org.im97mori.ble.test.BLETestUtilsAndroid;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import androidx.test.filters.RequiresDevice;

public class BondTaskTest {

    @SuppressWarnings("ConstantConditions")
    @Test
    public void test_createInitialMessage_00001() {
        BondTask task = new BondTask(null, null, null, null, null, 0, null);
        Message message = task.createInitialMessage();

        assertNotNull(message);
        Bundle bundle = message.getData();
        assertNotNull(bundle);
        assertTrue(bundle.containsKey(AbstractBLETask.KEY_NEXT_PROGRESS));
        assertEquals(AbstractBLETask.PROGRESS_BOND_START, bundle.getInt(AbstractBLETask.KEY_NEXT_PROGRESS));
        assertEquals(task, message.obj);
    }

    @Test
    @RequiresDevice
    public void test_createBondSuccessMessage_00001() {
        Message message = BondTask.createBondSuccessMessage(BLETestUtilsAndroid.MOCK_DEVICE_0);

        assertNotNull(message);
        Bundle bundle = message.getData();
        assertNotNull(bundle);
        assertEquals(AbstractBLETask.PROGRESS_BOND_SUCCESS, bundle.getInt(AbstractBLETask.KEY_NEXT_PROGRESS));
        assertEquals(BLETestUtilsAndroid.MOCK_DEVICE_0, bundle.getParcelable(AbstractBLETask.KEY_BLUETOOTH_DEVICE));
    }

    @Test
    @RequiresDevice
    public void test_createBondErrorMessage_00001() {
        Message message = BondTask.createBondErrorMessage(BLETestUtilsAndroid.MOCK_DEVICE_0);

        assertNotNull(message);
        Bundle bundle = message.getData();
        assertNotNull(bundle);
        assertEquals(AbstractBLETask.PROGRESS_BOND_ERROR, bundle.getInt(AbstractBLETask.KEY_NEXT_PROGRESS));
        assertEquals(BLETestUtilsAndroid.MOCK_DEVICE_0, bundle.getParcelable(AbstractBLETask.KEY_BLUETOOTH_DEVICE));
    }

}
