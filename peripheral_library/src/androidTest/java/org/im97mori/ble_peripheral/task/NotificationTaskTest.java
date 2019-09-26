package org.im97mori.ble_peripheral.task;

import android.os.Bundle;
import android.os.Message;

import org.im97mori.ble.task.AbstractBLETask;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class NotificationTaskTest {

    @Test
    public void test_createInitialMessage001() {
        NotificationTask task = new NotificationTask(null, null, null, null, null, null, true, null);
        Message message = task.createInitialMessage();

        assertNotNull(message);
        Bundle bundle = message.getData();
        assertNotNull(bundle);
        assertEquals(AbstractBLETask.PROGRESS_NOTIFICATION, bundle.getInt(AbstractBLETask.KEY_NEXT_PROGRESS));
        assertEquals(task, message.obj);
    }

}
