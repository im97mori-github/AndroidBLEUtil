package org.im97mori.ble;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.format.DateUtils;

import androidx.annotation.NonNull;

import org.im97mori.ble.task.AbstractBLETask;
import org.im97mori.stacklog.LogUtils;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * Single queue task handler
 */
@SuppressWarnings({"WeakerAccess"})
public class TaskHandler extends Handler {

    /**
     * busy status duration(millis)
     */
    private static final long DURATION_BUSY = DateUtils.SECOND_IN_MILLIS;

    /**
     * MESSAGE:QUIT
     */
    private static final int MESSAGE_QUIT = 0;

    /**
     * MESSAGE:TASK_ADD
     */
    private static final int MESSAGE_TASK_ADD = MESSAGE_QUIT + 1;

    /**
     * MESSAGE:HIGH_PRIORITY_TASK_ADD
     */
    private static final int MESSAGE_HIGH_PRIORITY_TASK_ADD = MESSAGE_TASK_ADD + 1;

    /**
     * MESSAGE:TASK_PROCESSING
     */
    private static final int MESSAGE_TASK_PROCESSING = MESSAGE_HIGH_PRIORITY_TASK_ADD + 1;

    /**
     * MESSAGE:TASK_CLEAR
     */
    private static final int MESSAGE_TASK_CLEAR = MESSAGE_TASK_PROCESSING + 1;

    /**
     * MESSAGE:TASK_CANCEL
     */
    private static final int MESSAGE_TASK_CANCEL = MESSAGE_TASK_CLEAR + 1;

    /**
     * MESSAGE:CLEAR_BUSY
     */
    private static final int MESSAGE_CLEAR_BUSY = MESSAGE_TASK_CANCEL + 1;

    /**
     * current task
     */
    private AbstractBLETask mCurrentTask;

    /**
     * task queue
     */
    private final LinkedList<AbstractBLETask> mQueue = new LinkedList<>();

    /**
     * high priority task queue
     */
    private final LinkedList<AbstractBLETask> mHighPriorityQueue = new LinkedList<>();

    /**
     * end of busy status
     */
    private long mWaitForBusy;

    /**
     * @see Handler#Handler(Looper)
     */
    public TaskHandler(@NonNull Looper looper) {
        super(looper);
    }

    /**
     * check task status
     *
     * @param task check target task
     * @return {@code true}:task canceled, {@code false}:task alive
     */
    protected boolean isTaskAlive(@NonNull AbstractBLETask task) {
        boolean result = true;
        if (hasMessages(MESSAGE_TASK_CANCEL, task.getTaskId())) {
            task.cancel();
            removeMessages(MESSAGE_TASK_CANCEL, task.getTaskId());
            result = false;
        } else if (hasMessages(MESSAGE_TASK_CLEAR)) {
            task.cancel();
            result = false;
        }
        return result;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void handleMessage(@NonNull Message msg) {
        try {
            // current message is quit, or message queue has quit
            if (MESSAGE_QUIT == msg.what || hasMessages(MESSAGE_QUIT)) {
                // clear all task
                cancelAllQueue();

                // quit
                getLooper().quit();
            } else if (MESSAGE_TASK_CLEAR == msg.what) {
                // current message is clear, or message queue has clear

                // clear all task
                cancelAllQueue();
            } else if (MESSAGE_TASK_CANCEL == msg.what) {
                // cancel single task
                Integer canceledTask = (Integer) msg.obj;

                if (mCurrentTask != null && canceledTask.equals(mCurrentTask.getTaskId())) {
                    mCurrentTask.cancel();
                    mCurrentTask = null;
                }

                Iterator<AbstractBLETask> it = mQueue.iterator();
                while (it.hasNext()) {
                    AbstractBLETask task = it.next();
                    if (canceledTask.equals(task.getTaskId())) {
                        it.remove();
                        break;
                    }
                }

                it = mHighPriorityQueue.iterator();
                while (it.hasNext()) {
                    AbstractBLETask task = it.next();
                    if (canceledTask.equals(task.getTaskId())) {
                        it.remove();
                        break;
                    }
                }
            } else {
                if (hasMessages(MESSAGE_TASK_CLEAR)) {
                    // clear all task
                    cancelAllQueue();
                }

                // processing for high priority task

                if (MESSAGE_HIGH_PRIORITY_TASK_ADD == msg.what) {
                    AbstractBLETask task = (AbstractBLETask) msg.obj;
                    if (isTaskAlive(task)) {
                        mHighPriorityQueue.add(task);
                    }
                }

                // processing for add

                // add task
                if (MESSAGE_TASK_ADD == msg.what) {
                    AbstractBLETask task = (AbstractBLETask) msg.obj;
                    if (isTaskAlive(task)) {
                        // add to task queue
                        mQueue.add(task);
                    }
                }

                // have current task, process task
                if (mCurrentTask != null) {
                    if (!isTaskAlive(mCurrentTask)) {
                        mCurrentTask = null;
                    } else if (mCurrentTask.doProcess(msg)) {
                        // task finished

                        // if busy, wait interval 1sec.
                        if (mCurrentTask.isBusy()) {
                            mWaitForBusy = SystemClock.elapsedRealtime() + DURATION_BUSY;
                        }

                        // clear current task
                        mCurrentTask = null;
                    }
                }

                // clear busy status
                if (MESSAGE_CLEAR_BUSY == msg.what) {
                    mWaitForBusy = 0;
                }

                Iterator<AbstractBLETask> it = mHighPriorityQueue.iterator();
                while (it.hasNext()) {
                    AbstractBLETask task = it.next();
                    if (isTaskAlive(task)) {
                        if (!isBusy() || task.isIgnoreBusy()) {
                            task.doProcess(msg);
                            it.remove();
                        }
                    } else {
                        it.remove();
                    }
                }

                // no current task and task queue is not empty
                if (mCurrentTask == null && !mQueue.isEmpty()) {
                    // set current task
                    do {
                        AbstractBLETask task = mQueue.poll();
                        if (task != null) {
                            if (isTaskAlive(task) && (!isBusy() || task.isIgnoreBusy())) {
                                // Disconnect task ignore busy status

                                mCurrentTask = task;

                                // send current task's first message
                                Message initialMessage = task.createInitialMessage();
                                initialMessage.what = MESSAGE_TASK_PROCESSING;
                                sendMessage(initialMessage);
                            } else {
                                // busy status

                                // return to queue
                                mQueue.push(task);
                            }
                            break;
                        }
                    } while (!mQueue.isEmpty());
                }
            }
        } catch (Exception e) {
            LogUtils.stackLog(e);
        }
    }

    /**
     * quit looper
     */
    public void quit() {
        sendEmptyMessage(MESSAGE_QUIT);
    }

    /**
     * @see #sendProcessingMessage(Message, long)
     */
    public void sendProcessingMessage(@NonNull Message message) {
        sendProcessingMessage(message, 0);
    }

    /**
     * send processing message
     *
     * @param message target {@link Message}
     * @param delay   millis
     */
    public void sendProcessingMessage(@NonNull Message message, long delay) {
        message.what = MESSAGE_TASK_PROCESSING;
        sendMessageDelayed(message, delay);
    }

    /**
     * @see #addTaskDelayed(AbstractBLETask, long)
     */
    public void addTask(AbstractBLETask task) {
        addTaskDelayed(task, 0);
    }

    /**
     * add task and task's first message to task queue
     *
     * @param task  {@link AbstractBLETask} instance
     * @param delay millis
     */
    public void addTaskDelayed(@NonNull AbstractBLETask task, long delay) {
        Message message = new Message();
        message.what = MESSAGE_TASK_ADD;
        message.obj = task;
        sendMessageDelayed(message, delay);
    }

    public void addHighPriorityTask(@NonNull AbstractBLETask task) {
        Message message = new Message();
        message.what = MESSAGE_HIGH_PRIORITY_TASK_ADD;
        message.obj = task;
        sendMessageDelayed(message, 0);
    }

    /**
     * clear task queue
     */
    public void clearTask() {
        sendEmptyMessage(MESSAGE_TASK_CLEAR);
    }

    /**
     * clear single task
     *
     * @param taskId task id
     */
    public void cancelTask(@NonNull Integer taskId) {
        Message message = new Message();
        message.what = MESSAGE_TASK_CANCEL;
        message.obj = taskId;
        sendMessage(message);
    }

    /**
     * clear busy status
     */
    public void clearBusy() {
        sendEmptyMessage(MESSAGE_CLEAR_BUSY);
    }

    /**
     * check busy status
     *
     * @return {@code true}:busy, {@code false}:not busy
     */
    public boolean isBusy() {
        return mWaitForBusy > SystemClock.elapsedRealtime();
    }

    /**
     * clear all task
     */
    private void cancelAllQueue() {
        if (mCurrentTask != null) {
            mCurrentTask.cancel();
            mCurrentTask = null;
        }
        for (AbstractBLETask task : mQueue) {
            task.cancel();
        }
        mQueue.clear();
        for (AbstractBLETask task : mHighPriorityQueue) {
            task.cancel();
        }
        mHighPriorityQueue.clear();
    }

}
