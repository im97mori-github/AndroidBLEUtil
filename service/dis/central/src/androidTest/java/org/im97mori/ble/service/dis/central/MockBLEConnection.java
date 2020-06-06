package org.im97mori.ble.service.dis.central;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.test.core.app.ApplicationProvider;

import org.im97mori.ble.BLECallback;
import org.im97mori.ble.BLEConnection;

class MockBLEConnection extends BLEConnection {

    public static final BluetoothDevice MOCK_DEVICE = BluetoothAdapter.getDefaultAdapter().getRemoteDevice("00:11:22:33:AA:BB");

    public MockBLEConnection() {
        super(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null);
        this.start();
    }

}
