package org.im97mori.ble.task;

import android.os.Message;

import androidx.annotation.NonNull;

import org.im97mori.ble.BLEConnection;

/**
 * Service Changed task
 * <p>
 * for central role
 */
public class ServiceChangedTask extends AbstractBLETask {

    /**
     * task target {@link BLEConnection} instance
     */
    private final BLEConnection mBLEConnection;

    /**
     * @param bleConnection            task target {@link BLEConnection} instance
     */
    public ServiceChangedTask(@NonNull BLEConnection bleConnection) {
        mBLEConnection = bleConnection;
    }

    /**
     * {@inheritDoc}
     */
    @NonNull
    @Override
    public Message createInitialMessage() {
        return new Message();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean doProcess(@NonNull Message message) {
        mBLEConnection.getBLECallback().onServiceChanged(mBLEConnection.getBluetoothDevice());
        return true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isBusy() {
        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void cancel() {
        // do nothing
    }

}
