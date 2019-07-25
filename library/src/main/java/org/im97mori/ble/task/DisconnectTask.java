package org.im97mori.ble.task;

import android.bluetooth.BluetoothGatt;
import android.os.Bundle;
import android.os.Message;

import org.im97mori.ble.BLEConnection;

/**
 * Disconnect from {@link BluetoothGatt} task
 */
@SuppressWarnings("JavadocReference")
public class DisconnectTask extends AbstractBLETask {

    /**
     * create disconnect message
     *
     * @param obj instance for {@link android.os.Handler#removeCallbacksAndMessages(Object)}
     * @return create disconnect {@link Message} instance
     */
    public static Message createDisconnectMessage(Object obj) {
        Bundle bundle = new Bundle();
        bundle.putInt(KEY_NEXT_PROGRESS, PROGRESS_DISCONNECT);
        Message message = new Message();
        message.setData(bundle);
        message.obj = obj;
        return message;
    }

    /**
     * task target {@link BLEConnection} instance
     */
    private final BLEConnection mBLEConnection;

    /**
     * task target {@link BluetoothGatt} instance
     */
    private final BluetoothGatt mBluetoothGatt;

    /**
     * @param bleConnection task target {@link BLEConnection} instance
     * @param bluetoothGatt task target {@link BluetoothGatt} instance
     */
    public DisconnectTask(BLEConnection bleConnection, BluetoothGatt bluetoothGatt) {
        mBLEConnection = bleConnection;
        mBluetoothGatt = bluetoothGatt;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean doProcess(Message message) {
        // if not connected, finish task
        if (!mBLEConnection.isConnected()) {
            mCurrentProgress = PROGRESS_FINISHED;
        } else {
            Bundle bundle = message.getData();
            int nextProgress = bundle.getInt(KEY_NEXT_PROGRESS);

            // current:init, next:disconnect
            if (this == message.obj && PROGRESS_INIT == mCurrentProgress) {
                if (PROGRESS_DISCONNECT == nextProgress) {
                    // target is newest one
                    if (mBLEConnection.isCurrentConnectionTarget(mBluetoothGatt)) {
                        mBluetoothGatt.disconnect();
                        mBluetoothGatt.close();
                        mBLEConnection.onDisconnected(mBluetoothGatt);
                    }
                    mCurrentProgress = nextProgress;
                }
            }
        }

        return PROGRESS_FINISHED == mCurrentProgress || PROGRESS_DISCONNECT == mCurrentProgress;
    }
}
