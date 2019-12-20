package org.im97mori.ble.characteristic;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class UserIndexUtilsTest {

    @Test
    public void test_isUserIdUnknownUser001() {
        assertTrue(UserIndexUtils.isUserIdUnknownUser(UserIndexUtils.USER_ID_UNKNOWN_USER));
    }

    @Test
    public void test_isUserIdUnknownUser002() {
        assertFalse(UserIndexUtils.isUserIdUnknownUser(0));
    }

    @Test
    public void test_isUserIdUnknownUser003() {
        assertFalse(UserIndexUtils.isUserIdUnknownUser(254));
    }

}
