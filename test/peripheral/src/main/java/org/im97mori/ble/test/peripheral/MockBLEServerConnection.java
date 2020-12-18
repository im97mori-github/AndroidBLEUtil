package org.im97mori.ble.test.peripheral;

import androidx.test.core.app.ApplicationProvider;

import org.im97mori.ble.BLEServerConnection;

public class MockBLEServerConnection extends BLEServerConnection {

    public MockBLEServerConnection() {
        super(ApplicationProvider.getApplicationContext());
    }
}
