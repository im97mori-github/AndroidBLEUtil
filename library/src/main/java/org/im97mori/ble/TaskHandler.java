package org.im97mori.ble;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Parcelable;
import android.util.Pair;

import org.im97mori.ble.task.AbstractBLETask;

import java.util.LinkedList;
import java.util.Queue;
import java.util.UUID;

@SuppressWarnings({"WeakerAccess", "JavadocReference"})
public class TaskHandler extends Handler {

    /**
     * MESSAGE:QUIT
     */
    private static final int MESSAGE_QUIT = 0;

    /**
     * MESSAGE:TASK_ADD
     */
    private static final int MESSAGE_TASK_ADD = 1;

    /**
     * MESSAGE:TASK_PROCESSING
     */
    private static final int MESSAGE_TASK_PROCESSING = 2;

    /**
     * MESSAGE:TASK_CLEAR
     */
    private static final int MESSAGE_TASK_CLEAR = 3;

    /**
     * current task
     */
    private AbstractBLETask mCurrentTask;

    /**
     * task queue
     */
    private Queue<Pair<AbstractBLETask, Message>> mQueue = new LinkedList<>();

    /**
     * {@inheritDoc}
     */
    public TaskHandler(Looper looper) {
        super(looper);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void handleMessage(Message msg) {
        try {
            // current message is quit, or message queue has quit
            if (MESSAGE_QUIT == msg.what || hasMessages(MESSAGE_QUIT)) {
                // quit
                getLooper().quit();
            } else if (MESSAGE_TASK_CLEAR == msg.what || hasMessages(MESSAGE_TASK_CLEAR)) {
                // current message is clear, or message queue has clear

                // clear all task
                mCurrentTask = null;
                mQueue.clear();

                // remove all clear/processing from message queue
                removeMessages(MESSAGE_TASK_CLEAR);
                removeMessages(MESSAGE_TASK_PROCESSING);
            } else {
                // processing for add

                // add
                if (MESSAGE_TASK_ADD == msg.what) {
                    // add to task queue
                    //noinspection unchecked
                    mQueue.add((Pair<AbstractBLETask, Message>) msg.obj);
                }

                // have current task, process task
                if (mCurrentTask != null && mCurrentTask.doProcess(msg)) {
                    // task finished

                    // clear current task
                    mCurrentTask = null;
                }

                // no current task, task queue has task
                if (mCurrentTask == null && !mQueue.isEmpty()) {
                    // set current task
                    Pair<AbstractBLETask, Message> pair = mQueue.poll();
                    mCurrentTask = pair.first;

                    // send current task's first message
                    sendMessage(pair.second);
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
     * send processing message
     *
     * @param message target {@link Message}
     * @see AbstractBLETask#createReadCharacteristicMessage(UUID, Object)
     * @see AbstractBLETask#createReadCharacteristicFinishedMessage(UUID, Parcelable)
     * @see ConnectTask#createConnectMessage(Object)
     * @see DisconnectTask#createDisconnectMessage(Object)
     * @see NotificationSettingTask#createWriteDescriptorMessage(UUID, Object)
     * @see NotificationSettingTask#createWriteDescriptorFinishedMessage(UUID)
     * @see WriteCharacteristicTask#createWriteCharacteristicMessage(UUID, Object)
     */
    public void sendProcessingMessage(Message message) {
        message.what = MESSAGE_TASK_PROCESSING;
        sendMessage(message);
    }

    /**
     * send timeout message
     *
     * @param message target {@link Message}
     * @param timeout millis
     * @see AbstractBLETask#createTimeoutMessage(UUID, Object)
     */
    public void sendTimeoutMessage(Message message, long timeout) {
        message.what = MESSAGE_TASK_PROCESSING;
        sendMessageDelayed(message, timeout);
    }

    /**
     * add task and task's first message to task queue
     *
     * @param task     {@link AbstractBLETask} instance
     * @param original first {@link Message} instance
     */
    public void addTask(AbstractBLETask task, Message original) {
        original.what = MESSAGE_TASK_PROCESSING;
        Pair pair = Pair.create(task, original);

        Message message = new Message();
        message.what = MESSAGE_TASK_ADD;
        message.obj = pair;
        sendMessage(message);
    }

    /**
     * clear task queue
     */
    public void clearTask() {
        sendEmptyMessage(MESSAGE_TASK_CLEAR);
    }

}
