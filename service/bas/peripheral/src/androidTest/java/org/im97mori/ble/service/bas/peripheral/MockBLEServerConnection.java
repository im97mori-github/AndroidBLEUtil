package org.im97mori.ble.service.bas.peripheral;

import androidx.test.core.app.ApplicationProvider;

import org.im97mori.ble.BLEServerConnection;

class MockBLEServerConnection extends BLEServerConnection {

    public MockBLEServerConnection() {
        super(ApplicationProvider.getApplicationContext());
    }
}
