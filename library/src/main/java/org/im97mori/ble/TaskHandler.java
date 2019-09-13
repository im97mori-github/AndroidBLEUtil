package org.im97mori.ble;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.format.DateUtils;

import androidx.annotation.NonNull;

import org.im97mori.ble.task.AbstractBLETask;
import org.im97mori.ble.task.DisconnectTask;

import java.util.Iterator;
import java.util.LinkedList;

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
     * MESSAGE:TASK_PROCESSING
     */
    private static final int MESSAGE_TASK_PROCESSING = MESSAGE_TASK_ADD + 1;

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
     * KEY:TASK_ID
     */
    private static final String KEY_TASK_ID = "KEY_TASK_ID";

    /**
     * current task
     */
    private AbstractBLETask mCurrentTask;

    /**
     * task queue
     */
    private final LinkedList<AbstractBLETask> mQueue = new LinkedList<>();

    /**
     * end of busy status
     */
    private long mWaitForBusy;

    /**
     * @see Handler#Handler(Looper)
     */
    public TaskHandler(Looper looper) {
        super(looper);
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
                Bundle bundle = msg.getData();
                long taskId = bundle.getLong(KEY_TASK_ID);

                if (mCurrentTask != null && mCurrentTask.getTaskId() == taskId) {
                    mCurrentTask.cancel();
                    mCurrentTask = null;
                }

                Iterator<AbstractBLETask> it = mQueue.iterator();
                while (it.hasNext()) {
                    AbstractBLETask task = it.next();
                    if (task.getTaskId() == taskId) {
                        it.remove();
                        break;
                    }
                }
            } else {
                if (hasMessages(MESSAGE_TASK_CLEAR)) {
                    // clear all task
                    cancelAllQueue();
                }

                // processing for add

                // add task
                if (MESSAGE_TASK_ADD == msg.what) {
                    AbstractBLETask task = (AbstractBLETask) msg.obj;
                    if (hasMessages(MESSAGE_TASK_CANCEL, task.getTaskId())) {
                        removeMessages(MESSAGE_TASK_CANCEL, task.getTaskId());
                    } else if (hasMessages(MESSAGE_TASK_CLEAR)) {
                        task.cancel();
                    } else {
                        // add to task queue
                        mQueue.add(task);
                    }
                }

                // have current task, process task
                if (mCurrentTask != null) {
                    if (hasMessages(MESSAGE_TASK_CANCEL, mCurrentTask.getTaskId())) {
                        mCurrentTask.cancel();
                        removeMessages(MESSAGE_TASK_CANCEL, mCurrentTask.getTaskId());
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

                // no current task and task queue is not empty
                if (mCurrentTask == null && !mQueue.isEmpty()) {
                    // set current task
                    do {
                        AbstractBLETask task = mQueue.poll();
                        if (task != null) {
                            if (hasMessages(MESSAGE_TASK_CANCEL, task.getTaskId())) {
                                task.cancel();
                                removeMessages(MESSAGE_TASK_CANCEL, task.getTaskId());
                            } else if (mWaitForBusy < SystemClock.elapsedRealtime() || task instanceof DisconnectTask) {
                                // Disconnect task ignore busy status

                                mCurrentTask = task;

                                // send current task's first message
                                Message initialMessage = task.createInitialMessage();
                                initialMessage.what = MESSAGE_TASK_PROCESSING;
                                sendMessage(initialMessage);
                                break;
                            } else {
                                // busy status

                                // return to queue
                                mQueue.push(task);
                                break;
                            }
                        }
                    } while (!mQueue.isEmpty());
                }
            }
        } catch (Exception e) {
            BLELogUtils.stackLog(e);
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
    public void sendProcessingMessage(Message message) {
        sendProcessingMessage(message, 0);
    }

    /**
     * send processing message
     *
     * @param message target {@link Message}
     * @param delay   millis
     */
    public void sendProcessingMessage(Message message, long delay) {
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
     * @param task     {@link AbstractBLETask} instance
     * @param delay    millis
     */
    public void addTaskDelayed(AbstractBLETask task, long delay) {
        Message message = new Message();
        message.what = MESSAGE_TASK_ADD;
        message.obj = task;
        sendMessageDelayed(message, delay);
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
    public void cancelTask(long taskId) {
        Message message = new Message();
        Bundle bundle = new Bundle();
        bundle.putLong(KEY_TASK_ID, taskId);
        message.setData(bundle);
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
    }

}
