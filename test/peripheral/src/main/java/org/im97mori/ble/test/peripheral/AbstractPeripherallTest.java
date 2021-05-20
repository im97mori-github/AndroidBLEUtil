package org.im97mori.ble.test.peripheral;

import org.junit.After;
import org.junit.Before;

public abstract class AbstractPeripherallTest {

    protected MockBLEServerConnection MOCK_BLE_SERVER_CONNECTION;

    @Before
    public void setup() {
        MOCK_BLE_SERVER_CONNECTION = new MockBLEServerConnection();
    }

    @After
    public void tearDown() {
        if (MOCK_BLE_SERVER_CONNECTION != null) {
            MOCK_BLE_SERVER_CONNECTION.quit();
            MOCK_BLE_SERVER_CONNECTION = null;
        }
    }

}
