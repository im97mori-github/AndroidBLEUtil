package org.im97mori.ble.service.central;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.os.Bundle;

import androidx.annotation.Nullable;

import org.im97mori.ble.BLECallback;
import org.im97mori.ble.test.central.MockBLEConnection;

class CentralMockBLEConnection extends MockBLEConnection {

    public static final BluetoothDevice MOCK_DEVICE = BluetoothAdapter.getDefaultAdapter().getRemoteDevice("00:11:22:33:AA:BB");

    private boolean mIsConnected;

    @Override
    public boolean isConnected() {
        return mIsConnected;
    }

    public void setIsConnected(boolean isConnected) {
        this.mIsConnected = isConnected;
    }


    @Nullable
    @Override
    public Integer createDiscoverServiceTask(long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
        return mIsConnected ? 1 : null;
    }

    @Nullable
    @Override
    public synchronized Integer quit(@Nullable Bundle argument, @Nullable BLECallback bleCallback) {
        return mIsConnected ? 1 : null;
    }
}
