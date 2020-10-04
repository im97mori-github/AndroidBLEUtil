package org.im97mori.ble.service.uds.peripheral;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class RegisteredUserIndicationDataTest {

    @Test
    public void test_constructor_00001() {
        int requestId = 1;
        int offset = 2;
        byte[] returnValue = new byte[]{3};
        long timeout = 4;
        int count = 5;

        RegisteredUserIndicationData result1 = new RegisteredUserIndicationData(requestId
                , offset
                , returnValue
                , timeout
                , count);

        assertEquals(requestId, result1.requestId);
        assertEquals(offset, result1.offset);
        assertArrayEquals(returnValue, result1.returnValue);
        assertEquals(timeout, result1.timeout);
        assertEquals(count, result1.count);
    }

}
