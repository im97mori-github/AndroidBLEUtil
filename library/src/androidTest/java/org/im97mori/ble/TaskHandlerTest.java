package org.im97mori.ble;

import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.format.DateUtils;

import org.im97mori.ble.task.AbstractBLETask;
import org.junit.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class TaskHandlerTest {

    @Test
    public void addTaskTest001() {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        AbstractBLETask task = new AbstractBLETask() {
            @Override
            public Message createInitialMessage() {
                return new Message();
            }

            @Override
            public boolean doProcess(Message message) {
                countDownLatch.countDown();
                return true;
            }

            @Override
            public boolean isBusy() {
                return false;
            }

            @Override
            public void cancel() {

            }
        };

        HandlerThread thread = new HandlerThread(this.getClass().getName());
        thread.start();
        TaskHandler taskHandler = new TaskHandler(thread.getLooper());

        taskHandler.addTask(task);

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assertEquals(0, countDownLatch.getCount());

        taskHandler.quit();
    }

    @Test
    public void addTaskTest002() {
        final CountDownLatch countDownLatch = new CountDownLatch(2);
        AbstractBLETask task = new AbstractBLETask() {
            @Override
            public Message createInitialMessage() {
                return new Message();
            }

            @Override
            public boolean doProcess(Message message) {
                countDownLatch.countDown();
                return true;
            }

            @Override
            public boolean isBusy() {
                return false;
            }

            @Override
            public void cancel() {

            }
        };

        HandlerThread thread = new HandlerThread(this.getClass().getName());
        thread.start();
        TaskHandler taskHandler = new TaskHandler(thread.getLooper());

        taskHandler.addTask(task);
        taskHandler.addTask(task);

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assertEquals(0, countDownLatch.getCount());

        taskHandler.quit();
    }

    @Test
    public void cancelTaskTest001() {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        AbstractBLETask task1 = new AbstractBLETask() {
            @Override
            public Message createInitialMessage() {
                return new Message();
            }

            @Override
            public boolean doProcess(Message message) {
                try {
                    Thread.sleep(DateUtils.SECOND_IN_MILLIS);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return true;
            }

            @Override
            public boolean isBusy() {
                return false;
            }

            @Override
            public void cancel() {

            }
        };
        final AtomicInteger atomicInteger = new AtomicInteger(0);
        AbstractBLETask task2 = new AbstractBLETask() {
            @Override
            public Message createInitialMessage() {
                return new Message();
            }

            @Override
            public boolean doProcess(Message message) {
                atomicInteger.addAndGet(1);
                countDownLatch.countDown();
                return true;
            }

            @Override
            public boolean isBusy() {
                return false;
            }

            @Override
            public void cancel() {

            }
        };

        HandlerThread thread = new HandlerThread(this.getClass().getName());
        thread.start();
        TaskHandler taskHandler = new TaskHandler(thread.getLooper());

        taskHandler.addTask(task1);
        taskHandler.addTask(task2);
        taskHandler.cancelTask(task2.getTaskId());

        try {
            countDownLatch.await(2, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        assertEquals(0, atomicInteger.get());

        taskHandler.quit();
    }

    @Test
    public void cancelTaskTest002() {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        AbstractBLETask task1 = new AbstractBLETask() {
            @Override
            public Message createInitialMessage() {
                return new Message();
            }

            @Override
            public boolean doProcess(Message message) {
                try {
                    Thread.sleep(DateUtils.SECOND_IN_MILLIS * 2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                  return true;
            }

            @Override
            public boolean isBusy() {
                return false;
            }

            @Override
            public void cancel() {

            }
        };
        final AtomicInteger atomicInteger1 = new AtomicInteger(0);
        AbstractBLETask task2 = new AbstractBLETask() {
            @Override
            public Message createInitialMessage() {
                return new Message();
            }

            @Override
            public boolean doProcess(Message message) {
                atomicInteger1.addAndGet(1);
                return true;
            }

            @Override
            public boolean isBusy() {
                return false;
            }

            @Override
            public void cancel() {

            }
        };
        final AtomicInteger atomicInteger2 = new AtomicInteger(0);
        AbstractBLETask task3 = new AbstractBLETask() {
            @Override
            public Message createInitialMessage() {
                return new Message();
            }

            @Override
            public boolean doProcess(Message message) {
                atomicInteger2.addAndGet(1);
                countDownLatch.countDown();
                return true;
            }

            @Override
            public boolean isBusy() {
                return false;
            }

            @Override
            public void cancel() {

            }
        };

        HandlerThread thread = new HandlerThread(this.getClass().getName());
        thread.start();
        TaskHandler taskHandler = new TaskHandler(thread.getLooper());

        taskHandler.addTask(task1);
        taskHandler.addTask(task2);
        taskHandler.addTask(task3);
        taskHandler.cancelTask(task2.getTaskId());

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        assertEquals(0, atomicInteger1.get());
        assertEquals(1, atomicInteger2.get());

        taskHandler.quit();
    }

    @Test
    public void clearTaskTest001() {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        AbstractBLETask task1 = new AbstractBLETask() {
            @Override
            public Message createInitialMessage() {
                return new Message();
            }

            @Override
            public boolean doProcess(Message message) {
                try {
                    Thread.sleep(DateUtils.SECOND_IN_MILLIS * 2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return true;
            }

            @Override
            public boolean isBusy() {
                return false;
            }

            @Override
            public void cancel() {
            }
        };
        final AtomicInteger atomicInteger1 = new AtomicInteger(0);
        AbstractBLETask task2 = new AbstractBLETask() {
            @Override
            public Message createInitialMessage() {
                return new Message();
            }

            @Override
            public boolean doProcess(Message message) {
                atomicInteger1.addAndGet(1);
                return true;
            }

            @Override
            public boolean isBusy() {
                return false;
            }

            @Override
            public void cancel() {
            }
        };
        final AtomicInteger atomicInteger2 = new AtomicInteger(0);
        AbstractBLETask task3 = new AbstractBLETask() {
            @Override
            public Message createInitialMessage() {
                return new Message();
            }

            @Override
            public boolean doProcess(Message message) {
                atomicInteger2.addAndGet(1);
                return true;
            }

            @Override
            public boolean isBusy() {
                return false;
            }

            @Override
            public void cancel() {
            }
        };
        final AtomicInteger atomicInteger3 = new AtomicInteger(0);
        AbstractBLETask task4 = new AbstractBLETask() {
            @Override
            public Message createInitialMessage() {
                return new Message();
            }

            @Override
            public boolean doProcess(Message message) {
                atomicInteger3.addAndGet(1);
                countDownLatch.countDown();
                return true;
            }

            @Override
            public boolean isBusy() {
                return false;
            }

            @Override
            public void cancel() {
                BLELogUtils.stackLog();
            }
        };

        HandlerThread thread = new HandlerThread(this.getClass().getName());
        thread.start();
        TaskHandler taskHandler = new TaskHandler(thread.getLooper());

        taskHandler.addTask(task1);
        taskHandler.addTask(task2);
        taskHandler.addTask(task3);
        taskHandler.clearTask();
        taskHandler.addTask(task4);
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assertEquals(0, atomicInteger1.get());
        assertEquals(0, atomicInteger2.get());
        assertEquals(1, atomicInteger3.get());

        taskHandler.quit();
    }

    @Test
    public void clearBusyTest001() {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        AbstractBLETask task1 = new AbstractBLETask() {
            @Override
            public Message createInitialMessage() {
                return new Message();
            }

            @Override
            public boolean doProcess(Message message) {
                return true;
            }

            @Override
            public boolean isBusy() {
                return true;
            }

            @Override
            public void cancel() {

            }
        };
        AbstractBLETask task2 = new AbstractBLETask() {
            @Override
            public Message createInitialMessage() {
                return new Message();
            }

            @Override
            public boolean doProcess(Message message) {
                countDownLatch.countDown();
                return true;
            }

            @Override
            public boolean isBusy() {
                return false;
            }

            @Override
            public void cancel() {

            }
        };
        AbstractBLETask task3 = new AbstractBLETask() {
            @Override
            public Message createInitialMessage() {
                return new Message();
            }

            @Override
            public boolean doProcess(Message message) {
                return true;
            }

            @Override
            public boolean isBusy() {
                return false;
            }

            @Override
            public void cancel() {

            }
        };
        HandlerThread thread = new HandlerThread(this.getClass().getName());
        thread.start();
        Looper looper = thread.getLooper();
        TaskHandler taskHandler = new TaskHandler(looper);

        taskHandler.addTask(task1);
        taskHandler.addTask(task2);

        assertEquals(1, countDownLatch.getCount());

        do {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } while (taskHandler.isBusy());

        taskHandler.addTask(task3);

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assertEquals(0, countDownLatch.getCount());

        taskHandler.quit();
    }

    @Test
    public void clearBusyTest002() {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        AbstractBLETask task1 = new AbstractBLETask() {
            @Override
            public Message createInitialMessage() {
                return new Message();
            }

            @Override
            public boolean doProcess(Message message) {
                return true;
            }

            @Override
            public boolean isBusy() {
                return true;
            }

            @Override
            public void cancel() {

            }
        };
        AbstractBLETask task2 = new AbstractBLETask() {
            @Override
            public Message createInitialMessage() {
                return new Message();
            }

            @Override
            public boolean doProcess(Message message) {
                countDownLatch.countDown();
                return true;
            }

            @Override
            public boolean isBusy() {
                return false;
            }

            @Override
            public void cancel() {

            }
        };
        HandlerThread thread = new HandlerThread(this.getClass().getName());
        thread.start();
        Looper looper = thread.getLooper();
        TaskHandler taskHandler = new TaskHandler(looper);

        taskHandler.addTask(task1);
        taskHandler.addTask(task2);

        assertEquals(1, countDownLatch.getCount());

        do {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } while (taskHandler.isBusy());

        taskHandler.clearBusy();

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assertEquals(0, countDownLatch.getCount());

        taskHandler.quit();
    }

    @Test
    public void quitTest001() {
        HandlerThread thread = new HandlerThread(this.getClass().getName());
        thread.start();
        Looper looper = thread.getLooper();
        TaskHandler taskHandler = new TaskHandler(looper);
        taskHandler.quit();

        try {
            Thread.sleep(DateUtils.SECOND_IN_MILLIS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        assertFalse(looper.getThread().isAlive());
    }
}
