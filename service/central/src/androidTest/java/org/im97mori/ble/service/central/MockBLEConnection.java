package org.im97mori.ble.service.central;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.test.core.app.ApplicationProvider;

import org.im97mori.ble.BLECallback;
import org.im97mori.ble.BLEConnection;

class MockBLEConnection extends BLEConnection {

    public static final BluetoothDevice MOCK_DEVICE = BluetoothAdapter.getDefaultAdapter().getRemoteDevice("00:11:22:33:AA:BB");

    private boolean mIsConnected;

    public MockBLEConnection() {
        super(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null);
        this.start();
    }

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
