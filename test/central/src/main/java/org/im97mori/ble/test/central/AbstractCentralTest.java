package org.im97mori.ble.test.central;

import org.junit.After;
import org.junit.Before;

public abstract class AbstractCentralTest {

    protected MockBLEConnection MOCK_BLE_CONNECTION;

    @Before
    public void setup() {
        MOCK_BLE_CONNECTION = new MockBLEConnection();
    }

    @After
    public void tearDown() {
        if (MOCK_BLE_CONNECTION != null) {
            MOCK_BLE_CONNECTION.quitTaskHandler();
            MOCK_BLE_CONNECTION = null;
        }
    }

}
