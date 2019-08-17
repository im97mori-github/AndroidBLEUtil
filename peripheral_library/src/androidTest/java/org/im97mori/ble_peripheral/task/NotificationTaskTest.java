package org.im97mori.ble_peripheral.task;

import android.os.Bundle;
import android.os.Message;

import org.im97mori.ble.task.AbstractBLETask;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class NotificationTaskTest {

    @Test
    public void test_createNotificationMessage001() {
        Message message = NotificationTask.createNotificationMessage(null);

        assertNotNull(message);
        Bundle bundle = message.getData();
        assertNotNull(bundle);
        assertEquals(AbstractBLETask.PROGRESS_NOTIFICATION, bundle.getInt(AbstractBLETask.KEY_NEXT_PROGRESS));
        assertNull(message.obj);
    }

    @Test
    public void test_createNotificationMessage002() {
        Object object = new Object();
        Message message = NotificationTask.createNotificationMessage(object);

        assertNotNull(message);
        Bundle bundle = message.getData();
        assertNotNull(bundle);
        assertEquals(AbstractBLETask.PROGRESS_NOTIFICATION, bundle.getInt(AbstractBLETask.KEY_NEXT_PROGRESS));
        assertEquals(object, message.obj);
    }
}
