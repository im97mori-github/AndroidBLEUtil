package org.im97mori.ble.profile.central;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;

import androidx.test.core.app.ApplicationProvider;

import org.im97mori.ble.BLEConnection;

public class MockBLEConnection extends BLEConnection {
    public static final BluetoothDevice MOCK_DEVICE = BluetoothAdapter.getDefaultAdapter().getRemoteDevice("00:11:22:33:AA:BB");

    public MockBLEConnection() {
        super(ApplicationProvider.getApplicationContext(), MOCK_DEVICE, null);
        this.start();
    }
}
