package org.im97mori.ble;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;

import androidx.test.core.app.ApplicationProvider;

public class MockBLEServerConnection extends BLEServerConnection {

    public static final BluetoothDevice MOCK_DEVICE = BluetoothAdapter.getDefaultAdapter().getRemoteDevice("00:11:22:33:AA:BB");

    public MockBLEServerConnection() {
        super(ApplicationProvider.getApplicationContext());
    }

}
